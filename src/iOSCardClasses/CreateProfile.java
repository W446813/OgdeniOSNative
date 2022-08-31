package iOSCardClasses;

import java.sql.ResultSet;
import org.openqa.selenium.WebElement;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import io.appium.java_client.AppiumDriver;

public class CreateProfile {
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements = new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	LogoutCardControl Logout = new LogoutCardControl();
	CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
	
	public CreateProfile ProfileSetup(String environment) throws Exception {
		iOSLogs.setupTest("Profile Setup");
		Thread.sleep(3000);

		Thread.sleep(3000);
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
		} else {
			iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
		}
		
		Thread.sleep(3000);
		WebElement SetupProfile = elements.SetupProfile();
		Thread.sleep(3000);
		if (SetupProfile != null && SetupProfile.isEnabled()) {
			iOSLogs.CapturedLogs(pass, "Setup profile page opened");
	
			Thread.sleep(3000);
			WebElement FirstNameTextbox = elements.FirstNameTextbox();
			Thread.sleep(3000);
			if (FirstNameTextbox != null && FirstNameTextbox.isEnabled()) {
				FirstNameTextbox.click();
				FirstNameTextbox.sendKeys(iOSText.FIRST_NAME);
				iOSLogs.CapturedLogs(pass, "First Name textbox filled in");
			} else {
				iOSLogs.CapturedLogs(fail, "First Name textbox not found");
			}

			Thread.sleep(3000);
			WebElement LastNameTextbox = elements.LastNameTextbox();
			Thread.sleep(3000);
			if (LastNameTextbox != null && LastNameTextbox.isEnabled()) {
				LastNameTextbox.click();
				LastNameTextbox.sendKeys(iOSText.LAST_NAME);
				iOSLogs.CapturedLogs(pass, "Last Name textbox filled in");
			} else {
				iOSLogs.CapturedLogs(fail, "Last Name textbox not found");
			}

			Thread.sleep(3000);
			WebElement NextButton = elements.NextButton();
			Thread.sleep(3000);
			if (NextButton != null && NextButton.isEnabled()) {
				NextButton.click();
				iOSLogs.CapturedLogs(pass, "Next Button Pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Next Button not found");
			}

			Thread.sleep(3000);
			WebElement DateOfBirth = elements.DateOfBirthTextbox();
			Thread.sleep(3000);
			if (DateOfBirth != null && DateOfBirth.isEnabled()) {
				DateOfBirth.click();
				DateOfBirth.sendKeys(iOSText.DATE_OF_BIRTH);
				iOSLogs.CapturedLogs(pass, "Date of Birth Textbox filled in");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Date of Birth Textbox not found");
			}

			Thread.sleep(3000);
			WebElement DOBNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (DOBNextButton != null && DOBNextButton.isEnabled()) {
				DOBNextButton.click();
				iOSLogs.CapturedLogs(pass, "Next Button on DOB Pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Next Button on DOB not found");
			}

			Thread.sleep(3000);
			WebElement PhoneNumberTextBox = elements.PhoneNumberTextBox();
			Thread.sleep(3000);
			if (PhoneNumberTextBox != null && PhoneNumberTextBox.isEnabled()) {
				PhoneNumberTextBox.click();
				PhoneNumberTextBox.sendKeys(iOSText.PHONE_NUMBER);
				iOSLogs.CapturedLogs(pass, "Phone Number Textbox filled in");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Phone Number Textbox not found");
			}

			Thread.sleep(3000);
			WebElement PhoneNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (PhoneNextButton != null && PhoneNextButton.isEnabled()) {
				PhoneNextButton.click();
				iOSLogs.CapturedLogs(pass, "Next Button on Phone page Pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Next Button on Phone page not found");
			}

			Thread.sleep(3000);
			WebElement EmailTextBox = elements.EmailTextBox();
			Thread.sleep(3000);
			if (EmailTextBox != null && EmailTextBox.isEnabled()) {
				EmailTextBox.click();
				EmailTextBox.sendKeys(iOSText.EMAIL_ADDRESS);
				iOSLogs.CapturedLogs(pass, "Email Textbox filled in");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Email Textbox not found");
			}

			Thread.sleep(3000);
			WebElement EmailNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (EmailNextButton != null && EmailNextButton.isEnabled()) {
				EmailNextButton.click();
				iOSLogs.CapturedLogs(pass, "Next Button on email page Pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Next Button on email page not found");
			}

			Thread.sleep(3000);
			WebElement SocialTextBox = elements.SocialTextBox();
			Thread.sleep(3000);
			if (SocialTextBox != null && SocialTextBox.isEnabled()) {
				SocialTextBox.click();
				SocialTextBox.sendKeys(iOSText.SOCIAL_SECURITY);
				iOSLogs.CapturedLogs(pass, "Social Textbox filled in");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(info, "Social Textbox not found");
			}

			Thread.sleep(3000);
			WebElement SocialNextButton = elements.NextButton();
			Thread.sleep(3000);
			if (SocialNextButton != null && SocialNextButton.isEnabled()) {
				SocialNextButton.click();
				iOSLogs.CapturedLogs(pass, "Next Button on Social page Pressed");
			} else {
				iOSLogs.CapturedLogs(info, "Next Button on Social page not found");
			}

			Thread.sleep(3000);
			WebElement HomeAddressTextBox = elements.HomeAddressTextBox();
			Thread.sleep(3000);
			if (HomeAddressTextBox != null && HomeAddressTextBox.isEnabled()) {
				HomeAddressTextBox.click();
				HomeAddressTextBox.sendKeys(iOSText.HOME_ADDRESS);
				iOSLogs.CapturedLogs(pass, "Address Textbox filled in");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Address Textbox not found");
			}

			Thread.sleep(3000);
			WebElement AddressSelector = elements.AddressSelector();
			Thread.sleep(3000);
			if (AddressSelector != null && AddressSelector.isEnabled()) {
				AddressSelector.click();
				iOSLogs.CapturedLogs(pass, "Address Selector selected");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Address Selector not found");
			}

			Thread.sleep(3000);
			WebElement AddressLineTwo = elements.AddressLineTwo();
			Thread.sleep(3000);
			if (AddressLineTwo != null && AddressLineTwo.isEnabled()) {
				AddressLineTwo.click();
				AddressLineTwo.sendKeys(iOSText.HOME_ADDRESS_LINE_TWO);
				iOSLogs.CapturedLogs(pass, "Address Line two filled in");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Address Selector not found");
			}

			Thread.sleep(3000);
			WebElement ProfileFinishButton = elements.ProfileFinishButton();
			Thread.sleep(3000);
			if (ProfileFinishButton != null && ProfileFinishButton.isEnabled()) {
				ProfileFinishButton.click();
				iOSLogs.CapturedLogs(pass, "Finish Button Pressed");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Finish Button not found");
			}

			Thread.sleep(3000);
			WebElement GetStartedButton = elements.GetStartedButton();
			Thread.sleep(3000);
			if (GetStartedButton != null && GetStartedButton.isEnabled()) {
				GetStartedButton.click();
				iOSLogs.CapturedLogs(pass, "Get Started Button Pressed");
				Thread.sleep(3000);
			} else {
				iOSLogs.CapturedLogs(fail, "Get Started Button not found");
			}

		} else {
			iOSLogs.CapturedLogs(info, "Setup profile page not found could be already setup or not needed for this account");
		}
					return this;

		}

}