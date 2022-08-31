package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCarrierClasses.AccountTabManageYourProfile;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.RepoCarrieriOS;
import iOSCarrierClasses.SubUserLoginCarrierControl;
import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class ManageYourProfileRun {
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
		RepoCarrieriOS elements = new RepoCarrieriOS();
		AccountTabManageYourProfile manageYourProfile = new AccountTabManageYourProfile();
		String appName = "Carrier Control";
		
		try {
			System.out.println(phone.autoPhonePickerCarrier(appName));
			
			iOSLogs.setupTest("Manage your profile run Funtional Test");
		
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			
			subUserLogin.CarrierPassExpected();
			
			Biometric.BiometricsiOS();
			
			Thread.sleep(3000);
			iOSLogs.setupTest("Manage your profile ");
			WebElement accountsTab = elements.accountsTab();
			if (accountsTab.isEnabled()) {
				Thread.sleep(3000);
				accountsTab.click();
				iOSLogs.CapturedLogs(iOSText.PASS, "accounts Tab is opened.");
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "accounts Tab was not found.");
			}

			WebElement ManageYourProfile = elements.ManageYourProfile();
			if (ManageYourProfile != null && ManageYourProfile.isEnabled()) {
				ManageYourProfile.click();

//This section tests and updated the profile name and details if it fails it puts the wrong info on the account Skipping probably should be done manually... 		
//Manage your profile
//				manageYourProfile.AccountTabManageYourProfile();

			} else {
				iOSLogs.CapturedLogs(iOSText.INFO, "Manage your profile not found or is not a role in this account.");

			}
			
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Manage your profile run Functional Test completed");
			
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