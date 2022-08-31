package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;


//import io.appium.java_client.AppiumDriver;

public class CarrierLoginPassVerification {
	public CarrierLoginPassVerification() {
	}
	
	//TODO Add to all 		
			private String env;
			//TODO Add to all 		
				public void CarrierLoginFailVerification(String environment) throws Exception {
					this.env = environment;
					CarrierPassExpected();
				}

	// AppiumDriver<WebElement> driver;

	// static WebDriver driverWeb;

	public void CarrierPassExpected() throws Exception {
		
		
		Sleep appSleep = new Sleep();
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
//		InputText appText = new InputText();
		RepoCarrieriOS xpath = new RepoCarrieriOS();
		

		iOSLogs.setupTest("Login Pass Expected testing");	
		Thread.sleep(3000);
		
		WebElement invalidModalOKButton = xpath.InvalidModalOkButton();
		Thread.sleep(3000);
		if (invalidModalOKButton != null && invalidModalOKButton.isDisplayed()) {
			invalidModalOKButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Ok Button to close modal was pressed and modal closed");
			appSleep.ThreadSleep1();
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Ok Button to close modal was not found");

		}

		WebElement carrierNumberLoginPass = xpath.CarrierNumFailTextField();
		Thread.sleep(3000);
		iOSLogs.CapturedLogs(iOSText.PASS, "Login Pass Verification started succesfully.");

		if (carrierNumberLoginPass.isDisplayed()) {
			carrierNumberLoginPass.click();
			carrierNumberLoginPass.clear();
			carrierNumberLoginPass.click();
		
			Thread.sleep(3000);
			WebElement selectAllText = xpath.SelectAllText();
			Thread.sleep(3000);
			
			selectAllText.click();
			Thread.sleep(3000);
			WebElement cutText = xpath.CutAllText();
			cutText.click();
//			WebElement deleteText = Capabilities.driver.findElementByXPath(appText.deleteText());
//			deleteText.click();

			carrierNumberLoginPass.sendKeys(iOSText.CARRIER_LOGIN_ID_SMARTFUNDS);

			Thread.sleep(3000);
			iOSLogs.CapturedLogs(iOSText.PASS, "Carrier Number entered.");

			appSleep.ThreadSleep1();
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Carrier Number text box was not found");
		}

		appSleep.ThreadSleep1();

		// Find the login Password textbox tell if find or fail.
		WebElement pass = xpath.PasswordTextbox();
		Thread.sleep(3000);
		if (pass.isDisplayed()) {
			pass.click();
			pass.clear();
			pass.click();
		
			Thread.sleep(3000);
			WebElement selectAllText = xpath.SelectAllText();
			selectAllText.click();
			pass.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS);
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Password text box is not found");
			}

		WebElement loginKey = xpath.LoginButtonCarrier();
		Thread.sleep(3000);
		if (loginKey.isEnabled()) {
			Thread.sleep(3000);
			loginKey.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Login Button Pressed.");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Login Button was not found");
		}

	}

}
