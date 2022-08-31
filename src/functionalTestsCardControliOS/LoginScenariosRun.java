package functionalTestsCardControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCardClasses.LoginLogoutTesting;
import iOSCardClasses.LogoutCardControl;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class LoginScenariosRun {	
static AppiumDriver<WebElement> driver;
String appName = "Card Control";

@Test
public void cardControlTestiOS() {
	Logs iOSLogs = new Logs();
	LogoutCardControl Logout = new LogoutCardControl();
	Sleep appSleep =new Sleep();
	AppStringsiOS iOSText = new AppStringsiOS();
	LoginLogoutTesting LoginLogoutTesting = new LoginLogoutTesting();
	
	try {
	appSleep.ThreadSleep3000();
//login logout testing Card Control	
	LoginLogoutTesting.openCardControl();
	Thread.sleep(6000);
	Logout.LogoutCardControl();
	iOSLogs.CapturedLogs(iOSText.INFO, "Login Scenarios Functional Test completed.");
	
	Capabilities.driver.closeApp();
	Capabilities.driver.quit();
	
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