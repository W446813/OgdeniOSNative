package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class PayInvoiceBilling {
	Logs iOSLogs = new Logs();
	ScrollOptionsiOS pull = new ScrollOptionsiOS();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	Wait appWait = new Wait();
	AppStringsiOS iOSText = new AppStringsiOS();
	ProgressSpinneriOS spinner=new ProgressSpinneriOS();
	
	static AppiumDriver<WebElement> driver;
	public PayInvoiceBilling payInvoice() throws Exception {
		Thread.sleep(3000);
		iOSLogs.setupTest("Tests for Pay Invoice in Billing Tab");
		WebElement SelectAR = elements.SelectAR();
		Thread.sleep(3000);
		if(SelectAR!=null && SelectAR.isEnabled()) {
			SelectAR.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "AR selected.");
			elements.PayNowButton().click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Pay now button selected.");
			//elements.SelectInvoice().click(); //it is selected by default when page opens
			Thread.sleep(3000);
			elements.SelectNextButton().click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Next button selected.");
			
			WebElement SelectBankAccount = elements.SelectBankAccount();
			Thread.sleep(3000);
			if (SelectBankAccount!=null && SelectBankAccount.isEnabled()) {
				SelectBankAccount.click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Bank account selected.");
				elements.SelectNextButton().click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Next button selected.");
			}
			elements.EditPaymentAmountButton().click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Edit Payment Amount button clicked.");
			elements.PaymentAmountTextBox().click();
			elements.XClearText().click();
			elements.PaymentAmountTextBox().sendKeys("1.00");
			iOSLogs.CapturedLogs(iOSText.PASS, "Payment amount entered.");
			elements.SaveButton().click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Save button selected");
			elements.SchedulePaymentButton().click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Schedule payment button clicked.");
			
			spinner.progressSpinnerSchedulePaymentBilling();
			
		//	appWait.WaitForDoneButtonBilling3000();
			elements.DoneButton().click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Done button clicked.");
		}
		return this;
		}

}
