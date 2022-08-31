package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class BillingTab {
  
	
	
	Sleep appSleep = new Sleep();
	Logs logs = new Logs();
	
	Wait appWait = new Wait();
	AppStringsiOS cardControlNumber = new AppStringsiOS();
	InputText appText = new InputText();	
	RepoCarrieriOS elements = new RepoCarrieriOS();
	PayInvoiceBilling payInvoice=new PayInvoiceBilling();
	AppStringsiOS iOSText = new AppStringsiOS();
	static AppiumDriver<WebElement> driver;
	
	public BillingTab BillingTab() throws Exception {
			logs.setupTest("Testing Billing tab");
			//Find and click the Payment tab and tap it to open Payment.
			try {
				Thread.sleep(3000);
				WebElement BillingTab = elements.BillingTab();
				Thread.sleep(3000);
					
				if (BillingTab != null && BillingTab.isDisplayed()) {
					BillingTab.click();
					logs.CapturedLogs(iOSText.PASS, "Billing tab found and opened");
					payInvoice.payInvoice();
				}
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println(e.getMessage());
			logs.CapturedLogs(iOSText.FAIL, "billing tab was not found");
		}
		
		return this;
	}
}

