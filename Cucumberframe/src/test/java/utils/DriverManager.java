package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); 

    public static WebDriver getDriver(String browserName) {
        
        if (driver.get() == null) {
            
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver()); // Use set() for ThreadLocal
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver()); // Added Edge setup
            } else {
                System.out.println("Browser not supported: " + browserName + ". Defaulting to Chrome.");
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }

            driver.get().manage().deleteAllCookies();
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        }
        
        return driver.get();
    }
    
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); 
        }
    }
}
