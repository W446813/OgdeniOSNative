package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


import iOSCarrierClasses.AccountsTab;
import iOSCarrierClasses.CarrierDirectLoginPass;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class AccountTabRun  {
	static AppiumDriver<WebElement> driver;
	@Test
	public void carrierControlTestiOS() {
		Logs iOSLogs = new Logs();
		LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
		AppStringsiOS iOSText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
		WelcomeScreeniOS welcome = new WelcomeScreeniOS();
		BiometricsiOS Biometric = new BiometricsiOS();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CarrierDirectLoginPass CarrierDirectLogin = new CarrierDirectLoginPass();
		AccountsTab accountsTab = new AccountsTab();
		String appName = "Carrier Control";
		
		try {
			System.out.println(phone.autoPhonePickerCarrier(appName));
			
			iOSLogs.setupTest("Account Tab Funtional Test");
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			CarrierDirectLogin.CarrierPassExpected();
			Biometric.BiometricsiOS();
			accountsTab.accountsTab();
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Account Tab Functional Test completed");
			
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
				
				e.printStackTrace();
			}
			
		}
	  }	
	}