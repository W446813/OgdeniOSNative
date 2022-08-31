package iOSCardClasses;
import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class LoginLogoutTesting {
	AppiumDriver<WebElement> driver;

	private String cardNum;	
	private String cardType;
	String appName = "Card Control";
	public  void openCardControl() throws Exception {

		Logs iOSLogs = new Logs();
		PhonePicker phone = new PhonePicker();
		CardLoginLogoutTestingLoginPass CardLogin = new CardLoginLogoutTestingLoginPass();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		LoginFailVerificationiOS failLogin = new LoginFailVerificationiOS();
		AppStringsiOS iOSText = new AppStringsiOS();
		BiometricsiOS Biometric = new BiometricsiOS();
		MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		
		System.out.println(phone.autoPhonePickerCard(appName));
		iOSLogs.setupTest("Card Control Login Logout testing");
		iOSLogs.CapturedLogs(iOSText.INFO, "Multiple cards are used for this test");
		
		// Environment Picker
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		getAccount.CardPassExpected("FAKE");
		failLogin.FailExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		getAccount.CardPassExpected("COMPANY");
		failLogin.LockedLoginExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		// welcome.welomeScreen();

		getAccount.CardPassExpected("COMPANY");
		CardLogin.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
		Biometric.BiometricsiOS();

	}
	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: "+ cardNum);
	}


	public String getCardNum() {
		System.out.println("GET Card number: "+ cardNum);
		return cardNum;
	}
}
