package iOSCardClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.BiometricsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.AutoAccountSelector;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;

public class OpenDirectLoginSecureFuel {

	AppiumDriver<WebElement> driver;
	
	
	public static void openCardControl() throws Exception {
		String appName = "Card Control";
		Logs iOSLogs = new Logs();
		PhonePicker phone = new PhonePicker();
		CardLoginPassSecureFuel CardLogin = new CardLoginPassSecureFuel();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		AppStringsiOS iOSText = new AppStringsiOS();
		SecureFuel secureFuel = new SecureFuel();
		RegisterCheckiOS registerCheck=new RegisterCheckiOS();
		BiometricsiOS Biometric = new BiometricsiOS();
		MultiCardLoginCheck multiCardLogin = new MultiCardLoginCheck();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		String cardType;
		
		System.out.println(phone.autoPhonePickerCard(appName));
		iOSLogs.CapturedLogs(iOSText.INFO, "Card Control Secure fuel testing");
		cardType = "Card Control Secure fuel testing";
		environmentPicker.environmentPickerButton();
		multiCardLogin.MultiCardLoginCheck();
		CardLogin.CardPassExpected(environmentPicker.getEnviroment());
		Biometric.BiometricsiOS();
		Thread.sleep(25000);
		iOSLogs.CapturedLogs(iOSText.INFO, "Sleep initiated for home page transactions to load");
		secureFuel.secureFuel(environmentPicker.getEnviroment(), getAccount.getUnitID());
		registerCheck.registerCheckiOS(environmentPicker.getEnviroment(), getAccount.getAccountNum(), getAccount.getPasswordOrPin(), cardType);

	}
}
