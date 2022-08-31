package iOSCarrierClasses;

import java.sql.ResultSet;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.ConnectionHandler;
import iOSsharedClasses.Logs;

public class ResetTestAccounts {
	
	
	//TODO Add to all 		
			private String env;
			//TODO Add to all 		
				public void ResetTestAccounts(String environment) throws Exception {
					this.env = environment;
					ResetAllAccounts();
				}

	
	public void ResetAllAccounts() throws Exception {
	Logs iOSLogs = new Logs();
	ConnectionHandler dbACPT = new ConnectionHandler(env);
	AppStringsiOS iOSText = new AppStringsiOS();
	//ConnectionHandler SIT = new ConnectionHandler();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	ResultSet CarrierStatus1 = dbACPT.query("mysql", String.format("select status_id from sec_user where user_id = %s" , "129698"));
	
	CarrierStatus1.next();
	iOSLogs.CapturedLogs(info, String.format("Carrier Account status is: %s", CarrierStatus1.getString("status_id")));

	
	if (CarrierStatus1.getString("status_id").equalsIgnoreCase("S")){
		iOSLogs.CapturedLogs(info, "Carrier 129698 Account Was Suspended prior to testing");
		dbACPT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '129698'");
		iOSLogs.CapturedLogs(info, "Account 129698 Now acctive and fail count set to 0");
	}else {
		iOSLogs.CapturedLogs(info, String.format("Carrier Account status is: %s", CarrierStatus1.getString("status_id")));
		iOSLogs.CapturedLogs(info, "Account 129698 is active and ready for testing ");

	}
	

	ResultSet card_info3 = dbACPT.query("infx", String.format("select passwd from member where member_id = %s" , "129698"));
	
	card_info3.next();
	
	if (card_info3.getString("passwd").equals("985477")) {
		iOSLogs.CapturedLogs(info, "Carrier password is as expected: 985477");
		iOSLogs.CapturedLogs(info, "Account 100045 Password is correct");
	}else {
		dbACPT.execute("infx", "update member set passwd = '985477' where member_id = '129698'");
		
		iOSLogs.CapturedLogs(info, String.format("password updated to expected from: %s", card_info3.getString("passwd")));
		iOSLogs.CapturedLogs(info, "Account 129698 password is updatd and ready for testing ");

	}
	
	
	ResultSet CarrierStatus2 = dbACPT.query("mysql", String.format("select status_id from sec_user where user_id = %s" , "102698"));
	
	
	CarrierStatus2.next();
	iOSLogs.CapturedLogs(info, String.format("Carrier Account status is: %s", CarrierStatus2.getString("status_id")));

	
	if (CarrierStatus2.getString("status_id").equals("S")) {
		iOSLogs.CapturedLogs(info, "Carrier 102698 Account Was Suspended prior to testing");
		dbACPT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '102698'");
		iOSLogs.CapturedLogs(info, "Account 102698 Now acctive and fail count set to 0");
	}else {
		iOSLogs.CapturedLogs(info, String.format("Carrier Account status is: %s", CarrierStatus2.getString("status_id")));
		iOSLogs.CapturedLogs(info, "Account 102698 is active and ready for testing ");

	}
	
	iOSLogs.CapturedLogs(info, "Database for automation test accounts Set to active and are ready for testing.");
	
	}
	
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	//things to add in the future for mysql:// 
	//changing password for subusers this one grabs the hash stores it and then changes the hash back to what it was 
		//so we don't change the actual password. Before doing this for security reasons use a password no one else would be
		//that way no one can just simply paste the hash some where. 
	
	//Step1  is have a variable  of the sec_user.user_password stored off in code.  
		//Make sure real password is not something used elseward like letmein11.  
	//Step 2 -  Set up automation. to change password to what ever.  
	//Verify on screen the password was changed?
	//Verify in DB that user_password has changed?  Might not be need
	//Log in with new password -- verify it works.  
	//Step 3: Save password variable  back to DB.  so password is back to old one.
	
	
	
}
