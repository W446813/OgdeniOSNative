package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;

public class GetACardLogin {
	public GetACardLogin() {
	}
	
	
private String env;
private String cardNum;

	
	public void CardPassExpected(String environment, String cardNumber) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		System.out.println("I am in login fail environment is:" + environment);
		CardPassExpected();
	}
	
	
	
	

	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	

	public void CardPassExpected() throws Exception {
		iOSText = new AppStringsiOS(env);
		Sleep appSleep = new Sleep();
		Logs iOSLogs = new Logs();
		RepoCardiOS xpath = new RepoCardiOS();
		int lastFour;
		String passwordOrPin;
		String cardNumber;
		
		
		switch (cardNum) {
		case "6344":  lastFour = 1;
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 6344 found");
		cardNumber = "CARDPIN_LOGIN_NUMBER_6344";
		passwordOrPin = "CARDPIN_LOGIN_PIN_6344";
		break;
		
		case "0561": lastFour = 2;
		//TODO Add database login
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 0561 found");
		cardNumber = "CARD_LOGIN_LOCK_EXPECTED";
		passwordOrPin = "SECURE_FUEL_0561_PIN";
		break;
		
		case "5542": lastFour = 3;
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 5542 found");
		cardNumber = "FORGOT_PIN_PASSCODE_5542";
		passwordOrPin = "FORGOT_PIN_PASSCODE_5542_PASSCODE";
		break;
		
		case "2800": lastFour = 4;
		//TODO Add database login
		iOSLogs.CapturedLogs(iOSText.INFO, "Card 2800 found");
		cardNumber = "ACH_PIN_LOGIN_2800";
		passwordOrPin = "ACH_2800_PIN";
		break;
					
		default:
		iOSLogs.CapturedLogs(iOSText.INFO, "No Card number found");
	
	}
		
	}
	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: "+ cardNum);
	}


	public String getCardNum() {
		System.out.println("GET Card number: "+ cardNum);
		return cardNum;
	}

}
