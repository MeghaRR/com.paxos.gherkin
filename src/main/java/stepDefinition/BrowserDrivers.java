package stepDefinition;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//-Dbrowser.name=firefox 
public class BrowserDrivers {

	    public static WebDriver createWebDriver() {
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
