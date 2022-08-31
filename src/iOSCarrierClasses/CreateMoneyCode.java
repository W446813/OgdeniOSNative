package iOSCarrierClasses;


import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;


public class CreateMoneyCode {
  
	Logs logs = new Logs();
	Wait appWait = new Wait();
	ScrollOptionsiOS pull = new ScrollOptionsiOS();
	InputText appText = new InputText();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	static AppiumDriver<WebElement> driver;

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	public CreateMoneyCode createMoneyCode() throws Exception {

		Thread.sleep(5000);
		
		try {
			WebElement NewMoneyCodeButton = elements.NewMoneyCodeButton();
			Thread.sleep(3000);
			if (NewMoneyCodeButton != null && NewMoneyCodeButton.isEnabled()) {
				NewMoneyCodeButton.click();
				logs.CapturedLogs(pass, "New Moneycode Button found and clicked.");

			} else {
				logs.CapturedLogs(fail, "New Moneycode Button unable to be found");
			}
			
			Thread.sleep(3000);
			WebElement SelectContractMoneyCodes = elements.SelectContractMoneyCodes();
			Thread.sleep(3000);
			if (SelectContractMoneyCodes != null && SelectContractMoneyCodes.isEnabled()) {
				SelectContractMoneyCodes.click();
				logs.CapturedLogs(pass, "Contract Selected");
			} else {
				logs.CapturedLogs(info,"Contract not found. Or only one contract was available and was pre-selected");
			}
			
			WebElement PayeeNameTextBox = elements.PayeeNameTextBox();
			Thread.sleep(3000);
			if (PayeeNameTextBox != null && PayeeNameTextBox.isEnabled()) {
				PayeeNameTextBox.sendKeys("iOS Mobile Automation");
				logs.CapturedLogs(pass, "Payee Name textbox found and filled in");

			} else {
				logs.CapturedLogs(fail, "Payee Name textbox not found");
				
			}

			WebElement NextButtonMoneyCode = elements.NextButtonMoneyCode();
			Thread.sleep(3000);
			if (NextButtonMoneyCode!=null && NextButtonMoneyCode.isEnabled()) {
				
				NextButtonMoneyCode.click();
				logs.CapturedLogs(pass, "Next Button found and clicked");

			} else {
				logs.CapturedLogs(fail, "\"Next Button unable to be found");

			}

			WebElement AmountMoneyCodeTextBox = elements.AmountMoneyCodeTextBox();
			Thread.sleep(3000);
			if (AmountMoneyCodeTextBox!=null && AmountMoneyCodeTextBox.isEnabled()) {
				AmountMoneyCodeTextBox.sendKeys("9.99");
				logs.CapturedLogs(pass, "Amount text box found and filled in");
				

			} else {
				logs.CapturedLogs(fail, "Amount text box unable to be Selected");

			}

			WebElement AmountNextMoneyCode = elements.AmountNextMoneyCode();
			Thread.sleep(3000);
			if (AmountNextMoneyCode != null && AmountNextMoneyCode.isEnabled()) {
				AmountNextMoneyCode.click();
				logs.CapturedLogs(pass, "Next Button found and clicked");
				
			} else {
				logs.CapturedLogs(fail, "Next Button unable to be Selected");
				
			}
			//New Code
			Thread.sleep(3000);
			WebElement InfoFieldsDriverIDCheckBox = elements.InfoFieldsDriverIDCheckBox();
			Thread.sleep(3000);
			Thread.sleep(3000);
			if (InfoFieldsDriverIDCheckBox!=null && InfoFieldsDriverIDCheckBox.isEnabled()) {
				Thread.sleep(3000);
				InfoFieldsDriverIDCheckBox.click();
				logs.CapturedLogs(pass, "Driver ID check box found and clicked");
			}
			
			
			
//			WebElement SkipInfoFieldsMoneyCodes = elements.SkipInfoFieldsMoneyCodes();
//			if (SkipInfoFieldsMoneyCodes != null && SkipInfoFieldsMoneyCodes.isEnabled()) {
//				SkipInfoFieldsMoneyCodes.click();
//				logs.CapturedLogs("pass", "Skip MoneyCodesButton clicked");
//
//			} else {
//				logs.CapturedLogs("fail", "Skip MoneyCodesButton not found.");
//			}
			WebElement Add1FieldsButton = elements.Add1FieldsButton();
			Thread.sleep(3000);
			if(Add1FieldsButton!=null && Add1FieldsButton.isEnabled()) {
				Add1FieldsButton.click();
			logs.CapturedLogs(pass, "Add Fields Next Button MoneyCode found and clicked");}
			
//			Thread.sleep(3000);
//			elements.InfoFieldsDriverTextBox().sendKeys("iOS Driver ID");
//			logs.CapturedLogs("Test Pass", "DriverID TextBox found and filled in");

			// this one is weird may not work.
			Thread.sleep(2000);
			WebElement InfoDetailsNotesTextBox = elements.InfoDetailsNotesTextBox();
			Thread.sleep(3000);
			if (InfoDetailsNotesTextBox.isEnabled()) {
				Thread.sleep(2000);
				InfoDetailsNotesTextBox.sendKeys("iOS Mobile Automation");
				logs.CapturedLogs(pass, "Info Details Notes TextBox found and filled in");

			} else {
				logs.CapturedLogs(fail, "Info Details Notes TextBox unable to be Selected");
			}

			WebElement InfoNextButtonMoneyCode = elements.InfoNextButtonMoneyCode();
			Thread.sleep(3000);
			if (InfoNextButtonMoneyCode != null && InfoNextButtonMoneyCode.isEnabled()) {
				
				InfoNextButtonMoneyCode.click();
				logs.CapturedLogs(pass, "Info Next Button MoneyCode found and clicked.");

			} else {
				logs.CapturedLogs(fail, "Info Next Button MoneyCode unable to be Selected");

			}
			Thread.sleep(3000);
			elements.EditFeeIcon().click();
			
			WebElement DeductFeeNowRadioButton = elements.DeductFeeNowRadioButton();
			Thread.sleep(3000);
			if(DeductFeeNowRadioButton!=null && DeductFeeNowRadioButton.isEnabled()) {
				DeductFeeNowRadioButton.click();
				logs.CapturedLogs(pass, "Deduct fee now radio button found and clicked.");}
			Thread.sleep(3000);
			elements.BackButtonEditFee().click();
			
			Thread.sleep(3000);
			WebElement IssueMoneyCodeButton = elements.IssueMoneyCodeButton();
			Thread.sleep(3000);
			if (IssueMoneyCodeButton!= null && IssueMoneyCodeButton.isEnabled()) {
				IssueMoneyCodeButton.click();

				logs.CapturedLogs(pass, "Issue MoneyCode Button found and clicked");

			} else {
				logs.CapturedLogs(pass, "Issue MoneyCode Button was not found");
			}

			Thread.sleep(5000);
			WebElement DismissMoneyCodeButton = elements.DismissMoneyCodeButton();
			Thread.sleep(3000);
			if (DismissMoneyCodeButton!= null && DismissMoneyCodeButton.isDisplayed()) {
				Thread.sleep(2000);
				DismissMoneyCodeButton.click();
				logs.CapturedLogs(pass, "Dismiss MoneyCode Button found and clicked");
				
			} else {
				logs.CapturedLogs(fail, "Dismiss MoneyCode Button unable to be Selected");

			}

			Thread.sleep(3000);
			WebElement DismissMoneyCodeModalButton = elements.DismissMoneyCodeModalButton();
			Thread.sleep(3000);
			if (DismissMoneyCodeModalButton!=null && DismissMoneyCodeModalButton.isEnabled()) {

				DismissMoneyCodeModalButton.click();
				logs.CapturedLogs(pass, "Dismiss MoneyCode Modal Button found and clicked");
				logs.CapturedLogs(pass, "A new moneycode was created.");

			} else {
				logs.CapturedLogs(fail, "Dismiss MoneyCode Modal Button unable to be found");
			}

			// void the moneycode
			WebElement SelectCreatedMoneyCode = elements.SelectCreatedMoneyCode();
			Thread.sleep(3000);
			if (SelectCreatedMoneyCode!=null && SelectCreatedMoneyCode.isEnabled()) {
			SelectCreatedMoneyCode.click();
			logs.CapturedLogs(pass, "Created MoneyCode Selected.");
			} else {
				logs.CapturedLogs(fail, "Couldnt find Created MoneyCode.");
			}

			WebElement VoidMoneyCodeButton = elements.VoidMoneyCodeButton();
			Thread.sleep(3000);
			if (VoidMoneyCodeButton.isEnabled()) {
				VoidMoneyCodeButton.click();
				logs.CapturedLogs(pass, "Voided last created money code using void button");
			} else {
				logs.CapturedLogs(fail, "Couldnt Void last created money code no button found");
			}

			WebElement VoidMoneyCodeModal = elements.VoidMoneyCodeModal();
			Thread.sleep(3000);
			if (VoidMoneyCodeModal != null && VoidMoneyCodeModal.isEnabled()) {
				VoidMoneyCodeModal.click();
				logs.CapturedLogs(pass, "closed Voided money code modal");
			} else {
				logs.CapturedLogs(fail, "Couldnt close voided moneycode modal");
			}

			WebElement MoneyCodeBackButton = elements.MoneyCodeBackButton();
			Thread.sleep(3000);
			if (MoneyCodeBackButton != null && MoneyCodeBackButton.isEnabled()) {
				MoneyCodeBackButton.click();

				logs.CapturedLogs(pass, "moneyCodeBackButton found and clicked");

			} else {
				logs.CapturedLogs(fail, "moneyCodeBackButton not found and unable to be clicked");
			}

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println(e.getMessage());
		}

		return this;
	}
}
