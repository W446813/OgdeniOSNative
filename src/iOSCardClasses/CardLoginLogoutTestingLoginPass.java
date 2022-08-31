package iOSCardClasses;
import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;

public class CardLoginLogoutTestingLoginPass {
	public CardLoginLogoutTestingLoginPass() {
	}
	
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;

	
	public void CardPassExpected(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
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
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
//		int lastFour;
//		String passwordOrPin = "0000";
//		String cardNumber = "0000";
//		
//		
//		switch (cardNum) {
//		case "6344":  lastFour = 1;
//		iOSLogs.CapturedLogs(iOSText.INFO, "Card 6344 found");
//		cardNumber = "CARDPIN_LOGIN_NUMBER_6344";
//		passwordOrPin = "CARDPIN_LOGIN_PIN_6344";
//		break;
//		
//		case "0561": lastFour = 2;
//		//TODO Add database login
//		iOSLogs.CapturedLogs(iOSText.INFO, "Card 0561 found");
//		cardNumber = "CARD_LOGIN_LOCK_EXPECTED";
//		passwordOrPin = "SECURE_FUEL_0561_PIN";
//		break;
//		
//		case "5542": lastFour = 3;
//		iOSLogs.CapturedLogs(iOSText.INFO, "Card 5542 found");
//		cardNumber = "FORGOT_PIN_PASSCODE_5542";
//		passwordOrPin = "FORGOT_PIN_PASSCODE_5542_PASSCODE";
//		break;
//		
//		case "2800": lastFour = 4;
//		//TODO Add database login
//		iOSLogs.CapturedLogs(iOSText.INFO, "Card 2800 found");
//		cardNumber = "ACH_PIN_LOGIN_2800";
//		passwordOrPin = "ACH_2800_PIN";
//		break;
//					
//		default:
//		iOSLogs.CapturedLogs(iOSText.INFO, "No Card number found");
//	
//	}
	
		
		iOSLogs.setupTest("Login Pass testing");
		iOSLogs.CapturedLogs(info, "Login Pass Expected Testing started for 5542");
		iOSLogs.CapturedLogs(pass, "Login Pass Verification started succesfully.");
		
		WebElement cardNumberLoginPass = xpath.CardNumberTextBox();
		Thread.sleep(3000);
		if (cardNumberLoginPass != null && cardNumberLoginPass.isDisplayed()) {
			cardNumberLoginPass.click();
			cardNumberLoginPass.clear();
			cardNumberLoginPass.sendKeys(this.cardNum);
			iOSLogs.CapturedLogs(pass, "Card Number was entered");
		} else {
			iOSLogs.CapturedLogs(fail,
					"Card Number text box is not found");
		}

		Thread.sleep(3000);
		// Find the login Password text box tell if find or fail.

		WebElement PinPassTextBox = xpath.PinPassTextBox();
		Thread.sleep(3000);
		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.click();
			PinPassTextBox.clear();
			PinPassTextBox.sendKeys(this.passwordOrPin);
			iOSLogs.CapturedLogs(pass, "Pin/passcode text box found pine/passcpde added");
		
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(fail, "Pin/passcode text box not found");
		}

		WebElement DoneKeyboardButton = xpath.DoneKeyboardButton();
		Thread.sleep(3000);
		if (DoneKeyboardButton != null && DoneKeyboardButton.isEnabled()) {
			DoneKeyboardButton.click();
			iOSLogs.CapturedLogs(pass, "Done Button is found and clicked");
		} else {
			iOSLogs.CapturedLogs(info, "Done button not found");
		}

		WebElement CardLoginButton = xpath.CardLoginButton();
		Thread.sleep(3000);
		if (CardLoginButton  != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed");

		} else {
			iOSLogs.CapturedLogs(fail, "Login Buttonfor not found");
		}
	}
}
