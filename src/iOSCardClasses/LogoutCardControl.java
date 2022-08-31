package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSCarrierClasses.InputText;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class LogoutCardControl {

	 AppiumDriver<WebElement> driver;

	Logs iOSLogs = new Logs();
	Wait appWait = new Wait();
	InputText appText = new InputText();
	RepoCardiOS xpath = new RepoCardiOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	

		public LogoutCardControl LogoutCardControl() throws Exception {
			iOSLogs.setupTest("Testing Logout ");
			Thread.sleep(3000);
			WebElement ProfileButton = xpath.ProfileButton();
			Thread.sleep(3000);
			if (ProfileButton != null && ProfileButton.isEnabled()) {
				ProfileButton.click();
				iOSLogs.CapturedLogs(pass, "Profile Button is found and pressed.");
			} else {
				iOSLogs.CapturedLogs(fail, "Profile Button is not found");
			}
			
			
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = xpath.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}

			Thread.sleep(3000);
			scroll.ScrollDown();
			scroll.ScrollDown();
			
				
				WebElement logoutButton = xpath.CardLogoutButton();
				Thread.sleep(3000);
				if (logoutButton != null && logoutButton.isEnabled()) {
					logoutButton.click();
					iOSLogs.CapturedLogs(pass, "Logout Button is clicked.");

				} else {
					iOSLogs.CapturedLogs(fail, "Logout Button is not found");
				}

				// find logout cancel modal button click it open the logout modal again and
				
				WebElement logoutModalCancelButton = xpath.CardlogoutModalCancelButton();
				Thread.sleep(3000);
					if (logoutModalCancelButton != null && logoutModalCancelButton.isEnabled()) {
					logoutModalCancelButton.click();
					logoutButton.click();
					iOSLogs.CapturedLogs(pass, "Logout Modal Cancel Button is clicked.");

				} else {
					iOSLogs.CapturedLogs(fail, "Logout Modal cancel Button is not found");

				}
				
					WebElement logoutButtonTwo = xpath.CardLogoutButton();
					Thread.sleep(3000);
					if (logoutButtonTwo != null && logoutButton.isEnabled()) {
						logoutButtonTwo.click();
						iOSLogs.CapturedLogs(pass, "Logout Button is clicked.");

					} else {
						iOSLogs.CapturedLogs(fail, "Logout Button is not found");
					}
					
				
					WebElement logoutModalLogoutButton = xpath.CardlogoutModalLogoutButton();
					Thread.sleep(3000);
					if (logoutModalLogoutButton != null && logoutModalLogoutButton.isEnabled()) {
					logoutModalLogoutButton.click();
					iOSLogs.CapturedLogs(pass, "Logout Modal Button clicked.");
					
								
					}else {
						
						iOSLogs.CapturedLogs(fail, "Logout Modal Button not found.");
					}
				

				return this;

			}

}
