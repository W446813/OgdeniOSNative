package carrierControliOS;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import functionalTestsCardControliOS.AutoAccountMultiCardDelete;
import iOSCarrierClasses.LoginPassVerificationCarrierControl;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AutoAccountSmashLoginRun {
	static AppiumDriver<WebElement> driver;
	private String carrierNum;
	private String carrierType;

	@Test
	public void cardControlTestiOS() throws Exception {
		Logs iOSLogs = new Logs();
		PhonePicker phone = new PhonePicker();
		BiometricsiOS Biometric = new BiometricsiOS();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		AppStringsiOS iOSText = new AppStringsiOS();
		LoginPassVerificationCarrierControl loginPassVerificationCarrierControl = new LoginPassVerificationCarrierControl();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		int timesToRun = 1;
		int runsPerCarrier = 3;
		int smashLogin = 0;
		int perCarrierLogin = 0;
		String storedCarrier;
		String storedPassword;
		String env;

		// ADD INFO FOR WHAT YOU ARE RUUNING TEST NAME USUALLY = CLASS NAME
		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		//SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Auto Account Smash Login ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "Partner ";
		
		try {
			iOSLogs.setupTestYellow(TestName + appName +server);
			while (smashLogin < timesToRun) {
				System.out.println("Times test has run: " + smashLogin);
				iOSLogs.setupTest("LOGIN CYCLE TEST");
				System.out.println("Times test has run: " + smashLogin);

				// CARRIER_102698
				perCarrierLogin = 0;
				iOSLogs.setupTestYellow("CARRIER_102698");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_102698");
				carrierType = "CARRIER_102698";
				iOSLogs.setupTestYellow("LOCATING " + carrierType + " ON: " + env);
				storedCarrier = getAccount.getAccountNum();
				storedPassword = getAccount.getPasswordOrPin();
				System.out.println(storedCarrier);
				System.out.println(storedPassword);

				while (perCarrierLogin < runsPerCarrier) {
					iOSLogs.setupTestYellow(carrierType + " LOGIN CYCLE #: " + perCarrierLogin);
					System.out.println(phone.autoPhonePickerCarrier(appName));
					environmentPicker.environmentPickerButtonCarrier();

					loginPassVerificationCarrierControl.PassExpected(env, storedCarrier, storedPassword);
					Biometric.BiometricsiOS();
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCarrierLogin++;
					iOSLogs.setupTestYellow("LOGIN " + storedCarrier + " COMPLETED COUNT #: " + perCarrierLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				iOSLogs.setupTest("LOGIN CYCLE TEST");
				// CARRIER_100045
				perCarrierLogin = 0;
				iOSLogs.setupTestYellow("CARRIER_100045");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_100045");
				carrierType = "CARRIER_100045";
				iOSLogs.setupTestYellow("LOCATING " + carrierType + " ON: " + env);
				storedCarrier = getAccount.getAccountNum();
				storedPassword = getAccount.getPasswordOrPin();
				System.out.println(storedCarrier);
				System.out.println(storedPassword);

				while (perCarrierLogin < runsPerCarrier) {
					System.out.println(phone.autoPhonePickerCarrier(appName));
					environmentPicker.environmentPickerButtonCarrier();
					loginPassVerificationCarrierControl.PassExpected(env, storedCarrier, storedPassword);
					Biometric.BiometricsiOS();
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCarrierLogin++;
					iOSLogs.setupTestYellow("LOGIN " + storedCarrier + " COMPLETED COUNT #: " + perCarrierLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				iOSLogs.setupTest("LOGIN CYCLE TEST");
				// CARRIER_100644
				perCarrierLogin = 0;
				iOSLogs.setupTestYellow("CARRIER_100644");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_100644");
				carrierType = "CARRIER_100644";
				iOSLogs.setupTestYellow("LOCATING " + carrierType + " ON: " + env);
				storedCarrier = getAccount.getAccountNum();
				storedPassword = getAccount.getPasswordOrPin();
				System.out.println(storedCarrier);
				System.out.println(storedPassword);

				while (perCarrierLogin < runsPerCarrier) {
					System.out.println(phone.autoPhonePickerCarrier(appName));
					environmentPicker.environmentPickerButtonCarrier();
					loginPassVerificationCarrierControl.PassExpected(env, storedCarrier, storedPassword);
					Biometric.BiometricsiOS();
					Capabilities.driver.closeApp();
					iOSLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perCarrierLogin++;
					iOSLogs.setupTestYellow("LOGIN " + storedCarrier + " COMPLETED COUNT #: " + perCarrierLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

//TODO ADD MORE ACCOUNT TYPES			

				smashLogin++;
				iOSLogs.setupTestYellow("ALL CARRIER LOGIN COUNT #: " + smashLogin);
				// iOSLogs.setupTestYellow("LOGIN TESTS COMPLETED #: " + smashLogin);
			}
			// iOSLogs.setupTestYellow("LOGIN TESTS COMPLETED WITH: " + smashLogin +"
			// CYCLES");
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
}