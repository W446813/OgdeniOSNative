package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardLoginLogoutTestingLoginPass;
import iOSCardClasses.LoginFailVerificationiOS;
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

public class AutoAccountLoginScenariosRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;	
private String cardType;

@Test
public void cardControlTestiOS() throws Exception{
	Logs iOSLogs = new Logs();
	LogoutCardControl logout = new LogoutCardControl();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	CardLoginLogoutTestingLoginPass CardLogin = new CardLoginLogoutTestingLoginPass();
//	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	LoginFailVerificationiOS failLogin = new LoginFailVerificationiOS();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
		
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	String env;
	String appName = "Card Control";
	
	environmentPicker.SetEnvironment();
	env = environmentPicker.getEnviroment();
	
	ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
	
	try {
	iOSLogs.setupTestYellow("LOGIN SCENARIOS");
	iOSLogs.setupTestYellow("FAKE CARD");
	getAccount.setEnv(env);
	cardType = "FAKE";
	getAccount.CardPassExpected(cardType);
	
	System.out.println(phone.autoPhonePickerCard(appName));
	environmentPicker.environmentPickerButton();
	autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
	//multiCardLogin.MultiCardLoginCheck();
	
	failLogin.FailExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
	iOSLogs.CapturedLogs(iOSText.PASS, "Fake card testing completed");
	Capabilities.driver.closeApp();
	Capabilities.driver.quit();
		
	
	iOSLogs.setupTestYellow("LOCKED LOGIN");
	getAccount.setEnv(env);
	cardType = "COMPANY";
	getAccount.CardPassExpected(cardType);
	
	
	System.out.println(phone.autoPhonePickerCard(appName));
	environmentPicker.environmentPickerButton();
	autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
	//multiCardLogin.MultiCardLoginCheck();

	failLogin.LockedLoginExpected(env, getAccount.getAccountNum(), "0103", this.cardType);
	Capabilities.driver.closeApp();
	Capabilities.driver.quit();
	
	iOSLogs.setupTestYellow("SUSPENDED LOGIN");
	getAccount.setEnv(env);
	getAccount.CardPassExpected("COMPANY");
	cardType = "COMPANY";
	
	System.out.println(phone.autoPhonePickerCard(appName));
	environmentPicker.environmentPickerButton();
	autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
	//multiCardLogin.MultiCardLoginCheck();
	
	failLogin.SuspendedLoginExpected(env, getAccount.getAccountNum(), "0103", this.cardType);
	Capabilities.driver.closeApp();
	Capabilities.driver.quit();
	
	
	iOSLogs.setupTestYellow("LOGIN AFTER LOCKED");
	getAccount.setEnv(env);
	cardType = "COMPANY";
	getAccount.CardPassExpected(cardType);
	
	
	System.out.println(phone.autoPhonePickerCard(appName));
	environmentPicker.environmentPickerButton();
	autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
	//multiCardLogin.MultiCardLoginCheck();
	
	CardLogin.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
	Biometric.BiometricsiOS();
	logout.LogoutCardControl();
	
	Capabilities.driver.closeApp();
	Capabilities.driver.quit();
	iOSLogs.CapturedLogs(info, "Login Scenarios completed");
	
	

	
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