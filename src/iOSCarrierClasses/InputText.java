package iOSCarrierClasses;



public class InputText {

	
	//Carrier control inputs section: 
	
	//Added more Web elements here-J
	
	
	
	
	//////////////////////
	

	public String faceIDAllow() throws Exception {
		String faceIDAllow = "//XCUIElementTypeButton[@name=\"Don’t Allow\"]";

		return faceIDAllow;
	}
	
	public String touchIDCancel() throws Exception {
		String touchIDCancel = "(//XCUIElementTypeButton[@name=\"Cancel\"])[2]";
		
		return touchIDCancel;
	}
	
	
	

public String deleteText() throws Exception {

	String deleteText = "//XCUIElementTypeKey[@name=\"delete\"]";

	return deleteText;
}

	
	
	
	public String CarrierInvalidModal() throws Exception {
		String CarrierNumFailTextField = "//XCUIElementTypeOther[@name=\"UsernameTextView\"]";

 

		return CarrierNumFailTextField;
	}
		
	
	
	
	
	public String somethingWentWrongModal() throws Exception {

		String somethingWentWrongModal = "//XCUIElementTypeStaticText[@name=\"Something Went Wrong\"]";
		
		
		return somethingWentWrongModal;
	}
	
	
	
	
	
	
	public String invalidUserPassModal() throws Exception {

		String invalidUserPassModal = "//XCUIElementTypeAlert[@name=\"Invalid Username or Password\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther";

		return invalidUserPassModal;
	}

	
	
	
	public String lockedAccountModal() throws Exception {

		String lockedAccountModal = "//XCUIElementTypeStaticText[@name=\"Your Account is Locked\"]";
		
		return lockedAccountModal;
	}
	
	
	
	
	
	
	
	public String invalidCarrierUserText() throws Exception {

		String invalidCarrierUserText = "//XCUIElementTypeStaticText[@name=\"Invalid Username or Password\"]";

		return invalidCarrierUserText;
	}
	
	
	public String CarrierNumLockedTextField() throws Exception {

		String CarrierNumLockedTextField = "//XCUIElementTypeOther[@name=\"CarrierControl\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField";

		return CarrierNumLockedTextField;
	}
	
	public String CarrierLockedPasswordText() throws Exception {

		String CarrierLockedPasswordText = "//XCUIElementTypeOther[@name=\"CarrierControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeSecureTextField";
		return CarrierLockedPasswordText;
	}
	
	public String CarrierPasswordLocked2TextBox() throws Exception {

		String CarrierPasswordLocked2TextBox = "//XCUIElementTypeOther[@name=\"CarrierControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField";
		//XCUIElementTypeOther[@name="CardControl"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField


		return CarrierPasswordLocked2TextBox;
	}
	
	public String CarrierPasswordSuspendedTextBox() throws Exception {

		String CarrierPasswordSuspendedTextBox = "//XCUIElementTypeOther[@name=\"CarrierControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeSecureTextField";
		//XCUIElementTypeOther[@name="CardControl"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField
		//XCUIElementTypeOther[@name="CardControl"]/XCUIElementTypeOther[5]/XCUIElementTypeTextField


		return CarrierPasswordSuspendedTextBox;
	}	

	
	public String CarrierNumPassTextField() throws Exception {
		String CarrierNumFailTextField = "//XCUIElementTypeOther[@name=\"CarrierControl\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField";


		return CarrierNumFailTextField;
	}
	
		
	
	
	
	//Card control input section: 
	
	public InputText() {

	}
	
