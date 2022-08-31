package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;

public class RepoCarrieriOS {
	public Logs iOSLogs = new Logs();
	Sleep appSleep = new Sleep();
	public AppStringsiOS iOSText = new AppStringsiOS();
	public String moneycodePageSource = "";
	public String cardsPageSource = "";
	public String transactionsPageSource = "";
	public String billingPageSource = "";
	public String accountPageSource = "";
	public String cardsOverviewPageSource = "";
	public String extrasPageSource = "";

	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	String elementButton = "//XCUIElementTypeButton[@name=";
	String elementButtonLabel = "//XCUIElementTypeButton[@label=";
	String typeImage = "//XCUIElementTypeImage[@name=";
	String staticText = "//XCUIElementTypeStaticText[@name=";
	String staticTextLabel = "//XCUIElementTypeStaticText[@label=";
	String staticTextValue = "//XCUIElementTypeStaticText[@value=";
	String textField = "//XCUIElementTypeTextField[@name=";
	String textFieldValue = "//XCUIElementTypeTextField[@value=";
	String secureText = "//XCUIElementTypeSecureTextField[@value=";
	String typeApp = "//XCUIElementTypeApplication[@name=";
	String elementButtonLike = "//*[@name=";
	String SwitchValue = "//XCUIElementTypeSwitch[@value=";
	String SwitchName = "//XCUIElementTypeSwitch[@name=";
	String otherName = "//XCUIElementTypeOther[@name=";
	
//test
	// finds the elements on the page asked for
	public Boolean pageElement(String elementLabel, String pageSource) {

		if (pageSource == "" || pageSource == null) {
			return false;
		}

		Boolean foundPageSource = false;

		switch (pageSource) {
		case "moneycode":
			this.moneycodePageSource = lookupPageSource(this.moneycodePageSource);
			foundPageSource = this.moneycodePageSource.contains(elementLabel);
			return foundPageSource;

		case "cardsOverview":
			this.cardsOverviewPageSource = lookupPageSource(this.cardsOverviewPageSource);
			foundPageSource = this.cardsOverviewPageSource.contains(elementLabel);
			return foundPageSource;
			
		
		case "cards":
			this.cardsPageSource = lookupPageSource(this.cardsPageSource);
			foundPageSource = this.cardsPageSource.contains(elementLabel);
			return foundPageSource;

		case "transactions":
			this.transactionsPageSource = lookupPageSource(this.transactionsPageSource);
			foundPageSource = this.transactionsPageSource.contains(elementLabel);
			return foundPageSource;

		case "billing":
			this.billingPageSource = lookupPageSource(this.billingPageSource);
			foundPageSource = this.billingPageSource.contains(elementLabel);
			return foundPageSource;

		case "account":
			this.accountPageSource = lookupPageSource(this.accountPageSource);
			foundPageSource = this.accountPageSource.contains(elementLabel);
			return foundPageSource;

		default:
			// extras always gets over written as a they are usually done or close etc
			this.extrasPageSource = Capabilities.driver.getPageSource();
			foundPageSource = this.extrasPageSource.contains(elementLabel);
			return foundPageSource;
		}
	}

	private String lookupPageSource(String pageSource) {
		if (pageSource == "") {
			pageSource = Capabilities.driver.getPageSource();
		}

		return pageSource;

	}

	// create one of these for every page in the automation
	public Boolean findMoneyCodePageElement(String elementLabel) {
		return pageElement(elementLabel, "moneycode");
	}

	// create one of these for every page in the automation
	public Boolean findCardsPageElement(String elementLabel) {
		return pageElement(elementLabel, "cards");
	}

	// create one of these for every page in the automation
	public Boolean findCardsOverviewPageElement(String elementLabel) {
		return pageElement(elementLabel, "cardsOverView");
	}
	
	
	// create one of these for every page in the automation
	public Boolean findTransactionsPageElement(String elementLabel) {
		return pageElement(elementLabel, "transactions");
	}

	// create one of these for every page in the automation
	public Boolean findBillingPageElement(String elementLabel) {
		return pageElement(elementLabel, "billing");
	}

	// create one of these for every page in the automation
	public Boolean findAccountPageElement(String elementLabel) {
		return pageElement(elementLabel, "account");
	}

	// create one of these for every page in the automation
	public Boolean findExtrasPageSource(String elementLabel) {
		return pageElement(elementLabel, "default");
	}

	public void clearPageElement(String pageSource) {
		pageSource = "";
	}
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for FACE ID Screen
	
	
	public WebElement CancelButtonFaceID() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement CancelButtonFaceID = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Cancel\"]");
			iOSLogs.CapturedLogs(info, "Cancel Button for FACE ID found");
			return CancelButtonFaceID;
		} else {
			iOSLogs.CapturedLogs(info, "Cancel Button for FACE ID Not found");
			return null;
		}
	}
	
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for Welcome Screen
	public WebElement WelcomeScreen() throws Exception {
		WebElement WelcomeScreen = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeImage[@name=\"Onboarding1\"]");
		return WelcomeScreen;
	}

	public WebElement getStarted() throws Exception {
		WebElement getStarted = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Get started\"]");
		return getStarted;
	}

	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	//Web Elements for Biometrics	
	
	public WebElement BiometricsXR() throws Exception {
		if (findExtrasPageSource("Don’t Allow")) {
			WebElement BiometricsXR = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Don’t Allow\"]");
			iOSLogs.CapturedLogs(info, "Biometrics XR phone Don't allow button found");
			return BiometricsXR;
		} else {
			iOSLogs.CapturedLogs(info, "Biometrics XR phone Don't allow button Not found");
			return null;
		}
	}
	
	
	public WebElement BiometricsiPhone8() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement BiometricsiPhone8 = Capabilities.driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Cancel\"])[2]");
			iOSLogs.CapturedLogs(info, "Biometrics iPhone 8 phone Don't allow button found");
			return BiometricsiPhone8;
		} else {
			iOSLogs.CapturedLogs(info, "Biometrics iPhone 8 phone Don't allow button Not found");
			return null;
		}
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		//Web Elements for loading Progress Spinners
	
	public WebElement progressSpinnerSchedulePaymentBilling() throws Exception {
		if(findExtrasPageSource("Schedule payment")) {
		WebElement progressSpinnerSubmitPaymentInvoice = Capabilities.driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Schedule payment\"]");
		iOSLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
		return progressSpinnerSubmitPaymentInvoice;
		}else {
			iOSLogs.CapturedLogs(info, "Loading Spinner was not found");
			return null;
		}
		}
	
	
	public WebElement loadingRejectsSpinnerText() throws Exception {
		Thread.sleep(3000);
		if(findExtrasPageSource("ActivityStatusView")) {
		WebElement loadingSpinnerText = Capabilities.driver.findElementByXPath("//XCUIElementTypeOther[@name=\"ActivityStatusView\"]"); 
		iOSLogs.CapturedLogs(info, "Loading Spinner text was found");
		return loadingSpinnerText;
		}
		else {
			iOSLogs.CapturedLogs(info, "Loading Spinner text was not found");
			return null;
		}
		}
	
	
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Web Elements for Login
	public WebElement CarrierNumberTextbox() throws Exception {
		if (findExtrasPageSource("UsernameTextView")) {
			WebElement CarrierNumberTextbox = Capabilities.driver.findElementByXPath(otherName+"\"UsernameTextView\"]");
						
			iOSLogs.CapturedLogs(info, "Carrier number text box found");
			return CarrierNumberTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "Carrier number text box Not found");
			return null;
		}
	}
	
	public WebElement PasswordTextbox() throws Exception {
		if (findExtrasPageSource("PasswordContainerView")) {
			WebElement PasswordTextbox = Capabilities.driver.findElementByXPath(otherName+"\"PasswordContainerView\"]");
				
			iOSLogs.CapturedLogs(info, "Password text box found");
			return PasswordTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "Password text box Not found");
			return null;
		}
	}
	
	public WebElement LoginButton() throws Exception {
		if (findExtrasPageSource("Log in")) {
			WebElement LoginButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Log in\"]");
			iOSLogs.CapturedLogs(info, "Log in button found");
			return LoginButton;
		} else {
			iOSLogs.CapturedLogs(info, "Log in button not found");
			return null;
		}
	}
	
	public WebElement CarrierNumFailTextField() throws Exception {
		if (findExtrasPageSource("UsernameTextView")) {
			WebElement CarrierNumFailTextField = Capabilities.driver.findElementByXPath("//XCUIElementTypeOther[@name=\"UsernameTextView\"]");
			iOSLogs.CapturedLogs(info, "Carrier Number Fail Expected text box was found");
			return CarrierNumFailTextField;
		} else {
			iOSLogs.CapturedLogs(info, "Carrier Number Fail Expected text box was not found");
			return null;
		}
	}
	
	
	
	
	public WebElement LoginButtonCarrier() throws Exception {
		if (findExtrasPageSource("Log in")) {
			WebElement LoginButtonCarrier = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Log in\"]");
			iOSLogs.CapturedLogs(info, "Login Button was found");
			return LoginButtonCarrier;
		} else {
			iOSLogs.CapturedLogs(info, "Login Button was not found");
			return null;
		}
	}
	
	

	public WebElement CarrierNumberFailTexbox() throws Exception {
		if (findExtrasPageSource("UsernameTextView")) {
			WebElement CarrierNumberFailTexbox = Capabilities.driver.findElementByXPath("//XCUIElementTypeOther[@name=\"UsernameTextView\"]");
			iOSLogs.CapturedLogs(info, "Login Button was found");
			return CarrierNumberFailTexbox;
		} else {
			iOSLogs.CapturedLogs(info, "Login Button was not found");
			return null;
		}
	}
	
