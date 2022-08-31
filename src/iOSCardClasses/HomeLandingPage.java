package iOSCardClasses;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;


public class HomeLandingPage {
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	
	public void HomeLandingPage(String environment, String cardNumber, String passwordOrPin) throws Exception {
			this.env = environment;
			this.cardNum = cardNumber;
			this.passwordOrPin = passwordOrPin;
			//System.out.println("I am in Card Pass expected environment is:" + environment);
			homePage();
		}
	
	
		
	public void homePage() throws Exception {
		
		Logs iOSLogs = new Logs();
//		iOSLogs.testSetup = testSetup;
	//CombinedBasicExtentReportiOS iOSLogs = new BasicExtentReportiOS();
		LogoutCardControl Logout = new LogoutCardControl();
		AppStringsiOS iOSText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
	//CardDirectLoginPass CardLogin = new CardDirectLoginPass();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		BiometricsiOS Biometric = new BiometricsiOS();
		MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreateProfile profileSetup = new CreateProfile();
		HomeLandingPage homePage = new HomeLandingPage();
		AccountPage accountPage = new AccountPage();
		CreatePasscode createPasscode = new CreatePasscode();
		RepoCardiOS elements=new RepoCardiOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;	
		

//Help screen for home page
		Thread.sleep(3000);
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
		} else {
			iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
		}
		

//Home card header expected seen (One sided cards)
		iOSLogs.setupTest("Home Landing Page Testing started.");
		Thread.sleep(3000);
		iOSLogs.CapturedLogs(info, "Checking for Home header");
		Thread.sleep(3000);
		WebElement HomeHeader = elements.HomeHeader();
		Thread.sleep(3000);
		if (HomeHeader != null && HomeHeader.isEnabled()) {
			iOSLogs.CapturedLogs(pass, "Company or SmartFunds only account homepage found");
					
		} else {
			iOSLogs.CapturedLogs(info, "Home Header not found");
		}
		
//Company header expected for Universal (Dual sided cards)
		iOSLogs.CapturedLogs(info, "Checking for Company header");
		Thread.sleep(3000);
		WebElement CompanyHeader = elements.CompanyHeader();
		Thread.sleep(3000);
		if (CompanyHeader != null && CompanyHeader.isEnabled()) {
			iOSLogs.CapturedLogs(pass, "Company account homepage found");
			
//SmartFunds header expected for Universal (Dual sided cards)			
			Thread.sleep(3000);
			WebElement SmartFundsHeader = elements.SmartFundsHeader();
			Thread.sleep(3000);
			if (SmartFundsHeader != null && SmartFundsHeader.isEnabled()) {
				SmartFundsHeader.click();
				iOSLogs.CapturedLogs(pass, "SmartFunds account homepage found");
				Thread.sleep(3000);
				CompanyHeader.click();
				iOSLogs.CapturedLogs(pass, "Switched back to company side");
				Thread.sleep(3000);
			
		} else {
			iOSLogs.CapturedLogs(info, "SmartFunds Header not found");
		}
		}else {
			iOSLogs.CapturedLogs(info, "Company Account Header not found");
		}
		

	

		
		
//TODO If you want to click the profile button latter on
//		Thread.sleep(3000);	
//		WebElement openProfileButtonFromHome = elements.ProfileButtonFromHome();
//		Thread.sleep(3000);
//		if (openProfileButtonFromHome != null && openProfileButtonFromHome.isEnabled()) {
//			openProfileButtonFromHome.click();
//			iOSLogs.CapturedLogs(pass, "Open Profile Button is found and pressed.");
//		} else {
//			iOSLogs.CapturedLogs(fail, "Open Profile Button is not found");
//		}
//				
//		
//		Thread.sleep(3000);
//		WebElement HelpScreenContinue = elements.HelpScreenContinue();
//		Thread.sleep(3000);
//		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
//			HelpScreenContinue.click();
//			iOSLogs.CapturedLogs(pass, "Help Screen Continue Button is found and pressed");
//		} else {
//			iOSLogs.CapturedLogs(info, "Help Screen Continue Button is not found");
//		}

		

	
		
	}
}

