package iOSCardClasses;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;



//import io.appium.java_client.AppiumDriver;

public class MultiCardLoginCheck {
	public MultiCardLoginCheck() {
	}

	public void MultiCardLoginCheck() throws Exception {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		ScrollOptionsiOS scroll = new ScrollOptionsiOS();
		RepoCardiOS elements=new RepoCardiOS();
		
		iOSLogs.setupTest("Check for Multi card login page");
		iOSLogs.CapturedLogs(iOSText.INFO, "Multi card Login page check Testing started.");

		Thread.sleep(3000);
		

		WebElement CheckForMuliCardLogin = elements.CheckForMuliCardLogin();
		Thread.sleep(3000);
		if (CheckForMuliCardLogin != null && CheckForMuliCardLogin.isDisplayed()) {
			
			iOSLogs.CapturedLogs(iOSText.PASS, "Multi card text loaded to page");
		

		
		scroll.ScrollDown();
		scroll.ScrollDown();
		scroll.ScrollDown();
		Thread.sleep(3000);
		
		WebElement SignInWithDifferentcardButton = elements.SignInWithDifferentcardButton();
		Thread.sleep(3000);
		if (SignInWithDifferentcardButton != null && SignInWithDifferentcardButton.isDisplayed()) {
			SignInWithDifferentcardButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Sign in with different card Button selected.");
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Sign in with different card Button Not found");
		}
		
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Multi Card Login page Not found as expected with single card login");
		}

	}

}
