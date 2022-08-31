package iOSCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;

//import io.appium.java_client.AppiumDriver;

public class MultiCardsRemoveCard {
	public MultiCardsRemoveCard() {
	}

private String env;
private String cardNum;
private String passwordOrPin;
private String nameOnAccount;
private String carrierID;
private String cardNumAndCarrierID;

	public void multiCardPassExpected(String environment, String cardNumber, String passwordOrPin) throws Exception {
		
		this.env = environment;
		//this.cardNum = cardNumber;
		System.out.println("The card number before trim is " +cardNumber);
		this.cardNum = cardNumber.substring(cardNumber.length()-4);
	
	
		System.out.println("The card number after trim is " +cardNum);
		this.passwordOrPin = passwordOrPin;
		System.out.println("I am in login Pass invoirment is:" + environment);
		
			
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		ResultSet carrierId = dbACPTCheck.query("infx",String.format("select * from cards where card_Num ='" +cardNumber+"'"));
		carrierId.next();
		String carrierID = carrierId.getString("carrier_id");
		this.carrierID = carrierID;
		
		
		ResultSet nameFound = dbACPTCheck.query("infx",String.format("select name, * from member where member_id ='" +carrierID+"'"));
		nameFound.next();
		String nameOneAccount = nameFound.getString("name");
		this.nameOnAccount = nameOneAccount;
				
		
	
		this.cardNumAndCarrierID = this.cardNum+ ", "+this.nameOnAccount;
		System.out.println(cardNumAndCarrierID);
		
		multiCardPassExpected();
	}
	
	
		
	public void multiCardPassExpected() throws Exception {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		ScrollOptionsiOS scroll = new ScrollOptionsiOS();
		RepoCardiOS elements=new RepoCardiOS();

		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
	
		
		iOSLogs.setupTest("REMOVE A CARD");
		iOSLogs.CapturedLogs(info, "Login Pass Expected Testing started.");
		
		Thread.sleep(3000);
		WebElement CheckForMuliCardLogin = elements.CheckForMuliCardLogin();
		Thread.sleep(3000);
		if (CheckForMuliCardLogin != null && CheckForMuliCardLogin.isDisplayed()) {
			iOSLogs.CapturedLogs(pass, "Multi Card Login page found.");
			
			Thread.sleep(3000);
			WebElement MultiCardSelector = elements.MultiCardSelector(cardNumAndCarrierID);
			Thread.sleep(3000);
			if (MultiCardSelector != null && MultiCardSelector.isEnabled()) {
				MultiCardSelector.click();
				iOSLogs.CapturedLogs(pass, "MultiCard Login for: "+ cardNumAndCarrierID+ " Selected");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "MultiCard Login for: "+ cardNumAndCarrierID+ " not found");
			}
			
			Thread.sleep(3000);
			WebElement EditPencilButton = elements.EditPencilButton();
			Thread.sleep(3000);
			
			if(EditPencilButton != null && EditPencilButton.isEnabled()) {
				Thread.sleep(3000);
				EditPencilButton.click();
				iOSLogs.CapturedLogs(pass, "Edit Pencil Press once");
				iOSLogs.CapturedLogs(info, "Edit Pencil seems to be broken and takes many clicks needs to speak with devs");
						
				
			WebElement XCloseButton = elements.XCloseButton();
			Thread.sleep(3000);
			if (XCloseButton != null && XCloseButton.isEnabled()) {
				XCloseButton.click();
				iOSLogs.CapturedLogs(pass, "X close Button Pressed");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "X close Button not found");
			}
			
		
//			WebElement MultiCardSelectorOne = elements.MultiCardSelector(cardNumAndCarrierID);
//			Thread.sleep(3000);
//			if (MultiCardSelectorOne != null && MultiCardSelectorOne.isEnabled()) {
//				MultiCardSelectorOne.click();
//				iOSLogs.CapturedLogs(pass, "MultiCard Login for: "+ cardNumAndCarrierID+ " Selected");
//				Thread.sleep(3000);
//			} else {
//				iOSLogs.CapturedLogs(fail, "MultiCard Login for: "+ cardNumAndCarrierID+ " not found");
//			}
			
			
			
			WebElement EditPencilButtonOne = elements.EditPencilButton();
			Thread.sleep(3000);
			if (EditPencilButtonOne != null && EditPencilButtonOne.isEnabled()) {
				EditPencilButtonOne.click();
				iOSLogs.CapturedLogs(pass, "Edit Pencil Pressed");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Edit Pencil not found");
			}
		

			WebElement MultiCardSelectorThree = elements.MultiCardSelector(cardNumAndCarrierID);
			Thread.sleep(3000);
			if (MultiCardSelectorThree != null && MultiCardSelectorThree.isEnabled()) {
				MultiCardSelectorThree.click();
				iOSLogs.CapturedLogs(pass, "MultiCard Login for: "+ cardNumAndCarrierID+ " Selected");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "MultiCard Login for: "+ cardNumAndCarrierID+ " not found");
			}
						
		
			WebElement RemoveCardButton = elements.RemoveCardButton();
			Thread.sleep(3000);
			if (RemoveCardButton != null && RemoveCardButton.isEnabled()) {
				RemoveCardButton.click();
				iOSLogs.CapturedLogs(pass, "Remove card button Pressed");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Remove card button not found");
			}
			
			
			} else {
				iOSLogs.CapturedLogs(info, "Edit Pencil not found");
			}
		
		
	} else {
		iOSLogs.CapturedLogs(info, "Multi Card Login page not found.");
		}
	}
}
