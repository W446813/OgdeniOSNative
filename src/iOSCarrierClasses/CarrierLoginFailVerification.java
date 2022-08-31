package iOSCarrierClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;


public class CarrierLoginFailVerification {
	AppStringsiOS carrierText = new AppStringsiOS();
	RepoCarrieriOS xpath = new RepoCarrieriOS();
	
	
	public CarrierLoginFailVerification() {
	}

	//TODO Add to all 		
			private String env;
			//TODO Add to all 		
				public void CarrierLoginFailVerification(String environment) throws Exception {
					this.env = environment;
					CarrierFailExpected();
				}
	
	public void CarrierFailExpected() throws Exception {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		iOSLogs.setupTest("Login Fail Verification Started");
		Thread.sleep(3000);
		
		WebElement CarrierNumFailTextField = xpath.CarrierNumberTextbox();
		Thread.sleep(3000);
		if (CarrierNumFailTextField != null && CarrierNumFailTextField.isDisplayed()) {
			CarrierNumFailTextField.sendKeys(carrierText.CARRIER_LOGIN_ID_FAIL_EXPECTED);
			iOSLogs.CapturedLogs(pass, "Carrier Number Fail Expected entered");

		} else {
			iOSLogs.CapturedLogs(fail, "Carrier Number Fail Expected text box not found");
		}

		Thread.sleep(3000);

		WebElement PasswordFailExpected = xpath.PasswordTextbox();
		Thread.sleep(3000);
		if (PasswordFailExpected.isDisplayed()) {
			PasswordFailExpected.sendKeys(carrierText.CARRIER_LOGIN_PASSWORD_FAIL_EXPECTED);
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Password Fail Expected text entered.");

		} else {
			iOSLogs.CapturedLogs(fail, "Pin Password Fail Expected text box is not found");
		}

		Thread.sleep(3000);
		WebElement loginKey = xpath.LoginButtonCarrier();
		Thread.sleep(3000);
		if (loginKey.isEnabled()) {
			loginKey.click();
			iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button was not found");
		}

		
		Thread.sleep(3000);
		WebElement invalidModalOKButton = xpath.InvalidModalOkButton();
		Thread.sleep(3000);
		invalidModalOKButton.click();
		iOSLogs.CapturedLogs(pass, "Login details are incorrect app shouldn't let you login");

	}

	public void CarrierLockedLoginExpected(String environment) throws Exception {
		this.env = environment;
		//System.out.println("I am in login locked environment is:" + env);

		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCarrieriOS xpath = new RepoCarrieriOS();
		ResetTestAccounts ResetTestAccounts = new ResetTestAccounts();
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		iOSLogs.setupTest("Locked Login Verification Started");
		Thread.sleep(3000);
		// Check all accounts are still ready for testing.
		//ResetTestAccounts.ResetAllAccounts();

		// phones logs in as expected.

		WebElement LockedCarrierNumber = xpath.CarrierNumberTextbox();
		Thread.sleep(3000);
		if (LockedCarrierNumber != null && LockedCarrierNumber.isDisplayed()) {
			LockedCarrierNumber.click();
			LockedCarrierNumber.clear();
			LockedCarrierNumber.click();
			
			Thread.sleep(3000);
			WebElement selectAllText = xpath.SelectAllText();
			selectAllText.click();
			Thread.sleep(3000);
			WebElement cutText = xpath.CutAllText();
			cutText.click();
			Thread.sleep(3000);
			LockedCarrierNumber.sendKeys(iOSText.CARRIER_LOGIN_ID_UNIVERSAL);
			iOSLogs.CapturedLogs(pass, "Locked Card Number text box was found. Invalid card number entered");
			Thread.sleep(3000);
		} else {
			iOSLogs.CapturedLogs(fail, "Locked CardNumber text box is not found");
		}

		Thread.sleep(3000);

		WebElement passwordLockedTextBox = xpath.PasswordTextbox();
		Thread.sleep(3000);
		if (passwordLockedTextBox != null && passwordLockedTextBox.isDisplayed()) {
			passwordLockedTextBox.click();
			passwordLockedTextBox.clear();
			passwordLockedTextBox.click();
			
			Thread.sleep(3000);
			WebElement selectAllText = xpath.SelectAllText();
			Thread.sleep(3000);
			selectAllText.click();
			Thread.sleep(3000);
			
			passwordLockedTextBox.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_LOCKED);
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Password entered.");

		} else {
			iOSLogs.CapturedLogs(fail, "invalid password Text box is not found");
		}

//TODO if you want ACPT TEST as your login server use this	
//SIT
//		
		ConnectionHandler dbCheck = new ConnectionHandler(env);

