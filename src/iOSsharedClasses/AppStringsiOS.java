package iOSsharedClasses;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import iOSCarrierClasses.InputText;
import iOSCarrierClasses.LocalConfiguration;

public class AppStringsiOS {
	LocalConfiguration TestData;
	Logs iOSLogs = new Logs();
	
	
	public AppStringsiOS(){
		
	}

	
	public AppStringsiOS(String environment)throws Exception {
		System.out.println("Inside of app string android. MY enviroment is: " + environment);
		AppStringsiOS iOSText = new AppStringsiOS();
		int envPicked = 0;


		switch (environment) {
		case "TEST":  envPicked = 1;
		TestData = new LocalConfiguration("iOSTestData.txt");
		iOSLogs.CapturedLogs(iOSText.INFO, "iOSTestData.TXT found");
		break;
		case "PARTNER": envPicked = 2;
		TestData = new LocalConfiguration("iOSPartnerData.txt");
		iOSLogs.CapturedLogs(iOSText.INFO, "PartnerData.TXT found");
		break;
		case "AWSSIT": envPicked = 3;
		TestData = new LocalConfiguration("iOSAWSSITData.txt");
		iOSLogs.CapturedLogs(iOSText.INFO, "AWSSIT.TXT found");
		break;
		case "AWSDIT": envPicked = 4;
		TestData = new LocalConfiguration("iOSAWSDITData.txt");
		iOSLogs.CapturedLogs(iOSText.INFO, "iOSAWSDITData.TXT found");
		break;
		default:
			iOSLogs.CapturedLogs(iOSText.INFO, "No server DATA found to test on.");
		}	
	}
	
