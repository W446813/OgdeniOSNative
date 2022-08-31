package cardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
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
import iOSsharedClasses.HelpScreen;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.TestSetup;
import io.appium.java_client.AppiumDriver;

public class AutoAccountSmashLoginRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String accountType;

	@Test
	public void cardControlTestiOS() throws Exception {
		Logs iOSLogs = new Logs();
		LogoutCardControl logout = new LogoutCardControl();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		BiometricsiOS Biometric = new BiometricsiOS();
		MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreateProfile profileSetup = new CreateProfile();
		HelpScreen helpScreen = new HelpScreen();
		CreatePasscode createPasscode = new CreatePasscode();
			AppStringsiOS iOSText = new AppStringsiOS();
		UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		int timesToRun = 1;
		int runsPerCard = 4;
		int smashLogin = 0;
		int perCardLogin = 0;
		String storedCard;
		String storedPin;
		String env;
		String cardID;
	
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		
		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smash Login ";
		String build = "Build #:  ";
		String appName = "Card Control ";
		String server = "AWSDIT ";

		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);
			
			while (smashLogin < timesToRun) {
				iOSLogs.setupTest("LOGIN VERIFICATION TEST");

				System.out.println("Times test has run: " + smashLogin);
				
				// FLEET ONE CARD
				perCardLogin = 0;
				getAccount.setEnv(env);
				accountType = "FLEET ONE CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected("FLEET_ONE");
				storedCard = getAccount.getAccountNum();
				storedPin = getAccount.getPasswordOrPin();

				while (perCardLogin < runsPerCard) {
					cardID = getAccount.getCardID(storedCard, env);
					iOSLogs.setupTestYellow(accountType + " cardID: " + cardID + " LOGIN CYCLE #: " + perCardLogin);

					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					multiCardLogin.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
					Biometric.BiometricsiOS();
					helpScreen.HelpScreenContinue(env, storedCard, storedPin, this.accountType);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCardLogin++;
					iOSLogs.CapturedLogs(info, "LOGIN FLEETONE COMPLETED CYCLE #: " + perCardLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");
				}
				
				// COMPANY CARD
				perCardLogin = 0;
				getAccount.setEnv(env);
				accountType = "COMPANY CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected("COMPANY");

				storedCard = getAccount.getAccountNum();
				storedPin = getAccount.getPasswordOrPin();

				while (perCardLogin < runsPerCard) {
					cardID = getAccount.getCardID(storedCard, env);
					iOSLogs.setupTestYellow(accountType + " cardID: " + cardID + " LOGIN CYCLE #: " + perCardLogin);

					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					multiCardLogin.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
					Biometric.BiometricsiOS();
					helpScreen.HelpScreenContinue(env, storedCard, storedPin, this.accountType);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCardLogin++;
					iOSLogs.CapturedLogs(info, "LOGIN COMPANY CARD COMPLETED CYCLE #: " + perCardLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");
				}
				
				// MASTER CARD
				perCardLogin = 0;
				getAccount.setEnv(env);
				accountType = "MasterCard";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected("MasterCard");
				storedCard = getAccount.getAccountNum();
				storedPin = getAccount.getPasswordOrPin();

				while (perCardLogin < runsPerCard) {
					cardID = getAccount.getCardID(storedCard, env);
					iOSLogs.setupTestYellow(accountType + " cardID: " + cardID + " LOGIN CYCLE #: " + perCardLogin);

					System.out.println(phone.autoPhonePickerCard(appName));

					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					multiCardLogin.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
					Biometric.BiometricsiOS();
					helpScreen.HelpScreenContinue(env, storedCard, storedPin, this.accountType);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCardLogin++;
					iOSLogs.CapturedLogs(info, "LOGIN "+accountType+ " COMPLETED CYCLE #: " + perCardLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");
				}

				// SMART FUNDS CARD
				perCardLogin = 0;
				getAccount.setEnv(env);
				accountType = "SMARTFUNDS";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected("SMARTFUNDS");

				storedCard = getAccount.getAccountNum();
				storedPin = getAccount.getPasswordOrPin();

				while (perCardLogin < runsPerCard) {
					cardID = getAccount.getCardID(storedCard, env);
					iOSLogs.setupTestYellow(accountType + " cardID: " + cardID + " LOGIN CYCLE #: " + perCardLogin);

					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					multiCardLogin.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
					Biometric.BiometricsiOS();
					helpScreen.HelpScreenContinue(env, storedCard, storedPin, this.accountType);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCardLogin++;
					iOSLogs.CapturedLogs(info, "LOGIN SMARTFUNDS CARD COMPLETED CYCLE #: " + perCardLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");
				}

				// UNIVERSAL CARD
				perCardLogin = 0;
				getAccount.setEnv(env);
				accountType = "UNIVERSAL CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected("UNIVERSAL");

				storedCard = getAccount.getAccountNum();
				storedPin = getAccount.getPasswordOrPin();

				while (perCardLogin < runsPerCard) {
					cardID = getAccount.getCardID(storedCard, env);
					iOSLogs.setupTestYellow(accountType + " cardID: " + cardID + " LOGIN CYCLE #: " + perCardLogin);

					// iOSLogs.setupTestYellow(accountType +" LOGIN CYCLE #: " + perCardLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					multiCardLogin.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
					Biometric.BiometricsiOS();
					helpScreen.HelpScreenContinue(env, storedCard, storedPin, this.accountType);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCardLogin++;
					iOSLogs.CapturedLogs(info, "LOGIN UNIVERSAL CARD COMPLETED CYCLE #: " + perCardLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");
				}

				// PASSCODE Card (this comes from turning on dynamic pin)
				perCardLogin = 0;
				Thread.sleep(3000);
				getAccount.setEnv(env);
				accountType = "PASSCODE CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				getAccount.CardPassExpected("PASSCODE");

				storedCard = getAccount.getAccountNum();
				storedPin = getAccount.getPasswordOrPin();

				// Delete passcode in database
				System.out.println(
						"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
				dbACPTCheck.execute("infx",
						"Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
				// login with temp passcode
				System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.environmentPickerButton();
				autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
				multiCardLogin.MultiCardLoginCheck();
				Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
				// Biometric.BiometricsiOS();
				createPasscode.NewPasscode(environmentPicker.getEnviroment());
				profileSetup.ProfileSetup(environmentPicker.getEnviroment());
				helpScreen.HelpScreenContinue(env, storedCard, getAccount.getPasswordOrPin(), this.accountType);
				storedPin = iOSText.MANUAL_PASSCODE;
				Capabilities.driver.closeApp();
				iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");

				while (perCardLogin < runsPerCard) {
					cardID = getAccount.getCardID(storedCard, env);
					iOSLogs.setupTestYellow(accountType + " cardID: " + cardID + " LOGIN CYCLE #: " + perCardLogin);

					// iOSLogs.setupTestYellow(accountType +" LOGIN CYCLE #: " + perCardLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					multiCardLogin.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedCard, storedPin, this.accountType);
					Biometric.BiometricsiOS();
					helpScreen.HelpScreenContinue(env, storedCard, storedPin, this.accountType);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCardLogin++;
					iOSLogs.CapturedLogs(info, "LOGIN PASSCODE CARD COMPLETED CYCLE #: " + perCardLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");
				}

				smashLogin++;
				iOSLogs.CapturedLogs(info, "LOGIN TESTS COMPLETED CYCLE #: " + smashLogin);
			}
			iOSLogs.setupTestYellow("LOGIN TESTS COMPLETED WITH: " + smashLogin + " CYCLES");

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*CHECKING FOR MULTI CARDS LIST*");
//		autoAccountMultiCardDelete.cardControlTestAndroid();	

		} catch (Exception exp) {
			String errorMessage = exp.getMessage();
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
				iOSLogs.CapturedLogs(iOSText.FAIL, errorMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: " + cardNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + cardNum);
		return cardNum;
	}
}