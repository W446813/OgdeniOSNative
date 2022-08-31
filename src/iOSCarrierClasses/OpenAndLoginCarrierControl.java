package iOSCarrierClasses;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OpenAndLoginCarrierControl {

	 AppiumDriver<WebElement> driver;

	public static void openCarrierControl() throws Exception {
		Logs keepThisLog = new Logs();
		AppStringsiOS carrierText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
		ElementID id = new ElementID();
		AppStringsiOS iOSText = new AppStringsiOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		String appName = "Card Control";
		
		try {
			phone.autoPhonePickerCarrier(appName);
		
		 } catch (org.openqa.selenium.WebDriverException e) {
				keepThisLog.CapturedLogs("Test Fail", "No phone found plugged in.");
				System.out.println("Test Fail No phone found plugged in.");
			}
		 	// App opened display
		System.out.println("Carrier Control app Started succesfully");

		

		// App sleep and display

		Thread.sleep(1);
		
		// Find the login Username textbox tell if find or fail.

		try {
			WebElement userName = Capabilities.driver.findElementById("userinput");
			userName.click();

			Actions actionUserName = new Actions(Capabilities.driver);
			Actions actionReturn = new Actions(Capabilities.driver);

			actionUserName.sendKeys(carrierText.CARRIER_LOGIN_ID_SMARTFUNDS); // send user name value to carrier control app.

			actionReturn.sendKeys(Keys.RETURN);

			Thread.sleep(1);

			if (userName.isDisplayed()) {
				Thread.sleep(1);
				System.out.println("Username textbox is clicked...");

			}
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Username textbox is not found");
		}

		Thread.sleep(1); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");

		// Find the login Password textbox tell if find or fail.
		try {
			WebElement password = Capabilities.driver.findElementByName(id.LoginPinElement());
			password.click();

			Actions actionUserPassword = new Actions(Capabilities.driver);
			Actions actionReturn = new Actions(Capabilities.driver);

			actionUserPassword.sendKeys(carrierText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS).build().perform(); // send password to carrier control app

			actionReturn.sendKeys(Keys.RETURN).build().perform();

			
			Thread.sleep(1); // put to sleep to load next automation.
			System.out.println("Sleep succesfull");

			if (password.isDisplayed()) {
				Thread.sleep(1); // put to sleep to load next automation.
				System.out.println("Password textbox is clicked...");
				Thread.sleep(2000); // put to sleep to load next automation.

			}
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Password textbox is not found");
		}
	}

}
