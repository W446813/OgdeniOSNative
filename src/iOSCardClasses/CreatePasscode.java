package iOSCardClasses;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class CreatePasscode {

	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements = new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	LogoutCardControl Logout = new LogoutCardControl();
	CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	
	public CreatePasscode NewPasscode(String enviroment) throws Exception {

		Thread.sleep(3000);
		WebElement CreateAPasscodePage = elements.CreateAPasscodePage();
		Thread.sleep(3000);
		if (CreateAPasscodePage != null && CreateAPasscodePage.isEnabled()) {
			iOSLogs.CapturedLogs(info, "Create passcode page found and opened");	
			
		Thread.sleep(3000);
		WebElement NewPasscodeTextbox = elements.NewPasscodeTextbox();
		Thread.sleep(3000);
		if (NewPasscodeTextbox != null && NewPasscodeTextbox.isEnabled()) {
			NewPasscodeTextbox.click();
			NewPasscodeTextbox.sendKeys(iOSText.MANUAL_PASSCODE);
			iOSLogs.CapturedLogs(pass, "New passcocde textbox found and filled in");
		} else {
			iOSLogs.CapturedLogs(fail, "New passcocde textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement ConfirmPasscodeTextbox = elements.ConfirmPasscodeTextbox();
		Thread.sleep(3000);
		if (ConfirmPasscodeTextbox != null && ConfirmPasscodeTextbox.isEnabled()) {
			ConfirmPasscodeTextbox.click();
			ConfirmPasscodeTextbox.sendKeys(iOSText.MANUAL_PASSCODE);
			iOSLogs.CapturedLogs(pass, "Confirm passcocde textbox found and filled in");
		} else {
			iOSLogs.CapturedLogs(fail, "Confirm passcocde textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement NextButton = elements.NextButton();
		Thread.sleep(3000);
		if (NextButton != null && NextButton.isEnabled()) {
			NextButton.click();
			iOSLogs.CapturedLogs(pass, "Next Button found and selected");
		} else {
			iOSLogs.CapturedLogs(fail, "Next Button not found");
		}
		
	
		} else {
			iOSLogs.CapturedLogs(info, "Create passcode page not seen might already be setup");
		}
		
		
		
		

		return this;
	}
}
