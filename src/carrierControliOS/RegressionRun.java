package carrierControliOS;

import java.io.IOException;

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
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class RegressionRun {
//Working on adding testng...
	// cntrl shft f cleans up the format..
	// sysout + cntrl + space == System.out.println();
	// sout + cntr + space = System.out.println();

	static AppiumDriver<WebElement> driver;

	@Test
	public void functionalAndroidCarrierControl() throws Exception {
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		AccountTabRun accountTabRun = new AccountTabRun();
		BillingTabRun billingTabRun = new BillingTabRun();
		CardsTabRun cardsTabRun = new CardsTabRun();
		CompanyCardOverviewRun companyCardOverviewRun = new CompanyCardOverviewRun();
		SmartFundsCardOverviewRun smartFundsCardOverviewRun = new SmartFundsCardOverviewRun();
		UniversalCardsOverviewRun universalCardsOverviewRun = new UniversalCardsOverviewRun();
		LoginScenariosRun loginScenariosRun = new LoginScenariosRun();
		ManageYourProfileRun manageYourProfileRun = new ManageYourProfileRun();
		MoneyCodesRun moneyCodesRun = new MoneyCodesRun();
		RejectsTabRun rejectsTabRun = new RejectsTabRun();
		TransferToYourBankRun transferToYourBankRun = new TransferToYourBankRun();
		QuickLoginLogoutRun quickLoginLogoutRun = new QuickLoginLogoutRun();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		// ADD INFO FOR WHAT YOU ARE RUUNING TEST NAME USUALLY = CLASS NAME
		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String testName = "Regression ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "Partner ";

		try {
			iOSLogs.setupTestYellow(testName + build + appName + server  );

			iOSLogs.setupTestYellow("LOCKED SUSPENDED SUCCESS LOGIN");
			loginScenariosRun.carrierControliOSLoginLogout();

			iOSLogs.setupTestYellow("Login Logout multiple carriers");
			quickLoginLogoutRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Company Card tab tests");
			companyCardOverviewRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Universal Card tests");
			universalCardsOverviewRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("SmartFunds tab tests");
			smartFundsCardOverviewRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Account tab tests");
			accountTabRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Billing tab tests");
			billingTabRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Cards tab tests");
			cardsTabRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Manage Profile tests");
			manageYourProfileRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("MoneyCodes tests");
			moneyCodesRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Transfer to your bank tests");
			transferToYourBankRun.carrierControlTestiOS();

			iOSLogs.setupTestYellow("Reject tab tests");
			rejectsTabRun.carrierControlTestiOS();

			iOSLogs.CapturedLogs(pass, "Full Regression testing completed.");

		} catch (Exception exp) {

			String errorMessage = exp.getMessage();

			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);

			} else {
				System.out.println("Error is: " + errorMessage);
			}

			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				iOSLogs.CapturedLogs(info, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}