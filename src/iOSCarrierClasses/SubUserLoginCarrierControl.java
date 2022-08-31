package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;

//similar to LoginSubUserCC

//import io.appium.java_client.AppiumDriver;

public class SubUserLoginCarrierControl {
	public SubUserLoginCarrierControl() {
	}

	// AppiumDriver<WebElement> driver;

	// static WebDriver driverWeb;

	public void CarrierPassExpected() throws Exception {

		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCarrieriOS elements = new RepoCarrieriOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		iOSLogs.setupTest("Login Testing on 102698db");
		Thread.sleep(5000);
		
		WebElement CarrierNumberTextbox = elements.CarrierNumberTextbox();
		Thread.sleep(3000);
		if (CarrierNumberTextbox != null && CarrierNumberTextbox.isDisplayed()) {
			CarrierNumberTextbox.click();
			CarrierNumberTextbox.clear();
			CarrierNumberTextbox.sendKeys(iOSText.CARRIER_LOGIN_ID_SUB_USER);
			iOSLogs.CapturedLogs(pass, "Carrier Number entered.");
		} else {
			iOSLogs.CapturedLogs(fail, "Carrier Number text box is not found");
		}

		
		WebElement PasswordTextbox = elements.PasswordTextbox();
		Thread.sleep(3000);
		
		if (PasswordTextbox != null && PasswordTextbox.isDisplayed()) {
			PasswordTextbox.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_SUB_USER);
			iOSLogs.CapturedLogs(pass, "Password entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Password text box is not found");
		}

		
		WebElement LoginButton = elements.LoginButton();
		Thread.sleep(3000);
		
		if (LoginButton != null && LoginButton.isEnabled()) {
			LoginButton.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button is not found");
		}

		Thread.sleep(2000);
	}

}
