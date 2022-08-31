package iOSCarrierClasses;



import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AccountTransferToYourBankAddAccountiOS {
	
	//TODO Add to all 		
		private String env;
		//TODO Add to all 		
			public void AccountTransferToYourBankAddAccountiOS(String environment) throws Exception {
				this.env = environment;
				accountTransferToYourBankAddAccount();
			}
			
	Logs logs = new Logs();
	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;
	Wait appWait = new Wait();
	Sleep appSleep = new Sleep();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	
	public AccountTransferToYourBankAddAccountiOS accountTransferToYourBankAddAccount() throws Exception {
		logs.setupTest("Testing ACH transfer");
		ConnectionHandler dbACPT = new ConnectionHandler(env);
		
		WebElement accountsTab = elements.accountsTab();
		if (accountsTab.isEnabled()) {
			accountsTab.click();
			logs.CapturedLogs(iOSText.PASS, "Account tab opened");
			
			logs.CapturedLogs("Test Info", "Expiring any Automation bank accounts numbered: 1234569854 prior to testing manually.");
			dbACPT.execute("infx", "update ach_ppd_header set expire_date = '2021-01-28 13:38' where dfi_account_number = '1234569854' and expire_date is NULL;");
			logs.CapturedLogs("Test Info", "Bank account 1234569854 manually expired in database");
			
			WebElement TransferToYourBank = elements.TransferToYourBank();
			if (TransferToYourBank != null &&  TransferToYourBank.isEnabled()) {
				//open Transfer to your bank
				TransferToYourBank.click();
				logs.CapturedLogs(iOSText.PASS, "Transfer to your bank opened");
				WebElement TransferFromSelectContract = elements.TransferFromSelectContract();
				if(TransferFromSelectContract.isEnabled()) {
					TransferFromSelectContract.click();
					logs.CapturedLogs(iOSText.PASS, "Select contract clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Select contract not found");

				}
				
				WebElement TransferNextButton = elements.TransferNextButton();
				if(TransferNextButton!=null && TransferNextButton.isEnabled()) {
					TransferNextButton.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");

				}
				
				
				WebElement transferSelectBankAccount = elements.TransferSelectBankAccount();
				WebElement bankAccountFour = elements.BankAccountFour();
				new TouchAction<>(Capabilities.driver).longPress(PointOption.point(bankAccountFour.getLocation())).moveTo(PointOption.point(transferSelectBankAccount.getLocation())).release().perform();
				logs.CapturedLogs(iOSText.INFO, "Scroll down to find add new bank account");

				//add new bank account
				Thread.sleep(3000);

				WebElement AddNewBankAccountButton = elements.AddNewBankAccountButton();
				if(AddNewBankAccountButton != null && AddNewBankAccountButton.isEnabled()) {
					AddNewBankAccountButton.click();
					logs.CapturedLogs(iOSText.PASS, "Add New Bank Account button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Add new bank button not found");

				}
				
				//enter routing number
				Thread.sleep(3000);
				WebElement RoutingNumberTextBox = elements.RoutingNumberTextBox();
				if(RoutingNumberTextBox!=null && RoutingNumberTextBox.isEnabled()) {
					RoutingNumberTextBox.sendKeys("324377516");
					logs.CapturedLogs(iOSText.PASS, "Routing number clicked and entered.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Routing number text box not found");

				}
				
				//enter account number
				WebElement AccountNumberTextBox = elements.AccountNumberTextBox();
				if(AccountNumberTextBox!=null && AccountNumberTextBox.isEnabled()) {
					AccountNumberTextBox.sendKeys("1234569854");
					//need to edit so account numbers can be different
					logs.CapturedLogs(iOSText.PASS, "Account number clicked and entered.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Account number text box not found");

				}
				
				//click on where do i find these and click X
				WebElement WhereDoIFindTheseButton = elements.WhereDoIFindTheseButton();
				if(WhereDoIFindTheseButton!=null && WhereDoIFindTheseButton.isEnabled()) {
					WhereDoIFindTheseButton.click();
					logs.CapturedLogs(iOSText.PASS, "Where Do I Find These Button clciked.");
					Thread.sleep(3000);
					elements.WhereDoIFindTheseDoneButton().click();
					logs.CapturedLogs(iOSText.PASS, "Where do I find these Done button clicked");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Where do I find these button not found");

				}
				
				//click Next
				WebElement AddBankAccountNextButton = elements.AddBankAccountNextButton();
				if(AddBankAccountNextButton!=null && AddBankAccountNextButton.isEnabled()) {
					AddBankAccountNextButton.click();
					logs.CapturedLogs(iOSText.PASS, "Next Button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");

				}
				Thread.sleep(3000);
				//Add bank name
				WebElement BankNameTextBox = elements.BankNameTextBox();
				if(BankNameTextBox!=null && BankNameTextBox.isEnabled()) {
					BankNameTextBox.sendKeys("iOS Automation bank");
					logs.CapturedLogs(iOSText.PASS, "Bank Name TextBox clicked and entered.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Bank name text box not found");

				}
				
				//add account owner
				WebElement AccountOwnerTextBox = elements.AccountOwnerTextBox();
				if(AccountOwnerTextBox!=null && AccountOwnerTextBox.isEnabled()) {
					AccountOwnerTextBox.sendKeys("iOS Automater");
					logs.CapturedLogs(iOSText.PASS, "Account Owner Text Box clicked and entered.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Account owner text box not found");

				}
				
				// select savings then checking
				WebElement SavingsButton = elements.SavingsButton();
				if(SavingsButton!=null && SavingsButton.isEnabled()) {
					SavingsButton.click();
					logs.CapturedLogs(iOSText.PASS, "Savings Button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Savings button not found");

				}
				
				Thread.sleep(3000);
				WebElement CheckingButton = elements.CheckingButton();
				if(CheckingButton!=null && CheckingButton.isEnabled()) {
					CheckingButton.click();
					logs.CapturedLogs(iOSText.PASS, "Checking Button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Checking button not found");

				}
				Thread.sleep(3000);
				//click next
				WebElement AddBankDetailsNextButton = elements.AddBankDetailsNextButton();
				if(AddBankDetailsNextButton!=null && AddBankDetailsNextButton.isEnabled()) {
					AddBankDetailsNextButton.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT Button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");

				}
				Thread.sleep(3000);
				//click ok
				WebElement NewBankAccountOKButton = elements.NewBankAccountOKButton();
				if(NewBankAccountOKButton!=null && NewBankAccountOKButton.isEnabled()) {
					NewBankAccountOKButton.click();
					logs.CapturedLogs(iOSText.PASS, "OK Button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Ok button not found");

				}
				
				
				
				dbACPT.execute("infx", "update ach_ppd_header set expire_date = '2021-01-28 13:38' where dfi_account_number = '1234569854'");
				logs.CapturedLogs(iOSText.INFO, "Bank account 1234569854 manually expired in database");
				
				//leaving transfer to bank section after deleting created bank account
				elements.TransferToYourBankCloseButton().click();
				logs.CapturedLogs(iOSText.PASS, "Transfer to your bank close button clicked");
				Thread.sleep(3000);
				elements.TransferToYourYesDiscardModalButton().click();
				logs.CapturedLogs(iOSText.PASS, "Transfer to your bank Discard modal button clicked");
				
			
				
			}
			else {
				logs.CapturedLogs(iOSText.FAIL, "Transfer to your bank not found.");
			}
			
			//Ach transfer and deleting pending transfer starts here ********************
			Thread.sleep(3000);
			WebElement TransferToYourBank2 = elements.TransferToYourBank();
			if (TransferToYourBank2!= null && TransferToYourBank2.isEnabled()) {
				TransferToYourBank2.click();
				logs.CapturedLogs(iOSText.PASS, "Transfer to your bank opened");
				
				Thread.sleep(2000);
				
//				elements.TransferToYourBankCancelButton().click();
//				logs.CapturedLogs("pass", "Transfer to your bank back button clicked.");
//				Thread.sleep(2000);	
				
				WebElement TransferFromSelectContract = elements.TransferFromSelectContract();
				if(TransferFromSelectContract.isEnabled()) {
					TransferFromSelectContract.click();
					logs.CapturedLogs(iOSText.PASS, "Select contract clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Select contract not found");

				}
				
				WebElement TransferNextButton = elements.TransferNextButton();
				if(TransferNextButton!=null && TransferNextButton.isEnabled()) {
					TransferNextButton.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");

				}
				
				WebElement TransferSelectBankAccount = elements.TransferSelectBankAccount();
				if(TransferSelectBankAccount!=null && TransferSelectBankAccount.isEnabled()) {
					TransferSelectBankAccount.click();
					logs.CapturedLogs(iOSText.PASS, "Bank account clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, " Bank account not found");

				}
				
				WebElement TransferNextButton2 = elements.TransferNextButton();
				if(TransferNextButton2!=null && TransferNextButton2.isEnabled()) {
					TransferNextButton2.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");

				}
				
				WebElement TransferNextButton3 = elements.TransferNextButton();
				if(TransferNextButton3!=null && TransferNextButton3.isEnabled()) {
					TransferNextButton3.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button button not found");

				}
				
				WebElement TransferEnterAmountTextBox = elements.TransferEnterAmountTextBox();
				if(TransferEnterAmountTextBox!=null && TransferEnterAmountTextBox.isEnabled()) {
					TransferEnterAmountTextBox.sendKeys("1.00");
					logs.CapturedLogs(iOSText.PASS, "Amount enteredin text box");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Amount text box not found");

				}
				
				WebElement EnterAmountNextButton = elements.EnterAmountNextButton();
				if(EnterAmountNextButton!=null && EnterAmountNextButton.isEnabled()) {
					EnterAmountNextButton.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");

				}
				
				WebElement TransferSubmitButton = elements.TransferSubmitButton();
				if(TransferSubmitButton!=null && TransferSubmitButton.isEnabled()) {
					TransferSubmitButton.click();
					logs.CapturedLogs(iOSText.PASS, "Submit button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Submit button not found");

				}
				
				WebElement TransferDoneButton = elements.TransferDoneButton();
				if(TransferDoneButton.isEnabled()) {
					TransferDoneButton.click();
					logs.CapturedLogs(iOSText.PASS, "Done button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Done button not found");
				}
				
				
				
				
				//to delete a pending payment
				elements.TransferToYourBank().click();
				logs.CapturedLogs(iOSText.PASS, "Transfer to your bank clicked.");
				
				WebElement TransferFromSelectContract2 = elements.TransferFromSelectContract();
				if(TransferFromSelectContract2.isEnabled()) {
					TransferFromSelectContract2.click();
					logs.CapturedLogs(iOSText.PASS, "Select contract clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Select contract not found");
				}
				
				WebElement TransferNextButton4 = elements.TransferNextButton();
				if(TransferNextButton4!=null && TransferNextButton4.isEnabled()) {
					Thread.sleep(3000);
					TransferNextButton4.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");
				}
				
				WebElement TransferSelectBankAccount2 = elements.TransferSelectBankAccount();
				if(TransferSelectBankAccount2!=null && TransferSelectBankAccount2.isEnabled()) {
					TransferSelectBankAccount2.click();
					logs.CapturedLogs(iOSText.PASS, "Bank account clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Bank account not found");
				}
				
				WebElement TransferNextButton5 = elements.TransferNextButton();
				if(TransferNextButton5!=null && elements.TransferNextButton().isEnabled()) {
					TransferNextButton5.click();
					logs.CapturedLogs(iOSText.PASS, "NEXT button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Next button not found");
				}
				
				WebElement PendingTransfer = elements.PendingTransfer();
				if(PendingTransfer.isEnabled()) {
					PendingTransfer.click();
					logs.CapturedLogs(iOSText.PASS, "Pending Transfer opened");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Pending transfer not found");
				}
				
				WebElement CancelTransferButton = elements.CancelTransferButton();
				if(CancelTransferButton!=null && CancelTransferButton.isEnabled()) {
					CancelTransferButton.click();
					logs.CapturedLogs(iOSText.PASS, "Cancel transfer button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Cancel transfer button not found");
				}
				
				WebElement BackModalButton = elements.BackModalButton();
				if(BackModalButton!=null && BackModalButton.isEnabled()) {
					BackModalButton.click();
					logs.CapturedLogs(iOSText.PASS, "Back modal button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Back modal button not found");
				}
				
				WebElement CancelTransferButton2 = elements.CancelTransferButton();
				if(CancelTransferButton2!=null && CancelTransferButton2.isEnabled()) {
					CancelTransferButton2.click();
					logs.CapturedLogs(iOSText.PASS, "Cancel transfer button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Cancel transfer button not found");
				}
				
				WebElement CancelModalButton = elements.CancelModalButton();
				if(CancelModalButton!=null && CancelModalButton.isEnabled()) {
					CancelModalButton.click();
					logs.CapturedLogs(iOSText.PASS, "Cancel modal button clicked.");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Cancel modal button not found");
				}
				
				Thread.sleep(2000);
				WebElement CancelPendingPaymentXButton = elements.CancelPendingPaymentXButton();
				if(CancelPendingPaymentXButton.isEnabled()) {
					CancelPendingPaymentXButton.click();
					logs.CapturedLogs(iOSText.PASS, "Pending Transfer X button clicked");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Pending transfer X button not found");
				}
				
				
				
				
//TODO this is the final sometimes failing Xpath in automation for this side
				
				Thread.sleep(2000);
				WebElement CancelModalButton2 = elements.CancelModalButton2();
				if(CancelModalButton2!=null && CancelModalButton2.isEnabled()) {
					CancelModalButton2.click();
					logs.CapturedLogs(iOSText.PASS, "Discard modal button clicked");
				}else {
					logs.CapturedLogs(iOSText.FAIL, "Discard modal button not found");
				}
				
//				Thread.sleep(2000);
//				WebElement DiscardChangesModal = elements.DiscardChangesModal();
//				if(DiscardChangesModal!=null && DiscardChangesModal.isEnabled()) {
//					DiscardChangesModal.click();
//					logs.CapturedLogs(iOSText.PASS, "Discard modal button clicked");
//				}else {
//					logs.CapturedLogs(iOSText.FAIL, "Discard modal button not found");
//				}
				
				
				
			}
			else {
				logs.CapturedLogs(iOSText.FAIL, "Transfer to your bank not found.");
			}	
			
		}
		else {
			logs.CapturedLogs(iOSText.FAIL, "Accounts tab not found");
		}
		return this;
	}

}
