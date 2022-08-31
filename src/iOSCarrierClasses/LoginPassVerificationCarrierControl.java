package iOSCarrierClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;

public class LoginPassVerificationCarrierControl{

	public LoginPassVerificationCarrierControl() {
	}
	
private String env;
private String carrierNum;
private String passwordOrPin;
	
public void PassExpected(String environment, String carrierNum, String passwordOrPin) throws Exception {
	this.env = environment;
	this.carrierNum = carrierNum;
	this.passwordOrPin = passwordOrPin;
	PassExpected();
}
	

	@Test
	public void PassExpected() throws Exception {
		Logs iOSLogs = new Logs();
		PhonePicker phone = new PhonePicker();
		ConnectionHandler dbCheck = new ConnectionHandler(env);
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCarrieriOS xpath = new RepoCarrieriOS();
		
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		iOSLogs.CapturedLogs(info,"LOGIN PASS");
		// check test account is not prior suspended.
	

		ResultSet carrier_info = dbCheck.query("mysql",String.format("select status_id from sec_user where user_id ='"+carrierNum+"'"));

		carrier_info.next();
		if (carrier_info.getString("status_id").equals("S")) {
			iOSLogs.CapturedLogs("Test Info", "Carrier Account Was Suspended prior to testing");
			dbCheck.execute("mysql",
					"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id  = '"+carrierNum+"'");
		} else {
			iOSLogs.CapturedLogs(info,
					String.format("Carrier Account status is: %s", carrier_info.getString("status_id")));
			iOSLogs.CapturedLogs(info, "Carrier Account is active and ready for testing ");

		}
		Thread.sleep(3000);
		WebElement LoginCarrierTextBox = xpath.CarrierNumberTextbox();
		Thread.sleep(3000);
		if (LoginCarrierTextBox != null && LoginCarrierTextBox.isEnabled()) {
			LoginCarrierTextBox.click();
			LoginCarrierTextBox.clear();
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(info, "Carrier number textbox cleared");
			LoginCarrierTextBox.sendKeys(this.carrierNum);
			iOSLogs.CapturedLogs(pass, "Carrier number entered");
		} else {
			iOSLogs.CapturedLogs(fail,
					"Carrier number for " + this.carrierNum + " text box is not found");
		}
		Thread.sleep(3000);

		// Find the login Password/pin textbox tell if find or fail.
		Thread.sleep(3000);
		WebElement LoginCarrierPasswordTextBox = xpath.PasswordTextbox();
		Thread.sleep(3000);
		if (LoginCarrierPasswordTextBox != null && LoginCarrierPasswordTextBox.isEnabled()) {
			LoginCarrierPasswordTextBox.click();
			LoginCarrierPasswordTextBox.clear();
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(info, "Carrier Password textbox cleared");
			LoginCarrierPasswordTextBox.sendKeys(this.passwordOrPin);
			iOSLogs.CapturedLogs(pass,
					"Pin text box for " + this.carrierNum + " is entered.");
		} else {
			iOSLogs.CapturedLogs(fail,
					"Pin text box for " + this.carrierNum + " is not found");
		}
		
		
		Thread.sleep(3000);
		WebElement LoginButtonCarrierControl = xpath.LoginButtonCarrier();
		Thread.sleep(3000);
		if (LoginButtonCarrierControl != null && LoginButtonCarrierControl.isEnabled()) {
			LoginButtonCarrierControl.click();
			iOSLogs.CapturedLogs(pass, "Login Button selected.");
		} else {
			iOSLogs.CapturedLogs(fail, "Login Button not found");
		}
	}
}
