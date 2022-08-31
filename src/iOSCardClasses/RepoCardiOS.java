package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;


public class RepoCardiOS {
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	public String loginPageSource = "";
	public String welcomePageSource = "";
	public String profilePageSource = "";
	public String extrasPageSource = "";
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	
	String elementButton = "//XCUIElementTypeButton[@name=";
	String elementButtonLabel = "//XCUIElementTypeButton[@label=";
	String elementButtonLike = "//*[@name=";
	String typeImage = "//XCUIElementTypeImage[@name=";
	String staticText = "//XCUIElementTypeStaticText[@name=";
	String staticTexLabel = "//XCUIElementTypeStaticText[@label=";
	String textField = "//XCUIElementTypeTextField[@name=";
	String textFieldValue = "//XCUIElementTypeTextField[@value=";
	String secureText = "//XCUIElementTypeSecureTextField[@value=";
	String typeApp = "//XCUIElementTypeApplication[@name=";
	String SwitchValue = "//XCUIElementTypeSwitch[@value=";
	String SwitchName = "//XCUIElementTypeSwitch[@name=";
	String searchField = "//XCUIElementTypeSearchField[@name=";
	String findSomethingLike ="//*[contains(text(),'"; 

	
	//test
	//finds the elements on the page asked for
	public Boolean pageElement (String elementLabel, String pageSource) {
	
		
		if (pageSource == "" || pageSource == null) {
		return false;	
		}
		
		Boolean foundPageSource = false; 

		switch (pageSource) {
		case "loginpage":
			this.loginPageSource = lookupPageSource(this.loginPageSource);
			foundPageSource = this.loginPageSource.contains(elementLabel);
			return foundPageSource;
			
		case "welcomepage":
			this.welcomePageSource = lookupPageSource(this.welcomePageSource);
			foundPageSource = this.welcomePageSource.contains(elementLabel);
			return foundPageSource;
			
		case "profile":
			this.welcomePageSource = lookupPageSource(this.profilePageSource);
			foundPageSource = this.profilePageSource.contains(elementLabel);
			return foundPageSource;

		default:
			//extras always gets over written as a they are usually done or close etc 
			this.extrasPageSource = Capabilities.driver.getPageSource();
			foundPageSource = this.extrasPageSource.contains(elementLabel);
			return foundPageSource;
		}
	}

	private String lookupPageSource (String pageSource ) {
		if (pageSource == "") {
			pageSource = Capabilities.driver.getPageSource();
		}
		
		return pageSource;
		
	}


	//create one of these for every page in the automation
	public Boolean findLoginPageElement(String elementLabel) {
	return pageElement(elementLabel, "loginpage");	
	} 

	
	//create one of these for every page in the automation
		public Boolean findWelcomePageElement(String elementLabel) {
		return pageElement(elementLabel, "welcomepage");	
		} 
	
		//create one of these for every page in the automation
				public Boolean findProfilePageElement(String elementLabel) {
				return pageElement(elementLabel, "profilpage");	
				} 

		
	//create one of these for every page in the automation
	public Boolean findExtrasPageSource(String elementLabel) {
	return pageElement(elementLabel, "default");	
	} 

	
	public void clearPageElement(String pageSource) {
	pageSource = "";
	}

	


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for Welcome Page
	
//	public WebElement welcomeScreenStartButton() throws Exception {
//		//
//		if (findWelcomePageElement("Start")) {
//		WebElement welcomeScreenStartButton = Capabilities.driver.findElementByXPath(elementButton+"\"Start\"]");
//		return welcomeScreenStartButton;
//		} else {
//			return null;
//		}
//	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//Web Elements for Login Page	
	
	public WebElement CardNumberTextBox() throws Exception {
	
		if (findExtrasPageSource("Card Number Text Field")) {
		WebElement CardNumberTextBox = Capabilities.driver.findElementByXPath(textField+"\"Card Number Text Field\"]");
		iOSLogs.CapturedLogs(info, "Card number text box found");
		return CardNumberTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Card number text box not found");
			return null;
		}
	}
	
	
	public WebElement CardEditButton() throws Exception {
		
		if (findExtrasPageSource("Edit")) {
		WebElement CardEditButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Edit\"]");
		iOSLogs.CapturedLogs(info, "Card edit button button found");
		return CardEditButton;
		} else {
			iOSLogs.CapturedLogs(info, "Card edit button not found");
			return null;
		}
	}
	
public WebElement SelectCardFromEdit() throws Exception {
	
		if (findExtrasPageSource("Cached Card Button")) {
		WebElement SelectCardFromEdit = Capabilities.driver.findElementByXPath(elementButton+"\"Cached Card Button\"]");
		iOSLogs.CapturedLogs(info, "Card to remove found");
		return SelectCardFromEdit;
		} else {
			iOSLogs.CapturedLogs(info, "Card to remove not found");
			return null;
		}
	}



public WebElement RemoveSelectedCardFromEdit() throws Exception {
	
	if (findExtrasPageSource("Remove Card Button")) {
	WebElement RemoveSelectedCardFromEdit = Capabilities.driver.findElementByXPath(elementButton+"\"Remove Card Button\"]");
	iOSLogs.CapturedLogs(info, "Card to remove found");
	return RemoveSelectedCardFromEdit;
	} else {
		iOSLogs.CapturedLogs(info, "Card to remove not found");
		return null;
	}
}


	public WebElement PinPassTextBox() throws Exception {
		//
		if (findLoginPageElement("PIN or passcode")) {
			WebElement PinPassTextBox = Capabilities.driver.findElementByXPath("//XCUIElementTypeSecureTextField[@name=\"PIN Passcode Text Field\"]");
			iOSLogs.CapturedLogs(info, "PIN Passcode text box found");
			return PinPassTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "PIN Passcode text box not found");
			return null;
		}
	}
	
	
	public WebElement CardLoginButton() throws Exception {
	
		if (findLoginPageElement("Login Button")) {
			WebElement CardLoginButton = Capabilities.driver.findElementByXPath(elementButton+"\"Login Button\"]");
			iOSLogs.CapturedLogs(info, "Log in button found");
			return CardLoginButton;
		} else {
			iOSLogs.CapturedLogs(info, "Login button not found");
			return null;
		}
	}
	
	public WebElement BiometricDontAllowButtonFaceID() throws Exception {
		if (findExtrasPageSource("Don’t Allow")) {
			WebElement BiometricDenyButton = Capabilities.driver.findElementByXPath(elementButton+"\"Don’t Allow\"]");
			iOSLogs.CapturedLogs(info, "Biometrics Don't allow button found");
			return BiometricDenyButton;
		} else {
			iOSLogs.CapturedLogs(info, "Biometrics Don't allow button not found");
			return null;
		}
	}
	
	public WebElement BiometricCancelButtonTouchID() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement BiometricDenyButton = Capabilities.driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Cancel\"])[2]");
			iOSLogs.CapturedLogs(info, "Biometrics Cancel button found");
			return BiometricDenyButton;
		} else {
			iOSLogs.CapturedLogs(info, "Biometrics Cancel button not found");
			return null;
		}
	}
	
	public WebElement DoneKeyboardButton() throws Exception {
		//
		if (findExtrasPageSource("Done")) {
			WebElement CardLoginButton = Capabilities.driver.findElementByXPath(elementButton+"\"Done\"]");
			iOSLogs.CapturedLogs(info, "Done button found");
			return CardLoginButton;
		} else {
			iOSLogs.CapturedLogs(info, "Done button not found");
			return null;
		}
	}
	
	public WebElement InformationIcon() throws Exception {
		//
		if (findLoginPageElement("Card Number Text Field")) {
			WebElement InformationIcon = Capabilities.driver.findElementByXPath(typeImage+"\"Card Number Text Field\"]");
			iOSLogs.CapturedLogs(info, "Information icon not found");
			return InformationIcon;
		} else {
			iOSLogs.CapturedLogs(info, "Information icon not found");
			return null;
		}
	}
	
	public WebElement InformationIconDoneButton() throws Exception {
		//
		if (findExtrasPageSource("Find your card number")) {
			WebElement InformationIconDoneButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Find your card number\"]/XCUIElementTypeOther");
			iOSLogs.CapturedLogs(info, "Information icon done button found");
			return InformationIconDoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Information icon done button not found");
			return null;
		}
	}
	
	public WebElement ShowHidePINPasscodeIcon() throws Exception {
		//
		if (findLoginPageElement("PIN Passcode Text Field")) {
			WebElement ShowHidePINPasscodeIcon = Capabilities.driver.findElementByXPath(typeImage+"\"PIN Passcode Text Field\"]");
			iOSLogs.CapturedLogs(info, "Show hide passcode icon found");
			return ShowHidePINPasscodeIcon;
		} else {
			iOSLogs.CapturedLogs(info, "Show hide passcode icon not found");
			return null;
		}
	}
	
	
	public WebElement invalidCardText() throws Exception {
		
		if (findExtrasPageSource("Invalid Card Number or PIN/Passcode")) {
			WebElement invalidCardText = Capabilities.driver.findElementByXPath(staticText+"\"Invalid Card Number or PIN/Passcode\"]");
			iOSLogs.CapturedLogs(info, "Invalid Card Number or PIN Passcode found");
			return invalidCardText;
		} else {
			iOSLogs.CapturedLogs(info, "Invalid Card Number or PIN Passcode not found");
			return null;
		}
	}
	
	
	public WebElement suspendedOKButton() throws Exception {
		
		if (findExtrasPageSource("OK")) {
			WebElement suspendedOKButton = Capabilities.driver.findElementByXPath(elementButton+"\"OK\"]");

			iOSLogs.CapturedLogs(info, "Account Suspened Ok Button Found");
			return suspendedOKButton;
		} else {
			iOSLogs.CapturedLogs(info, "Account Suspened Ok Button not found");
			return null;
		}
	}
	
