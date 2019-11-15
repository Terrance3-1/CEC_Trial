package com.amazon.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.Pages.CartPage;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.LoginPage;
import com.amazon.Pages.ProdPage;
import com.amazon.Pages.ProdSearch;
import com.amazon.Pages.SelectAddrsPg;

import Helper.BrowserFactory;
 
public class AmazonPurchase {
	
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
		ProdSearch prod_search= PageFactory.initElements(driver, ProdSearch.class);
		ProdPage add2cart= PageFactory.initElements(driver, ProdPage.class);
		CartPage cart_page= PageFactory.initElements(driver, CartPage.class);
		SelectAddrsPg select_add= PageFactory.initElements(driver, SelectAddrsPg.class);
		//.class will return the page object of the particular page
		
		
		//call the method
		home_page.navigateToLoginPage();
		login_page.login_amazon("8105435474", "Terrance");
		home_page.navigateToProdSearch("Fastrack watches for Boys");
		prod_search.navigateToProdPage();
		add2cart.Add_2_cart();
		home_page.navigateToCartPage();
		cart_page.navigateToSelectAddrsPg();
		select_add.navigateToPaymentPg();
		
		
		}
	
	@AfterTest
	public void aftertest(){
		driver.close();

    }
	
	
	
	}
