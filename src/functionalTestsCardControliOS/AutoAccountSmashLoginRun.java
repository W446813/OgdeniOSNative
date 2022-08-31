package functionalTestsCardControliOS;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.HelpScreen;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.TestSetup;
import io.appium.java_client.AppiumDriver;

public class AutoAccountSmashLoginRun {
static AppiumDriver<WebElement> driver;
private String cardNum;
private String cardType;
String appName = "Card Control";


@Test
public void cardControlTestiOS() throws Exception {
	//private String testType = "System Test";
	String testType = "QuickLoginLogoutRun";
	String buildNum = "5.0.0";
	
	TestSetup testSetup = new TestSetup(testType, buildNum);

	
	
	Logs iOSLogs = new Logs();
//	iOSLogs.testSetup = testSetup;
//CombinedBasicExtentReportiOS iOSLogs = new BasicExtentReportiOS();
	LogoutCardControl logout = new LogoutCardControl();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
//CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	CardDirectLoginPass Login = new CardDirectLoginPass();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	CreateProfile profileSetup = new CreateProfile();
	HelpScreen helpScreen = new HelpScreen();
	CreatePasscode createPasscode = new CreatePasscode();
	AutoAccountMultiCardDelete autoAccountMultiCardDelete = new AutoAccountMultiCardDelete();
	
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	int smashLogin = 0;
	int timesToRun = 3;
	
	
	try {
		while (smashLogin <= timesToRun) {
			
		iOSLogs.setupTest("TEST TO VERIFY LOGIN WORKS");
		System.out.println("Times test has run: " + smashLogin);
		System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
	
		iOSLogs.setupTestYellow("*CHECKING FOR MULTI CARDS LIST*");
		autoAccountMultiCardDelete.cardControlTestAndroid();	
				
		//FLEET ONE CARD
		iOSLogs.setupTestYellow("FLEET ONE CARD");
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.setEnv(environmentPicker.getEnviroment());
		getAccount.CardPassExpected("FLEET_ONE");			
		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info,"APP KILLED FOR NEXT CARD TYPE");
		
		iOSLogs.setupTestYellow("COMPANY CARD");
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.setEnv(environmentPicker.getEnviroment());
		getAccount.CardPassExpected("COMPANY");
		cardType = "COMPANY CARD";
		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info,"APP KILLED FOR NEXT CARD TYPE");
		
		iOSLogs.setupTestYellow("SMARTFUNDS CARD");
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.setEnv(environmentPicker.getEnviroment());
		getAccount.CardPassExpected("SMARTFUNDS");			
		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info,"APP KILLED FOR NEXT CARD TYPE");
		
		System.out.println("***CHECK FOR MULTI CARDS***");
		iOSLogs.setupTestYellow("*CHECKING FOR MULTI CARDS LIST*");
		autoAccountMultiCardDelete.cardControlTestAndroid();

		iOSLogs.setupTestYellow("UNIVERSAL CARD");
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.setEnv(environmentPicker.getEnviroment());
		getAccount.CardPassExpected("UNIVERSAL");
		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);

		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info,"APP KILLED FOR NEXT CARD TYPE");
		
		//PASSCODE Card (this comes from turning on dynamic pin)
		Thread.sleep(3000);
		iOSLogs.setupTestYellow("PASSCODE CARD");
		System.out.println(phone.autoPhonePickerCard(appName));
		cardType = "PASSCODE CARD";
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.setEnv(environmentPicker.getEnviroment());
		getAccount.CardPassExpected("PASSCODE");
		ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());
		
		//Delete passcode in database 
		System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
		dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getAccountNum()+"'");
		//login with temp passcode 
		System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		
		
		//Login with newly set card passcode
		Biometric.BiometricsiOS();
		createPasscode.NewPasscode(environmentPicker.getEnviroment());
		profileSetup.ProfileSetup(environmentPicker.getEnviroment());
		helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info,"APP KILLED FOR NEXT CARD TYPE");
		
		smashLogin++;
		iOSLogs.CapturedLogs(info, "LOGIN TESTS COMPLETED CYCLE #: " + smashLogin);
	}
		iOSLogs.setupTestYellow("LOGIN TESTS COMPLETED WITH: " + smashLogin +" CYCLES");
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