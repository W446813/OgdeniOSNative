package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCarrierClasses.CarrierDirectLoginPass;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.RejectsTab;
import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class RejectsTabRun{
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
		RejectsTab rejectsTab = new RejectsTab();
		String appName = "Carrier Control";
		
		try {
			System.out.println(phone.autoPhonePickerCarrier(appName));
			
			iOSLogs.setupTest("Rejects Tab Funtional Test");
			
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			
			CarrierDirectLogin.CarrierPassExpected();
			
			Biometric.BiometricsiOS();
			
			rejectsTab.rejectsTab();
			
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Rejects Tab Functional Test completed");
			
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