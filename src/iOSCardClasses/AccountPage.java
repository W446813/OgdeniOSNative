package iOSCardClasses;

import org.openqa.selenium.WebElement;
import iOSCarrierClasses.InputText;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.ScrollOptionsiOS;
import iOSsharedClasses.Sleep;
import iOSsharedClasses.Wait;
import io.appium.java_client.AppiumDriver;

public class AccountPage {

	
	private String cardNum;
	private String env;
	private String pinOrPasscode;
	private String appVersionNumber;
	
	public void openProfileButtonFromHome(String environment, String cardNum, String pin) throws Exception {
		this.env = environment;
		this.cardNum = cardNum;
		this.pinOrPasscode = pin;
		System.out.println("card found after is:" + cardNum);
		System.out.println("I am in Account Page environment is:" + environment);
		openProfileButtonFromHome();
	}
	


	ScrollOptionsiOS scroll = new ScrollOptionsiOS();
	EnvironmentPicker environmentPicker = new EnvironmentPicker();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	RepoCardiOS elements = new RepoCardiOS();
	Sleep appSleep = new Sleep();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	 AppiumDriver<WebElement> driver;

	
	Wait appWait = new Wait();


		public AccountPage openProfileButtonFromHome() throws Exception {
		
			iOSText = new AppStringsiOS(env);
			iOSLogs.setupTest("Profile and account testing ");
		
			Thread.sleep(3000);
			WebElement ProfileButtonFromHome = elements.ProfileButton();
			Thread.sleep(3000);
			if (ProfileButtonFromHome != null && ProfileButtonFromHome.isEnabled()) {
				ProfileButtonFromHome.click();
				iOSLogs.CapturedLogs(pass, "Profile Button is found and pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Profile Button is not found");
			}
			
			
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}
			
