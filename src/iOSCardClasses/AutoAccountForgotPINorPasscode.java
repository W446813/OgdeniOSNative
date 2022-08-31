package iOSCardClasses;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;

public class AutoAccountForgotPINorPasscode {

private String env;
private String passwordOrPin;
private String accountType;
private String cardNumber;
private String tempPasswordOrPin;

	public void ForgotPINorPasscode(String environment, String cardNum, String accntType) throws Exception {
		this.env = environment;
		this.cardNumber = cardNum;
		this.accountType = accntType;
		this.tempPasswordOrPin = "985477";
		ForgotPINorPasscode();
	}
	
	public AutoAccountForgotPINorPasscode ForgotPINorPasscode() throws Exception {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCardiOS elements = new RepoCardiOS();
		iOSText = new AppStringsiOS(env);
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
	
		
		iOSLogs.setupTest("Forgot Pin or Passcode");
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeLink = elements.ForgotPINorPasscodeLink();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeLink != null && ForgotPINorPasscodeLink.isEnabled()) {
			ForgotPINorPasscodeLink.click();
			iOSLogs.CapturedLogs(pass, "Forgot PIN or passcode link clicked and opened.");
		} else {
			iOSLogs.CapturedLogs(fail, "Forgot PIN or passcode link not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeCardNumberTextBox = elements.ForgotPINorPasscodeCardNumberTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeCardNumberTextBox != null && ForgotPINorPasscodeCardNumberTextBox.isEnabled()) {
			ForgotPINorPasscodeCardNumberTextBox.click();
			ForgotPINorPasscodeCardNumberTextBox.clear();
			ForgotPINorPasscodeCardNumberTextBox.sendKeys(cardNumber);
			iOSLogs.CapturedLogs(pass, "Card number text box found and card number entered");
		} else {
			iOSLogs.CapturedLogs(fail,
					"Card number text box for " + cardNumber + " not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton != null && ForgotPINorPasscodeNextButton.isEnabled()) {
			ForgotPINorPasscodeNextButton.click();
			iOSLogs.CapturedLogs(pass, "Next button for clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeSecurityAnswerTextBox = elements.ForgotPINorPasscodeSecurityAnswerTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeSecurityAnswerTextBox != null && ForgotPINorPasscodeSecurityAnswerTextBox.isEnabled()) {
			ForgotPINorPasscodeSecurityAnswerTextBox.click();
			ForgotPINorPasscodeSecurityAnswerTextBox.sendKeys("test");
			iOSLogs.CapturedLogs(pass, "Security answer text box found and answer entered");
		} else {
			iOSLogs.CapturedLogs(fail, "security answer text box not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton2 = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton2 != null && ForgotPINorPasscodeNextButton2.isEnabled()) {
			ForgotPINorPasscodeNextButton2.click();
			iOSLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNewPasscodeTextBox = elements.ForgotPINorPasscodeNewPasscodeTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNewPasscodeTextBox != null && ForgotPINorPasscodeNewPasscodeTextBox.isEnabled()) {
			ForgotPINorPasscodeNewPasscodeTextBox.click();
			ForgotPINorPasscodeNewPasscodeTextBox.sendKeys(tempPasswordOrPin);
			iOSLogs.CapturedLogs(pass, "New passcode entered");
		} else {
			iOSLogs.CapturedLogs(fail, "New passcode text box not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeConfirmPasscodeTextBox = elements.ForgotPINorPasscodeConfirmPasscodeTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeConfirmPasscodeTextBox != null
				&& ForgotPINorPasscodeConfirmPasscodeTextBox.isEnabled()) {
			ForgotPINorPasscodeConfirmPasscodeTextBox.click();
			ForgotPINorPasscodeConfirmPasscodeTextBox.sendKeys(tempPasswordOrPin);
			iOSLogs.CapturedLogs(pass, "Confirm passcode entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Confirm passcode text box not found");
		}
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton3 = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton3 != null && ForgotPINorPasscodeNextButton3.isEnabled()) {
			ForgotPINorPasscodeNextButton3.click();
			iOSLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeDoneButton = elements.ForgotPINorPasscodeDoneButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeDoneButton != null && ForgotPINorPasscodeDoneButton.isEnabled()) {
			ForgotPINorPasscodeDoneButton.click();
			iOSLogs.CapturedLogs(pass, "Forgot pin passcode continue to home button clicked to Log in");
		} else {
			iOSLogs.CapturedLogs(fail, "Forgot pin passcode continue to home button not found.");
		}
		Thread.sleep(5000);
		
		return this;
	}
}