public WebElement skipProfileButton() throws Exception {
		
		if (findExtrasPageSource("Skip Button")) {
			WebElement skipProfileButton = Capabilities.driver.findElementByXPath(elementButton+"\"Skip Button\"]");
		
			iOSLogs.CapturedLogs(info, "Skip Profile button Found");
			return skipProfileButton;
		} else {
			iOSLogs.CapturedLogs(info, "Skip Profile button not found");
			return null;
		}
	}
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Multi card login page	
	
	
	public WebElement CheckForMuliCardLogin() throws Exception {
		
		if (findExtrasPageSource("Select a card")) {
			WebElement CheckForMuliCardLogin = Capabilities.driver.findElementByXPath(staticText+"\"Select a card\"]");


			iOSLogs.CapturedLogs(info, "Multi card login page found");
			return CheckForMuliCardLogin;
		} else {
			iOSLogs.CapturedLogs(info, "Multi card login page not found");
			return null;
		}
	}
	
	
	public WebElement SignInWithDifferentcardButton() throws Exception {
		
		if (findExtrasPageSource("Sign In With Different Card Button")) {
			WebElement SignInWithDifferentcardButton = Capabilities.driver.findElementByXPath(elementButton+"\"Sign In With Different Card Button\"]");


			iOSLogs.CapturedLogs(info, "Sign in with a different card button found");
			return SignInWithDifferentcardButton;
		} else {
			iOSLogs.CapturedLogs(info,"Sign in with a different card button not found");
			return null;
		}
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		//Web Elements for Forgot PIN or passcode flow
	
	public WebElement ForgotPINorPasscodeLink() throws Exception {
		if (findLoginPageElement("Forgot PIN or passcode")) {
			WebElement ForgotPINorPasscodeLink = Capabilities.driver.findElementByXPath(elementButton+"\"Forgot PIN or passcode\"]");
			iOSLogs.CapturedLogs(info, "Forgot pin passcode link found");
			return ForgotPINorPasscodeLink;
		} else {
			iOSLogs.CapturedLogs(info, "Forgot pin passcode link not found");
			return null;
		}
	}
	
	public WebElement ForgotPINorPasscodeCardNumberTextBox() throws Exception {
		if (findExtrasPageSource("Card Number Text Field")) {
			WebElement ForgotPINorPasscodeCardNumberTextBox = Capabilities.driver.findElementByXPath(textField+"\"Card Number Text Field\"]");
			iOSLogs.CapturedLogs(info, "Forgot pin passcode textbox found");
			return ForgotPINorPasscodeCardNumberTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Forgot pin passcode textbox not found");
			return null;
		}
	}
	
	public WebElement ForgotPINorPasscodeNextButton() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement ForgotPINorPasscodeNextButton = Capabilities.driver.findElementByXPath(elementButton+"\"Next Button\"]");
			iOSLogs.CapturedLogs(info, "Forgot pin passcode next button found");
			return ForgotPINorPasscodeNextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Forgot pin passcode Next button not found");
			return null;
		}
	}
	
	public WebElement ForgotPINorPasscodeSecurityAnswerTextBox() throws Exception {
		if (findExtrasPageSource("Forgot Passcode Answer Text Field")) {
			WebElement ForgotPINorPasscodeSecurityAnswerTextBox = Capabilities.driver.findElementByXPath(textField+"\"Forgot Passcode Answer Text Field\"]");
			iOSLogs.CapturedLogs(info, "Forgot pin passcode security answer textbox found");
			return ForgotPINorPasscodeSecurityAnswerTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Forgot pin passcode security answer textbox not found");
			return null;
		}
	}
	
	public WebElement ForgotPINorPasscodeNewPasscodeTextBox() throws Exception {
		if (findExtrasPageSource("New Passcode Text Field")) {
			WebElement ForgotPINorPasscodeNewPasscodeTextBox = Capabilities.driver.findElementByXPath(textField+"\"New Passcode Text Field\"]");
			iOSLogs.CapturedLogs(info, "New passcode textbox found");
			return ForgotPINorPasscodeNewPasscodeTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "New passcode textbox not found");
			return null;
		}
	}
	
	public WebElement ForgotPINorPasscodeConfirmPasscodeTextBox() throws Exception {
		if (findExtrasPageSource("Confirm Passcode Text Field")) {
			WebElement ForgotPINorPasscodeConfirmPasscodeTextBox = Capabilities.driver.findElementByXPath(textField+"\"Confirm Passcode Text Field\"]");
			iOSLogs.CapturedLogs(info, "Confirm passcode textbox found");
			return ForgotPINorPasscodeConfirmPasscodeTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Confirm passcode textbox not found");
			return null;
		}
	}
	
	
	
	public WebElement ForgotPINorPasscodeDoneButton() throws Exception {
		if (findExtrasPageSource("Continue to Home")) {
			WebElement ForgotPINorPasscodeDoneButton = Capabilities.driver.findElementByXPath(elementButton+"\"Continue To Home Button\"]");
			iOSLogs.CapturedLogs(info, "Forgot pin passcode continue to home button found");
			return ForgotPINorPasscodeDoneButton;
		} else {
			iOSLogs.CapturedLogs(info, "Forgot pin passcode continue to home button not found");
			return null;
		}
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//	
		//Web Elements for Create Passcode
	public WebElement SetupProfile() throws Exception {
		if (findExtrasPageSource("Setup profile")) {
			WebElement SetupProfile = Capabilities.driver.findElementByXPath(staticText+"\"Setup profile\"]");
			iOSLogs.CapturedLogs(info, "Setup Profile found");
			return SetupProfile;
		} else {
			iOSLogs.CapturedLogs(info, "Setup Profile not found account either does not have profiles or it was setup on prior run");
			return null;
		}
	}
	
	public WebElement FirstNameTextbox() throws Exception {
		if (findExtrasPageSource("Registration First Name Text Field")) {
			WebElement FirstNameTextbox = Capabilities.driver.findElementByXPath(textField+"\"Registration First Name Text Field\"]");
			iOSLogs.CapturedLogs(info, "First name text box found");
			return FirstNameTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "First name text box not found");
			return null;
		}
	}
	
	public WebElement LastNameTextbox() throws Exception {
		if (findExtrasPageSource("Registration Last Name Text Field")) {
			WebElement LastNameTextbox = Capabilities.driver.findElementByXPath(textField+"\"Registration Last Name Text Field\"]");
			iOSLogs.CapturedLogs(info, "Last name text box found");
			return LastNameTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "Last name text box not found");
			return null;
		}
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//	
	//Web Elements for Setup Profile
	
	public WebElement CreateAPasscodePage() throws Exception {
		if (findExtrasPageSource("Create a passcode")) {
			WebElement CreateAPasscodePage = Capabilities.driver.findElementByXPath(staticText+"\"Create a passcode\"]");
			iOSLogs.CapturedLogs(info, "Create Passcode page found");
			return CreateAPasscodePage;
		} else {
			iOSLogs.CapturedLogs(info, "Create Passcode page not found");
			return null;
		}
	}
	
	public WebElement NewPasscodeTextbox() throws Exception {
		if (findExtrasPageSource("Create PIN Text Field")) {
			WebElement NewPasscodeTextbox = Capabilities.driver.findElementByXPath(textField+"\"Create PIN Text Field\"]");
			iOSLogs.CapturedLogs(info, "New Passcode Text box found");
			return NewPasscodeTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "New Passcode Text box not found");
			return null;
		}
	}
	
	public WebElement ConfirmPasscodeTextbox() throws Exception {
		if (findExtrasPageSource("Confirm PIN Text Field")) {
			WebElement ConfirmPasscodeTextbox = Capabilities.driver.findElementByXPath(textField+"\"Confirm PIN Text Field\"]");
			iOSLogs.CapturedLogs(info, "Confirm Passcode text box found");
			return ConfirmPasscodeTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "Confirm Passcode text box not found");
			return null;
		}
	}
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

			// Web Elements for Pin Reset Page
			
			public WebElement CreateAPinPage() throws Exception {
				if (findExtrasPageSource("Create a PIN")) {
					WebElement CreateAPinPage = Capabilities.driver
							.findElementByXPath(staticText+"\"Create a PIN\"]");
					iOSLogs.CapturedLogs(info, "Create a pin page found");
					return CreateAPinPage;
				} else {
					iOSLogs.CapturedLogs(info,
							"Create a pin page not found this account may already have one setup");
					return null;
				}
			}
			
			public WebElement NewPinTextbox() throws Exception {
				if (findExtrasPageSource("Create PIN Text Field")) {
					WebElement NewPinTextbox = Capabilities.driver
							.findElementByXPath(textField+"\"Create PIN Text Field\"]");
					iOSLogs.CapturedLogs(info, "New pin textbox found");
					return NewPinTextbox;
				} else {
					iOSLogs.CapturedLogs(info,
							"New pin textbox not found");
					return null;
				}
			}
			
			public WebElement ConfirmPinTextbox() throws Exception {
				if (findExtrasPageSource("Confirm PIN Text Field")) {
					WebElement ConfirmPinTextbox = Capabilities.driver
							.findElementByXPath(textField+"\"Confirm PIN Text Field\"]");
					iOSLogs.CapturedLogs(info, "Confirm pin textbox found");
					return ConfirmPinTextbox;
				} else {
					iOSLogs.CapturedLogs(info,
							"Confirm pin textbox not found");
					return null;
				}
			}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//	
		//Web Elements for Setup Profile
	
	
	public WebElement NextButton() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement NextButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Next\"]");
			iOSLogs.CapturedLogs(info, "Next button found");
			return NextButton;
		} else {
			iOSLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}
	
	public WebElement DateOfBirthTextbox() throws Exception {
		if (findExtrasPageSource("Registration DOB Text Field")) {
			WebElement DateOfBirthTextbox = Capabilities.driver.findElementByXPath(textField+"\"Registration DOB Text Field\"]");
			iOSLogs.CapturedLogs(info, "Date of birth textbox found");
			return DateOfBirthTextbox;
		} else {
			iOSLogs.CapturedLogs(info, "Date of birth textbox not found");
			return null;
		}
	}
	
	public WebElement PhoneNumberTextBox() throws Exception {
		if (findExtrasPageSource("Registration Phone Text Field")) {
			WebElement PhoneNumberTextBox = Capabilities.driver.findElementByXPath(textField+"\"Registration Phone Text Field\"]");
			iOSLogs.CapturedLogs(info, "Phone number textbox found");
			return PhoneNumberTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Phone number textbox not found");
			return null;
		}
	}
	
	public WebElement EmailTextBox() throws Exception {
		if (findExtrasPageSource("Registration Email Text Field")) {
			WebElement EmailTextBox = Capabilities.driver.findElementByXPath(textField+"\"Registration Email Text Field\"]");
			iOSLogs.CapturedLogs(info, "Email textbox found");
			return EmailTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Email textbox not found");
			return null;
		}
	}
	
	public WebElement SocialTextBox() throws Exception {
		if (findExtrasPageSource("Registration SSN Text Field")) {
			WebElement SocialTextBox = Capabilities.driver.findElementByXPath(textField+"\"Registration SSN Text Field\"]");
			iOSLogs.CapturedLogs(info, "Social security number textbox found");
			return SocialTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Social security number textbox not found");
			return null;
		}
	}
	
	public WebElement HomeAddressTextBox() throws Exception {
		if (findExtrasPageSource("Search Address Text Field")) {
			WebElement HomeAddressTextBox = Capabilities.driver.findElementByXPath(textField+"\"Search Address Text Field\"]");
			iOSLogs.CapturedLogs(info, "Home address textbox found");
			return HomeAddressTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Home address textbox not found");
			return null;
		}
	}
	
	public WebElement AddressSelector() throws Exception {
		if (findExtrasPageSource("1 Hancock St")) {
			WebElement AddressSelector = Capabilities.driver.findElementByXPath(staticText+"\"1 Hancock St\"]");
			iOSLogs.CapturedLogs(info, "Home address selector found");
			return AddressSelector;
		} else {
			iOSLogs.CapturedLogs(info, "Home address selector not found");
			return null;
		}
	}
	
	public WebElement AddressLineTwo() throws Exception {
		if (findExtrasPageSource("Unit Number Text Field")) {
			WebElement AddressLineTwo = Capabilities.driver.findElementByXPath(textField+"\"Unit Number Text Field\"]");
			iOSLogs.CapturedLogs(info, "Address line two textbox found");
			return AddressLineTwo;
		} else {
			iOSLogs.CapturedLogs(info, "Address line two textbox not found");
			return null;
		}
	}
	
	public WebElement ProfileFinishButton() throws Exception {
		if (findExtrasPageSource("Finish")) {
			WebElement ProfileFinishButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Finish\"]");
			iOSLogs.CapturedLogs(info, "Finish button found");
			return ProfileFinishButton;
		} else {
			iOSLogs.CapturedLogs(info, "Finish button not found");
			return null;
		}
	}
	
	public WebElement GetStartedButton() throws Exception {
		if (findExtrasPageSource("Get started")) {
			WebElement GetStartedButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Get started\"]");
			iOSLogs.CapturedLogs(info, "Get started button found");
			return GetStartedButton;
		} else {
			iOSLogs.CapturedLogs(info, "Get started button not found");
			return null;
		}
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		//Web Elements for Secure Fuel Check in page

	public WebElement FuelCheckInButton() throws Exception {
		if (findExtrasPageSource("Fuel Checkin Button")) {
			WebElement FuelCheckInButton = Capabilities.driver.findElementByXPath(elementButton+"\"Fuel Checkin Button\"]");
			iOSLogs.CapturedLogs(info, "Fuel check in button found");
			return FuelCheckInButton;
		} else {
			iOSLogs.CapturedLogs(info, "Fuel check in button not found");
			return null;
		}
	}
	
	public WebElement UnitNumberTextBox() throws Exception {
		if (findExtrasPageSource("Unit Number Text Field")) {
			WebElement UnitNumberTextBox = Capabilities.driver.findElementByXPath(textField+"\"Unit Number Text Field\"]");
			iOSLogs.CapturedLogs(info, "Unit number text box found");
			return UnitNumberTextBox;
		} else {
			iOSLogs.CapturedLogs(info, "Unit number text box not found");
			return null;
		}
	}
	

	public WebElement CheckInButton() throws Exception {
		if (findExtrasPageSource("Check-in")) {
			WebElement CheckInButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Check-in\"]");
			iOSLogs.CapturedLogs(info, "Check-in button found");
			return CheckInButton;
		} else {
			iOSLogs.CapturedLogs(info, "Check-in button not found");
			return null;
		}
	}
	
	public WebElement AllowLocationModal() throws Exception {
		if (findExtrasPageSource("Allow While Using App")) {
			WebElement AllowLocationModal = Capabilities.driver.findElementByXPath(elementButton+"\"Allow While Using App\"]");
			iOSLogs.CapturedLogs(info, "Allow location modal button found");
			return AllowLocationModal;
		} else {
			iOSLogs.CapturedLogs(info, "Allow location modal button not found");
			return null;
		}
	}
	
	public WebElement DismissFuelCheckinButton() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement DismissFuelCheckinButton = Capabilities.driver.findElementByXPath(elementButton+"\"Dismiss Button\"]");
		

			iOSLogs.CapturedLogs(info, "Dismiss check in button found");
			return DismissFuelCheckinButton;
		} else {
			iOSLogs.CapturedLogs(info, "Dismiss check in button not found");
			return null;
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	

		// Web Elements for Register checks page
		//TODO add xpaths when available
		public WebElement RegisterCheckIconButton() throws Exception {
			if (findExtrasPageSource("Register Check Button")) {
				WebElement RegisterCheckIconButton = Capabilities.driver.findElementByXPath(elementButton+"\"Register Check Button\"]");
				iOSLogs.CapturedLogs(info, "Register Check button found");
				return RegisterCheckIconButton;
			} else {
				iOSLogs.CapturedLogs(info, "Register Check button not found");
				return null;
			}
		}
		
		public WebElement AmountTextBoxRegisterCheck() throws Exception {
			if (findExtrasPageSource("Enter amount")) {
				WebElement AmountTextBoxRegisterCheck = Capabilities.driver.findElementByXPath(typeApp+"\"Test Card Control\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
				iOSLogs.CapturedLogs(info, "Amount text box found");
				return AmountTextBoxRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Amount text box not found");
				return null;
			}
		}
		
		public WebElement NextButtonRegisterCheck() throws Exception {
			if (findExtrasPageSource("Next Button")) {
				WebElement NextButtonRegisterCheck = Capabilities.driver.findElementByXPath(elementButton+"\"Next Button\"]");
				iOSLogs.CapturedLogs(info, "Next button found");
				return NextButtonRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Next button not found");
				return null;
			}
		}
		
		

		public WebElement CheckNumberInfoFromTextBox() throws Exception {
			if (findExtrasPageSource("Register Check")) {
				WebElement CheckNumberInfoFromTextBox = Capabilities.driver.findElementByXPath(elementButton+"\"Open Find Check Number Button\"]");
				iOSLogs.CapturedLogs(info, "Check Number Info Help Button found");
				return CheckNumberInfoFromTextBox;
			} else {
				iOSLogs.CapturedLogs(info, "Check Number Info Help Button not found");
				return null;
			}
		}
		
				

		public WebElement CheckNumberInfoFromTextBoxDoneButton() throws Exception {
			if (findExtrasPageSource("Done")) {
				WebElement CheckNumberInfoFromTextBoxDoneButton = Capabilities.driver.findElementByXPath(elementButton+"\"Done Button\"]");
				iOSLogs.CapturedLogs(info, "Check Number Info Help done Button found");
				return CheckNumberInfoFromTextBoxDoneButton;
			} else {
				iOSLogs.CapturedLogs(info, "Check Number Info Help done Button not found");
				return null;
			}
		}
		
		
		public WebElement WhatIsRegisterCheckButton() throws Exception {
			if (findExtrasPageSource("Register Check")) {
				WebElement WhatIsRegisterCheckButton = Capabilities.driver.findElementByXPath(elementButton+"\"Right Navigation Bar Button\"]");
				iOSLogs.CapturedLogs(info, "What is Register Check Button found");
				return WhatIsRegisterCheckButton;
			} else {
				iOSLogs.CapturedLogs(info, "What is Register Check Button not found");
				return null;
			}
		}
		
		

		public WebElement WhatIsRegisterCheckDoneButton() throws Exception {
			if (findExtrasPageSource("Done")) {
				WebElement WhatIsRegisterCheckDoneButton = Capabilities.driver.findElementByXPath(elementButton+"\"Done Button\"]");
				iOSLogs.CapturedLogs(info, "What is Register Check done Button found");
				return WhatIsRegisterCheckDoneButton;
			} else {
				iOSLogs.CapturedLogs(info, "What is Register Check done Button not found");
				return null;
			}
		}
		
		
		public WebElement CheckNumberTextBox() throws Exception {
			if (findExtrasPageSource("Check number")) {
				WebElement CheckNumberTextBox = Capabilities.driver.findElementByXPath(textFieldValue+"\"Check number\"]");
				iOSLogs.CapturedLogs(info, "Check Number Text Box found");
				return CheckNumberTextBox;
			} else {
				iOSLogs.CapturedLogs(info, "Check Number Text Box not found");
				return null;
			}
		}
		
		public WebElement SubmitButtonRegisterCheck() throws Exception {
			if (findExtrasPageSource("Submit Button")) {
				WebElement SubmitButtonRegisterCheck = Capabilities.driver.findElementByXPath(elementButton+"\"Submit Button\"]");
				iOSLogs.CapturedLogs(info, "Submit button found");
				return SubmitButtonRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Submit button not found");
				return null;
			}
		}
	
		public WebElement DismissAuthButtonRegisterCheck() throws Exception {
			if (findExtrasPageSource("Dismiss Button")) {
				WebElement DismissAuthButtonRegisterCheck = Capabilities.driver.findElementByXPath(elementButton+"\"Dismiss Button\"]");
				iOSLogs.CapturedLogs(info, "Dismiss auth button found");
				return DismissAuthButtonRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Dismiss auth button not found");
				return null;
			}
		}

		public WebElement DismissAuthButtonTwoRegisterCheck() throws Exception {
			if (findExtrasPageSource("Dismiss Button")) {
				WebElement DismissAuthButtonTwoRegisterCheck = Capabilities.driver.findElementByXPath(elementButton+"\"Dismiss Button\"]");
				iOSLogs.CapturedLogs(info, "Dismiss button found");
				return DismissAuthButtonTwoRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Dismiss button not found");
				return null;
			}
		}
		
		public WebElement CancelButtonRegisterCheck() throws Exception {
			if (findExtrasPageSource("Cancel")) {
				WebElement CancelButtonRegisterCheck = Capabilities.driver.findElementByXPath(elementButton+"\"Cancel\"]");
				iOSLogs.CapturedLogs(info, "Cancel button found");
				return CancelButtonRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Cancel button not found");
				return null;
			}
		}
		
		public WebElement DismissCodeModalButtonRegisterCheck() throws Exception {
			if (findExtrasPageSource("Dismiss Code")) {
				WebElement DismissCodeModalButtonRegisterCheck = Capabilities.driver.findElementByXPath(elementButton+"\"Dismiss Code\"]");
				iOSLogs.CapturedLogs(info, "Dismiss code modal button found");
				return DismissCodeModalButtonRegisterCheck;
			} else {
				iOSLogs.CapturedLogs(info, "Dismiss code modal button not found");
				return null;
			}
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		
		//WebElements for Dynamic PIN
		public WebElement DynamicPINButton() throws Exception {
			if (findExtrasPageSource("****, Dynamic PIN")) {
				WebElement DynamicPINButton = Capabilities.driver.findElementByXPath(elementButton+"\"****, Dynamic PIN\"]");
				iOSLogs.CapturedLogs(info, "Dynamic PIN button found");
				return DynamicPINButton;
			} else {
				iOSLogs.CapturedLogs(info, "Dynamic PIN button not found");
				return null;
			}
		}
		

		public WebElement DynamicPINButtonName() throws Exception {
			if (findExtrasPageSource("Dynamic Pin Button")) {
				WebElement DynamicPINButtonName = Capabilities.driver.findElementByXPath(elementButton+"\"Dynamic Pin Button\"]");
				iOSLogs.CapturedLogs(info, "Dynamic PIN button found");
				return DynamicPINButtonName;
			} else {
				iOSLogs.CapturedLogs(info, "Dynamic PIN button not found");
				return null;
			}
		}
		
		
		public WebElement DynamicPINButtonOld() throws Exception {
			if (findExtrasPageSource("**** Dynamic PIN")) {
				WebElement DynamicPINButtonOld = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"**** Dynamic PIN\"]");
				iOSLogs.CapturedLogs(info, "Dynamic PIN button found");
				return DynamicPINButtonOld;
			} else {
				iOSLogs.CapturedLogs(info, "Dynamic PIN button not found");
				return null;
			}
		}
		
		public WebElement DynamicPINNumber() throws Exception {
			if (findExtrasPageSource("")) {
				WebElement DynamicPINNumber = Capabilities.driver.findElementByXPath(elementButton+"\"\"]");
				iOSLogs.CapturedLogs(info, "Dynamic PIN number found");
				return DynamicPINNumber;
			} else {
				iOSLogs.CapturedLogs(info, "Dynamic PIN number not found");
				return null;
			}
		}
		

		public WebElement DismissDynamicPINbutton() throws Exception {
			if (findExtrasPageSource("Dismiss Button")) {
				WebElement DismissDynamicPINbutton = Capabilities.driver.findElementByXPath(elementButton+"\"Dismiss Button\"]");
				iOSLogs.CapturedLogs(info, "Dismiss Dynamic PIN button found");
				return DismissDynamicPINbutton;
			} else {
				iOSLogs.CapturedLogs(info, "Dismiss Dynamic PIN button not found");
				return null;
			}
		}
		
		
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		// Web elements for  One time transfer funds flow

		public WebElement TransferFundsButton() throws Exception {
			if (findExtrasPageSource("Transfer Funds")) {
				WebElement TransferFundsButton = Capabilities.driver.findElementByXPath(elementButton+"\"Transfer Funds\"]");
				iOSLogs.CapturedLogs(info, "Transfer funds button found");
				return TransferFundsButton;
			} else {
				iOSLogs.CapturedLogs(info, "Transfer funds button not found");
				return null;
			}
			}
		
		public WebElement SmartFundsTab() throws Exception {
			if (findExtrasPageSource("SmartFunds")) {
				WebElement SmartFundsTab = Capabilities.driver.findElementByXPath(elementButton+"\"SmartFunds\"]");
				iOSLogs.CapturedLogs(info, "SmartFunds tab found");
				return SmartFundsTab;
			} else {
				iOSLogs.CapturedLogs(info, "SmartFunds tab not found");
				return null;
			}
			}
			
			public WebElement OneTimeTransferRadioButton() throws Exception {
				if (findExtrasPageSource("Transfer Type single cell")) {
					WebElement OneTimeTransferRadioButton = Capabilities.driver.findElementByXPath(staticText+"\"Transfer Type single cell\"]");
					iOSLogs.CapturedLogs(info, "One time transfer radio button found");
					return OneTimeTransferRadioButton;
				} else {
					iOSLogs.CapturedLogs(info, "One time transfer radio button not found");
					return null;
				}	
		}
			
			public WebElement NextTransferFundsButton() throws Exception {
				if (findExtrasPageSource("Next Button")) {
					WebElement NextTransferFundsButton = Capabilities.driver.findElementByXPath(elementButton+"\"Next Button\"]");
					iOSLogs.CapturedLogs(info, "Next button select type screen found");
					return NextTransferFundsButton;
				} else {
					iOSLogs.CapturedLogs(info, "Next button select type screen not found");
					return null;
				}	
		}
			
			public WebElement NextTransferFundsButtonTransferTo() throws Exception {
				if (findExtrasPageSource("Next")) {
					WebElement NextTransferFundsButtonTransferTo = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Next\"]");
					iOSLogs.CapturedLogs(info, "Next button Transfer to screen found");
					return NextTransferFundsButtonTransferTo;
				} else {
					iOSLogs.CapturedLogs(info, "Next button transfer to screen not found");
					return null;
				}	
		}
			
			

			public WebElement SelectDaysOfTheMonthNextButton() throws Exception {
				if (findExtrasPageSource("Next or Save Button")) {
					WebElement SelectDaysOfTheMonthNextButton = Capabilities.driver.findElementByXPath(elementButton+"\"Next or Save Button\"]");
					iOSLogs.CapturedLogs(info, "Select days of the mont next button found");
					return SelectDaysOfTheMonthNextButton;
				} else {
					iOSLogs.CapturedLogs(info, "Select days of the mont next button not found");
					return null;
				}	
		}
			
			
			public WebElement EnterAmountTextBox() throws Exception {
				if (findExtrasPageSource("Amount entered field")) {
					WebElement EnterAmountTextBox = Capabilities.driver.findElementByXPath(textField+"\"Amount entered field\"]");
					iOSLogs.CapturedLogs(info, "Enter amount textbox found");
					return EnterAmountTextBox;
				} else {
					iOSLogs.CapturedLogs(info, "Enter amount textbox not found");
					return null;
				}	
		}
			
			public WebElement EditAmountButton() throws Exception {
				if (findExtrasPageSource("Edit amount Button")) {
					WebElement EditAmountButton = Capabilities.driver.findElementByXPath(elementButton+"\"Edit amount Button\"]");
					iOSLogs.CapturedLogs(info, "Edit amount button found");
					return EditAmountButton;
				} else {
					iOSLogs.CapturedLogs(info, "Edit amount button not found");
					return null;
				}	
		}
			public WebElement PercentOfBalanceTab() throws Exception {
				if (findExtrasPageSource("% of balance")) {
					WebElement PercentOfBalanceTab = Capabilities.driver.findElementByXPath(elementButton+"\"% of balance\"]]");
					iOSLogs.CapturedLogs(info, "% of balance tab found");
					return PercentOfBalanceTab;
				} else {
					iOSLogs.CapturedLogs(info, "% of balance tab not found");
					return null;
				}	
		}
			
			public WebElement EnterPercentTextBox() throws Exception {
				if (findExtrasPageSource("Amount entered field")) {
					WebElement EnterPercentTextBox = Capabilities.driver.findElementByXPath(textField+"\"Amount entered field\"]");
					iOSLogs.CapturedLogs(info, "Enter Percent textbox found");
					return EnterPercentTextBox;
				} else {
					iOSLogs.CapturedLogs(info, "Enter percent textbox not found");
					return null;
				}	
		}
			
			public WebElement SubmitButton() throws Exception {
				if (findExtrasPageSource("Submit Button")) {
					WebElement SubmitButton = Capabilities.driver.findElementByXPath(elementButton+"\"Submit Button\"]");
					iOSLogs.CapturedLogs(info, "Submit button found");
					return SubmitButton;
				} else {
					iOSLogs.CapturedLogs(info, "Submit button not found");
					return null;
				}	
		}
			
			public WebElement DismissButtonTransferFunds() throws Exception {
				if (findExtrasPageSource("Dismiss Button")) {
					WebElement DismissButtonTransferFunds = Capabilities.driver.findElementByXPath(elementButton+"\"Dismiss Button\"]");
					iOSLogs.CapturedLogs(info, "Dismiss button found");
					return DismissButtonTransferFunds;
				} else {
					iOSLogs.CapturedLogs(info, "Dismiss button not found");
					return null;
				}	
		}
			
			
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		// Web elements for Repeat transfer funds flow

			public WebElement RepeatTransferRadioButton() throws Exception {
				if (findExtrasPageSource("Transfer Type multiple cell")) {
					WebElement RepeatTransferRadioButton = Capabilities.driver.findElementByXPath(staticText+"\"Transfer Type multiple cell\"]");
					iOSLogs.CapturedLogs(info, "Repeat transfer radio button found");
					return RepeatTransferRadioButton;
				} else {
					iOSLogs.CapturedLogs(info, "Repeat transfer radio button not found");
					return null;
				}	
		}
			
		public WebElement SelectBankAccount() throws Exception {
			if (findExtrasPageSource("Bank Account mobile automation cell")) {
				WebElement RepeatTransferRadioButton = Capabilities.driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Bank Account mobile automation cell\"])[1]");
				iOSLogs.CapturedLogs(info, "Bank account radio button found");
				return RepeatTransferRadioButton;
			} else {
				iOSLogs.CapturedLogs(info, "Bank account radio button not found");
				return null;
			}
		}
		
		public WebElement DoneDatePickerButton() throws Exception {
			if (findExtrasPageSource("Next")) {
				WebElement DoneDatePickerButton = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Next\"]");
				iOSLogs.CapturedLogs(info, "Set end Date Picker next button found");
				return DoneDatePickerButton;
			} else {
				iOSLogs.CapturedLogs(info, "Set end Date Picker next button not found");
				return null;
			}
		}
			
		
		public WebElement DailyRepeatSchedule() throws Exception {
			if (findExtrasPageSource("Daily")) {
				WebElement DailyRepeatSchedule = Capabilities.driver.findElementByXPath(elementButton+"\"Daily\"]");
				iOSLogs.CapturedLogs(info, "Daily Repeat schedule found");
				return DailyRepeatSchedule;
			} else {
				iOSLogs.CapturedLogs(info, "Daily Repeat schedule not found");
				return null;
			}
		}
		
		public WebElement WeeklyRepeatSchedule() throws Exception {
			if (findExtrasPageSource("Weekly")) {
				WebElement WeeklyRepeatSchedule = Capabilities.driver.findElementByXPath(elementButton+"\"Weekly\"]");
				iOSLogs.CapturedLogs(info, "Weekly Repeat schedule found");
				return WeeklyRepeatSchedule;
			} else {
				iOSLogs.CapturedLogs(info, "Weekly Repeat schedule not found");
				return null;
			}
		}
		
		public WebElement SaturdayWeekly() throws Exception {
			if (findExtrasPageSource("Saturday")) {
				WebElement MondayWeekly = Capabilities.driver.findElementByXPath(elementButton+"\"Saturday\"]");
				iOSLogs.CapturedLogs(info, "Saturday found");
				return MondayWeekly;
			} else {
				iOSLogs.CapturedLogs(info, "Saturday not found");
				return null;
			}
		}
		
		public WebElement MonthlyRepeatSchedule() throws Exception {
			if (findExtrasPageSource("Monthly")) {
				WebElement MonthlyRepeatSchedule = Capabilities.driver.findElementByXPath(elementButton+"\"Monthly\"]");
				iOSLogs.CapturedLogs(info, "Monthly Repeat schedule found");
				return MonthlyRepeatSchedule;
			} else {
				iOSLogs.CapturedLogs(info, "Monthly Repeat schedule not found");
				return null;
			}
		}
		
		public WebElement MonthlyDate1RepeatSchedule() throws Exception {
			if (findExtrasPageSource("1")) {
				WebElement MonthlyDate1RepeatSchedule = Capabilities.driver.findElementByXPath(elementButton+"\"1\"]");
				iOSLogs.CapturedLogs(info, "Day 1 on Monthly Repeat schedule found");
				return MonthlyDate1RepeatSchedule;
			} else {
				iOSLogs.CapturedLogs(info, "Day 1 on Monthly Repeat schedule not found");
				return null;
			}
		}
		
		public WebElement MonthlyDate2RepeatSchedule() throws Exception {
			if (findExtrasPageSource("2")) {
				WebElement MonthlyRepeatSchedule = Capabilities.driver.findElementByXPath(elementButton+"\"2\"]");
				iOSLogs.CapturedLogs(info, "Day 2 Monthly Repeat schedule found");
				return MonthlyRepeatSchedule;
			} else {
				iOSLogs.CapturedLogs(info, "Day 2 Monthly Repeat schedule not found");
				return null;
			}
		}
		
		
		public WebElement OnceNewSmartFundsAreLoadedRepeatSchedule() throws Exception {
			if (findExtrasPageSource("Once new SmartFunds are loaded")) {
				WebElement OnceNewSmartFundsAreLoadedRepeatSchedule = Capabilities.driver.findElementByXPath(elementButton+"\"Once new SmartFunds are loaded\"]");
				iOSLogs.CapturedLogs(info, "Once new smartfunds are loaded Repeat schedule found");
				return OnceNewSmartFundsAreLoadedRepeatSchedule;
			} else {
				iOSLogs.CapturedLogs(info, "Once new smartfunds are loaded Repeat schedule not found");
				return null;
			}
		}
		
		public WebElement SetEndDateSwitch() throws Exception {
			if (findExtrasPageSource("Test Card Control")) {
				WebElement SetEndDateSwitch = Capabilities.driver.findElementByXPath(typeApp+"\"Test Card Control\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch");
				iOSLogs.CapturedLogs(info, "Set End date switch found");
				return SetEndDateSwitch;
			} else {
				iOSLogs.CapturedLogs(info, "Set End date switch not found");
				return null;
			}
		}
		
		public WebElement EditBankAccountButton() throws Exception {
			if (findExtrasPageSource("Edit bank account Button")) {
				WebElement EditBankAccountButton = Capabilities.driver.findElementByXPath(elementButton+"\"Edit bank account Button\"]");
				iOSLogs.CapturedLogs(info, "Edit bank account found");
				return EditBankAccountButton;
			} else {
				iOSLogs.CapturedLogs(info, "Edit bank account not found");
				return null;
			}
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		// Web Elements for Logout Page
	
		
		
		public WebElement HelpScreenContinue() throws Exception {
			if (findExtrasPageSource("Continue Button")) {
				WebElement HelpScreenContinue = Capabilities.driver.findElementByXPath(elementButton+"\"Continue Button\"]");
				iOSLogs.CapturedLogs(info, "Help Screen Continue button found");
				return HelpScreenContinue;
			} else {
				iOSLogs.CapturedLogs(info, "Help Screen Continue not found");
				return null;
			}
		}
		
		
		public WebElement ProfileCardHolderInfoLoaded() throws Exception {
			if (findExtrasPageSource("Account")) {
				WebElement ProfileCardHolderInfoLoaded = Capabilities.driver.findElementByXPath(staticText+"\"Account\"]");
				iOSLogs.CapturedLogs(info, "Card holder page loaded");
				return ProfileCardHolderInfoLoaded;
			} else {
				iOSLogs.CapturedLogs(info, "Card holder page did not load");
				return null;
			}
		}
		
		public WebElement HomeHeader() throws Exception {
			
			if (findExtrasPageSource("Home")) {
				WebElement HomeHeader = Capabilities.driver.findElementByXPath(elementButton+"\"Home\"]");
				iOSLogs.CapturedLogs(info, "Home header seen");
				return HomeHeader;
			} else {
				iOSLogs.CapturedLogs(info, "Home header not found");
				return null;
			}
		}
		

	public WebElement CompanyHeader() throws Exception {
		
		if (findExtrasPageSource("Company")) {
			WebElement CompanyHeader = Capabilities.driver.findElementByXPath(elementButton+"\"Company\"]");
			iOSLogs.CapturedLogs(info, "Company header seen");
			return CompanyHeader;
		} else {
			iOSLogs.CapturedLogs(info, "Company header not found");
			return null;
		}
	}


	public WebElement SmartFundsHeader() throws Exception {
		
		if (findExtrasPageSource("SmartFunds balance")) {
			WebElement SmartFundsHeader = Capabilities.driver.findElementByXPath(staticText+"\"SmartFunds balance\"]");
			iOSLogs.CapturedLogs(info, "Smartfunds header seen");
			return SmartFundsHeader;
		} else {
			iOSLogs.CapturedLogs(info, "Smartfunds header not found");
			return null;
		}
	}
		
		
		
	

		
		public WebElement ProfileButton() throws Exception {
			//
			if (findLoginPageElement("Account Home Button")) {
				WebElement ProfileButton = Capabilities.driver.findElementByXPath(elementButton+"\"Account Home Button\"]");
				iOSLogs.CapturedLogs(info, "Profile button found");
				return ProfileButton;
			} else {
				iOSLogs.CapturedLogs(info, "Profile button not found");
				return null;
			}
		}
		

		public WebElement CardLogoutButton() throws Exception {
		//
		if (findProfilePageElement("Log out")) {
			WebElement CardLogoutButton = Capabilities.driver.findElementByXPath(elementButton+"\"Logout Button\"]");
			iOSLogs.CapturedLogs(info, "Logout button found");
			return CardLogoutButton;
		} else {
			iOSLogs.CapturedLogs(info, "Logout button not found");
			return null;
		}
	}
	
	public WebElement CardlogoutModalCancelButton() throws Exception {
		//
		if (findExtrasPageSource("Cancel")) {
			WebElement logoutModalCancelButton = Capabilities.driver.findElementByXPath(elementButton+"\"Cancel\"]");
			iOSLogs.CapturedLogs(info, "Cancel button found");
			return logoutModalCancelButton;
		} else {
			iOSLogs.CapturedLogs(info, "Cancel button not found");
			return null;
		}
	}
	
	

	public WebElement CardlogoutModalLogoutButton() throws Exception {
		//
		if (findExtrasPageSource("Log out")) {
			WebElement CardlogoutModalLogoutButton = Capabilities.driver.findElementByXPath(elementButton+"\"Log out\"]");
			iOSLogs.CapturedLogs(info, "Logout modal button found");
					
			return CardlogoutModalLogoutButton;
		} else {
			iOSLogs.CapturedLogs(info, "Logout modal button not found");
			return null;
		}
	}
	
	
	
	

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			// Web Elements for Profile Page
		
			public WebElement ChangePinOnProfile() throws Exception {
				//
				if (findProfilePageElement("Change PIN")) {
					WebElement ChangePin = Capabilities.driver.findElementByXPath(elementButton+"\"Change Password Button\"]");
					iOSLogs.CapturedLogs(info, "Change Pin button found");
					return ChangePin;
				} else {
					iOSLogs.CapturedLogs(info, "Change PIN button not found");
					return null;
				}
			}
			
			
			public WebElement ChangePasscodeOnProfile() throws Exception {
				//
				if (findProfilePageElement("Change passcode")) {
					WebElement ChangePasscodeOnProfile = Capabilities.driver.findElementByXPath(elementButton+"\"Change passcode\"]");
					iOSLogs.CapturedLogs(info, "Change passcode button found");
					return ChangePasscodeOnProfile;
				} else {
					iOSLogs.CapturedLogs(info, "Change passcode button not found");
					return null;
				}
			}
			
			public WebElement CurrentPinOnProfile() throws Exception {
				//
				if (findExtrasPageSource("Current PIN")) {
					WebElement ChangePin = Capabilities.driver.findElementByXPath(secureText+"\"Current PIN\"]");
					iOSLogs.CapturedLogs(info, "Current Pin button found");
					return ChangePin;
				} else {
					iOSLogs.CapturedLogs(info, "Current PIN button not found");
					return null;
				}
			}
			
			public WebElement NewPinOnProfile() throws Exception {
				//
				if (findExtrasPageSource("New PIN")) {
					WebElement ChangePin = Capabilities.driver.findElementByXPath(secureText+"\"New PIN\"]");
					iOSLogs.CapturedLogs(info, "New Pin button found");
					return ChangePin;
				} else {
					iOSLogs.CapturedLogs(info, "New PIN button not found");
					return null;
				}
			}
			
			
			public WebElement ConfirmNewPinOnProfile() throws Exception {
				//
				if (findExtrasPageSource("Confirm new PIN")) {
					WebElement ChangePin = Capabilities.driver.findElementByXPath(secureText+"\"Confirm new PIN\"]");
					iOSLogs.CapturedLogs(info, "Confirm new PIN button found");
					return ChangePin;
				} else {
					iOSLogs.CapturedLogs(info, "Confirm new PIN button not found");
					return null;
				}
			}
			
			public WebElement SaveNewPinOnProfile() throws Exception {
				//
				if (findExtrasPageSource("Save")) {
					WebElement SaveNewPinOnProfile = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"Save\"]");
					iOSLogs.CapturedLogs(info, "Save New Pin On Profile button found");
					return SaveNewPinOnProfile;
				} else {
					iOSLogs.CapturedLogs(info, "Save New Pin On Profile button not found");
					return null;
				}
			}
			
			
			public WebElement CurrentPasscodeOnProfile() throws Exception {
				//
				if (findExtrasPageSource("Current passcode")) {
					WebElement CurrentPasscodeOnProfile = Capabilities.driver.findElementByXPath(secureText+"\"Current passcode\"]");
					iOSLogs.CapturedLogs(info, "Current passcode button found");
					return CurrentPasscodeOnProfile;
				} else {
					iOSLogs.CapturedLogs(info, "Current passcode button not found");
					return null;
				}
			}
			
			public WebElement NewPasscodeOnProfile() throws Exception {
				//
				if (findExtrasPageSource("New passcode")) {
					WebElement NewPasscodeOnProfile = Capabilities.driver.findElementByXPath(secureText+"\"New passcode\"]");
					iOSLogs.CapturedLogs(info, "New passcode button found");
					return NewPasscodeOnProfile;
				} else {
					iOSLogs.CapturedLogs(info, "New passcode button not found");
					return null;
				}
			}
			
			
			public WebElement ConfirmNewPasscodeOnProfile() throws Exception {
				//
				if (findExtrasPageSource("Confirm new passcode")) {
					WebElement ConfirmNewPasscodeOnProfile = Capabilities.driver.findElementByXPath(secureText+"\"Confirm new passcode\"]");
					iOSLogs.CapturedLogs(info, "Confirm new passcode button found");
					return ConfirmNewPasscodeOnProfile;
				} else {
					iOSLogs.CapturedLogs(info, "Confirm new passcode button not found");
					return null;
				}
			}
			
			public WebElement SaveNewPasscodeOnProfile() throws Exception {
				//
				if (findExtrasPageSource("Save")) {
					WebElement SaveNewPasscodeOnProfile = Capabilities.driver.findElementByXPath(elementButton+"\"Save\"]");
					iOSLogs.CapturedLogs(info, "Save New passcode On Profile button found");
					return SaveNewPasscodeOnProfile;
				} else {
					iOSLogs.CapturedLogs(info, "Save New passcode On Profile button not found");
					return null;
				}
			}
	
			public WebElement CloseProfileButton() throws Exception {
				if (findExtrasPageSource("Home")) {
				    WebElement CloseProfileButton = Capabilities.driver.findElementByXPath(elementButton+"\"Home\"]");
					iOSLogs.CapturedLogs(info, "Close Profile button found");
					return CloseProfileButton;
				} else {
					iOSLogs.CapturedLogs(info, "Close Profile button not found");
					return null;
				}
			}
			
			public WebElement CardLastFour6344() throws Exception {
				//
				if (findExtrasPageSource("Card")) {
					WebElement CardLastFour6344 = Capabilities.driver.findElementByXPath(staticText+"\"•••••••••••••••6344\"]");
					iOSLogs.CapturedLogs(info, "Card last four 6344 found");
					return CardLastFour6344;
				} else {
					iOSLogs.CapturedLogs(info, "Card last four 6344 not found");
					return null;
				}
			}

		
		

