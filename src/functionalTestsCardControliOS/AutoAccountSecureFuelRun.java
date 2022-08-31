package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.SecureFuel;
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

public class AutoAccountSecureFuelRun {	
static AppiumDriver<WebElement> driver;
private String cardType;
	
@Test
public void cardControlTestiOS() throws Exception{
	//private String testType = "System Test";
		String testType = "SecureFuelRun";
		String buildNum = "5.0.0";
		
		TestSetup testSetup = new TestSetup(testType, buildNum);

		
		
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	SecureFuel secureFuel = new SecureFuel();
	LogoutCardControl Logout = new LogoutCardControl();
	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	CardDirectLoginPass Login = new CardDirectLoginPass();
	CreateProfile profileSetup = new CreateProfile();
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
			
		
		iOSLogs.setupTestYellow("SECURE FUEL DOES NOT NEEDS UNIT NUMBER");
		cardType = "SECURE_FUEL_DOES NOT_NEED_UNIT_NUMBER";
		getAccount.setEnv(env);
		getAccount.CardPassExpected(cardType);
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		secureFuel.secureFuel(env,getAccount.getUnitID());
		Logout.LogoutCardControl();
		
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		
		
		
		
		iOSLogs.setupTestYellow("SECURE FUEL NEEDS UNIT NUMBER");
		cardType = "SECURE_FUEL_NEEDS_UNIT_NUMBER";
		iOSLogs.CapturedLogs(info, "might have a vpn issue running this one"); 
		iOSLogs.setupTest("SECURE FUEL NEEDS UNIT NUMBER");
		getAccount.setEnv(env);
		getAccount.CardPassExpected(cardType);

		System.out.println(phone.autoPhonePickerCard(appName));
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		environmentPicker.environmentPickerButton();
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		secureFuel.secureFuel(env,getAccount.getUnitID());
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
	
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		
		
		iOSLogs.CapturedLogs(info, "Secure Fuel functional test completed");
			
		
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