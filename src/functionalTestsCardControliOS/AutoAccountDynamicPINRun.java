package functionalTestsCardControliOS;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.DynamicPIN;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.UnitTestMultiCardDelete;
import iOSCardClasses.CreateProfile;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountDynamicPINRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;	
private String cardType;

@Test
public void cardControlTestiOS() throws Exception{
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	DynamicPIN dynamicPIN = new DynamicPIN();

	BiometricsiOS Biometric = new BiometricsiOS();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	CardDirectLoginPass Login = new CardDirectLoginPass();
	LogoutCardControl logout = new LogoutCardControl();
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
		
		
		iOSLogs.setupTest("PASSCODE CARD");
		cardType = "PASSCODE";
		getAccount.setEnv(env);
		getAccount.CardPassExpected(cardType);
				
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
//		multiCardLogin.MultiCardLoginCheck();
		CreatePasscode createPasscode = new CreatePasscode();
		CreateProfile profileSetup = new CreateProfile();
	
		
		//Delete passcode in database 
		System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
		dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getAccountNum()+"'");
		
		//login with temp passcode 
		System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		
		
		//Login with newly set card passcode
		iOSLogs.setupTest("Dynamic PIN functional test");
		Biometric.BiometricsiOS();
		createPasscode.NewPasscode(env);
		profileSetup.ProfileSetup(env);
		dynamicPIN.dynamicPIN(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin());
		logout.LogoutCardControl();
	
		iOSLogs.CapturedLogs(pass, "Logged out of "+cardType+ " Card");
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
				iOSLogs.CapturedLogs(info, "Dynamic PIN functional test completed");
		
		
		
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