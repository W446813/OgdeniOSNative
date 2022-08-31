package iOSCarrierClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class CardsOverviewUniversaliOS {
	Logs logs = new Logs();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	Sleep appSleep = new Sleep();
	Wait appWait = new Wait();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	AppStringsiOS iOSText = new AppStringsiOS();

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	public CardsOverviewUniversaliOS CardsOverview() throws Exception {
		// Code directed to Company card tab on 100045

		logs.setupTest("Testing Cards overview Universal Card");
		appSleep.ThreadSleep3000();
		// try {
		// find Cards Tab and click it.

		appWait.CardsTabOrSleep3000(); // need to add waits
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) {
			CardsTab.click();
		
			logs.CapturedLogs(pass, "Cards Tab is opened.");

			// card:
			elements.CardSelection().click();

			// card search:
			WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.clear();
				CardSearch.sendKeys("0470");

				elements.PhysicalSearchButton().click();

				logs.CapturedLogs(pass, "Card Number entered.");
			} else {
				logs.CapturedLogs(fail, "Card Number text box was not found");
			}

			WebElement CardSearchResult = elements.CardSearchResult();
			Thread.sleep(3000);
			if (CardSearchResult.isDisplayed()) {
				CardSearchResult.click();

				logs.CapturedLogs(pass, "Card search result found.");

				logs.CapturedLogs(info, "Testsing Company Card Side");
				WebElement CompanyTab = elements.CompanyTab();
				Thread.sleep(3000);
				if (CompanyTab != null && CompanyTab.isEnabled()) {
					CompanyTab.click();
										
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
					Thread.sleep(2000);
					// scroll.ScrollDown();
					WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
					if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
						Thread.sleep(2000);
						ActivityViewAllTop.click();
						logs.CapturedLogs(pass, "View All Activity Top button clicked");
						Thread.sleep(3000);
						scroll.ScrollDown();
						scroll.ScrollUp();
							
						WebElement TransactionActivityViewAllTopBackButtonTest = elements.TransactionActivityViewAllBottomBackButton();
						logs.CapturedLogs(info, "View all activity top Back button found");
						TransactionActivityViewAllTopBackButtonTest.click();
						logs.CapturedLogs(pass, "View all activity top Back button pressed");
						
//						Thread.sleep(3000);
//						WebElement TransactionActivityViewAllTopBackButton = elements.TransactionActivityViewAllTopBackButton();
//						if (TransactionActivityViewAllTopBackButton != null && TransactionActivityViewAllTopBackButton.isEnabled()) {
//							TransactionActivityViewAllTopBackButton.click();
//						logs.CapturedLogs(pass, "View all activity top Back button pressed");
//						}
//						else {
//						logs.CapturedLogs(fail, "View all activity top Back button not found");
//						}
					} else {
						logs.CapturedLogs(info, "View all Activity top button not found or less than 10 found ");
					}
					
					
					
					
					
					

					scroll.ScrollDown();
					scroll.ScrollDown();
					Thread.sleep(3000);
					WebElement ActivityViewAllBottom = elements.ActivityViewAllBottom();
					if (ActivityViewAllBottom != null && ActivityViewAllBottom.isEnabled()) {
						Thread.sleep(3000);
						ActivityViewAllBottom.click();
						logs.CapturedLogs(pass, "View All Activity Bottom button clicked");

						Thread.sleep(3000);
						WebElement TransactionActivityViewAllBackButton2 = elements.TransactionActivityViewAllBackButton();
						if (TransactionActivityViewAllBackButton2 != null && TransactionActivityViewAllBackButton2.isEnabled()) {
							TransactionActivityViewAllBackButton2.click();
						logs.CapturedLogs(pass, "View all activity bottom Back button pressed");
						}
						else {
						logs.CapturedLogs(fail, "\"View all activity Back button not found");
						}
					} else {
						logs.CapturedLogs(info, "View all Activity Bottom button not found or less than 10 found ");
					}

				} else {
					logs.CapturedLogs(fail, "Company tab not found");
				}

				// ***********Smartfunds tab*************//

				Thread.sleep(3000);
				scroll.ScrollUp();
				logs.CapturedLogs(info, "Testsing smartfunds Card Side");
				WebElement SmartfundsTab = elements.SmartfundsTab();
				Thread.sleep(3000);
				if (SmartfundsTab != null && SmartfundsTab.isEnabled()) {
					SmartfundsTab.click();
					logs.CapturedLogs(pass, "SmartFunds Tab found and clicked");
					Thread.sleep(3000);
					logs.CapturedLogs(info, "SmartFunds tab loaded.");
					Thread.sleep(3000);
					
					
					// Change status
					WebElement ChangeStatusButton = elements.ChangeStatusButton();
					Thread.sleep(3000);
					if (ChangeStatusButton != null && ChangeStatusButton.isEnabled()) {
						Thread.sleep(3000);
						ChangeStatusButton.click();
						Thread.sleep(3000);
						elements.HoldStatus().click();
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs("test Pass", "Hold Status selected and saved");
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.InactiveStatus().click();
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs("test Pass", "Inactive Status selected and saved");
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.ActiveStatus().click();
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs("test Pass", "Active Status selected and saved");
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.FollowsStatus().click();
						elements.StatusChangeSaveButton().click();
						logs.CapturedLogs("test Pass", "Follow Status selected and saved");
						Thread.sleep(3000);
					} else {
						logs.CapturedLogs(fail, "Change status button not found");
					}
					

					// load cash
					WebElement LoadCashButton = elements.LoadCashButton();
					Thread.sleep(3000);
					if (LoadCashButton != null && LoadCashButton.isEnabled()) {
						LoadCashButton.click();
						logs.CapturedLogs(pass, "Load Cash Button clicked");
						elements.LoadCashAmountTextBox().sendKeys("1.99");
						logs.CapturedLogs(pass, "Load Cash Amount textbox and 1.99 added");
						elements.LoadCashNextButton().click();
						logs.CapturedLogs(pass, "Load Cash Next  Button and clicked");
						elements.LoadCashAmountButton().click();
						logs.CapturedLogs(pass, "Load Cash Amount Button and clicked");
					} else {
						logs.CapturedLogs(fail, "Load cash button not found");
					}

					// remove cash
					Thread.sleep(3000);
					WebElement RemoveCashButton = elements.RemoveCashButton();
					Thread.sleep(3000);
					if (RemoveCashButton != null && RemoveCashButton.isEnabled()) {
						Thread.sleep(3000);
						RemoveCashButton.click();
						logs.CapturedLogs(pass, "Remove Cash Button and clicked");
						elements.RemoveCashAmountTextBox().sendKeys("1.99");
						logs.CapturedLogs(pass, "Remove Cash amount text box and 1.99 added");
						Thread.sleep(3000);
						elements.RemoveCashNextButton().click();
						logs.CapturedLogs(pass, "Remove Cash Next Button and clicked");
						Thread.sleep(5000);
						elements.RemoveCashAmountButton().click();
						logs.CapturedLogs(pass, "Remove Cash Amount Button and clicked");
					} else {
						logs.CapturedLogs(info, "Remove cash button not found");
					}

					// Card information
					WebElement CardInformationButton = elements.CardInformationButton();
					Thread.sleep(3000);
					if (CardInformationButton != null && CardInformationButton.isEnabled()) {
						CardInformationButton.click();
						logs.CapturedLogs(pass, "Card Information Button and clicked");
						Thread.sleep(3000);
						elements.CardInfoBackButton().click();
						logs.CapturedLogs(pass, "Card Information back Button and clicked");
					} else {
						logs.CapturedLogs(fail, "Card information button not found");
					}

					Thread.sleep(2000);
					// scroll.ScrollDown();

					WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
					Thread.sleep(3000);
					if (ActivityViewAllTop != null && ActivityViewAllTop.isDisplayed()
							&& ActivityViewAllTop.isEnabled()) {
						Thread.sleep(3000);
						ActivityViewAllTop.click();
						logs.CapturedLogs("test Pass", "View all top button and clicked");

						WebElement TransactionActivityViewAllBackButton = elements
								.TransactionActivityViewAllBackButton();
						Thread.sleep(3000);
						if (TransactionActivityViewAllBackButton != null
								&& TransactionActivityViewAllBackButton.isEnabled()) {
							TransactionActivityViewAllBackButton.click();
							logs.CapturedLogs("test Pass", "View All Transaction bottom back button and clicked");
						} else {
							logs.CapturedLogs(fail, "View All Transaction bottom back button not found");
						}
					} else {
						logs.CapturedLogs(info, "View all top button not found or less than 10 transactions found");
					}

					// Activity
					// Activity taking long to load inside view all

					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();

					WebElement ActivityViewAllBottom = elements.ActivityViewAllBottom();
					Thread.sleep(3000);
					if (ActivityViewAllBottom != null && ActivityViewAllBottom.isDisplayed()
							&& ActivityViewAllBottom.isEnabled()) {

						ActivityViewAllBottom.click();
						logs.CapturedLogs("test Pass", "View all bottom button found and clicked");
						WebElement TransactionActivityViewAllBackButton2 = elements
								.TransactionActivityViewAllBackButton();
						Thread.sleep(3000);
						if (TransactionActivityViewAllBackButton2 != null
								&& TransactionActivityViewAllBackButton2.isDisplayed()
								&& TransactionActivityViewAllBackButton2.isEnabled()) {
							TransactionActivityViewAllBackButton2.click();
							logs.CapturedLogs("test Pass", "View All Transaction bottom back button clicked");
						} else {
							logs.CapturedLogs(fail, "View All Transaction bottom back button not found");
						}
					} else {
						logs.CapturedLogs(info, "View all bottom button not found or less than 10 transactions found");
					}
					
					WebElement ActivityViewAllTopSeen = elements.ActivityViewAllTop();
					Thread.sleep(3000);
					if (ActivityViewAllTopSeen != null && ActivityViewAllTopSeen.isDisplayed()
							&& ActivityViewAllTopSeen.isEnabled()) {
						Thread.sleep(3000);
						logs.CapturedLogs("test Pass", "View all top button found after card status change");
					} else {
						logs.CapturedLogs(info, "View all top button not found after card status change or less than 10 transaction found");
					}

					// Activity
					// Activity taking long to load inside view all

					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();

					WebElement ActivityViewAllBottomSeen = elements.ActivityViewAllBottom();
					Thread.sleep(3000);
					if (ActivityViewAllBottomSeen != null && ActivityViewAllBottomSeen.isDisplayed()
							&& ActivityViewAllBottomSeen.isEnabled()) {
						logs.CapturedLogs("test Pass", "View all bottom button found after card status change");
						
					} else {
						logs.CapturedLogs(info, "View all Bottom button not found after card status change or less than 10 transaction found");
					}

					// add back button here to go back to cards search****

				} else {
					logs.CapturedLogs(fail, "Smartfunds tab not found");
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
