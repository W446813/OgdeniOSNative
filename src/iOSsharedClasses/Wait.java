package iOSsharedClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import iOSCarrierClasses.ElementID;
import iOSCarrierClasses.InputText;
import iOSCarrierClasses.RepoCarrieriOS;







public class Wait{
	InputText appText = new InputText();
	ElementID ID = new ElementID();
	RepoCarrieriOS element = new RepoCarrieriOS();
	
	public Wait() {
	}
	Logs keepThisLog = new Logs();
	
	//Carrier control section: 



public Wait WaitForDoneButtonBilling3000() throws Exception {
	
	
	try {
	
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Done\"]");
		
		System.out.println("Wait initiated for Carrier Number fail text Field, or sleep for 3000");
		keepThisLog.CapturedLogs("Test Pass", "Wait for Carrier Number fail text Field initialized");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait for for Carrier Number fail text Field failed to initialize");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait for Carrier Number fail text Field failed to initialize");
	}

	return this;
}
	

	
	
public Wait WaitForCarrierNumberLockedOrSleep3000() throws Exception {
	
	
	try {
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.CarrierNumLockedTextField());
		System.out.println("Wait initiated for Wait For Locked Card Number Text Box, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Locked Card Number Text Box");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait for Locked Card Number Text Box");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Locked Card Number Text Box");
	}

	return this;
}


public Wait WaitForsomethingWentWrongModalOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.somethingWentWrongModal());
		System.out.println("Wait initiated Something Went Wrong Modal, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Something Went Wrong Modal");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Something Went Wrong Modal");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Something Went Wrong Modal");
	}

	return this;
}


public Wait WaitForinvalidUserPassModalOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.invalidUserPassModal());
		System.out.println("Wait initiated Something Went Wrong Modal, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Something Went Wrong Modal");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Something Went Wrong Modal");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Something Went Wrong Modal");
	}

	return this;
}



	
	
	
public Wait WaitForinvalidCarrierTextOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.invalidCarrierUserText());
		System.out.println("Wait initiated for Invalid Card Text, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Invalid Card Text");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Invalid Card Text");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Invalid Card Text");
	}

	return this;
}


public Wait WaitForCarrierPasswordLockedOrSleep3000() throws Exception {
	
	
	try {
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.CarrierLockedPasswordText());
		System.out.println("Wait initiated for Wait For Locked Card Number Text Box, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Locked Card Number Text Box");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait for Locked Card Number Text Box");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Locked Card Number Text Box");
	}

	return this;
}

public Wait WaitForCarrierPasswordLocked2OrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.CarrierPasswordLocked2TextBox());
		System.out.println("Wait initiated for Password Suspended text box, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Pasword Suspended textbox");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Password Suspended");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize forPassword Suspended");
	}

	return this;
}


public Wait WaitForCarrierPasswordSuspendedTextBoxOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.CarrierPasswordSuspendedTextBox());
		System.out.println("Wait initiated for Wait For Suspended Password Text Box, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Suspended Pin Text Box");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Suspended Password Text Box");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Suspended Password Text Box");
	}

	return this;
}


public Wait WaitForCarrierNumberPassOrSleep3000() throws Exception {
	
	
	try {
	
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementsByXPath(appText.CarrierNumPassTextField());
		
		System.out.println("Wait initiated for Carrier Number fail text Field, or sleep for 3000");
		keepThisLog.CapturedLogs("Test Pass", "Wait for Carrier Number fail text Field initialized");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait for for Carrier Number fail text Field failed to initialize");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait for Carrier Number fail text Field failed to initialize");
	}

	return this;
}

