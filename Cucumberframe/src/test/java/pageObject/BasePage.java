package pageObject;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	  WebDriver driver; public BasePage(WebDriver driver) { 
		  this.driver =driver;
	  PageFactory.initElements(driver, this);
	  
	  
	  }
	 
	/*
	 * public static WebDriver driver;
	 * 
	 * public static void launchBrowser() { driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * driver.get("https://app.engagebay.com"); }
	 * 
	 * public static void closeBrowser() { driver.quit(); }
	 */
}
