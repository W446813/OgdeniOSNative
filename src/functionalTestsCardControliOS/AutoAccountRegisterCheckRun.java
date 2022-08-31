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
import iOSCardClasses.HomeLandingPage;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.RegisterCheckiOS;
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

public class AutoAccountRegisterCheckRun {	
static AppiumDriver<WebElement> driver;
public String cardType;

@Test
public void cardControlTestiOS() throws Exception{
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	RegisterCheckiOS registerCheck=new RegisterCheckiOS();
	LogoutCardControl Logout = new LogoutCardControl();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	CardDirectLoginPass Login = new CardDirectLoginPass();
	HomeLandingPage homePage = new HomeLandingPage();
	AutoAccountSelector getAccount = new AutoAccountSelector();
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
				
		iOSLogs.setupTestYellow("REGISTER CHECK COMPANY TEST");
		getAccount.setEnv(env);
		cardType = "Register_Check_Company";	
		getAccount.CardPassExpected(cardType);
		
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		registerCheck.registerCheckiOS(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+" Card");
		
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		
		iOSLogs.setupTestYellow("REGISTER CHECK SMARTFUNDS TEST");
		getAccount.setEnv(env);
		cardType = "Register_Check_Smartfunds";
		getAccount.CardPassExpected("Register_Check_Smartfunds");
		
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		registerCheck.registerCheckiOS(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		
		iOSLogs.setupTestYellow("Register_Check_UNIVERSAL TEST");
		getAccount.setEnv(env);
		cardType = "Register_Check_UNIVERSAL";
		getAccount.CardPassExpected("Register_Check_UNIVERSAL");
		
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		registerCheck.registerCheckiOS(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		
		iOSLogs.CapturedLogs(iOSText.INFO, "Register Check functional test completed");
		
		
		
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
}