		ResultSet card_info_now = dbCheck.query("mysql",
				String.format("select status_id from sec_user where user_id = %s", "129698"));

		card_info_now.next();

		if (card_info_now.getString("status_id").equals("S")) {
			iOSLogs.CapturedLogs(info, "Card Account Was Suspended prior to testing");

			dbCheck.execute("mysql",
					"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '129698'");
			iOSLogs.CapturedLogs(info, "Card Account is no longer suspended ready for next run.");
			dbCheck.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '129698'");
			iOSLogs.CapturedLogs(info, "Login attempted field equals Null");
			iOSLogs.CapturedLogs(info, "Restarting Locked Login Expected test.");
			CarrierLockedLoginExpected(env);

//TODO if you want DIT as your login server use this 
////DIT						
//								ConnectionHandler dbCheck = new ConnectionHandler();
//								
//								ResultSet card_info_now = dbCheck.query("mysql", String.format("select status_id from sec_user where user_id = %s","129698"));
//								
//								card_info_now.next();
//								
//								if (card_info_now.getString("status_id").equals("S")){
//									keepThisLog.CapturedLogs("Test Pass", "Card Account Was Suspended prior to testing");
//									
//															
//										dbCheck.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '129698'");
//										keepThisLog.CapturedLogs("Test Pass", "Card Account is no longer suspended ready for next run.");
//										dbCheck.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '129698'");
//										keepThisLog.CapturedLogs("Test Pass", "Login attempted field equals Null");
//										keepThisLog.CapturedLogs("Test Pass", "Restarting Locked Login Expected test.");
//										CarrierLockedLoginExpected();
//							

		} else if (card_info_now.getString("status_id").equals("A")) {

			// First false login done for real carrier
			WebElement loginKey = xpath.LoginButtonCarrier();
			Thread.sleep(3000);
			if (loginKey.isEnabled()) {
				loginKey.click();
				iOSLogs.CapturedLogs(pass, "Login button clicked");
			}

			int loginAttempt = 0;

			while (loginAttempt < 8) {

				loginAttempt++;
				System.out.println("Locked Login attempts count: " + String.valueOf(loginAttempt));

				ConnectionHandler dbACPT1 = new ConnectionHandler(env);
				dbACPT1.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '129698'");
				iOSLogs.CapturedLogs(info, "Databse checked and login attempted field is equals to Null");

				WebElement invalidCarrierUserPassOkModal = xpath.InvalidModalOkButton();
				Thread.sleep(3000);
				if (invalidCarrierUserPassOkModal.isDisplayed()) {
					
					iOSLogs.CapturedLogs(info, "Login details are incorrect app shouldn't let you login");

					WebElement invalidModalUserPassOKButton = xpath.InvalidModalOkButton();

					invalidModalUserPassOKButton.click();
					iOSLogs.CapturedLogs(pass, "Ok Button to close modal was pressed and modal closed");
					Thread.sleep(3000);

				} else {
					iOSLogs.CapturedLogs(fail, "Login is being allowed with bad login credentials");
				}

				

				if (loginKey.isEnabled()) {
					loginKey.click();
					iOSLogs.CapturedLogs(pass, "Login Button Pressed.");
				

				} else {
					WebElement invalidModalOKButton = xpath.InvalidModalOkButton();
					Thread.sleep(3000);
					if (invalidModalOKButton.isDisplayed()) {
						invalidModalOKButton.click();
						iOSLogs.CapturedLogs(pass, "Ok Button to close modal was pressed and modal closed");
						Thread.sleep(3000);
					}



					if (passwordLockedTextBox.isDisplayed()) {
						passwordLockedTextBox.click();
						// passwordLockedTextBox.clear();
						// pinSuspended.click();

						Actions actionpasswordLockedTextBox = new Actions(Capabilities.driver);
						actionpasswordLockedTextBox.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_FAIL_EXPECTED);

//						more.click();

						WebElement cardNumbers1 = Capabilities.driver
								.findElementByAccessibilityId(iOSText.CARRIER_PASSWORD_FAIL_EXPECTED);
						Thread.sleep(3000);
						cardNumbers1.click();

						Thread.sleep(3000);
						iOSLogs.CapturedLogs(pass, "Password entered.");
			

					} else {
						iOSLogs.CapturedLogs(info, "No modal is seen to close");
					}

					// Find the login Password/pin textbox tell if find or fail.

					WebElement pinSuspended = xpath.PasswordTextbox();
					Thread.sleep(3000);
					if (pinSuspended.isDisplayed()) {
						pinSuspended.click();
						Actions actionUserpinSuspended = new Actions(Capabilities.driver);
						actionUserpinSuspended.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_SUSPENDED);
						Thread.sleep(3000);
						iOSLogs.CapturedLogs(pass, "Password entered.");
					} else {
						iOSLogs.CapturedLogs(fail, "Password text box is not found");
					}
					iOSLogs.CapturedLogs(fail, "Login Button not found");
				}

			}