			//Verify account page is loaded with Card Holder info;
			Thread.sleep(5000);
			WebElement ProfileCardHolderInfoLoaded = elements.ProfileCardHolderInfoLoaded();
			Thread.sleep(5000);
			if (ProfileCardHolderInfoLoaded != null && ProfileCardHolderInfoLoaded.isEnabled()) {
				iOSLogs.CapturedLogs(pass, "Card holder information screen loaded");			


//Change pin on profile page 			
			Thread.sleep(3000);
			WebElement ChangePinOnProfile = elements.ChangePinOnProfile();
			Thread.sleep(3000);
			if (ChangePinOnProfile != null && ChangePinOnProfile.isEnabled()) {
				ChangePinOnProfile.click();
				iOSLogs.CapturedLogs(pass, "Change PIN on profile Button is found and pressed");
				
				Thread.sleep(3000);
				WebElement CurrentPinOnProfile = elements.CurrentPinOnProfile();
				Thread.sleep(3000);
				if (CurrentPinOnProfile != null && CurrentPinOnProfile.isEnabled()) {
					CurrentPinOnProfile.click();
					CurrentPinOnProfile.sendKeys(pinOrPasscode);
					
					iOSLogs.CapturedLogs(pass, "Current PIN textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Current PIN Button is not found");
				}
				
				
				Thread.sleep(3000);
				WebElement NewPinOnProfile = elements.NewPinOnProfile();
				Thread.sleep(3000);
				if (NewPinOnProfile != null && NewPinOnProfile.isEnabled()) {
					NewPinOnProfile.click();
					CurrentPinOnProfile.sendKeys(pinOrPasscode);
					iOSLogs.CapturedLogs(pass, "New PIN textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "New PIN is not found");
				}
				
				Thread.sleep(3000);
				WebElement ConfirmNewPinOnProfile = elements.ConfirmNewPinOnProfile();
				Thread.sleep(3000);
				if (ConfirmNewPinOnProfile != null && ConfirmNewPinOnProfile.isEnabled()) {
					ConfirmNewPinOnProfile.click();
					CurrentPinOnProfile.sendKeys(this.pinOrPasscode);
					iOSLogs.CapturedLogs(pass, "Confirm new PIN textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Confirm new Pin Button is not found");
				}
				
				Thread.sleep(3000);
				WebElement SaveNewPinOnProfile = elements.SaveNewPinOnProfile();
				Thread.sleep(3000);
				if (SaveNewPinOnProfile != null && SaveNewPinOnProfile.isEnabled()) {
					SaveNewPinOnProfile.click();
					iOSLogs.CapturedLogs(pass, "Save New Pin On Profile is found and selected");
				} else {
					iOSLogs.CapturedLogs(fail, "Save New Pin On Profile button is not found");
				}
				
				
				
			} else {
				iOSLogs.CapturedLogs(info, "Change PIN on profile Button is not found or is a passcode card");
			}
			
			
			
////Change passcode on profile page 			
			Thread.sleep(3000);
			WebElement ChangePasscodeOnProfile = elements.ChangePasscodeOnProfile();
			Thread.sleep(3000);
			if (ChangePasscodeOnProfile != null && ChangePasscodeOnProfile.isEnabled()) {
				ChangePasscodeOnProfile.click();
				iOSLogs.CapturedLogs(pass, "Change passcocde on profile Button is found and pressed");
				
				Thread.sleep(3000);
				WebElement CurrentPasscodeOnProfile = elements.CurrentPasscodeOnProfile();
				Thread.sleep(3000);
				if (CurrentPasscodeOnProfile != null && CurrentPasscodeOnProfile.isEnabled()) {
					CurrentPasscodeOnProfile.click();
					CurrentPasscodeOnProfile.sendKeys(this.pinOrPasscode);
					
					iOSLogs.CapturedLogs(pass, "Current passcode textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Profile passcode Button is not found");
				}
				
				
				Thread.sleep(3000);
				WebElement NewPasscodeOnProfile = elements.NewPasscodeOnProfile();
				Thread.sleep(3000);
				if (NewPasscodeOnProfile != null && NewPasscodeOnProfile.isEnabled()) {
					NewPasscodeOnProfile.click();
					NewPasscodeOnProfile.sendKeys(pinOrPasscode);
					iOSLogs.CapturedLogs(pass, "New passcode textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "New passcode Button is not found");
				}
				
				Thread.sleep(3000);
				WebElement ConfirmNewPasscodeOnProfile = elements.ConfirmNewPasscodeOnProfile();
				Thread.sleep(3000);
				if (ConfirmNewPasscodeOnProfile != null && ConfirmNewPasscodeOnProfile.isEnabled()) {
					ConfirmNewPasscodeOnProfile.click();
					ConfirmNewPasscodeOnProfile.sendKeys(this.pinOrPasscode);
					iOSLogs.CapturedLogs(pass, "Confirm new passcode textbox is found and current PIN entered");
				} else {
					iOSLogs.CapturedLogs(fail, "Confirm new passcode Button is not found");
				}
				
				Thread.sleep(3000);
				WebElement SaveNewPasscodeOnProfile = elements.SaveNewPasscodeOnProfile();
				Thread.sleep(3000);
				if (SaveNewPasscodeOnProfile != null && SaveNewPasscodeOnProfile.isEnabled()) {
					SaveNewPasscodeOnProfile.click();
					iOSLogs.CapturedLogs(pass, "Save New passcode On Profile is found and selected");
				} else {
					iOSLogs.CapturedLogs(fail, "Save New passcode On Profile button is not found");
			}
				
				
				
			} else {
				iOSLogs.CapturedLogs(info, "Change passcode on profile Button is not found or is a PIN card");
			}
			

			
//This section tests and updated the profile name and details if it fails it puts the wrong info on the account Skipping probably should be done manually... 		
//TODO No way to open this because it is not named each account is different and it is names as the name shown			
//Edit profile from account page 
//			Thread.sleep(3000);
//			WebElement editCardHolderInfoButton = elements.editCardHolderInfoButton();
//			Thread.sleep(3000);
//			if (editCardHolderInfoButton != null && editCardHolderInfoButton.isEnabled()) {
//				editCardHolderInfoButton.click();
//				iOSLogs.CapturedLogs(pass, "Edit Card Holder Info found and pressed.");
//				
//				
//				Thread.sleep(3000);
//				WebElement OpenEditName = elements.OpenEditName();
//				Thread.sleep(3000);
//				if (OpenEditName  != null && OpenEditName.isEnabled()) {
//					OpenEditName.click();
//					iOSLogs.CapturedLogs(pass, "Edit Name button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Name button button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement EditFirstName = elements.EditFirstName();
//				Thread.sleep(3000);
//				if (EditFirstName  != null && EditFirstName.isEnabled()) {
//					EditFirstName.click();
//					EditFirstName.sendKeys(androidText.FIRST_NAME);
//					iOSLogs.CapturedLogs(pass, "Edit First Name textBox found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit First Name textBox was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement EditLastName = elements.EditLastName();
//				Thread.sleep(3000);
//				if (EditLastName  != null && EditLastName.isEnabled()) {
//					EditLastName.click();
//					EditLastName.sendKeys(androidText.LAST_NAME);
//					iOSLogs.CapturedLogs(pass, "Edit First Name textBox found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit First Name textBox was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement SaveName = elements.SaveName();
//				Thread.sleep(3000);
//				if (SaveName  != null && SaveName.isEnabled()) {
//					SaveName.click();
//					
//					iOSLogs.CapturedLogs(pass, "Save Name Button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Save Name Button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement OpenEditEmail = elements.OpenEditEmail();
//				Thread.sleep(3000);
//				if (OpenEditEmail  != null && OpenEditEmail.isEnabled()) {
//					OpenEditEmail.click();
//					
//					iOSLogs.CapturedLogs(pass, "Open email button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Open email Button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement editEmailAddress = elements.editEmailAddress();
//				Thread.sleep(3000);
//				if (editEmailAddress  != null && editEmailAddress.isEnabled()) {
//					editEmailAddress.click();
//					editEmailAddress.sendKeys(androidText.EMAIL_ADDRESS);
//					iOSLogs.CapturedLogs(pass, "Edit Email Name textBox found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Email Name textBox was not found");
//				}
//				
//				
//				Thread.sleep(3000);
//				WebElement SaveEmail = elements.SaveEmail();
//				Thread.sleep(3000);
//				if (SaveEmail  != null && SaveEmail.isEnabled()) {
//					SaveEmail.click();
//					
//					iOSLogs.CapturedLogs(pass, "Save Email Button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Save EmailName Button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement OpenEditMobilePhone = elements.OpenEditMobilePhone();
//				Thread.sleep(3000);
//				if (OpenEditMobilePhone  != null && OpenEditMobilePhone.isEnabled()) {
//					OpenEditMobilePhone.click();
//					
//					iOSLogs.CapturedLogs(pass, "Edit Mobile Phone Button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Mobile Phone Buttonwas not found");
//				}
//				
//				
//				Thread.sleep(3000);
//				WebElement EditMobilePhone = elements.EditMobilePhone();
//				Thread.sleep(3000);
//				if (EditMobilePhone  != null && EditMobilePhone.isEnabled()) {
//					EditMobilePhone.click();
//					EditMobilePhone.sendKeys(androidText.PHONE_NUMBER);
//					iOSLogs.CapturedLogs(pass, "Edit Mobile Phone textBox found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Mobile Phone textBox was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement SavePhone = elements.SavePhone();
//				Thread.sleep(3000);
//				if (SavePhone  != null && SavePhone.isEnabled()) {
//					SavePhone.click();
//					
//					iOSLogs.CapturedLogs(pass, "Save Mobile Phone Button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Save Mobile Phone Button was not found");
//				}
//				
//				
//				Thread.sleep(3000);
//				WebElement OpenEditHomeAddress = elements.OpenEditHomeAddress();
//				Thread.sleep(3000);
//				if (OpenEditHomeAddress  != null && OpenEditHomeAddress.isEnabled()) {
//					OpenEditHomeAddress.click();
//					
//					iOSLogs.CapturedLogs(pass, "Edit Home Address Button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(info, "Edit Home Address Button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement CloseHomeAddress = elements.CloseHomeAddress();
//				Thread.sleep(3000);
//				if (CloseHomeAddress  != null && CloseHomeAddress.isEnabled()) {
//					CloseHomeAddress.click();
//					
//					iOSLogs.CapturedLogs(pass, "Close Home Address Button found and selected");
//					iOSLogs.CapturedLogs(info, "Closing home address no update because VPN does not allow for address lookup");
//				} else {
//					iOSLogs.CapturedLogs(info, "Close Home Address Button was not found");
//				}
				
				
//				Thread.sleep(3000);
//				WebElement closeProfileXButton = elements.closeProfileXButton();
//				Thread.sleep(3000);
//				if (closeProfileXButton != null && closeProfileXButton.isEnabled()) {
//					closeProfileXButton.click();
//					iOSLogs.CapturedLogs(pass, "Edit Card Holder Info close Button is found and pressed.");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Edit Card Holder Info close Button is not found");
//				}			
				
				
				
//			} else {
//				iOSLogs.CapturedLogs(info, "Edit Card Holder Info is not found");
//			}
			
			
			
			
	//TODO Bank Accounts
		
			
	//SmartFunds alert settings
			Thread.sleep(3000);
			WebElement SmartFundsAlertsButton = elements.SmartFundsAlertsButton();
			Thread.sleep(3000);
			if (SmartFundsAlertsButton  != null && SmartFundsAlertsButton.isEnabled()) {
				SmartFundsAlertsButton.click();
				iOSLogs.CapturedLogs(pass, "SmartFunds Alerts button found and selected");
				
				
				Thread.sleep(3000);
				WebElement SmartFundsAlertsCloseButton = elements.SmartFundsAlertsCloseButton();
				Thread.sleep(3000);
				if (SmartFundsAlertsCloseButton  != null && SmartFundsAlertsCloseButton.isEnabled()) {
					SmartFundsAlertsCloseButton.click();
					iOSLogs.CapturedLogs(pass, "SmartFunds Alerts close button found and selected");
				} else {
					iOSLogs.CapturedLogs(info, "SmartFunds Alerts close button was not found");
				}
				
				
			} else {
				iOSLogs.CapturedLogs(info, "SmartFunds Alerts button was not found");
			}			
			
			
			
	//SmartFunds Statements
			Thread.sleep(3000);
			WebElement SmartFundsstatementsButton = elements.SmartFundsstatementsButton();
			Thread.sleep(3000);
			if (SmartFundsstatementsButton  != null && SmartFundsstatementsButton.isEnabled()) {
				SmartFundsstatementsButton.click();
				iOSLogs.CapturedLogs(pass, "Statement button found and selected");
				iOSLogs.CapturedLogs(pass, "Due to long loading tinme Skipping opening one");
				
				Thread.sleep(3000);
				WebElement SmartFundsstatementsCloseButton = elements.SmartFundsstatementsCloseButton();
				Thread.sleep(3000);
				if (SmartFundsstatementsCloseButton  != null && SmartFundsstatementsCloseButton.isEnabled()) {
					SmartFundsstatementsCloseButton.click();
					iOSLogs.CapturedLogs(pass, "Statement close button found and selected");
				} else {
					iOSLogs.CapturedLogs(info, "Statement close button was not found");
				}
				
				
			} else {
				iOSLogs.CapturedLogs(info, "Statement button was not found");
			}			
			
			
			
			Thread.sleep(3000);
			Thread.sleep(3000);
			scroll.ScrollDown();
			scroll.ScrollDown();
			
//TODO PROGRAMERS NEED TO NAME THIS XPATH			
	//Toggle biometrics Use Touch ID option
			Thread.sleep(3000);
			WebElement TouchIDBiometricsToggle = elements.TouchIDBiometricsToggle();
			Thread.sleep(3000);
			if (TouchIDBiometricsToggle  != null && TouchIDBiometricsToggle.isEnabled()) {
				TouchIDBiometricsToggle.click();
				iOSLogs.CapturedLogs(pass, "Biometrics toggle found and selected");
			} else {
				iOSLogs.CapturedLogs(fail, "Biometrics toggle was not found");
			}		
			
			Thread.sleep(3000);
			WebElement TouchIDBiometricsToggleDenyModal = elements.TouchIDBiometricsToggleDenyModal();
			Thread.sleep(3000);
			if (TouchIDBiometricsToggleDenyModal  != null && TouchIDBiometricsToggleDenyModal.isEnabled()) {
				TouchIDBiometricsToggleDenyModal.click();
				iOSLogs.CapturedLogs(pass, "Biometrics Deny modal button found and selected");
			} else {
				iOSLogs.CapturedLogs(fail, "Biometrics Deny modal button was not found");
			}		
			Thread.sleep(3000);

	//Security questions
	//TODO IT IS NOT PICKING NEW SEQURITY QUESTIONS FOR SOME REASON... fix it..
//			Thread.sleep(3000);
//			WebElement SecurityQuestions = elements.SecurityQuestions();
//			Thread.sleep(3000);
//			if (SecurityQuestions  != null && SecurityQuestions.isEnabled()) {
//				SecurityQuestions.click();
//				iOSLogs.CapturedLogs(pass, "Security Questions button found and selected");
//				
//				
//				Thread.sleep(3000);
//				WebElement OpenSecurityQuestionOne = elements.OpenSecurityQuestionOne();
//				Thread.sleep(3000);
//				if (OpenSecurityQuestionOne  != null && OpenSecurityQuestionOne.isEnabled()) {
//					OpenSecurityQuestionOne.click();
//					iOSLogs.CapturedLogs(pass, "Security question one found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question one was not found");
//				}		
//			
//				Thread.sleep(3000);
//				WebElement PickNewSecurityQuesrtionOne = elements.PickNewSecurityQuesrtionOne();
//				Thread.sleep(3000);
//				if (PickNewSecurityQuesrtionOne  != null && PickNewSecurityQuesrtionOne.isEnabled()) {
//					PickNewSecurityQuesrtionOne.click();
//					iOSLogs.CapturedLogs(pass, "New security question one found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "New security question one was not found");
//				}		
				
//				Thread.sleep(3000);
//				WebElement CloseNewSecurityOne = elements.CloseNewSecurityOne();
//				Thread.sleep(3000);
//				if (CloseNewSecurityOne  != null && CloseNewSecurityOne.isEnabled()) {
//					CloseNewSecurityOne.click();
//					iOSLogs.CapturedLogs(pass, "New Security question page closed");
//				} else {
//					iOSLogs.CapturedLogs(fail, "SNew security question close not found");
//				}		
				

//				Thread.sleep(3000);
//				WebElement AnswerSecurityQuestionOne = elements.AnswerSecurityQuestionOne();
//				Thread.sleep(3000);
//				if (AnswerSecurityQuestionOne  != null && AnswerSecurityQuestionOne.isEnabled()) {
//					AnswerSecurityQuestionOne.click();
//					AnswerSecurityQuestionOne.sendKeys(androidText.SEC_ANSWERS);
//					iOSLogs.CapturedLogs(pass, "Security question one found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question one was not found");
//				}		
//			
//				
//				
//				Thread.sleep(3000);
//				WebElement SaveSecurityQuestionOne = elements.SaveSecurityQuestions();
//				Thread.sleep(3000);
//				if (SaveSecurityQuestionOne  != null && SaveSecurityQuestionOne.isEnabled()) {
//					SaveSecurityQuestionOne.click();
//					iOSLogs.CapturedLogs(pass, "Security question one save button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question one save button was not found");
//				}		
//			
//				
//				
//				Thread.sleep(3000);
//				WebElement OpenSecurityQuestionTwo = elements.OpenSecurityQuestionTwo();
//				Thread.sleep(3000);
//				if (OpenSecurityQuestionTwo  != null && OpenSecurityQuestionTwo.isEnabled()) {
//					OpenSecurityQuestionTwo.click();
//					iOSLogs.CapturedLogs(pass, "Security question two found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question two was not found");
//				}		
//				
//				
//				Thread.sleep(3000);
//				WebElement PickNewSecurityQuesrtionTwo = elements.PickNewSecurityQuesrtionTwo();
//				Thread.sleep(3000);
//				if (PickNewSecurityQuesrtionTwo  != null && PickNewSecurityQuesrtionTwo.isEnabled()) {
//					PickNewSecurityQuesrtionTwo.click();
//					iOSLogs.CapturedLogs(pass, "New security question two found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "New security question two was not found");
//				}		
				
				
//				Thread.sleep(3000);
//				WebElement CloseNewSecuritytwo = elements.CloseNewSecuritytwo();
//				Thread.sleep(3000);
//				if (CloseNewSecuritytwo  != null && CloseNewSecuritytwo.isEnabled()) {
//					CloseNewSecuritytwo.click();
//					iOSLogs.CapturedLogs(pass, "Security questions two close page found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security questions two close page was not found");
//				}		
			
				

//				Thread.sleep(3000);
//				WebElement AnswerSecurityQuestionTwo = elements.AnswerSecurityQuestionTwo();
//				Thread.sleep(3000);
//				if (AnswerSecurityQuestionTwo  != null && AnswerSecurityQuestionTwo.isEnabled()) {
//					AnswerSecurityQuestionTwo.click();
//					AnswerSecurityQuestionTwo.sendKeys(androidText.SEC_ANSWERS);
//					iOSLogs.CapturedLogs(pass, "Security question two found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question two was not found");
//				}		
//			
//				
//				
//				Thread.sleep(3000);
//				WebElement SaveSecurityQuestionTwo = elements.SaveSecurityQuestions();
//				Thread.sleep(3000);
//				if (SaveSecurityQuestionTwo  != null && SaveSecurityQuestionTwo.isEnabled()) {
//					SaveSecurityQuestionTwo.click();
//					iOSLogs.CapturedLogs(pass, "Security question two save button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question two save button was not found");
//				}		
//				
//				
//				
//				
//				
//				Thread.sleep(3000);
//				WebElement OpenSecurityQuestionThree = elements.OpenSecurityQuestionThree();
//				Thread.sleep(3000);
//				if (OpenSecurityQuestionThree  != null && OpenSecurityQuestionThree.isEnabled()) {
//					OpenSecurityQuestionThree.click();
//					iOSLogs.CapturedLogs(pass, "Security question one found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question one was not found");
//				}		
//			
//				
//				Thread.sleep(3000);
//				WebElement PickNewSecurityQuesrtionThree = elements.PickNewSecurityQuesrtionThree();
//				Thread.sleep(3000);
//				if (PickNewSecurityQuesrtionThree  != null && PickNewSecurityQuesrtionThree.isEnabled()) {
//					PickNewSecurityQuesrtionThree.click();
//					iOSLogs.CapturedLogs(pass, "New security question three found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "New security question three was not found");
//				}		
//				
//
//				Thread.sleep(3000);
//				WebElement AnswerSecurityQuestionThree = elements.AnswerSecurityQuestionThree();
//				Thread.sleep(3000);
//				if (AnswerSecurityQuestionThree  != null && AnswerSecurityQuestionThree.isEnabled()) {
//					AnswerSecurityQuestionThree.click();
//					AnswerSecurityQuestionThree.sendKeys(androidText.SEC_ANSWERS);
//					iOSLogs.CapturedLogs(pass, "Security question three found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question three was not found");
//				}		
//			
//				
//				
//				Thread.sleep(3000);
//				WebElement SaveSecurityQuestionThree = elements.SaveSecurityQuestions();
//				Thread.sleep(3000);
//				if (SaveSecurityQuestionThree  != null && SaveSecurityQuestionThree.isEnabled()) {
//					SaveSecurityQuestionThree.click();
//					iOSLogs.CapturedLogs(pass, "Security question three save button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question three save button was not found");
//				}		
//				
//				Thread.sleep(3000);
//				WebElement CloseSecurityQuestionPage = elements.CloseSecurityQuestionPage();
//				Thread.sleep(3000);
//				if (CloseSecurityQuestionPage  != null && CloseSecurityQuestionPage.isEnabled()) {
//					CloseSecurityQuestionPage.click();
//					iOSLogs.CapturedLogs(pass, "Security question three save button found and selected");
//				} else {
//					iOSLogs.CapturedLogs(fail, "Security question three save button was not found");
//				}		
//				
//				
//			} else {
//				iOSLogs.CapturedLogs(info, "Security Questions button was not found");
//			}
			
			
//TODO XPATHS ARE NOT VISIBLE			
//Help Screens
					// Find and open helps screens
//					Thread.sleep(3000);
//					WebElement HelpScreenOpenButton = elements.HelpScreenOpenButton();
//					Thread.sleep(3000);
//					if (HelpScreenOpenButton  != null && HelpScreenOpenButton.isEnabled()) {
//						HelpScreenOpenButton.click();
//						iOSLogs.CapturedLogs(pass, "Help Screens button from home page is found and pressed");
//
//					
//					Thread.sleep(3000);
//					WebElement HelpScreensHome = elements.HelpScreensHome();
//					Thread.sleep(3000);
//					if (HelpScreensHome  != null && HelpScreensHome.isEnabled()) {
//						HelpScreensHome.click();
//						iOSLogs.CapturedLogs(pass, "Help Screens home button is found and pressed");
//						
//						Thread.sleep(3000);
//						WebElement HelpScreensHomeCloseButton = elements.HelpScreensCloseButton();
//						Thread.sleep(3000);
//						if (HelpScreensHomeCloseButton  != null && HelpScreensHomeCloseButton.isEnabled()) {
//							HelpScreensHomeCloseButton.click();
//							iOSLogs.CapturedLogs(pass, "Help Home close button is found and pressed");
//						} else {
//							iOSLogs.CapturedLogs(info, "Help Home close button was not found");
//						}
//						
//						
//					} else {
//						iOSLogs.CapturedLogs(info, "Help Screens home button was not found");
//					}
//
//					
//					
//					
//					Thread.sleep(3000);
//					WebElement HelpScreensAccount = elements.HelpScreensAccount();
//					Thread.sleep(3000);
//					if (HelpScreensAccount  != null && HelpScreensAccount.isEnabled()) {
//						HelpScreensAccount.click();
//						iOSLogs.CapturedLogs(pass, "Account button is found and pressed");
//						
//						Thread.sleep(3000);
//						WebElement HelpScreensCloseButtonAccount = elements.HelpScreensCloseButton();
//						Thread.sleep(3000);
//						if (HelpScreensCloseButtonAccount  != null && HelpScreensCloseButtonAccount.isEnabled()) {
//							HelpScreensCloseButtonAccount.click();
//							iOSLogs.CapturedLogs(pass, "Help Account close button is found and pressed");
//						} else {
//							iOSLogs.CapturedLogs(info, "Help Account close button was not found");
//						}
//						
//					} else {
//						iOSLogs.CapturedLogs(info, "Account button was not found");
//					}
//					
//					
//					
//
//					Thread.sleep(3000);
//					WebElement HelpScreensTransactions = elements.HelpScreensTransactions();
//					Thread.sleep(3000);
//					if (HelpScreensTransactions  != null && HelpScreensTransactions.isEnabled()) {
//						HelpScreensTransactions.click();
//						iOSLogs.CapturedLogs(pass, "Transactions button is found and pressed");
//						
//						Thread.sleep(3000);
//						WebElement HelpScreensCloseButtonTransactions = elements.HelpScreensCloseButton();
//						Thread.sleep(3000);
//						if (HelpScreensCloseButtonTransactions  != null && HelpScreensCloseButtonTransactions.isEnabled()) {
//							HelpScreensCloseButtonTransactions.click();
//							iOSLogs.CapturedLogs(pass, "Help Transactions close button is found and pressed");
//						} else {
//							iOSLogs.CapturedLogs(info, "Help Transactions close button was not found");
//						}		
//					} else {
//						iOSLogs.CapturedLogs(info, "Transactions button was not found");
//					}
//					
//							
//
//					Thread.sleep(3000);
//					WebElement HelpScreensFindFuelNearby = elements.HelpScreensFindFuelNearby();
//					Thread.sleep(3000);
//					if (HelpScreensFindFuelNearby  != null && HelpScreensFindFuelNearby.isEnabled()) {
//						HelpScreensFindFuelNearby.click();
//						iOSLogs.CapturedLogs(pass, "Find Fuel nearby button is found and pressed");
//						
//						Thread.sleep(3000);
//						WebElement HelpScreensCloseButtonFindFuel = elements.HelpScreensCloseButton();
//						Thread.sleep(3000);
//						if (HelpScreensCloseButtonFindFuel  != null && HelpScreensCloseButtonFindFuel.isEnabled()) {
//							HelpScreensCloseButtonFindFuel.click();
//							iOSLogs.CapturedLogs(pass, "Help Find Fuel nearby close button is found and pressed");
//						} else {
//							iOSLogs.CapturedLogs(info, "Help Find Fuel nearby close button was not found");
//						}		
//						
//					} else {
//						iOSLogs.CapturedLogs(info, "Find Fuel nearby button button was not found");
//					}
//					
//					
//
//					Thread.sleep(3000);
//					WebElement HelpScreensFindFuelPlanATrip = elements.HelpScreensFindFuelPlanATrip();
//					Thread.sleep(3000);
//					if (HelpScreensFindFuelPlanATrip  != null && HelpScreensFindFuelPlanATrip.isEnabled()) {
//						HelpScreensFindFuelPlanATrip.click();
//						iOSLogs.CapturedLogs(pass, "Find Fuel plan a trip button is found and pressed");
//						
//						Thread.sleep(3000);
//						WebElement HelpScreensCloseButtonTrip = elements.HelpScreensCloseButton();
//						Thread.sleep(3000);
//						if (HelpScreensCloseButtonTrip  != null && HelpScreensCloseButtonTrip.isEnabled()) {
//							HelpScreensCloseButtonTrip.click();
//							iOSLogs.CapturedLogs(pass, "Help Find Fuel plan a trip close button is found and pressed");
//						} else {
//							iOSLogs.CapturedLogs(info, "Help Find Fuel plan a trip close button was not found");
//						}		
//						
//					} else {
//						iOSLogs.CapturedLogs(info, "Find Fuel plan a trip button was not found");
//					}
//
//					
//					
//					
//					
//					Thread.sleep(3000);
//					WebElement CloseHelpScreens = elements.HelpScreensCloseButton();
//					Thread.sleep(3000);
//					if (CloseHelpScreens  != null && CloseHelpScreens.isEnabled()) {
//						CloseHelpScreens.click();
//						iOSLogs.CapturedLogs(pass, "Help screens close button is found and pressed");
//					} else {
//						iOSLogs.CapturedLogs(info, "Help screensclose button was not found");
//					}		
//					
//				} else {
//				  iOSLogs.CapturedLogs(fail, "Help Screens button from home page was not found");
//			}
					
			
	//Privacy policy
					Thread.sleep(3000);
					WebElement PrivacyPolicy = elements.PrivacyPolicy();
					Thread.sleep(3000);
					if (PrivacyPolicy  != null && PrivacyPolicy.isEnabled()) {
						PrivacyPolicy.click();
						iOSLogs.CapturedLogs(pass, "Privacy Policy button found and selected");
					} else {
						iOSLogs.CapturedLogs(fail, "Privacy Policy button was not found");
					}		
					
					Thread.sleep(3000);
					WebElement PrivacyPolicyClose = elements.PrivacyPolicyClose();
					Thread.sleep(3000);
					if (PrivacyPolicyClose  != null && PrivacyPolicyClose.isEnabled()) {
						PrivacyPolicyClose.click();
						iOSLogs.CapturedLogs(pass, "Privacy Policy Close button found and selected");
					} else {
						iOSLogs.CapturedLogs(fail, "Privacy Policy Close button was not found");
					}		

	//Terms Of Use
					Thread.sleep(3000);
					WebElement TermsOfUse = elements.TermsOfUse();
					Thread.sleep(3000);
					if (TermsOfUse  != null && TermsOfUse.isEnabled()) {
						TermsOfUse.click();
						iOSLogs.CapturedLogs(pass, "Terms of use button found and selected");
					} else {
						iOSLogs.CapturedLogs(fail, "Terms of use button was not found");
					}		
					Thread.sleep(3000);
					WebElement TermsOfUseClose = elements.TermsOfUseClose();
					Thread.sleep(3000);
					if (TermsOfUseClose  != null && TermsOfUseClose.isEnabled()) {
						TermsOfUseClose.click();
						iOSLogs.CapturedLogs(pass, "Terms Of Use Close button found and selected");
					} else {
						iOSLogs.CapturedLogs(fail, "Terms Of Use Close button was not found");
					}
					
	//Call Customer service
					Thread.sleep(3000);
					WebElement CallCustomerSupportButton = elements.CallCustomerSupportButton();
					Thread.sleep(3000);
					if (CallCustomerSupportButton  != null && CallCustomerSupportButton.isEnabled()) {
						CallCustomerSupportButton.click();
						iOSLogs.CapturedLogs(pass, "Call customer support button found and selected");
					} else {
						iOSLogs.CapturedLogs(fail, "Call customer support was not found");
					}		
							
					Thread.sleep(3000);
					WebElement CloseCustomerSupportButton = elements.CloseCustomerSupportButton();
					Thread.sleep(3000);
					if (CloseCustomerSupportButton  != null && CloseCustomerSupportButton.isEnabled()) {
						CloseCustomerSupportButton.click();
						iOSLogs.CapturedLogs(pass, "Close customer support button found and selected");
					} else {
						iOSLogs.CapturedLogs(fail, "Close customer support was not found");
					}		
										
					

	//Check Version
					Thread.sleep(3000);
					WebElement AppVersionHomeAccountPage = elements.AppVersionHomeAccountPage();
					Thread.sleep(3000);
					if (AppVersionHomeAccountPage  != null && AppVersionHomeAccountPage.isEnabled()) {
						this.appVersionNumber = AppVersionHomeAccountPage.getText();
						iOSLogs.CapturedLogs(pass, "App version " +this.appVersionNumber+ " found");
					} else {
						iOSLogs.CapturedLogs(fail, "App version not found");
					}						
					
			
			
			// find logout button click it open the logout modal again and
			Thread.sleep(3000);
			WebElement CardLogoutButton = elements.CardLogoutButton();
			Thread.sleep(3000);
			if (CardLogoutButton  != null && CardLogoutButton.isEnabled()) {
					CardLogoutButton.click();
				iOSLogs.CapturedLogs(pass, "Log out button on profile page is found and pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Log out button on profile page was not found");

			}
			
			
			
			// find logout modal no button and click it as logout is in account section
//			Thread.sleep(3000);
//			WebElement CardLogoutModalCancelButton = elements.CardLogoutModalCancelButton();
//			Thread.sleep(3000);
//			if (CardLogoutModalCancelButton != null && CardLogoutModalCancelButton.isEnabled()) {
//				CardLogoutModalCancelButton.click();
//				iOSLogs.CapturedLogs(pass, "Logout Modal Cancel Button is found and pressed");
//			} else {
//				iOSLogs.CapturedLogs(fail, "Logout Modal Cancel Button is not found");
//			}
//			
//			// find logout cancel modal button click it open the logout modal again and
//			Thread.sleep(3000);
//			WebElement CardLogoutButtonTwo = elements.CardLogoutButton();
//			Thread.sleep(3000);
//			if (CardLogoutButtonTwo  != null && CardLogoutButtonTwo.isEnabled()) {
//				CardLogoutButtonTwo.click();
//				iOSLogs.CapturedLogs(pass, "Log out button on profile page is found and pressed");
//			} else {
//				iOSLogs.CapturedLogs(fail, "Log out button on profile page was not found");
//			}
			
			
			// find logout modal button and click logout from modal
			Thread.sleep(3000);
			WebElement CardlogoutModalLogoutButton = elements.CardlogoutModalLogoutButton();
			Thread.sleep(3000);
			if (CardlogoutModalLogoutButton != null && CardlogoutModalLogoutButton.isEnabled()) {
				CardlogoutModalLogoutButton.click();
				iOSLogs.CapturedLogs(pass, "Logout Modal Log Out Button is found and pressed");
			} else {
				iOSLogs.CapturedLogs(fail, "Logout Modal Log Out Button was not found");

			}
			
			} else {
				iOSLogs.CapturedLogs(fail, "Card holder information screen is not found");
			}
			
			return this;
		}

	}

			