//	public WebElement InvalidUserPassModal() throws Exception {
//		if (findExtrasPageSource("Invalid Username or Password")) {
//			WebElement InvalidUserPassModal = Capabilities.driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Invalid Username or Password\"]");
//			iOSLogs.CapturedLogs(info, "Invalid User Pass Modal was found");
//			return InvalidUserPassModal;
//		} else {
//			iOSLogs.CapturedLogs(info, "Invalid User Pass Modal was not found");
//			return null;
//		}
//	}
	
	public WebElement InvalidModalOkButton() throws Exception {
		if (findExtrasPageSource("OK")) {
			WebElement InvalidModalOkButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"OK\"]");
			iOSLogs.CapturedLogs(info, "Invalid Modal ok Button was found");
			return InvalidModalOkButton;
		} else {
			iOSLogs.CapturedLogs(info, "Invalid Modal ok Button not found");
			return null;
		}
	}
	
	
//	public WebElement CarrierMore() throws Exception {
//		if (findExtrasPageSource("more")) {
//			WebElement CarrierMore = Capabilities.driver.findElementByXPath("//XCUIElementTypeKey[@name=\"more\"]");
//			iOSLogs.CapturedLogs(info, "More Button was found");
//			return CarrierMore;
//		} else {
//			iOSLogs.CapturedLogs(info, "More Button not found");
//			return null;
//		}
//	}
	

