package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCardClasses.AccountPage;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.UnitTestMultiCardDelete;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.TestSetup;
import io.appium.java_client.AppiumDriver;

public class AutoAccountResetPinAndPasswordFromProfileRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;
private String cardType;

@Test
public void cardControlTestiOS() throws Exception{
//  private String testType = "System Test";
//	String testType = "ResetPinAndPasswordFromProfileRun";
//	String buildNum = "5.0.0";
//	TestSetup testSetup = new TestSetup(testType, buildNum);

	
	Logs iOSLogs = new Logs();
	LogoutCardControl Logout = new LogoutCardControl();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
//	ResetPinAndPasscodeFromProfilePage resetPinAndPasscodeFromProfile = new ResetPinAndPasscodeFromProfilePage();
	
//	CardLoginPassSecureFuel card0561 = new CardLoginPassSecureFuel();
//	CardLoginPassCode card5542 = new CardLoginPassCode();

	CardDirectLoginPass Login = new CardDirectLoginPass();
	//GetACard getACard = new GetACard();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	CreateProfile createProfile = new CreateProfile();
	CreatePasscode createPasscode = new CreatePasscode();
	CreateProfile profileSetup = new CreateProfile();
	AccountPage openAccount = new AccountPage();
	UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

		
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	String env;
	String appName = "Card Control";
	
	environmentPicker.SetEnvironment();
	env = environmentPicker.getEnviroment();
	
	ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		
		try {
		iOSLogs.setupTestYellow("Reset Pin And Password From Profile");
		iOSLogs.setupTestYellow("COMPANY CARD");
		getAccount.setEnv(env);
		getAccount.CardPassExpected("COMPANY");
		cardType = "COMPANY";
		
		System.out.println(phone.autoPhonePickerCard(appName));	
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(pass, "Logged out of 6344");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
	
		//6344 Pin Card
		//setCardNum("6344");
		iOSLogs.setupTestYellow("SMART FUNDS CARD");
		getAccount.setEnv(env);
		getAccount.CardPassExpected("SMARTFUNDS");
		cardType = "SMARTFUNDS";
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
//		getACard.CardPassExpected("6344");
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
//		card6344.CardPassExpected(env , this.cardNum);
		Biometric.BiometricsiOS();
		openAccount.openProfileButtonFromHome(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());	
		iOSLogs.CapturedLogs(pass, "Logged out of 6344");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();		
		
		//0561 Pin Card
		//setCardNum("0561");
		iOSLogs.setupTestYellow("COMPANY CARD");
		getAccount.setEnv(env);
		getAccount.CardPassExpected("COMPANY");
		cardType = "COMPANY";
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		//card0561.CardPassExpected(env);
		Biometric.BiometricsiOS();
//		openAccount.openProfileButtonFromHome(env, getAccount.getCardNum(), getAccount.getPasswordOrPin());	
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(pass, "Logged out of Company Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		//5542 Passcode Card
		//setCardNum("5542");
		iOSLogs.setupTestYellow("UNIVERSAL CARD");
		getAccount.setEnv(env);
		getAccount.CardPassExpected("UNIVERSAL");
		cardType = "UNIVERSAL";
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		//card5542.CardPassExpected(env);
		Biometric.BiometricsiOS();
//		openAccount.openProfileButtonFromHome(env, getAccount.getCardNum(), getAccount.getPasswordOrPin());	
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(pass, "Logged out of Passcoce Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
			
		//Delete passcode in database 
		System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
		dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getAccountNum()+"'");
		//login with temp passcode 
		System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		createPasscode.NewPasscode(env);
		
		//Login with newly set card passcode
		Login.CardPassExpected(env, getAccount.getAccountNum(), "985477", this.cardType);
		Biometric.BiometricsiOS();
		createProfile.ProfileSetup(env);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(pass, "Logged out of PASSCODE Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		
			
		iOSLogs.CapturedLogs(info, "Profile functional test completed");
		
		
		
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




public void setCardNum(String cardNumNow) {
	this.cardNum = cardNumNow;
	System.out.println("SET Card Number: "+ cardNum);
}


public String getCardNum() {
	System.out.println("GET Card number: "+ cardNum);
	return cardNum;
}
}