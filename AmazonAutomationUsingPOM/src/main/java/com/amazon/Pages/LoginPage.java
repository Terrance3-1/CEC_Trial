package com.amazon.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
		wait = new WebDriverWait(driver, 5);
		}
	
	@FindBy(name="email")
	@CacheLookup WebElement username;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"continue\"]")
	@CacheLookup WebElement continue_button;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup WebElement password;
	
	@FindBy(how=How.ID,using="createAccountSubmit")
	@CacheLookup WebElement create_Account_Submit;
	
	@FindBy(how=How.ID,using="signInSubmit")
	@CacheLookup WebElement sign_In_Submit; //CacheLoopup wont  check the webelement each time but will check in the memory and process the webelement
	
	public void login_amazon(String uid, String pass){
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(uid);
		wait.until(ExpectedConditions.visibilityOf(continue_button)).click();
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOf(sign_In_Submit)).click();
		
	}
	
}