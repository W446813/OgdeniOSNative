package iOSsharedClasses;

import org.openqa.selenium.WebElement;
import iOSCardClasses.RepoCardiOS;

public class HelpScreen {

	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
	
	public HelpScreen HelpScreenContinue(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCardiOS elements = new RepoCardiOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
			try {
			
		
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	public HelpScreen HelpScreenContinueRequired(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCardiOS elements = new RepoCardiOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
			try {
			
		
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				iOSLogs.CapturedLogs(fail, "Help Screen continue Button is not found");
			}

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	public HelpScreen HelpScreenContinueOld() throws Exception {
				
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCardiOS elements = new RepoCardiOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
			try {
			
		
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	
}
