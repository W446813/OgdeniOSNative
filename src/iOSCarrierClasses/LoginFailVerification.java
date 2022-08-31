package iOSCarrierClasses;

import java.sql.ResultSet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;

public class LoginFailVerification {
	public LoginFailVerification()throws Exception {
		
	}
	
	private String env;
	
	public void LoginFailVerification(String environment) throws Exception {
			this.env = environment;
			System.out.println("I am in login fail environment is:" + environment);
			FailExpected();
		}
	
	Sleep appSleep = new Sleep();
	Logs iOSLogs = new Logs();
	Wait appWait = new Wait();
	InputText appText = new InputText();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCarrieriOS xpath = new RepoCarrieriOS();

	
	public  void FailExpected() throws Exception {
		iOSText = new AppStringsiOS(env);

			appWait.WaitForCardNumOrSleep3000();
			// Appium 1.15.1 
			WebElement cardNumber = Capabilities.driver.findElementByXPath(appText.CardNumTextField());
			
			// Appium 1.14.0
			//WebElement cardNumber = Capabilities.driver.findElementById(id.LoginCardNumElement());
			
			if (cardNumber.isDisplayed()) {
				
				cardNumber.click();
				
				
				
//				cardNumber.clear();
//				cardNumber.click();
//				appSleep.ThreadSleep1();
//				WebElement selectAllText = Capabilities.driver.findElementByXPath(appText.SelectAllText());
//				selectAllText.click();
//				WebElement cutText = Capabilities.driver.findElementByXPath(appText.CutAllText());
//				cutText.click();
//				
				
				Actions actionUserCard = new Actions(Capabilities.driver);
				actionUserCard.sendKeys(iOSText.CardControlNumberFail());
				//7083051010269845547
			iOSLogs.CapturedLogs(iOSText.PASS, "Card Number entered.");
			
			//actionReturn.sendKeys(Keys.RETURN).build().perform();

			appSleep.ThreadSleep1();
			} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "CardNumber text box is not found");
			}
		
		
			appSleep.ThreadSleep1();	
			
			
			
			
			// Find the login Password/pin textbox tell if find or fail.
			appWait.WaitForCardPinOrSleep3000();
			// Appium 1.15.1 
			WebElement pin = Capabilities.driver.findElementByXPath(appText.PinTextField());
			
			//Appium 1.14.0
			//WebElement pin = Capabilities.driver.findElementById(id.LoginPinElement());
			
			
				
				
				if (pin.isDisplayed()) {
				
				pin.click();
//				appSleep.ThreadSleep3000();
//				pin.clear();
//				pin.click();
				Actions actionUserPin = new Actions(Capabilities.driver);
				actionUserPin.sendKeys(iOSText.cardControlPinFail()); // send Pin to card control app
				//1111
				appSleep.ThreadSleep3000();
				iOSLogs.CapturedLogs(iOSText.PASS, "Pin entered.");
				//appWait.WaitForHomeOrSleep3000();
				
				
				} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Pin text box is not found");
			}
				
				
						//appWait.WaitForLogoOrSleep3000();
