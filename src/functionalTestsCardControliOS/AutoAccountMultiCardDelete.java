package functionalTestsCardControliOS;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.RepoCardiOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;


public class AutoAccountMultiCardDelete {
	
	
	@Test
	public void cardControlTestAndroid() throws Exception {
		//private String testType = "System Test";
		//String testType = "QuickLoginLogoutRun";
		//String buildNum = "5.0.0";
		//TestSetup testSetup = new TestSetup(testType, buildNum);

		Logs iOSLogs = new Logs();
	
		AppStringsiOS iOSText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		RepoCardiOS elements = new RepoCardiOS();
		//Boolean cardsStillExist;
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		String appName = "Card Control";
		
		
		try {
								
			
		
			iOSLogs.setupTest("REMOVE CARDS FROM MULTI CARD LOGIN PAGE");
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.environmentPickerButton();
					
			iOSLogs.setupTest("Check for Multi card login page");
			iOSLogs.CapturedLogs(info, "Multi card Login page check Testing started.");
		
			Thread.sleep(3000);
			WebElement CardEditButton = elements.CardEditButton();
			Thread.sleep(3000);
			
				if (CardEditButton != null && CardEditButton.isEnabled()) {
				CardEditButton.click();
				
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
						iOSLogs.CapturedLogs(info, "Checking for other cards");
						
						Thread.sleep(3000);
						WebElement CardEditButton1 = elements.CardEditButton();
						Thread.sleep(3000);
						if (CardEditButton1 != null && CardEditButton1.isDisplayed()) {
							iOSLogs.CapturedLogs(info, "More cards seen to remove");
							this.cardControlTestAndroid();							
							//cardsStillExist = true;
						} else {
							iOSLogs.CapturedLogs(info, "No cards left to remove");
							//cardsStillExist = false;
						}
						
						
												
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
			//}

		///	}while (cardsStillExist.equals(true));
			
			//Capabilities.driver.closeApp();
			Capabilities.driver.quit();
				
		
			iOSLogs.CapturedLogs(info, "MultiCard Login Logout functional test completed");
		
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