////Check Xpath	
//	public WebElement CarrierPasswordFailTextField() throws Exception {
//		if (findExtrasPageSource("OK")) {
//			WebElement CarrierPasswordFailTextField = Capabilities.driver.findElementByXPath("//XCUIElementTypeOther[@name=\"PasswordContainerView\"]");
//			iOSLogs.CapturedLogs(info, "More Button was found");
//			return CarrierPasswordFailTextField;
//		} else {
//			iOSLogs.CapturedLogs(info, "More Button not found");
//			return null;
//		}
//	}
	
	
//	public WebElement CarrierPasswordPassTextField() throws Exception {
//		if (findExtrasPageSource("more")) {
//			WebElement CarrierPasswordPassTextField = Capabilities.driver.findElementByXPath("//XCUIElementTypeOther[@name=\"CarrierControl\"]/XCUIElementTypeOther[4]/XCUIElementTypeSecureTextField");
//			iOSLogs.CapturedLogs(info, "More Button was found");
//			return CarrierPasswordPassTextField;
//		} else {
//			iOSLogs.CapturedLogs(info, "More Button not found");
//			return null;
//		}
//	}
//	
	
	public WebElement lockedUserModal() throws Exception {
		if (findExtrasPageSource("Account temporarily locked")) {
			WebElement lockedUserModal = Capabilities.driver.findElementByXPath("//XCUIElementTypeAlert[@name=\"Account temporarily locked\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			iOSLogs.CapturedLogs(info, "More Button was found");
			return lockedUserModal;
		} else {
			iOSLogs.CapturedLogs(info, "More Button not found");
			return null;
		}
	}
	
	
	public WebElement CardPinSuspendedTextBox() throws Exception {
		if (findExtrasPageSource("CardControl")) {
			WebElement CardPinSuspendedTextBox = Capabilities.driver.findElementByXPath("//XCUIElementTypeOther[@name=\"CardControl\"]/XCUIElementTypeOther[5]/XCUIElementTypeTextField");
			iOSLogs.CapturedLogs(info, "More Button was found");
			return CardPinSuspendedTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "More Button not found");
			return null;
		}
	}
	
	
	public WebElement accountLockedDismissButton() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement accountLockedDismissButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Dismiss\"]");
			iOSLogs.CapturedLogs(info, "More Button was found");
			return accountLockedDismissButton;
		} else {
			iOSLogs.CapturedLogs(info, "More Button not found");
			return null;
		}
	}
	
	
	public WebElement SelectAllText() throws Exception {
		if (findExtrasPageSource("Select All")) {
			WebElement SelectAllText = Capabilities.driver.findElementByXPath("//XCUIElementTypeMenuItem[@name=\"Select All\"]");
			iOSLogs.CapturedLogs(info, "Select All Button was found");
			return SelectAllText;
		} else {
			iOSLogs.CapturedLogs(info, "Select All Button not found");
			return null;
		}
	}
	
	
	public WebElement CutAllText() throws Exception {
		if (findExtrasPageSource("Cut")) {
			WebElement CutAllText = Capabilities.driver.findElementByXPath("//XCUIElementTypeMenuItem[@name=\"Cut\"]");
			iOSLogs.CapturedLogs(info, "Select All Button was found");
			return CutAllText;
		} else {
			iOSLogs.CapturedLogs(info, "Select All Button not found");
			return null;
		}
	}
	
	
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Web Elements for Log out
	public WebElement LogoutButton() throws Exception {
		if (findExtrasPageSource("LogOutButton")) {
			WebElement LogoutButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"LogOutButton\"]");
			iOSLogs.CapturedLogs(info, "Log Out button found");
			return LogoutButton;
		} else {
			iOSLogs.CapturedLogs(info, "Log Out button not found");
			return null;
		}
	}
	
	public WebElement LogoutModalCancelButton() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement LogoutModalCancelButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Cancel\"]");
			iOSLogs.CapturedLogs(info, "Log Out modal cancel button found");
			return LogoutModalCancelButton;
		} else {
			iOSLogs.CapturedLogs(info, "Log Out modal cancel button not found");
			return null;
		}
	}
	
	public WebElement LogoutModalLogoutButton() throws Exception {
		if (findExtrasPageSource("Log out")) {
			WebElement LogoutModalLogoutButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Log out\"]");
			iOSLogs.CapturedLogs(info, "Log Out modal log out button found");
			return LogoutModalLogoutButton;
		} else {
			iOSLogs.CapturedLogs(info, "Log Out modal log out button not found");
			return null;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Web Elements for MoneyCodes Tab section

	public WebElement MoneyCodesTab() throws Exception {
		WebElement moneyCodesTab = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"MC\"]");
		iOSLogs.CapturedLogs(info, "MoneyCode tab found");
		return moneyCodesTab;
	}

	public WebElement NewMoneyCodeButton() throws Exception {
		if (findMoneyCodePageElement("IssueMoneycodeButton")) {
			WebElement newMoneyCodeButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"IssueMoneycodeButton\"]");
			iOSLogs.CapturedLogs(info, "Issue Moneycode Button found");
			
			return newMoneyCodeButton;
		} else {
			iOSLogs.CapturedLogs(info, "Issue Moneycode Button Not found");
			return null;
		
		}
	}

	public WebElement SelectContractMoneyCodes() throws Exception {
		if (findExtrasPageSource("ShadowedTableViewCell")) {
			WebElement selectContractMoneyCodes = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeCell[@name=\"ShadowedTableViewCell\"])[1]");
			
			iOSLogs.CapturedLogs(info, "Select Contract for Money Code found");
			return selectContractMoneyCodes;
		} else {
			iOSLogs.CapturedLogs(info, "Select Contract for Money Code not found");
			return null;
		}
	}

	public WebElement PayeeNameTextBox() throws Exception {
		if (findExtrasPageSource("TextField")) {
			WebElement payeeNameTextBox = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");
			iOSLogs.CapturedLogs(info, "Payee Name TextBox found");
			return payeeNameTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Payee Name TextBox not found");
			return null;
		}
	}

	public WebElement NextButtonMoneyCode() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement nextButtonMoneyCode = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Next\"]");
			iOSLogs.CapturedLogs(info, "Next Button MoneyCode Found");
			return nextButtonMoneyCode;
		} else {
			iOSLogs.CapturedLogs(info, "Next Button MoneyCode Not Found");
			return null;
		}
	}

	public WebElement AmountMoneyCodeTextBox() throws Exception {
		if (findExtrasPageSource("TextField")) {
			WebElement AmountMoneyCodeTextBox = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");
			iOSLogs.CapturedLogs(info, "Amount MoneyCode TextBox found");
			return AmountMoneyCodeTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Amount MoneyCode TextBox not found");
			return null;
		}
	}

	public WebElement AmountNextMoneyCode() throws Exception {
		if (findExtrasPageSource("SubmitButton")) {
			WebElement amountNextMoneyCode = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SubmitButton\"]");
			iOSLogs.CapturedLogs(info, "Amount NextMoney Code button not found");
			return amountNextMoneyCode;
		} else {
			iOSLogs.CapturedLogs(info, "Amount NextMoney Code button not found");
			return null;
		}
	}

	public WebElement InfoDetailsNotesTextBox() throws Exception {
		WebElement infoDetailsNotesTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField");
		return infoDetailsNotesTextBox;
	}

	public WebElement SkipInfoFieldsMoneyCodes() throws Exception {
		if (findExtrasPageSource("SubmitButton")) {
			WebElement skipInfoFieldsMoneyCodes = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SubmitButton\"]");
			iOSLogs.CapturedLogs(info, "Skip Info Fields MoneyCodes button not found");
			return skipInfoFieldsMoneyCodes;
		} else {
			iOSLogs.CapturedLogs(info, "Skip Info Fields MoneyCodes button not found");
			return null;
		}
	}

	public WebElement InfoNextButtonMoneyCode() throws Exception {
		if (findExtrasPageSource("SubmitButton")) {
			WebElement infoNextButtonMoneyCode = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SubmitButton\"]");
			iOSLogs.CapturedLogs(info, "Info Next  MoneyCode button found");
			return infoNextButtonMoneyCode;
		} else {
			iOSLogs.CapturedLogs(info, "Info Next MoneyCode button not found");
			return null;
		}
	}

	public WebElement IssueMoneyCodeButton() throws Exception {
		if (findExtrasPageSource("Issue MoneyCode")) {
//			WebElement issueMoneyCodeButton = Capabilities.driver
//					.findElementByXPath("//XCUIElementTypeButton[@name=\"IssueMoneycodeButton\"]");
			WebElement issueMoneyCodeButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Issue MoneyCode\"]");
			
			
			iOSLogs.CapturedLogs(info, "Issue MoneyCode button found");
			return issueMoneyCodeButton;
		} else {
			iOSLogs.CapturedLogs(info, "Issue MoneyCode button not found");
			return null;
		}
	}

	public WebElement DismissMoneyCodeButton() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement dismissMoneyCodeButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Dismiss\"]");
			iOSLogs.CapturedLogs(info, "Dismiss Money Code button found");
			return dismissMoneyCodeButton;
		} else {
			iOSLogs.CapturedLogs(info, "Dismiss Money Code button not found");
			return null;
		}
	}

	public WebElement DismissMoneyCodeModalButton() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement dismissMoneyCodeModalButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Dismiss\"]");
			iOSLogs.CapturedLogs(info, "Dismiss MoneyCode Modal button found");
			return dismissMoneyCodeModalButton;
		} else {
			iOSLogs.CapturedLogs(info, "Dismiss MoneyCode Modal button not found");
			return null;
		}
	}

	public WebElement SelectCreatedMoneyCode() throws Exception {
		if (findMoneyCodePageElement("IssuedAmountLabel")) {
			WebElement selectCreatedMoneyCode = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"IssuedAmountLabel\"])[2]");
			iOSLogs.CapturedLogs(info, "Select Created MoneyCode button found");
			return selectCreatedMoneyCode;
		} else {
			iOSLogs.CapturedLogs(info, "Select Created MoneyCode button not found");
			return null;
		}
	}

	public WebElement VoidMoneyCodeButton() throws Exception {
		WebElement voidMoneyCodeButton = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[8]");
		return voidMoneyCodeButton;
	}

	public WebElement VoidMoneyCodeModal() throws Exception {
		if (findExtrasPageSource("Void")) {
			WebElement voidMoneyCodeModal = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Void\"]");
			iOSLogs.CapturedLogs(info, "Void MoneyCode Modal button found");
			return voidMoneyCodeModal;
		} else {
			iOSLogs.CapturedLogs(info, "Void MoneyCode Modal button found");
			return null;
		}
	}

	public WebElement MoneyCodeBackButton() throws Exception {
		if (findExtrasPageSource("MoneyCodes")) {
			WebElement moneyCodeBackButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"MoneyCodes\"]");
			iOSLogs.CapturedLogs(info, "MoneyCode Back Button button found");
			return moneyCodeBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "MoneyCode Back Button button not found");
			return null;
		}
	}

	public WebElement InfoFieldsDriverIDCheckBox() throws Exception {
		if (findExtrasPageSource("Driver ID")) {
			WebElement InfoFieldsDriverIDCheckBox = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]");
			iOSLogs.CapturedLogs(info, "Info Fields DriverID CheckBox found");
			return InfoFieldsDriverIDCheckBox;
		} else {
			iOSLogs.CapturedLogs(info, "Driver ID check box not found");
			return null;
		}
	}

	public WebElement Add1FieldsButton() throws Exception {
		if (findExtrasPageSource("SubmitButton")) {
			WebElement Add1FieldsButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SubmitButton\"]");
			iOSLogs.CapturedLogs(info, "Add 1 Fields button button found");
			return Add1FieldsButton;
		} else {
			iOSLogs.CapturedLogs(info, "Add 1 Fields button button not found");
			return null;
		}
	}

	public WebElement InfoFieldsDriverTextBox() throws Exception {
		if (findExtrasPageSource("Driver Name")) {
			WebElement InfoFieldsDriverTextBox = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField");
			iOSLogs.CapturedLogs(info, "Driver Name text box found");
			return InfoFieldsDriverTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Driver Name text box not found");
			return null;
		}
	}

	public WebElement EditFeeIcon() throws Exception {
		WebElement EditFeeIcon = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]");
		return EditFeeIcon;
	}

	public WebElement DeductFeeNowRadioButton() throws Exception {
		if (findExtrasPageSource("Deduct fee now")) {
			//WebElement DeductFeeNowRadioButton = Capabilities.driver.findElementByXPath(
			//		"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]");
			
			WebElement DeductFeeNowRadioButton = Capabilities.driver.findElementByXPath(staticTextValue+"\"Deduct fee now\"]");
			
			
			iOSLogs.CapturedLogs(info, "Decduct fee now Radio button found");
			return DeductFeeNowRadioButton;
		} else {
			iOSLogs.CapturedLogs(info, "Decduct fee now Radio button not found");
			return null;
		}
	}

	public WebElement BackButtonEditFee() throws Exception {
		WebElement BackButtonEditFee = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"New MoneyCode\"]/XCUIElementTypeButton");
		return BackButtonEditFee;
	}

	public WebElement SendToPayeeButton() throws Exception {
		if (findExtrasPageSource("SendToDriverButton")) {
			WebElement DeductFeeNowRadioButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SendToDriverButton\"]");
			iOSLogs.CapturedLogs(info, "Send To Payee Button fee now found");
			return DeductFeeNowRadioButton;
		} else {
			iOSLogs.CapturedLogs(info, "Send To Payee Button fee now not found");
			return null;
		}
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Web Elements for cards Tab section

	public WebElement CardsTab() throws Exception {
		WebElement cardsTab = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Cards\"]");
		return cardsTab;
	}

	public WebElement DriverSelection() throws Exception {

		if (findCardsPageElement("Driver")) {
			WebElement driverSelection = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Driver\"]");
			iOSLogs.CapturedLogs(info, "Driver Selection found");
			return driverSelection;
		} else {
			iOSLogs.CapturedLogs(info, "Driver Selection not found");
			return null;
		}
	}

	public WebElement DriverSearch() throws Exception {
		if (findCardsPageElement("Search by driver name")) {
			WebElement driverSearch = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeSearchField[@name=\"Search by driver name\"]");
			iOSLogs.CapturedLogs(info, "Search by driver name found");
			return driverSearch;
		} else {
			iOSLogs.CapturedLogs(info, "Search by driver name not found");
			return null;
		}
	}

