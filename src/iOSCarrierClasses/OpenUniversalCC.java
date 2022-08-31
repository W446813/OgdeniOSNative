package iOSCarrierClasses;


import org.openqa.selenium.WebElement;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class OpenUniversalCC {

	static AppiumDriver<WebElement> driver;

	public static void openCarrierControl() throws Exception {
		String appName = "Carrier Control";
		Sleep appSleep = new Sleep();
		Logs iOSLogs = new Logs();
		PhonePicker phone = new PhonePicker();
		LoginUniversalCC loginUniversal = new LoginUniversalCC();
		AccountsTab accountTab = new AccountsTab();
		CardsTabUniversal cardsTabUniversal = new CardsTabUniversal();
		RejectsTab transactionTab = new RejectsTab();
		BillingTab paymentTab = new BillingTab();
		MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		WelcomeScreeniOS welcome = new WelcomeScreeniOS();
		BiometricsiOS Biometric = new BiometricsiOS();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		
		System.out.println(phone.autoPhonePickerCarrier(appName));
		
		iOSLogs.CapturedLogs("--Carrier Control--", "--App testing Logs started--");
		appSleep.ThreadSleep3000();
			
		//Make sure all account are ready for testing prior to staring 
		//ResetTestAccounts.ResetAllAccounts(); 
		
		//closes welcome screen needs some work.... Figgure our swipe.
		welcome.welomeScreen();
				
		
		environmentPicker.environmentPickerButtonCarrier();
		
		//Automation is given good login details and logs in successfully. 
		loginUniversal.CarrierPassExpected();
		//close biometrics if seen
		Biometric.BiometricsiOS();
		//Automation begins tab section testing. 
		moneyCodesTab.moneyCodesTab();
		//Fix money code max issue.....
		cardsTabUniversal.CardsTabUniversal();
		//iOSLogs.setupTest("This account is unable to test transactions per loading time"); 
		transactionTab.rejectsTab();

//TODO add new billing error exception handling IE unicorn setup so just open an AR Press back and move on.		
		iOSLogs.setupTest("This account is unable to test Billing per loading time"); 
		//paymentTab.BillingTab();
		accountTab.accountsTab();
		
		//LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
		//Logout.logOutCarrierControll();
	}
}
