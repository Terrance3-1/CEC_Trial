package com.amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectAddrsPg {
	WebDriver driver;
	WebDriverWait wait;
	
	public SelectAddrsPg(WebDriver ldriver) {
		this.driver=ldriver;
		wait = new WebDriverWait(driver, 5);
		}
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Most recently used')]")
	@CacheLookup WebElement RecentAdd;
	
	@FindBy(how=How.XPATH,using="//body/div[contains(@class,'checkout checkout-as checkout-as-desktop')]/div[contains(@class,'a-container')]/div[contains(@class,'clearfix')]/form[1]/div[1]/div[1]/div[2]/span[1]/a[1]")
	@CacheLookup WebElement Dlvr2Add;
	
	public PaymentPg navigateToPaymentPg(){
		wait.until(ExpectedConditions.visibilityOf(Dlvr2Add)).click();
		System.out.println("SELECT ADDRESS PAGE: Navigating to Payment Page");
		return new PaymentPg(driver);
		}
	

}