	public String getENVData(String DataName) throws IOException {
		System.out.println("Start getting data: " + DataName );
		System.out.println("Start getting data2: " + TestData );
		String configdata = TestData.getConfigurationValue(DataName);

		System.out.println("After data is: " + configdata);
//			return TestData.getConfigurationValue(DataName);
		return configdata;

	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~ID Strings for carrier Control iOS login~~~~~~~~~~~~~~~~//	
	public final String PASS = "Test Pass";
	public final String INFO = "Test Info";
	public final String FAIL = "Test Fail";
	
	//~~~~~~~~~~~~~~~~~~~~~ID Strings for Carrier control Profile iOS login~~~~~~~~~~~~~~~~//	
		public final String PROFILE_FIRST_NAME = "iOS";
		public final String PROFILE_LAST_NAME = "Automation";
		public final String PROFILE_EMAIL = "iOSAutomation@wexinc.com";
		public final String PROFILE_PHONE = "8015555555";
		
//~~~~~~~~~~~~~~~~~~~~~ID Strings for carrier Control iOS login~~~~~~~~~~~~~~~~//	
	public final String CARRIER_LOGIN_ID_SMARTFUNDS = "100045";  	
	public final String CARRIER_LOGIN_ID_SUB_USER = "102698db";
	public final String CARRIER_LOGIN_ID_UNIVERSAL = "129698";	
	public final String CARRIER_LOGIN_ID_COMPANY = "103526";	
	public final String CARRIER_LOGIN_ID_FAIL_EXPECTED = "000000";	
	//public final String CARRIER_LOGIN_ID_LOCKED = "129698";	

//~~~~~~~~~~~~~~~~~~~~~Pass Strings for carrier Control iOS login~~~~~~~~~~~~~~~~//	
	public final String CARRIER_LOGIN_PASSWORD_SMARTFUUNDS = "985477";	
	public final String CARRIER_LOGIN_PASSWORD_SUB_USER = "NGFC123";	
	public final String CARRIER_LOGIN_PASSWORD_UNIVERSAL = "985477";	
	public final String CARRIER_LOGIN_PASSWORD_COMPANY = "985477";	
	public final String CARRIER_LOGIN_PASSWORD_FAIL_EXPECTED = "123456";	
	public final String CARRIER_LOGIN_PASSWORD_LOCKED = "112233";
	public final String CARRIER_LOGIN_PASSWORD_SUSPENDED = "999999";
	public final String CARRIER_PASSWORD_FAIL_EXPECTED = "1111";

	
//~~~~~~~~~~~~~~~~~~~~~Card Num Strings for Card Control iOS login~~~~~~~~~~~~~~~~//	
//	public final String CARDPIN_LOGIN_NUMBER_6344 = "7083050910386616344";
//	public final String SECURITY_QUESTION_CARD_NUM_0065 = "7083059961000200065";
//	public final String CARD_LOGIN_FAIL_EXPECTED = "1234567891234567891";
//	public final String CARD_LOGIN_LOCK_EXPECTED = "7083059961002500561";
//	public final String FORGOT_PIN_PASSCODE_5542 = "7083059810269845542";
//	public final String ACH_PIN_LOGIN_2800 = "7083050612969802800";

//~~~~~~~~~~~~~~~~~~~~~Pin/Passcode Strings for Card Control iOS login~~~~~~~~~~~~~~~~//	
//	public final String CARDPIN_LOGIN_PIN_6344 = "9854";
//	public final String SECURITY_QUESTION_CARD_PIN_0065 = "985477";
//	public final String CARD_LOGIN_PIN_FAIL_EXPECTED = "1111";
//	public final String CARD_LOGIN_PIN_LOCK_EXPECTED = "1111";
//	public final String FORGOT_PIN_PASSCODE_5542_PASSCODE = "985477";
//	public final String ACH_2800_PIN = "9854";
//	public final String SECURE_FUEL_0561_PIN = "9854";
//~~~~~~~~~~~~~~~~~~~~~SecureFuel Strings for Card Control iOS ~~~~~~~~~~~~~~~~//	
	public final String SECURE_FUEL_UNIT_NUMBER = "1234";

	
	// ~~~~~~~~~~~~~~~~~~~~~Profile Setup~~~~~~~~~~~~~~~~//
		public final String FIRST_NAME = "John";
		public final String LAST_NAME = "Wayne";
		public final String DATE_OF_BIRTH = "05051999";
		public final String PHONE_NUMBER = "8608675309";
		public final String EMAIL_ADDRESS = "efs.testers@efsllc.com";
		public final String SOCIAL_SECURITY = "9999";
		public final String HOME_ADDRESS = "1 Hancock Street Portland, ME USA 04101";
		public final String HOME_ADDRESS_LINE_TWO = "Apt 5";
		public final String MANUAL_PASSCODE = "985477";
		//~~~~~~~~~~~~~~~~~~~~~Card Control Register check strings~~~~~~~~~~~~~~~~//
		public final String REGISTER_CHECK_AMOUNT = "1.00";
		public final String REGISTER_CHECK_NUMBER = "1248174135";
		public final String PERCENT_BALANCE_AMOUNT = "2.00";
		public final String PERCENT_TO_TRANSFER = "2";
		//~~~~~~~~~~~~~~~~~~~~~Card Control Transfer funds strings~~~~~~~~~~~~~~~~//
				public final String EDITED_AMOUNT = "1.01";
				public final String TRANSFER_FUNDS_AMOUNT = "22.22";
//~~~~~~~~~~~~~~~~~~~~~Strings for IONIC Cordova logins~~~~~~~~~~~~~~~~//	
	InputText appText = new InputText();
	public String CarrierLoginPasswordTwo() throws Exception {
		
		WebElement carrierLetterc = Capabilities.driver.findElementByAccessibilityId("c");
		WebElement carrierLettera = Capabilities.driver.findElementByAccessibilityId("a");
		WebElement carrierLetterp = Capabilities.driver.findElementByAccessibilityId("p");
	
		carrierLetterc.click();
		carrierLettera.click();
		carrierLetterp.click();
		
	
		
		WebElement pass1 = Capabilities.driver.findElementByAccessibilityId(("9"));
		WebElement pass2 = Capabilities.driver.findElementByAccessibilityId(("8"));
		WebElement pass3 = Capabilities.driver.findElementByAccessibilityId(("5"));
		WebElement pass4 = Capabilities.driver.findElementByAccessibilityId(("4"));
		WebElement pass5 = Capabilities.driver.findElementByAccessibilityId(("7"));
		
		
		pass1.click();
		pass2.click();
		pass3.click();
		pass4.click();
		pass5.click();
		
		String CarrierLoginPassword = "cap98547";
		return CarrierLoginPassword;
	}
		
		public String CarrierLoginIdFail() throws Exception {

			String CarrierLoginIdFail = "000000";
			return CarrierLoginIdFail;
		}
		
		public String CarrierControlLetterPassword() throws Exception {
			WebElement carrierLetterc = Capabilities.driver.findElementByAccessibilityId("c");
			WebElement carrierLettera = Capabilities.driver.findElementByAccessibilityId("a");
			WebElement carrierLetterp = Capabilities.driver.findElementByAccessibilityId("p");
		
			
			carrierLetterc.click();
			carrierLettera.click();
			carrierLetterp.click();
			
			String CarrierControlLetterPassword = "cap";
			return CarrierControlLetterPassword;
		}

	//login username or card is right pass or pin is wrong
	public String CardControlNumberLock() throws Exception {

		WebElement cardNumbers1 = Capabilities.driver.findElementByAccessibilityId(appText.Number7());
		WebElement cardNumbers2 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
		WebElement cardNumbers3 = Capabilities.driver.findElementByAccessibilityId(appText.Number8());
		WebElement cardNumbers4 = Capabilities.driver.findElementByAccessibilityId(appText.Number3());
		WebElement cardNumbers5 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
		WebElement cardNumbers6 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
		WebElement cardNumbers7 = Capabilities.driver.findElementByAccessibilityId(appText.Number9());
		WebElement cardNumbers8 = Capabilities.driver.findElementByAccessibilityId(appText.Number9());
		WebElement cardNumbers9 = Capabilities.driver.findElementByAccessibilityId(appText.Number6());
		WebElement cardNumbers10 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
		WebElement cardNumbers11 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
		WebElement cardNumbers12 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
		WebElement cardNumbers13 = Capabilities.driver.findElementByAccessibilityId(appText.Number2());
		WebElement cardNumbers14 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
		WebElement cardNumbers15 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
		WebElement cardNumbers16 = Capabilities.driver.findElementByAccessibilityId(appText.Number0());
		WebElement cardNumbers17 = Capabilities.driver.findElementByAccessibilityId(appText.Number5());
		WebElement cardNumbers18 = Capabilities.driver.findElementByAccessibilityId(appText.Number6());
		WebElement cardNumbers19 = Capabilities.driver.findElementByAccessibilityId(appText.Number1());
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
		String CardControlNumberLock = "7083059961002500561";
		return CardControlNumberLock;
	}
	public String cardControlPinLock() throws Exception {

		String cardControlPinLock = "1111";
		return cardControlPinLock;
	}
	
	public String CardControlNumber() throws Exception {

		String cardControlCard = "56678";
		return cardControlCard;
	}
	
	public String cardControlPin() throws Exception {

		String cardControlPin = "1070";
		return cardControlPin;
	}
	
	public String CardControlNumberFail() throws Exception {

		String CardControlNumberFail = "1234567891234567891";
		return CardControlNumberFail;
	}
	public String cardControlPinFail() throws Exception {

		String cardControlPinFail = "1111";
		return cardControlPinFail;
	}
	
}