//edit account 					
			public WebElement editCardHolderInfoButton() throws Exception {
				if (findExtrasPageSource("	Card Info Row Button")) {
					WebElement editCardHolderInfoButton = Capabilities.driver
							.findElementByXPath(staticText+"\"	Card Info Row Button\"]");
					iOSLogs.CapturedLogs(info, "Edit Card Holder Button button found");
					return editCardHolderInfoButton;
				} else {
					iOSLogs.CapturedLogs(info, "Edit Card Holder Info Button not found");
					return null;
				}
			}
			
			

//			public WebElement OpenEditName() throws Exception {
//				if (findExtrasPageSource("Name")) {
//					WebElement OpenEditName = Capabilities.driver
//							.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_name\"]");
//					iOSLogs.CapturedLogs(info, "Edit Name found");
//					return OpenEditName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit name not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement EditFirstName() throws Exception {
//				if (findExtrasPageSource("Edit name")) {
//					WebElement EditFirstName = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_first_name_edittext\"]");
//					iOSLogs.CapturedLogs(info, "Edit fist Name text box found");
//					return EditFirstName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit fist Name text box not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement EditLastName() throws Exception {
//				if (findExtrasPageSource("Edit name")) {
//					WebElement EditLastName = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_last_name_edittext\"]");
//					iOSLogs.CapturedLogs(info, "Edit Last Name textbox found");
//					return EditLastName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Last Name textbox not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement SaveName() throws Exception {
//				if (findExtrasPageSource("Save")) {
//					WebElement SaveName = Capabilities.driver
//							.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/saveNameButton\"]");
//					iOSLogs.CapturedLogs(info, "Save Name button found");
//					return SaveName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Save Name button not found");
//					return null;
//				}
//			}
//			
//			
//
//
//			public WebElement OpenEditEmail() throws Exception {
//				if (findExtrasPageSource("Email")) {
//					WebElement OpenEditEmail = Capabilities.driver
//							.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_email\"]");
//					iOSLogs.CapturedLogs(info, "Edit Email found");
//					return OpenEditEmail;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Email not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement editEmailAddress() throws Exception {
//				if (findExtrasPageSource("Edit email")) {
//					WebElement editEmailAddress = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_email_edittext\"]");
//					iOSLogs.CapturedLogs(info, "Email Address edit textbox found");
//					return editEmailAddress;
//				} else {
//					iOSLogs.CapturedLogs(info, "Email Address edit textbox not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement SaveEmail() throws Exception {
//				if (findExtrasPageSource("Save")) {
//					WebElement SaveEmail = Capabilities.driver
//							.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/saveEmailButton\"]");
//					iOSLogs.CapturedLogs(info, "Save Email button found");
//					return SaveEmail;
//				} else {
//					iOSLogs.CapturedLogs(info, "Save Email button not found");
//					return null;
//				}
//			}
//			
//			
//			public WebElement OpenEditMobilePhone() throws Exception {
//				if (findExtrasPageSource("Mobile")) {
//					WebElement OpenEditName = Capabilities.driver
//							.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_mobile_number\"]");
//					iOSLogs.CapturedLogs(info, "Edit Mobile found");
//					return OpenEditName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Mobile not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement EditMobilePhone() throws Exception {
//				if (findExtrasPageSource("Edit mobile")) {
//					WebElement OpenEditName = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_phone_edittext\"]");
//					iOSLogs.CapturedLogs(info, "Edit Mobile phone textbox found");
//					return OpenEditName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Mobile phone textbox not found");
//					return null;
//				}
//			}
//				
//
//			public WebElement SavePhone() throws Exception {
//				if (findExtrasPageSource("Save")) {
//					WebElement SavePhone = Capabilities.driver
//							.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/savePhoneButton\"]");
//					iOSLogs.CapturedLogs(info, "Save Phone button found");
//					return SavePhone;
//				} else {
//					iOSLogs.CapturedLogs(info, "Save Phone button not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement OpenEditHomeAddress() throws Exception {
//				if (findExtrasPageSource("Home")) {
//					WebElement OpenEditName = Capabilities.driver
//							.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_address\"]");
//					iOSLogs.CapturedLogs(info, "Edit Address found");
//					return OpenEditName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Address not found");
//					return null;
//				}
//			}
//			
//					
//			
//			public WebElement EditHomeAddress() throws Exception {
//				if (findExtrasPageSource("Edit home")) {
//					WebElement OpenEditName = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_address_search_edit_text\"]");
//					iOSLogs.CapturedLogs(info, "Edit Address textbox found");
//					return OpenEditName;
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Address textbox not found");
//					return null;
//				}
//			}
//			
//			
//			public WebElement SaveHomeAddress() throws Exception {
//				if (findExtrasPageSource("Save")) {
//					WebElement SavePhone = Capabilities.driver
//							.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/savePhoneButton\"]");
//					iOSLogs.CapturedLogs(info, "Save Home Address button found");
//					return SavePhone;
//				} else {
//					iOSLogs.CapturedLogs(info, "Save Home Address button not found");
//					return null;
//				}
//			}
//			
//			
//
//			public WebElement CloseHomeAddress() throws Exception {
//				if (findExtrasPageSource("Navigate up")) {
//					WebElement CloseHomeAddress = Capabilities.driver
//							.findElementByXPath(imageButton+"\"Navigate up\"]");
//					iOSLogs.CapturedLogs(info, "Close Home Address button found");
//					
//					return CloseHomeAddress;
//				} else {
//					iOSLogs.CapturedLogs(info, "Close Home Address button not found");
//					return null;
//				}
//			}
			
			

			public WebElement closeProfileXButton() throws Exception {
				Thread.sleep(2000);
				if (findExtrasPageSource("Back")) {
					WebElement closeProfileXButton = Capabilities.driver
							.findElementByXPath(elementButton+"\"Back\"]");
					iOSLogs.CapturedLogs(info, "Profile Close X button found");
					return closeProfileXButton;
				} else {
					iOSLogs.CapturedLogs(info, "Profile Close X button not found");
					return null;
				}
			}
			
			public WebElement SmartFundsAlertsButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("SmartFunds alert settings")) {
					WebElement SmartFundsAlertsButton = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"SmartFunds alert settings\"]");
					iOSLogs.CapturedLogs(info, "SmartFunds Alert settings button is found");
					return SmartFundsAlertsButton;
				} else {
					iOSLogs.CapturedLogs(info, "SmartFunds Alert settings is not found");
					return null;
				}
			}
			
			
			public WebElement SmartFundsAlertsCloseButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Back")) {
					WebElement SmartFundsAlertsCloseButton = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Back\"]");
					iOSLogs.CapturedLogs(info, "SmartFunds Alert close is found");
					return SmartFundsAlertsCloseButton;
				} else {
					iOSLogs.CapturedLogs(info, "SmartFunds Alert close is not found");
					return null;
				}
			}
			
			
			
			public WebElement SmartFundsstatementsButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("SmartFunds statements")) {
					WebElement SmartFundsstatementsButton = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"SmartFunds statements\"]");
					iOSLogs.CapturedLogs(info, "Statement button is found");
					return SmartFundsstatementsButton;
				} else {
					iOSLogs.CapturedLogs(info, "Statement button is not found");
					return null;
				}
			}
			
			
			public WebElement SmartFundsstatementsCloseButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Back")) {
					WebElement SmartFundsstatementsCloseButton = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Back\"]");
					iOSLogs.CapturedLogs(info, "Statement close button is found");
					return SmartFundsstatementsCloseButton;
				} else {
					iOSLogs.CapturedLogs(info, "Statement close button is not found");
					return null;
				}
			}
			
			
			


			public WebElement TouchIDBiometricsToggle() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Biometrics Toggle")) {
					WebElement TouchIDBiometricsToggle = Capabilities.driver
							.findElementByXPath(SwitchName+"\"Biometrics Toggle\"]");
					iOSLogs.CapturedLogs(info, "Biometrics toggle is found");
					return TouchIDBiometricsToggle;
				} else {
					iOSLogs.CapturedLogs(info, "Biometrics toggle is not found");
					return null;
				}
			}
			
			
			public WebElement TouchIDBiometricsToggleDenyModal() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Cancel")) {
					WebElement TouchIDBiometricsToggleDenyModal = Capabilities.driver
							.findElementByXPath(elementButton+"\"Cancel\"]");
					iOSLogs.CapturedLogs(info, "Biometrics Deny toggle is found");
					return TouchIDBiometricsToggleDenyModal;
				} else {
					iOSLogs.CapturedLogs(info, "Biometrics Deny toggle is not found");
					return null;
				}
			}

			
			public WebElement SecurityQuestions() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Security questions")) {
					WebElement SecurityQuestions = Capabilities.driver
							.findElementByXPath(elementButton+"\"Security questions\"]");
					iOSLogs.CapturedLogs(info, "Security questions button is found");
					return SecurityQuestions;
				} else {
					iOSLogs.CapturedLogs(info, "Security questions button is not found");
					return null;
				}
			}
