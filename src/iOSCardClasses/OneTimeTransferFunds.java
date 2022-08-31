package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class OneTimeTransferFunds {
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements=new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText=new AppStringsiOS();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	
	public OneTimeTransferFunds OneTImeTransferFunds() throws Exception {
		iOSLogs.setupTest("One Time Transfer Funds Test");
		
		iOSLogs.CapturedLogs(info, "One time transfer flow test");
		
		Thread.sleep(3000);
		WebElement TransferFundsButton = elements.TransferFundsButton();
		Thread.sleep(3000);
		if (TransferFundsButton != null && TransferFundsButton.isEnabled()) {
			TransferFundsButton.click();
			iOSLogs.CapturedLogs(pass, "Transfer funds button clicked");
		} else {
			iOSLogs.CapturedLogs(info, "Transfer funds button not found or unavailable in this card type");
		}
	
		Thread.sleep(2000);
		WebElement OneTimeTransferRadioButton = elements.OneTimeTransferRadioButton();
		Thread.sleep(3000);
		if (OneTimeTransferRadioButton != null && OneTimeTransferRadioButton.isEnabled()) {
			OneTimeTransferRadioButton.click();
			iOSLogs.CapturedLogs(pass, "One time transfer radio button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "One time transfer radio button not found");
		}
		
		Thread.sleep(2000);
		WebElement NextTransferFundsButton = elements.NextTransferFundsButton();
		Thread.sleep(3000);
		if (NextTransferFundsButton != null && NextTransferFundsButton.isEnabled()) {
			NextTransferFundsButton.click();
			iOSLogs.CapturedLogs(pass, "Next button Transfer type screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button Transfer type screeb not found");
		}
		
		Thread.sleep(3000);
		WebElement SelectBankAccount = elements.SelectBankAccount();
		Thread.sleep(3000);
		if (SelectBankAccount != null && SelectBankAccount.isEnabled()) {
			SelectBankAccount.click();
			iOSLogs.CapturedLogs(pass, "Bank account selected");
		} else {
			iOSLogs.CapturedLogs(fail, "Bank account not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonTransferTo = elements.NextTransferFundsButtonTransferTo();
		Thread.sleep(3000);
		if (NextTransferFundsButtonTransferTo != null && NextTransferFundsButtonTransferTo.isEnabled()) {
			NextTransferFundsButtonTransferTo.click();
			iOSLogs.CapturedLogs(pass, "Next button transfer to screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button transfer to screen not found");
		}
		
		Thread.sleep(3000);
		WebElement EnterAmountTextBox = elements.EnterAmountTextBox();
		Thread.sleep(3000);
		if (EnterAmountTextBox != null && EnterAmountTextBox.isEnabled()) {
			EnterAmountTextBox.sendKeys(iOSText.REGISTER_CHECK_AMOUNT);
			iOSLogs.CapturedLogs(pass, "Amount entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Amount textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonEnterAmount = elements.NextTransferFundsButtonTransferTo();
		Thread.sleep(3000);
		if (NextTransferFundsButtonEnterAmount != null && NextTransferFundsButtonEnterAmount.isEnabled()) {
			NextTransferFundsButtonEnterAmount.click();
			iOSLogs.CapturedLogs(pass, "Next button enter amount screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button enter amount screen not found");
		}
		
		
		Thread.sleep(3000);
		WebElement SubmitButton = elements.SubmitButton();
		Thread.sleep(3000);
		if (SubmitButton != null && SubmitButton.isEnabled()) {
			SubmitButton.click();
			iOSLogs.CapturedLogs(pass, "Submit button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Submit button not found");
		}
		
		Thread.sleep(6000);
		WebElement DismissButtonTransferFunds = elements.DismissButtonTransferFunds();
		Thread.sleep(3000);
		if (DismissButtonTransferFunds != null && DismissButtonTransferFunds.isEnabled()) {
			DismissButtonTransferFunds.click();
			iOSLogs.CapturedLogs(pass, "Dismiss button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Dismiss button not found");
		}
		Thread.sleep(3000);
		return this;
	}
}
