package iOSCarrierClasses;

import org.openqa.selenium.WebElement;
//import org.testng.ITestResult;
//import org.testng.Reporter;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AccountsTab {
	Sleep appSleep = new Sleep();
	Logs logs = new Logs();
	Wait appWait = new Wait();
	AppStringsiOS cardControlNumber = new AppStringsiOS();
	InputText appText = new InputText();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	AccountTabManageYourProfile manageYourProfile = new AccountTabManageYourProfile();
	AppStringsiOS iOSText = new AppStringsiOS();
	static AppiumDriver<WebElement> driver;
	public AccountsTab accountsTab() throws Exception {
	
		logs.setupTest("Testing Account tab");
		
		Thread.sleep(3000);
		WebElement accountsTab = elements.accountsTab();
		Thread.sleep(2000);
		if (accountsTab.isEnabled()) {
			Thread.sleep(3000);
			accountsTab.click();
			logs.CapturedLogs(iOSText.PASS, "accounts Tab is opened.");
		} else {
			logs.CapturedLogs(iOSText.FAIL, "accounts Tab was not found.");
		}

//This section tests and updated the profile name and details if it fails it puts the wrong info on the account Skipping probably should be done manually... 		
//		WebElement ManageYourProfile = elements.ManageYourProfile();
//		if (ManageYourProfile != null && ManageYourProfile.isEnabled()) {
//			ManageYourProfile.click();
//			// edit account information
//			manageYourProfile.AccountTabManageYourProfile();

//				Thread.sleep(2000);
//				Capabilities.driver.navigate().back();
//				Thread.sleep(3000);
//		} else {
//			logs.CapturedLogs(iOSText.INFO, "Manage your profile not found or is not a role in this account.");
//
//		}
		Thread.sleep(2000);
		// moved ACH transfer to its own class

		WebElement BioSwitch = elements.BioSwitch();
		Thread.sleep(2000);
		if (BioSwitch != null && BioSwitch.isEnabled()) {
			BioSwitch.click();
			logs.CapturedLogs(iOSText.PASS, "Bio Swicth toggle to on");

			WebElement BioSwitchOk = elements.BioSwitchOk();
			Thread.sleep(2000);
			if (BioSwitchOk != null && BioSwitchOk.isEnabled()) {
				BioSwitchOk.click();
				logs.CapturedLogs(iOSText.PASS, "Bio Switch Ok Button pressed.");

			} else {
				elements.BioSwitch().click();
				logs.CapturedLogs(iOSText.FAIL, "Bio Swicth Ok modal not seen.");
			}

		} else {
			logs.CapturedLogs(iOSText.FAIL, "Bio Swicth toggle not found.");
		}

		Thread.sleep(2000);
		WebElement CallCustomerService = elements.CallCustomerService();
		Thread.sleep(2000);
		if (CallCustomerService.isEnabled()) {
			CallCustomerService.click();
			logs.CapturedLogs(iOSText.PASS, "Call customer service opened");
			Thread.sleep(2000);
			elements.CancelCustomerServiceButton().click();
			logs.CapturedLogs(iOSText.PASS, "Clicked cancel to close customer service modal");
			Thread.sleep(2000);
		} else {
			logs.CapturedLogs(iOSText.FAIL, "Call Customer service not found.");
		}

		Thread.sleep(2000);
		WebElement WelcomeTutorial = elements.WelcomeTutorial();
		Thread.sleep(2000);
		if (WelcomeTutorial.isEnabled()) {
			WelcomeTutorial.click();
			logs.CapturedLogs(iOSText.PASS, "View Welcome tutorial opened");
			Thread.sleep(3000);
			scroll.WelcomeScreenScroll();
			elements.WelcomeTutorialDoneButton().click();
			logs.CapturedLogs(iOSText.PASS, "Welcome tutorial Done button clicked.");
			Thread.sleep(3000);
		} else {
			logs.CapturedLogs(iOSText.FAIL, "View Welcome tutorial not found.");
		}

		Thread.sleep(2000);
		WebElement TermsOfUse = elements.TermsOfUse();
		Thread.sleep(2000);
		if (TermsOfUse.isEnabled()) {
			TermsOfUse.click();
			logs.CapturedLogs(iOSText.PASS, "Terms of use opened");
			Thread.sleep(3000);
			//new TouchAction<>(Capabilities.driver).longPress(PointOption.point(50, 66)).release().perform();
			elements.TermsOfUseDoneButton().click();
			logs.CapturedLogs(iOSText.PASS, "Used done to close Terms of use Page.");
			Thread.sleep(3000);
		} else {
			logs.CapturedLogs(iOSText.FAIL, "terms of use not found.");
		}

		WebElement PrivacyPolicy = elements.PrivacyPolicy();
		Thread.sleep(2000);
		if (PrivacyPolicy.isEnabled()) {
			Thread.sleep(2000);
			PrivacyPolicy.click();
			logs.CapturedLogs(iOSText.PASS, "Privacy Policy link found and clicked.");
			Thread.sleep(3000);
			//new TouchAction<>(Capabilities.driver).longPress(PointOption.point(50, 66)).release().perform();
			elements.PrivacyPolicyDoneButton().click();
			logs.CapturedLogs(iOSText.PASS, "Done button clicked to close privacy policy.");

		} else {
			logs.CapturedLogs(iOSText.FAIL, "Privacy policy not found");
		}

		// Reporter.setCurrentTestResult(Pass);
		return this;
	}
}
