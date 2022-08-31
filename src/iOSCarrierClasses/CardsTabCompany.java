package iOSCarrierClasses;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class CardsTabCompany {
  
	Logs androidLogs = new Logs();
	RepoCarrieriOS elements=new RepoCarrieriOS();
	Sleep appSleep = new Sleep();
	AppStringsiOS iOSText = new AppStringsiOS();
	  static AppiumDriver<WebElement> driver;
		DesiredCapabilities cap = new DesiredCapabilities();
	
	
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		public CardsTabCompany CardsTabCompamy() throws Exception {
			Wait appWait = new Wait();
			androidLogs.setupTest("Testing Cards Tab");

			appWait.CardsTabOrSleep3000();
			WebElement CardsTab = elements.CardsTab();
			if (CardsTab.isEnabled()) { 
				CardsTab.click();
			androidLogs.CapturedLogs(pass, "Cards Tab is opened.");
			
			
			//driver: 
			elements.DriverSelection().click();
			
			//element.SearchIcon().click();
			
			//driver search: 
			WebElement DriverSearch = elements.DriverSearch();
			if (DriverSearch.isDisplayed()) {
				DriverSearch.sendKeys("John Wayne");

				elements.PhysicalSearchButton().click();
				androidLogs.CapturedLogs(pass, "Driver name entered.");

				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Driver text box was not found");
			}
			
			

			if (elements.DriverSearchResult().isDisplayed()) {
				//driverSearchResult.click();

				androidLogs.CapturedLogs(pass, "Driver search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Driver search result was not found");
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
				androidLogs.CapturedLogs(pass, "Unit number entered.");
			} else {
				androidLogs.CapturedLogs(fail, "Unit text box was not found");
			}
			
			
			if (elements.UnitSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				androidLogs.CapturedLogs(pass, "Unit search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Unit search result was not found");
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
				androidLogs.CapturedLogs(pass, "Card Number entered.");
			} else {
				androidLogs.CapturedLogs(fail, "Card Number text box was not found");
			}
			

			if (elements.CardSearchResult().isDisplayed()) {
				//element.CardSearchResult().click();

				androidLogs.CapturedLogs(pass, "Card search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Card search result was not found");
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
				androidLogs.CapturedLogs(pass, "Driver ID entered.");
			} else {
				androidLogs.CapturedLogs(fail, "Driver ID was not entered");
			}
			

			if (elements.DriverIDSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				androidLogs.CapturedLogs(pass, "Driver ID search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Driver ID search result was not found");
			}
			
			//Policy:
			elements.PolicySelection().click();
			//element.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			//policy search:
			WebElement PolicySearch = elements.PolicySearch();
			if (PolicySearch.isDisplayed()) {
				PolicySearch.sendKeys("2");
				elements.PhysicalSearchButton().click();
				androidLogs.CapturedLogs(pass, "Policy number entered.");

				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Policy text box was not found");
			}
			

			if (elements.PolicySearchResult().isDisplayed()) {
				//unitSearchResult.click();

				androidLogs.CapturedLogs(pass, "Policy search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				androidLogs.CapturedLogs(fail, "Policy search result was not found");
			}
			
			
			} else {
				androidLogs.CapturedLogs(fail, "Cards Tab was not found.");
			}
						
		return this;
		

	}
}

