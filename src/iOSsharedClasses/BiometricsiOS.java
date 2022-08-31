package iOSsharedClasses;

import org.openqa.selenium.WebElement;
import iOSCarrierClasses.RepoCarrieriOS;
import io.appium.java_client.AppiumDriver;

public class BiometricsiOS {
	Logs iOSLogs = new Logs();
	static AppiumDriver<WebElement> driver;
	Wait appWait = new Wait();
	Sleep appSleep = new Sleep();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;

	public BiometricsiOS BiometricsiOS() throws Exception {
		iOSLogs.setupTest("Biometrics Test");
		
		System.out.println("Thread sleep 5000 initiated for Biometrics (long wait)");
		Thread.sleep(5000);
		
		WebElement BiometricsXR = elements.BiometricsXR();

		if (BiometricsXR != null && BiometricsXR.isDisplayed()) {
			BiometricsXR.click();
			iOSLogs.CapturedLogs(pass, "Biometrics XR phone Don't allow button selected");

		} else {
			iOSLogs.CapturedLogs(info,
					"Biometrics XR phone Don't allow button not seen or was done on prior login");
		}

		System.out.println("Thread sleep 5000 initiated for Biometrics (long wait)");
		Thread.sleep(5000);
		WebElement BiometricsiPhone8 = elements.BiometricsiPhone8();

		if (BiometricsiPhone8 != null && BiometricsiPhone8.isDisplayed()) {
			BiometricsiPhone8.click();
			iOSLogs.CapturedLogs(pass, "Biometrics iPhone 8 Don't allow button selected");

		} else {
			iOSLogs.CapturedLogs(info,
					"Biometrics iPhone 8 Don't allow button not seen or was done on prior login");
		}

		return this;

	}
}