	public String refreshButton() throws Exception {

		String cardMaintenancemmbutton = "(//XCUIElementTypeImage[@name=\"refresh\"])";

		return cardMaintenancemmbutton;
	}
	
public String openMMenuButton() throws Exception {
		

		
		String openMMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
		
		return openMMenuButton;
	}

public String openACMenuButton() throws Exception {
	

	
	String openACMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openACMenuButton;
}

public String openCMMenuButton() throws Exception {
	

	
	String openCMMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openCMMenuButton;
}

public String openRCMenuButton() throws Exception {
	

	
	String openRCMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openRCMenuButton;
}

public String openStatementsMenuButton() throws Exception {
	

	
	String openStatementsMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openStatementsMenuButton;
}

public String openTRMenuButton() throws Exception {
	

	
	String openTRMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openTRMenuButton;
}

public String openTFMenuButton() throws Exception {
	

	
	String openTFMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openTFMenuButton;
}
public String openContactUsMenuButton() throws Exception {
	

	
	String openContactUsMenuButton = "//XCUIElementTypeButton[@name=\"menu\"]";
	
	return openContactUsMenuButton;
}


public String homeMMButton() throws Exception {

	String homemmbutton = "//XCUIElementTypeButton[@name=\"Home\"]";

	return homemmbutton;
}

public String accountActivtyMMButton() throws Exception {

	String accountactivtymmbutton = "//XCUIElementTypeButton[@name=\"Account Activity\"]";
	//String accountactivtymmbutton = "Account Activity";						

	return accountactivtymmbutton;
}

public String cardMaintenanceMMButton() throws Exception {

	String cardMaintenancemmbutton = "//XCUIElementTypeButton[@name=\"Card Maintenance\"]";

	return cardMaintenancemmbutton;
}

public String PriceLocatorMMbutton() throws Exception {

	String PriceLocatormmbutton = "//XCUIElementTypeButton[@name=\"Price Locator\"]";

	return PriceLocatormmbutton;
}

public String RegisterCheckMMButton() throws Exception {

	String RegisterCheckmmbutton = "//XCUIElementTypeButton[@name=\"Register Check\"]";

	return RegisterCheckmmbutton;
}

public String StatementsMMButton() throws Exception {

	String Statementsmmbutton = "//XCUIElementTypeButton[@name=\"Statements\"]";

	return Statementsmmbutton;
}

public String TransactionRejectsMMButton() throws Exception {

	String TransactionRejectsmmbutton = "//XCUIElementTypeButton[@name=\"Transaction Rejects\"]";

	return TransactionRejectsmmbutton;
}

public String TransferFundsMMButton() throws Exception {

	String TransferFundsmmbutton = "//XCUIElementTypeButton[@name=\"Transfer Funds\"]";

	return TransferFundsmmbutton;
}

public String ContactUsMMButton() throws Exception {

	String ContactUsmmbutton = "//XCUIElementTypeButton[@name=\"Contact Us\"]";

	return ContactUsmmbutton;
}

public String LogoutMMButton() throws Exception {

	String Logoutmmbutton = "//XCUIElementTypeButton[@name=\"Logout\"]";

	return Logoutmmbutton;
}

public String LogoutModalYesButton() throws Exception {

	String LogoutModalYesButton = "//XCUIElementTypeButton[@name=\"Yes\"]";

	return LogoutModalYesButton;
}

public String LogoutModalNoButton() throws Exception {

	String LogoutModalNoButton = "//XCUIElementTypeButton[@name=\"No\"]";;

	return LogoutModalNoButton;
}

public String Number0() throws Exception {
	

	
	//String number0 = "//XCUIElementTypeKey[@name=\"0\"]";
	String number0 = "0";
	return number0;
}

public String Number1() throws Exception {
	

	
	//String number1 = "//XCUIElementTypeKey[@name=\"1\"]";
	String number1 = "1";
	return number1;
}




public String Number2() throws Exception {
	

	
	//String number2 = "//XCUIElementTypeKey[@name=\"2\"]";
	String number2 = "2";
	return number2;
}

public String Number3() throws Exception {
	

	
	//String number3 = "//XCUIElementTypeKey[@name=\"3\"]";
	String number3 = "3";
	return number3;
}

public String Number4() throws Exception {
	

	
	//String number4 = "//XCUIElementTypeKey[@name=\"4\"]";
	String number4 = "4";
	return number4;
}

public String Number5() throws Exception {
	

	
	//String number5 = "//XCUIElementTypeKey[@name=\"5\"]";
	String number5 = "5";
	return number5;
}

public String Number6() throws Exception {
	

	
	//String number6 = "//XCUIElementTypeKey[@name=\"6\"]";
	String number6 = "6";
	return number6;
}



public String Number7() throws Exception {
	

	
	//String number7 = "//XCUIElementTypeKey[@name=\"7\"]";
	String number7 = "7";
	return number7;
}

public String Number8() throws Exception {
	

	
	//String number8 = "//XCUIElementTypeKey[@name=\"8\"]";
	String number8 = "8";
	return number8;
}

public String Number9() throws Exception {
	

	
	//String number9 = "//XCUIElementTypeKey[@name=\"9\"]";
	String number9 = "9";
	return number9;
}

public String KeyBoardDelete() throws Exception {
	

	
	//String keyBoardDelete = "//XCUIElementTypeKey[@name=\"Delete\"]";
	String keyBoardDelete = "Delete";
	
	return keyBoardDelete;
}


public String LoginButton() throws Exception {
	

	
	String loginButton = "//XCUIElementTypeButton[@name=\"Log in\"]";
	return loginButton;
}


public String AccountButton() throws Exception {
	String accountButton = "//XCUIElementTypeButton[@name=\"Account\"]";
	
	return accountButton;
}

public String ContractChevron() throws Exception {
	String contractChevron = "(//XCUIElementTypeButton[@name=\"chevron\"])[1]";

	return contractChevron;
}


public String PayeeName() throws Exception {
	String payeeName = "//XCUIElementTypeTextField[@name=\"TextField\"]";
	

	return payeeName;
}





public String LogoutButton() throws Exception {
	String logoutButton = "//XCUIElementTypeStaticText[@name=\"Log out\"]";
	
	return logoutButton;
}

public String LogoutModalCancelButton() throws Exception {
	String logoutModalCancelButton = "//XCUIElementTypeButton[@name=\"Cancel\"]";

	
	return logoutModalCancelButton;
}


public String LogoutModalLogoutButton() throws Exception {
	String logoutModalLogoutButton = "//XCUIElementTypeButton[@name=\"Log out\"]";

	
	return logoutModalLogoutButton;
}


public String TokenInfoNeededModal() throws Exception {
	

	
	String TokenInfoNeededModal = "//XCUIElementTypeStaticText[@name=\"Token contact info needed\"]";

	return TokenInfoNeededModal;
}

public String PinTextField() throws Exception {
	

	
	String pinTextField = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField";

	return pinTextField;
}


public String validPinTextField() throws Exception {
	

	
	String validPinTextField = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField";

	return validPinTextField;
}


public String VpnConnectAccessID() throws Exception {

	String VpnConnectAccessID = "Check your connection.";
	
	return VpnConnectAccessID;
}

public String CardNumTextField() throws Exception {
	String cardNumTextField = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";


	return cardNumTextField;
}



public String cardNumberLoginPass() throws Exception {
	String cardNumberLoginPass = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField";

	return cardNumberLoginPass;
}

public String VpnConnect() throws Exception {

	String VpnConnect = "//XCUIElementTypeStaticText[@name=\"Check your connection.\"]";

	return VpnConnect;
}

public String invalidCardText() throws Exception {

	String invalidCardText = "//XCUIElementTypeStaticText[@name=\"Invalid Card Number or PIN/Passcode.\"]";

	return invalidCardText;
}

public String cardNum2() throws Exception {

	String cardNum2 = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField";

	return cardNum2;
}

public String cardNumLocked() throws Exception {

	String cardNumLocked = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField";
	return cardNumLocked;
}



public String SelectAllText() throws Exception {

	String SelectAllText = "//XCUIElementTypeMenuItem[@name=\"Select All\"]";

	return SelectAllText;
}

public String CutAllText() throws Exception {

	String CutAllText = "//XCUIElementTypeMenuItem[@name=\"Cut\"]";

	return CutAllText;
}

public String invalidCardPin() throws Exception {

	String invalidCardPin = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[5]/XCUIElementTypeTextField";
	


	return invalidCardPin;
}

public String ValidPinFinal() throws Exception {

	String ValidPinFinal = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[5]/XCUIElementTypeTextField";
	


	return ValidPinFinal;
}

public String CardPinSuspended() throws Exception {

	String CardPinSuspended = "//XCUIElementTypeStaticText[@name=\"Your account has been temporarily locked.\"]";
	

	return CardPinSuspended;
}

public String CardPinLockedTextBox() throws Exception {

	String CardPinLockedTextBox = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField";
	//XCUIElementTypeOther[@name="CardControl"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField


	return CardPinLockedTextBox;
}




public String LastPinLockTextBox() throws Exception {

	String LastPinLockTextBox = "//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField";



	return LastPinLockTextBox;
}

public String FailLoginText() throws Exception {

	String FailLoginText = "//XCUIElementTypeStaticText[@name=\"Your account has been suspended.\"]";

	return FailLoginText;
}


public String accountLockedDismissButton() {
	String accountLockedDismissButton = "//XCUIElementTypeButton[@name=\"Dismiss\"]";

	return accountLockedDismissButton;
}

public String SomethingWentWrongOKButton() {
	String SomethingWentWrongOKButton = "//XCUIElementTypeButton[@name=\"OK\"]";

	return SomethingWentWrongOKButton;
}



public String SomethingWentWrongModal() {
	String SomethingWentWrongModal = "//XCUIElementTypeStaticText[@name=\"Invalid Username or Password\"]";

	return SomethingWentWrongModal;
}





}

//"//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField"
//"//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField"

//"//XCUIElementTypeButton[@name=\"LOGIN\"]"


//WebElement pinNumbers1 = Capabilities.driver.findElementByXPath("//XCUIElementTypeKey[@name=\"1\"]");
//WebElement pinNumbers2 = Capabilities.driver.findElementByXPath("//XCUIElementTypeKey[@name=\"0\"]");
//WebElement pinNumbers3 = Capabilities.driver.findElementByXPath("//XCUIElementTypeKey[@name=\"7\"]");
//WebElement pinNumbers4 = Capabilities.driver.findElementByXPath("//XCUIElementTypeKey[@name=\"0\"]");




