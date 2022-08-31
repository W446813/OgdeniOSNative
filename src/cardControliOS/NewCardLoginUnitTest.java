package cardControliOS;

import java.io.IOException;
import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.NewAccountPinOrPasscode;
import iOSCardClasses.RepoCardiOS;
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
import iOSsharedClasses.TestSetup;
import io.appium.java_client.AppiumDriver;

public class NewCardLoginUnitTest {
	static AppiumDriver<WebElement> driver;
	private String accountNum;
	private String accountType;
	private String lastOfCardNum;

	@Test
	public void cardControlTestAndroid() throws Exception {

		// private String testType = "System Test";
		String testType = "QuickLoginLogoutRun";
		String buildNum = "5.0.0";

		TestSetup testSetup = new TestSetup(testType, buildNum);

		Logs iOSLogs = new Logs();
//		iOSLogs.testSetup = testSetup;
		// CombinedBasicExtentReportiOS iOSLogs = new BasicExtentReportiOS();
		LogoutCardControl logout = new LogoutCardControl();
		PhonePicker phone = new PhonePicker();
		// CardDirectLoginPass CardLogin = new CardDirectLoginPass();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		BiometricsiOS Biometrics = new BiometricsiOS();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreateProfile profileSetup = new CreateProfile();
		HelpScreen helpScreen = new HelpScreen();
		NewAccountPinOrPasscode newPassOrPin = new NewAccountPinOrPasscode();
		// AutoAccountMultiCardDelete autoAccountMultiCardDelete = new
		// AutoAccountMultiCardDelete();
		UnitTestMultiCardDelete autoAccountMultiCardDelete = new UnitTestMultiCardDelete();

		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCardiOS elements = new RepoCardiOS();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		int timesToRun = 1;
		int runsPerAccount = 1;
		int smashLogin = 0;
		int perAccountLogin = 0;
		String storedAccount;
		String storedPinOrPassword;
		String cardID;
		String env;

		String accountNumber = "1";
		String passwordOrPin = "1";
		

		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "New Card Log in ";
		String build = "Build #:  ";
		String appName = "Card Control ";
		String server = "Partner ";

		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);
			
