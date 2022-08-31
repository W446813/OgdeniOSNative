package carrierControliOS;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import functionalTestsCarrierControliOS.AccountTabRun;
import functionalTestsCarrierControliOS.BillingTabRun;
import functionalTestsCarrierControliOS.CardsTabRun;
import functionalTestsCarrierControliOS.CompanyCardOverviewRun;
import functionalTestsCarrierControliOS.ManageYourProfileRun;
import functionalTestsCarrierControliOS.MoneyCodesRun;
import functionalTestsCarrierControliOS.QuickLoginLogoutRun;
import functionalTestsCarrierControliOS.RejectsTabRun;
import functionalTestsCarrierControliOS.SmartFundsCardOverviewRun;
import functionalTestsCarrierControliOS.TransferToYourBankRun;
import functionalTestsCarrierControliOS.UniversalCardsOverviewRun;
import iOSCarrierClasses.LogoutCarrierControlRewrite;
import iOSCarrierClasses.OpenCarrierControlDirectLogin;
import iOSCarrierClasses.OpenCompanyCC;
import iOSCarrierClasses.OpenSubUserCarrierControl;
import iOSCarrierClasses.OpenUniversalCC;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;


public class SmokeTestRun {

	static AppiumDriver<WebElement> driver;

//	public static void main(String[] args) throws Exception {
//		System.out.println("Test Info " + "------Test--------Running using Java----------");
//		carrierControlTestiOS();
//	}

	@Test
	public void carrierControlTestiOS() {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		AccountTabRun accountTabRun = new AccountTabRun();
		BillingTabRun billingTabRun = new BillingTabRun(); 
		CardsTabRun cardsTabRun = new CardsTabRun();
		CompanyCardOverviewRun companyCardOverviewRun = new CompanyCardOverviewRun();
		SmartFundsCardOverviewRun smartFundsCardOverviewRun = new SmartFundsCardOverviewRun();
		UniversalCardsOverviewRun universalCardsOverviewRun = new UniversalCardsOverviewRun();
		LoginScenariosRun loginScenariosRun = new LoginScenariosRun(); 
		ManageYourProfileRun  manageYourProfileRun = new ManageYourProfileRun();
		MoneyCodesRun moneyCodesRun = new MoneyCodesRun();
		QuickLoginLogoutRun quickLoginLogoutRun = new QuickLoginLogoutRun();
		RejectsTabRun rejectsTabRun = new RejectsTabRun();
		TransferToYourBankRun transferToYourBankRun = new TransferToYourBankRun();
		
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		
		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smoke Test ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "Partner ";

		
		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);
			iOSLogs.setupTest("SMOKE TEST CARD CONTROL");
			
			System.out.println("***Inside: ACCOUNT TAB TESTS***");
			iOSLogs.setupTestYellow("*ACCOUNT TAB TESTS*");
			accountTabRun.carrierControlTestiOS();
			
			System.out.println("***Inside: BILLING TAB TESTS***");
			iOSLogs.setupTestYellow("*BILLING TAB TESTS*");
			billingTabRun.carrierControlTestiOS();
			
			System.out.println("***Inside: CARDS TAB TESTS***");
			iOSLogs.setupTestYellow("*CARDS TAB TESTS*");
			cardsTabRun.carrierControlTestiOS();
			
			System.out.println("***Inside: COMPANY CARD TESTS***");
			iOSLogs.setupTestYellow("*COMPANY CARD TESTS*");
			companyCardOverviewRun.carrierControlTestiOS();
			
			System.out.println("***Inside: SMARTFUNDS CARD TESTS***");
			iOSLogs.setupTestYellow("*SMARTFUNDS CARD TESTS*");
			smartFundsCardOverviewRun.carrierControlTestiOS();
			
			System.out.println("***Inside: UNIVERSAL CARD TESTS***");
			iOSLogs.setupTestYellow("*UNIVERSAL CARD TESTS*");
			universalCardsOverviewRun.carrierControlTestiOS();
			
			System.out.println("***Inside: MANAGE YOUR PROFILE TESTS***");
			iOSLogs.setupTestYellow("*MANAGE YOUR PROFILE TESTS*");
			manageYourProfileRun.carrierControlTestiOS();			

			System.out.println("***Inside: LOGIN SCENARIOS TESTS***");
			iOSLogs.setupTestYellow("*LOGIN SCENARIOS TESTS*");
			loginScenariosRun.carrierControliOSLoginLogout();
			
			System.out.println("***Inside: MONEY CODES TESTS***");
			iOSLogs.setupTestYellow("*MONEY CODES TESTS*");
			moneyCodesRun.carrierControlTestiOS();
			
			System.out.println("***Inside:QUICK LOGIN LOGOUT TESTS***");
			iOSLogs.setupTestYellow("*QUICK LOGIN LOGOUT TESTS*");
			quickLoginLogoutRun.carrierControlTestiOS();
			
			System.out.println("***Inside: REJECTS TESTS***");
			iOSLogs.setupTestYellow("*REJECTS TESTS*");
			rejectsTabRun.carrierControlTestiOS();
			
			System.out.println("***Inside: TRANSFER TO YOUR BANK TESTS***");
			iOSLogs.setupTestYellow("*TRANSFER TO YOUR BANK TESTS*");
			transferToYourBankRun.carrierControlTestiOS();
			
			
			iOSLogs.CapturedLogs(pass, "Regression CarrierControl testing completed");

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
				iOSLogs.CapturedLogs(fail, errorMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  }	
	}