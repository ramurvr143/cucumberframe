package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Loginpage;

public class Loginstep {
	WebDriver driver;
	Loginpage login;
/*
@Given("Consider user is in login page")
public void consider_user_is_in_login_page() {
	System.out.println("user open login page");
	 driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.saucedemo.com/v1/");
}

//@When("User enter user name and password")
//public void user_enter_user_name_and_password() 
@When("User enter {string} and {string}")
public void user_enter_and(String username, String password){
  System.out.println("User enter user name and password");
  driver.findElement(By.id("user-name")).sendKeys(username);
  driver.findElement(By.id("password")).sendKeys(password);
	
}

@And("Click on login button")
public void click_on_login_button() {
	System.out.println("click the login button");
   driver.findElement(By.id("login-button")).click();
}

@Then("User is navigate to home page")
public void user_is_navigate_to_home_page() {
    String text = driver.findElement(By.className("product_label")).getText();
    String etext ="Products";
    if(text.equals(etext)) {
    	 System.out.println("user is navigated to home page");
    	
    }
}

@And("Close browser")
public void close_browser() {
	System.out.println("close the browser");
    driver.close();
}
*/
	@Given("Consider user is in login page")
	public void consider_user_is_in_login_page() {
		System.out.println("user open login page");
		 driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/");
		login = new Loginpage(driver);
	}

	//@When("User enter user name and password")
	//public void user_enter_user_name_and_password() 
	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password){
	  System.out.println("User enter user name and password");
	 
	  login.enterusername(username);
	  login.enterpassword(password);
		
	}

	@And("Click on login button")
	public void click_on_login_button() {
		System.out.println("click the login button");
		login.clicklogin();
	}

	@Then("User is navigate to home page")
	public void user_is_navigate_to_home_page() {
		 boolean visual = login.textexist();
	        Assert.assertTrue(visual);
	}

	@And("Close browser")
	public void close_browser() {
		System.out.println("close the browser");
	    driver.close();
	}


}