//			
//			public WebElement OpenSecurityQuestionOne() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Question 1")) {
//					WebElement OpenSecurityQuestionOne = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"Question 1\"]");
//					iOSLogs.CapturedLogs(info, "Security questions one button is found");
//					return OpenSecurityQuestionOne;
//				} else {
//					iOSLogs.CapturedLogs(info, "Security questions one button is not found");
//					return null;
//				}
//			}
//			
//					
//				
//			public WebElement PickNewSecurityQuesrtionOne() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Choose question")) {
//					WebElement PickNewSecurityQuesrtionOne = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"What is your mother's maiden name?\"]");
//					iOSLogs.CapturedLogs(info, "New security questions one is found");
//					return PickNewSecurityQuesrtionOne;
//				} else {
//					iOSLogs.CapturedLogs(info, "New security questions one is not found");
//					return null;
//				}
//			}
//			
//			public WebElement CloseNewSecurityOne() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Close")) {
//					WebElement CloseNewSecurityOne = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"Close\"]");
//					iOSLogs.CapturedLogs(info, "Close new security questions one button is found");
//					return CloseNewSecurityOne;
//				} else {
//					iOSLogs.CapturedLogs(info, "Close new security questions one is not found");
//					return null;
//				}
//			}
//
//			public WebElement AnswerSecurityQuestionOne() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Security")) {
//					WebElement AnswerSecurityQuestionOne = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/answer_selected_edit_text\"]");
//					iOSLogs.CapturedLogs(info, "Security questions one textbox button is found");
//					return AnswerSecurityQuestionOne;
//				} else {
//					iOSLogs.CapturedLogs(info, "Security questions one textbox is not found");
//					return null;
//				}
//			}
//			
//			
//
//			public WebElement SaveSecurityQuestions() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Save")) {
//					WebElement AnswerSecurityQuestionOne = Capabilities.driver
//							.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/security_question_save_button\"]");
//					iOSLogs.CapturedLogs(info, "Security questions Save button is found");
//					return AnswerSecurityQuestionOne;
//				} else {
//					iOSLogs.CapturedLogs(info, "Security questions Save is not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement OpenSecurityQuestionTwo() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Question 2")) {
//					WebElement OpenSecurityQuestionTwo = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"Question 2\"]");
//					iOSLogs.CapturedLogs(info, "Security questions two button is found");
//					return OpenSecurityQuestionTwo;
//				} else {
//					iOSLogs.CapturedLogs(info, "Security questions two button is not found");
//					return null;
//				}
//			}
//			
//			
//			public WebElement OpenNewSecurityQuesrtionTwo() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Security question 1")) {
//					WebElement OpenNewSecurityQuesrtionTwo = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/question_select_edit_text\"]");
//					iOSLogs.CapturedLogs(info, "Open new security questions two is found");
//					return OpenNewSecurityQuesrtionTwo;
//				} else {
//					iOSLogs.CapturedLogs(info, "Open new security questions two is not found");
//					return null;
//				}
//			}
//			
//
//			
//
//			public WebElement PickNewSecurityQuesrtionTwo() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Choose question")) {
//					WebElement PickNewSecurityQuesrtionTwo = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"What was your childhood nickname?\"]");
//					iOSLogs.CapturedLogs(info, "New security questions teo is found");
//					return PickNewSecurityQuesrtionTwo;
//				} else {
//					iOSLogs.CapturedLogs(info, "New security questions two is not found");
//					return null;
//				}
//			}
//			
//			public WebElement CloseNewSecuritytwo() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Close")) {
//					WebElement CloseNewSecuritytwo = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"Close\"]");
//					iOSLogs.CapturedLogs(info, "Close security questions two button is found");
//					return CloseNewSecuritytwo;
//				} else {
//					iOSLogs.CapturedLogs(info, "Close security questions two is not found");
//					return null;
//				}
//			}
//			
//			public WebElement AnswerSecurityQuestionTwo() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Security")) {
//					WebElement AnswerSecurityQuestionTwo = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/answer_selected_edit_text\"]");
//					iOSLogs.CapturedLogs(info, "Security questions two textbox button is found");
//					return AnswerSecurityQuestionTwo;
//				} else {
//					iOSLogs.CapturedLogs(info, "Security questions two textbox is not found");
//					return null;
//				}
//			}
//			
//			public WebElement OpenSecurityQuestionThree() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Question 3")) {
//					WebElement OpenSecurityQuestionThree = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"Question 3\"]");
//					iOSLogs.CapturedLogs(info, "Security questions three button is found");
//					return OpenSecurityQuestionThree;
//				} else {
//					iOSLogs.CapturedLogs(info, "Security questions three button is not found");
//					return null;
//				}
//			}
//			
//			
//			public WebElement OpenNewSecurityQuesrtionThree() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Security question 1")) {
//					WebElement OpenNewSecurityQuesrtionThree = Capabilities.driver
//							.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/question_select_edit_text\"]");
//					iOSLogs.CapturedLogs(info, "Open new security questions three is found");
//					return OpenNewSecurityQuesrtionThree;
//				} else {
//					iOSLogs.CapturedLogs(info, "Open new security questions three is not found");
//					return null;
//				}
//			}
//			
//
//			public WebElement PickNewSecurityQuesrtionThree() throws Exception {
//				 Thread.sleep(2000);
//				if (findExtrasPageSource("Choose question")) {
//					WebElement PickNewSecurityQuesrtionThree = Capabilities.driver
//							.findElementByXPath(textViewXpath+"\"What is your favorite movie?\"]");
//					iOSLogs.CapturedLogs(info, "New security questions thee is found");
//					return PickNewSecurityQuesrtionThree;
//				} else {
//					iOSLogs.CapturedLogs(info, "New security questions three is not found");
//					return null;
//				}
//			}
			
			public WebElement CloseNewSecuritythree() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Back")) {
					WebElement CloseNewSecuritythree = Capabilities.driver
							.findElementByXPath(elementButton+"\"Back\"]");
					iOSLogs.CapturedLogs(info, "Close security questions three button is found");
					return CloseNewSecuritythree;
				} else {
					iOSLogs.CapturedLogs(info, "Close security questions three is not found");
					return null;
				}
			}
			
			public WebElement AnswerSecurityQuestionThree() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Security questions")) {
					WebElement AnswerSecurityQuestionThree = Capabilities.driver
							.findElementByXPath(elementButton+"\"Security questions\"]");
					iOSLogs.CapturedLogs(info, "Security questions three textbox button is found");
					return AnswerSecurityQuestionThree;
				} else {
					iOSLogs.CapturedLogs(info, "Security questions three textbox is not found");
					return null;
				}
			}
			
			
			public WebElement CloseSecurityQuestionPage() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Back")) {
					WebElement CloseSecurityQuestionPage = Capabilities.driver
							.findElementByXPath(elementButton+"\"Back\"]");
					iOSLogs.CapturedLogs(info, "Close Security questions button is found");
					return CloseSecurityQuestionPage;
				} else {
					iOSLogs.CapturedLogs(info, "Close Security questions is not found");
					return null;
				}
			}
			
			
			
			

			public WebElement PrivacyPolicy() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Privacy Policy Row Button")) {
					WebElement PrivacyPolicy = Capabilities.driver
							.findElementByXPath(elementButton+"\"Privacy Policy Row Button\"]");
					iOSLogs.CapturedLogs(info, "Privacy Policy is found");
					return PrivacyPolicy;
				} else {
					iOSLogs.CapturedLogs(info, "Privacy Policy is not found");
					return null;
				}
			}
			
			
			public WebElement PrivacyPolicyClose() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Home")) {
					WebElement PrivacyPolicyClose = Capabilities.driver
							.findElementByXPath(elementButton+"\"Account Home Button\"]");
					iOSLogs.CapturedLogs(info, "Privacy Policy close button is found");
					return PrivacyPolicyClose;
				} else {
					iOSLogs.CapturedLogs(info, "Privacy Policy close Button is not found");
					return null;
				}
			}
			
			
			public WebElement TermsOfUse() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Terms Of Use Row Button")) {
					WebElement TermsOfUse = Capabilities.driver
							.findElementByXPath(elementButton+"\"Terms Of Use Row Button\"]");
					iOSLogs.CapturedLogs(info, "Privacy Policy Button is found");
					return TermsOfUse;
				} else {
					iOSLogs.CapturedLogs(info, "Privacy Policy Button is not found");
					return null;
				}
			}
			
			
			public WebElement TermsOfUseClose() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Account Home Button")) {
					WebElement TermsOfUseClose = Capabilities.driver
							.findElementByXPath(elementButton+"\"Account Home Button\"]");
					iOSLogs.CapturedLogs(info, "Terms of use close button is found");
					return TermsOfUseClose;
				} else {
					iOSLogs.CapturedLogs(info, "Terms of use close Button is not found");
					return null;
				}
			}
			
			

			public WebElement CallCustomerSupportButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Customer Support Button")) {
					WebElement CallCustomerSupportButton = Capabilities.driver
							.findElementByXPath(elementButton+"\"Customer Support Button\"]");
					iOSLogs.CapturedLogs(info, "Call Customer support button is found");
					return CallCustomerSupportButton;
				} else {
					iOSLogs.CapturedLogs(info, "Call Customer support button is not found");
					return null;
				}
			}		
			
			public WebElement CloseCustomerSupportButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Cancel")) {
					WebElement CloseCustomerSupportButton = Capabilities.driver
							.findElementByXPath(elementButton+"\"Cancel\"]");
					iOSLogs.CapturedLogs(info, "Close Customer support button is found");
					return CloseCustomerSupportButton;
				} else {
					iOSLogs.CapturedLogs(info, "Close Customer support button is not found");
					return null;
				}
			}		


			
			public WebElement AppVersionHomeAccountPage() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("CardControl")) {
					String version = "CardControl";
					//WebElement AppVersionHomeAccountPage = Capabilities.driver.findElementByXPath(staticText+"\"CardControl v5.0.0\"]");
					//WebElement  AppVersionHomeAccountPage = Capabilities.driver.findElementByXPath(findSomethingLike +"\"CardControl v\"')]");
					WebElement  AppVersionHomeAccountPage = Capabilities.driver.findElementByXPath(findSomethingLike + version+"')]");
					
					iOSLogs.CapturedLogs(info, "App version is found");
					return AppVersionHomeAccountPage;
				} else {
					iOSLogs.CapturedLogs(info, "App version is not found");
					return null;
				}
			}	
			
			

			public WebElement HelpScreenOpenButton() throws Exception {
				 Thread.sleep(2000);
				if (findExtrasPageSource("Help Screens Row Button")) {
					WebElement HelpScreenOpenButton = Capabilities.driver
							.findElementByXPath(elementButton+"\"Help Screens Row Button\"]");
					iOSLogs.CapturedLogs(info, "Help Screens button from home page is found");
					return HelpScreenOpenButton;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens button from home page is not found");
					return null;
				}
			}
			

			public WebElement HelpScreensHome() throws Exception {
					if (findExtrasPageSource("Home")) {
					WebElement HelpScreensHome = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Home\"]");
					iOSLogs.CapturedLogs(info, "Help Screens home button is found");
					return HelpScreensHome;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens button home button is not found");
					return null;
				}
			}
			

			public WebElement HelpScreensAccount() throws Exception {
				
				if (findExtrasPageSource("Account")) {
					WebElement HelpScreensAccount = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Account\"]");
					iOSLogs.CapturedLogs(info, "Help Screens acccount button is found");
					return HelpScreensAccount;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens account button is not found");
					return null;
				}
			}
			

			public WebElement HelpScreensTransactions() throws Exception {
				
				if (findExtrasPageSource("Transactions")) {
					WebElement HelpScreensTransactions = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Transactions\"]");
					iOSLogs.CapturedLogs(info, "Help Screens transations button is found");
					return HelpScreensTransactions;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens transations button is not found");
					return null;
				}
			}
			
			

			public WebElement HelpScreensFindFuelNearby() throws Exception {
				
				if (findExtrasPageSource("Find Fuel Nearby")) {
					WebElement HelpScreensFindFuelNearby = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Find Fuel Nearby\"]");
					iOSLogs.CapturedLogs(info, "Help Screens find fuel nearby button is found");
					return HelpScreensFindFuelNearby;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens find fuel nearby button is not found");
					return null;
				}
			}
			
			

			public WebElement HelpScreensFindFuelPlanATrip() throws Exception {
			
				if (findExtrasPageSource("Find Fuel Plan A Trip")) {
					WebElement HelpScreensFindFuelPlanATrip = Capabilities.driver
							.findElementByXPath(elementButtonLabel+"\"Find Fuel Plan A Trip\"]");
					iOSLogs.CapturedLogs(info, "Help Screens find fuel plan a trip button is found");
					return HelpScreensFindFuelPlanATrip;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens find fuel plan a trip button is not found");
					return null;
				}
			}
			
			
			public WebElement HelpScreensCloseButton() throws Exception {
			
				if (findExtrasPageSource("Back")) {
					WebElement HelpScreensCloseButton = Capabilities.driver
							.findElementByXPath(elementButton+"\"Back Button\"]");
							iOSLogs.CapturedLogs(info, "Help Screens close button is found");
					return HelpScreensCloseButton;
				} else {
					iOSLogs.CapturedLogs(info, "Help Screens close button is not found");
					return null;
				}
			}	
			
			
			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

			// Web Elements for Environment Picker page
			
			public WebElement PartnerButton() throws Exception {
				if (findExtrasPageSource("Partner")) {
					WebElement PartnerButton = Capabilities.driver
							.findElementByXPath(elementButton+"\"Partner\"]");
					iOSLogs.CapturedLogs(info, "Partner environment button found");
					return PartnerButton;
				} else {
					iOSLogs.CapturedLogs(info,
							"Partner environment Button not found could be that you already chose an environment");
					return null;
				}
			}
			

			//Web Elements for Environment Picker page
		public WebElement ACPTButton() throws Exception {
			if (findExtrasPageSource("ACPT")) {
				WebElement ACPTButton = Capabilities.driver.findElementByXPath(elementButton+"\"ACPT\"]");
				
				iOSLogs.CapturedLogs(info, "ACPT Test button found");
				return ACPTButton;
			} else {
				iOSLogs.CapturedLogs(info, "ACPT Test Environment Button not found could be that you already chose an invorement");
				return null;
			}
			}
		
		
		public WebElement AWSSITButton() throws Exception {
			if (findExtrasPageSource("AWS SIT")) {
				WebElement AWSSITButton = Capabilities.driver.findElementByXPath(elementButton+"\"AWS SIT\"]");
				
				iOSLogs.CapturedLogs(info, "Test button found");
				return AWSSITButton;
			} else {
				iOSLogs.CapturedLogs(info, "Test Environment Button not found could be that you already chose an invorement");
				return null;
			}
			}
		
		public WebElement SITAWSButton() throws Exception {
			if (findExtrasPageSource("AWS SIT")) {
				WebElement SITAWSButton = Capabilities.driver
						.findElementByXPath(elementButton+"\"AWS SIT\"]");
				iOSLogs.CapturedLogs(info, "SIT AWS environment button found");
				return SITAWSButton;
			} else {
				iOSLogs.CapturedLogs(info,
						"SIT AWS environment Button not found could be that you already chose an invorement");
				return null;
			}
		}
		

		public WebElement DITAWSButton() throws Exception {
			if (findExtrasPageSource("AWS DIT")) {
				WebElement SITAWSButton = Capabilities.driver
						.findElementByXPath(elementButton+"\"AWS DIT\"]");
				iOSLogs.CapturedLogs(info, "DIT AWS environment button found");
				return SITAWSButton;
			} else {
				iOSLogs.CapturedLogs(info,
						"DIT AWS environment Button not found could be that you already chose an invorement");
				return null;
			}
		}
		
		public WebElement DITButton() throws Exception {
			WebElement DITButton = Capabilities.driver.findElementByXPath(elementButton+"\"DIT\"]");
			iOSLogs.CapturedLogs(info, "DIT button found");
			return DITButton;
		}
		
		public WebElement DEVButton() throws Exception {
			WebElement DEVButton = Capabilities.driver.findElementByXPath(elementButton+"\"Dev\"]");
			iOSLogs.CapturedLogs(info, "Dev button found");
			return DEVButton;
		}
		
				
		
		public WebElement StartButton() throws Exception {
			if (findExtrasPageSource("Start Button")) {
				WebElement StartButton = Capabilities.driver.findElementByXPath(elementButton+"\"Start Button\"]");
				iOSLogs.CapturedLogs(info, "Start Button found");
				return StartButton;
			} else {
				iOSLogs.CapturedLogs(info, "Start Button not found");
				return null;
			}
		}	
		
		
		public WebElement StartButtonCarrier() throws Exception {
			if (findExtrasPageSource("Start")) {
				WebElement StartButtonCarrier = Capabilities.driver.findElementByXPath(elementButton+"\"Start\"]");
				iOSLogs.CapturedLogs(info, "Start Button found");
				return StartButtonCarrier;
			} else {
				iOSLogs.CapturedLogs(info, "Start Button not found");
				return null;
			}
		}	
		
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// Web Elements for MultiCard Login Page	