//don't use pagesource for physical button
	public WebElement PhysicalSearchButton() throws Exception {
		WebElement physicalSearchButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Search\"]");
		return physicalSearchButton;
	}

	public WebElement DriverSearchResult() throws Exception {
		WebElement driverSearchResult = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		return driverSearchResult;
	}

	public WebElement UnitSelection() throws Exception {
		if (findCardsPageElement("Unit")) {
			WebElement unitSelection = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Unit\"]");
			iOSLogs.CapturedLogs(info, "Search by Unit Selection found");
			return unitSelection;
		} else {
			iOSLogs.CapturedLogs(info, "Search by Unit Selection not found");
			return null;
		}
	}

	public WebElement UnitSearch() throws Exception {
		if (findExtrasPageSource("Search by unit")) {
			WebElement unitSearch = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeSearchField[@name=\"Search by unit\"]");
			iOSLogs.CapturedLogs(info, "Search by Unit found");
			return unitSearch;
		} else {
			iOSLogs.CapturedLogs(info, "Search by Unit not found");
			return null;
		}
	}

	public WebElement UnitSearchResult() throws Exception {
		WebElement unitSearchResult = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		return unitSearchResult;
	}

	public WebElement CardSelection() throws Exception {
		if (findCardsPageElement("Card")) {
			WebElement cardSelection = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Card\"]");
			iOSLogs.CapturedLogs(info, "Card Selection found");
			return cardSelection;
		} else {
			iOSLogs.CapturedLogs(info, "Card Selection not found");
			return null;
		}
	}

	public WebElement CardSearch() throws Exception {
		if (findExtrasPageSource("Search by card #")) {
			WebElement cardSearch = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeSearchField[@name=\"Search by card #\"]");
			iOSLogs.CapturedLogs(info, "Card Search by card # found");
			return cardSearch;
		} else {
			iOSLogs.CapturedLogs(info, "Card Search by card # not found");
			return null;
		}
	}

	public WebElement CardSearchResult() throws Exception {
		WebElement cardSearchResult = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		return cardSearchResult;
	}

	public WebElement CardSearchResultCardsOverview() throws Exception {
		WebElement cardSearchResult = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]");
		return cardSearchResult;
	}

	public WebElement DriverIDSelection() throws Exception {
		if (findCardsPageElement("Driver ID")) {
			WebElement driverIDSelection = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Driver ID\"]");
			iOSLogs.CapturedLogs(info, "Driver ID found");
			return driverIDSelection;
		} else {
			iOSLogs.CapturedLogs(info, "Driver ID not found");
			return null;
		}
	}

	public WebElement DriverIDSearch() throws Exception {
		if (findExtrasPageSource("Search by driver ID")) {
			WebElement driverIDSearch = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeSearchField[@name=\"Search by driver ID\"]");
			iOSLogs.CapturedLogs(info, "Search by driver ID found");
			return driverIDSearch;
		} else {
			iOSLogs.CapturedLogs(info, "Search by driver ID not found");
			return null;
		}
	}

	public WebElement DriverIDSearchResult() throws Exception {
		WebElement driverIDSearchResult = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		return driverIDSearchResult;
	}

	public WebElement PolicySelection() throws Exception {
		if (findAccountPageElement("Policy")) {
			WebElement policySelection = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Policy\"]");
			iOSLogs.CapturedLogs(info, "Policy found");
			return policySelection;
		} else {
			iOSLogs.CapturedLogs(info, "Policy not found");
			return null;
		}
	}

	public WebElement PolicySearch() throws Exception {
		if (findExtrasPageSource("Policy")) {
			WebElement policySearch = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeSearchField[@name=\"Search by policy\"]");
			iOSLogs.CapturedLogs(info, "Search by policy found");
			return policySearch;
		} else {
			iOSLogs.CapturedLogs(info, "Search by policy not found");
			return null;
		}
	}

	public WebElement PolicySearchResult() throws Exception {
		WebElement policySearchResult = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		return policySearchResult;
	}

//*********** Web Elements for Cards overview page *************//

	public WebElement SmartfundsCardImage() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("SmartFunds")) {
			WebElement SmartfundsCardImage = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
			iOSLogs.CapturedLogs(info, "Smartfunds Card Image found");
			return SmartfundsCardImage;
		} else {
			iOSLogs.CapturedLogs(info, "Smartfunds Card Image not found");
			return null;
		}
	}

	public WebElement CompanyTab() throws Exception {
		Thread.sleep(2000);
		if (findCardsOverviewPageElement("Company")) {
			WebElement CompanyTab = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Company\"]");

			iOSLogs.CapturedLogs(info, "Company tab found");
			return CompanyTab;
		} else {
			iOSLogs.CapturedLogs(info, "Company tab not found");
			return null;
		}
	}

//Load cash ~~~~~~~~~~~~//
	public WebElement LoadCashButton() throws Exception {
		Thread.sleep(2000);
		if (findCardsOverviewPageElement("LoadCashBottomButton")) {
			WebElement LoadCashButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"LoadCashBottomButton\"]");

			iOSLogs.CapturedLogs(info, "Load cash button found");
			return LoadCashButton;
		} else {
			iOSLogs.CapturedLogs(info, "Load cash button not found");
			return null;
		}
	}

	public WebElement LoadCashAmountTextBox() throws Exception {
		Thread.sleep(2000);
		WebElement LoadCashAmountTextBox = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");

		return LoadCashAmountTextBox;
	}

	public WebElement LoadCashNextButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("NextButton")) {
			WebElement LoadCashNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info,"Next button found");
			return LoadCashNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}

	public WebElement LoadCashAmountButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("Load $1.99")) {
			WebElement LoadCashAmountButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Load $1.99\"]");

			// only works if amount is $1.99
			iOSLogs.CapturedLogs(info, "Load amount button found");
			return LoadCashAmountButton;
		} else {
			iOSLogs.CapturedLogs(info, "Load amount button not found");
			return null;
		}
	}

	public WebElement SmartfundsTab() throws Exception {
		Thread.sleep(2000);
		if (findCardsOverviewPageElement("SmartFunds")) {
			WebElement SmartfundsTab = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SmartFunds\"]");

			iOSLogs.CapturedLogs(info, "Smartfunds tab found");
			return SmartfundsTab;
		} else {
			iOSLogs.CapturedLogs(info, "Smartfunds tab not found");
			return null;
		}
	}

//Remove cash ~~~~~~~~~~~~//

	public WebElement RemoveCashButton() throws Exception {
		Thread.sleep(2000);
		if (findCardsOverviewPageElement("RemoveCashButton")) {
			WebElement RemoveCashButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"RemoveCashButton\"]");

			iOSLogs.CapturedLogs(info, "Remove cash button found");
			return RemoveCashButton;
		} else {
			iOSLogs.CapturedLogs(info, "Remove cash button not found");
			return null;
		}
	}

	public WebElement RemoveCashAmountTextBox() throws Exception {
		Thread.sleep(2000);
		WebElement RemoveCashAmountTextBox = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");
		iOSLogs.CapturedLogs(info, "Remove Cash Amount TextBox cash button found");
		return RemoveCashAmountTextBox;
	}

	public WebElement RemoveCashNextButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("NextButton")) {
			WebElement RemoveCashNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info, "Next button found");
			return RemoveCashNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}

	public WebElement RemoveCashAmountButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Remove $1.99")) {
			WebElement RemoveCashAmountButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Remove $1.99\"]");

			// only works if amount is $1.99
			iOSLogs.CapturedLogs(info, "Remove amount button found");
			return RemoveCashAmountButton;
		} else {
			iOSLogs.CapturedLogs(info, "Remove amount button not found");
			return null;
		}
	}

//Network overrides *********

	public WebElement NetworkOverridesButton() throws Exception {
		Thread.sleep(3000);
		if (findCardsOverviewPageElement("LeftLabel")) {
			WebElement NetworkOverridesButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"LeftLabel\"]");

			iOSLogs.CapturedLogs(info, "Network overrides button found");
			return NetworkOverridesButton;
		} else {
			iOSLogs.CapturedLogs(info, "Network overrides button not found");
			return null;
		}
	}

	public WebElement NetworkOverridePlusButton() throws Exception {
		Thread.sleep(2000);
		WebElement NetworkOverridePlusButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"]");
		iOSLogs.CapturedLogs(info, "NetworkOverride PlusButton found");
		return NetworkOverridePlusButton;
	}

	public WebElement EnableNetworkOverrideButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Enable 2 Overrides")) {
			WebElement EnableNetworkOverrideButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Enable 2 Overrides\"]");

			iOSLogs.CapturedLogs(info, "Enable 1 override button found");
			return EnableNetworkOverrideButton;
		} else {
			iOSLogs.CapturedLogs(info, "Enable 1 override button not found");
			return null;
		}
	}

	public WebElement DisableNetworkOverrideModalButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Disable")) {
			WebElement DisableNetworkOverrideModalButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Disable\"]");

			iOSLogs.CapturedLogs(info, "Disable button found");
			return DisableNetworkOverrideModalButton;
		} else {
			iOSLogs.CapturedLogs(info, "Disable button not found");
			return null;
		}
	}

//Card information*******
	public WebElement CardInformationButton() throws Exception {
		Thread.sleep(3000);
		if (findCardsOverviewPageElement("InformationLabel")) {
			WebElement CardInformationButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"InformationLabel\"]");

			iOSLogs.CapturedLogs(info, "Card information button found");
			return CardInformationButton;
		} else {
			iOSLogs.CapturedLogs(info, "Card information button not found");
			return null;
		}
	}

	public WebElement OverrideMileageButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Override mileage")) {
			WebElement OverrideMileageButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Override mileage\"]");

			iOSLogs.CapturedLogs(info, "Override mileage button found");
			return OverrideMileageButton;
		} else {
			iOSLogs.CapturedLogs(info, "Override Mileage button not found");
			return null;
		}
	}

	public WebElement HubometerRadioButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Hubometer")) {
			WebElement HubometerRadioButton = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]");
			iOSLogs.CapturedLogs(info, "Hubometer radio button found");
			return HubometerRadioButton;
		} else {
			iOSLogs.CapturedLogs(info, "Hubometer radio button not found");
			return null;
		}
	}

	public WebElement OverrideMileageNextButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Next")) {
			WebElement OverrideMileageNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]");

			iOSLogs.CapturedLogs(info, "Next button found");
			return OverrideMileageNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}

	public WebElement MileageTextBox() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("TextField")) {
			WebElement MileageTextBox = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");

			iOSLogs.CapturedLogs(info, "Mileage textbox found");
			return MileageTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Mileage textbox not found");
			return null;
		}
	}

	public WebElement MileageSaveButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("NextButton")) {
			WebElement MileageSaveButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info, "Save button found");
			return MileageSaveButton;
		} else {
			iOSLogs.CapturedLogs(info, "Save button not found");
			return null;
		}
	}

	public WebElement CardInfoBackButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Card overview")) {
			WebElement CardInfoBackButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Card overview\"]");
			iOSLogs.CapturedLogs(info, "Save button found");
			return CardInfoBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "Save button not found");
			return null;
		}
	}

