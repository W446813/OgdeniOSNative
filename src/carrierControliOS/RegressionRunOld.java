package carrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.OpenCarrierControlDirectLogin;
import iOSCarrierClasses.OpenCarrierControlUsingDatabase;
import iOSCarrierClasses.OpenCompanyCC;
import iOSCarrierClasses.OpenSubUserCarrierControl;
import iOSCarrierClasses.OpenUniversalCC;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class RegressionRunOld {

//iOS
	// cntrl shft f cleans up the format..
	// sysout + cntrl + space == System.out.println();
	// sout + cntr + space = System.out.println();
	static AppiumDriver<WebElement> driver;

//	// static WebDriver driverWeb;
//		public static void main(String[] args) {
//			System.out.println("Test Info " + "------Test--------Running using Java----------");
//			FunctionalTesting();
//		}
//	

	
	@Test
	public void FunctionalTesting() {
		Logs iOSLogs = new Logs();
		LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
		Sleep appSleep = new Sleep();
		AppStringsiOS iOSText = new AppStringsiOS();
		OpenCarrierControlDirectLogin OpenCarrierControlDirectLogin = new OpenCarrierControlDirectLogin();
		OpenSubUserCarrierControl OpenSubUserCarrierControl = new OpenSubUserCarrierControl();
		LoginScenariosRun loginLogoutTest = new LoginScenariosRun();
		
		
		// Carrier Control Test menu items.
		// On each menu item open the associated page and then go back to home page
		// followed by a logout.
		// Tests for Carrier Control app
		
		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Regression Old ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "Partner ";

		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);
		
			loginLogoutTest.carrierControliOSLoginLogout();
			iOSLogs.CapturedLogs(iOSText.PASS, "Login Logout testing completed");

			iOSLogs.setupTest("Account setup test logs for 100045");
			OpenCarrierControlDirectLogin.openCarrierControl();
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.PASS, "SmartFunds User Testing is now logging out.");

			// Run sub user tests
			OpenSubUserCarrierControl.openCarrierControl();
			// App is given good login details and logs in successfully.
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.PASS, "Sub User Testing is now logging out.");

			appSleep.ThreadSleep3000();

			// Run Universal tests
			OpenUniversalCC.openCarrierControl();
			// App is given good login details and logs in successfully.
			Logout.logOutCarrierControll();

			/// logged out now adding closing remarks to test.
			iOSLogs.CapturedLogs(iOSText.PASS, "Universal User Testing is now logging out.");

//			Run Company tests	
//			OpenCompanyCC.openCarrierControl();
//			Logout.logOutCarrierControll();			
//			iOSLogs.CapturedLogs(iOSText.PASS, "Company Testing is now logging out.");

			iOSLogs.CapturedLogs(iOSText.PASS, "Regression testing completed.");

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
}