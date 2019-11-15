package com.amazon.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.Pages.HomePage;
import com.amazon.Pages.ProdSearch;

import Helper.BrowserFactory;

public class VerifyProdSearch {
	
	@Test
	public void checkproductsearch() {
		
		// This will launch browser and specific url
		WebDriver driver=BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
	
		//created page object using page factory
		HomePage home_page= PageFactory.initElements(driver, HomePage.class);
		ProdSearch prod_search= PageFactory.initElements(driver, ProdSearch.class);
		//.class will return the page object of the particular page
		
		
		//call the method
		home_page.navigateToProdSearch("Fastrack watches for Boys");
		
		prod_search.navigateToProdPage();
		
		}
	
	
	}