public WebElement EditPencilButton() throws Exception {
	
	if (findExtrasPageSource("Edit")) {
		WebElement EditPencilButton = Capabilities.driver.findElementByXPath(elementButton+"\"Edit\"]");
		iOSLogs.CapturedLogs(info, "Edit pencil Button found");
		return EditPencilButton;
	} else {
		iOSLogs.CapturedLogs(info, "Edit pencil Button not found");
		return null;
	}
}


public WebElement XCloseButton() throws Exception {
	
	if (findExtrasPageSource("Cancel")) {
		WebElement XCloseButton = Capabilities.driver.findElementByXPath(elementButton+"\"Cancel\"]");
		iOSLogs.CapturedLogs(info, "X close Button found");
		return XCloseButton;
	} else {
		iOSLogs.CapturedLogs(info, "X close Button not found");
		return null;
	}
}


public WebElement RemoveCardButton() throws Exception {

if (findExtrasPageSource("Remove card")) {
WebElement RemoveCardButton = Capabilities.driver.findElementByXPath(elementButton+"\"Remove card\"]");
iOSLogs.CapturedLogs(info, "Remove card Button found");
return RemoveCardButton;
} else {
iOSLogs.CapturedLogs(info, "Remove card Button not found");
return null;
}
}


WebElement MultiCardSelector(String cardNumAndCarrierID) throws Exception {
	
	if (findLoginPageElement("•••• " + cardNumAndCarrierID)) {
		String cardNum;
		String carrrierName;
		
		WebElement MultiCardSelector = Capabilities.driver.findElementByXPath(elementButtonLabel+"\"•••• "+cardNumAndCarrierID+"\"]");

		iOSLogs.CapturedLogs(info, "MultiCard Selector for " +cardNumAndCarrierID+ " found");
		return MultiCardSelector;
	} else {
		iOSLogs.CapturedLogs(info, "MultiCard Selector for " +cardNumAndCarrierID+ " not found");
		return null;
	}
}
	



