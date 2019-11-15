package com.amazon.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.Pages.HomePage;
import com.amazon.Pages.ProdPage;
import com.amazon.Pages.ProdSearch;

import Helper.BrowserFactory;

public class VerifyAd2Cart {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup(){

		// This will launch browser and specific url
			driver=BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");

    }
	
	@Test
	public void checkproductsearch() {
		
		//created page object using page factory
		HomePage home_page= PageFactory.initElements(driver, HomePage.class);
		ProdSearch prod_search= PageFactory.initElements(driver, ProdSearch.class);
		ProdPage add2cart= PageFactory.initElements(driver, ProdPage.class);
		//.class will return the page object of the particular page
		
		
		//call the method
		home_page.navigateToProdSearch("Fastrack watches for Boys");
		prod_search.navigateToProdPage();
		add2cart.Add_2_cart();
		
		}
	
	@AfterTest
	public void aftertest(){
		driver.close();

    }
	
	
	}