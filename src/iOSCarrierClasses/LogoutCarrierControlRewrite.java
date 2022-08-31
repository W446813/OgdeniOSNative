package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class LogoutCarrierControlRewrite {

	Sleep appSleep = new Sleep();
	Logs iOSLogs = new Logs();
	Wait appWait = new Wait();
	AppStringsiOS cardControlNumber = new AppStringsiOS();
	InputText appText = new InputText();
	RepoCarrieriOS xpath = new RepoCarrieriOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	public LogoutCarrierControlRewrite logOutCarrierControll() throws Exception {
		iOSLogs.setupTest("Logout test");
				
		Thread.sleep(5000);
		if (xpath.accountsTab().isEnabled()) {
			xpath.accountsTab().click();
			iOSLogs.CapturedLogs(pass, "accounts Tab is opened.");
		} else {
			iOSLogs.CapturedLogs(fail, "accounts Tab was not found.");
		}
		
		Thread.sleep(3000);
		WebElement LogoutButton = xpath.LogoutButton();
		if (LogoutButton!=null && LogoutButton.isEnabled()) {
			LogoutButton.click();
			iOSLogs.CapturedLogs(pass, "Logout Button selected");
		} else {
			iOSLogs.CapturedLogs(fail, "Logout Button is not found");

		}

		Thread.sleep(3000);
		WebElement LogoutModalCancelButton = xpath.LogoutModalCancelButton();
		if (LogoutModalCancelButton != null && LogoutModalCancelButton.isEnabled()) {
			LogoutModalCancelButton.click();
			iOSLogs.CapturedLogs(pass, "Logout Modal cancel Button selected.");
		} else {
			iOSLogs.CapturedLogs(fail, "Logout Modal cancel Button is not found");
		}

		Thread.sleep(3000);
		WebElement LogoutButton2 = xpath.LogoutButton();
		if (LogoutButton2!=null && LogoutButton2.isEnabled()) {
			LogoutButton2.click();
			iOSLogs.CapturedLogs(pass, "Logout Button selected.");
		} else {
			iOSLogs.CapturedLogs(fail, "Logout Button is not found");
		}
		
		Thread.sleep(3000);
		WebElement LogoutModalLogoutButton = xpath.LogoutModalLogoutButton();
		if (LogoutModalLogoutButton!=null && LogoutModalLogoutButton.isEnabled()) {
			LogoutModalLogoutButton.click();
			iOSLogs.CapturedLogs(pass, "Logout Modal Button selected.");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
		} else {
			iOSLogs.CapturedLogs(fail, "Logout Modal Button not found.");
		}
		return this;

	}
}
