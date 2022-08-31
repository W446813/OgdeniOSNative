package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class AccountTabManageYourProfile {
	Logs logs = new Logs();
	static AppiumDriver<WebElement> driver;
	Wait appWait = new Wait();
	Sleep appSleep = new Sleep();
	RepoCarrieriOS elements = new RepoCarrieriOS();
	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	AppStringsiOS iOSText = new AppStringsiOS();
	public AccountTabManageYourProfile AccountTabManageYourProfile() throws Exception {
		
		logs.CapturedLogs(iOSText.PASS, "Manage your profile seciton opened");
	//edit name
		Thread.sleep(3000);
		WebElement EditNameButton = elements.EditNameButton();
		if(EditNameButton.isEnabled()) {
			EditNameButton.click();
			logs.CapturedLogs(iOSText.PASS, "Edit name button clicked");
			String originalFirstName = elements.FirstNameTextBox().getText();
			String originalLastName=elements.LastNameTextBox().getText();
			logs.CapturedLogs(iOSText.INFO, "Original First name stored " +originalFirstName.toString());
			logs.CapturedLogs(iOSText.INFO, "Original last name stored " +originalLastName.toString());
			elements.FirstNameTextBox().clear();
			logs.CapturedLogs(iOSText.INFO, "First name text box cleared");
			elements.FirstNameTextBox().sendKeys(iOSText.PROFILE_FIRST_NAME);
			logs.CapturedLogs(iOSText.PASS, "First name text box filled.");
			elements.LastNameTextBox().clear();
			logs.CapturedLogs(iOSText.INFO, "Last name text box cleared");
			elements.LastNameTextBox().sendKeys(iOSText.PROFILE_LAST_NAME);
			logs.CapturedLogs(iOSText.PASS, "Last name text box filled");
			elements.SaveEditNameButton().click();
			logs.CapturedLogs(iOSText.PASS, "Save button selected");
			Thread.sleep(4000);
			elements.EditNameButton().click();
			elements.FirstNameTextBox().clear();
			elements.FirstNameTextBox().sendKeys(originalFirstName);
			logs.CapturedLogs(iOSText.PASS, "First name text box filled.");
			elements.LastNameTextBox().clear();
			elements.LastNameTextBox().sendKeys(originalLastName);
			logs.CapturedLogs(iOSText.PASS, "Last name text box filled.");
			Thread.sleep(3000);
			elements.SaveEditNameButton().click();
			logs.CapturedLogs(iOSText.PASS, "Save button selected");
			Thread.sleep(3000);
		}
		else {
			logs.CapturedLogs(iOSText.FAIL, "Edit name button not found");
		}
		//edit email
		WebElement EditEmailButton = elements.EditEmailButton();
		Thread.sleep(3000);
		if(EditEmailButton.isEnabled()) {
			EditEmailButton.click();
			logs.CapturedLogs(iOSText.PASS, "Edit email button clicked");
			String originalEmail=elements.EmailTextBox().getText();
			logs.CapturedLogs(iOSText.INFO, "Original Email stored "+originalEmail.toString());
			elements.EmailTextBox().clear();
			logs.CapturedLogs(iOSText.INFO, "Email text box cleared");
			elements.EmailTextBox().sendKeys(iOSText.PROFILE_EMAIL);
			logs.CapturedLogs(iOSText.PASS, "Email textbox filled in");
			elements.SaveEditEmailButton().click();
			logs.CapturedLogs(iOSText.PASS, "Save button selected");
			Thread.sleep(3000);
			elements.EditEmailButton().click();
			logs.CapturedLogs(iOSText.PASS, "Edit email button clicked");
			elements.EmailTextBox().clear();
			elements.EmailTextBox().sendKeys(originalEmail);
			logs.CapturedLogs(iOSText.PASS, "Email textbox filled in");
			Thread.sleep(3000);
			elements.SaveEditEmailButton().click();
			logs.CapturedLogs(iOSText.PASS, "Save button selected");
			Thread.sleep(3000);
		}
		else {
			logs.CapturedLogs(iOSText.FAIL, "Edit email button not found");
		}
		
		//edit phone number
		Thread.sleep(3000);
		WebElement EditPhoneButton = elements.EditPhoneButton();
		if(EditPhoneButton.isEnabled()) {
			Thread.sleep(3000);
			EditPhoneButton.click();
			logs.CapturedLogs(iOSText.PASS, "Edit Phone number button clicked");
			String originalPhoneNumber=elements.EditPhoneTextBox().getText();
			logs.CapturedLogs(iOSText.INFO, "Original Phone Number stored " +originalPhoneNumber.toString());
			elements.EditPhoneTextBox().clear();
			logs.CapturedLogs(iOSText.INFO, "Phone number text box cleared");
			elements.EditPhoneTextBox().sendKeys(iOSText.PROFILE_PHONE);
			logs.CapturedLogs(iOSText.PASS, "Phone number text box filled in");
			elements.SaveEditPhoneButton().click();
			logs.CapturedLogs(iOSText.PASS, "Save button selected");
			Thread.sleep(3000);
			elements.EditPhoneButton().click();
			logs.CapturedLogs(iOSText.PASS, "Edit Phone number button clicked");
			elements.EditPhoneTextBox().clear();
			logs.CapturedLogs(iOSText.INFO, "Phone number text box cleared");
			elements.EditPhoneTextBox().sendKeys(originalPhoneNumber);
			logs.CapturedLogs(iOSText.PASS, "Phone number text box filled in");
			Thread.sleep(3000);
			elements.SaveEditPhoneButton().click();
			logs.CapturedLogs(iOSText.PASS, "Save button selected");
			Thread.sleep(3000);
		}
		else {
			logs.CapturedLogs(iOSText.FAIL, "Edit phone button not found");
		}
		
		
		elements.ManageYourProfileBackButton().click();
		logs.CapturedLogs(iOSText.INFO, "Back button selected");
		return this;
		
	}
}