//Change status*******
	public WebElement ChangeStatusButton() throws Exception {
		Thread.sleep(3000);
		if (findCardsOverviewPageElement("Change status")) {
			WebElement ChangeStatusButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Change status\"]");

			iOSLogs.CapturedLogs(info, "Change status button found");
			return ChangeStatusButton;
		} else {
			iOSLogs.CapturedLogs(info, "Change status button not found");
			return null;
		}
	}

	public WebElement ActiveStatus() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("InformationLabel")) {
			// WebElement ActiveStatus =
			// Capabilities.driver.findElementByXPath("**/XCUIElementTypeStaticText[`label
			// == \"Active\"`]");
//			WebElement ActiveStatus = Capabilities.driver
//					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"InformationLabel\"])[1]");

			WebElement ActiveStatus = Capabilities.driver.findElementByXPath(staticTextValue+"\"Active\"]");
			
			iOSLogs.CapturedLogs(info, "Active status button found");
			return ActiveStatus;
		} else {
			iOSLogs.CapturedLogs(info, "Active status button not found");
			return null;
		}
	}

	public WebElement HoldStatus() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("InformationLabel")) {
			// WebElement HoldStatus =
			// Capabilities.driver.findElementByXPath("**/XCUIElementTypeStaticText[`label
			// == \"Hold\"`]");

			WebElement HoldStatus = Capabilities.driver.findElementByXPath(staticTextValue+"\"Hold\"]");
			
			//WebElement HoldStatus = Capabilities.driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"InformationLabel\"])[2]");

			iOSLogs.CapturedLogs(info, "Hold status button found");
			return HoldStatus;
		} else {
			iOSLogs.CapturedLogs(info, "Hold status button not found");
			return null;
		}
	}

	public WebElement InactiveStatus() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("InformationLabel")) {
			// WebElement InactiveStatus =
			// Capabilities.driver.findElementByXPath("**/XCUIElementTypeStaticText[`label
			// == \"Inactive\"`]");
			
			WebElement InactiveStatus = Capabilities.driver.findElementByXPath(staticTextValue+"\"Inactive\"]");
			
//			WebElement InactiveStatus = Capabilities.driver
//					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"InformationLabel\"])[3]");

			iOSLogs.CapturedLogs(info, "Inactive status button found");
			return InactiveStatus;
		} else {
			iOSLogs.CapturedLogs(info, "Inactive status button not found");
			return null;
		}
	}

	public WebElement FollowsStatus() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("InformationLabel")) {
			// WebElement InactiveStatus =
			// Capabilities.driver.findElementByXPath("**/XCUIElementTypeStaticText[`label
			// == \"Inactive\"`]");
			WebElement FollowsStatus = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]");

			iOSLogs.CapturedLogs(info, "Inactive status button found");
			return FollowsStatus;
		} else {
			iOSLogs.CapturedLogs(info, "Inactive status button not found");
			return null;
		}
	}

	public WebElement StatusChangeSaveButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Save")) {
			WebElement StatusChangeSaveButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]");

			iOSLogs.CapturedLogs(info, "Save status button found");
			return StatusChangeSaveButton;
		} else {
			iOSLogs.CapturedLogs(info, "Change status button not found");
			return null;
		}
	}

//Activity

	public WebElement ActivityViewAllTop() throws Exception {
		Thread.sleep(3000);
		if (findCardsOverviewPageElement("View all")) {
			WebElement ActivityViewAllTop = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"View all\"])[1]");
			iOSLogs.CapturedLogs(info, "Activity View All Top button found");
			return ActivityViewAllTop;
		} else {
			return null;
		}
	}

	public WebElement TransactionActivityCell() throws Exception {
		Thread.sleep(2000);
		WebElement TransactionActivityCell = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		iOSLogs.CapturedLogs(info, "Activity row found");
		return TransactionActivityCell;
	}

	public WebElement TransactionActivityCellBackButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("Back")) {
			WebElement TransactionActivityCellBackButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Back\"]");
			iOSLogs.CapturedLogs(info, "Transaction Activity Cell BackButton View All Top button found");
			return TransactionActivityCellBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "Transaction Activity Cell BackButton View All Top button not found");
			return null;
		}
	}

	public WebElement TransactionActivityViewAllBackButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("Card overview")) {
			WebElement TransactionActivityViewAllBackButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Card overview\"]");
			
			iOSLogs.CapturedLogs(info, "Transaction Activity Cell BackButton View All back button found");
			return TransactionActivityViewAllBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "Transaction Activity Cell BackButton View All back button not found");
			return null;
		}
	}
	
	public WebElement TransactionActivityViewAllTopBackButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("Card overview")) {
			WebElement TransactionActivityViewAllTopBackButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Card overview\"]");
			
			iOSLogs.CapturedLogs(info, "NEW View All Transaction Activity Top BackButton button found");
			return TransactionActivityViewAllTopBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "NEW View All Transaction Activity TopBackButton button not found");
			return null;
		}
	}

	public WebElement TransactionActivityViewAllBottomBackButton() throws Exception {
		Thread.sleep(2000);
		WebElement TransactionActivityViewAllBottomBackButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Card overview\"]");
		iOSLogs.CapturedLogs(info, "Transaction Activity ViewAll Bottom Back Button found");
		return TransactionActivityViewAllBottomBackButton;
	}

	public WebElement ActivityViewAllBottom() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("View all")) {
			WebElement ActivityViewAllBottom = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeButton[@name=\"View all\"])[2]");
			iOSLogs.CapturedLogs(info, "View all bottom button found");
			return ActivityViewAllBottom;
		} else {
			iOSLogs.CapturedLogs(info,  "View all bottom button not found");
			return null;
		}
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for Transactions Tab section

	public WebElement rejectsTab() throws Exception {
		Thread.sleep(3000);
		WebElement RejectsTab = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Rejects\"]");
		iOSLogs.CapturedLogs(info, "Rejects Tab found");
		return RejectsTab;
	}

	public WebElement WaitForTransaction() throws Exception {
		Thread.sleep(3000);
		WebElement waitForTransaction = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeCell[@name=\"BottomSection\"]/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		iOSLogs.CapturedLogs(info, "Wait For Transaction found");
		return waitForTransaction;
	}

	public WebElement ViewAllTop() throws Exception {
		Thread.sleep(3000);
		if (findTransactionsPageElement("View all")) {
			WebElement viewAllTop = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"View all\"])[2]");
			iOSLogs.CapturedLogs(info, "ViewAllTop found");
			return viewAllTop;
		} else {
			iOSLogs.CapturedLogs(info, "ViewAllTop not found");
			return null;
		}
	}

	public WebElement WaitForRejectHistoryMustBeExactAmount() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Must Be Exact Amount")) {
			WebElement waitForRejectHistoryMustBeExactAmount = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Must Be Exact Amount\"])[1]");
			iOSLogs.CapturedLogs(info, "Must Be Exact Amount found");
			return waitForRejectHistoryMustBeExactAmount;
		} else {
			iOSLogs.CapturedLogs(info, "Must Be Exact Amount not found");
			return null;
		}
	}

	public WebElement WaitForRejectHistoryTransaction() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Check status on card, contract or carrier")) {
			WebElement WaitForRejectHistoryTransaction = Capabilities.driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Invalid location for customer\"])[1]");

			return WaitForRejectHistoryTransaction;
		} else {
			return null;
		}
	}

	public WebElement RejectDetailsBack() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Reject history")) {
			WebElement rejectDetailsBack = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Reject history\"]");
			iOSLogs.CapturedLogs(info, "Reject Details Back found");
			return rejectDetailsBack;
		} else {
			iOSLogs.CapturedLogs(info, "Reject Details Back not found");
			return null;
		}
	}

	public WebElement CardDetailButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Card details")) {
			WebElement cardDetailButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Card details\"]");
			iOSLogs.CapturedLogs(info, "Card details not found");
			return cardDetailButton;
		} else {
			iOSLogs.CapturedLogs(info, "Card details not found");
			return null;
		}
	}

	public WebElement CardDetailsPage() throws Exception {
		Thread.sleep(3000);
		WebElement cardDetailsPage = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		iOSLogs.CapturedLogs(info, "Card details page found");
		return cardDetailsPage;
	}

	public WebElement CardDetailsPageBackButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Card overview")) {
			WebElement cardDetailsPageBackButton = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeNavigationBar[@name=\"Card overview\"]/XCUIElementTypeButton");
			iOSLogs.CapturedLogs(info, "Card details page Back button found");
			return cardDetailsPageBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "Card details page Back button not found");
			return null;
		}
	}

	public WebElement RejectDetailsBackButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Reject history")) {
			WebElement rejectDetailsBackButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Reject history\"]");
			iOSLogs.CapturedLogs(info, "Reject Details Back Button found");
			return rejectDetailsBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "Reject Details Back Button not found");
			return null;
		}
	}

	public WebElement RejectHistoryBackButton() throws Exception {
		Thread.sleep(3000);
			if (findExtrasPageSource("Transactions")) {
			WebElement rejectHistoryBackButton = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeButton[@name=\"Transactions\"])[1]");
			iOSLogs.CapturedLogs(info, "Reject History Back Button found");
			return rejectHistoryBackButton;
		} else {
			iOSLogs.CapturedLogs(info, "Reject History Back Button not found");
			return null;
		}
	}

	public WebElement ViewAllBottomButton() throws Exception {
		Thread.sleep(3000);
		if (findTransactionsPageElement("ViewAllBottomButton")) {
			WebElement viewAllBottomButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"ViewAllBottomButton\"]");
			iOSLogs.CapturedLogs(info, "View All Bottom Button found");
			return viewAllBottomButton;
		} else {
			iOSLogs.CapturedLogs(info, "View All Bottom Button not found");
			return null;
		}
	}

	public WebElement RejectHistoryBackButtonViewallBottom() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Transactions")) {
			WebElement rejectHistoryBackButtonViewallBottom = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeButton[@name=\"Transactions\"])[1]");
			iOSLogs.CapturedLogs(info, "Reject History Back ButtonV iewall Bottom button found");
			return rejectHistoryBackButtonViewallBottom;
		} else {
			iOSLogs.CapturedLogs(info, "Reject History Back ButtonV iewall Bottom button not found");
			return null;
		}
	}

	public WebElement CompanyCardImage() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Company")) {
			WebElement CompanyCardImage = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
			iOSLogs.CapturedLogs(info, "Company Card Image found");
			return CompanyCardImage;
		} else {
			iOSLogs.CapturedLogs(info, "Company Card Image not found");
			return null;
		}
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for Billing Tab section
	public WebElement BillingTab() throws Exception {
		if (findExtrasPageSource("Billing")) {
		//WebElement billingTab = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Billing\"]");
		WebElement billingTab = Capabilities.driver.findElementByXPath(elementButton+"\"Billing\"]");
		iOSLogs.CapturedLogs(info,"Billing Tab found");
		return billingTab;
	}else {
		iOSLogs.CapturedLogs(info,"Billing Tab not found");
		return null;
	}
}
	public WebElement SelectAR() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("ShadowedTableViewCell")) {
//WebElement selectAR = Capabilities.driver.findElementByXPath("(//XCUIElementTypeCell[@name\"ShadowedTableViewCell\"])[5]");
			WebElement selectAR = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeCell[@name=\"ShadowedTableViewCell\"])[5]");
			iOSLogs.CapturedLogs(info,"Expected Ar Number found");
			return selectAR;
		} else {
			iOSLogs.CapturedLogs(info,"Expected Ar Number not found. Either Check the name or it is expected to be missing");
			return null;
		}
	}

	public WebElement PayNowButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Pay now")) {
			WebElement payNowButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Pay now\"]");
			iOSLogs.CapturedLogs(info, "Pay now button selected");
			return payNowButton;
		} else {
			iOSLogs.CapturedLogs(info, "Pay Now button not found");
			return null;
		}
	}

