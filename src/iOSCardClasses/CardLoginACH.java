package iOSCardClasses;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;


public class CardLoginACH {
	public CardLoginACH() {
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

	
	
	
	public void CardPassExpected() throws Exception {
		iOSText = new AppStringsiOS(env);
		
		iOSLogs.setupTest("Login Testing for 2800");
		iOSLogs.CapturedLogs(iOSText.INFO, "Login Pass Expected Testing started.");

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
			carrierNumberLoginPass.sendKeys(iOSText.getENVData("ACH_PIN_LOGIN_2800"));

			iOSLogs.CapturedLogs(iOSText.PASS, "Card Number entered");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Card Number text box 2800 is not found");
		}

		Thread.sleep(3000);
		// Find the login Password text box tell if find or fail.

		WebElement pass = xpath.PinPassTextBox();

		if (pass != null && pass.isDisplayed()) {
			pass.sendKeys(iOSText.getENVData("ACH_2800_PIN"));
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Pin/passcode for 5542 text box is not found");
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
