package com.amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver ldriver) {
		this.driver=ldriver;
		wait = new WebDriverWait(driver, 5);
		}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"nav-link-accountList\"]")
	@CacheLookup WebElement Account;
	
	@FindBy(how=How.ID,using="twotabsearchtextbox")
	@CacheLookup WebElement Search_prod;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	@CacheLookup WebElement Search_butn;
	
	@FindBy(how=How.XPATH,using="//a[@id='nav-cart']")
	@CacheLookup WebElement Cart;

	
	public LoginPage navigateToLoginPage(){
		System.out.println("HOME_PAGE: Selecting [YOUR_ACCOUNT] in navigation bar.");
		wait.until(ExpectedConditions.visibilityOf(Account)).click();
		System.out.println("HOME_PAGE: Navigating to the SIGNIN_PAGE.\n");
		return new LoginPage(driver);
		}
	
	
	public ProdSearch navigateToProdSearch(String prod_name){
		wait.until(ExpectedConditions.visibilityOf(Search_prod)).sendKeys(prod_name);
		System.out.println("HOME_PAGE: Searching for the required product"+ prod_name);
		wait.until(ExpectedConditions.visibilityOf(Search_butn)).click();
		System.out.println("HOME_PAGE: Navigating to the respective product page");
		return new ProdSearch(driver);
		}
	
	public CartPage navigateToCartPage(){
		wait.until(ExpectedConditions.visibilityOf(Cart)).click();
		System.out.println("HOME_PAGE: Navigating to the CART PAGE");
		return new CartPage(driver);
		}
	
	
	}
