package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class CardsOverviewCompany {
	Logs iOSLogs = new Logs();
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
	
	public CardsOverviewCompany CardsOverview() throws Exception {
		iOSLogs.setupTest("Testing Cards overview Company card");
		appSleep.ThreadSleep3000();
		// try {
		// find Cards Tab and click it.

		appWait.CardsTabOrSleep3000(); // need to add waits
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) {
			CardsTab.click();
			iOSLogs.CapturedLogs(pass, "Cards Tab is opened.");

			// card:
			elements.CardSelection().click();

			// card search:

			WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.clear();
				CardSearch.sendKeys("0010");

				elements.PhysicalSearchButton().click();
				iOSLogs.CapturedLogs(pass, "Card Number entered.");

			} else {
				iOSLogs.CapturedLogs(fail, "Card Number text box was not found");
			}

			WebElement CardSearchResult = elements.CardSearchResult();
			if (CardSearchResult.isDisplayed()) {
				CardSearchResult.click();

				iOSLogs.CapturedLogs(pass, "Card search result found.");
				// Code directed to Universal card tab on 103526
				WebElement CompanyCardImage = elements.CompanyCardImage();
				Thread.sleep(3000);
				if (CompanyCardImage != null && CompanyCardImage.isEnabled()) {

					// Change status
					Thread.sleep(3000);
					WebElement ChangeStatusButton = elements.ChangeStatusButton();
					Thread.sleep(3000);
					if (ChangeStatusButton != null && ChangeStatusButton.isEnabled()) {
						Thread.sleep(3000);
						ChangeStatusButton.click();
						iOSLogs.CapturedLogs(pass, "Change status opened");
						Thread.sleep(3000);
						elements.HoldStatus().click();
						elements.StatusChangeSaveButton().click();
						iOSLogs.CapturedLogs(pass, "Status set to hold");
						
						
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.InactiveStatus().click();
						elements.StatusChangeSaveButton().click();
						iOSLogs.CapturedLogs(pass, "Status set to inactive");
						
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.ActiveStatus().click();
						elements.StatusChangeSaveButton().click();
						iOSLogs.CapturedLogs(pass, "status set to active");
					} else {
						iOSLogs.CapturedLogs(fail, "Change status button not found");
					}

					
					// load cash
					Thread.sleep(3000);
					WebElement LoadCashButton = elements.LoadCashButton();
					if (LoadCashButton != null && LoadCashButton.isEnabled()) {
						LoadCashButton.click();
						iOSLogs.CapturedLogs(pass, "Load cash button clicked");
						elements.LoadCashAmountTextBox().sendKeys("1.99");
						iOSLogs.CapturedLogs(pass, "Load cash amount entered");
						elements.LoadCashNextButton().click();
						elements.LoadCashAmountButton().click();
						iOSLogs.CapturedLogs(pass, "Load cash completed");
					} else {
						iOSLogs.CapturedLogs(info,
								"Load cash button not found Could be unavailble for account check image");
					}

					// remove cash
					Thread.sleep(3000);
					WebElement RemoveCashButton = elements.RemoveCashButton();
					if (RemoveCashButton != null && RemoveCashButton.isEnabled()) {
						RemoveCashButton.click();
						iOSLogs.CapturedLogs(pass, "Remove cash clicked");
						elements.RemoveCashAmountTextBox().sendKeys("1.99");
						iOSLogs.CapturedLogs(pass, "Remove cash amount entered");
						Thread.sleep(3000);
						elements.RemoveCashNextButton().click();
						Thread.sleep(5000);
						elements.RemoveCashAmountButton().click();
						iOSLogs.CapturedLogs(pass, "Remove cash completed");
					} else {
						iOSLogs.CapturedLogs(info,
								"Remove cash button not found Could be unavailble for account check image");
					}

					// network override and disable
					Thread.sleep(3000);
					WebElement NetworkOverridesButton = elements.NetworkOverridesButton();
					if (NetworkOverridesButton != null && NetworkOverridesButton.isEnabled()) {
						NetworkOverridesButton.click();
						iOSLogs.CapturedLogs(pass, "Network override clicked");
						elements.NetworkOverridePlusButton().click();
						
						elements.EnableNetworkOverrideButton().click();
						iOSLogs.CapturedLogs(pass, "Network override enabled");
						Thread.sleep(3000);
						elements.NetworkOverridesButton().click();
						elements.DisableNetworkOverrideModalButton().click();
						iOSLogs.CapturedLogs(pass, "Network override disabled");
					} else {
						iOSLogs.CapturedLogs(info, "Network overrides button not found");
					}

					// Card information
					Thread.sleep(3000);
					WebElement CardInformationButton = elements.CardInformationButton();
					Thread.sleep(3000);
					if (CardInformationButton != null && CardInformationButton.isEnabled()) {
						CardInformationButton.click();
						iOSLogs.CapturedLogs(pass, "Card information opened");
						
						WebElement OverrideMileageButton = elements.OverrideMileageButton();
						if (OverrideMileageButton != null && OverrideMileageButton.isEnabled()) {
						elements.OverrideMileageButton().click();
						iOSLogs.CapturedLogs(pass, "Overide Milage Button selected");
						} else {
						iOSLogs.CapturedLogs(info, "Overide Milage Button not found");
						}
						iOSLogs.CapturedLogs(pass, "Override mileage opened");
						elements.OverrideMileageNextButton().click();
						elements.MileageTextBox().sendKeys("100");
						iOSLogs.CapturedLogs(pass, "Mileage texbox filled in");
						elements.MileageSaveButton().click();
						iOSLogs.CapturedLogs(pass, "Override mileage completed");
											
					} else {
						iOSLogs.CapturedLogs(info, "Card information button not found");
					}

					// Card information to override Hubometer
					Thread.sleep(3000);
					WebElement OverrideMileageNextButton2 = elements.OverrideMileageNextButton();
					if (OverrideMileageNextButton2 != null && OverrideMileageNextButton2.isEnabled()) {
						OverrideMileageNextButton2.click();
						iOSLogs.CapturedLogs(pass, "Override Milage opened");
						elements.HubometerRadioButton().click();
						iOSLogs.CapturedLogs(pass, "Hubometer radio button selected");
						elements.OverrideMileageNextButton().click();
						elements.MileageTextBox().sendKeys("252");
						iOSLogs.CapturedLogs(pass, "Mileage text box filled in");
						elements.MileageSaveButton().click();
						iOSLogs.CapturedLogs(pass, "Override mileage completed");
											
					} else {
						iOSLogs.CapturedLogs(info,
								"Card information button not found Could be unavailble for account check image");
					}

					
					WebElement CardInfoBackButton = elements.CardInfoBackButton();
					if (CardInfoBackButton != null && CardInfoBackButton.isEnabled()) {
					CardInfoBackButton.click();
					iOSLogs.CapturedLogs(info, "Card information Back button found");
					} else {
						iOSLogs.CapturedLogs(info, "Card information Back button not found");
					}
					
					
					// Activity
					Thread.sleep(2000);
					scroll.ScrollDown();
					Thread.sleep(3000);
					WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
					if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
						ActivityViewAllTop.click();
						iOSLogs.CapturedLogs(pass, "View all top button clicked");
//						scroll.ScrollDown();
//						scroll.ScrollUp();
//						elements.TransactionActivityCell().click();
//						Thread.sleep(2000);
//						elements.TransactionActivityCellBackButton().click();
//						Thread.sleep(2000);
						WebElement TransactionActivityViewAllBackButton = elements
								.TransactionActivityViewAllBackButton();
						if (TransactionActivityViewAllBackButton != null
								&& TransactionActivityViewAllBackButton.isEnabled()) {
							elements.TransactionActivityViewAllBackButton().click();
							iOSLogs.CapturedLogs(pass, "View all back button clicked");
						} else {
							iOSLogs.CapturedLogs(fail, "Back button not found");
						}

					} else {
						iOSLogs.CapturedLogs(fail, "View all top button not found");
					}

					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					Thread.sleep(3000);
					WebElement ActivityViewAllBottom = elements.ActivityViewAllBottom();
					if (ActivityViewAllBottom != null && ActivityViewAllBottom.isEnabled()) {
						ActivityViewAllBottom.click();
						iOSLogs.CapturedLogs(pass, "View all bottom button clicked");
						Thread.sleep(3000);
						WebElement TransactionActivityViewAllBackButton2 = elements
								.TransactionActivityViewAllBackButton();
						if (TransactionActivityViewAllBackButton2 != null
								&& TransactionActivityViewAllBackButton2.isEnabled()) {
							elements.TransactionActivityViewAllBackButton().click();
							iOSLogs.CapturedLogs(pass, "View all back button clicked");
						} else {
							iOSLogs.CapturedLogs(fail, "Back button not found");
						}
					} else {
						iOSLogs.CapturedLogs(fail, "View all bottom button not found");
					}
		
				} else {
					iOSLogs.CapturedLogs(fail, "Company card image not found");
				}
				// add back button to leave card here
			} else {
				iOSLogs.CapturedLogs(fail, "Card search result was not found");
			}

		} else {
			iOSLogs.CapturedLogs(fail, "Cards Tab was not opened.");

		}

		return this;

	}
}
