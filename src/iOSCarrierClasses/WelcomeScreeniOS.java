package iOSCarrierClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class WelcomeScreeniOS {
	Logs logs = new Logs();
	Sleep appSleep = new Sleep();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;
	OpenAndLoginCarrierControl reopenApp = new OpenAndLoginCarrierControl();
	AppStringsiOS iOSText = new AppStringsiOS();

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	@Test
	public WelcomeScreeniOS welomeScreen() throws Exception {
		logs.setupTest("Welcome Screen Testing");
		try {
			if (elements.WelcomeScreen().isEnabled()) {
				int welcomeScreen = 0;
				while (welcomeScreen < 3) {
					logs.CapturedLogs(pass, "Welcome screen is seen.");
					// this is the long press move to new location on screen needed for screen
					// scroll
					new TouchAction<>(Capabilities.driver).longPress(PointOption.point(1000, 1390))
							.moveTo(PointOption.point(60, 1390)).release().perform();
					appSleep.ThreadSleep1();
					welcomeScreen++;
				}

				if (elements.getStarted().isDisplayed()) {
					elements.getStarted().click();
				}

			} else {
				logs.CapturedLogs(info, "Welcome screen is not seen or has been closed on prior run.");
			}
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println(e.getMessage());
			logs.CapturedLogs(info, "Welcome screen is not seen or has been closed on prior run.");
		}
		return this;
	}
}
