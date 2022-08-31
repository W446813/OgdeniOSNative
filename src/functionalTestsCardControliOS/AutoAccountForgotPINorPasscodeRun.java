package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCardClasses.AccountPage;
import iOSCardClasses.AutoAccountForgotPINorPasscode;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CardLoginACH;
import iOSCardClasses.CardLoginPassCode;
import iOSCardClasses.CardLoginPassSecureFuel;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.ForgotPINorPasscode;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.UnitTestMultiCardDelete;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.HelpScreen;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountForgotPINorPasscodeRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;	
private String accountType;

@Test
public void cardControlTestiOS() throws Exception {
	Logs iOSLogs = new Logs();
	LogoutCardControl logout = new LogoutCardControl();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	AutoAccountForgotPINorPasscode resetpinOrPassFromLogin = new AutoAccountForgotPINorPasscode();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	
	String storedCard;
	String storedPin;
	String env;
	String cardID;
	String appName = "Card Control";
	
	environmentPicker.SetEnvironment();
	env = environmentPicker.getEnviroment();
	ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
	
	
	try {
		
		
		getAccount.setEnv(env);
		accountType = "PASSCODE";
		getAccount.CardPassExpected(accountType);
		iOSLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
		
		storedCard = getAccount.getAccountNum();
		storedPin = getAccount.getPasswordOrPin();
		cardID = getAccount.getCardID(storedCard, env);
		
			
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
		multiCardLogin.MultiCardLoginCheck();
		resetpinOrPassFromLogin.ForgotPINorPasscode(env, storedCard, accountType);
	
		
		logout.LogoutCardControl();
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(pass, "Logged out of "+accountType+ " Card");
		
		
		
		iOSLogs.CapturedLogs(iOSText.INFO, "Forgot PIN or Passcode functional test completed");
		
		
		
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