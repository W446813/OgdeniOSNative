package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class InformationIcon {
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements=new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText=new AppStringsiOS();
	
	public InformationIcon InformationIcon() throws Exception {
		
		iOSLogs.setupTest("Info Icon and Show Hide Passode test");
		Thread.sleep(5000);
		//Click information icon
		WebElement InformationIcon = elements.InformationIcon();
		if (InformationIcon != null && InformationIcon.isEnabled()) {
			InformationIcon.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Information Icon clicked and opened");
			
			//Click done to close Find your card number
			Thread.sleep(5000);
			WebElement InformationIconDoneButton = elements.InformationIconDoneButton();
			if (InformationIconDoneButton != null && InformationIconDoneButton.isEnabled()) {
				InformationIconDoneButton.click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Information Icon Done button found and clicked");
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Information Icon Done button not found");
			}
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Information Icon not found");
		}
		
		Thread.sleep(2000);
		WebElement ShowHidePINPasscodeIcon = elements.ShowHidePINPasscodeIcon();
		if (ShowHidePINPasscodeIcon != null && ShowHidePINPasscodeIcon.isEnabled()) {
			ShowHidePINPasscodeIcon.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Show/Hide PIN passcode clicked");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Show/Hide PIN passcode not found");
		}
		Thread.sleep(2000);
		return this;
	}

}
