package iOSCarrierClasses;



import org.openqa.selenium.WebElement;

import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;


public class OpenCardControlUsingDatabase {
	
	 		AppiumDriver<WebElement> driver;	

			// static WebDriver driverWeb;

			public static void openCardControl() throws Exception {
				Sleep appSleep = new Sleep();
				Logs keepThisLog = new Logs();
				PhonePicker phone = new PhonePicker();
				LoginFailVerification failLogin = new LoginFailVerification();
				LoginPassVerification passLogin = new LoginPassVerification();
				String appName = "Card Control";
				
				System.out.println(phone.autoPhonePickerCard(appName));
				
				keepThisLog.CapturedLogs("--Card Control--", "--App testing Logs started--");
				appSleep.ThreadSleep3000();
				
				
				
				
				//App is given incorrect login details.
				failLogin.FailExpected();
							
				//App is given a good card bad pin untill the account is locked
				failLogin.LockedLoginExpected();
				
				//App is given an incorrect pint untill the account is suspended. 
				failLogin.SuspendedLoginExpected();
				
				//app is given a good card but a bad pin expected to fail login, and app is given a bad card and a good pin expected to fail login
				
						
				//App is given good login details and logs in successfully. 
				passLogin.PassExpected();
					
										
			}
	// static WebDriver driverWeb;

//	public static void openCardControl() throws Exception {
//		Sleep appSleep = new Sleep();
//		Logs keepThisLog = new Logs();
//		//Wait appWait = new Wait();
//		Login cardControlNumber = new Login();
//		PhonePicker phone = new PhonePicker();
//		InputText appText = new InputText();
//		
//		
//		
//		
//			//opens auto phone picker
//			
//			
//		System.out.println(phone.autoPhonePicker());
//		
//		
//		
//		
//		keepThisLog.CapturedLogs("--Card Control--", "--App testing Logs started--");
//		appSleep.ThreadSleep3000();
//		
//		
//try {
//			
//			QTRecord.startQTrecord();
//			
//		
//							
//		} catch (Exception exp) {
//
//			System.out.println(exp.getCause());
//			System.out.println(exp.getMessage());
//			exp.printStackTrace();
//
//		}
//
//	appSleep.ThreadSleep3000();
//		// Appium 1.15.1 
//		WebElement cardNumber = Capabilities.driver.findElementByXPath(appText.CardNumTextField());
//		
//
//		// Appium 1.14.0
//		//WebElement cardNumber = Capabilities.iphone7.findElementById(id.LoginCardNumElement());
//		
//		
//		
//		
//		if (cardNumber.isDisplayed()) {
//			cardNumber.click();
//			
//		
//		if 	(cardNumber.toString().isEmpty()){
//			Actions actionCardNumber = new Actions(Capabilities.driver);
//			actionCardNumber.sendKeys(cardControlNumber.CardControlNumber());
//			
//		
//			Actions actionUserCard = new Actions(Capabilities.driver);
//			actionUserCard.sendKeys(cardControlNumber.cardControlPin());
//			//7083051010269845547
//			
//			WebElement cardNumbers1 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
//			WebElement cardNumbers2 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
//			WebElement cardNumbers3 = Capabilities.driver.findElementByAccessibilityId(appText.Number8());
//			WebElement cardNumbers4 = Capabilities.driver.findElementByAccessibilityId(appText.Number3());
//			WebElement cardNumbers5 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
//			WebElement cardNumbers6 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
//			WebElement cardNumbers7 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
//			WebElement cardNumbers8 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
//			WebElement cardNumbers9 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
//			WebElement cardNumbers10 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
//			WebElement cardNumbers11 = Capabilities.driver.findElementByAccessibilityId(appText.Number2());
//			WebElement cardNumbers12 = Capabilities.driver.findElementByAccessibilityId(appText.Number6());
//			WebElement cardNumbers13 = Capabilities.driver.findElementByAccessibilityId(appText.Number9());
//			WebElement cardNumbers14 = Capabilities.driver.findElementByAccessibilityId(appText.Number8());
//			WebElement cardNumbers15 = Capabilities.driver.findElementByAccessibilityId(appText.Number4());
//			WebElement cardNumbers16 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
//			WebElement cardNumbers17 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
//			WebElement cardNumbers18 = Capabilities.driver.findElementByAccessibilityId(appText.Number4());
//			WebElement cardNumbers19 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
//			cardNumbers1.click();
//			cardNumbers2.click();
//			cardNumbers3.click();
//			cardNumbers4.click();
//			cardNumbers5.click();
//			cardNumbers6.click();
//			cardNumbers7.click();
//			cardNumbers8.click();
//			cardNumbers9.click();
//			cardNumbers10.click();
//			cardNumbers11.click();
//			cardNumbers12.click();
//			cardNumbers13.click();
//			cardNumbers14.click();
//			cardNumbers15.click();
//			cardNumbers16.click();
//			cardNumbers17.click();
//			cardNumbers18.click();
//			cardNumbers19.click();
//		}
//			
//		
//	
//		
//		//send cardnumber to the card controll app
//		
//	
//	
//		
//		keepThisLog.CapturedLogs("Test Pass", "Card Number text box was found.");
//		keepThisLog.CapturedLogs("Test Pass", "Card Number entered.");
//		
//		//actionReturn.sendKeys(Keys.RETURN).build().perform();
//
//		appSleep.ThreadSleep1();
//		} else {
//			keepThisLog.CapturedLogs("Test Fail", "CardNumber text box is not found");
//			keepThisLog.CapturedLogs("Test Fail", "CardNumber was not enetered");	
//		}
//	
//	
//		appSleep.ThreadSleep1();	
//		
//		
//		
//		// Find the login Password textbox tell if find or fail.
//					
//		// Appium 1.15.1 
//		WebElement pin = Capabilities.driver.findElementByXPath(appText.PinTextField());
//		
//		//Appium 1.14.0
//		//WebElement pin = Capabilities.driver.findElementById(id.LoginPinElement());
//		
//			
//			if (pin.isDisplayed()) {
//			
//			pin.click();
//			
//			
//			Actions actionUserPin = new Actions(Capabilities.driver);
//			actionUserPin.sendKeys(cardControlNumber.cardControlPin());
//			WebElement pinNumbers1 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
//			WebElement pinNumbers2 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
//			WebElement pinNumbers3 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
//			WebElement pinNumbers4 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
//			pinNumbers1.click();
//			pinNumbers2.click();
//			pinNumbers3.click();
//			pinNumbers4.click();
//			
//			appSleep.ThreadSleep3000();
//			appSleep.ThreadSleep1();
//			Thread.sleep(1); // put to sleep to load next automation.
//			
//			
//			
//						
//			
//			WebElement loginKey = Capabilities.driver.findElementByAccessibilityId(appText.LoginButton());
//
//			loginKey.click();
//			
//			keepThisLog.CapturedLogs("Test Pass", "Pin text box is found.");
//			keepThisLog.CapturedLogs("Test Pass", "Pin entered.");
//			//appWait.WaitForHomeOrSleep3000();
//			
//			} else {
//			keepThisLog.CapturedLogs("Test Fail", "Pin text box is not found");
//			keepThisLog.CapturedLogs("Test Fail", "Pin was not entered");
//		}
//			
////			WebElement conectVPN = Capabilities.driver.findElementByAccessibilityId(appText.VpnConnectAccessID());
////			//System.out.println("This is VPn: " + conectVPN.getText());		
////			if (conectVPN.getText().equalsIgnoreCase("Check your connection.")) {
////				
////				keepThisLog.CapturedLogs("Test Fail", "Device is not connected connect to vpn");
////				Capabilities.driver.closeApp();
////								
////			}else if (!conectVPN.getText().equalsIgnoreCase("Check your connection.")){
////				keepThisLog.CapturedLogs("Test Pass", "VPN is connected.");
////			}
//			
////			WebElement conectVPN = Capabilities.driver.findElementByXPath(appText.VpnConnect());
////			//System.out.println("This is VPn: " + conectVPN.getText());		
////			if (conectVPN.getText().contains("Check your connection.")) {
////				
////				keepThisLog.CapturedLogs("Test Fail", "Device is not connected connect to vpn");
////				Capabilities.driver.closeApp();
////								
////			}else {
////				keepThisLog.CapturedLogs("Test Pass", "VPN is connected.");
////			}
//			
//						
//	}
}
