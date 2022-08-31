package iOSCarrierClasses;



import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class OpenSubUserCarrierControl {
	
	 		static AppiumDriver<WebElement> driver;	

			// static WebDriver driverWeb;


			public void openCarrierControl() throws Exception  {
				String appName = "Carrier Control";
				Sleep appSleep = new Sleep();
				Logs iOSLogs = new Logs();
				PhonePicker phone = new PhonePicker();
				SubUserLoginCarrierControl subUserLogin = new SubUserLoginCarrierControl();
				WelcomeScreeniOS welcome = new WelcomeScreeniOS();
				AccountsTab accountsTab = new AccountsTab();
			//	CardsTab cardsTab = new CardsTab();
			//	TransactionsTab transactionTab = new TransactionsTab();
				BillingTab BillingTab = new BillingTab();
				MoneyCodesTab moneyCodesTab = new MoneyCodesTab();
				AccountTransferToYourBankAddAccountiOS addBankAccount = new AccountTransferToYourBankAddAccountiOS();
				CardsOverviewSmartfunds cardOverview=new CardsOverviewSmartfunds();
				AppStringsiOS iOSText = new AppStringsiOS();
				FaceIDCheck FaceIDModal = new FaceIDCheck();
				BiometricsiOS Biometric = new BiometricsiOS();
				EnvironmentPicker environmentPicker = new EnvironmentPicker();
				ResetTestAccounts ResetTestAccounts = new ResetTestAccounts();
				
				System.out.println(phone.autoPhonePickerCarrier(appName));
				iOSLogs.setupTest("Account setup test logs for 102698db");
				iOSLogs.CapturedLogs(iOSText.INFO, "----Test starting on 102698db starting----");
				appSleep.ThreadSleep3000();
				
				//Make sure Face ID if seen is closed before testing.
				FaceIDModal.FaceIdModal();
				
				//Make sure all account are ready for testing prior to staring 
				ResetTestAccounts.ResetAllAccounts();	

				
				environmentPicker.environmentPickerButtonCarrier();
				
				welcome.welomeScreen();
				subUserLogin.CarrierPassExpected();
				Biometric.BiometricsiOS();
				moneyCodesTab.moneyCodesTab();
				iOSLogs.setupTest("This account is unable to test Cards tab");
//				//cardsTab.cardsTab();
				cardOverview.CardsOverviewSubuser();
				iOSLogs.setupTest("This account is unable to test Transactions to many to search");
//				//transactionTab.transactionsTab();
				BillingTab.BillingTab();
				addBankAccount.accountTransferToYourBankAddAccount();
				accountsTab.accountsTab();

//				LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
//				Logout.logOutCarrierControll();

			}
}
