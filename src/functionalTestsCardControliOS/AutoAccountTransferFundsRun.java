package functionalTestsCardControliOS;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.CardDirectLoginPass;
import iOSCardClasses.CreatePasscode;
import iOSCardClasses.LogoutCardControl;
import iOSCardClasses.MultiCardLoginCheck;
import iOSCardClasses.CreateProfile;
import iOSCardClasses.TransferFunds;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class AutoAccountTransferFundsRun {	
static AppiumDriver<WebElement> driver;
private String cardNum;	
private String cardType;
String appName = "Card Control";

@Test
public void cardControlTestiOS() {
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	PhonePicker phone = new PhonePicker();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	TransferFunds transferFunds = new TransferFunds();
//LogoutCardControl Logout = new LogoutCardControl();
	BiometricsiOS Biometric = new BiometricsiOS();
//CardDirectLoginPass CardLogin6344 = new CardDirectLoginPass();
//CardLoginLogoutTestingLoginPass CardLogin5542 = new CardLoginLogoutTestingLoginPass();
	MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
	CardDirectLoginPass Login = new CardDirectLoginPass();
	//GetACard getACard = new GetACard();
	AutoAccountSelector getAccount = new AutoAccountSelector();
	CreatePasscode createPasscode = new CreatePasscode();
	LogoutCardControl Logout = new LogoutCardControl();

	
	try {
		
		System.out.println(phone.autoPhonePickerCard(appName));
		iOSLogs.setupTest("Transfer funds functional test");
		//PASSCODE Card (this comes from turning on dynamic pin)
		Thread.sleep(3000);
		iOSLogs.setupTest("TRANSFER_FUNDS_MANUAL");
		cardType = "TRANSFER FUNDS MANUAL";
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.setEnv(environmentPicker.getEnviroment());
		getAccount.CardPassExpected("TRANSFER_FUNDS_MANUAL_5542");
		CreateProfile profileSetup = new CreateProfile();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	

		iOSLogs.CapturedLogs(info, "ASK DEVS WHY FIRST LOGIN DOES NOT WORK CHECK NEWEST BUILD");
//		ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());

//		//Delete passcode in database 
//		System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
//		dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getCardNum()+"'");
//		//login with temp passcode 
//		System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
//		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getCardNum(), getAccount.getPasswordOrPin());
//		createPasscode.NewPasscode(environmentPicker.getEnviroment());
		
		//Login with newly set card passcode
		Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), iOSText.MANUAL_PASSCODE, this.cardType);
		Biometric.BiometricsiOS(); 
		profileSetup.ProfileSetup(environmentPicker.getEnviroment());
		transferFunds.TransferFunds(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin());
		Logout.LogoutCardControl();
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
		iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
		
		
		
		iOSLogs.CapturedLogs(iOSText.INFO, "Transfer funds functional test completed");
		
		
		
	} catch (Exception exp) {
		String errorMessage = exp.getMessage();
		
		
		if (errorMessage == null) {
			errorMessage = exp.toString();
			System.out.println("Error is: " + errorMessage);
			
		}else {
			System.out.println("Error is: " + errorMessage);
		}
		
		System.out.println(exp.getCause());
		System.out.println(exp.getMessage());
		exp.printStackTrace();
		
		try {
			iOSLogs.CapturedLogs(iOSText.FAIL, errorMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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