public Wait WaitForCarrierPasswordPassTextFieldOrSleep3000() throws Exception {


try {
	// TODO Auto-generated method stub
	Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	Capabilities.driver.findElementByXPath(appText.CarrierNumPassTextField());
	System.out.println("Wait initiated for Wait For Carrier Pasword Pass Textbox, or sleep for 3000 ");
	keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Carrier Pasword Pass Textbox");
				
} catch (org.openqa.selenium.WebDriverException e) {
	System.out.println("Wait failed to initialize for Wait For Carrier Pasword Pass Textbox");
	keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Carrier Pasword Pass Textbox");
}

return this;
}


	//Card Control section: 
	
	
		public Wait WaitForMenuOrSleep3000() throws Exception {
		
		
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementsByXPath(appText.openMMenuButton());
			
			System.out.println("Wait initiated for menu, or sleep for 3000");
			keepThisLog.CapturedLogs("Test Pass", "Wait for Menu initialized");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait for Menu failed to initialize");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu failed to initialize");
		}

		return this;
	}
	
		public Wait WaitForACMenuOrSleep3000() throws Exception {
			
			
			try {
			
				Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				Capabilities.driver.findElementsByXPath(appText.openACMenuButton());
				
				System.out.println("Wait initiated for menu, or sleep for 3000");
				keepThisLog.CapturedLogs("Test Pass", "Wait for Menu initialized");
							
			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Wait for Menu failed to initialize");
				keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu failed to initialize");
			}

			return this;
		}
	
	public Wait WaitForHomeOrSleep3000() throws Exception {
		
		
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementsByXPath(appText.homeMMButton());
			
			System.out.println("Wait initiated for menu, or sleep for 3000");
			keepThisLog.CapturedLogs("Test Pass", "Wait for Menu initialized");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait for Menu failed to initialize");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu failed to initialize");
		}

		return this;
	}
	
	public Wait WaitForMenuAAOrSleep3000() throws Exception {
		try {
			
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.openACMenuButton());
			System.out.println("Wait initiated for menu-aa, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Menu Account Activity");
			
			
			} catch (org.openqa.selenium.WebDriverException e) {
			
				System.out.println("Wait failed to initialize for Menu Account Activity");
				keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Account Activity failed to initialize");
		}
			
		
			
		return this;
		

	}
	
	public Wait WaitForMenuCcmOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementsByXPath(appText.openCMMenuButton());
			System.out.println("Wait initiated for menu Card maintenance, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for menu Card maintenance");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			
			System.out.println("Wait failed to initialize for Menu Card Manintenance");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait for Menu Card Manintenance failed to initialize");
		}

		return this;
	}
	
	
	public Wait WaitForMenuPlOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Capabilities.driver.findElementById("menu-pl");
			System.out.println("Wait initiated for Menu Price Locator, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Menu Price Locator");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Menu Price Locator");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Price Locator failed to initialize");
		}

		return this;
	}
	
	public Wait WaitForMenuRcOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.openRCMenuButton());
			System.out.println("Wait initiated for Menu Register Check, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Menu Register Check");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Menu Register Check");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Register Check failed to initialize");
		}

		return this;
	}
	
	public Wait WaitForMenuSsOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.openStatementsMenuButton());
			System.out.println("Wait initiated for Menu Statements, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Menu Statements");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Menu Statements");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Statements failed to initialize");
		}

		return this;
	}
	
	public Wait WaitForMenuTrOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.openTRMenuButton());
			System.out.println("Wait initiated for Menu Transaction Rejects, or sleep for 10 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Menu Transaction Rejects");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Menu Transaction Rejects");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Transaction Rejects failed to initialize");
		}

		return this;
	}
	
	
//	public Wait WaitForMenuTfOrSleep3000() throws Exception {
//		try {
//		
//			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//			Capabilities.driver.findElementById("menu-tf");
//			System.out.println("Wait initiated for Menu Transfer Funds, or sleep for 3000 ");
//			keepThisLog.CapturedLogs("Test Pass", "Wait initialized");
//						
//		} catch (org.openqa.selenium.WebDriverException e) {
//			System.out.println("Wait failed to initialize");
//			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Transfer Funds failed to initialize");
//		}
//
//		return this;
//	}

	public Wait WaitForMenuCtOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.openContactUsMenuButton());
			System.out.println("Wait initiated for Wait For MenuCt, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For MenuCt");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Wait For MenuCt");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For MenuCt");
		}

		return this;
	}
	
	public Wait WaitForMenuTfOrSleep3000() throws Exception {
				
		try {
						
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.openTFMenuButton());
			System.out.println("Wait initiated for Transfer funds");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Transfer funds.");
			
			
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait Menu Transfer Funds failed to initialize");
		}
		
		return this;
	}
	
	public Wait WaitForLogoutOrSleep3000() throws Exception {
		try {
		
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.LogoutMMButton());
			System.out.println("Wait initiated for Wait For Logout, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Menu Contact Us");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Wait For Logout");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Logout");
		}

		return this;
	}

	public Wait WaitForCardNumOrSleep3000() throws Exception{
		try {
	
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.CardNumTextField());
		System.out.println("Wait initiated for Wait For CardNum, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For CardNum");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For CardNum");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For CardNum");
	}

	return this;
}

	public Wait WaitForLoginButtonOrSleep3000() throws Exception {
		
		
		try {
			
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.LoginButton());
			System.out.println("Wait initiated for Wait For Login Button, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Login Button");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Wait For Login Button");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Login Button");
		}

		return this;
	}
	
	
public Wait AccountbuttonOrSleep3000() throws Exception {
		
		
		try {
			System.out.println("Wait initiated for Account Button, or sleep for 3000 ");
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.AccountButton());
			
			keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Account Button");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Account Button");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Account Button");
		}

		return this;
	}
	
public Wait SelectContractOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Contract Chevron, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.ContractChevron());
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Contract Chevron");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Contract Chevron");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Contract Chevron");
	}

	return this;
}

public Wait PayeeTextBoxOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Payee Text Box or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.PayeeName());
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Contract Chevron");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Contract Chevron");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Contract Chevron");
	}

	return this;
}



public Wait LogoutButtonOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Logout Button, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.LogoutButton());
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Logout Button");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Account Button");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Logout Button");
	}

	return this;
}


public Wait LogoutModalCancelButtonOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Account Button, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.LogoutModalCancelButton());
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Account Button");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Account Button");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Account Button");
	}

	return this;
}

public Wait LogoutModalLogoutButtonOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Account Button, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.LogoutModalLogoutButton());
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Account Button");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Account Button");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Account Button");
	}

	return this;
}


		public Wait WaitForVPNOrSleep3000() throws Exception {
		
		
		try {
			// TODO Auto-generated method stub
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.VpnConnect());
			System.out.println("Wait initiated for Wait For VPN, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For VPN");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Wait For VPN");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For VPN");
		}

		return this;
	}
	
	public Wait WaitForCardPinOrSleep3000() throws Exception {
		
		
		try {
			// TODO Auto-generated method stub
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.PinTextField());
			System.out.println("Wait initiated for Wait For Card Pin, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Card Pin");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Wait For Card Pin");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Card Pin");
		}

		return this;
	}
	public Wait WaitForinvalidCardTextOrSleep3000() throws Exception {
		
		
		try {
			// TODO Auto-generated method stub
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.invalidCardText());
			System.out.println("Wait initiated for Invalid Card Text, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Invalid Card Text");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Invalid Card Text");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Invalid Card Text");
		}

		return this;
	}
		
public Wait WaitForCardNum2OrSleep3000() throws Exception {
		
		
		try {
			Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			Capabilities.driver.findElementByXPath(appText.cardNum2());
			System.out.println("Wait initiated for Wait For Card Num 2, or sleep for 3000 ");
			keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Card Num 2");
						
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Wait failed to initialize for Wait For Card Num 2");
			keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Card Num 2");
		}

		return this;
	}

public Wait WaitForCardNumLockedOrSleep3000() throws Exception {
	
	
	try {
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.cardNumLocked());
		System.out.println("Wait initiated for Wait For Card Num 2, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Card Num 2");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Card Num 2");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Card Num 2");
	}

	return this;
}

public Wait WaitForInvalidCardPinOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.invalidCardPin());
		System.out.println("Wait initiated for Invalid Card pin Textbox, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Invalid Card pin Textbox");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Invalid Card pin Textbox");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Invalid Card pin Textbox");
	}

	return this;
}

public Wait WaitForCardPinLockedOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.CardPinLockedTextBox());
		System.out.println("Wait initiated for Card Pin Suspended text box, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Card Pin Suspended textbox");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Card Pin Suspended");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Card Pin Suspended");
	}

	return this;
}

public Wait WaitForcardNumberLoginPassOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.cardNumberLoginPass());
		System.out.println("Wait initiated for Wait For Fail Text, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Fail Text");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Fail Text");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Fail Text");
	}

	return this;
}

public Wait WaitForvalidPinTextFieldOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.validPinTextField());
		System.out.println("Wait initiated for Wait For Fail Text, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Fail Text");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Fail Text");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Fail Text");
	}

	return this;
	
}
public Wait WaitForvalidPinFinalFieldOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.ValidPinFinal());
		System.out.println("Wait initiated for Wait For Valid Pin Final Textbox, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Valid Pin Final Textbox");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Valid Pin Final Textbox");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Valid Pin Final Textbox");
	}
		
	return this;
}





public Wait WaitforLastPinLockTextBoxOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.LastPinLockTextBox());
		System.out.println("Wait initiated for Wait For Suspended Pin Text Box, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Suspended Pin Text Box");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Suspended Pin Text Box");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Suspended Pin Text Box");
	}

	return this;
}


public Wait WaitForFailTextOrSleep3000() throws Exception {
	
	
	try {
		// TODO Auto-generated method stub
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.FailLoginText());
		System.out.println("Wait initiated for Wait For Fail Text, or sleep for 3000 ");
		keepThisLog.CapturedLogs("Test Pass", "Wait initialized for Wait For Fail Text");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Wait For Fail Text");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Wait For Fail Text");
	}

	return this;
}


//added waits for tabs here -J.

//Moneycodes tab sleep
public Wait MoneyCodesTabOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Money Codes tab, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"MC\"]"); //replace xpath
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for MoneyCodes tab");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for MoneyCodes tab");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for MoneyCodes tab");
	}

	return this;
}

//Cards tab sleep























public Wait CardsTabOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Cards tab, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		element.CardsTab();
		//Capabilities.driver.findElementByXPath(element.CardsTab().toString()); //replace xpath
	
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Cards tab");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Cards tab");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Cards tab");
	}

	return this;
}

//transactions tab sleep
public Wait TransactionsTabOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for transactions tab, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Transactions\"]"); //replace xpath
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Transactions tab");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Transactions tab");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Transactions tab");
	}

	return this;
}

//payments tab sleep
public Wait BillingTabOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for payments tab, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Billing\"]"); //replace xpath
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for payments tab");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for payments tab");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for payments tab");
	}

	return this;
}

//Accounts tab sleeps
public Wait AccountsTabOrSleep3000() throws Exception {
	
	
	try {
		System.out.println("Wait initiated for Accounts tab, or sleep for 3000 ");
		Capabilities.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Capabilities.driver.findElementByXPath(appText.AccountButton());
		
		keepThisLog.CapturedLogs("Test Pass", "Wait initiated for Account tab");
					
	} catch (org.openqa.selenium.WebDriverException e) {
		System.out.println("Wait failed to initialize for Account tab");
		keepThisLog.CapturedLogs("***Test Fail***", "Wait failed to initialize for Account tab");
	}

	return this;
}





}
	

