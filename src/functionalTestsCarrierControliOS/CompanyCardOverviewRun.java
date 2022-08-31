package functionalTestsCarrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCarrierClasses.CardsOverviewCompany;
import iOSCarrierClasses.LoginCompanyCC;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class CompanyCardOverviewRun {
	static AppiumDriver<WebElement> driver;
	@Test
	public void carrierControlTestiOS() {
		Logs iOSLogs = new Logs();
		LogoutCarrierControlRewrite Logout = new LogoutCarrierControlRewrite();
		AppStringsiOS iOSText = new AppStringsiOS();
		PhonePicker phone = new PhonePicker();
		WelcomeScreeniOS welcome = new WelcomeScreeniOS();
		BiometricsiOS Biometric = new BiometricsiOS();
		
		LoginCompanyCC companyLogin = new LoginCompanyCC();
		CardsOverviewCompany cardsOverview= new CardsOverviewCompany();
			EnvironmentPicker environmentPicker = new EnvironmentPicker();
			String appName = "Carrier Control";
			
		try {
			System.out.println(phone.autoPhonePickerCarrier(appName));
			
			iOSLogs.setupTest("Company Cards Overview Funtional Test");
			
		
			environmentPicker.environmentPickerButtonCarrier();
			
			welcome.welomeScreen();
			
			companyLogin.CarrierPassExpected();
			
			Biometric.BiometricsiOS();
			
			cardsOverview.CardsOverview();
			
			Logout.logOutCarrierControll();
			iOSLogs.CapturedLogs(iOSText.INFO, "Logged out");
			
			iOSLogs.CapturedLogs(iOSText.INFO, "Company Cards overview Functional Test completed");
			
		} catch (Exception exp) {
			String errorMessage = exp.getMessage();
			
			
			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);
				
			}else {
				System.out.println("Error is: " + errorMessage);
			}
			
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			
			try {
				iOSLogs.CapturedLogs(iOSText.FAIL, errorMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }	
	}