			while (smashLogin < timesToRun) {

				System.out.println("Times test has run: " + smashLogin);
				iOSLogs.setupTest("LOGIN VERIFICATION TEST");

				// FLEET ONE
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "FLEET ONE CARD";
				// TODO Add database login
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				System.out.println("Some SQL Statements take a minute to load Please Wait");
				ResultSet fleetOneCard = dbACPTCheck.query("infx", String.format(
						"Select * from card_pins where card_num like '501%%' and status = 'A' and valid = 'A' order by set DESC"));

				int fleetOneCardloops = 0;
				while (fleetOneCard.next() && fleetOneCardloops <= smashLogin) {

					// fleetOne.next();
					accountNumber = fleetOneCard.getString("card_num");
					passwordOrPin = fleetOneCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					iOSLogs.CapturedLogs(info, "Card ID located: " + cardID);
					fleetOneCardloops++;

					iOSLogs.CapturedLogs(info,
							" #:" + fleetOneCardloops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + fleetOneCardloops + " Card ID found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				lastOfCardNum = getAccount.getlastFour(accountNumber);
				cardID = getAccount.getCardID(accountNumber, env);

				while (perAccountLogin < runsPerAccount) {
					// Delete pin/passcode in database
					System.out.println("Deleteing CardPin Record from " + getAccount.getCardID(accountNumber, env)
							+ " from databse prior to login");
					dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + accountNumber + "'");
					// login with temp passcode
					System.out.println("Pin is set to: " + storedPinOrPassword);

					iOSLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					Login.CardPassExpected(env, storedAccount, lastOfCardNum, accountType);
					newPassOrPin.NewPasscodeOrPin(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsiOS();
					profileSetup.ProfileSetup(env);
					helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, this.accountType);
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					iOSLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);

					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// COMPANY CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "COMPANY CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				System.out.println("Some SQL Statements take a minute to load Please Wait");
				ResultSet companyCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.dynamic_pin_flag = 'N' order by c.lastupdated desc"));

				int companyCardloops = 0;
				while (companyCard.next() && companyCardloops <= smashLogin) {
					accountNumber = companyCard.getString("card_num");
					passwordOrPin = companyCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					iOSLogs.CapturedLogs(info, "Card ID located: " + cardID);
					companyCardloops++;

					iOSLogs.CapturedLogs(info, " #:" + companyCardloops + " Card ID found: " + cardID);
					System.out.println(accountType + " #:" + companyCardloops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				lastOfCardNum = getAccount.getlastFour(accountNumber);
				cardID = getAccount.getCardID(accountNumber, env);

				while (perAccountLogin < runsPerAccount) {
					// Delete pin/passcode in database
					System.out.println("Deleteing CardPin Record from " + getAccount.getCardID(accountNumber, env)
							+ " from databse prior to login");
					dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + accountNumber + "'");
					// login with temp passcode
					System.out.println("Pin is set to: " + storedPinOrPassword);

					iOSLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					Login.CardPassExpected(env, storedAccount, lastOfCardNum, accountType);
					newPassOrPin.NewPasscodeOrPin(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsiOS();
					profileSetup.ProfileSetup(env);
					helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, this.accountType);
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					iOSLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);

					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// SMARTFUNDS CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "SMARTFUNDS CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				System.out.println("Some SQL Statements take a minute to load Please Wait");
				ResultSet smartFundsCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'P' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and cp.pin <> 'NULL' and c.card_type <> 'MCFL' order by c.lastupdated desc"));

				int smartFundsCardloops = 0;
				while (smartFundsCard.next() && smartFundsCardloops <= smashLogin) {
					accountNumber = smartFundsCard.getString("card_num");
					passwordOrPin = smartFundsCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					iOSLogs.CapturedLogs(info, "Card ID located: " + cardID);
					smartFundsCardloops++;

					iOSLogs.CapturedLogs(info, " #:" + smartFundsCardloops + " Card ID found: "
							+ getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + smartFundsCardloops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				lastOfCardNum = getAccount.getlastFour(accountNumber);

				while (perAccountLogin < runsPerAccount) {
					// Delete pin/passcode in database
					System.out.println("Deleteing CardPin Record from " + getAccount.getCardID(accountNumber, env)
							+ " from databse prior to login");
					dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + accountNumber + "'");
					// login with temp passcode
					System.out.println("Pin is set to: " + storedPinOrPassword);

					iOSLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					Login.CardPassExpected(env, storedAccount, lastOfCardNum, accountType);
					newPassOrPin.NewPasscodeOrPin(env, storedAccount, storedPinOrPassword);
					Thread.sleep(3000);
					Biometrics.BiometricsiOS();
					profileSetup.ProfileSetup(env);
					helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, this.accountType);
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					iOSLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);

					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// UNIVERSAL CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "UNIVERSAL CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				ResultSet universalCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A'order by c.lastupdated desc"));

				int universalCardLoops = 0;
				while (universalCard.next() && universalCardLoops <= smashLogin) {
					accountNumber = universalCard.getString("card_num");
					passwordOrPin = universalCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					iOSLogs.CapturedLogs(info, "Card ID located: " + cardID);
					universalCardLoops++;

					iOSLogs.CapturedLogs(info,
							" #:" + universalCardLoops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + universalCardLoops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				lastOfCardNum = getAccount.getlastFour(accountNumber);

				while (perAccountLogin < runsPerAccount) {
					// Delete pin/passcode in database
					System.out.println("Deleteing CardPin Record from " + getAccount.getCardID(accountNumber, env)
							+ " from databse prior to login");
					dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + accountNumber + "'");
					// login with temp passcode
					System.out.println("Pin is set to: " + storedPinOrPassword);

					iOSLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					Login.CardPassExpected(env, storedAccount, lastOfCardNum, accountType);
					newPassOrPin.NewPasscodeOrPin(env, storedAccount, storedPinOrPassword);
					Biometrics.BiometricsiOS();
					profileSetup.ProfileSetup(env);
					helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, this.accountType);
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					iOSLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);

					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// PASSCODE Card (this comes from turning on dynamic pin)
				perAccountLogin = 0;
				Thread.sleep(3000);
				iOSLogs.setupTestYellow("PASSCODE CARD");
				getAccount.setEnv(env);
				accountType = "PASSCODE CARD";
				iOSLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				ResultSet passcodeCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, cp.* from cards c, card_pins cp where c.card_num = cp.card_num and cp.status = 'A'and cp.valid in ('A','Y') and c.status = 'A'and cp.passcode_enabled_flag = 'Y'and c.dynamic_pin_flag = 'Y' order by cp.passcode_set_date desc"));

				int passcodeCardLoops = 0;
				while (passcodeCard.next() && passcodeCardLoops <= smashLogin) {
					accountNumber = passcodeCard.getString("card_num");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					iOSLogs.CapturedLogs(info, "Card ID located: " + cardID);
					passcodeCardLoops++;

					String newPasscodeCardPasscode = accountNumber.substring(accountNumber.length() - 6);
					passwordOrPin = newPasscodeCardPasscode;

					iOSLogs.CapturedLogs(info,
							" #:" + passcodeCardLoops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + passcodeCardLoops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				cardID = getAccount.getCardID(accountNumber, env);

				// Delete passcode in database
				System.out.println("Deleteing CardPin Record from " + cardID + " from databse prior to login");
				dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + accountNumber + "'");
				// login with temp passcode
				System.out.println("Pin is set to: " + storedPinOrPassword);

				iOSLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.environmentPickerButton();
				autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
				Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
				newPassOrPin.NewPasscodeOrPin(env, storedAccount, storedPinOrPassword);
				Biometrics.BiometricsiOS();
				profileSetup.ProfileSetup(env);
				helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, this.accountType);
				Thread.sleep(3000);
				storedPinOrPassword = iOSText.MANUAL_PASSCODE;
				Capabilities.driver.closeApp();
				iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");

				while (perAccountLogin < runsPerAccount) {
					iOSLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.environmentPickerButton();
					autoAccountMultiCardDelete.AutoAccountMultiCardDelete(env);
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, accountType);
					Biometrics.BiometricsiOS();
					profileSetup.ProfileSetup(env);
					helpScreen.HelpScreenContinue(env, storedAccount, storedPinOrPassword, this.accountType);
					perAccountLogin++;
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					iOSLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				smashLogin++;
				iOSLogs.setupTestYellow("ALL CARRIER LOGIN COUNT #: " + smashLogin);

			}
			iOSLogs.setupTestYellow("LOGIN TESTS COMPLETED WITH: " + smashLogin + " CYCLES");
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
				iOSLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setCardNum(String cardNumNow) {
		this.accountNum = cardNumNow;
		System.out.println("SET Card Number: " + accountNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + accountNum);
		return accountNum;
	}
}