//				WebElement BackgroundClick = Capabilities.driver.findElementByXPath(appText.BackgroundClick());
//
//				if (BackgroundClick.isEnabled()) {
//					BackgroundClick.click();
//				
//				keepThisLog.CapturedLogs("Test Pass", "Background is found. ");
//				keepThisLog.CapturedLogs("Test Pass", "Keyboard is closed.");
//				//appWait.WaitForHomeOrSleep3000();
//				
//				} else {
//				keepThisLog.CapturedLogs("Test Fail", "Background is not found");
//				keepThisLog.CapturedLogs("Test Fail", "Background was not found");
//			}

				appWait.WaitForLoginButtonOrSleep3000();
				WebElement loginKey = Capabilities.driver.findElementByXPath(appText.LoginButton());
				
				if (loginKey.isEnabled()) {
				loginKey.click();
				iOSLogs.CapturedLogs(iOSText.PASS, "Login Button Pressed.");
				//appWait.WaitForHomeOrSleep3000();
				
				} else {
				iOSLogs.CapturedLogs(iOSText.FAIL, "Login Button is not found");
			}
				
				appWait.WaitForinvalidCardTextOrSleep3000();
				WebElement invalidCardText = Capabilities.driver.findElementByXPath(appText.invalidCardText());
				System.out.println("This is bad login text: " + invalidCardText.getText());	
				
				if (invalidCardText.getText().contains("Invalid Card Number or PIN/Passcode.")) {
					
					iOSLogs.CapturedLogs(iOSText.PASS, "Login details are incorrect shouldn't let you in");
					
									
				}else {
					iOSLogs.CapturedLogs(iOSText.FAIL, "Login is being allowed with bad login type");
				}
							
		}
	
	public  void LockedLoginExpected() throws Exception {
		
		Sleep appSleep = new Sleep();
		Logs keepThisLog = new Logs();
		Wait appWait = new Wait();
		InputText appText = new InputText();
		iOSText = new AppStringsiOS(env);
		
		// phones logs in as expected. 
				appWait.WaitForCardNum2OrSleep3000();
				// Appium 1.15.1 
				WebElement cardNum2 = Capabilities.driver.findElementByXPath(appText.cardNum2());
				
				// Appium 1.14.0
				//WebElement cardNumber = Capabilities.driver.findElementById(id.LoginCardNumElement());
				
				if (cardNum2.isDisplayed()) {
					cardNum2.click();
					cardNum2.clear();
//					cardNum2.click();
					
					WebElement selectAllText = Capabilities.driver.findElementByXPath(appText.SelectAllText());
					selectAllText.click();
					
					//SELECT ALL IS Not WORKING!!!! FIX it....
					
					WebElement cutText = Capabilities.driver.findElementByXPath(appText.CutAllText());
								
					cutText.click();

//					appSleep.ThreadSleep3000();
					
					
					
			
				Actions actionCardNum2 = new Actions(Capabilities.driver);
				//Actions actionReturn = new Actions(Capabilities.driver);
											
				//send cardnumber to the card controll app
				actionCardNum2.sendKeys(iOSText.getENVData("CARD_LOGIN_LOCK_EXPECTED"));
				//7083059961002500561
				keepThisLog.CapturedLogs(iOSText.PASS, "Card Number entered.");
				
				//actionReturn.sendKeys(Keys.RETURN).build().perform();

				appSleep.ThreadSleep1();
				} else {
					keepThisLog.CapturedLogs(iOSText.FAIL, "CardNumber text box is not found");	
				}
			
			
				appSleep.ThreadSleep1();	
				
				
				
				// Find the login Password/pin textbox tell if find or fail.
				appWait.WaitForInvalidCardPinOrSleep3000();
				// Appium 1.15.1 
				WebElement invalidCardPin = Capabilities.driver.findElementByXPath(appText.invalidCardPin());
				
				//Appium 1.14.0
				//WebElement pin = Capabilities.driver.findElementById(id.LoginPinElement());
				
				
				//	Actions actionReturn = new Actions(Capabilities.driver);
					
					if (invalidCardPin.isDisplayed()) {
						invalidCardPin.click();
						invalidCardPin.clear();
						invalidCardPin.click();
					
					WebElement selectAllText = Capabilities.driver.findElementByXPath(appText.SelectAllText());
					selectAllText.click();
					WebElement cutText = Capabilities.driver.findElementByXPath(appText.CutAllText());
					cutText.click();
					
					Actions actioninvalidCardPin = new Actions(Capabilities.driver);
					actioninvalidCardPin.sendKeys(iOSText.cardControlPinLock()); // send Pin to card control app
					
					//1111
					
					WebElement cardNumbers1 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					WebElement cardNumbers2 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					WebElement cardNumbers3 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					WebElement cardNumbers4 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					cardNumbers1.click();
					cardNumbers2.click();
					cardNumbers3.click();
					cardNumbers4.click();
					
				
					appSleep.ThreadSleep3000();
					keepThisLog.CapturedLogs(iOSText.PASS, "Pin entered.");
					
					} else {
					keepThisLog.CapturedLogs(iOSText.FAIL, "invalid Card Pin Text box is not found");
				}
					
//DIT		
					ConnectionHandler dbCheckDIT = new ConnectionHandler(env);
					
					ResultSet card_info_now = dbCheckDIT.query("mysql", String.format("select status_id from sec_user where user_id = %s","7083059961002500561"));
					
					card_info_now.next();
					
					if (card_info_now.getString("status_id").equals("S")){
						keepThisLog.CapturedLogs(iOSText.INFO, "Card Account Was Suspended prior to testing");
										
						    dbCheckDIT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '7083059961002500561'");
							keepThisLog.CapturedLogs("Test Pass", "Card Account is not longer suspended ready for next run.");
							dbCheckDIT.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
							keepThisLog.CapturedLogs(iOSText.INFO, "Login attempted field equals Null");
							keepThisLog.CapturedLogs(iOSText.INFO, "Restarting Locked Login Expected test.");
							LockedLoginExpected();
							
					} else if (card_info_now.getString("status_id").equals("A")){
						
						
						int loginAttempt = 0;
										
					while (loginAttempt <5) {						

//DIT						
						ConnectionHandler dbNowDIT = new ConnectionHandler(env);
								
								dbNowDIT.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
								keepThisLog.CapturedLogs(iOSText.INFO, "Login attempted field equals Null");
							
						
						
//SIT						
//					ConnectionHandlerSIT dbCheckSIT = new ConnectionHandlerSIT();
//					
//					ResultSet card_info_now = dbCheckSIT.query("mysql", String.format("select status_id from sec_user where user_id = %s","7083059961002500561"));
//					
//					card_info_now.next();
//					
//					if (card_info_now.getString("status_id").equals("S")){
//						keepThisLog.CapturedLogs("Test Pass", "Card Account Was Suspended prior to testing");
//										
//						    dbCheckSIT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '7083059961002500561'");
//							keepThisLog.CapturedLogs("Test Pass", "Card Account is not longer suspended ready for next run.");
//							dbCheckSIT.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
//							keepThisLog.CapturedLogs("Test Pass", "Login attempted field equals Null");
//							keepThisLog.CapturedLogs("Test Pass", "Restarting Locked Login Expected test.");
//							LockedLoginExpected();
//							
//					} else if (card_info_now.getString("status_id").equals("A")){
//						
//						
//						int loginAttempt = 0;
//										
//					while (loginAttempt <5) {						

//SIT					
//						ConnectionHandlerSIT dbNowSIT = new ConnectionHandlerSIT();
//						dbNowSIT.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
//						keepThisLog.CapturedLogs("Test Pass", "Login attempted field equals Null");


						
						
						//added sleep to try to get numbers to match
						appSleep.ThreadSleep3000();
					
					// Login failed attempt 1
						
					appWait.WaitForLoginButtonOrSleep3000();
					WebElement loginKey = Capabilities.driver.findElementByXPath(appText.LoginButton());
					
					
					if (loginKey.isEnabled()) {
					loginKey.click();
					
					//added sleep to try to get numbers to match
					appSleep.ThreadSleep3000();
					
					loginAttempt ++;
					keepThisLog.CapturedLogs(iOSText.PASS, "Login Button Pressed.");
					keepThisLog.CapturedLogs(iOSText.INFO, "Locked Login attempted: " + String.valueOf(loginAttempt) + " times");
					//appWait.WaitForHomeOrSleep3000();
					
					}else{
						
						
						
						WebElement pinSuspended = xpath.CardPinSuspendedTextBox();

						
						
							if (pinSuspended.isDisplayed()) {
								pinSuspended.click();
								//pinSuspended.clear();
								//pinSuspended.click();
														
							Actions actionUserpinSuspended= new Actions(Capabilities.driver);
							actionUserpinSuspended.sendKeys(iOSText.CARRIER_PASSWORD_FAIL_EXPECTED); // send Pin to card control app
							appSleep.ThreadSleep3000();
							keepThisLog.CapturedLogs(iOSText.PASS, "Pin entered.");
							} else {
							keepThisLog.CapturedLogs(iOSText.FAIL, "Pin text box is not found");
						}
						
					keepThisLog.CapturedLogs(iOSText.FAIL, "Login Button is not found");
				}
					
				
			}
	
								
					}
					
//					appWait.WaitForVPNOrSleep3000();
//					WebElement vpnConnection = Capabilities.driver.findElementByXPath(appText.VpnConnect());
//					//System.out.println("This is VPn: " + vpnConnection.getText());	
//					
//					if (vpnConnection.getText().contains("Check your connection.")) {
//						
//						keepThisLog.CapturedLogs("Test Fail", "Device is not connected connect to vpn");
//						Capabilities.driver.closeApp();
//										
//					}else {
//						keepThisLog.CapturedLogs("Test Pass", "VPN is connected.");
//					}
					
					
					
					//CHANGE THIS TO CHECK FOR LOCKOUT TEXT 
					
//					appWait.WaitForFailTextOrSleep3000();
//					WebElement failText = Capabilities.driver.findElementByXPath(appText.FailLoginText());
//					System.out.println("This is bad login text: " + failText.getText());	
//					
//					if (failText.getText().contains("Your account has been temporarily locked.")) {
//						
//						keepThisLog.CapturedLogs("Test Pass", "Login details are incorrect shouldn't let you in");
//						
//										
//					}else {
//						keepThisLog.CapturedLogs("Test Fail", "Login is being allowed with bad login type");
//					}
								
			}
	
	
