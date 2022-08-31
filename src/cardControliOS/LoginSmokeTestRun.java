package cardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import functionalTestsCardControliOS.AutoAccountLoginScenariosRun;
import functionalTestsCardControliOS.AutoAccountMultiCardDelete;
import functionalTestsCardControliOS.AutoAccountMultiCardLogin;
import functionalTestsCardControliOS.AutoAccountQuickLoginLogoutRun;
import functionalTestsCardControliOS.ForgotPINorPasscodeRun;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class LoginSmokeTestRun {
	static AppiumDriver<WebElement> driver;

//public static void main(String[] args) throws Exception {
//		Logs iOSLogs = new Logs();
//		cardControlTestiOS();
//	}

	@Test
	public void cardControlTestiOS() {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		AutoAccountMultiCardLogin autoAccountMultiCardLogin = new AutoAccountMultiCardLogin();
		AutoAccountQuickLoginLogoutRun autoAccountQuickLoginLogoutRun = new AutoAccountQuickLoginLogoutRun();
		ForgotPINorPasscodeRun forgotPINorPasscodeRun = new ForgotPINorPasscodeRun();
		AutoAccountMultiCardDelete autoAccountMultiCardDelete = new AutoAccountMultiCardDelete();
		AutoAccountLoginScenariosRun autoAccountLoginScenariosRun = new AutoAccountLoginScenariosRun();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Login Smoke Test ";
		String build = "Build #:  ";
		String appName = "Card Control ";
		String server = "Partner ";

		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);

//		System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
//		iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
//		autoAccountMultiCardDelete.cardControlTestAndroid();

			iOSLogs.setupTestYellow("*LOGIN SCENARIOS*");
			autoAccountLoginScenariosRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: QUICK LOGIN LOGOUT TESTS***");
			iOSLogs.setupTestYellow("*QUICK LOGIN LOGOUT TESTS*");
			autoAccountQuickLoginLogoutRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			// to many cards get loaded need max 3
			// System.out.println("***Inside: MULIT CARD LOGIN TESTS***");
			// iOSLogs.setupTestYellow("*MULIT CARD LOGIN TESTS*");
			// autoAccountMultiCardLogin.cardControlTestAndroid();

			// System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			// iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			// autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: PIN OR PASSCODE TESTS***");
			iOSLogs.setupTestYellow("*PIN OR PASSCODE TESTS*");
			forgotPINorPasscodeRun.cardControlTestiOS();

			System.out.println("***Inside: MULIT CARD LOGIN TESTS***");
			iOSLogs.setupTestYellow("*MULIT CARD LOGIN TESTS*");
			autoAccountMultiCardLogin.cardControlTestAndroid();

			iOSLogs.CapturedLogs(info, "CARDCONTROL LOGIN SMOKE TESTING COMPLETE");

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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}