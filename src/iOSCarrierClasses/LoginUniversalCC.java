package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;

public class LoginUniversalCC {

	public LoginUniversalCC() {
	}

	public void CarrierPassExpected() throws Exception {

		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCarrieriOS elements = new RepoCarrieriOS();

		iOSLogs.setupTest("Login Testing on 129698");

		WebElement CarrierNumberTextbox = elements.CarrierNumberTextbox();
		if (CarrierNumberTextbox != null && CarrierNumberTextbox.isDisplayed()) {
			CarrierNumberTextbox.sendKeys(iOSText.CARRIER_LOGIN_ID_UNIVERSAL);
			iOSLogs.CapturedLogs(iOSText.PASS, "Carrier Number entered.");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Carrier Number text box is not found");
		}

		Thread.sleep(2000);
		WebElement PasswordTextbox = elements.PasswordTextbox();

		if (PasswordTextbox != null && PasswordTextbox.isDisplayed()) {
			PasswordTextbox.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_UNIVERSAL);
			iOSLogs.CapturedLogs(iOSText.PASS, "Password entered");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Password text box is not found");
		}

		Thread.sleep(2000);
		WebElement LoginButton = elements.LoginButton();
		if (LoginButton != null && LoginButton.isEnabled()) {
			LoginButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Login Button Pressed.");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Login Button is not found");
		}
		Thread.sleep(2000);
	}
}
