package iOSCardClasses;
import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.RepoCardiOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;


public class UnitTestMultiCardDelete {
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
		
		public void AutoAccountMultiCardDelete(String environment) throws Exception {
			this.env = environment;
			UnitTestMultiCardDelete();
		}
	
	@Test
	public void UnitTestMultiCardDelete() throws Exception {
		//private String testType = "System Test";
		//String testType = "QuickLoginLogoutRun";
		//String buildNum = "5.0.0";
		//TestSetup testSetup = new TestSetup(testType, buildNum);

		Logs iOSLogs = new Logs();
	
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCardiOS elements = new RepoCardiOS();
		//Boolean cardsStillExist;
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
		
		try {
			Thread.sleep(3000);
			iOSLogs.setupTestYellow("Multi Card Checker");
			iOSLogs.CapturedLogs(info, "Checking for Multi card login page");
					
			Thread.sleep(3000);
			WebElement CardEditButton = elements.CardEditButton();
			Thread.sleep(3000);
		try {
			while (CardEditButton != null && CardEditButton.isEnabled()) {
			
				if (CardEditButton != null && CardEditButton.isEnabled()) {
				CardEditButton.click();
				iOSLogs.CapturedLogs(info, "Multi Card Edit button located and selected");
				
				Thread.sleep(3000);
				WebElement SelectCardFromEdit = elements.SelectCardFromEdit();
				Thread.sleep(3000);
				if (SelectCardFromEdit != null && SelectCardFromEdit.isEnabled()) {
					SelectCardFromEdit.click();
					iOSLogs.CapturedLogs(info, "Card found and selected on edit page");	
				
					Thread.sleep(3000);
					WebElement RemoveSelectedCardFromEdit = elements.RemoveSelectedCardFromEdit();
					Thread.sleep(3000);
					
					if (RemoveSelectedCardFromEdit != null && RemoveSelectedCardFromEdit.isEnabled()) {
						RemoveSelectedCardFromEdit.click();
						iOSLogs.CapturedLogs(info, "Remove Card Button selected");
												
				}else {
						iOSLogs.CapturedLogs(info, "Remove Card Button not found in edit page");	
					}
				}else {
					iOSLogs.CapturedLogs(info, "Cards not found in edit page");	
				}
							iOSLogs.CapturedLogs(pass, "Card edit button clicked");
				} else {
					iOSLogs.CapturedLogs(info, "Card edit button is not found Multiple cards not seen");
				}
				iOSLogs.CapturedLogs(info, "Checking for other cards");
			}
		}catch(StaleElementReferenceException e) {
			
		}


			iOSLogs.CapturedLogs(info, "MultiCard delete a card completed");
		
		} catch (Exception exp) {String errorMessage = exp.getMessage();
			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);
			} else {
				System.out.println("Error is: " + errorMessage);
			}
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				iOSLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}