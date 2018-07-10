package stepDefinition;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//this class will select appropriate webdrivers for cross browser testing
public class BrowserDrivers {

	    public static WebDriver createWebDriver() {
		    //selecting browser on which the test should run
	        String webdriver = System.getProperty("browser", "chrome");
	        switch(webdriver) {
	            case "firefox":
	                return new FirefoxDriver();
	            case "chrome":
	                return new ChromeDriver();
	            default:
	                throw new RuntimeException("Unsupported webdriver: " + webdriver);
	        }
	    }
	
}
