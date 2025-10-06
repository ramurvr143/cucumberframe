package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	WebDriver driver;
	By visual_txt = By.className("product_label");
	By txt_username	= By.id("user-name");
	By txt_password = By.id("password");
	By btn_login = By.id("login-button");
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		
	}
	public void enterusername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	public void enterpassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	public void clicklogin() {
		driver.findElement(btn_login).click();
		
	}
	public boolean textexist() {
        return driver.findElement(visual_txt).isDisplayed();
    }

    public String getVisualText() {
        return driver.findElement(visual_txt).getText();
    }
	

	
	
	
	
}
