package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.OpenCarrierControlUsingDatabase;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class LoginScenariosRun {
	String appName = "Carrier Control";
	
	// cntrl shft f cleans up the format.
	// sysout + cntrl + space == System.out.println();
	// sout + cntr + space = System.out.println();

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
		// Carrier Control Test menu items.
		//On each menu item open the associated page and then go back to home page followed by a logout.
//		//Tests for Carrier Control app
		try {
		
			OpenCarrierControlUsingDatabase.openCarrierControl();
			Logout.logOutCarrierControll();
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Login Scenarios Functional test completed");
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
	}