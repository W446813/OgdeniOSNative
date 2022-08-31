package iOSsharedClasses;

import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import iOSCardClasses.RepoCardiOS;
import io.appium.java_client.AppiumDriver;


public class Capabilities {
	


	public static AppiumDriver<WebElement> driver;
	//static AppiumDriver<WebElement> iphone7;
	//static RemoteWebDriver driver = null;
	
	public static String phoneID = "No Phone";
	public static String appName = "No App";
	//public int multiPhone = 0; 
	public static AppStringsiOS iOSText = new AppStringsiOS();
	public static RepoCardiOS elements = new RepoCardiOS();
	public static Logs iOSLogs = new Logs();
	
	public static String pass = iOSText.PASS;
	public static String fail = iOSText.FAIL;
	public static String info = iOSText.INFO;
	
	
	public static String AppName(){
		
		return appName;
		}	
	
	public static String phoneID(){
		
		return phoneID;
		}

//Start of iPhone Carrier Control Capabilities.
	public static void capabilitiesCarrierControliPhoneXr(String appName) throws Exception {
		iOSLogs.CapturedLogs(info, "Finding Device capabilities");
		phoneID = "iPhone XR";
		DesiredCapabilities cap = new DesiredCapabilities();
		
					
		cap.setCapability("BROWSER_NAME", "safari");
		cap.setCapability("platformVersion", "14.4");
		cap.setCapability("udid", "00008020-0002199E36D8003A");
		
		cap.setCapability("deviceName", "iPhone Xʀ");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("noReset",true);
		cap.setCapability("usePrebuiltWDA",true);
	
		cap.setCapability("app", "com.efs.EFS-MWA-Carrier.test");
	
	   
		cap.setCapability("appWaitDuration", "3000");
		cap.setCapability("newCommandTimeout", 60 * 5);
		

		// app open in appium
		iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
		//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

				
		// shows it ran through here
		System.out.println("Ran trhough PhoneCap");
		appName = "Carrier Control";
		phoneID = "iPhone XR";
		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
	}
	
	
	
		public static void capabilitiesCarrierControliPhone7(String appName) throws Exception {
			iOSLogs.CapturedLogs(info, "Finding Device capabilities");
			phoneID = "iPhone 7";
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("BROWSER_NAME", "safari");
			cap.setCapability("platformVersion", "12.0.1");
			cap.setCapability("udid", "256303487ebe5471ca758da0e95d27634f45bf5c");
			cap.setCapability("deviceName", "iPhone 7");
			cap.setCapability("platformName", "iOS");
			cap.setCapability("noReset",false);
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("usePrebuiltWDA",true);
			cap.setCapability("app", "com.efs.EFS-MWA-Carrier");
			cap.setCapability("appWaitDuration", "3000");
			cap.setCapability("newCommandTimeout", 60 * 5);

			// app open in appium
			iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
			driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);			
			//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

					
			// shows it ran through here
			System.out.println("Ran trhough PhoneCap");
			appName = "Carrier Control";
			phoneID = "iPhone 7";
			// App sleep and display

			Thread.sleep(1); // put to sleep to load next automation.
			System.out.println("Sleep succesfull");

		}
		
		public static void capabilitiesCarrierControliPhone8(String appName) throws Exception {
			iOSLogs.CapturedLogs(info, "Finding Device capabilities");
			phoneID = "iPhone 8";
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("BROWSER_NAME", "safari");
			cap.setCapability("platformVersion", "13.5.1");
			cap.setCapability("udid", "73f3eb04fb400695854183dca70b334a2a93799e");
			
			cap.setCapability("deviceName", "iPhone 8");
			cap.setCapability("platformName", "iOS");
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("noReset",true);
			cap.setCapability("usePrebuiltWDA",true);
		
			cap.setCapability("app", "com.efs.EFS-MWA-Carrier.test");
		
			
						
		   
			cap.setCapability("appWaitDuration", "3000");
			cap.setCapability("newCommandTimeout", 60 * 5);
			

			// app open in appium
			iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
			driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
			//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

					
			// shows it ran through here
			System.out.println("Ran trhough PhoneCap");
			appName = "Carrier Control";
			phoneID = "iPhone 8";
			// App sleep and display
			cap.setCapability("appWaitDuration", "3000");
			cap.setCapability("newCommandTimeout", 60 * 5);
			Thread.sleep(3000); // put to sleep to load next automation.
			System.out.println("Sleep succesfull");

		}

	
