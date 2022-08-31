package iOSCarrierClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;




public class PreferredContactMethodCheck {
	public PreferredContactMethodCheck(){}
	
	//TODO Add to all 		
		private String env;
		//TODO Add to all 		
			public void PreferredContactMethodCheck(String environment) throws Exception {
				this.env = environment;
				PreferredContactMethod();
			}

	
public  void PreferredContactMethod() throws Exception {
		
	Sleep appSleep = new Sleep();
		Logs keepThisLog = new Logs();
		Wait appWait = new Wait();
		InputText appText = new InputText();
		AppStringsiOS carrierText = new AppStringsiOS();
		RepoCarrieriOS xpath = new RepoCarrieriOS();
		
		keepThisLog.CapturedLogs("Test Info", "Preferred Method token setup in databse Testing started.");

						
	
		ConnectionHandler dbACPT = new ConnectionHandler(env);
		dbACPT.execute("mysql", "update sec_user set preferred_token_method = 'E' where user_id = '100045'");
		keepThisLog.CapturedLogs("Test Info", "Carrier preferred token method is now set to E prior to testing. Testing is ready to begin.");


		ResultSet carrier_info_now = dbACPT.query("mysql", String.format("select preferred_token_method from sec_user where user_id = %s","100045"));
		
		carrier_info_now.next();
		
	 if (carrier_info_now.getString("preferred_token_method").equals("E") || (carrier_info_now.getString("preferred_token_method").equals("T") || (carrier_info_now.getString("preferred_token_method").equals("T")))) {
			
			keepThisLog.CapturedLogs("Test Info", "Carrier preferred token method is currently set to Email, Text, or Both.");
											
						

			
			//Set token method to null and try login for modal 
						appSleep.ThreadSleep3000();
						
							dbACPT.execute("mysql", "update sec_user set preferred_token_method = NULL where user_id = '100045'");
							keepThisLog.CapturedLogs("Test Info", "Carrier preferred token method is now set to NULL. Testing is ready to begin.");
							
							
							
							AppStringsiOS carrierControlNumber = new AppStringsiOS();
							
							keepThisLog.CapturedLogs("Test Info", "Preferred Token Modal testing initiated.");

						
						
							
							WebElement CarrierNumberTextbox = xpath.CarrierNumberFailTexbox();
							
							
							WebElement carrierNumberLoginPass = Capabilities.driver.findElementByXPath(carrierText.getENVData("CARD_LOGIN_FAIL_EXPECTED"));

							// Appium 1.14.0
							//WebElement cardNumber = Capabilities.iphone7.findElementById(id.LoginCardNumElement());
										
							
							
							if (carrierNumberLoginPass.isDisplayed()) {
								carrierNumberLoginPass.click();
								
								
							
							
//								WebElement more = xpath.CarrierMore();
//								more.click();
//						
								Actions actionCarrierControlNumber = new Actions(Capabilities.driver);
								actionCarrierControlNumber.sendKeys(carrierText.CARRIER_LOGIN_ID_UNIVERSAL);
								

								
							
							keepThisLog.CapturedLogs("Test Pass", "Carrier Number text box was found.");
							keepThisLog.CapturedLogs("Test Pass", "Carrier Number entered.");
							
							//actionReturn.sendKeys(Keys.RETURN).build().perform();

							appSleep.ThreadSleep1();
							} else {
								keepThisLog.CapturedLogs("Test Fail", "Carrier Number text box is not found");
								keepThisLog.CapturedLogs("Test Fail", "Carrier Number was not enetered");	
							}
						
						
							appSleep.ThreadSleep1();	
							
							
							
							// Find the login Password textbox tell if find or fail.
										
							// Appium 1.15.1
							WebElement pass = xpath.PasswordTextbox();
							
							
								if (pass.isDisplayed()) {
								
									pass.click();
									pass.clear();
									pass.click();
								
								

								appSleep.ThreadSleep3000();
								
														
								
								Actions actionUserPass = new Actions(Capabilities.driver);
								actionUserPass.sendKeys(carrierControlNumber.CarrierLoginPasswordTwo());
								
							
								} else {
								keepThisLog.CapturedLogs("Test Fail", "Password text box is not found");
								keepThisLog.CapturedLogs("Test Fail", "Password was not entered");
							}
								
								appWait.WaitForLoginButtonOrSleep3000();
								WebElement loginKey = Capabilities.driver.findElementByXPath(appText.LoginButton());
								
								if (loginKey.isEnabled()) {
								loginKey.click();
								
								keepThisLog.CapturedLogs("Test Pass", "Login Button is found.");
								keepThisLog.CapturedLogs("Test Pass", "Login Button Pressed.");
								//appWait.WaitForHomeOrSleep3000();
								
								} else {
								keepThisLog.CapturedLogs("Test Fail", "Login Button is not found");
								keepThisLog.CapturedLogs("Test Fail", "Login Button was not found");
							}

								
								
								
								dbACPT.execute("mysql", "update sec_user set preferred_token_method = 'E' where user_id = '100045'");

								
								
		}
	 
		WebElement tokenModal = Capabilities.driver.findElementByXPath(appText.TokenInfoNeededModal());			
		WebElement okButton = Capabilities.driver.findElementByXPath(appText.SomethingWentWrongOKButton());
	 
	 if (tokenModal.isDisplayed()) {
		 okButton.click();
			keepThisLog.CapturedLogs("Test Info", "Token modal seen and closed.");

	 }
	 
													
	}
}

