package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;

//import io.appium.java_client.AppiumDriver;

public class CarrierDirectLoginPass {
	public CarrierDirectLoginPass() {
	}

	public void CarrierPassExpected() throws Exception {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCarrieriOS elements = new RepoCarrieriOS();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		iOSLogs.setupTest("Login Pass on 100045");
		Thread.sleep(5000);
				
		WebElement CarrierNumberTextbox = elements.CarrierNumberTextbox();
		Thread.sleep(3000);
		if (CarrierNumberTextbox != null && CarrierNumberTextbox.isDisplayed()) {
			CarrierNumberTextbox.click();
			CarrierNumberTextbox.clear();
			CarrierNumberTextbox.sendKeys(iOSText.CARRIER_LOGIN_ID_SMARTFUNDS);
			iOSLogs.CapturedLogs(pass, "Carrier Number entered.");
		} else {
			iOSLogs.CapturedLogs(fail, "Carrier Number text box is not found");
		}
		
		WebElement PasswordTextbox = elements.PasswordTextbox();
		Thread.sleep(2000);
		if (PasswordTextbox != null && PasswordTextbox.isDisplayed()) {
			PasswordTextbox.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS);
			iOSLogs.CapturedLogs(pass, "Password entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Password text box is not found");
		}
		
		WebElement LoginButton = elements.LoginButton();
		Thread.sleep(2000);
		if (LoginButton != null && LoginButton.isEnabled()) {
			LoginButton.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button is not found");
		}
		Thread.sleep(2000);

//					//Close facial reg software modal with cancel click. needs some work.
//					try {
//						WebElement facialReg = Capabilities.driver.findElementByXPath(appText.facialReg());			
//						facialReg.click();
//						keepThisLog.CapturedLogs("Test Info", "Face ID Modal is now closed or canceled");
//
//					} catch (Exception exp) {
//						keepThisLog.CapturedLogs("Test Info", "Face ID Modal was already closed or canceled on a prior run");
//					}
//					
//					
//					//Close facial reg software modal with Don't allow click. Needs some work...
//						try {
//						WebElement faceIDAllow = Capabilities.driver.findElementByXPath(appText.faceIDAllow());
//						faceIDAllow.click();
//						keepThisLog.CapturedLogs("Test Info", "Face ID Allow modal is closed Don't allow was selected");
//
//						}catch (Exception exp) {
//							keepThisLog.CapturedLogs("Test Info", "Face ID Allow modal was already closed or canceled on a prior run");
//						}
//					
//					
//					//Close touch ID reg software modal with Don't allow click.
//						try {
//						WebElement touchIDCancel = Capabilities.driver.findElementByXPath(appText.touchIDCancel());	
//						touchIDCancel.click();
//						keepThisLog.CapturedLogs("Test Info", "Touch ID Cancel Modal is closed Cancel was selected");
//
//					} catch (Exception exp) {
//						keepThisLog.CapturedLogs("Test Info", "Touch ID Allow modal was already closed or canceled on a prior run");
//					}
	}

}