//Start of iPhone Card Control Capabilities.
		public static void capabilitiesCardControliPhoneXr(String appName) throws Exception {
			iOSLogs.CapturedLogs(info, "Finding Device capabilities");
			phoneID = "iPhone XR";
			DesiredCapabilities cap = new DesiredCapabilities();
			
						
			cap.setCapability("BROWSER_NAME", "safari");
			cap.setCapability("platformVersion", "14.4");
			cap.setCapability("udid", "00008020-0002199E36D8003A");
			
			cap.setCapability("deviceName", "iPhone Xʀ");
			cap.setCapability("platformName", "iOS");
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("noReset",false);
			
		
			cap.setCapability("app", "com.wex.cardcontrol.test");
			
		   
			cap.setCapability("appWaitDuration", "3000");
			cap.setCapability("newCommandTimeout", 60 * 5);
			

			// app open in appium
			iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
			driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
			//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

					
			// shows it ran through here
			System.out.println("Ran trhough PhoneCap");
			appName = "Carrier Control";
			phoneID = "iPhone XR";
			// App sleep and display
			cap.setCapability("appWaitDuration", "3000");
			Thread.sleep(3000); // put to sleep to load next automation.
			System.out.println("Sleep succesfull");
		}
		
		
		
		public static void capabilitiesCardControliPhone12(String appName) throws Exception {
			iOSLogs.CapturedLogs(info, "Finding Device capabilities");
			phoneID = "iPhone 12";
			DesiredCapabilities cap = new DesiredCapabilities();
			
						
			cap.setCapability("BROWSER_NAME", "safari");
			cap.setCapability("platformVersion", "15.0");
			cap.setCapability("udid", "00008101-00040DA814E9001E");
			
			cap.setCapability("deviceName", "iPhone 12");
			cap.setCapability("platformName", "iOS");
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("noReset",false);
			
		
			cap.setCapability("app", "com.wex.cardcontrol.test");
			
		   
			cap.setCapability("appWaitDuration", "3000");
			cap.setCapability("newCommandTimeout", 60 * 5);
			

			// app open in appium
			iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
			driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
			//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

					
			// shows it ran through here
			System.out.println("Ran trhough PhoneCap");
			appName = "Carrier Control";
			phoneID = "iPhone XR";
			// App sleep and display
			cap.setCapability("appWaitDuration", "3000");
			Thread.sleep(3000); // put to sleep to load next automation.
			System.out.println("Sleep succesfull");
		}
		
		
		
		
		
		
public static void capabilitiesCardControliPhone8(String appName) throws Exception {
	iOSLogs.CapturedLogs(info, "Finding Device capabilities");
		phoneID = "iPhone 8";
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("BROWSER_NAME", "safari");
		cap.setCapability("platformVersion", "12.1.3");
		cap.setCapability("udid", "73f3eb04fb400695854183dca70b334a2a93799e");
		cap.setCapability("deviceName", "iPhone 8");
		cap.setCapability("platformName", "iOS");
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("noReset",false);
	//	cap.setCapability("usePrebuiltWDA",true);
	
		cap.setCapability("app", "com.wex.cardcontrol.test");
	   
		cap.setCapability("appWaitDuration", "3000");
		cap.setCapability("newCommandTimeout", 60 * 5);
		

		// app open in appium
		iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
		//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

				
		// shows it ran through here
		System.out.println("Ran trhough PhoneCap");
		appName = "Card Control";
		phoneID = "iPhone 7";
		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");

	}

