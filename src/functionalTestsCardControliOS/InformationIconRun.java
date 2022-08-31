package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.InformationIcon;
import iOSCardClasses.MultiCardLoginCheck;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class InformationIconRun {	
static AppiumDriver<WebElement> driver;
String appName = "Card Control";

@Test
public void cardControlTestiOS() {
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	InformationIcon infoIcon = new InformationIcon();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	
	try {
		
		System.out.println(phone.autoPhonePickerCard(appName));
		iOSLogs.setupTest("Information Icon functional test");
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		infoIcon.InformationIcon();

		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		iOSLogs.CapturedLogs(iOSText.INFO, "Information icon functional test completed");
		
		
		
	} catch (Exception exp) {
		String errorMessage = exp.getMessage();
		
		
		if (errorMessage == null) {
			errorMessage = exp.toString();
			System.out.println("Error is: " + errorMessage);
			
		}else {
			System.out.println("Error is: " + errorMessage);
		}
		
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
		
		try {
			iOSLogs.CapturedLogs(iOSText.FAIL, errorMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  }	
}