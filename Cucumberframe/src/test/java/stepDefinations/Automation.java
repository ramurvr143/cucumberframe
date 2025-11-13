package stepDefinations;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Automationpage;

public class Automation {
WebDriver driver;
Automationpage ap;

public Automation() {
	this.driver = Hooks.getDriver();
	
}
@Given("user open URL")
public void user_open_url() {

	ap= new Automationpage(driver);
	System.out.println("user open login page");
    driver.get("https://testautomationpractice.blogspot.com/");

}

@Then("scroll range is updated")
public void scroll_range_is_updated() throws InterruptedException {
  ap.scroll();;
}



}