public static void capabilitiesCardControliPhone7(String appName) throws Exception {
	iOSLogs.CapturedLogs(info, "Finding Device capabilities");
	phoneID = "iPhone 7";
	DesiredCapabilities cap = new DesiredCapabilities();
	
	cap.setCapability("BROWSER_NAME", "safari");
	cap.setCapability("platformVersion", "12.0.1");
	cap.setCapability("udid", "256303487ebe5471ca758da0e95d27634f45bf5c");
	cap.setCapability("deviceName", "iPhone 7");
	cap.setCapability("platformName", "iOS");
	cap.setCapability("automationName", "XCUITest");
	cap.setCapability("noReset",false);
	cap.setCapability("usePrebuiltWDA",true);
	cap.setCapability("app", "com.wex.cardcontrol.test");
   
	cap.setCapability("appWaitDuration", "3000");
	cap.setCapability("newCommandTimeout", 60 * 5);
	

	// app open in appium
	iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
	driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
	//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

			
	// shows it ran through here
	System.out.println("Ran trhough PhoneCap");
	appName = "Card Control";
	phoneID = "iPhone 7";
	// App sleep and display
	cap.setCapability("appWaitDuration", "3000");
	Thread.sleep(3000); // put to sleep to load next automation.
	System.out.println("Sleep succesfull");

}


public static void capabilitiesCarrierControliPhone12(String appName) throws Exception {
	iOSLogs.CapturedLogs(info, "Finding Device capabilities");
	phoneID = "iPhone 12";
	DesiredCapabilities cap = new DesiredCapabilities();
	
				
	cap.setCapability("BROWSER_NAME", "safari");
	cap.setCapability("platformVersion", "15.0");
	cap.setCapability("udid", "00008101-00040DA814E9001E");
	
	cap.setCapability("deviceName", "iPhone 12");
	cap.setCapability("platformName", "iOS");
	cap.setCapability("automationName", "XCUITest");
	cap.setCapability("noReset",true);
	cap.setCapability("usePrebuiltWDA",true);

	cap.setCapability("app", "com.efs.EFS-MWA-Carrier.test");

   
	cap.setCapability("appWaitDuration", "3000");
	cap.setCapability("newCommandTimeout", 60 * 5);

	// app open in appium
	iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
	driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
	//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

			
	// shows it ran through here
	System.out.println("Ran trhough PhoneCap");
	appName = "Carrier Control";
	phoneID = "iPhone XR";
	// App sleep and display
	cap.setCapability("appWaitDuration", "3000");
	Thread.sleep(3000); // put to sleep to load next automation.
	System.out.println("Sleep succesfull");
}


//Start of Wex Connect Apple Devices
public static void capabilitiesWexConnectiPhoneXr(String appName) throws Exception {
	iOSLogs.CapturedLogs(info, "Finding Device capabilities");
	phoneID = "iPhone xr";
	DesiredCapabilities cap = new DesiredCapabilities();
	
				
	cap.setCapability("BROWSER_NAME", "safari");
	cap.setCapability("platformVersion", "14.4");
	cap.setCapability("udid", "00008020-0002199E36D8003A");
	
	cap.setCapability("deviceName", "iPhone Xʀ");
	cap.setCapability("platformName", "iOS");
	cap.setCapability("automationName", "XCUITest");
	cap.setCapability("noReset",false);
	

	cap.setCapability("app", "com.wrightexpress.fuelsitelocator.stage");
	
   
	cap.setCapability("appWaitDuration", "3000");
	cap.setCapability("newCommandTimeout", 60 * 5);
	

	// app open in appium
	iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
	driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
	//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

			
	// shows it ran through here
	System.out.println("Ran trhough PhoneCap");
	appName = "Wex Connect";
	phoneID = "iPhone XR";
	// App sleep and display
	cap.setCapability("appWaitDuration", "3000");
	Thread.sleep(3000); // put to sleep to load next automation.
	System.out.println("Sleep succesfull");
}



