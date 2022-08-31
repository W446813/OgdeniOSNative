package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;

public class CardLoginPassSecureFuel {
	public CardLoginPassSecureFuel() {
	}

private String env;


	
	public void CardPassExpected(String environment) throws Exception {
		this.env = environment;
		System.out.println("I am in login fail environment is:" + environment);
		CardPassExpected();
	}

	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	
	
	public void CardPassExpected() throws Exception {
		iOSText = new AppStringsiOS(env);
		Sleep appSleep = new Sleep();
		Logs iOSLogs = new Logs();
		RepoCardiOS xpath = new RepoCardiOS();

		iOSLogs.setupTest("Logging into 0561");

//				WebElement welcomeScreenStartButton = xpath.welcomeScreenStartButton();			
//				if (welcomeScreenStartButton.isEnabled()) {
//					welcomeScreenStartButton.click();
//					logs.CapturedLogs("Test Pass", "Welcome screen start button not found.");
//					appSleep.ThreadSleep1();
//				} else {
//					logs.CapturedLogs("Test Fail", "Welcome screen start button not found");
//				}

		iOSLogs.CapturedLogs(iOSText.PASS, "Login Pass Verification started succesfully.");
		Thread.sleep(3000);
		WebElement carrierNumberLoginPass = xpath.CardNumberTextBox();
		Thread.sleep(3000);
		if (carrierNumberLoginPass != null && carrierNumberLoginPass.isEnabled()) {
			carrierNumberLoginPass.click();
			carrierNumberLoginPass.clear();
			carrierNumberLoginPass.sendKeys(iOSText.getENVData("CARD_LOGIN_LOCK_EXPECTED"));

			iOSLogs.CapturedLogs(iOSText.PASS, "Card Number entered");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Card Number text box 0561 is not found");
		}

		Thread.sleep(3000);
		// Find the login Password text box tell if find or fail.
		Thread.sleep(3000);
		WebElement pass = xpath.PinPassTextBox();
		Thread.sleep(3000);
		if (pass != null && pass.isDisplayed()) {
			pass.sendKeys(iOSText.getENVData("SECURE_FUEL_0561_PIN"));
			iOSLogs.CapturedLogs(iOSText.PASS, "PIN entered");
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Pin/passcode for 0561 text box is not found");
		}
		Thread.sleep(3000);
		WebElement DoneKeyboardButton = xpath.DoneKeyboardButton();
		Thread.sleep(3000);
		if (DoneKeyboardButton != null && DoneKeyboardButton.isEnabled()) {
			DoneKeyboardButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Done Button Pressed");
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Done button not found");
		}
		Thread.sleep(3000);
		WebElement CardLoginButton = xpath.CardLoginButton();
		Thread.sleep(3000);
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();

			iOSLogs.CapturedLogs(iOSText.PASS, "Login Button Pressed");

		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Login Button is not found");
		}
	}

}
