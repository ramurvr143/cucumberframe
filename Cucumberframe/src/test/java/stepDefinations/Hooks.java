package stepDefinations;



import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setup() {
    	driver =  DriverManager.getDriver("chrome");
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
