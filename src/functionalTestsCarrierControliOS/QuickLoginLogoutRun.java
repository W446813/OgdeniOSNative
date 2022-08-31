package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCarrierClasses.CarrierDirectLoginPass;
import iOSCarrierClasses.LoginCompanyCC;
import iOSCarrierClasses.LoginUniversalCC;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.SubUserLoginCarrierControl;
import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class QuickLoginLogoutRun {
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
		SubUserLoginCarrierControl subUserLogin = new SubUserLoginCarrierControl();
		CarrierDirectLoginPass CarrierDirectLogin = new CarrierDirectLoginPass();
		LoginUniversalCC loginUniversal = new LoginUniversalCC();
		LoginCompanyCC companyLogin = new LoginCompanyCC();
		String appName = "Carrier Control";
		
		try {
			iOSLogs.setupTest("Quick Login Logout Funtional Test");
			
			//102698db
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			subUserLogin.CarrierPassExpected();
			Biometric.BiometricsiOS();	
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out of 102698db");
			
			//100045
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			CarrierDirectLogin.CarrierPassExpected();
			Biometric.BiometricsiOS();	
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out of 100045");
			
			//129698
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			loginUniversal.CarrierPassExpected();
			Biometric.BiometricsiOS();	
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out of 129698");
			
			//103526
			System.out.println(phone.autoPhonePickerCarrier(appName));
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			companyLogin.CarrierPassExpected();
			Biometric.BiometricsiOS();	
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out of 103526");
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Quick Login Logout Functional Test completed");
			
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