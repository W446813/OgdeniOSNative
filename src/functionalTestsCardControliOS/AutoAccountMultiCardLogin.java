package functionalTestsCardControliOS;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.HomeLandingPage;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.MultiCardsLogin;
import iOSCardClasses.MultiCardsRemoveCard;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountMultiCardLogin {
	static AppiumDriver<WebElement> driver;
	private String cardNum;	
	private String cardType;
	
	@Test
	public void cardControlTestAndroid() throws Exception {
		//private String testType = "System Test";
		//String testType = "QuickLoginLogoutRun";
		//String buildNum = "5.0.0";
		//TestSetup testSetup = new TestSetup(testType, buildNum);

		Logs iOSLogs = new Logs();
		LogoutCardControl logout = new LogoutCardControl();
		AppStringsiOS iOSText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		BiometricsiOS Biometric = new BiometricsiOS();
		MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		MultiCardsLogin multiCardsLogin = new MultiCardsLogin();
		MultiCardsRemoveCard removeCard = new MultiCardsRemoveCard();
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		String appName = "Card Control";
		
		try {
			
			AutoAccountSelector getAccount = new AutoAccountSelector();
			CreateProfile profileSetup = new CreateProfile();
			HomeLandingPage homePage = new HomeLandingPage();
			
			
			System.out.println(phone.autoPhonePickerCard(appName));
			iOSLogs.setupTest("MultiCard Login Logout Function test");
			
			
			//COMPANY
			iOSLogs.setupTestYellow("Testing add Company Card");
			environmentPicker.environmentPickerButton();
			multiCardLogin.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "COMPANY";
			getAccount.CardPassExpected(cardType);
			
			String companyCard = getAccount.getAccountNum();
			String companyCardPin = getAccount.getPasswordOrPin();
			
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometric.BiometricsiOS(); 
			profileSetup.ProfileSetup(environmentPicker.getEnviroment());
			//homePage.HomeLandingPage(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
			logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			//SMARTFUNDS
			System.out.println(phone.autoPhonePickerCard(appName));
			iOSLogs.setupTestYellow("Testing add SmartFunds Card");
			environmentPicker.environmentPickerButton();
			multiCardLogin.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "SMARTFUNDS";
			getAccount.CardPassExpected(cardType);
			
			String smartfundsCard = getAccount.getAccountNum();
			String smartfundsCardPin = getAccount.getPasswordOrPin();
			
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(),this.cardType);
			Biometric.BiometricsiOS(); 
			profileSetup.ProfileSetup(environmentPicker.getEnviroment());
			//homePage.HomeLandingPage(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
			logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			
			//UNIVERSAL
			System.out.println(phone.autoPhonePickerCard(appName));
			iOSLogs.setupTestYellow("Testing add Universal Card");
			environmentPicker.environmentPickerButton();
			multiCardLogin.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			cardType = "UNIVERSAL";
			getAccount.CardPassExpected(cardType);
			
			String universalCard = getAccount.getAccountNum();
			String universalCardPin = getAccount.getPasswordOrPin();
			
			Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			Biometric.BiometricsiOS(); 
			profileSetup.ProfileSetup(environmentPicker.getEnviroment());
			//homePage.HomeLandingPage(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
			logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			//COMPANY MultiCard page login
			System.out.println(phone.autoPhonePickerCard(appName));
			iOSLogs.setupTestYellow("COMPANY FROM MULTI CARD LIST");
			cardType = "COMPANY FROM MULTI CARD LIST CARD";
			environmentPicker.environmentPickerButton();
			getAccount.setEnv(environmentPicker.getEnviroment());
			multiCardsLogin.multiCardPassExpected(environmentPicker.getEnviroment(), companyCard, companyCardPin , this.cardType);
			Biometric.BiometricsiOS(); 
			profileSetup.ProfileSetup(environmentPicker.getEnviroment());
			//homePage.HomeLandingPage(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
			logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			//SMARTFUNDS MultiCard page Login
			System.out.println(phone.autoPhonePickerCard(appName));
			iOSLogs.setupTestYellow("SMARTFUNDS FROM MULTI CARD LIST");
			cardType = "SMARTFUNDS FROM MULTI CARD LIST CARD";
			environmentPicker.environmentPickerButton();
			getAccount.setEnv(environmentPicker.getEnviroment());
			multiCardsLogin.multiCardPassExpected(environmentPicker.getEnviroment(), smartfundsCard, smartfundsCardPin, this.cardType);
			Biometric.BiometricsiOS(); 
			profileSetup.ProfileSetup(environmentPicker.getEnviroment());
			//homePage.HomeLandingPage(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
			logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			//UNIVERSAL MultiCard page login
			
			System.out.println(phone.autoPhonePickerCard(appName));
			iOSLogs.setupTestYellow("UNIVERSAL FROM MULTI CARD LIST");
			cardType = "UNIVERSAL FROM MULTI CARD LIST CARD";
			environmentPicker.environmentPickerButton();
			getAccount.setEnv(environmentPicker.getEnviroment());
			multiCardsLogin.multiCardPassExpected(environmentPicker.getEnviroment(), universalCard, universalCardPin, this.cardType);
			Biometric.BiometricsiOS(); 
			profileSetup.ProfileSetup(environmentPicker.getEnviroment());
        	//homePage.HomeLandingPage(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
			logout.LogoutCardControl();
			iOSLogs.CapturedLogs(info, "Logged out of "+cardType+" Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
					
				
			
//TODO add a fleet one card also...
			

			
			iOSLogs.CapturedLogs(info, "MultiCard Login Logout functional test completed");
		
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
			} catch (IOException e) {
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