public  void SuspendedLoginExpected() throws Exception {
	iOSText = new AppStringsiOS(env);	
	Sleep appSleep = new Sleep();
		Logs keepThisLog = new Logs();
		Wait appWait = new Wait();
		InputText appText = new InputText();
	
		RepoCarrieriOS xpath = new RepoCarrieriOS();

//SIT		
		ConnectionHandler dbACPT = new ConnectionHandler(env);
		
		ResultSet card_info_now = dbACPT.query("mysql", String.format("select status_id from sec_user where user_id = %s","7083059961002500561"));
	
//DIT		
//		ConnectionHandler dbCheckDIT = new ConnectionHandlerDIT();
		
//		ResultSet card_info_now = dbCheckSIT.query("mysql", String.format("select status_id from sec_user where user_id = %s","7083059961002500561"));
		
		
		
		card_info_now.next();
		
		if (card_info_now.getString("status_id").equals("S")){
			keepThisLog.CapturedLogs(iOSText.INFO, "Card Account Was Suspended prior to testing");
		
		} else if (card_info_now.getString("status_id").equals("A")){
			
			keepThisLog.CapturedLogs(iOSText.INFO, "Card not already suspended. Suspended Login testing started");
											
//			int loginAttempt = 0;
//			
//			while (loginAttempt <1) {
			
						//added sleep to try to get numbers to match
						appSleep.ThreadSleep3000();

						ConnectionHandler dbACPT1 = new ConnectionHandler(env);
						
//SIT						
							dbACPT1.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
							keepThisLog.CapturedLogs(iOSText.INFO, "Login attempted field equals Null");
						
//DIT						
//							dbDIT.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
//							keepThisLog.CapturedLogs("Test Pass", "Login attempted field equals Null");

							
							WebElement pinSuspended = xpath.CardPinSuspendedTextBox();
						
							if (pinSuspended.isDisplayed()) {
								pinSuspended.click();
								pinSuspended.clear();
								pinSuspended.click();
							
							
							WebElement selectAllText = Capabilities.driver.findElementByXPath(appText.SelectAllText());
							selectAllText.click();
							WebElement cutText = Capabilities.driver.findElementByXPath(appText.CutAllText());
							cutText.click();

							appSleep.ThreadSleep3000();
							
							
							Actions actionUserpinSuspended= new Actions(Capabilities.driver);
							actionUserpinSuspended.sendKeys(iOSText.CARRIER_LOGIN_PASSWORD_SUSPENDED); // send Pin to card control app
							
							WebElement loginKey = Capabilities.driver.findElementByXPath(appText.LoginButton());
								if (loginKey.isEnabled()) {
								loginKey.click();
								appSleep.ThreadSleep3000();
								keepThisLog.CapturedLogs(iOSText.PASS, "Login Button Pressed.");
							
								}
							keepThisLog.CapturedLogs(iOSText.PASS, "Pin entered.");
							//appWait.WaitForHomeOrSleep3000();
							
							
							} else {
							keepThisLog.CapturedLogs(iOSText.FAIL, "Pin text box is not found");
						}
			}

		
					
//DB SIT		
					ConnectionHandler dbACPT2 = new ConnectionHandler(env);
					
					ResultSet card_info = dbACPT2.query("mysql", String.format("select status_id from sec_user where user_id = %s","7083059961002500561"));
					
					card_info.next();
					
					if (card_info.getString("status_id").equals("S")){
						keepThisLog.CapturedLogs(iOSText.INFO, "Card Account Was Suspended successfully");
						dbACPT2.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '7083059961002500561'");
						keepThisLog.CapturedLogs(iOSText.INFO, "Card Account is no longer suspended ready for next run.");
						dbACPT2.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
						keepThisLog.CapturedLogs(iOSText.INFO, "Login attempted field equals Null");
						keepThisLog.CapturedLogs(iOSText.INFO, "Now moving to Login Pass Verification test");
					}else {
						keepThisLog.CapturedLogs(iOSText.INFO, String.format("Card Account status is: %s", card_info.getString("status_id")));

					}
					
					
//DB DIT		
//					ConnectionHandler dbDIT = new ConnectionHandler();
//					
//					ResultSet card_info = dbDIT.query("mysql", String.format("select status_id from sec_user where user_id = %s","7083059961002500561"));
//					
//					card_info.next();
//					
//					if (card_info.getString("status_id").equals("S")){
//						keepThisLog.CapturedLogs("Test Pass", "Card Account Was Suspended successfully");
//						dbDIT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '7083059961002500561'");
//						keepThisLog.CapturedLogs("Test Pass", "Card Account is no longer suspended ready for next run.");
//						dbDIT.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
//						keepThisLog.CapturedLogs("Test Pass", "Login attempted field equals Null");
//						keepThisLog.CapturedLogs("Test Pass", "Now moving to Login Pass Verification test");
//					}else {
//						keepThisLog.CapturedLogs("Test Fail", String.format("Card Account status is: %s", card_info.getString("status_id")));
//
//					}
			}
	
}

