package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;

public class CardDirectLoginPass {
	public CardDirectLoginPass() {
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
		System.out.println("I am in card pass expected environment is:" + environment);
		CardPassExpected();
	}
	
	
	
	

	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	

	public void CardPassExpected() throws Exception {
		iOSText = new AppStringsiOS(env);
		Logs iOSLogs = new Logs();
		RepoCardiOS elements = new RepoCardiOS();
	

		

		iOSLogs.setupTest("Login Testing for " +cardType);
		iOSLogs.CapturedLogs(info, "Login Pass Expected Testing started.");
		iOSLogs.CapturedLogs(pass, "Login Pass Verification started succesfully.");
		
		Thread.sleep(3000);
		WebElement CardNumberTextBox = elements.CardNumberTextBox();
		Thread.sleep(3000);
		if (CardNumberTextBox != null && CardNumberTextBox.isEnabled()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(cardNum);

			iOSLogs.CapturedLogs(pass, "Card Number entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Card Number text box 6344 is not found");
		}

		Thread.sleep(3000);
		// Find the login Password text box tell if find or fail.
		Thread.sleep(3000);
		WebElement PinPassTextBox = elements.PinPassTextBox();
		Thread.sleep(3000);
		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.sendKeys(passwordOrPin);
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(fail, "Pin/passcode for 6344 text box is not found");
		}
		Thread.sleep(3000);
		WebElement DoneKeyboardButton = elements.DoneKeyboardButton();
		Thread.sleep(3000);
		if (DoneKeyboardButton != null && DoneKeyboardButton.isEnabled()) {
			DoneKeyboardButton.click();
			iOSLogs.CapturedLogs(pass, "Done Button Pressed");
		} else {
			iOSLogs.CapturedLogs(info, "Done button not found");
		}
		Thread.sleep(3000);
		WebElement CardLoginButton = elements.CardLoginButton();
		Thread.sleep(3000);
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();

			iOSLogs.CapturedLogs(pass, "Login Button Pressed");

		} else {
			iOSLogs.CapturedLogs(fail, "Login Button is not found");
		}

	}

}