//public WebElement SelectInvoice() throws Exception {
//	Thread.sleep(3000);
//	WebElement selectInvoice = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
//	logs.CapturedLogs("test info", "invoice selected");
//	return selectInvoice;
//	}

	public WebElement SelectNextButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Next")) {
			WebElement selectInvoiceNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]");
			iOSLogs.CapturedLogs(info,"Select next button found");
			return selectInvoiceNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}

	public WebElement SelectBankAccount() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Select bank account")) {
			WebElement selectBankAccount = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeCell[@name=\"ShadowedTableViewCell\"])[1]");

			iOSLogs.CapturedLogs(info,"Bank account found");
			return selectBankAccount;
		} else {
			iOSLogs.CapturedLogs(info, "Bank account not found");
			return null;
		}
	}

	public WebElement EditPaymentAmountButton() throws Exception {
		Thread.sleep(3000);
		WebElement editPaymentAmountButton = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");

		iOSLogs.CapturedLogs("test info", "edit button found");
		return editPaymentAmountButton;
	}

	public WebElement XClearText() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Clear text")) {
			WebElement xClearText = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Clear text\"]");

			iOSLogs.CapturedLogs(info, "Bank account found");
			return xClearText;
		} else {
			iOSLogs.CapturedLogs(info, "Bank account not found");
			return null;
		}
	}

	public WebElement PaymentAmountTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement paymentAmountTextBox = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");

		iOSLogs.CapturedLogs(info, "payment amount textbox found");
		return paymentAmountTextBox;
	}

	public WebElement SaveButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("NextButton")) {
			WebElement saveButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info, "Save button found");
			return saveButton;
		} else {
			iOSLogs.CapturedLogs(info, "Save not found");
			return null;
		}
	}

	public WebElement SchedulePaymentButton() throws Exception {
		Thread.sleep(3000);
		if (findExtrasPageSource("Schedule payment")) {
			WebElement schedulePaymentButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Schedule payment\"]");
			iOSLogs.CapturedLogs(info,"schedule Payment Button found");
			return schedulePaymentButton;
		} else {
			iOSLogs.CapturedLogs(info, "Schedule Payment Button not found");
			return null;
		}
	}

	public WebElement DoneButton() throws Exception {
		Thread.sleep(5000);
		if (findExtrasPageSource("Done")) {
			WebElement doneButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Done\"]");
			iOSLogs.CapturedLogs(info,"Done Button found");
			return doneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Done Button not found");
			return null;
		}
	}

//~~~~~~~~~~~~~~~~ACCOUNT TAB~~~~~~~~~~~~~~~~~~~~~//
	public WebElement accountsTab() throws Exception {
		Thread.sleep(3000);
		WebElement accountsTab = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Account\"]");
		iOSLogs.CapturedLogs(info,"Account Tab was found");
		return accountsTab;
	}

//************MANAGE YOUR PROFILE************//
	public WebElement ManageYourProfile() throws Exception {
		if (findAccountPageElement("chevron")) {
			Thread.sleep(3000);
			WebElement manageYourProfile = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
			iOSLogs.CapturedLogs(info, "Manage your profile found");
			return manageYourProfile;
		} else {
			iOSLogs.CapturedLogs(info,"Manage your profile not found");
			return null;
		}
	}

	public WebElement ClearTextButton() throws Exception {
		Thread.sleep(3000);
		WebElement ClearTextButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Clear text\"]");
		iOSLogs.CapturedLogs(info, "Clear button Found");
		return ClearTextButton;
	}

	public WebElement EditNameButton() throws Exception {
		Thread.sleep(3000);
		WebElement EditNameButton = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]");

		iOSLogs.CapturedLogs(info, "Edit name button found");
		return EditNameButton;
	}

	public WebElement FirstNameTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement FirstNameTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField");

		iOSLogs.CapturedLogs(info, "First name Text box found");
		return FirstNameTextBox;
	}

	public WebElement LastNameTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement LastNameTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField");

		iOSLogs.CapturedLogs("Test info", "last name text box found");
		return LastNameTextBox;
	}

	public WebElement SaveEditNameButton() throws Exception {
		if (findAccountPageElement("Save")) {
			Thread.sleep(3000);
			WebElement SaveEditNameButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]");

			iOSLogs.CapturedLogs(info,"Save button found");
			return SaveEditNameButton;
		} else {
			iOSLogs.CapturedLogs(info, "Save button not found");
			return null;
		}
	}

	public WebElement EditEmailButton() throws Exception {
		Thread.sleep(3000);
		WebElement EditEmailButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Email\"]");

		iOSLogs.CapturedLogs(info, "Edit email button found");
		return EditEmailButton;
	}

	public WebElement EmailTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement EmailTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextField");

		iOSLogs.CapturedLogs(info,"email text box found");
		return EmailTextBox;
	}

	public WebElement SaveEditEmailButton() throws Exception {
		if (findAccountPageElement("Save")) {
			Thread.sleep(3000);
			WebElement SaveEditEmailButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]");

			iOSLogs.CapturedLogs(info, "Save button found");
			return SaveEditEmailButton;
		} else {
			iOSLogs.CapturedLogs(info, "Save button not found");
			return null;
		}
	}

	public WebElement EditPhoneButton() throws Exception {
		Thread.sleep(3000);
		WebElement EditPhoneButton = Capabilities.driver.findElementByAccessibilityId("Phone");
//				.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Phone\"])[3]");
					
		iOSLogs.CapturedLogs(info, "Edit phone button found");
		return EditPhoneButton;
	}

	public WebElement EditPhoneTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement EditPhoneTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextField");

		iOSLogs.CapturedLogs(info, "Edit phone textbox found");
		return EditPhoneTextBox;
	}

	public WebElement SaveEditPhoneButton() throws Exception {
		if (findAccountPageElement("Save")) {
			Thread.sleep(3000);
			WebElement SaveEditPhoneButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]");
			
			iOSLogs.CapturedLogs(info, "Save button found");
			return SaveEditPhoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Save button not found");
			return null;
		}
	}

	public WebElement ManageYourProfileBackButton() throws Exception {
		Thread.sleep(3000);
		WebElement ManageYourProfileBackButton = Capabilities.driver
				.findElementByXPath("(//XCUIElementTypeButton[@name=\"Account\"])[1]");

		iOSLogs.CapturedLogs(info, "Back button found");
		return ManageYourProfileBackButton;
	}

