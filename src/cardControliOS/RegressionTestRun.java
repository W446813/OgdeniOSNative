package cardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import functionalTestsCardControliOS.AutoAccountAccountPage;
import functionalTestsCardControliOS.AutoAccountDynamicPINRun;
import functionalTestsCardControliOS.AutoAccountForgotPINorPasscodeRun;
import functionalTestsCardControliOS.AutoAccountLoginScenariosRun;
import functionalTestsCardControliOS.AutoAccountMultiCardDelete;
import functionalTestsCardControliOS.AutoAccountMultiCardLogin;
import functionalTestsCardControliOS.AutoAccountQuickLoginLogoutRun;
import functionalTestsCardControliOS.AutoAccountRegisterCheckRun;
import functionalTestsCardControliOS.AutoAccountResetPinAndPasswordFromProfileRun;
import functionalTestsCardControliOS.AutoAccountSecureFuelRun;
import functionalTestsCardControliOS.AutoAccountSetupProfileRun;
import functionalTestsCardControliOS.AutoAccountTransferFundsRun;
import functionalTestsCardControliOS.ForgotPINorPasscodeRun;
import iOSCardClasses.LogoutCardControl;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class RegressionTestRun {
	static AppiumDriver<WebElement> driver;

//public static void main(String[] args) throws Exception {
//		Logs iOSLogs = new Logs();
//		cardControlTestiOS();
//	}

	@Test
	public void cardControlTestiOS() {
		Logs iOSLogs = new Logs();
		LogoutCardControl Logout = new LogoutCardControl();
		AppStringsiOS iOSText = new AppStringsiOS();

		AutoAccountAccountPage autoAccountAccountPage = new AutoAccountAccountPage();
		AutoAccountDynamicPINRun autoAccountDynamicPINRun = new AutoAccountDynamicPINRun();
		AutoAccountMultiCardLogin autoAccountMultiCardLogin = new AutoAccountMultiCardLogin();
		AutoAccountQuickLoginLogoutRun autoAccountQuickLoginLogoutRun = new AutoAccountQuickLoginLogoutRun();
		AutoAccountRegisterCheckRun autoAccountRegisterCheckRun = new AutoAccountRegisterCheckRun();
		AutoAccountResetPinAndPasswordFromProfileRun autoAccountResetPinAndPasswordFromProfileRun = new AutoAccountResetPinAndPasswordFromProfileRun();
		AutoAccountSecureFuelRun autoAccountSecureFuelRun = new AutoAccountSecureFuelRun();
		AutoAccountSetupProfileRun autoAccountSetupProfileRun = new AutoAccountSetupProfileRun();
		AutoAccountTransferFundsRun autoAccountTransferFundsRun = new AutoAccountTransferFundsRun();
		ForgotPINorPasscodeRun forgotPINorPasscodeRun = new ForgotPINorPasscodeRun();
		AutoAccountMultiCardDelete autoAccountMultiCardDelete = new AutoAccountMultiCardDelete();
		AutoAccountLoginScenariosRun autoAccountLoginScenariosRun = new AutoAccountLoginScenariosRun();
		AutoAccountForgotPINorPasscodeRun autoAccountForgotPINorPasscodeRun = new AutoAccountForgotPINorPasscodeRun();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Regression ";
		String build = "Build #: 5.0.3 (20220401.1) ";
		String appName = "Card Control ";
		String server = "PARTNER ";

		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			iOSLogs.setupTestYellow("*LOGIN SCENARIOS*");
			autoAccountLoginScenariosRun.cardControlTestiOS();

			System.out.println("***Inside: ACCOUNT PAGE TESTS***");
			iOSLogs.setupTestYellow("*ACCOUNT PAGE TESTS*");
			autoAccountAccountPage.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: DYNAMIC PIN TESTS***");
			iOSLogs.setupTestYellow("*DYNAMIC PIN TESTS*");
			autoAccountDynamicPINRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: RESET PIN AND PASSCODE FROM PROFILE TESTS***");
			iOSLogs.setupTestYellow("*RESET PIN AND PASSCODE FROM PROFILE TESTS*");
			autoAccountResetPinAndPasswordFromProfileRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: SECURE FUEL TESTS***");
			iOSLogs.setupTestYellow("*SECURE FUEL TESTS*");
			autoAccountSecureFuelRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

//TODO setup profile address selector first page not working....		
//		System.out.println("***Inside: SETUP POFILE TESTS***");
//		iOSLogs.setupTestYellow("*SETUP POFILE TESTS*");
//		autoAccountSetupProfileRun.cardControlTestiOS();

//			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
//			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
//			autoAccountMultiCardDelete.cardControlTestAndroid();

//			System.out.println("***Inside: TRANSFER FUNDS TESTS***");
//			iOSLogs.setupTestYellow("*TRANSFER FUNDS TESTS*");
//			autoAccountTransferFundsRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: PIN OR PASSCODE TESTS***");
			iOSLogs.setupTestYellow("*PIN OR PASSCODE TESTS*");
			forgotPINorPasscodeRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: ACCOUNT PROFILE TESTS***");
			iOSLogs.setupTestYellow("*ACCOUNT PROFILE TESTS*");
			autoAccountAccountPage.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: QUICK LOGIN LOGOUT TESTS***");
			iOSLogs.setupTestYellow("*QUICK LOGIN LOGOUT TESTS*");
			autoAccountQuickLoginLogoutRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: REGISTER CHECK TESTS***");
			iOSLogs.setupTestYellow("*REGISTER CHECK TESTS*");
			autoAccountRegisterCheckRun.cardControlTestiOS();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: MULIT CARD LOGIN TESTS***");
			iOSLogs.setupTestYellow("*MULIT CARD LOGIN TESTS*");
			autoAccountMultiCardLogin.cardControlTestAndroid();

			System.out.println("***PRE TEST CHECK FOR MULTI CARDS***");
			iOSLogs.setupTestYellow("*PRE TEST CHECK FOR MULTI CARDS*");
			autoAccountMultiCardDelete.cardControlTestAndroid();

			System.out.println("***Inside: RESET PIN OR PASSCODE BUTTON***");
			iOSLogs.setupTestYellow("*RESET PIN OR PASSCODE BUTTON TESTS*");
			autoAccountForgotPINorPasscodeRun.cardControlTestiOS();

			iOSLogs.CapturedLogs(info, "CARDCONTROL SMOKE TESTING COMPLETE");

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