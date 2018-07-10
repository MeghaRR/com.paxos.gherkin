package stepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaxosStepDefinition {

	WebDriver driver;
	String searchTerm="Paxos";
	BrowserDrivers bd;
	
	@Given("^I am on Google Home page$")
	public void i_am_on_Google_search_page() throws Throwable {
	    driver=BrowserDrivers.createWebDriver();
	    driver.manage().window();
	    driver.get("http://www.google.com");
	}

	@When("^I search for Paxos Bankchain$")
	public void i_search_for_Paxos_Bankchain() throws Throwable {
	    WebElement element=driver.findElement(By.xpath("//*[@id='lst-ib']"));
		//WebElement element=driver.findElement(By.name("q"));
	    element.sendKeys("Paxos Bankchain");
	    element.submit();
	   
	}

	@Then("^I get search results for Paxos Bankchain$")
	public void i_get_search_results_for_Paxos_Bankchain() throws Throwable {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
		verifyURLhasPaxos();
	    verifyResultsHasPaxos();
	    driver.close();
	}

	private void verifyResultsHasPaxos() {

		List<WebElement> resultEntries = driver.findElements(By.cssSelector("div.s"));
        for(WebElement element : resultEntries){
        	
            String href = element.getText();
            assertTrue(href.contains("Paxos") || href.contains("bankchain"));
           
        }
	}

	private void verifyURLhasPaxos() {
		String url=driver.getCurrentUrl();
		assertTrue(url.contains("Paxos"));
	}
	

}