//*******************************************************************************//
//Transfer to your bank Add new bank account web elements

	public WebElement AddNewBankAccountButton() throws Exception {
		if (findExtrasPageSource("Add new bank account")) {
			Thread.sleep(3000);
			WebElement AddNewBankAccountButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Add new bank account\"]");

			iOSLogs.CapturedLogs(info, "Add new bank account button found");
			return AddNewBankAccountButton;
		} else {
			iOSLogs.CapturedLogs(info, "Add new bank account button not found");
			return null;
		}
	}

	public WebElement BankAccountFour() throws Exception {
		Thread.sleep(3000);
		WebElement bankAccountFour = Capabilities.driver
				.findElementByXPath("(//XCUIElementTypeCell[@name=\"ShadowedTableViewCell\"])[4]");
		iOSLogs.CapturedLogs(info, "Bank Account four found");
		return bankAccountFour;

	}

	public WebElement RoutingNumberTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement RoutingNumberTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField");
		iOSLogs.CapturedLogs(info, "Routing Number TextBox found");
		return RoutingNumberTextBox;

	}

	public WebElement AccountNumberTextBox() throws Exception {
		Thread.sleep(3000);
		WebElement AccountNumberTextBox = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField");
		iOSLogs.CapturedLogs(info,"Account Number TextBox found");
		return AccountNumberTextBox;
	}

	public WebElement WhereDoIFindTheseButton() throws Exception {
		if (findExtrasPageSource("WhereDoIFindTheseButton")) {
			Thread.sleep(3000);
			WebElement WhereDoIFindTheseButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"WhereDoIFindTheseButton\"]");

			iOSLogs.CapturedLogs(info, "Where Do I Find These Button found");
			return WhereDoIFindTheseButton;
		} else {
			iOSLogs.CapturedLogs(info, "Where Do I Find These Button not found");
			return null;
		}
	}

	public WebElement WhereDoIFindTheseDoneButton() throws Exception {
		if (findExtrasPageSource("Done")) {
			Thread.sleep(3000);
			WebElement WhereDoIFindTheseDoneButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Done\"]");
			iOSLogs.CapturedLogs(info, "Where Do I Find These done Button found");
			return WhereDoIFindTheseDoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Where Do I Find These done Button not found");
			return null;
		}
	}

	public WebElement AddBankAccountNextButton() throws Exception {
		if (findExtrasPageSource("NextButton")) {
			Thread.sleep(3000);
			WebElement AddBankAccountNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info,  "Add Bank Account Next Button found");
			return AddBankAccountNextButton;
		} else {
			iOSLogs.CapturedLogs(info,  "Add Bank Account Next Button not found");
			return null;
		}
	}

	public WebElement BankNameTextBox() throws Exception {
		if (findExtrasPageSource("BANK NAME")) {
			Thread.sleep(3000);
			WebElement BankNameTextBox = Capabilities.driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField");

			iOSLogs.CapturedLogs(info, "Bank Name TextBox found");
			return BankNameTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Bank Name TextBox not found");
			return null;
		}
	}

	public WebElement AccountOwnerTextBox() throws Exception {
		if (findExtrasPageSource("ACCOUNT OWNER")) {
			Thread.sleep(3000);
			WebElement AccountOwnerTextBox = Capabilities.driver.findElementByXPath(
					"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField");
			iOSLogs.CapturedLogs(info, "Account Owner TextBox found");
			return AccountOwnerTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Account Owner TextBox not found");
			return null;
		}
	}

	public WebElement CheckingButton() throws Exception {
		if (findExtrasPageSource("Checking")) {
			Thread.sleep(3000);
			WebElement CheckingButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Checking\"]");
			iOSLogs.CapturedLogs(info, "Checking Button found");
			return CheckingButton;
		} else {
			iOSLogs.CapturedLogs(info, "Checking Button not found");
			return null;
		}
	}

	public WebElement SavingsButton() throws Exception {
		if (findExtrasPageSource("Savings")) {
			Thread.sleep(3000);
			WebElement SavingsButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Savings\"]");

			iOSLogs.CapturedLogs(info, "Savings Button found");
			return SavingsButton;
		} else {
			iOSLogs.CapturedLogs(info, "Savings Button not found");
			return null;
		}
	}

	public WebElement AddBankDetailsNextButton() throws Exception {
		if (findExtrasPageSource("NextButton")) {
			Thread.sleep(3000);
			WebElement AddBankDetailsNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info,"Add Bank Details Next Button found");
			return AddBankDetailsNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Add Bank Details Next Button not found");
			return null;
		}
	}

	public WebElement NewBankAccountOKButton() throws Exception {
		if (findExtrasPageSource("OK")) {
			Thread.sleep(3000);
			WebElement NewBankAccountOKButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"OK\"]");
			iOSLogs.CapturedLogs(info, "OK Button found");
			return NewBankAccountOKButton;
		} else {
			iOSLogs.CapturedLogs(info, "OK Button not found");
			return null;
		}
	}

	public WebElement TransferToYourBankCloseButton() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement TransferToYourBankCloseButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Cancel\"]");
			iOSLogs.CapturedLogs(info, "OK Cancel to exit trasfer to bank found");
			return TransferToYourBankCloseButton;
		} else {
			iOSLogs.CapturedLogs(info, "OK Cancel to exit trasfer to bank not found");
			return null;
		}
	}

	public WebElement TransferToYourYesDiscardModalButton() throws Exception {
		if (findExtrasPageSource("Yes, discard")) {
			Thread.sleep(3000);
			WebElement TransferToYourYesDiscardModalButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Yes, discard\"]");

			iOSLogs.CapturedLogs(info, "YES, Discard Button found");
			return TransferToYourYesDiscardModalButton;
		} else {
			iOSLogs.CapturedLogs(info, "YES, Discard Button not found");
			return null;
		}
	}

