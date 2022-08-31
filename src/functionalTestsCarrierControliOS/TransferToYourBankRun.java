package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCarrierClasses.AccountTransferToYourBankAddAccountiOS;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.SubUserLoginCarrierControl;
import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class TransferToYourBankRun {
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
		AccountTransferToYourBankAddAccountiOS addBankAccount = new AccountTransferToYourBankAddAccountiOS();
		String appName = "Carrier Control";
		
		try {
			System.out.println(phone.autoPhonePickerCarrier(appName));
			
			iOSLogs.setupTest("Transfer To your bank Funtional Test");
			
			environmentPicker.environmentPickerButtonCarrier();
			welcome.welomeScreen();
			
			subUserLogin.CarrierPassExpected();
			
			Biometric.BiometricsiOS();
			
			addBankAccount.accountTransferToYourBankAddAccount();
			
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Transfer to your bank Functional Test completed");
			
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