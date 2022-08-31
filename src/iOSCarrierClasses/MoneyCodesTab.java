package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class MoneyCodesTab {

	Sleep appSleep = new Sleep();
	Logs iOSLogs = new Logs();
	Wait appWait = new Wait();
	InputText appText = new InputText();
	ScrollOptionsiOS pull = new ScrollOptionsiOS();
	CreateMoneyCode newMoneyCode = new CreateMoneyCode();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;

	public MoneyCodesTab moneyCodesTab() throws Exception {
		iOSLogs.setupTest("Testing MoneyCodes tab");
		// find MoneyCodes tab and click it.
		
		Thread.sleep(5000);
		WebElement MoneyCodesTab = elements.MoneyCodesTab();
		if (MoneyCodesTab.isEnabled()) {
			MoneyCodesTab.click();
			iOSLogs.CapturedLogs(pass, "MoneyCodes Tab is opened.");
			Thread.sleep(2000);
			pull.Refresh();
			//creates a new money code
			newMoneyCode.createMoneyCode();
		} else {
			iOSLogs.CapturedLogs(fail, "New MoneyCode Button was not found.");
		}

		return this;

	}
}
