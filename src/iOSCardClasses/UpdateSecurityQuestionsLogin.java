package iOSCardClasses;
import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;

public class UpdateSecurityQuestionsLogin {
	public UpdateSecurityQuestionsLogin() {
	}

	public void CardPassExpected() throws Exception {
		Logs iOSLogs = new Logs();
		Sleep appSleep = new Sleep();
		AppStringsiOS iOSText = new AppStringsiOS();
		iOSLogs.setupTest("Login test");

		AppStringsiOS cardText = new AppStringsiOS();
		RepoCardiOS xpath = new RepoCardiOS();

		iOSLogs.CapturedLogs(iOSText.INFO, "Login Pass Expected Testing started.");

		WebElement CardNumberTextBox = xpath.CardNumberTextBox();

		appSleep.ThreadSleep3000();
		if (CardNumberTextBox.isEnabled()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(cardText.getENVData("SECURITY_QUESTION_CARD_NUM_0065"));
			iOSLogs.CapturedLogs(iOSText.PASS, "Card Number entered.");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Card Number text box is not found");
		}

		WebElement PinPassTextBox = xpath.PinPassTextBox();

		if (PinPassTextBox.isDisplayed()) {
			PinPassTextBox.sendKeys(cardText.getENVData("SECURITY_QUESTION_CARD_PIN_0065"));
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Pin/passcode text box is not found");
		}

		WebElement CardLoginButton = xpath.CardLoginButton();

		if (CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Login Button Clicked");

		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Login Button is not found");
		}

//					//Close facial reg software modal with cancel click. needs some work.
//					try {
//						WebElement facialReg = Capabilities.driver.findElementByXPath(appText.facialReg());			
//						facialReg.click();
//						keepThisLog.CapturedLogs("Test Info", "Face ID Modal is now closed or canceled");
//
//					} catch (Exception exp) {
//						keepThisLog.CapturedLogs("Test Info", "Face ID Modal was already closed or canceled on a prior run");
//					}
//					
//					
//					//Close facial reg software modal with Don't allow click. Needs some work...
//						try {
//						WebElement faceIDAllow = Capabilities.driver.findElementByXPath(appText.faceIDAllow());
//						faceIDAllow.click();
//						keepThisLog.CapturedLogs("Test Info", "Face ID Allow modal is closed Don't allow was selected");
//
//						}catch (Exception exp) {
//							keepThisLog.CapturedLogs("Test Info", "Face ID Allow modal was already closed or canceled on a prior run");
//						}
//					
//					
//					//Close touch ID reg software modal with Don't allow click.
//						try {
//						WebElement touchIDCancel = Capabilities.driver.findElementByXPath(appText.touchIDCancel());	
//						touchIDCancel.click();
//						keepThisLog.CapturedLogs("Test Info", "Touch ID Cancel Modal is closed Cancel was selected");
//
//					} catch (Exception exp) {
//						keepThisLog.CapturedLogs("Test Info", "Touch ID Allow modal was already closed or canceled on a prior run");
//					}
			}

		}
