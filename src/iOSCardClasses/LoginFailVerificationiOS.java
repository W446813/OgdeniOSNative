package iOSCardClasses;

import java.sql.ResultSet;
import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;

public class LoginFailVerificationiOS {
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
		

	
	public void FailExpected(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		System.out.println("I am in login fail environment is:" + environment);
		FailExpected();
	}
	

	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();


	
	
	public void FailExpected() throws Exception {
		iOSText = new AppStringsiOS(env);
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
		
		iOSLogs.setupTest("Login Fail Expected test");
		iOSLogs.CapturedLogs(info, "Login Fail Expected Testing started.");
		
		Thread.sleep(3000);

		WebElement CardNumberTextBox = xpath.CardNumberTextBox();
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(this.cardNum);

			iOSLogs.CapturedLogs(pass, "Fail Card Number was entered.");

		} else {
			iOSLogs.CapturedLogs(fail, "Fail Card Number text box is not found");
		}

		Thread.sleep(3000);

		// Find the login Password/pin text box

		WebElement PinPassTextBox = xpath.PinPassTextBox();

		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.click();
			PinPassTextBox.clear();
			PinPassTextBox.sendKeys(this.passwordOrPin);

			iOSLogs.CapturedLogs(pass, "Fail Pin entered.");

		} else {
			iOSLogs.CapturedLogs(fail, "Fail Pin text box is not found");
		}

		WebElement CardLoginButton = xpath.CardLoginButton();
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button was not found");
		}

		WebElement invalidCardText = xpath.invalidCardText();
		Thread.sleep(3000);
		if (invalidCardText != null && invalidCardText.isEnabled()) {
			iOSLogs.CapturedLogs(pass, "Unable to login model found");

		} else {
			iOSLogs.CapturedLogs(fail, "Unable to login model not found");
		}

	}

	public void LockedLoginExpected(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		System.out.println("I am in login locked environment is:" + environment);
		LockedLoginExpected();
	}
	
	public void LockedLoginExpected() throws Exception {
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
	
		iOSLogs.setupTest("Locked Login Expected test");
		iOSLogs.CapturedLogs(info, "Checking and resetting card for next test");
		dbACPTCheck.execute("mysql",
				"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id ='"+this.cardNum+"'");
		dbACPTCheck.execute("mysql",
				"update sec_user set login_attempted = NULL where user_id ='"+this.cardNum+"'");
		iOSLogs.CapturedLogs(info, "Card is ready for testing");
		
		WebElement CardNumberTextBox = xpath.CardNumberTextBox();
		Thread.sleep(3000);
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(this.cardNum);
			iOSLogs.CapturedLogs(pass, "Card Number for locked login entered");

		} else {
			iOSLogs.CapturedLogs(fail, "Card Number for locked login is not found");
		}

		
		// Find the login Password/pin text box tell if find or fail.
		Thread.sleep(3000);
		WebElement PinPassTextBox = xpath.PinPassTextBox();
		Thread.sleep(3000);
		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.click();
			PinPassTextBox.clear();
			PinPassTextBox.sendKeys(this.passwordOrPin);

			iOSLogs.CapturedLogs(pass, "Locked Pin entered.");

		} else {
			iOSLogs.CapturedLogs(fail, "Locked Pin text box not found");
		}
		scroll.ScrollDown();

		iOSLogs.CapturedLogs(info, "Checking card in database");
		ResultSet card_info_now = dbACPTCheck.query("mysql",
				String.format("select status_id from sec_user where user_id='"+this.cardNum+"'"));

			
		card_info_now.next();

		if (card_info_now.getString("status_id").equals("S")) {
			iOSLogs.CapturedLogs(info, "Card Account Was Suspended prior to testing");
		} else if (card_info_now.getString("status_id").equals("A")) {

			
			
			
			System.out.println("If you see a Null fail the carrier account doesn't have a bad logins before tem lockout max number set in eManager emanager > User administration > Manage Users > Company Name > Edit Company > Bad logins before temp lockout");
			ResultSet lockNumberDB = dbACPTCheck.query("mysql",String.format("SELECT sec_company_attribute.value FROM sec_company_attribute JOIN sec_user ON sec_user.company_id = sec_company_attribute.company_id WHERE sec_user.user_id ='"+this.cardNum+"' AND sec_company_attribute.type_id IN (24)"));
			lockNumberDB.next();
			String lockNumber = lockNumberDB.getString("value");
			System.out.println("This is the number set for Login Attempted max: "+lockNumber);
			int intLockNumber = Integer.parseInt(lockNumber);  
			System.out.println("This is the number set for Login Attempted max: "+intLockNumber);
			
			
			ResultSet currenLockCount = dbACPTCheck.query("mysql",String.format("SELECT passwd_fail_count from sec_user where user_id='"+this.cardNum+"'"));
			currenLockCount.next();
			String lockCount = currenLockCount.getString("passwd_fail_count");
			System.out.println("Current password fail amount: "+lockCount);
			int intCurrentSusCount = Integer.parseInt(lockCount);  
		
			iOSLogs.CapturedLogs(info, "Bad Logins needed to lock account: "+intLockNumber);
						
			while (intCurrentSusCount < intLockNumber) {
				
				
				dbACPTCheck.execute("mysql",
						"update sec_user set login_attempted = NULL where user_id='"+this.cardNum+"'");
				iOSLogs.CapturedLogs(info, "Login attempted field now equals Null");
				
				Thread.sleep(3000);
				WebElement CardLoginButton = xpath.CardLoginButton();
				Thread.sleep(3000);
				if (CardLoginButton != null && CardLoginButton.isDisplayed()) {
					CardLoginButton.click();
					
					
					ResultSet currenlockCountUpdate = dbACPTCheck.query("mysql",String.format("SELECT passwd_fail_count from sec_user where user_id='"+this.cardNum+"'"));
					currenlockCountUpdate.next();
					String lockCountUpdate = currenlockCountUpdate.getString("passwd_fail_count");
					int intCurrentlockCountUpdate = Integer.parseInt(lockCountUpdate);  
					
					intCurrentSusCount = intCurrentlockCountUpdate;
					
					System.out.println("Login attempt #: "+intCurrentSusCount);
					iOSLogs.CapturedLogs(info, "Login attempt #: "+intCurrentSusCount);
					
					//lockLoginAttempt++;
					iOSLogs.CapturedLogs(pass, "Login Button Pressed.");

				} else {
					iOSLogs.CapturedLogs(fail, "Login Button not found");
				}
			}
						
			Thread.sleep(3000);
			WebElement CardLoginButton2 = xpath.CardLoginButton();
			Thread.sleep(3000);
			if (CardLoginButton2 != null && CardLoginButton2.isDisplayed()) {
				CardLoginButton2.click();

			
				iOSLogs.CapturedLogs(pass, "Locked login Button 2 Pressed.");

			} else {
				iOSLogs.CapturedLogs(fail, "Locked login Button 2 not found");
				
			}

		}
		
		
		iOSLogs.CapturedLogs(info, "Checking and resetting card for next test");
		dbACPTCheck.execute("mysql",
				"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id='"+this.cardNum+"'");
		dbACPTCheck.execute("mysql",
				"update sec_user set login_attempted = NULL where user_id='"+this.cardNum+"'");
		iOSLogs.CapturedLogs(info, "Card is ready for testing");
	}
	
	public void SuspendedLoginExpected(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		System.out.println("I am in login Suspended Login environment is:" + environment);
		SuspendedLoginExpected();
	}
	
	
	public void SuspendedLoginExpected() throws Exception {
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		
		
		
		iOSLogs.setupTest("Suspended Login test");
		iOSLogs.CapturedLogs(info, "Checking and resetting card for next test");
		dbACPTCheck.execute("mysql",
				"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id ='"+this.cardNum+"'");
		dbACPTCheck.execute("mysql",
				"update sec_user set login_attempted = NULL where user_id ='"+this.cardNum+"'");
		iOSLogs.CapturedLogs(info, "Card is ready for testing");
		
		WebElement CardNumberTextBox = xpath.CardNumberTextBox();
		Thread.sleep(3000);
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(this.cardNum);
			iOSLogs.CapturedLogs(pass, "Card Number for locked login entered");

		} else {
			iOSLogs.CapturedLogs(fail, "Card Number for locked login is not found");
		}

		
		// Find the login Password/pin text box tell if find or fail.
		Thread.sleep(3000);
		WebElement PinPassTextBox = xpath.PinPassTextBox();
		Thread.sleep(3000);
		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.click();
			PinPassTextBox.clear();
			PinPassTextBox.sendKeys(this.passwordOrPin);

			iOSLogs.CapturedLogs(pass, "Locked Pin entered.");

		} else {
			iOSLogs.CapturedLogs(fail, "Locked Pin text box not found");
		}
		scroll.ScrollDown();

		iOSLogs.CapturedLogs(info, "Checking card in database");
		ResultSet card_info_now = dbACPTCheck.query("mysql",
		String.format("select status_id from sec_user where user_id='"+this.cardNum+"'"));
		card_info_now.next();

		if (card_info_now.getString("status_id").equals("S")) {
			iOSLogs.CapturedLogs(info, "Card Account Was Suspended prior to testing");
		} else if (card_info_now.getString("status_id").equals("A")) {
		
		
		
		ResultSet suspenededNumberDB = dbACPTCheck.query("mysql",String.format("SELECT sec_company_attribute.value FROM sec_company_attribute JOIN sec_user ON sec_user.company_id = sec_company_attribute.company_id WHERE sec_user.user_id ='"+this.cardNum+"' AND sec_company_attribute.type_id IN (25)"));
		suspenededNumberDB.next();
		String suspendedNumber = suspenededNumberDB.getString("value");
		System.out.println("This is the number set for Login Attempted max: "+suspendedNumber);
		int intSuspenededNumber = Integer.parseInt(suspendedNumber);  
				
		ResultSet currenSusCount = dbACPTCheck.query("mysql",String.format("SELECT passwd_fail_count from sec_user where user_id='"+this.cardNum+"'"));
		currenSusCount.next();
		String susCount = currenSusCount.getString("passwd_fail_count");
		System.out.println("Current password fail amount: "+susCount);
		int intCurrentSusCount = Integer.parseInt(susCount);  
	
		iOSLogs.CapturedLogs(info, "Bad Logins needed to suspend account: "+suspendedNumber);
	
		while (intCurrentSusCount < intSuspenededNumber) {
			
			
			dbACPTCheck.execute("mysql",
					"update sec_user set login_attempted = NULL where user_id='"+this.cardNum+"'");
			iOSLogs.CapturedLogs(info, "Login attempted field now equals Null");

			Thread.sleep(3000);

			WebElement CardLoginButton = xpath.CardLoginButton();
			Thread.sleep(3000);
			if (CardLoginButton != null && CardLoginButton.isDisplayed()) {
				CardLoginButton.click();
				iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
				
				ResultSet currenSusCountUpdate = dbACPTCheck.query("mysql",String.format("SELECT passwd_fail_count from sec_user where user_id='"+this.cardNum+"'"));
				currenSusCountUpdate.next();
				String susCountUpdate = currenSusCountUpdate.getString("passwd_fail_count");
				int intCurrentSusCountUpdate = Integer.parseInt(susCountUpdate);  
				
				intCurrentSusCount = intCurrentSusCountUpdate;
				
				System.out.println("Login attempt #: "+intCurrentSusCount);
				iOSLogs.CapturedLogs(info, "Login attempt #: "+intCurrentSusCount);
				//intCurrentSusCount++;
			} else {
				iOSLogs.CapturedLogs(fail, "Login Button not found");
			}
		}
			
			
		Thread.sleep(3000);
		WebElement suspendedOKButton = xpath.suspendedOKButton();
		Thread.sleep(3000);
		if (suspendedOKButton != null && suspendedOKButton.isEnabled()) {
			Thread.sleep(3000);
			suspendedOKButton.click();
			iOSLogs.CapturedLogs(pass, "Suspended login model ok button clicked");
			Thread.sleep(3000);
			
			
			iOSLogs.CapturedLogs(info, "Checking and resetting card for next test");
			dbACPTCheck.execute("mysql",
					"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id='"+this.cardNum+"'");
			dbACPTCheck.execute("mysql",
					"update sec_user set login_attempted = NULL where user_id='"+this.cardNum+"'");
			iOSLogs.CapturedLogs(info, "Card is ready for testing");
			

		} else {
			iOSLogs.CapturedLogs(fail, "Suspended model OK button not found");
			// CardNumberTextBox.clear();
			// PinPassTextBox.clear();
		}
	  } 	
 }
}