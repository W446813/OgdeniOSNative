package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class CardsTab {
  
	
	
	Sleep appSleep = new Sleep();
	Logs iOSLogs = new Logs();
	Wait appWait = new Wait();
	AppStringsiOS iOSText = new AppStringsiOS();
	InputText appText = new InputText();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	
	
	
	static AppiumDriver<WebElement> driver;
		public CardsTab cardsTab() throws Exception {
			iOSLogs.setupTest("Testing Cards tab");
			appSleep.ThreadSleep3000();
		
			appWait.CardsTabOrSleep3000();
			WebElement CardsTab = elements.CardsTab();
			if (CardsTab.isEnabled()) { 
				CardsTab.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Cards Tab is opened.");
			
			
			//driver: 
			elements.DriverSelection().click();
			
			//driver search: 
			WebElement DriverSearch = elements.DriverSearch();
			if (DriverSearch.isDisplayed()) {
				DriverSearch.sendKeys("John Wayne");
				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Driver name entered.");

			
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Driver text box was not found");
			}
			
			

			if (elements.DriverSearchResult().isDisplayed()) {
				//driverSearchResult.click();
			
				iOSLogs.CapturedLogs(iOSText.PASS, "Driver search result found.");
				
			
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Driver search result was not found");
			}
			
			
			//unit: 
			elements.UnitSelection().click();
			
			//unit search:		
			WebElement UnitSearch = elements.UnitSearch();
			if (UnitSearch.isDisplayed()) {
				UnitSearch.sendKeys("1234");

				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Unit number entered.");

				
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Unit text box was not found");
			}
			
			
			if (elements.UnitSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				iOSLogs.CapturedLogs(iOSText.PASS, "Unit search result found.");
				
				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Unit search result was not found");
			}
			
			
			//card: 
			elements.CardSelection().click();
			
			//card search: 
			WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.sendKeys("0470");
				
				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Card Number entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Card Number text box was not found");
			}
			

			if (elements.CardSearchResult().isDisplayed()) {
				//element.CardSearchResult().click();

				iOSLogs.CapturedLogs(iOSText.PASS, "Card search result found.");
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Card search result was not found");
			}
			
			//driver ID: 
			elements.DriverIDSelection().click();
			
			//driver id search:
			WebElement DriverIDSearch = elements.DriverIDSearch();
			if (DriverIDSearch.isDisplayed()) {
				DriverIDSearch.sendKeys("1234");

				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Driver ID entered.");

				appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Driver ID text box was not found");
			}
			

			if (elements.DriverIDSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				iOSLogs.CapturedLogs(iOSText.PASS, "Driver ID search result found.");
				
			
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Driver ID search result was not found");
			}
			
			//Policy:
			elements.PolicySelection().click();
			
			//policy search:
			WebElement PolicySearch = elements.PolicySearch();
			if (PolicySearch.isDisplayed()) {
				PolicySearch.sendKeys("3");
				
				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Policy number entered.");

				
			} else {
				iOSLogs.CapturedLogs(iOSText.PASS, "Policy text box was not found");
			}
			

			if (elements.PolicySearchResult().isDisplayed()) {
				//unitSearchResult.click();
		
				iOSLogs.CapturedLogs(iOSText.PASS, "Policy search result found.");
				
				
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Policy search result was not found");
			}
			
			} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Cards Tab was not found.");
			

			}
				return this;
		}
		
}
