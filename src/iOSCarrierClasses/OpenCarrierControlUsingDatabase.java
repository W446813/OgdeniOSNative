package iOSCarrierClasses;



import org.openqa.selenium.WebElement;

import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;


public class OpenCarrierControlUsingDatabase {
	
	 		AppiumDriver<WebElement> driver;	

			// static WebDriver driverWeb;

			public void openCarrierControl() throws Exception {
				String appName = "Carrier Control";
				Logs iOSLogs = new Logs();
				PhonePicker phone = new PhonePicker();
				CarrierLoginFailVerification CarrierfailLogin = new CarrierLoginFailVerification();
				CarrierLoginPassVerification CarrierpassLogin = new CarrierLoginPassVerification();
				FaceIDCheck FaceIDModal = new FaceIDCheck();
				BiometricsiOS Biometric = new BiometricsiOS();
				EnvironmentPicker environmentPicker = new EnvironmentPicker();
				ResetTestAccounts ResetTestAccounts = new ResetTestAccounts();
				AutoAccountSelector getAccount = new AutoAccountSelector();
			//	PreferredContactMethodCheck PreferredTokenCheck = new PreferredContactMethodCheck();
			
				
				System.out.println(phone.autoPhonePickerCarrier(appName));
				iOSLogs.setupTest("Carrier Login Logout testing");	
				Thread.sleep(3000);
				
			
				environmentPicker.environmentPickerButtonCarrier();
				getAccount.setEnv(environmentPicker.getEnviroment());
				FaceIDModal.FaceIdModal();
				
				//Make sure all account are ready for testing prior to staring 
				//ResetTestAccounts.ResetAllAccounts();				
				
				//App is given incorrect login details.
				CarrierfailLogin.CarrierFailExpected();
							
				//App is given a good card bad pin until the account is locked.
				CarrierfailLogin.CarrierLockedLoginExpected(environmentPicker.getEnviroment());
				
				//App is given an incorrect pint until the account is suspended. 
				CarrierfailLogin.CarrierSuspendedLoginExpected();
										
				//App is given good login details and logs in successfully. 
				CarrierpassLogin.CarrierPassExpected();
				Thread.sleep(3000);
				
				//check if biometrics modals is seen
				Biometric.BiometricsiOS();
													
			}

}
