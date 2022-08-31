package iOSCarrierClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class CardsTabUniversal {
  
	Logs iOSLogs = new Logs();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	Sleep appSleep = new Sleep();
	Wait appWait = new Wait();
		
	AppStringsiOS iOSText = new AppStringsiOS();
	  static AppiumDriver<WebElement> driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		// static WebDriver driverWeb;
	
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		public CardsTabUniversal CardsTabUniversal() throws Exception {
			iOSLogs.setupTest("Cards Tab testing");
			//find Cards Tab and click it.
			

			appWait.CardsTabOrSleep3000(); //need to add waits
			WebElement CardsTab = elements.CardsTab();		
			if (CardsTab.isEnabled()) { 
				CardsTab.click();
			iOSLogs.CapturedLogs(pass, "Cards Tab is opened.");
			//driver: 
			elements.DriverSelection().click();
			
			//driver search: 
			WebElement DriverSearch = elements.DriverSearch();
			if (DriverSearch.isDisplayed()) {
				DriverSearch.sendKeys("John");

				elements.PhysicalSearchButton().click();
				
				Actions actionReturn = new Actions(Capabilities.driver);

				actionReturn.sendKeys(Keys.RETURN).build().perform();
				iOSLogs.CapturedLogs(pass, "Driver name entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Driver text box was not found");
			}
			
			

			if (elements.DriverSearchResult().isDisplayed()) {
				//DriverSearchResult.click();

				iOSLogs.CapturedLogs(pass, "Driver search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Driver search result was not found");
			}
			
			
			//unit: 
			elements.UnitSelection().click();
			//element.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			
			//unit search:		
			WebElement UnitSearch = elements.UnitSearch();
			if (UnitSearch.isDisplayed()) {
				UnitSearch.sendKeys("1234");

				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(pass, "Unit number entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Unit text box was not found");
			}
			
			
			if (elements.UnitSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				iOSLogs.CapturedLogs(pass, "Unit search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Unit search result was not found");
			}
			
			
			//card: 
			elements.CardSelection().click();
			//element.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			//card search: 
			WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.sendKeys("0010");
				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(pass, "Card Number entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Card Number text box was not found");
			}
			

			if (elements.CardSearchResult().isDisplayed()) {
				//element.CardSearchResult().click();

				iOSLogs.CapturedLogs(pass, "Card search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Card search result was not found");
			}
			
			//driver ID: 
			elements.DriverIDSelection().click();
			//element.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			//driver id search:
			WebElement DriverIDSearch = elements.DriverIDSearch();
			if (DriverIDSearch.isDisplayed()) {
				DriverIDSearch.sendKeys("1234");

				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(pass, "Driver ID entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Driver ID text box was not found");
			}
			

			if (elements.DriverIDSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				iOSLogs.CapturedLogs(pass, "Driver ID search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Driver ID search result was not found");
			}
			
			//Policy:
			elements.PolicySelection().click();
			//element.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			//policy search:
			WebElement PolicySearch = elements.PolicySearch();
			if (PolicySearch.isDisplayed()) {
				PolicySearch.sendKeys("3");
				
				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(pass, "Policy number entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Policy text box was not found");
			}
			

			if (elements.PolicySearchResult().isDisplayed()) {
				//unitSearchResult.click();

				iOSLogs.CapturedLogs(pass, "Policy search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(fail, "Policy search result was not found");
			}
			
			
			} else {
				iOSLogs.CapturedLogs(fail, "Cards Tab was not found.");
			

			}
						
		return this;
		

	}
}

