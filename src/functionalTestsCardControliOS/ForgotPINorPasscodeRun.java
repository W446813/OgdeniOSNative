package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.ForgotPINorPasscode;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class ForgotPINorPasscodeRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;
String appName = "Card Control";

@Test
public void cardControlTestiOS() {
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	ForgotPINorPasscode passcodeReset = new ForgotPINorPasscode();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	LogoutCardControl logout = new LogoutCardControl();
	
	try {
		
		System.out.println(phone.autoPhonePickerCard(appName));
		iOSLogs.setupTest("Forgot PIN or Passcode functional test");
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		Thread.sleep(3000);
		setCardNum("5542");
		passcodeReset.ForgotPINorPasscode(environmentPicker.getEnviroment(), this.cardNum);
		Biometric.BiometricsiOS();
		
		logout.LogoutCardControl();
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
		
		
		
		iOSLogs.CapturedLogs(iOSText.INFO, "Forgot PIN or Passcode functional test completed");
		
		
		
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
public void setCardNum(String cardNumNow) {
	this.cardNum = cardNumNow;
	System.out.println("SET Card Number: "+ cardNum);
}


public String getCardNum() {
	System.out.println("GET Card number: "+ cardNum);
	return cardNum;
}
}