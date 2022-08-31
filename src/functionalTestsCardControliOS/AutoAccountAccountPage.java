package functionalTestsCardControliOS;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.AccountPage;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CardLoginACH;
import iOSCardClasses.CardLoginPassCode;
import iOSCardClasses.CardLoginPassSecureFuel;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.GetACard;
import iOSCardClasses.HomeLandingPage;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.UnitTestMultiCardDelete;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountAccountPage {
	static AppiumDriver<WebElement> driver;
	private String cardNum;	
	private String cardType;
	
	@Test
	public void cardControlTestiOS() throws Exception {
		//private String testType = "System Test";
				//String testType = "QuickLoginLogoutRun";
				//String buildNum = "5.0.0";
				//TestSetup testSetup = new TestSetup(testType, buildNum);

		Logs iOSLogs = new Logs();
		LogoutCardControl Logout = new LogoutCardControl();
		AppStringsiOS iOSText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		BiometricsiOS Biometric = new BiometricsiOS();
		MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
		CardDirectLoginPass card6344 = new CardDirectLoginPass();
		CardLoginPassSecureFuel card0561 = new CardLoginPassSecureFuel();
		CardLoginPassCode card5542 = new CardLoginPassCode();
		CardLoginACH card2800 = new CardLoginACH();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AccountPage openAccount = new AccountPage();
		UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

		
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		String env;
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		String appName = "Card Control";
		
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		
		
		try {
			
			AutoAccountSelector getAccount = new AutoAccountSelector();
			CreateProfile profileSetup = new CreateProfile();
			HomeLandingPage homePage = new HomeLandingPage();
			AccountPage accountPage = new AccountPage();
			CreatePasscode createPasscode = new CreatePasscode();
			
			
			iOSLogs.setupTest("Account Page tests");
			iOSLogs.setupTestYellow("COMPANY CARD");
			cardType = "COMPANY";
			getAccount.setEnv(env);
			getAccount.CardPassExpected(cardType);	
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.environmentPickerButton();
			autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//			multiCardLogin.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometric.BiometricsiOS();
			profileSetup.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
			accountPage.openProfileButtonFromHome(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
			
			iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			//SMARTFUNDS CARD
			Thread.sleep(3000);
			iOSLogs.setupTestYellow("SMARTFUNDS CARD");
			cardType = "SMARTFUNDS";
			getAccount.setEnv(env);
			getAccount.CardPassExpected(cardType);			
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.environmentPickerButton();
			autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
	//		multiCardLogin.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometric.BiometricsiOS();
			profileSetup.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
			accountPage.openProfileButtonFromHome(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
		
			iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
						
			
			//UNIVERSAL CARD
			Thread.sleep(3000);
			iOSLogs.setupTestYellow("UNIVERSAL CARD");
			cardType = "UNIVERSAL";
			getAccount.setEnv(env);
			getAccount.CardPassExpected(cardType);
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.environmentPickerButton();
			autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//			multiCardLogin.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometric.BiometricsiOS();
			
			profileSetup.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
			accountPage.openProfileButtonFromHome(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
			
			iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			//PASSCODE Card (this comes from turning on dynamic pin)
			Thread.sleep(3000);
			iOSLogs.setupTestYellow("PASSCODE CARD");
			cardType = "PASSCODE";
			getAccount.setEnv(env);
			getAccount.CardPassExpected(cardType);
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.environmentPickerButton();
			autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//			multiCardLogin.MultiCardLoginCheck();
			//Delete passcode in database 
			System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getAccountNum()+"'");
			//login with temp passcode 
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			
			
			//Login with newly set card passcode
			Biometric.BiometricsiOS();
			createPasscode.NewPasscode(env);
			profileSetup.ProfileSetup(env);
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
			accountPage.openProfileButtonFromHome(env, getAccount.getAccountNum(), iOSText.MANUAL_PASSCODE);
		
			iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
//TODO add a fleet one card also...
			

			
			iOSLogs.CapturedLogs(info, "Account Page test completed");
		
		} catch (Exception exp) {String errorMessage = exp.getMessage();
			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);
			} else {
				System.out.println("Error is: " + errorMessage);
			}
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				iOSLogs.CapturedLogs(fail, errorMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: "+ cardNum);
	}


	public String getCardNum() {
		System.out.println("GET Card number: "+ cardNum);
		return cardNum;
	}
}