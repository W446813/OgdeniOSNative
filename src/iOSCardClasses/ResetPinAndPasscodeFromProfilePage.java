package iOSCardClasses;

import org.openqa.selenium.WebElement;

import iOSCarrierClasses.InputText;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class ResetPinAndPasscodeFromProfilePage {

	
	private String cardNum;
	private String env;
	
		
	public void openProfileButtonFromHome(String environment, String cardNum) throws Exception {
		this.env = environment;
		this.cardNum = cardNum;
		System.out.println("card found after is:" + cardNum);
		System.out.println("I am in Reset Pin And Passcode From Profile Page environment is:" + environment);
		openProfileButtonFromHome();
	}
	



	
	

	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS xpath = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	 AppiumDriver<WebElement> driver;

	
	Wait appWait = new Wait();
	InputText appText = new InputText();
	String cardFound = "0000";
	int lastFour;
	String passwordOrPin = "SECURE_FUEL_0561_PIN";

		public ResetPinAndPasscodeFromProfilePage openProfileButtonFromHome() throws Exception {
		
			iOSText = new AppStringsiOS(env);
			iOSLogs.setupTest("Profile and account testing ");
		
			
			WebElement ProfileButtonFromHome = xpath.ProfileButton();
			Thread.sleep(3000);
			if (ProfileButtonFromHome != null && ProfileButtonFromHome.isEnabled()) {
				ProfileButtonFromHome.click();
				iOSLogs.CapturedLogs(pass, "Profile Button is found and pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Profile Button is not found");
			}
			
				

			
			switch (cardNum) {
			case "6344":  lastFour = 1;
			iOSLogs.CapturedLogs(iOSText.INFO, "Card 6344 found");
			passwordOrPin = "CARDPIN_LOGIN_PIN_6344";
			break;
			
			case "0561": lastFour = 2;
			//TODO Add database login
			iOSLogs.CapturedLogs(iOSText.INFO, "Card 0561 found");
			passwordOrPin = "SECURE_FUEL_0561_PIN";
			break;
			
			case "5542": lastFour = 3;
			iOSLogs.CapturedLogs(iOSText.INFO, "Card 5542 found");
			passwordOrPin = "FORGOT_PIN_PASSCODE_5542_PASSCODE";
			break;
			
			case "2800": lastFour = 4;
			//TODO Add database login
			iOSLogs.CapturedLogs(iOSText.INFO, "Card 2800 found");
			passwordOrPin = "ACH_2800_PIN";
			break;
						
			default:
			iOSLogs.CapturedLogs(iOSText.INFO, "No Card number on profile page found");
		
		}
			
			

			
			Thread.sleep(3000);
			WebElement ChangePinOnProfile = xpath.ChangePinOnProfile();
			if (ChangePinOnProfile != null && ChangePinOnProfile.isEnabled()) {
				ChangePinOnProfile.click();
				iOSLogs.CapturedLogs(pass, "Change PIN on profile Button is found and pressed");
				
				Thread.sleep(3000);
				WebElement CurrentPinOnProfile = xpath.CurrentPinOnProfile();
				if (CurrentPinOnProfile != null && CurrentPinOnProfile.isEnabled()) {
					CurrentPinOnProfile.click();
					CurrentPinOnProfile.sendKeys(iOSText.getENVData(passwordOrPin));
					
					iOSLogs.CapturedLogs(pass, "Current PIN textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Current PIN Button is not found");
				}
				
				
				Thread.sleep(3000);
				WebElement NewPinOnProfile = xpath.NewPinOnProfile();
				if (NewPinOnProfile != null && NewPinOnProfile.isEnabled()) {
					NewPinOnProfile.click();
					CurrentPinOnProfile.sendKeys(iOSText.getENVData(passwordOrPin));
					iOSLogs.CapturedLogs(pass, "New PIN textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "New PIN is not found");
				}
				
				Thread.sleep(3000);
				WebElement ConfirmNewPinOnProfile = xpath.ConfirmNewPinOnProfile();
				if (ConfirmNewPinOnProfile != null && ConfirmNewPinOnProfile.isEnabled()) {
					ConfirmNewPinOnProfile.click();
					CurrentPinOnProfile.sendKeys(iOSText.getENVData(passwordOrPin));
					iOSLogs.CapturedLogs(pass, "Confirm new PIN textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Confirm new Pin Button is not found");
				}
				
				Thread.sleep(3000);
				WebElement SaveNewPinOnProfile = xpath.SaveNewPinOnProfile();
				if (SaveNewPinOnProfile != null && SaveNewPinOnProfile.isEnabled()) {
					SaveNewPinOnProfile.click();
					iOSLogs.CapturedLogs(pass, "Save New Pin On Profile is found and selected");
				} else {
					iOSLogs.CapturedLogs(fail, "Save New Pin On Profile button is not found");
				}
				
				
				
			} else {
				iOSLogs.CapturedLogs(info, "Change PIN on profile Button is not found or is a passcode card");
			}
			
			
			
			
			Thread.sleep(3000);
			WebElement ChangePasscodeOnProfile = xpath.ChangePasscodeOnProfile();
			if (ChangePasscodeOnProfile != null && ChangePasscodeOnProfile.isEnabled()) {
				ChangePasscodeOnProfile.click();
				iOSLogs.CapturedLogs(pass, "Change passcocde on profile Button is found and pressed");
				
				Thread.sleep(3000);
				WebElement CurrentPasscodeOnProfile = xpath.CurrentPasscodeOnProfile();
				if (CurrentPasscodeOnProfile != null && CurrentPasscodeOnProfile.isEnabled()) {
					CurrentPasscodeOnProfile.click();
					CurrentPasscodeOnProfile.sendKeys(iOSText.getENVData(passwordOrPin));
					
					iOSLogs.CapturedLogs(pass, "Current passcode textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Profile passcode Button is not found");
				}
				
				
				Thread.sleep(3000);
				WebElement NewPasscodeOnProfile = xpath.NewPasscodeOnProfile();
				if (NewPasscodeOnProfile != null && NewPasscodeOnProfile.isEnabled()) {
					NewPasscodeOnProfile.click();
					NewPasscodeOnProfile.sendKeys(iOSText.getENVData(passwordOrPin));
					iOSLogs.CapturedLogs(pass, "New passcode textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "New passcode Button is not found");
				}
				
				Thread.sleep(3000);
				WebElement ConfirmNewPasscodeOnProfile = xpath.ConfirmNewPasscodeOnProfile();
				if (ConfirmNewPasscodeOnProfile != null && ConfirmNewPasscodeOnProfile.isEnabled()) {
					ConfirmNewPasscodeOnProfile.click();
					ConfirmNewPasscodeOnProfile.sendKeys(iOSText.getENVData(passwordOrPin));
					iOSLogs.CapturedLogs(pass, "Confirm new passcode textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Confirm new passcode Button is not found");
				}
				
				Thread.sleep(3000);
				WebElement SaveNewPasscodeOnProfile = xpath.SaveNewPasscodeOnProfile();
				if (SaveNewPasscodeOnProfile != null && SaveNewPasscodeOnProfile.isEnabled()) {
					SaveNewPasscodeOnProfile.click();
					iOSLogs.CapturedLogs(pass, "Save New passcode On Profile is found and selected");
				} else {
					iOSLogs.CapturedLogs(fail, "Save New passcode On Profile button is not found");
				}
				
				
				
			} else {
				iOSLogs.CapturedLogs(info, "Change passcode on profile Button is not found or is a PIN card");
			}
			
			
			
			
//TODO add all other profile page items....			
			
			
					
			Thread.sleep(5000);
			WebElement CloseProfileButton = xpath.CloseProfileButton();
			if (CloseProfileButton != null && CloseProfileButton.isEnabled()) {
				CloseProfileButton.click();
				iOSLogs.CapturedLogs(pass, "Close profile button is found and selected");
			} else {
				iOSLogs.CapturedLogs(fail, "Close profile button is not found");
			}
				

				return this;

			}

}
