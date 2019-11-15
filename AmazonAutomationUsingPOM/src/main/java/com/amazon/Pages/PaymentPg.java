package com.amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPg {
	WebDriver driver;
	WebDriverWait wait;
	
	public PaymentPg(WebDriver ldriver) {
		this.driver=ldriver;
		wait = new WebDriverWait(driver, 5);
		}
	
	@FindBy(how=How.XPATH,using="//input[@id='pp-Ep-112']")
	@CacheLookup WebElement PayOnDlvr;
	
	@FindBy(how=How.XPATH,using="//span[@id='pp-Ep-114']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
	@CacheLookup WebElement Continue;
	
	public void PlaceOrder(){
		
		wait.until(ExpectedConditions.visibilityOf(PayOnDlvr)).click();
		wait.until(ExpectedConditions.visibilityOf(Continue)).click();
		
	}
}
