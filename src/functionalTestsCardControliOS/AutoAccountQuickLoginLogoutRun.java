package functionalTestsCardControliOS;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
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

public class AutoAccountQuickLoginLogoutRun {
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
	UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

		
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	String env;
	environmentPicker.SetEnvironment();
	env = environmentPicker.getEnviroment();
	
	ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
	
	try {
		//iOSLogs.setupTest(testType);
		iOSLogs.setupTestYellow("Quick Login Logout Function test");
		iOSLogs.setupTestYellow("COMPANY CARD");
		getAccount.setEnv(env);
		cardType = "COMPANY";
		getAccount.CardPassExpected(cardType);
		
		
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		iOSLogs.setupTestYellow("SMARTFUNDS CARD");
		getAccount.setEnv(env);
		cardType = "SMARTFUNDS";
		getAccount.CardPassExpected(cardType);	
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		
		iOSLogs.setupTestYellow("UNIVERSAL CARD");
		getAccount.setEnv(env);
		cardType = "UNIVERSAL";
		getAccount.CardPassExpected(cardType);
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
//SOMETHING IS CAUSING A CRAZY SET OF FOLDER CREATIONS IN HERE........		
//		iOSLogs.setupTestYellow("PASSCODE CARD");
//		//PASSCODE Card (this comes from turning on dynamic pin) 
//		getAccount.setEnv(env);
//		getAccount.CardPassExpected("PASSCODE");

//		System.out.println(phone.autoPhonePickerCard(appName));
//		environmentPicker.EnvironmentPicker();
//		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		//multiCardLogin.MultiCardLoginCheck();


//		
//		//Delete passcode in database 
//		System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
//		dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getCardNum()+"'");
//		//login with temp passcode 
//		System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
//		Login.CardPassExpected(env, getAccount.getCardNum(), getAccount.getPasswordOrPin());
//		createPasscode.NewPasscode(env);
//		
//		//Login with newly set card passcode
//		Login.CardPassExpected(env, getAccount.getCardNum(), "985477");
//		Biometric.BiometricsiOS();
//		profileSetup.ProfileSetup();
//		Logout.LogoutCardControl();
//		iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+" Card");
//		Capabilities.driver.closeApp();
//		Capabilities.driver.quit();
		
		
//TODO add a fleet one card also...
		

		
		iOSLogs.CapturedLogs(info, "Quick Login Logout functional test completed");
	
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