package pageObject;

import java.awt.Scrollbar;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automationpage extends BasePage {
	
	public  Automationpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "slider-range")
	WebElement slidebar;
	@FindBy(xpath = "(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]")
	WebElement minvalue;
	@FindBy(xpath = "(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]")
	WebElement maxvalue;
	@FindBy(id = "amount")
	WebElement amount;
	
	/*
	 * public void minvalue() throws InterruptedException { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOf(minvalue)); Actions action = new
	 * Actions(driver); action.clickAndHold(maxvalue) .moveByOffset(20, 0)
	 * .release() .perform(); Thread.sleep(6000); } public void maxvalue() throws
	 * InterruptedException { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOf(maxvalue)); Actions action = new
	 * Actions(driver); action.clickAndHold(maxvalue) .moveByOffset(-20, 0)
	 * .release() .perform(); Thread.sleep(6000);
	 * 
	 * } public void Amount() { String rangeamount = amount.getAttribute("value");
	 * System.out.println(rangeamount); }
	 */

	public void scroll() throws InterruptedException {
		// Wait for elements to be visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(slidebar));
	    wait.until(ExpectedConditions.visibilityOf(minvalue));
	    wait.until(ExpectedConditions.visibilityOf(maxvalue));

	    // Get slider width
	    int sliderWidth = slidebar.getSize().width;

	    // Example range values (you can parameterize them)
	    int minValue = 0;//slider minimum range
	    int maxValue = 500;//slider maximum range
	    int desiredMin = 100;//expected range
	    int desiredMax = 450;

	    // Calculate movement in pixels
	    int moveMin = (sliderWidth * (desiredMin - minValue)) / (maxValue - minValue);
	    int moveMax = (sliderWidth * (desiredMax - maxValue)) / (maxValue - minValue); // negative value to move left

	    Actions action = new Actions(driver);

	    // Move minimum handle to right
	    action.clickAndHold(minvalue) 
	    .moveByOffset(moveMin, 0)
		.release() 
		.perform(); 
	    //action.dragAndDropBy(minvalue, moveMin, 0).perform();
	    WebElement freshMaxHandle = wait.until(
	            ExpectedConditions.presenceOfElementLocated(
	                By.xpath("(//span[contains(@class,'ui-slider-handle')])[2]") )
	    	    );
	    Thread.sleep(2000);

	    // Move maximum handle to left
	    action.clickAndHold(freshMaxHandle) 
	    .moveByOffset(moveMax, 0)
		.release() 
		.perform(); 
	    //action.dragAndDropBy(maxvalue, moveMax, 0).perform();
	    Thread.sleep(2000);

	    // Print range value (optional)
	    System.out.println("Selected Range: " + amount.getAttribute("value"));
	}
		
	}

