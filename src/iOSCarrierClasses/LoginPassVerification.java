package iOSCarrierClasses;

	
	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

	public class LoginPassVerification {

		public LoginPassVerification() {}
		
		 AppiumDriver<WebElement> driver;
			

			// static WebDriver driverWeb;

		 public  void PassExpected() throws Exception {
				Sleep appSleep = new Sleep();
				Logs keepThisLog = new Logs();
				Wait appWait = new Wait();
				AppStringsiOS cardControlNumber = new AppStringsiOS();
				InputText appText = new InputText();	
				
				
			
				// Appium 1.15.1 
				appWait.WaitForCardNum2OrSleep3000();
				WebElement cardNumberLoginPass = Capabilities.driver.findElementByXPath(appText.cardNum2());
				keepThisLog.CapturedLogs("Test Pass", "Login Pass Verification started succesfully.");

				// Appium 1.14.0
				//WebElement cardNumber = Capabilities.iphone7.findElementById(id.LoginCardNumElement());
							
				
				if (cardNumberLoginPass.isDisplayed()) {
					cardNumberLoginPass.click();
					cardNumberLoginPass.clear();
					cardNumberLoginPass.click();
					
					WebElement selectAllText = Capabilities.driver.findElementByXPath(appText.SelectAllText());
					selectAllText.click();
					WebElement cutText = Capabilities.driver.findElementByXPath(appText.CutAllText());
					cutText.click();

					appSleep.ThreadSleep3000();
				
			
					Actions actionCardNumber = new Actions(Capabilities.driver);
					actionCardNumber.sendKeys(cardControlNumber.CardControlNumber());
					
				
					Actions actionUserCard = new Actions(Capabilities.driver);
					actionUserCard.sendKeys(cardControlNumber.CardControlNumber());
					//7083051010269845547
					
					WebElement cardNumbers1 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
					WebElement cardNumbers2 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
					WebElement cardNumbers3 = Capabilities.driver.findElementByAccessibilityId(appText.Number8());
					WebElement cardNumbers4 = Capabilities.driver.findElementByAccessibilityId(appText.Number3());
					WebElement cardNumbers5 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
					WebElement cardNumbers6 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
					WebElement cardNumbers7 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					WebElement cardNumbers8 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
					WebElement cardNumbers9 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					WebElement cardNumbers10 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
					WebElement cardNumbers11 = Capabilities.driver.findElementByAccessibilityId(appText.Number2());
					WebElement cardNumbers12 = Capabilities.driver.findElementByAccessibilityId(appText.Number6());
					WebElement cardNumbers13 = Capabilities.driver.findElementByAccessibilityId(appText.Number9());
					WebElement cardNumbers14 = Capabilities.driver.findElementByAccessibilityId(appText.Number8());
					WebElement cardNumbers15 = Capabilities.driver.findElementByAccessibilityId(appText.Number4());
					WebElement cardNumbers16 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
					WebElement cardNumbers17 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
					WebElement cardNumbers18 = Capabilities.driver.findElementByAccessibilityId(appText.Number4());
					WebElement cardNumbers19 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
					cardNumbers1.click();
					cardNumbers2.click();
					cardNumbers3.click();
					cardNumbers4.click();
					cardNumbers5.click();
					cardNumbers6.click();
					cardNumbers7.click();
					cardNumbers8.click();
					cardNumbers9.click();
					cardNumbers10.click();
					cardNumbers11.click();
					cardNumbers12.click();
					cardNumbers13.click();
					cardNumbers14.click();
					cardNumbers15.click();
					cardNumbers16.click();
					cardNumbers17.click();
					cardNumbers18.click();
					cardNumbers19.click();
				
				keepThisLog.CapturedLogs("Test Pass", "Card Number text box was found.");
				keepThisLog.CapturedLogs("Test Pass", "Card Number entered.");
				
				//actionReturn.sendKeys(Keys.RETURN).build().perform();

				appSleep.ThreadSleep1();
				} else {
					keepThisLog.CapturedLogs("Test Fail", "CardNumber text box is not found");
					keepThisLog.CapturedLogs("Test Fail", "CardNumber was not enetered");	
				}
			
			
				appSleep.ThreadSleep1();	
				
				
				
				// Find the login Password textbox tell if find or fail.
							
				// Appium 1.15.1
				appWait.WaitForvalidPinFinalFieldOrSleep3000();
				WebElement pin = Capabilities.driver.findElementByXPath(appText.ValidPinFinal());
				
				//Appium 1.14.0
				//WebElement pin = Capabilities.driver.findElementById(id.LoginPinElement());
				
					
					if (pin.isDisplayed()) {
					
					pin.click();
					pin.clear();
					pin.click();
					
					WebElement selectAllText = Capabilities.driver.findElementByXPath(appText.SelectAllText());
					selectAllText.click();
					WebElement cutText = Capabilities.driver.findElementByXPath(appText.CutAllText());
					cutText.click();

					appSleep.ThreadSleep3000();
					
					Actions actionUserPin = new Actions(Capabilities.driver);
					actionUserPin.sendKeys(cardControlNumber.cardControlPin());
					WebElement pinNumbers1 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
					WebElement pinNumbers2 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
					WebElement pinNumbers3 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
					WebElement pinNumbers4 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
					pinNumbers1.click();
					pinNumbers2.click();
					pinNumbers3.click();
					pinNumbers4.click();
					
					
									

					} else {
					keepThisLog.CapturedLogs("Test Fail", "Pin text box is not found");
					keepThisLog.CapturedLogs("Test Fail", "Pin was not entered");
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
					
					
					
					
//					WebElement conectVPN = Capabilities.driver.findElementByAccessibilityId(appText.VpnConnectAccessID());
//					//System.out.println("This is VPn: " + conectVPN.getText());		
//					if (conectVPN.getText().equalsIgnoreCase("Check your connection.")) {
//						
//						keepThisLog.CapturedLogs("Test Fail", "Device is not connected connect to vpn");
//						Capabilities.driver.closeApp();
//										
//					}else if (!conectVPN.getText().equalsIgnoreCase("Check your connection.")){
//						keepThisLog.CapturedLogs("Test Pass", "VPN is connected.");
//					}
					
//					WebElement conectVPN = Capabilities.driver.findElementByXPath(appText.VpnConnect());
//					//System.out.println("This is VPn: " + conectVPN.getText());		
//					if (conectVPN.getText().contains("Check your connection.")) {
//						
//						keepThisLog.CapturedLogs("Test Fail", "Device is not connected connect to vpn");
//						Capabilities.driver.closeApp();
//										
//					}else {
//						keepThisLog.CapturedLogs("Test Pass", "VPN is connected.");
//					}
					
								
			}
			
		}
