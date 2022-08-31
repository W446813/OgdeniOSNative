package iOSCarrierClasses;


import org.openqa.selenium.WebElement;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class OpenCompanyCC {

	static AppiumDriver<WebElement> driver;
	public static void openCarrierControl() throws Exception {
		String appName = "Carrier Control";
		Sleep appSleep = new Sleep();
		Logs logs = new Logs();
		PhonePicker phone = new PhonePicker();
		LoginCompanyCC companyLogin = new LoginCompanyCC();
		AccountsTab accountTab = new AccountsTab();
		RejectsTab transactionTab = new RejectsTab();
		BillingTab paymentTab = new BillingTab();
		MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
		WelcomeScreeniOS welcome = new WelcomeScreeniOS();
		CardsTabCompany companyCard = new CardsTabCompany();
		CardsOverviewCompany cardsOverview= new CardsOverviewCompany();
		BiometricsiOS Biometric = new BiometricsiOS();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		
		//LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
		
		System.out.println(phone.autoPhonePickerCarrier(appName));
		
		logs.CapturedLogs("--Carrier Control--", "--App testing Logs started--");
		appSleep.ThreadSleep3000();
			
		//Make sure all account are ready for testing prior to staring 
		//ResetTestAccounts.ResetAllAccounts(); 
		
		welcome.welomeScreen();
		
		environmentPicker.environmentPickerButton();
		
		//Automation is given good login details and logs in successfully. 
		companyLogin.CarrierPassExpected();
		//check if biometrics modal seen and close it
		Biometric.BiometricsiOS();
		//Automation begins tab section testing. 
		//moneyCodesTab.moneyCodesTab(); //does not support yet 
		companyCard.CardsTabCompamy();
		cardsOverview.CardsOverview();
		transactionTab.rejectsTab(); //transaction tab some times does not pull a transaction???
		//paymentTab.billingTab(); //Does not support yet
		accountTab.accountsTab();
		
		//Logout.logOutCarrierControll();
		
	}
}
