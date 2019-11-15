package com.amazon.Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProdPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProdPage(WebDriver ldriver) {
		this.driver=ldriver;
		wait = new WebDriverWait(driver, 5);
		}
	
	@FindBy(how=How.XPATH,using=".//input[@id='add-to-cart-button']")
	
	WebElement Add_Cart;

	public void Add_2_cart() {
		String parent= driver.getWindowHandle(); //to know what the parent window is 
		System.out.println("Parent window id is "+parent);
		Set<String> allWindows= driver.getWindowHandles(); //Once the child tab/window is opened it will get all of the tabs/window
		int count=allWindows.size(); //checks the number of tabs and windows
		System.out.println("Total windows "+count); //Prints the number of tabs/windows
		for(String child:allWindows) {  //adding for loop to check each window and switch between the tab
			
			if(!parent.equalsIgnoreCase(child)) { //checks the values through the id's and switches the window
				driver.switchTo().window(child);  //switches the window/tab
				
			}
		}
		
		System.out.println("PRODUCT_PAGE: Clicking on [ADD_TO_CART] button. \n");
		wait.until(ExpectedConditions.visibilityOf(Add_Cart)).click();
		driver.close();
		driver.switchTo().window(parent);
		}

}
