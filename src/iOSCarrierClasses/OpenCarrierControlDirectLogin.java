package iOSCarrierClasses;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class OpenCarrierControlDirectLogin {
	
	 		AppiumDriver<WebElement> driver;	
//smartfunds login
			// static WebDriver driverWeb;
	 		String appName = "Carrier Control";
			public void openCarrierControl () throws Exception {
	
								
				Sleep appSleep = new Sleep();
				Logs iOSLogs = new Logs();
				PhonePicker phone = new PhonePicker();
				CarrierDirectLoginPass CarrierDirectLogin = new CarrierDirectLoginPass();
				WelcomeScreeniOS welcome = new WelcomeScreeniOS();
				AccountsTab accountsTab = new AccountsTab();
				CardsTab cardsTab = new CardsTab();
				RejectsTab transactionTab = new RejectsTab();
				MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
				CardsOverviewUniversaliOS cardsOverview = new CardsOverviewUniversaliOS();
				AppStringsiOS iOSText = new AppStringsiOS();
				BiometricsiOS Biometric = new BiometricsiOS();
				EnvironmentPicker environmentPicker = new EnvironmentPicker();
				ResetTestAccounts ResetTestAccounts = new ResetTestAccounts();
				
			//	PreferredContactMethodCheck PreferredTokenCheck = new PreferredContactMethodCheck();
			//	FaceIDCheck FaceIDModal = new FaceIDCheck();
				
				System.out.println(phone.autoPhonePickerCarrier(appName));
				
				iOSLogs.CapturedLogs("--Carrier Control--", "--App testing Logs started--");
				appSleep.ThreadSleep3000();
				
							
				//Make sure all account are ready for testing prior to staring 
				ResetTestAccounts.ResetAllAccounts();	
				
				//closes welcome screen needs some work.... Figgure our swipe.
				//welcome.welomeScreen();
				
				
				environmentPicker.environmentPickerButtonCarrier();
																		
				//App is given good login details and logs in successfully. 
				CarrierDirectLogin.CarrierPassExpected();
			
				//check if biometrics is seen and close it.
				Biometric.BiometricsiOS();
				//Make sure Face ID if seen is closed before testing.
				//FaceIDModal.FaceIdModal();
				
				moneyCodesTab.moneyCodesTab();
				cardsTab.cardsTab();
				cardsOverview.CardsOverview();
//				transactionTab.transactionsTab(); //TODO needs debugging works on android
//				iOSLogs.setupTest("This account is unable to test billing--");
				accountsTab.accountsTab();
				
				//LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
				//Logout.logOutCarrierControll();
}


}
