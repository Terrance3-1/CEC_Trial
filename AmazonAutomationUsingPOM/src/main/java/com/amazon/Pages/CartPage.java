package com.amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver ldriver) {
		this.driver=ldriver;
		wait = new WebDriverWait(driver, 5);
		}
	
	@FindBy(name="proceedToCheckout")
	@CacheLookup WebElement Procd2Chkout;
	
	public SelectAddrsPg navigateToSelectAddrsPg(){
		wait.until(ExpectedConditions.visibilityOf(Procd2Chkout)).click();
		System.out.println("CART_PAGE: Proceeding to buy and Navigating to select address page");
		return new SelectAddrsPg(driver);
		}

}
