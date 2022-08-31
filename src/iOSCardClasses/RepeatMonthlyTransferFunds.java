package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class RepeatMonthlyTransferFunds {
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements=new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText=new AppStringsiOS();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	public RepeatMonthlyTransferFunds RepeatMonthlyTransferFunds() throws Exception {
		iOSLogs.setupTest("Repeat monthly Transfer Funds Test");
		
		iOSLogs.CapturedLogs(info, "Repeat monthly transfer flow test");
		
		Thread.sleep(3000);
		WebElement TransferFundsButton = elements.TransferFundsButton();
		if (TransferFundsButton != null && TransferFundsButton.isEnabled()) {
			TransferFundsButton.click();
			iOSLogs.CapturedLogs(pass, "Transfer funds button clicked");
		} else {
			iOSLogs.CapturedLogs(info, "Transfer funds button not found or unavailable in this card type");
		}
	
		Thread.sleep(2000);
		WebElement RepeatTransferRadioButton = elements.RepeatTransferRadioButton();
		if (RepeatTransferRadioButton != null && RepeatTransferRadioButton.isEnabled()) {
			RepeatTransferRadioButton.click();
			iOSLogs.CapturedLogs(pass, "Repeat transfer radio button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Repeat transfer radio button not found");
		}
		
		Thread.sleep(2000);
		WebElement NextTransferFundsButton = elements.NextTransferFundsButton();
		if (NextTransferFundsButton != null && NextTransferFundsButton.isEnabled()) {
			NextTransferFundsButton.click();
			iOSLogs.CapturedLogs(pass, "Next button Transfer type screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button Transfer type screen not found");
		}
		
		Thread.sleep(3000);
		WebElement SelectBankAccount = elements.SelectBankAccount();
		if (SelectBankAccount != null && SelectBankAccount.isEnabled()) {
			SelectBankAccount.click();
			iOSLogs.CapturedLogs(pass, "Bank account selected");
		} else {
			iOSLogs.CapturedLogs(fail, "Bank account not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonTransferTo = elements.NextTransferFundsButtonTransferTo();
		if (NextTransferFundsButtonTransferTo != null && NextTransferFundsButtonTransferTo.isEnabled()) {
			NextTransferFundsButtonTransferTo.click();
			iOSLogs.CapturedLogs(pass, "Next button transfer to screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button transfer to screen not found");
		}
		
		Thread.sleep(3000);
		WebElement EnterAmountTextBox = elements.EnterAmountTextBox();
		if (EnterAmountTextBox != null && EnterAmountTextBox.isEnabled()) {
			EnterAmountTextBox.sendKeys(iOSText.REGISTER_CHECK_AMOUNT);
			iOSLogs.CapturedLogs(pass, "Amount entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Amount textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement NextTransferFundsButtonEnterAmount = elements.NextTransferFundsButtonTransferTo();
		if (NextTransferFundsButtonEnterAmount != null && NextTransferFundsButtonEnterAmount.isEnabled()) {
			NextTransferFundsButtonEnterAmount.click();
			iOSLogs.CapturedLogs(pass, "Next button enter amount screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button enter amount screen not found");
		}
		
		Thread.sleep(3000);
		WebElement DoneDatePickerButton = elements.DoneDatePickerButton();
		if (DoneDatePickerButton != null && DoneDatePickerButton.isEnabled()) {
			DoneDatePickerButton.click();
			iOSLogs.CapturedLogs(pass, "Date Picker Done button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Date Picker Done button not found");
		}
		
//		Thread.sleep(3000);
//		WebElement NextButtonSetStartDate = elements.NextTransferFundsButtonTransferTo();
//		if (NextButtonSetStartDate != null && NextButtonSetStartDate.isEnabled()) {
//			NextButtonSetStartDate.click();
//			iOSLogs.CapturedLogs(pass, "Next button set start date screen clicked");
//		} else {
//			iOSLogs.CapturedLogs(fail, "Next button set start date screen not found");
//		}
		
		Thread.sleep(3000);
		WebElement MonthlyRepeatSchedule = elements.MonthlyRepeatSchedule();
		if (MonthlyRepeatSchedule != null && MonthlyRepeatSchedule.isEnabled()) {
			MonthlyRepeatSchedule.click();
			iOSLogs.CapturedLogs(pass, "Monthly Repeat schedule clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Monthly Repeat schedule not found");
		}
		
		Thread.sleep(3000);
		WebElement NextButtonRepeatScheduleScreen = elements.NextTransferFundsButtonTransferTo();
		if (NextButtonRepeatScheduleScreen != null && NextButtonRepeatScheduleScreen.isEnabled()) {
			NextButtonRepeatScheduleScreen.click();
			iOSLogs.CapturedLogs(pass, "Next button repeat schedule screen clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button repeat schedule screen not found");
		}
		
		Thread.sleep(3000);
		WebElement MonthlyDate1RepeatSchedule = elements.MonthlyDate1RepeatSchedule();
		if (MonthlyDate1RepeatSchedule != null && MonthlyDate1RepeatSchedule.isEnabled()) {
			MonthlyDate1RepeatSchedule.click();
			iOSLogs.CapturedLogs(pass, "Day 1 clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Day 1 not found");
		}
		
		Thread.sleep(3000);
		WebElement MonthlyDate2RepeatSchedule = elements.MonthlyDate2RepeatSchedule();
		if (MonthlyDate2RepeatSchedule != null && MonthlyDate2RepeatSchedule.isEnabled()) {
			MonthlyDate2RepeatSchedule.click();
			iOSLogs.CapturedLogs(pass, "Day 2 clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Day 2 not found");
		}
		
		Thread.sleep(3000);
		WebElement SelectDaysOfTheMonthNextButton = elements.SelectDaysOfTheMonthNextButton();
		if (SelectDaysOfTheMonthNextButton != null && SelectDaysOfTheMonthNextButton.isEnabled()) {
			SelectDaysOfTheMonthNextButton.click();
			iOSLogs.CapturedLogs(pass, "Select days of the mont next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Select days of the mont next button found");
		}
		
		Thread.sleep(3000);
		WebElement SetEndDateSwitch = elements.SetEndDateSwitch();
		if (SetEndDateSwitch != null && SetEndDateSwitch.isEnabled()) {
			SetEndDateSwitch.click();
			iOSLogs.CapturedLogs(pass, "Set End date turned on");
		} else {
			iOSLogs.CapturedLogs(fail, "Set End date switch not found");
		}
		
		Thread.sleep(3000);
		WebElement DoneDatePickerButtonEndDate = elements.DoneDatePickerButton();
		if (DoneDatePickerButtonEndDate != null && DoneDatePickerButtonEndDate.isEnabled()) {
			DoneDatePickerButtonEndDate.click();
			iOSLogs.CapturedLogs(pass, "Set end Date Picker next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Set end Date Picker next button not found");
		}
		
//		Thread.sleep(3000);
//		WebElement NextButtonEndDateScreen = elements.NextTransferFundsButtonTransferTo();
//		if (NextButtonEndDateScreen != null && NextButtonEndDateScreen.isEnabled()) {
//			NextButtonEndDateScreen.click();
//			iOSLogs.CapturedLogs(pass, "Next button end date screen clicked");
//		} else {
//			iOSLogs.CapturedLogs(fail, "Next button end date screen not found");
//		}
		
		Thread.sleep(3000);
		WebElement SubmitButton = elements.SubmitButton();
		if (SubmitButton != null && SubmitButton.isEnabled()) {
			SubmitButton.click();
			iOSLogs.CapturedLogs(pass, "Submit button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Submit button not found");
		}
		
		Thread.sleep(6000);
		WebElement DismissButtonTransferFunds = elements.DismissButtonTransferFunds();
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