public WebElement MultiCardPinPassTextBox() throws Exception {
	if (findExtrasPageSource("PIN or passcode")) {
		WebElement MultiCardPinPassTextBox = Capabilities.driver
				.findElementByXPath(secureText+"\"PIN or passcode\"]");
		iOSLogs.CapturedLogs(info, " MultiCard PIN or Passcode text box found");
		return MultiCardPinPassTextBox;
	} else {
		iOSLogs.CapturedLogs(info, "MultiCard PIN or Passcode text box not found");
		return null;
	}
}

public WebElement MultiCardLoginButton() throws Exception {
	
	if (findExtrasPageSource("Log in")) {
		WebElement MultiCardLoginButton = Capabilities.driver.findElementByXPath(elementButton+"\"Login Button\"]");
			
		iOSLogs.CapturedLogs(info, "MultiCard Log in button found");
		return MultiCardLoginButton;
	} else {
		iOSLogs.CapturedLogs(info, "MultiCard Log in button not found");
		return null;
	}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// Wex Connect 	


public WebElement ServiceTab() throws Exception {
	
	if (findExtrasPageSource("Service")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(elementButton+"\"Service\"]");
		iOSLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		iOSLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}

public WebElement ChargeTab() throws Exception {
	
	if (findExtrasPageSource("Charge")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(elementButton+"\"Charge\"]");
		iOSLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		iOSLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}

public WebElement CarWashTab() throws Exception {
if (findExtrasPageSource("Carwash")) {
	WebElement ServiceTab = Capabilities.driver
			.findElementByXPath(elementButton+"\"Carwash\"]");
	iOSLogs.CapturedLogs(info, "Carwash Tab found");
	return ServiceTab;
} else {
	iOSLogs.CapturedLogs(info, "Carwash Tab not found");
	return null;
}
}

public WebElement GasTab() throws Exception {
if (findExtrasPageSource("Gas")) {
	WebElement GasTab = Capabilities.driver
			.findElementByXPath(elementButton+"\"Gas\"]");
	iOSLogs.CapturedLogs(info, "Gas Tab found");
	return GasTab;
} else {
	iOSLogs.CapturedLogs(info, "Gas Tab not found");
	return null;
}
}


public WebElement MoreTab() throws Exception {
if (findExtrasPageSource("More")) {
	WebElement MoreTab = Capabilities.driver
			.findElementByXPath(elementButton+"\"More\"]");
	iOSLogs.CapturedLogs(info, "More Tab found");
	return MoreTab;
} else {
	iOSLogs.CapturedLogs(info, "More Tab not found");
	return null;
}
}


public WebElement SearchNearby() throws Exception {
	
	if (findExtrasPageSource("Search Nearby")) {
		WebElement SearchNearby = Capabilities.driver
				.findElementByXPath(searchField+"\"Search Nearby\"]");
		iOSLogs.CapturedLogs(info, "Search nearby textbox found");
		return SearchNearby;
	} else {
		iOSLogs.CapturedLogs(info, "Search nearby textbox not found");
		return null;
	}
}


public WebElement SearchNearbyWithText(String loc) throws Exception {
	String location = loc;
	if (findExtrasPageSource(location)) {
		WebElement SearchNearby = Capabilities.driver
				.findElementByXPath(searchField+"\""+location+"\"]");
		iOSLogs.CapturedLogs(info, "Search nearby textbox found");
		return SearchNearby;
	} else {
		iOSLogs.CapturedLogs(info, "Search nearby textbox not found");
		return null;
	}
}



public WebElement SearchNearbyTextBox() throws Exception {
	if (findExtrasPageSource("Where do you want to search?")) {
		WebElement SearchNearbyTextBox = Capabilities.driver
				.findElementByXPath(searchField+"\"Where do you want to search?\"]");
		iOSLogs.CapturedLogs(info, "Search nearby textbox found");
		return SearchNearbyTextBox;
	} else {
		iOSLogs.CapturedLogs(info, "Search nearby textbox not found");
		return null;
	}
}

public WebElement SelectLocation(String loc) throws Exception {
	String location = loc;
	if (findExtrasPageSource(location)) {
		WebElement SelectLocation = Capabilities.driver
				.findElementByXPath(staticText+"\""+location+"\"]");
		iOSLogs.CapturedLogs(info, "Searched location found");
		return SelectLocation;
	} else {
		iOSLogs.CapturedLogs(info, "Searched location  not found");
		return null;
	}
}


public WebElement MapButton() throws Exception {
	if (findExtrasPageSource("Map")) {
		WebElement MapButton = Capabilities.driver
				.findElementByXPath(elementButton+"\"Map\"]");
		iOSLogs.CapturedLogs(info, "Map Button found");
		return MapButton;
	} else {
		iOSLogs.CapturedLogs(info, "Map Button not found");
		return null;
	}
}

public WebElement ListViewButton() throws Exception {
	if (findExtrasPageSource("List")) {
		WebElement ListViewButton = Capabilities.driver
				.findElementByXPath(elementButton+"\"List\"]");
		iOSLogs.CapturedLogs(info, "List View button found");
		return ListViewButton;
	} else {
		iOSLogs.CapturedLogs(info, "List View button not found");
		return null;
	}
}

//MORE PAGE 

public WebElement WexConnectPromoCodesButton() throws Exception {
	if (findExtrasPageSource("Promo codes")) {
		WebElement WexConnectPromoCodesButton = Capabilities.driver
				.findElementByXPath(staticText+"\"Promo codes\"]");
		iOSLogs.CapturedLogs(info, "Promo codes Button found");
		return WexConnectPromoCodesButton;
	} else {
		iOSLogs.CapturedLogs(info, "Promo codes Button not found");
		return null;
	}
}


public WebElement WCDoneButton() throws Exception {
	if (findExtrasPageSource("Done")) {
		WebElement WCDoneButton = Capabilities.driver
				.findElementByXPath(elementButton+"\"Done\"]");
		iOSLogs.CapturedLogs(info, "Done Button found");
		return WCDoneButton;
	} else {
		iOSLogs.CapturedLogs(info, "Done Button not found");
		return null;
	}
}




public WebElement WexConnectPromoCodeTextBox(String promoCode) throws Exception {
	if (findExtrasPageSource("enter code")) {
		WebElement WexConnectPromoCodeTextBox = Capabilities.driver
				.findElementByXPath(textFieldValue+"\"enter code\"]");
		iOSLogs.CapturedLogs(info, "Promo codes for " + promoCode +" TextBox found");
		return WexConnectPromoCodeTextBox;
	} else {
		iOSLogs.CapturedLogs(info, "Promo codes for " + promoCode +" TextBox not found");
		return null;
	}
}




public WebElement WexConnectPromoCodeEnterCodeButton() throws Exception {
	if (findExtrasPageSource("Enter")) {
		WebElement WexConnectPromoCodeEnterCodeButton = Capabilities.driver
				.findElementByXPath(staticText+"\"Enter\"]");
		iOSLogs.CapturedLogs(info, "Enter Coce Button found");
		return WexConnectPromoCodeEnterCodeButton;
	} else {
		iOSLogs.CapturedLogs(info, "Enter Code Button not found");
		return null;
	}
}


public WebElement WexConnectPromoCodeAddCodeButton() throws Exception {
	if (findExtrasPageSource("add")) {
		WebElement WexConnectPromoCodeAddCodeButton = Capabilities.driver
				.findElementByXPath(elementButton+"\"add\"]");
		iOSLogs.CapturedLogs(info, "Add Promo codes Button found");
		return WexConnectPromoCodeAddCodeButton;
	} else {
		iOSLogs.CapturedLogs(info, "Add Promo codes Button not found");
		return null;
	}
}

//TODO NO SHARE BUTTON FOUND!!!!???
//public WebElement WexConnectShareButton() throws Exception {
//	if (findExtrasPageSource("Share")) {
//		WebElement WexConnectShareButton = Capabilities.driver
//				.findElementByXPath(textViewXpath+"\"Share\"]");
//		iOSLogs.CapturedLogs(info, "Share Button found");
//		return WexConnectShareButton;
//	} else {
//		iOSLogs.CapturedLogs(info, "Share Button not found");
//		return null;
//	}
//}


public WebElement WexConnectTOUButton() throws Exception {
	if (findExtrasPageSource("Terms of Use")) {
		WebElement WexConnectTOUButton = Capabilities.driver
				.findElementByXPath(staticText+"\"Terms of Use\"]");
		iOSLogs.CapturedLogs(info, "Terms of Use Button found");
		return WexConnectTOUButton;
	} else {
		iOSLogs.CapturedLogs(info, "Terms of Use Button not found");
		return null;
	}
}


public WebElement WexConnectPPButton() throws Exception {
	if (findExtrasPageSource("Privacy Policy")) {
		WebElement WexConnectPPButton = Capabilities.driver
				.findElementByXPath(staticText+"\"Privacy Policy\"]");
		iOSLogs.CapturedLogs(info, "Privacy Policy Button found");
		return WexConnectPPButton;
	} else {
		iOSLogs.CapturedLogs(info, "Privacy Policy Button not found");
		return null;
	}
}

public WebElement WCRemovePromoOne() throws Exception {
	if (findExtrasPageSource("Remove")) {
		WebElement WCRemovePromoOne = Capabilities.driver
				.findElementByXPath(elementButton+"\"Remove\"]");
		iOSLogs.CapturedLogs(info, "Promo codes remove one Button found");
		return WCRemovePromoOne;
	} else {
		iOSLogs.CapturedLogs(info, "Promo codes remove one not found");
		return null;
	}
}

public WebElement WCRemovePromoTwo() throws Exception {
	if (findExtrasPageSource("Remove")) {
		WebElement WCRemovePromoTwo = Capabilities.driver
				.findElementByXPath(elementButton+"\"Remove\"]");
		iOSLogs.CapturedLogs(info, "Promo codes remove two Button found");
		return WCRemovePromoTwo;
	} else {
		iOSLogs.CapturedLogs(info, "Promo codes remove two not found");
		return null;
	}
}

public WebElement WCCancelButton() throws Exception {
	if (findExtrasPageSource("Cancel")) {
		WebElement WCDoneButton = Capabilities.driver
				.findElementByXPath(elementButton+"\"Cancel\"]");
		iOSLogs.CapturedLogs(info, "Cancel Button found");
		return WCDoneButton;
	} else {
		iOSLogs.CapturedLogs(info, "Cancel Button not found");
		return null;
	}
}


}