//			WebElement invalidModalOKButton = xpath.InvalidModalOkButton();
//			Thread.sleep(3000);
//			if (invalidModalOKButton != null && invalidModalOKButton.isDisplayed()) {
//				invalidModalOKButton.click();
//				keepThisLog.CapturedLogs("Test Pass", "Ok Button to close modal was pressed and modal closed");
//			Thread.sleep(3000);
//			}
//			
//			}
		}
//
//		WebElement invalidModalOKButtonTwo = xpath.InvalidModalOkButton();
//		Thread.sleep(3000);
//		if (invalidModalOKButtonTwo != null && invalidModalOKButtonTwo.isDisplayed()) {
//			invalidModalOKButtonTwo.click();
//			keepThisLog.CapturedLogs("Test Pass", "Ok Button to close modal was pressed and modal closed");
//		Thread.sleep(3000);
//		} else {
//			keepThisLog.CapturedLogs("Test Pass", "Ok Button to close modal was not found");
//		}

	}

	public void CarrierSuspendedLoginExpected() throws Exception {
		//this.env = environment;
		//System.out.println("I am in login locked environment is:" + env);
		
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
	
		iOSLogs.setupTest("Suspended login testing Started");
		Thread.sleep(3000);
		
		ConnectionHandler dbACPT2 = new ConnectionHandler(env);

		ResultSet carrier_info_now = dbACPT2.query("mysql",
				String.format("select status_id from sec_user where user_id = %s", "129698"));

		carrier_info_now.next();

		if (carrier_info_now.getString("status_id").equals("S")) {
			iOSLogs.CapturedLogs(info, "Carrier Account Was Suspended prior to testing");

		} else if (carrier_info_now.getString("status_id").equals("A")) {

			iOSLogs.CapturedLogs(info, "Carrier not already suspended. Suspended Login testing started");

			ConnectionHandler db = new ConnectionHandler(env);

			db.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '129698'");
			iOSLogs.CapturedLogs(info, "Login attempted field equals Null");

			// Find the login Password/pin textbox tell if find or fail.

			WebElement passwordSuspended = xpath.PasswordTextbox();
			Thread.sleep(3000);
			if (passwordSuspended.isDisplayed()) {
				passwordSuspended.click();
				passwordSuspended.clear();
				passwordSuspended.click();

				WebElement selectAllText = xpath.SelectAllText();
				Thread.sleep(3000);
				selectAllText.click();

				passwordSuspended.sendKeys(carrierText.CARRIER_LOGIN_PASSWORD_SUSPENDED);
				Thread.sleep(3000);

				WebElement loginKey = xpath.LoginButtonCarrier();
				Thread.sleep(3000);
				if (loginKey.isEnabled()) {
					loginKey.click();

					WebElement invalidModalOKButton = xpath.InvalidModalOkButton();
					if (invalidModalOKButton.isDisplayed()) {
						invalidModalOKButton.click();
						iOSLogs.CapturedLogs(pass, "Ok Button to close modal was pressed and modal closed");
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					iOSLogs.CapturedLogs(pass, "Login Button Pressed.");		
				}
				iOSLogs.CapturedLogs(pass, "Password entered.");
	

			} else {
				iOSLogs.CapturedLogs(fail, "Password text box is not found");
			}
		}

		ConnectionHandler dbACPT3 = new ConnectionHandler(env);

		ResultSet card_info = dbACPT3.query("mysql",
				String.format("select status_id from sec_user where user_id = %s", "129698"));

		card_info.next();

		if (card_info.getString("status_id").equals("S")) {
			iOSLogs.CapturedLogs(info, "Carrier Account Was Suspended successfully");
			dbACPT3.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '129698'");
			iOSLogs.CapturedLogs(info, "Carrier Account is no longer suspended ready for next run.");
			dbACPT3.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '129698'");
			iOSLogs.CapturedLogs(info, "Login attempted field equals Null");
			iOSLogs.CapturedLogs(info, "Now moving to Login Pass Verification test");
		} else {
			iOSLogs.CapturedLogs(info,String.format("Carrier Account status is: %s", card_info.getString("status_id")));

		}

	}

}
