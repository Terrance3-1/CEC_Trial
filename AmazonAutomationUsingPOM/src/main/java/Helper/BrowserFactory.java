package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestException;

public class BrowserFactory {  ///Browser Factory accepts the browser name in the parameter and 
	                              //based on the parameter it will trigger the respective browser
	
	static WebDriver driver;
		
	public static WebDriver startBrowser(String browserName, String url) { //browserName is a parameter
		
		if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.chrome.driver","D:\\Tools2\\Drivers\\Gecko Driver\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","D:\\Tools2\\Drivers\\Chrome Driver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		try {
			driver.navigate().to(url);
			} 
		catch (Exception e) {
			System.out.println("FAILURE: URL did not load: " + url);
			throw new TestException("URL did not load");  
	     } 
		
		return driver;
		
	}
	
	
}
