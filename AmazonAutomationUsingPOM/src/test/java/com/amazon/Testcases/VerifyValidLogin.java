package com.amazon.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.Pages.HomePage;
import com.amazon.Pages.LoginPage;

import Helper.BrowserFactory;
 
public class VerifyValidLogin {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup(){

		// This will launch browser and specific url
			driver=BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");

    }
	
	@Test
	public void checkValidUser() {
		
		//created page object using page factory
		HomePage home_page= PageFactory.initElements(driver, HomePage.class);
		LoginPage login_page= PageFactory.initElements(driver, LoginPage.class);
		//.class will return the page object of the particular page
		
		
		//call the method
		home_page.navigateToLoginPage();
		login_page.login_amazon("8105435474", "Terrance");
		
		}
	
	@AfterTest
	public void aftertest(){
		driver.close();

    }
	
	
	
	}
