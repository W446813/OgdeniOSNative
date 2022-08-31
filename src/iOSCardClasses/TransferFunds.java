package iOSCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;
import io.appium.java_client.AppiumDriver;

public class TransferFunds {
	static AppiumDriver<WebElement> driver;
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	
	
	
	
	public void TransferFunds(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		TransferFunds();
	}
		
		
	RepoCardiOS elements=new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText=new AppStringsiOS();
	OneTimeTransferFunds oneTimeTransfer =new OneTimeTransferFunds();
	RepeatDailyTransferFunds RepeatDailyTransferFunds=new RepeatDailyTransferFunds();
	RepeatWeeklyTransferFunds RepeatWeeklyTransferFunds =new RepeatWeeklyTransferFunds();
	RepeatMonthlyTransferFunds RepeatMonthlyTransferFunds=new RepeatMonthlyTransferFunds();
	RepeatOnceNewSFLoadedTransferFunds RepeatOnceNewSFLoadedTransferFunds=new RepeatOnceNewSFLoadedTransferFunds();
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;	
		
		
		
		
		
		public TransferFunds TransferFunds() throws Exception {;
		//androidText = new AppStringsAndroid(env);	
		iOSLogs.setupTest("TRANSFER FUNDS");
					
	//Help screen for home page
				Thread.sleep(3000);
				WebElement HelpScreenContinue = elements.HelpScreenContinue();
				Thread.sleep(3000);
				if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
					HelpScreenContinue.click();
					iOSLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
				} else {
					iOSLogs.CapturedLogs(info, "Help Screen continue Button is not found");
				}
		
	//Database interaction 
				System.out.println("Card Found: " + this.cardNum);
			ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
			                                                                                                                   
			ResultSet balanceDBBefore = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
			balanceDBBefore.next();
			String balanceBefore = balanceDBBefore.getString("balance");
			
			
	//Run one time transfer funds
			iOSLogs.setupTest("ON TIME TRANSFER FUNDS");
	
			//Database interaction 	
			iOSLogs.CapturedLogs(info, "Checking for transID");
			
			ResultSet trasnIDDB = dbACPTCheck.query("infx",String.format("SELECT trans_id FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
			trasnIDDB.next();
			String transID = trasnIDDB.getString("trans_id");
			iOSLogs.CapturedLogs(info, String.format("Trans ID is found as: " + transID));
			ResultSet balanceDB = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
			balanceDB.next();
			String balance = balanceDB.getString("balance");
			dbACPTCheck.execute("infx", "UPDATE payr_cash_adv SET balance ="+balanceBefore+"WHERE trans_id ="+transID);
			ResultSet balanceDBReset = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
			balanceDBReset.next();
			String resetBalance = balanceDBBefore.getString("balance");
			iOSLogs.CapturedLogs(info, String.format("Balance before transaction is: $" + balanceBefore));
			iOSLogs.CapturedLogs(info, String.format("One time transfer funds amount: $" + iOSText.TRANSFER_FUNDS_AMOUNT));
			iOSLogs.CapturedLogs(info, String.format("Balance after transaction is: $" + balance));
			iOSLogs.CapturedLogs(info, String.format("Reset balance to: $" + resetBalance));
		
		
		
		
		
		oneTimeTransfer.OneTImeTransferFunds();
		
		iOSLogs.setupTest("REPEAT DAILY TRANSFER FUNDS");
		RepeatDailyTransferFunds.RepeatDailyTransferFunds();
		
		iOSLogs.setupTest("REPEAT WEEKLY TRANSFER FUNDS");
		RepeatWeeklyTransferFunds.RepeatWeeklyTransferFunds();
		
		iOSLogs.setupTest("REPEAT MONTHLY TRANSFER FUNDS");
		RepeatMonthlyTransferFunds.RepeatMonthlyTransferFunds();
		
		iOSLogs.setupTest("REPEAT PER NEW FUNDS TRANSFER FUNDS");
		RepeatOnceNewSFLoadedTransferFunds.RepeatOnceNewSFLoadedTransferFunds();
		
		return this;
	}
}
