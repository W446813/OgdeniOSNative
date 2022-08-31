package functionalTestsCardControliOS;

import java.sql.ResultSet;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.RepoCardiOS;
import iOSCardClasses.UnitTestMultiCardDelete;
import iOSCardClasses.CreateProfile;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountSetupProfileRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;	
private String cardType;

@Test
public void cardControlTestiOS() throws Exception{
	
	
	
	
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	CreateProfile profileSetup = new CreateProfile();
	LogoutCardControl Logout = new LogoutCardControl();
	BiometricsiOS Biometric = new BiometricsiOS();
	CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	CardDirectLoginPass Login = new CardDirectLoginPass();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

		
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	String env;
	String appName = "Card Control";
	
	environmentPicker.SetEnvironment();
	env = environmentPicker.getEnviroment();
	RepoCardiOS elements = new RepoCardiOS();
	
	ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
	
	try {
		iOSLogs.setupTestYellow("Setup Profile functional test");
		getAccount.setEnv(env);
		cardType = "SETUP_PROFILE";
		getAccount.CardPassExpected(cardType);	
	
		//Database interaction
		//Delete found profile so we can make a new one
				iOSLogs.CapturedLogs(info, "Starting search for profile and deletion execution");
			
				String profileID = "notFound";
				ResultSet profileIDDB = dbACPTCheck.query("infx",String.format("SELECT profile_id FROM ach_profile_card_xref WHERE card_num ='"+getAccount.getAccountNum()+"'"));	
				profileIDDB.next();
				profileID = profileIDDB.getString("profile_id");
				iOSLogs.CapturedLogs(pass, "Profile ID found as: " + profileID);
				System.out.println(profileID);
				iOSLogs.CapturedLogs(pass, "Deleting profile id: " + profileID);
				dbACPTCheck.execute("infx", "DELETE FROM ach_profile_card_xref WHERE profile_id =" +profileID);
				dbACPTCheck.execute("infx", "DELETE FROM ach_driver_profile WHERE profile_id =" +profileID);
				iOSLogs.CapturedLogs(pass, " Deleted profile id: " + profileID);
				iOSLogs.CapturedLogs(pass, " Setup profile Test ready to begin");

				String storedCardNum = getAccount.getAccountNum();
				String storedPinPasscode = getAccount.getPasswordOrPin();
				
		iOSLogs.CapturedLogs(info, "Starting login process");
		System.out.println(phone.autoPhonePickerCard(appName));
		Thread.sleep(3000);
		environmentPicker.environmentPickerButton();
		Thread.sleep(3000);
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		//CardLogin.CardPassExpected(env, this.cardNum);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		Thread.sleep(3000);
		Capabilities.driver.closeApp();
	
		
		//checking for login after profile creation to make sure it loggs in and does not ask to create a profile
		iOSLogs.CapturedLogs(info, "Login started with same account and verifying profile is still setup");
		getAccount.setEnv(env);
		
		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
		Login.CardPassExpected(env,storedCardNum, storedPinPasscode, this.cardType);
		//CardLogin.CardPassExpected(env, this.cardNum);
		Biometric.BiometricsiOS();
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out");
		
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		
		
		
		
		
		
				iOSLogs.setupTestYellow("Setup Profile Skip functional test");
				getAccount.setEnv(env);
				cardType = "SETUP_PROFILE";
				getAccount.CardPassExpected(cardType);
			
					
	
				//Database interaction
				//Delete found profile so we can make a new one
				iOSLogs.CapturedLogs(info, "Starting search for profile and deletion execution");
			
			
				//Database interaction
				//Delete found profile so we can make a new one
						iOSLogs.CapturedLogs(info, "Starting search for profile and deletion execution");
					
						String profileID1 = "notFound";
						ResultSet profileIDDB1 = dbACPTCheck.query("infx",String.format("SELECT profile_id FROM ach_profile_card_xref WHERE card_num ='"+getAccount.getAccountNum()+"'"));	
						profileIDDB1.next();
						profileID1 = profileIDDB1.getString("profile_id");
						iOSLogs.CapturedLogs(pass, "Profile ID found as: " + profileID1);
						System.out.println(profileID1);
						iOSLogs.CapturedLogs(pass, "Deleting profile id: " + profileID1);
						dbACPTCheck.execute("infx", "DELETE FROM ach_profile_card_xref WHERE profile_id =" +profileID1);
						dbACPTCheck.execute("infx", "DELETE FROM ach_driver_profile WHERE profile_id =" +profileID1);
						iOSLogs.CapturedLogs(pass, " Deleted profile id: " + profileID1);
						iOSLogs.CapturedLogs(pass, " Setup profile Test ready to begin");

//						String storedCardNum1 = getAccount.getAccountNum();
//						String storedPinPasscode1 = getAccount.getPasswordOrPin();
				
		iOSLogs.CapturedLogs(info, "Starting login process");
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.environmentPickerButton();
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
		Login.CardPassExpected(env, storedCardNum, storedPinPasscode, this.cardType);
		Biometric.BiometricsiOS();
		
		Thread.sleep(3000);
		WebElement skipProfileButton = elements.skipProfileButton();
		Thread.sleep(3000);
		
		if (skipProfileButton != null && skipProfileButton.isEnabled()) {
			skipProfileButton.click();
			iOSLogs.CapturedLogs(info, "Profile Skip  Button found and selected");
			Logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out");
			
		} else {
			iOSLogs.CapturedLogs(info, "Profile Skip  Button not found");	
		}
		
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(info, "Logged out");
	
		
		
		//checking for login after profile creation to make sure it loggs in and does not ask to create a profile
		iOSLogs.CapturedLogs(info, "Login started with same account fixing profile");
		iOSLogs.CapturedLogs(info, "Starting login process");
		
		System.out.println(phone.autoPhonePickerCard(appName));
		Thread.sleep(3000);
		environmentPicker.environmentPickerButton();
		Thread.sleep(3000);
		autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
		Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		//CardLogin.CardPassExpected(env, this.cardNum);
		Biometric.BiometricsiOS();
		profileSetup.ProfileSetup(env);
		Logout.LogoutCardControl();
		iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
		Thread.sleep(3000);
		Capabilities.driver.closeApp();
		
		
		iOSLogs.CapturedLogs(info, "Setup Profile functional test completed");
		
		
		
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