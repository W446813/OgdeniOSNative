package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class DynamicPIN {
//	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements=new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText=new AppStringsiOS();
	private String env;
	private String cardNum;
	private String passwordOrPin;
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	
	public DynamicPIN dynamicPIN(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		
		iOSLogs.setupTest("Dynamic PIN Test");
		Thread.sleep(3000);
	
		
		Thread.sleep(3000);
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
		} else {
			iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
		}
		
		
		//WebElement DynamicPINButtonOld = elements.DynamicPINButtonOld();
		//Thread.sleep(3000);
		//WebElement DynamicPINButton = elements.DynamicPINButton();
		
		Thread.sleep(3000);
		WebElement DynamicPINButton = elements.DynamicPINButtonName();
		Thread.sleep(3000);
		if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
			DynamicPINButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Dynamic PIN button clicked");	
		
		
		
		
		
//		if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
//			DynamicPINButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "Dynamic PIN button clicked");	
//		
//		
//		}
//		else if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
//			DynamicPINButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "Dynamic PIN button clicked");
		
			
			
		
		
//		Thread.sleep(4000);
//		WebElement DynamicPINNumber = elements.DynamicPINNumber();
//		if (DynamicPINNumber != null && DynamicPINNumber.isEnabled()) {
//			iOSLogs.CapturedLogs(iOSText.PASS, "Dynamic PIN number displayed as: "+ DynamicPINNumber.getText());
//		} else {
//			iOSLogs.CapturedLogs(iOSText.INFO, "Dynamic PIN number not found or unavailable in this card type");
//		}
		
		Thread.sleep(3000);
		WebElement DismissDynamicPINbutton = elements.DismissDynamicPINbutton();
		Thread.sleep(3000);
		if (DismissDynamicPINbutton != null && DismissDynamicPINbutton.isDisplayed()) {
			DismissDynamicPINbutton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Dismiss Dynamic PIN button clicked");
		} else {
			iOSLogs.CapturedLogs(iOSText.FAIL, "Dismiss Dynamic PIN button not found");
		}
		return this;
		
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Dynamic PIN button not found or unavailable in this card type");
		}
		return this;
	}
}
