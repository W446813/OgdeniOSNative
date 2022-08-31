package iOSCardClasses;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import iOSCarrierClasses.WelcomeScreeniOS;
import iOSsharedClasses.EnvironmentPicker;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;


public class OpenUpdateUserQuestionsLogin {
	
	 		AppiumDriver<WebElement> driver;	
//smartfunds login

			public static void openCardControl () throws Exception {
				String appName = "Card Control";
								
				Sleep appSleep = new Sleep();
				Logs keepThisLog = new Logs();
				PhonePicker phone = new PhonePicker();
				CardDirectLoginPass CardLogin = new CardDirectLoginPass();
				WelcomeScreeniOS welcome = new WelcomeScreeniOS();
				UpdateSecurityQuestionsLogin loginForSecurityQuestions = new UpdateSecurityQuestionsLogin();
				EnvironmentPicker environmentPicker=new EnvironmentPicker();
			//	PreferredContactMethodCheck PreferredTokenCheck = new PreferredContactMethodCheck();
			//	FaceIDCheck FaceIDModal = new FaceIDCheck();
				
				System.out.println(phone.autoPhonePickerCard(appName));
				keepThisLog.setupTest("Testing on 0065 Security questions starting");
				keepThisLog.CapturedLogs("------Test-----------", "----------Testing on 0065 Security questions starting-----------");
				keepThisLog.CapturedLogs("--Card Control--", "--App testing Logs started--");
				appSleep.ThreadSleep3000();
				
							
				//Make sure all account are ready for testing prior to staring 
				//Chnage to card resets and turn back on
				//ResetTestAccounts.ResetAllAccounts();	
				environmentPicker.environmentPickerButton();
				
				//closes welcome screen needs some work.... Figgure our swipe.
				//welcome.welomeScreen();
																		
				//App is given good login details and logs in successfully. 
				loginForSecurityQuestions.CardPassExpected();
				
				//add automation to delete the security questions from the databse 
				//add automation to fill in each of the three questions. 
								
				
			}

}