public static void capabilitiesWexConnectiPhone12(String appName) throws Exception {
	iOSLogs.CapturedLogs(info, "Finding Device capabilities");
	phoneID = "iPhone 12";
	DesiredCapabilities cap = new DesiredCapabilities();
	
				
	cap.setCapability("BROWSER_NAME", "safari");
	cap.setCapability("platformVersion", "15.0");
	cap.setCapability("udid", "00008101-00040DA814E9001E");
	
	cap.setCapability("deviceName", "iPhone 12");
	cap.setCapability("platformName", "iOS");
	cap.setCapability("automationName", "XCUITest");
	cap.setCapability("noReset",false);
	

	cap.setCapability("app", "com.wrightexpress.fuelsitelocator.stage");
	
   
	cap.setCapability("appWaitDuration", "3000");
	cap.setCapability("newCommandTimeout", 60 * 5);
	

	// app open in appium
	iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
	driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
	//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

			
	// shows it ran through here
	System.out.println("Ran trhough PhoneCap");
	appName = "Carrier Control";
	phoneID = "iPhone XR";
	// App sleep and display
	cap.setCapability("appWaitDuration", "3000");
	Thread.sleep(3000); // put to sleep to load next automation.
	System.out.println("Sleep succesfull");
}






public static void capabilitiesWexConnectiPhone8(String appName) throws Exception {
iOSLogs.CapturedLogs(info, "Finding Device capabilities");
phoneID = "iPhone 8";
DesiredCapabilities cap = new DesiredCapabilities();

cap.setCapability("BROWSER_NAME", "safari");
cap.setCapability("platformVersion", "12.1.3");
cap.setCapability("udid", "73f3eb04fb400695854183dca70b334a2a93799e");
cap.setCapability("deviceName", "iPhone 8");
cap.setCapability("platformName", "iOS");
cap.setCapability("automationName", "XCUITest");
cap.setCapability("noReset",false);
//	cap.setCapability("usePrebuiltWDA",true);

cap.setCapability("app", "com.wrightexpress.fuelsitelocator.stage");

cap.setCapability("appWaitDuration", "3000");
cap.setCapability("newCommandTimeout", 60 * 5);


// app open in appium
iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		
// shows it ran through here
System.out.println("Ran trhough PhoneCap");
appName = "Carrier Control";
phoneID = "iPhone 7";
// App sleep and display
cap.setCapability("appWaitDuration", "3000");
Thread.sleep(3000); // put to sleep to load next automation.
System.out.println("Sleep succesfull");

}

public static void capabilitiesWexConnectiPhone7(String appName) throws Exception {
iOSLogs.CapturedLogs(info, "Finding Device capabilities");
phoneID = "iPhone 7";
DesiredCapabilities cap = new DesiredCapabilities();

cap.setCapability("BROWSER_NAME", "safari");
cap.setCapability("platformVersion", "12.0.1");
cap.setCapability("udid", "256303487ebe5471ca758da0e95d27634f45bf5c");
cap.setCapability("deviceName", "iPhone 7");
cap.setCapability("platformName", "iOS");
cap.setCapability("automationName", "XCUITest");
cap.setCapability("noReset",false);
cap.setCapability("usePrebuiltWDA",true);
cap.setCapability("app", "com.wrightexpress.fuelsitelocator.stage");

cap.setCapability("appWaitDuration", "3000");
cap.setCapability("newCommandTimeout", 60 * 5);


// app open in appium
iOSLogs.CapturedLogs(info, "Trying to open " + appName +" on " + phoneID);
driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);		
//iphone7 = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

	
// shows it ran through here
System.out.println("Ran trhough PhoneCap");
appName = "Carrier Control";
phoneID = "iPhone 7";
// App sleep and display
cap.setCapability("appWaitDuration", "3000");
Thread.sleep(3000); // put to sleep to load next automation.
System.out.println("Sleep succesfull");

}


}
