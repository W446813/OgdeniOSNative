package iOSCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;

//import io.appium.java_client.AppiumDriver;

public class MultiCardsLogin {
	public MultiCardsLogin() {
	}

private String env;
private String cardNum;
private String passwordOrPin;
private String nameOnAccount;
private String carrierID;
private String cardNumAndCarrierID;
private String cardType;

	public void multiCardPassExpected(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardType = cardType;
		//this.cardNum = cardNumber;
		System.out.println("The card number before trim is " +cardNumber);
		this.cardNum = cardNumber.substring(cardNumber.length()-4);
		
		

		
		System.out.println("The card number after trim is " +cardNum);
		this.passwordOrPin = passwordOrPin;
		System.out.println("I am in login Pass invoirment is:" + environment);
		
		
		
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		System.out.println("Card num looking for: " +cardNumber);
		ResultSet carrierId = dbACPTCheck.query("infx",String.format("select * from cards where card_Num ='" +cardNumber+"'"));
		carrierId.next();
		String carrierID = carrierId.getString("carrier_id");
		this.carrierID = carrierID;
		System.out.println("Carrier ID looking for: " +carrierID);
		
	
		System.out.println("Finding company Name");
		//Select sec_company.* from sec_company join sec_user on sec_company.company_id=sec_user.company_id where sec_user.user_id = '100644';
		ResultSet nameFound = dbACPTCheck.query("mysql",String.format("Select sec_company.* from sec_company join sec_user on sec_company.company_id=sec_user.company_id where sec_user.user_id ='" +carrierID+"'"));
		nameFound.next();
		String nameOneAccount = nameFound.getString("name");
		this.nameOnAccount = nameOneAccount;
		System.out.println("Carrier Name looking for: " +nameOneAccount);
			
		this.cardNumAndCarrierID = this.cardNum+ ", "+this.nameOnAccount;
		System.out.println("This is the details we are looking to click: " +cardNumAndCarrierID);
		
		
				
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
	
		
		iOSLogs.setupTest(cardType+" testeding started");
		iOSLogs.CapturedLogs(info, "Login Pass Expected Testing started.");
		
		Thread.sleep(3000);
		WebElement CheckForMuliCardLogin = elements.CheckForMuliCardLogin();
		Thread.sleep(3000);
		if (CheckForMuliCardLogin != null && CheckForMuliCardLogin.isDisplayed()) {
			iOSLogs.CapturedLogs(pass, "Multi Card Login page found.");
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			WebElement MultiCardSelector = elements.MultiCardSelector(cardNumAndCarrierID);
			Thread.sleep(3000);
			if (MultiCardSelector != null && MultiCardSelector.isEnabled()) {
				Thread.sleep(3000);
				MultiCardSelector.click();
				iOSLogs.CapturedLogs(pass, "MultiCard Login for: "+ cardNumAndCarrierID+ " Pressed");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "MultiCard Login for: "+ cardNumAndCarrierID+ " not found");
			}
			
			
			Thread.sleep(3000);
//used if you need to close the keyboard
		iOSsharedClasses.Capabilities.driver.hideKeyboard();
		Thread.sleep(3000);
		WebElement CardLoginButton = elements.CardLoginButton();
		Thread.sleep(3000);
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button was not found");
		}
		
		Thread.sleep(3000);
		
		// Find the login Password text box tell if find or Test Fail.
		Thread.sleep(3000);
		WebElement MultiCardPinPassTextBox = elements.MultiCardPinPassTextBox();
		Thread.sleep(3000);
		if (MultiCardPinPassTextBox != null && MultiCardPinPassTextBox.isDisplayed()) {
			MultiCardPinPassTextBox.sendKeys(passwordOrPin);
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "MultiCard Pin/passcode entered");
// TODO				add	select hide show password button

		} else {
			iOSLogs.CapturedLogs(fail, "MultiCard Pin/passcode was not found");
		}

// TODO				add	some options for Forgot Pin or passcode maybe go into and close. 

//used if you need to close the keyboard
	
		Thread.sleep(3000);
		WebElement MultiCardLoginButton = elements.MultiCardLoginButton();
		Thread.sleep(3000);
		if (MultiCardLoginButton != null && MultiCardLoginButton.isEnabled()) {
			MultiCardLoginButton.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button was not found");
		}

	} else {
		iOSLogs.CapturedLogs(info, "Multi Card Login page not found.");
		}
	}
}
