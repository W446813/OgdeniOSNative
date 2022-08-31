package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class ForgotPINorPasscode {

private String env;

private String cardNum;
	
	public void ForgotPINorPasscode(String environment, String cardNum) throws Exception {
		this.env = environment;
		this.cardNum = cardNum;
		System.out.println("I am in login fail environment is:" + environment);
		ForgotPINorPasscode();
	}
	
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements = new RepoCardiOS();
	

	public ForgotPINorPasscode ForgotPINorPasscode() throws Exception {
		iOSText = new AppStringsiOS(env);
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
		int lastFour;
		String passwordOrPin = "0000";
		String cardNumber = "0000";
		
		
		switch (cardNum) {
		case "6344":  lastFour = 1;
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 6344 found");
		cardNumber = "CARDPIN_LOGIN_NUMBER_6344";
		passwordOrPin = "CARDPIN_LOGIN_PIN_6344";
		break;
		
		case "0561": lastFour = 2;
		//TODO Add database login
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 0561 found");
		cardNumber = "CARD_LOGIN_LOCK_EXPECTED";
		passwordOrPin = "SECURE_FUEL_0561_PIN";
		break;
		
		case "5542": lastFour = 3;
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 5542 found");
		cardNumber = "FORGOT_PIN_PASSCODE_5542";
		passwordOrPin = "FORGOT_PIN_PASSCODE_5542_PASSCODE";
		break;
		
		case "2800": lastFour = 4;
		//TODO Add database login
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 2800 found");
		cardNumber = "ACH_PIN_LOGIN_2800";
		passwordOrPin = "ACH_2800_PIN";
		break;
					
		default:
		iOSLogs.CapturedLogs(iOSText.INFO, "No Card number found");
	
	}
		
		iOSLogs.setupTest("Forgot Pin or Passcode");
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeLink = elements.ForgotPINorPasscodeLink();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeLink != null && ForgotPINorPasscodeLink.isEnabled()) {
			ForgotPINorPasscodeLink.click();
			iOSLogs.CapturedLogs(pass, "Forgot PIN or passcode link clicked and opened.");
		} else {
			iOSLogs.CapturedLogs(fail, "Forgot PIN or passcode link not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeCardNumberTextBox = elements.ForgotPINorPasscodeCardNumberTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeCardNumberTextBox != null && ForgotPINorPasscodeCardNumberTextBox.isEnabled()) {
			ForgotPINorPasscodeCardNumberTextBox.click();
			ForgotPINorPasscodeCardNumberTextBox.clear();
			ForgotPINorPasscodeCardNumberTextBox.sendKeys(iOSText.getENVData(cardNumber));
			iOSLogs.CapturedLogs(pass,
					"Card number text box for " + iOSText.getENVData(cardNumber) + " found and card number entered");
		} else {
			iOSLogs.CapturedLogs(fail,
					"Card number text box for " + iOSText.getENVData(cardNumber) + " not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeNextButton = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton != null && ForgotPINorPasscodeNextButton.isEnabled()) {
			ForgotPINorPasscodeNextButton.click();
			iOSLogs.CapturedLogs(pass, "Next button for " + iOSText.getENVData(cardNumber) + " clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button for " + iOSText.getENVData(cardNumber) + " not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeSecurityAnswerTextBox = elements.ForgotPINorPasscodeSecurityAnswerTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeSecurityAnswerTextBox != null && ForgotPINorPasscodeSecurityAnswerTextBox.isEnabled()) {
			ForgotPINorPasscodeSecurityAnswerTextBox.click();
			ForgotPINorPasscodeSecurityAnswerTextBox.sendKeys("test");
			iOSLogs.CapturedLogs(pass, "Security answer text box found and answer entered");
		} else {
			iOSLogs.CapturedLogs(fail, "security answer text box not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeNextButton2 = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton2 != null && ForgotPINorPasscodeNextButton2.isEnabled()) {
			ForgotPINorPasscodeNextButton2.click();
			iOSLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeNewPasscodeTextBox = elements.ForgotPINorPasscodeNewPasscodeTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNewPasscodeTextBox != null && ForgotPINorPasscodeNewPasscodeTextBox.isEnabled()) {
			ForgotPINorPasscodeNewPasscodeTextBox.click();
			ForgotPINorPasscodeNewPasscodeTextBox.sendKeys(iOSText.getENVData(passwordOrPin));
			iOSLogs.CapturedLogs(pass, "New passcode entered");
		} else {
			iOSLogs.CapturedLogs(fail, "New passcode text box not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeConfirmPasscodeTextBox = elements.ForgotPINorPasscodeConfirmPasscodeTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeConfirmPasscodeTextBox != null
				&& ForgotPINorPasscodeConfirmPasscodeTextBox.isEnabled()) {
			ForgotPINorPasscodeConfirmPasscodeTextBox.click();
			ForgotPINorPasscodeConfirmPasscodeTextBox.sendKeys(iOSText.getENVData(passwordOrPin));
			iOSLogs.CapturedLogs(pass, "Confirm passcode entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Confirm passcode text box not found");
		}
		Thread.sleep(2000);
		WebElement ForgotPINorPasscodeNextButton3 = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton3 != null && ForgotPINorPasscodeNextButton3.isEnabled()) {
			ForgotPINorPasscodeNextButton3.click();
			iOSLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button not found");
		}

		Thread.sleep(2000);

		WebElement ForgotPINorPasscodeDoneButton = elements.ForgotPINorPasscodeDoneButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeDoneButton != null && ForgotPINorPasscodeDoneButton.isEnabled()) {
			ForgotPINorPasscodeDoneButton.click();
			iOSLogs.CapturedLogs(pass, "Done button clicked to Log in");
		} else {
			iOSLogs.CapturedLogs(fail, "Done button not found.");
		}
		Thread.sleep(5000);
		return this;
	}
}
