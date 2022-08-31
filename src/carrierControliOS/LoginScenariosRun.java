package carrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.OpenCarrierControlUsingDatabase;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class LoginScenariosRun {
	static AppiumDriver<WebElement> driver;

//	// static WebDriver driverWeb;
//	public static void main(String[] args) {
//		System.out.println("Test Info " + "------Test--------Running using Java----------");
//		carrierControliOSLoginLogout();
//	}

	@Test
	public void carrierControliOSLoginLogout() {
		LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		OpenCarrierControlUsingDatabase OpenCarrierControlUsingDatabase = new OpenCarrierControlUsingDatabase();
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		// ADD INFO FOR WHAT YOU ARE RUUNING TEST NAME USUALLY = CLASS NAME
		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Login Scenarios ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "Partner ";

		// Carrier Control Test menu items.
		// On each menu item open the associated page and then go back to home page
		// followed by a logout.
//		//Tests for Carrier Control app
		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);
		
			OpenCarrierControlUsingDatabase.openCarrierControl();
			Logout.logOutCarrierControll();

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