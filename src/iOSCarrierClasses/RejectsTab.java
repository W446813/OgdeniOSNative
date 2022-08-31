package iOSCarrierClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class RejectsTab {

	Logs logs = new Logs();
	AppStringsiOS cardControlNumber = new AppStringsiOS();
	InputText appText = new InputText();
	ScrollOptionsiOS pull = new ScrollOptionsiOS();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	ProgressSpinneriOS loading = new ProgressSpinneriOS();

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	static AppiumDriver<WebElement> driver;

	@Test
	public RejectsTab rejectsTab() throws Exception {
		logs.setupTest("Testing Transactions tab");
		// find transactionsTab and click it.

		Thread.sleep(3000);
		WebElement rejectsTab = elements.rejectsTab();
		if (rejectsTab.isEnabled()) {
			rejectsTab.click();
			logs.CapturedLogs(pass, "Rejects Tab is opened.");

			Thread.sleep(2000); // put to sleep to load next automation.
			//pull.Refresh();
			
			loading.progressSpinnerWaitForRejects();

			Thread.sleep(5000);
			if (elements.WaitForTransaction().isEnabled()) {
				logs.CapturedLogs(pass, "Wait for transaction completed");

			} else {
				logs.CapturedLogs(fail, "Wait for transaction was not found.");
			}

			Thread.sleep(2000);
			WebElement ViewAllTop = elements.ViewAllTop();
			if (ViewAllTop != null && ViewAllTop.isDisplayed()) {
				ViewAllTop.click();
				logs.CapturedLogs(pass, "View all was clicked.");

			} else {
				logs.CapturedLogs(info, "View all top button not found.");
			}

			Thread.sleep(5000);
//TODO once we get card number search in lets add the ability to look for specific transactions right now they change to much...			
			WebElement WaitForRejectHistoryTransaction = elements.WaitForRejectHistoryTransaction();
			if (WaitForRejectHistoryTransaction != null && WaitForRejectHistoryTransaction.isDisplayed()) {
				Thread.sleep(2000);
				WaitForRejectHistoryTransaction.click();

				logs.CapturedLogs(pass, "Reject history Transaction found.");

			} else {
				logs.CapturedLogs(info, "Reject history Transaction not found");

			}

//			Thread.sleep(2000);
//			WebElement RejectDetailsBack = elements.RejectDetailsBack();
//			if (RejectDetailsBack != null && RejectDetailsBack.isEnabled()) {
//
//				logs.CapturedLogs(pass, "Reject Details transactions back button was found");
//
//				RejectDetailsBack.click();
//
//				logs.CapturedLogs(pass, "Reject Details transactions limit back button was clicked");
//
//			} else {
//				logs.CapturedLogs(fail, "Reject Details transactions limit back button was not found");
//			}

			Thread.sleep(3000);
			WebElement CardDetailButton = elements.CardDetailButton();
			if (CardDetailButton != null && CardDetailButton.isEnabled()) {
				CardDetailButton.click();
				logs.CapturedLogs(pass, "Card Details button was pressed");

			} else {
				logs.CapturedLogs(pass, "Card Details button was not found");
			}

			Thread.sleep(3000);
			if (elements.CardDetailsPage().isDisplayed()) {
				Thread.sleep(1); // put to sleep to load next automation.
				logs.CapturedLogs(pass, "Card details page is found");

				elements.CardDetailsPageBackButton().click();
				logs.CapturedLogs(pass, "Card Details page back button was clicked");

			} else {
				logs.CapturedLogs(info, "Card details page was not found");
			}

			Thread.sleep(2000);
			WebElement RejectDetailsBackButton = elements.RejectDetailsBackButton();
			if (RejectDetailsBackButton.isDisplayed()) {
				RejectDetailsBackButton.click();
				logs.CapturedLogs(pass, "Reject Details back button was clicked");

				Thread.sleep(2000);

			} else {
				logs.CapturedLogs(fail, "Reject Details Back button not found");
			}

			pull.ScrollDown();
			pull.ScrollDown();
			pull.ScrollUp();
			pull.ScrollUp();

//				new TouchAction<>(Capabilities.driver).longPress(PointOption.point(400, 800)).moveTo(PointOption.point(700, 500)).release().perform();
//				new TouchAction<>(Capabilities.driver).longPress(PointOption.point(400, 800)).moveTo(PointOption.point(700, 500)).release().perform();
//				new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 500)).moveTo(PointOption.point(700, 800)).release().perform();
//				new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 500)).moveTo(PointOption.point(700, 800)).release().perform();

			Thread.sleep(3000);
			WebElement RejectHistoryBackButton = elements.RejectHistoryBackButton();
			if (RejectHistoryBackButton.isDisplayed()) {
				RejectHistoryBackButton.click();
				logs.CapturedLogs(pass, "Reject history back button was clicked");

			} else {
				logs.CapturedLogs(info, "Reject History Back Button was not found");
			}

			Thread.sleep(3000);
			// added extra scroll to reject page
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(400, 800))
					.moveTo(PointOption.point(700, 500)).release().perform();

			logs.CapturedLogs(pass, "Scrolled down to view all button bottom.");

			Thread.sleep(2000);
			WebElement ViewAllBottomButton = elements.ViewAllBottomButton();
			if (ViewAllBottomButton.isDisplayed()) {
				ViewAllBottomButton.click();
				logs.CapturedLogs(pass, "View all bottom button was clicked");

			} else {
				logs.CapturedLogs(info, "View all bottom button not found");
			}

			Thread.sleep(2000);
			WebElement WaitForRejectHistoryTransactionBottom = elements.WaitForRejectHistoryTransaction();
			if (WaitForRejectHistoryTransactionBottom != null && WaitForRejectHistoryTransactionBottom.isEnabled()) {

				Thread.sleep(3000);
				WaitForRejectHistoryTransactionBottom.click();
				logs.CapturedLogs(pass, "Reject history Transaction from view all bottom was clicked");
				
				
				Thread.sleep(2000);
				WebElement RejectDetailsBackTwo = elements.RejectDetailsBack();
				if (RejectDetailsBackTwo.isDisplayed()) {
					RejectDetailsBackTwo.click();
					logs.CapturedLogs(pass, "Reject Details transactions from view all bottom back button was opened");

				} else {
					logs.CapturedLogs(info, "Reject Details transactions from view all bottom back button was not found");
				}
				
				
			} else {
				logs.CapturedLogs(pass, "Reject history Transaction from view all bottom was not found");
			}


			
			Thread.sleep(2000);
			WebElement RejectHistoryBackButtonViewallBottom = elements.RejectHistoryBackButtonViewallBottom();
			if (RejectHistoryBackButtonViewallBottom.isDisplayed()) {
				logs.CapturedLogs(pass, "View all bottom back button was clicked");
				RejectHistoryBackButtonViewallBottom.click();
				Thread.sleep(3000);

			} else {
				logs.CapturedLogs(info, "Reject Details Back button not found");
			}
		} else {
			logs.CapturedLogs(fail, "rejects Tab was not found");

		}

		return this;

	}
}
