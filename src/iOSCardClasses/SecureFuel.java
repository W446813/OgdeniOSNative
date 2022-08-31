package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class SecureFuel {
	
	
private String env;
private String unitID;


	
	public void secureFuel(String env, String unitID) throws Exception {
		this.env = env;
		this.unitID = unitID;
		System.out.println("I am in login fail environment is:" + env);
		secureFuel();
	}

	
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements=new RepoCardiOS();
	
	
	public SecureFuel secureFuel() throws Exception {
		iOSText = new AppStringsiOS(env);
		iOSLogs.setupTest("Secure Fuel Test");
		Thread.sleep(3000);
		WebElement FuelCheckInButton = elements.FuelCheckInButton();
		Thread.sleep(3000);
		if (FuelCheckInButton != null && FuelCheckInButton.isEnabled()) {
			FuelCheckInButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Fuel check in button clicked");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Fuel check in button not found");
		}
		
		Thread.sleep(2000);
		WebElement UnitNumberTextBox = elements.UnitNumberTextBox();
		Thread.sleep(3000);
		if (UnitNumberTextBox != null && UnitNumberTextBox.isEnabled()) {
			//UnitNumberTextBox.click();
			UnitNumberTextBox.sendKeys(unitID);
			iOSLogs.CapturedLogs(iOSText.PASS, "Unit number textbox filled");
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Unit number text box not found or is not supposed to be on this account");
		}
		
		Thread.sleep(3000);
		WebElement CheckInButton = elements.CheckInButton();
		Thread.sleep(3000);
		if (CheckInButton != null && CheckInButton.isEnabled()) {
			CheckInButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Check in button clicked");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Check in button not found");
		}
		
		Thread.sleep(3000);
		iOSLogs.CapturedLogs(iOSText.INFO, "Allow location does not show on screen capture");
		WebElement AllowLocationModal = elements.AllowLocationModal();
		Thread.sleep(3000);
		if (AllowLocationModal != null && AllowLocationModal.isEnabled()) {
			AllowLocationModal.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Allow location button clicked");
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Allow location button not found or previously selected");
		}
		
		Thread.sleep(15000);
		WebElement DismissFuelCheckinButton = elements.DismissFuelCheckinButton();
		Thread.sleep(3000);
		if (DismissFuelCheckinButton != null && DismissFuelCheckinButton.isEnabled()) {
			DismissFuelCheckinButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Dismiss button clicked");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Dismiss button not found");
		}
		
		Thread.sleep(2000);
		return this;
	}
}
