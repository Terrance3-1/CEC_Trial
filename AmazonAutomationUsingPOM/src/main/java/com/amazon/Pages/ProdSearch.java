package com.amazon.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdSearch {

		WebDriver driver;
		WebDriverWait wait;
		private FileInputStream stream;
		private String RepositoryFile;
		private Properties propertyFile = new Properties();

		private ProdSearch parser;

		
		
		public ProdSearch(WebDriver ldriver) {
			this.driver=ldriver;
			wait = new WebDriverWait(driver, 5);
			}
		
		public ProdSearch(String fileName) throws IOException
		 {
		 this.RepositoryFile = fileName;
		 stream = new FileInputStream(RepositoryFile);
		 propertyFile.load(stream);
		 }
		
		public By getbjectLocator(String locatorName)
		 {
		 String locatorProperty = propertyFile.getProperty(locatorName);
		 System.out.println(locatorProperty.toString());
		 String locatorType = locatorProperty.split(":")[0];
		 System.out.println(locatorType);
		 String locatorValue = locatorProperty.split(":")[1];
	
		 
		 By locator = null;
		 
		 switch(locatorType)
		 {
		 case "Id":
		 locator = By.id(locatorValue);
		 break;
		 case "Name":
		 locator = By.name(locatorValue);
		 break;
		 case "CssSelector":
		 locator = By.cssSelector(locatorValue);
		 break;
		 case "LinkText":
		 locator = By.linkText(locatorValue);
		 break;
		 case "PartialLinkText":
		 locator = By.partialLinkText(locatorValue);
		 break;
		 case "TagName":
		 locator = By.tagName(locatorValue);
		 break;
		 case "Xpath":
		 locator = By.xpath(locatorValue);
		 break;
		 }
		 return locator;
		 }
		
		//We use @FindBy annotations with variable of type WebElement at class level. 
		//It is not possible to call any method at class level i.e. outside any method in java. 
		//Also you can not create any method which can return you webelement declaration with @FindBy annotation.

		
		public ProdPage navigateToProdPage() {
			
				try {
					parser = new ProdSearch("C://Users//terranceaa//Tools//Eclipse//Workspace2//AmazonAutomationUsingPOM//src//main//resources//products//prodDetails.properties");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			WebElement prodimg = driver.findElement(parser.getbjectLocator("prod_img"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", prodimg);
			driver.findElement(parser.getbjectLocator("select_prod")).click();
			return new ProdPage(driver);
			
			}
		}


