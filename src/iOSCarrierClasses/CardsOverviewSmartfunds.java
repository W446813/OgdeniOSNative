package iOSCarrierClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class CardsOverviewSmartfunds {
	Logs logs = new Logs();
	RepoCarrieriOS elements=new RepoCarrieriOS();
	Sleep appSleep = new Sleep();
	Wait appWait = new Wait();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	AppStringsiOS iOSText = new AppStringsiOS();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	
	public CardsOverviewSmartfunds CardsOverviewSubuser() throws Exception {
		logs.setupTest("Testing Cards overview subsuser tab");
		appSleep.ThreadSleep3000();
		//try {
		//find Cards Tab and click it.
		
		appWait.CardsTabOrSleep3000(); //need to add waits
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) { 
			CardsTab.click();
		logs.CapturedLogs(pass, "Cards Tab is opened.");
		
		//card: 
		elements.CardSelection().click();
		
		//card search: 
		WebElement CardSearch = elements.CardSearch();
		if (CardSearch.isDisplayed()) {
			CardSearch.clear();
			CardSearch.sendKeys("5542");
			
			elements.PhysicalSearchButton().click();
			logs.CapturedLogs(pass, "Card Number entered.");

		} else {
			logs.CapturedLogs(fail, "Card Number text box was not found");
		}
		
		WebElement CardSearchResultCardsOverview = elements.CardSearchResultCardsOverview();
		if (CardSearchResultCardsOverview.isDisplayed()) {
			CardSearchResultCardsOverview.click();

			logs.CapturedLogs(pass, "Card search result found.");
				Thread.sleep(5000);
				// Code directed to Smartfunds card on 5542 John wayne 102698db 
				WebElement SmartfundsCardImage = elements.SmartfundsCardImage();//add xpath
				if (SmartfundsCardImage != null && SmartfundsCardImage.isEnabled()) {
					Thread.sleep(3000);

					// Change status
					Thread.sleep(3000);
					WebElement ChangeStatusButton = elements.ChangeStatusButton();
					if (ChangeStatusButton != null && ChangeStatusButton.isEnabled()) {
						Thread.sleep(3000);
						ChangeStatusButton.click();
						logs.CapturedLogs(pass, "Change status button pressed");
						Thread.sleep(3000);
						elements.HoldStatus().click();
						logs.CapturedLogs(pass, "Hold status options selected");
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs(pass, "Change status save button pressed");
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						logs.CapturedLogs(pass, "Change status button pressed");

						Thread.sleep(3000);
						elements.InactiveStatus().click();
						logs.CapturedLogs(pass, "Inactive status options selected");
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs(pass, "Change status save button pressed");

						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						logs.CapturedLogs(pass, "Change status  button pressed");
						Thread.sleep(3000);
						elements.ActiveStatus().click();
						logs.CapturedLogs(pass, "Active status options selected");
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs(pass, "Change status save button pressed");

					} else {
						logs.CapturedLogs(info, "Change status button not found");
					}

					
					// load cash
					WebElement LoadCashButton = elements.LoadCashButton();
					if (LoadCashButton != null && LoadCashButton.isEnabled()) {
						LoadCashButton.click();
						elements.LoadCashAmountTextBox().sendKeys("1.99");
						logs.CapturedLogs(pass, "1.99 entered into text box");
						elements.LoadCashNextButton().click();
						logs.CapturedLogs(pass, "Load Cash next button pressed");
						elements.LoadCashAmountButton().click();
						logs.CapturedLogs(pass, "Load Cash Ammount button pressed");
					} else {
						logs.CapturedLogs(info, "Load cash button not found Could be unavailble for account check image");
					}

					// remove cash
					Thread.sleep(3000);
					WebElement RemoveCashButton = elements.RemoveCashButton();
					Thread.sleep(3000);
					if (RemoveCashButton != null && RemoveCashButton.isEnabled()) {
						RemoveCashButton.click();
						elements.RemoveCashAmountTextBox().sendKeys("1.99");
						Thread.sleep(3000);
						elements.RemoveCashNextButton().click();
						logs.CapturedLogs(pass, "Remove Cash next button pressed");
						Thread.sleep(5000);
						elements.RemoveCashAmountButton().click();
						logs.CapturedLogs(pass, "Remove Cash amount button pressed");
					} else {
						logs.CapturedLogs(info, "Remove cash button not found");
					}

					// Card information
					WebElement CardInformationButton = elements.CardInformationButton();
					Thread.sleep(3000);
					if (CardInformationButton != null && CardInformationButton.isEnabled()) {
						CardInformationButton.click();
						logs.CapturedLogs(pass, "card Info  button pressed");
						
						
						WebElement CardInfoBackButton = elements.CardInfoBackButton();
						Thread.sleep(3000);
						if (CardInfoBackButton != null && CardInfoBackButton.isEnabled()) {
						elements.CardInfoBackButton().click();
						}else {
						logs.CapturedLogs(info, "Card information Backbutton not found");
						}
						
						logs.CapturedLogs(pass, "card Info back button pressed");
					} else {
						logs.CapturedLogs(info, "Card information button not found");
					}
					
					
					// Activity
					//Activity taking long to load inside view all
					
					Thread.sleep(2000);
					scroll.ScrollDown();
					WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
					if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
						ActivityViewAllTop.click();		
						logs.CapturedLogs(pass, "View all activity top button pressed");
						WebElement TransactionActivityViewAllBackButton = elements.TransactionActivityViewAllBackButton();
						if (TransactionActivityViewAllBackButton != null && TransactionActivityViewAllBackButton.isEnabled()) {
							TransactionActivityViewAllBackButton.click();
						logs.CapturedLogs(pass, "View all activity top Back button pressed");
						}
						else {
						logs.CapturedLogs(fail, "Back button not found");
						}

					} else {
						logs.CapturedLogs(info, "View all top button not found");
					}

					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					
					WebElement ActivityViewAllBottom = elements.ActivityViewAllBottom();
					if (ActivityViewAllBottom != null && ActivityViewAllBottom.isEnabled()) {
						ActivityViewAllBottom.click();
						logs.CapturedLogs(pass, "View all activity bottom button pressed");
						Thread.sleep(3000);
						WebElement TransactionActivityViewAllBackButton2 = elements.TransactionActivityViewAllBackButton();
						if (TransactionActivityViewAllBackButton2 != null && TransactionActivityViewAllBackButton2.isEnabled()) {
							TransactionActivityViewAllBackButton2.click();
						logs.CapturedLogs(pass, "View all activity bottom Back button pressed");
						}
						else {
						logs.CapturedLogs(fail, "Back button not found");
						}
					} else {
						logs.CapturedLogs(info, "View all bottom button not found");
					}
					Thread.sleep(3000);
					//add back button
					
				} else {
					logs.CapturedLogs(info, "Smarfunds tab not found");
				}

				

			} else {
				logs.CapturedLogs(fail, "Card search result was not found");
			}
		

		} else {
			logs.CapturedLogs(fail, "Cards Tab was not found.");

		}

		return this;

	}
}