//~~~~~~~~~~~~~~~~ACCOUNT TAB Continued~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for Account Tab section
	public WebElement BioSwitch() throws Exception {
		if (findAccountPageElement("BiometricsSwitch")) {
			WebElement bioSwitch = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeSwitch[@name=\"BiometricsSwitch\"]");
			// this.clearPageElement(accountPageSource);
			iOSLogs.CapturedLogs(info, "BioSwitch found");
			return bioSwitch;
		} else {
			iOSLogs.CapturedLogs(info, "BioSwitch not found Might be on this account check screeshot");
			return null;
		}
	}

	public WebElement BioSwitchOk() throws Exception {
		if (findExtrasPageSource("OK")) {
			WebElement bioSwitchOk = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"OK\"]");
			iOSLogs.CapturedLogs(info, "BioSwitch ok found");
			return bioSwitchOk;
		} else {
			iOSLogs.CapturedLogs(info, "BioSwitch OK not found");
			return null;
		}
	}

	public WebElement CallCustomerService() throws Exception {
		if (findAccountPageElement("Call customer service")) {
			WebElement callCustomerService = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Call customer service\"]");
			iOSLogs.CapturedLogs(info, "Call Customer Service found");
			return callCustomerService;
		} else {
			iOSLogs.CapturedLogs(info, "Call Customer Service not found");
			return null;
		}
	}

	public WebElement CancelCustomerServiceButton() throws Exception {
		// takes to long for one button and works without it.
		// if (findCardsPageElement("Cancel")){
		WebElement cancelCustomerServiceButton = Capabilities.driver
				.findElementByXPath("(//XCUIElementTypeButton[@name=\"Cancel\"])[2]");
		iOSLogs.CapturedLogs(info, "Cancel Customer Service found");
		return cancelCustomerServiceButton;
		// } else {
		// return null;
		// }

	}

	public WebElement WelcomeTutorial() throws Exception {
		if (findAccountPageElement("WelcomeTutorialLabel")) {
			WebElement welcomeTutorial = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"WelcomeTutorialLabel\"]");
			iOSLogs.CapturedLogs(info, "Welcome Tutorial  found");
			return welcomeTutorial;
		} else {
			iOSLogs.CapturedLogs(info, "Welcome Tutorial not found");
			return null;
		}
	}

	public WebElement WelcomeTutorialDoneButton() throws Exception {
		if (findExtrasPageSource("Done")) {
			WebElement welcomeTutorialDoneButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]");
			iOSLogs.CapturedLogs(info, "Done button found");
			return welcomeTutorialDoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Done button not found");
			return null;
		}
	}

	public WebElement TermsOfUse() throws Exception {
		if (findAccountPageElement("TermsAndPrivacyPolicyLabel")) {
			WebElement termsOfUse = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"TermsAndPrivacyPolicyLabel\"])[1]");
			iOSLogs.CapturedLogs(info, "Terms Of Use found");
			return termsOfUse;
		} else {
			iOSLogs.CapturedLogs(info, "Terms Of Use not found");
			return null;
		}
	}

	public WebElement TermsOfUseDoneButton() throws Exception {
		if (findExtrasPageSource("Account")) {
			//WebElement termsOfUseDoneButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]");
			WebElement termsOfUseDoneButton = Capabilities.driver.findElementByXPath(elementButton+"\"Account\"]");
			
			iOSLogs.CapturedLogs(info, "Done found");
			return termsOfUseDoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Done not found");
			return null;
		}
	}

	public WebElement PrivacyPolicy() throws Exception {
		if (findExtrasPageSource("TermsAndPrivacyPolicyLabel")) {
			//WebElement privacyPolicy = Capabilities.driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"TermsAndPrivacyPolicyLabel\"])[2]");
			WebElement privacyPolicy = Capabilities.driver.findElementByXPath(staticTextLabel+"\"Privacy Policy\"]");
			iOSLogs.CapturedLogs(info, "Privacy Policy found");
			return privacyPolicy;
		} else {
			iOSLogs.CapturedLogs(info, "Privacy Policy not found");
			return null;
		}
	}

	public WebElement PrivacyPolicyDoneButton() throws Exception {
		if (findExtrasPageSource("Account")) {
			//WebElement privacyPolicyDoneButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]");
			WebElement privacyPolicyDoneButton = Capabilities.driver.findElementByXPath(elementButton+"\"Account\"]");
			
			iOSLogs.CapturedLogs(info, "Done found");
			return privacyPolicyDoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Done not found");
			return null;
		}
	}

//Transfer to your bank //
	public WebElement TransferToYourBank() throws Exception {
		if (findExtrasPageSource("Transfer to your bank")) {
			WebElement transferToYourBank = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Transfer to your bank\"]");
			iOSLogs.CapturedLogs(info,
					"Transfer to bank account found");
			return transferToYourBank;
		} else {

			iOSLogs.CapturedLogs(info,
					"Transfer to bank account not found. Option is only available on Child Carrier accounts");
			return null;
		}
	}

	public WebElement TransferFromSelectContract() throws Exception {
		// if (findExtrasPageSource("ShadowedTableViewCell")) {
		Thread.sleep(3000);
		WebElement transferFromSelectContract = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeCell[@name=\"ShadowedTableViewCell\"]");

		iOSLogs.CapturedLogs(info, "Transfer from select contract found");
		return transferFromSelectContract;
//	} else {
//	 logs.CapturedLogs("Test Info", "Transfer from select contract not found");
//	 return null;
//}
	}

	public WebElement TransferNextButton() throws Exception {
		if (findExtrasPageSource("Next")) {
			Thread.sleep(3000);
			WebElement transferNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Next\"]");
			iOSLogs.CapturedLogs(info, "NEXT button found");
			return transferNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "NEXT button not found");
			return null;
		}
	}

	public WebElement EnterAmountNextButton() throws Exception {
		if (findExtrasPageSource("NextButton")) {
			Thread.sleep(3000);
			WebElement enterAmountNextButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"NextButton\"]");

			iOSLogs.CapturedLogs(info, "NEXT button found");
			return enterAmountNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "NEXT button not found");
			return null;
		}
	}

	public WebElement TransferSelectBankAccount() throws Exception {
		if (findExtrasPageSource("ShadowedTableViewCell")) {
			Thread.sleep(3000);
			WebElement transferSelectBankAccount = Capabilities.driver
					.findElementByXPath("(//XCUIElementTypeCell[@name=\"ShadowedTableViewCell\"])[1]");
			iOSLogs.CapturedLogs(info,"Select bank account found");
			return transferSelectBankAccount;
		} else {
			iOSLogs.CapturedLogs(info, "Select bank account not found");
			return null;
		}
	}

	public WebElement TransferEnterAmountTextBox() throws Exception {
		if (findExtrasPageSource("TextField")) {
			Thread.sleep(3000);
			WebElement transferEnterAmountTextBox = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeTextField[@name=\"TextField\"]");
			iOSLogs.CapturedLogs(info, "Enter Amount Text box found");
			return transferEnterAmountTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Enter amount text box not found");
			return null;
		}
	}

	public WebElement TransferSubmitButton() throws Exception {
		if (findExtrasPageSource("SubmitButton")) {
			Thread.sleep(3000);
			WebElement transferSubmitButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"SubmitButton\"]");
			iOSLogs.CapturedLogs(info, "Submit button found");
			return transferSubmitButton;
		} else {
			iOSLogs.CapturedLogs(info, "Submit button not found");
			return null;
		}
	}

	public WebElement TransferDoneButton() throws Exception {
		// if (findExtrasPageSource("DoneButton")) {
		Thread.sleep(3000);
		WebElement transferDoneButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"DoneButton\"]");
		iOSLogs.CapturedLogs(info, "Done button found");
		return transferDoneButton;
//	} else {
//	 logs.CapturedLogs("Test Info", "Done button not found");
//	 return null;
//}
	}

	public WebElement PendingTransfer() throws Exception {
		Thread.sleep(3000);
		WebElement pendingTransfer = Capabilities.driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"Test EFS CarrierControl\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]");
		iOSLogs.CapturedLogs(info, "Pending transfer found");
		return pendingTransfer;
	}

	public WebElement CancelTransferButton() throws Exception {
		if (findExtrasPageSource("Cancel transfer")) {
			Thread.sleep(3000);
			WebElement cancelTransferButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Cancel transfer\"]");

			iOSLogs.CapturedLogs(info, "cancel transfer button found");
			return cancelTransferButton;
		} else {
			iOSLogs.CapturedLogs(info,"cancel transfer button not found");
			return null;
		}
	}

	public WebElement BackModalButton() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			Thread.sleep(3000);
			WebElement backModalButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Cancel\"]");

			iOSLogs.CapturedLogs(info, "back modal button found");
			return backModalButton;
		} else {
			iOSLogs.CapturedLogs(info, "back modal button not found");
			return null;
		}
	}

	public WebElement CancelModalButton() throws Exception {
		if (findExtrasPageSource("Yes, cancel")) {
			Thread.sleep(3000);
			WebElement cancelModalButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Yes, cancel\"]");

			iOSLogs.CapturedLogs(info, "cancel modal button found");
			return cancelModalButton;
		} else {
			iOSLogs.CapturedLogs(info, "cancel modal button not found");
			return null;
		}
	}
	
	
	
	public WebElement CancelModalButton2() throws Exception {
		if (findExtrasPageSource("Yes, discard")) {
			Thread.sleep(3000);
			WebElement CancelModalButton2 = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Yes, discard\"]");

			iOSLogs.CapturedLogs(info, "cancel modal button found");
			return CancelModalButton2;
		} else {
			iOSLogs.CapturedLogs(info, "cancel modal button not found");
			return null;
		}
	}
	

	public WebElement CancelPendingPaymentXButton() throws Exception {
		WebElement cancelPendingPaymentXButton = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Cancel\"]");
		iOSLogs.CapturedLogs(info, "Cancel Pending Payment XButton found");
		return cancelPendingPaymentXButton;
	}

	public WebElement DiscardChangesModal() throws Exception {
		WebElement discardChangesModal = Capabilities.driver
				.findElementByXPath("//XCUIElementTypeButton[@name=\"Yes, discard\"]");
		iOSLogs.CapturedLogs(info, "Discard Changes Modal found");
		return discardChangesModal;
	}

	public WebElement TransferToYourBankCancelButton() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement transferToYourBankCancelButton = Capabilities.driver
					.findElementByXPath("//XCUIElementTypeButton[@name=\"Cancel\"]");
			iOSLogs.CapturedLogs(info, "Transfer To Your Bank Cancel button found");
			return transferToYourBankCancelButton;
		} else {
			iOSLogs.CapturedLogs(info, "Transfer To Your Bank Cancel button not found");
			return null;
		}
	}

}
