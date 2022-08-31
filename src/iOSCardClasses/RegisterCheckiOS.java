package iOSCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class RegisterCheckiOS {
private String env;
private String cardNum;
private String passwordOrPin;
private String cardType;

	
	public void registerCheckiOS(String environment, String cardNum, String PasswordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNum;
		this.passwordOrPin = PasswordOrPin;
		this.cardType = cardType;
		
		System.out.println("I am in login fail environment is:" + environment);
		registerCheckiOS();
	}

	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	RepoCardiOS elements=new RepoCardiOS();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	
	public RegisterCheckiOS registerCheckiOS() throws Exception {
		iOSText = new AppStringsiOS(env);
		iOSLogs.setupTest("Testing register check on " + cardType);
	
		System.out.println("Card num for query:" + this.cardNum);
		//Database interaction 	
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		ResultSet balanceDBBefore = dbACPTCheck.query("infx",String.format("SELECT * FROM payr_cash_adv WHERE card_num ='"+cardNum+"'ORDER BY trans_id DESC limit 1"));	
				
		
		balanceDBBefore.next();
		String cashAdvID = balanceDBBefore.getString("cash_adv_id");
		String balanceBefore = balanceDBBefore.getString("balance");
		System.out.println(balanceBefore);
		int balanceBeforeInt;
		
		try {
		balanceBeforeInt = Integer.parseInt(balanceBefore);
		}
		catch (NumberFormatException e) {
			balanceBeforeInt = 0;
		}

		
if (balanceBeforeInt < 200.00) {
	iOSLogs.CapturedLogs(info, "Not enough balance to use register check");
	dbACPTCheck.execute("infx", "UPDATE payr_cash_adv SET balance = '200.00' WHERE cash_adv_id ="+cashAdvID);
	iOSLogs.CapturedLogs(info, "Added $200.00 to account");
	} else {
		iOSLogs.CapturedLogs(info, "More than $200.00 found to use register check");
	}
		
		//SQL query to delete used check number
		ConnectionHandler dbACPT = new ConnectionHandler(env);
		dbACPT.execute("infx", "delete from checks where check_num ='1248174135'");
		iOSLogs.CapturedLogs(info, "Used check number deleted");
		
		Thread.sleep(3000);
		WebElement RegisterCheckIconButton = elements.RegisterCheckIconButton();
		Thread.sleep(3000);
		if (RegisterCheckIconButton != null && RegisterCheckIconButton.isEnabled()) {
			RegisterCheckIconButton.click();
			iOSLogs.CapturedLogs(pass, "Register check icon button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Register check icon button not found");
		}
		
	
		WebElement AmountTextBoxRegisterCheck = elements.AmountTextBoxRegisterCheck();
		Thread.sleep(3000);
		if (AmountTextBoxRegisterCheck != null && AmountTextBoxRegisterCheck.isEnabled()) {
			AmountTextBoxRegisterCheck.sendKeys(iOSText.REGISTER_CHECK_AMOUNT);
			iOSLogs.CapturedLogs(pass, "Register check amount entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Register check amount textbox not found");
		}
		
		
		WebElement NextButtonRegisterCheck = elements.NextButtonRegisterCheck();
		Thread.sleep(3000);
		if (NextButtonRegisterCheck != null && NextButtonRegisterCheck.isEnabled()) {
			NextButtonRegisterCheck.click();
			iOSLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button amount screen not found");
		}

//TODO INFO DONE BUTTON WONT WORK		
//		Thread.sleep(3000);
//		WebElement WhatIsRegisterCheckButton = elements.WhatIsRegisterCheckButton();
//		Thread.sleep(3000);
//		if (WhatIsRegisterCheckButton != null && WhatIsRegisterCheckButton.isEnabled()) {
//			WhatIsRegisterCheckButton.click();
//			iOSLogs.CapturedLogs(pass, "What is Register Check button selected");
//			
//			
//			WebElement WhatIsRegisterCheckDoneButton = elements.WhatIsRegisterCheckDoneButton();
//			Thread.sleep(3000);
//			if (WhatIsRegisterCheckDoneButton != null && WhatIsRegisterCheckDoneButton.isEnabled()) {
//				WhatIsRegisterCheckDoneButton.click();
//				iOSLogs.CapturedLogs(pass, "What is Register Check close button selected");
//			} else {
//				iOSLogs.CapturedLogs(fail, "What is Register Check close button not found");
//			}	
//					
//		} else {
//			iOSLogs.CapturedLogs(fail, "What is Register Check button not found");
//		}
		
		
//TODO INFO DONE BUTTON WONT WORK
//		Thread.sleep(3000);
//		WebElement CheckNumberInfoFromTextBox = elements.CheckNumberInfoFromTextBox();
//		Thread.sleep(3000);
//		if (CheckNumberInfoFromTextBox != null && CheckNumberInfoFromTextBox.isEnabled()) {
//			CheckNumberInfoFromTextBox.click();
//			iOSLogs.CapturedLogs(pass, "Check number info button selected");
//			
//			Thread.sleep(3000);
//			WebElement CheckNumberInfoFromTextBoxDoneButton = elements.CheckNumberInfoFromTextBoxDoneButton();
//			Thread.sleep(3000);
//			if (CheckNumberInfoFromTextBoxDoneButton != null && CheckNumberInfoFromTextBoxDoneButton.isEnabled()) {
//				CheckNumberInfoFromTextBoxDoneButton.click();
//				iOSLogs.CapturedLogs(pass, "Check number info close button selected");
//			} else {
//				iOSLogs.CapturedLogs(fail, "Check number info close button not found");
//			}
//			
//		} else {
//			iOSLogs.CapturedLogs(fail, "Check number info button not found");
//		}
		
		
		
		
		
		
		WebElement CheckNumberTextBox = elements.CheckNumberTextBox();
		Thread.sleep(4000);
		if (CheckNumberTextBox != null && CheckNumberTextBox.isEnabled()) {
			CheckNumberTextBox.click();
			CheckNumberTextBox.sendKeys(iOSText.REGISTER_CHECK_NUMBER);
			iOSLogs.CapturedLogs(pass, "Check number entered");
		} else {
			iOSLogs.CapturedLogs(fail, "Check number textbox not found");
		}
		
		
		WebElement NextButtonRegisterCheck2 = elements.NextButtonRegisterCheck();
		Thread.sleep(4000);
		if (NextButtonRegisterCheck2 != null && NextButtonRegisterCheck2.isEnabled()) {
			NextButtonRegisterCheck2.click();
			iOSLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Next button check number screen not found");
		}
		
		
		WebElement SubmitButtonRegisterCheck = elements.SubmitButtonRegisterCheck();
		Thread.sleep(5000);
		if (SubmitButtonRegisterCheck != null && SubmitButtonRegisterCheck.isEnabled()) {
			SubmitButtonRegisterCheck.click();
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Submit button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Submit button not found");
		}
		
		
		WebElement DismissAuthButtonRegisterCheck = elements.DismissAuthButtonRegisterCheck();
		Thread.sleep(3000);
		if (DismissAuthButtonRegisterCheck != null && DismissAuthButtonRegisterCheck.isEnabled()) {
			DismissAuthButtonRegisterCheck.click();
			iOSLogs.CapturedLogs(pass, "Dismiss auth button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Dismiss auth button not found");
		}
		
		
		WebElement CancelButtonRegisterCheck = elements.CancelButtonRegisterCheck();
		Thread.sleep(3000);
		if (CancelButtonRegisterCheck != null && CancelButtonRegisterCheck.isEnabled()) {
			CancelButtonRegisterCheck.click();
			iOSLogs.CapturedLogs(pass, "Cancel button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Cancel button not found");
		}
		
	
		WebElement DismissAuthButtonTwoRegisterCheck = elements.DismissAuthButtonTwoRegisterCheck();
		Thread.sleep(3000);
		if (DismissAuthButtonTwoRegisterCheck != null && DismissAuthButtonTwoRegisterCheck.isEnabled()) {
			DismissAuthButtonTwoRegisterCheck.click();
			iOSLogs.CapturedLogs(pass, "Dismiss button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Dismiss button not found");
		}
		
		
		WebElement DismissCodeModalButtonRegisterCheck = elements.DismissCodeModalButtonRegisterCheck();
		Thread.sleep(3000);
		if (DismissCodeModalButtonRegisterCheck != null && DismissCodeModalButtonRegisterCheck.isEnabled()) {
			DismissCodeModalButtonRegisterCheck.click();
			iOSLogs.CapturedLogs(pass, "Dismiss code modal button clicked");
		} else {
			iOSLogs.CapturedLogs(fail, "Dismiss code modal button not found");
		}
		ConnectionHandler dbACPTs = new ConnectionHandler(env);
		dbACPTs.execute("infx", "delete from checks where check_num ='1248174135'");
		iOSLogs.CapturedLogs(info, "Used check number deleted");
		return this;
	}
}
