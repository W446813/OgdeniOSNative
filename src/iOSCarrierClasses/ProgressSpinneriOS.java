package iOSCarrierClasses;

import org.openqa.selenium.WebElement;



//import org.testng.ITestResult;
//import org.testng.Reporter;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class ProgressSpinneriOS {
	Logs iOSLogs = new Logs();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	static AppiumDriver<WebElement> driver;

	public ProgressSpinneriOS progressSpinnerWaitForRejects() throws Exception {
		// check progress spinner
		Thread.sleep(2000);
		WebElement progressSpinnerWaitForRejectsViewAll = elements.loadingRejectsSpinnerText();
		iOSLogs.CapturedLogs(iOSText.INFO, "Loading spinner checker started");
		while (progressSpinnerWaitForRejectsViewAll != null && progressSpinnerWaitForRejectsViewAll.isDisplayed()) {
			// androidLogs.CapturedLogs(androidText.INFO, "Progress spinnnerSubmit Payment
			// on invoice seen waiting 3000");
			Thread.sleep(3000);
			progressSpinnerWaitForRejectsViewAll = elements.loadingRejectsSpinnerText();
		}
		iOSLogs.CapturedLogs(iOSText.INFO, "Loading spinner on page checker completed");
		return this;
	}
			
	public ProgressSpinneriOS progressSpinnerSchedulePaymentBilling() throws Exception {
		Thread.sleep(2000);
		WebElement progressSpinnerSubmitPaymentInvoice = elements.progressSpinnerSchedulePaymentBilling();
		iOSLogs.CapturedLogs(iOSText.INFO, "Loading spinner checker started");
		while (progressSpinnerSubmitPaymentInvoice != null && progressSpinnerSubmitPaymentInvoice.isDisplayed()) {
			Thread.sleep(3000);
			progressSpinnerSubmitPaymentInvoice = elements.progressSpinnerSchedulePaymentBilling();
		}
		iOSLogs.CapturedLogs(iOSText.INFO, "Loading spinner on page checker completed");
		return this;
	}
	
}
