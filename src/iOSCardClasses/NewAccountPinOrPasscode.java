package iOSCardClasses;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class NewAccountPinOrPasscode {

	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS elements = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	String cardNum;
	String oldPin;
	String env;
	
	public NewAccountPinOrPasscode NewPasscodeOrPin(String enviroment, String cardNumber, String passOrPin) throws Exception {
		this.env = enviroment;
		this.cardNum = cardNumber;
		this.oldPin = passOrPin;
		
		try { 
		Thread.sleep(3000);
		WebElement CreateAPasscodePage = elements.CreateAPasscodePage();
		Thread.sleep(3000);
		if (CreateAPasscodePage != null && CreateAPasscodePage.isEnabled()) {
			iOSLogs.CapturedLogs(info, "Create passcode page found and opened");	
			
			Thread.sleep(3000);
		WebElement NewPasscodeTextbox = elements.NewPasscodeTextbox();
		 Thread.sleep(2000);
		if (NewPasscodeTextbox != null && NewPasscodeTextbox.isEnabled()) {
			NewPasscodeTextbox.click();
			NewPasscodeTextbox.sendKeys(iOSText.MANUAL_PASSCODE);
			iOSLogs.CapturedLogs(pass, "New passcocde textbox found and filled in");
		} else {
			iOSLogs.CapturedLogs(fail, "New passcocde textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement ConfirmPasscodeTextbox = elements.ConfirmPasscodeTextbox();
		 Thread.sleep(2000);
		if (ConfirmPasscodeTextbox != null && ConfirmPasscodeTextbox.isEnabled()) {
			ConfirmPasscodeTextbox.click();
			ConfirmPasscodeTextbox.sendKeys(iOSText.MANUAL_PASSCODE);
			iOSLogs.CapturedLogs(pass, "Confirm passcocde textbox found and filled in");
		} else {
			iOSLogs.CapturedLogs(fail, "Confirm passcocde textbox not found");
		}
		Thread.sleep(3000);
		WebElement NextButton = elements.NextButton();
		 Thread.sleep(2000);
		if (NextButton != null && NextButton.isEnabled()) {
			NextButton.click();
			iOSLogs.CapturedLogs(pass, "Next Button found and selected");
		} else {
			iOSLogs.CapturedLogs(fail, "Next Button not found");
		}
		
	
		} else {
			iOSLogs.CapturedLogs(info, "Create passcode page not seen might already be setup");
	}
		
		
		Thread.sleep(3000);
		WebElement CreateAPinPage = elements.CreateAPinPage();
		Thread.sleep(3000);
		if (CreateAPinPage != null && CreateAPinPage.isEnabled()) {
			iOSLogs.CapturedLogs(info, "Create PIN page found and opened");	
			
		Thread.sleep(3000);
		WebElement NewPinTextbox = elements.NewPinTextbox();
		 Thread.sleep(2000);
		if (NewPinTextbox != null && NewPinTextbox.isEnabled()) {
			NewPinTextbox.click();
			NewPinTextbox.sendKeys(oldPin);
			iOSLogs.CapturedLogs(pass, "New PIN textbox found and filled in");
		} else {
			iOSLogs.CapturedLogs(fail, "New PIN textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement ConfirmPinTextbox = elements.ConfirmPinTextbox();
		 Thread.sleep(2000);
		if (ConfirmPinTextbox != null && ConfirmPinTextbox.isEnabled()) {
			ConfirmPinTextbox.click();
			ConfirmPinTextbox.sendKeys(oldPin);
			iOSLogs.CapturedLogs(pass, "Confirm PIN textbox found and filled in");
		} else {
			iOSLogs.CapturedLogs(fail, "Confirm PIN textbox not found");
		}
		Thread.sleep(3000);
		WebElement NextButton = elements.NextButton();
		 Thread.sleep(2000);
		if (NextButton != null && NextButton.isEnabled()) {
			NextButton.click();
			iOSLogs.CapturedLogs(pass, "Next Button found and selected");
		} else {
			iOSLogs.CapturedLogs(fail, "Next Button not found");
		}
		
	
		} else {
			iOSLogs.CapturedLogs(info, "Create PIN page not seen might already be setup");
		}
		
		
		
		} catch (Exception exp) {String errorMessage = exp.getMessage();
		if (errorMessage == null) {
			errorMessage = exp.toString();
			System.out.println("Error is: " + errorMessage);
		} else {
			System.out.println("Error is: " + errorMessage);
		}
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
		try {
			iOSLogs.CapturedLogs(fail, errorMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
		
		

		return this;
	}
}
