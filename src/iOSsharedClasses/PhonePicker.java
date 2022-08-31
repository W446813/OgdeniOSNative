package iOSsharedClasses;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class PhonePicker {
	Sleep appSleep = new Sleep();
	Wait appWait = new Wait();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	static AppiumDriver<WebElement> driver;
	
	public static String phoneID = "No Phone";
	public static String appName = "No App";
	//public int multiPhone = 0; 
	
	public static String AppName(){
		
		return appName;
		}	
	
	public static String PhoneID(){
		
		return phoneID;
		}

	
		
	
	
	public String autoPhonePickerCard(String appName) throws Exception {
		iOSLogs.setupTest("Phone Picker started");
		//find first device found connected as uses it for automation.
		
		try {
			Capabilities.capabilitiesCardControliPhoneXr(appName);
			appName = "Card Control";
			phoneID = "iPhone Xr";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return "Card Control app Started succesfully on iPhone Xr";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhoneXr Not Plugged in.");
				iOSLogs.CapturedLogs( iOSText.INFO, "Checking Phone: iPhoneXr Not Plugged in");
				
		}
		
		try {
			Capabilities.capabilitiesCardControliPhone12(appName);
			appName = "Card Control";
			phoneID = "iPhone 12";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return "Card Control app Started succesfully on iPhone 12";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone 12 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone 12 Not Plugged in");
				
		}
		
		
		
try {
		Capabilities.capabilitiesCardControliPhone8(appName);
		appName = "Card Control";
		phoneID = "iPhone 8";
	
		
		
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return AppName().toString() + " app Started succesfully on " + PhoneID().toString();
				
		} catch (org.openqa.selenium.WebDriverException e){
			System.out.println("Checking Phone: iPhone 8 Not Plugged in.");
			iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone8 Not Plugged in");
			
	}

try {

			Capabilities.capabilitiesCardControliPhone7(appName);
			appName = "Card Control";
			phoneID = "iPhone 7";
		
		
			
			
				iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
				return AppName().toString() + " app Started succesfully on " + PhoneID().toString();
					
			}catch (org.openqa.selenium.WebDriverException e){
				System.out.println("Checking Phone: iPhone 7 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone7 Not Plugged in");
				
				
		}

			return "Card Control no devices found.";
			

	

} 

	
	public String autoPhonePickerCarrier(String appName) throws Exception {
		
		iOSLogs.setupTest("Phone Picker started");
		//find first device found connected as uses it for automation.
				
		try {
			Capabilities.capabilitiesCarrierControliPhoneXr(appName);
			appName = "Carrier Control";
			phoneID = "iPhone Xr";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return "Carrier Control app Started succesfully on iPhone Xr";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhoneXr Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhoneXr Not Plugged in");
				
		}
		
		try {
			Capabilities.capabilitiesCarrierControliPhone12(appName);
			appName = "Carrier Control";
			phoneID = "iPhone 12";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return "Carrier Control app Started succesfully on iPhone 12";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone 12 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone 12 Not Plugged in");
				
		}
		
		
		
		
		try {
			Capabilities.capabilitiesCarrierControliPhone8(appName);
			appName = "Carrier Control";
			phoneID = "iPhone 8";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return "Carrier Control app Started succesfully on iPhone 8";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone8 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone8 Not Plugged in");
				
		}
		
		try {
			Capabilities.capabilitiesCarrierControliPhone7(appName);
			appName = "Carrier Control";
			phoneID = "iPhone 7";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return "Carrier Control app Started succesfully on iPhone 7";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone7 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone7 Not Plugged in");
				
		}
		

return "Carrier Control no devices found";
} 
	
//WexConnect	
	public String autoPhonePickerWexConnect(String appName) throws Exception {
		iOSLogs.setupTest("Phone Picker started");
		//find first device found connected as uses it for automation.
				
		try {
			Capabilities.capabilitiesWexConnectiPhoneXr(appName);
			appName = "Wex Connect";
			phoneID = "iPhone Xr";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return appName+" app Started succesfully on iPhone Xr";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhoneXr Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhoneXr Not Plugged in");
				
		}
		
		try {
			Capabilities.capabilitiesWexConnectiPhone12(appName);
			appName = "Wex Connect";
			phoneID = "iPhone 12";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return appName+" app Started succesfully on iPhone 12";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone 12 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone 12 Not Plugged in");
				
		}
		
		
		
		
		try {
			Capabilities.capabilitiesWexConnectiPhone8(appName);
			appName = "Wex Connect";
			phoneID = "iPhone 8";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return appName+" app Started succesfully on iPhone 8";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone8 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone8 Not Plugged in");
				
		}
		
		try {
			Capabilities.capabilitiesWexConnectiPhone7(appName);
			appName = "Wex Connect";
			phoneID = "iPhone 7";
			
			iOSLogs.CapturedLogs(iOSText.PASS, AppName().toString() + " running on " + PhoneID().toString());
			return appName+" app Started succesfully on iPhone 7";
			
			}catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: iPhone7 Not Plugged in.");
				iOSLogs.CapturedLogs(iOSText.INFO, "Checking Phone: iPhone7 Not Plugged in");
				
		}
		

return "Wex Connect no devices found";
} 
	
}

