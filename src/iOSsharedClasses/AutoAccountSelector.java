package iOSsharedClasses;

import java.sql.ResultSet;


public class AutoAccountSelector {
	
private String env;
private String accountNum;
private String passwordOrPin;
private String memberID;
private String unitID;
private String accountType;
Logs iOSLogs = new Logs();
int lastFour;
private String cardID;		
	
	public void CardPassExpected(String account) throws Exception {
		AutoAccountSelector getAccount = new AutoAccountSelector();
		this.accountNum = account;
		this.accountType = account;
		
		AppStringsiOS iOSText = new AppStringsiOS(env);
//		String pass = iOSText.PASS;
//		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		
		iOSLogs.CapturedLogs(info, "Auto account selector started");
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
				
		iOSLogs.CapturedLogs(info, "environment is: " + env+" account type is: " +accountType);
		System.out.println("I am in Card Pass expected environment is: " + env+ " account type is: " +accountType);

		
		switch (accountNum) {
		case "COMPANY":  lastFour = 1;
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");

		//ResultSet companyCardInfx = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' order by c.lastupdated desc"));
		ResultSet companyCardInfx = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.dynamic_pin_flag = 'N' order by c.lastupdated desc"));
		//ResultSet companyCardInfx = dbACPTCheck.query("infx",String.format("select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' order by c.lastupdated desc limit 1"));
		companyCardInfx.next();
		
		String newCompanyCard = companyCardInfx.getString("card_num");
		String newCompanyCardPin = companyCardInfx.getString("pin");
				
		this.accountNum = newCompanyCard;
		this.passwordOrPin = newCompanyCardPin;
		
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
	
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;

		
		case "SMARTFUNDS": lastFour = 2;
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet smartFundsCard = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'P' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and cp.pin <> 'NULL' and c.card_type <> 'MCFL' order by c.lastupdated desc"));
		
		smartFundsCard.next();
		String newSmartFundsCard = smartFundsCard.getString("card_num");
		String newSmartFundsCardPin = smartFundsCard.getString("pin");
		this.accountNum = newSmartFundsCard;
		this.passwordOrPin = newSmartFundsCardPin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
	
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		case "UNIVERSAL": lastFour = 3;
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet universalCard = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A'order by c.lastupdated desc"));
		//		ResultSet universalCard = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' limit 1"));

		universalCard.next();
		
		String newuniversalCard = universalCard.getString("card_num");
		String newuniversalCardPin = universalCard.getString("pin");
		
		this.accountNum = newuniversalCard;
		this.passwordOrPin = newuniversalCardPin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
			
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
				
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		case "SETUP_PROFILE": lastFour = 4;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet setupProfileCardDB = dbACPTCheck.query("infx",String.format("select card_num from ach_profile_card_xref order by profile_id desc limit 1"));
		setupProfileCardDB.next();
		
		String newSetupProfileCardDB = setupProfileCardDB.getString("card_num");
		newSetupProfileCardDB.trim();
		ResultSet setupProfileCardDBData = dbACPTCheck.query("infx",String.format("Select * from card_pins where card_num = '"+newSetupProfileCardDB+"'"));
		setupProfileCardDBData.next();
		
		String setupProfileCardUsing = setupProfileCardDBData.getString("card_num");
		String setupProfileCardUsingPin = setupProfileCardDBData.getString("pin");
		
		this.accountNum = setupProfileCardUsing;
		this.passwordOrPin = setupProfileCardUsingPin;
		
		System.out.println("This is the Setup Profile card found: " +accountNum + " Pin found: " +passwordOrPin);
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		
		case "PASSCODE": lastFour = 5;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet setupPasscodeCardDB = dbACPTCheck.query("infx",String.format("select first 3 cp.card_num, cp.pin, cp.* from cards c, card_pins cp where c.card_num = cp.card_num and cp.status = 'A'and cp.valid in ('A','Y') and c.status = 'A'and cp.passcode_enabled_flag = 'Y'and c.dynamic_pin_flag = 'Y' order by cp.passcode_set_date desc"));
//		ResultSet setupPasscodeCardDB = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, cp.* from cards c, card_pins cp where c.card_num = cp.card_num and cp.status = 'A'and cp.valid in ('A','Y') and c.status = 'A'and cp.passcode_enabled_flag = 'Y'and c.dynamic_pin_flag = 'Y' limit 1"));

		setupPasscodeCardDB.next();	
//		setupPasscodeCardDB.next();	
//		setupPasscodeCardDB.next();	
		String newPasscodeCard = setupPasscodeCardDB.getString("card_num");
		String newPASSCODECardStatus = setupPasscodeCardDB.getString("status");
		this.accountNum = newPasscodeCard;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("This is the Universal card found: " +accountNum);
		System.out.println("Account number after trim should be the new password: "+accountNum+" Should have no spaces at the end");
		
		System.out.println(accountType+" Card found on MYSQL side =: " + newPasscodeCard +" LOGIN WITH CARD IF ERROR SEEN CARD NUMBER NO LONGER HAS PASSCODE");
		iOSLogs.CapturedLogs(info, accountType+" Card found on MYSQL side =: " + cardID +" LOGIN WITH CARD IF ERROR SEEN CARD NUMBER NO LONGER HAS PASSCODE");
		System.out.println(accountType+" Card status on MYSQL side =: " + newPASSCODECardStatus);
		
		
		String newPasscodeCardPasscode = accountNum.substring(accountNum.length()-6);
		this.passwordOrPin = newPasscodeCardPasscode;
		System.out.println("Account number after trim should be the new password: "+newPasscodeCardPasscode+" Should have no spaces at the end");

		System.out.println(newPasscodeCard);
		System.out.println(newPasscodeCardPasscode);
	
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
	
		
		case "SECURE_FUEL_NEEDS_UNIT_NUMBER": lastFour = 6;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		
		//ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("Select member_id, card_pins.* from cards, card_pins, member where member.secure_fuel_rules in (1, 2) and member.member_id = cards.carrier_id and cards.status = 'A'and cards.card_num = card_pins.card_num and card_pins.status = 'A'and card_pins.valid ='A'"));
		
		//Original 
				//ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("SELECT first 1 card_pins.* from cards, card_pins, member where member.secure_fuel_rules in (1, 2) and member.member_id = cards.carrier_id and cards.status = 'A'and cards.card_num = card_pins.card_num and card_pins.status = 'A'and card_pins.valid ='A'"));
				
				//This one works now that I have a card setup for it.. Check for constancy.
				ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("SELECT first 1 member_id, card_pins.* FROM cards, card_pins, member, card_inf WHERE member.secure_fuel_rules IN (1,2) AND member.member_id = cards.carrier_id AND cards.status = 'A' AND cards.card_num = card_pins.card_num AND card_pins.status = 'A' AND card_pins.valid = 'A' AND cards.card_num = card_inf.card_num AND card_inf.info_id <> 'UNIT'"));	
				
		
		
		setupSecureFuelCardDB.next();
		String newSecureFuelCard = setupSecureFuelCardDB.getString("card_num");
		String newSecureFuelCardPin = setupSecureFuelCardDB.getString("pin");
		String newSecureFuelCardMemberID = setupSecureFuelCardDB.getString("member_id");
		this.accountNum = newSecureFuelCard;
		this.passwordOrPin = newSecureFuelCardPin;
		this.memberID = newSecureFuelCardMemberID;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("This is the Secure Fuel card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		memberID = memberID.trim();
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
				
		
		ResultSet secureFuelUnitID = dbACPTCheck.query("infx",String.format("Select * from def_info where carrier_id = '"+memberID+"'" + "and info_id = 'UNIT'"));
		secureFuelUnitID.next();
		
		String newUnitID = secureFuelUnitID.getString("info_validation");
		this.unitID = newUnitID;
		unitID = newUnitID.trim();
		System.out.println("the unit number found is: " + unitID);	
		
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
				
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		
		
		case "Register_Check_Company": lastFour = 7;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet registerCheckCardDB = dbACPTCheck.query("infx",String.format("select first 3 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.contract_id = '-1' and c.payr_chk = 'Y' and  c.payr_ach = 'Y' order by c.lastupdated desc"));

		
		registerCheckCardDB.next();
		registerCheckCardDB.next();
		String newregisterCheckCard = registerCheckCardDB.getString("card_num");
		String newregisterCheckCardPin = registerCheckCardDB.getString("pin");
		this.accountNum = newregisterCheckCard;
		this.passwordOrPin = newregisterCheckCardPin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("Register Check Company card found: " +accountNum + " Pin found: " +passwordOrPin);
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
		
		iOSLogs.CapturedLogs(info, accountType+" Card found on MYSQL side =: " + cardID +" LOGIN WITH CARD IF ERROR SEEN CARD NUMBER NO LONGER HAS PASSCODE");
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		
		case "Register_Check_Smartfunds": lastFour = 8;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet registerCheckCardSmartFundsDB = dbACPTCheck.query("infx",String.format("select first 3 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'P' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.contract_id = '-1' and c.payr_chk = 'Y' and  c.payr_ach = 'Y' order by c.lastupdated desc"));

		
		registerCheckCardSmartFundsDB.next();
		registerCheckCardSmartFundsDB.next();
		registerCheckCardSmartFundsDB.next();
		String newregisterCheckSmartFundsCard = registerCheckCardSmartFundsDB.getString("card_num");
		String newregisterCheckSmartFundsPin = registerCheckCardSmartFundsDB.getString("pin");
		this.accountNum = newregisterCheckSmartFundsCard;
		this.passwordOrPin = newregisterCheckSmartFundsPin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("Register Check SmartFunds card found: " +accountNum + " Pin found: " +passwordOrPin);
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
		
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		
		
		
		case "SECURE_FUEL_DOES NOT_NEED_UNIT_NUMBER": lastFour = 9;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
	
//		ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("Select member_id, card_pins.* from cards, card_pins, member where member.secure_fuel_rules in (1, 2) and member.member_id = cards.carrier_id and cards.status = 'A'and cards.card_num = card_pins.card_num and card_pins.status = 'A'and card_pins.valid ='A'"));

		ResultSet SecureFuelCardDoesNotNeedUnitNumberDB = dbACPTCheck.query("infx",String.format("SELECT first 1 member_id, card_pins.*, card_inf.info_validation FROM cards, card_pins, member, card_inf WHERE member.secure_fuel_rules IN (1,2) AND   member.member_id = cards.carrier_id AND   cards.status = 'A' AND   cards.card_num = card_pins.card_num AND   card_pins.status = 'A' AND   card_pins.valid = 'A' AND   cards.card_num = card_inf.card_num  AND  card_inf.info_id = 'UNIT' and cards.infosrc = 'C' and card_inf.info_validation like 'V%%'"));
		
		SecureFuelCardDoesNotNeedUnitNumberDB.next();
		String newSecureFuelNoUnitCard = SecureFuelCardDoesNotNeedUnitNumberDB.getString("card_num");
		String newSecureFuelNoUnitCardPin = SecureFuelCardDoesNotNeedUnitNumberDB.getString("pin");
		String newSecureFuelNoUnitCardMemberID = SecureFuelCardDoesNotNeedUnitNumberDB.getString("member_id");
		this.accountNum = newSecureFuelNoUnitCard;
		this.passwordOrPin = newSecureFuelNoUnitCardPin;
		this.memberID = newSecureFuelNoUnitCardMemberID;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("This is the Secure Fuel card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		memberID = memberID.trim();
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
				
		
		ResultSet secureFuelUnitID1 = dbACPTCheck.query("infx",String.format("Select * from def_info where carrier_id = '"+memberID+"'" + "and info_id = 'UNIT'"));
		secureFuelUnitID1.next();
		
		String newUnitID1 = secureFuelUnitID1.getString("info_validation");
		this.unitID = newUnitID1;
		unitID = newUnitID1.trim();
		System.out.println("the unit number found is: " + unitID);
		
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		
		case "TRANSFER_FUNDS_MANUAL_5542": lastFour = 10;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Setting manually until we figgure out SQL for this");
	
		String newTransferFundsCard = "7083059810269845542";
		String newTransferFundsCardPin = "985477";
		this.accountNum = newTransferFundsCard;
		this.passwordOrPin = newTransferFundsCardPin;
		accountNum = accountNum.trim();
		
		System.out.println("This is the Secure Fuel card found: " +accountNum + " Pin found: " +passwordOrPin);
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		this.cardID = getAccount.getCardID(accountNum, env);
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");																 
		break;
						
		
		case "FLEET_ONE": lastFour = 11;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet fleetOne = dbACPTCheck.query("infx",String.format("Select * from card_pins where card_num like '501486%%' and status = 'A' and valid = 'A' order by set DESC"));
																											
		fleetOne.next();
		String fleetOneCard = fleetOne.getString("card_num");
		String fleetOnePin = fleetOne.getString("pin");
		this.accountNum = fleetOneCard;
		this.passwordOrPin = fleetOnePin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		this.cardID = getAccount.getCardID(accountNum, env);
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
		
		
		
		case "FAKE": lastFour = 12;
		String fakeCard = "1234567891234567891";
		String fakePin = "1234";
		this.accountNum = fakeCard;
		this.passwordOrPin = fakePin;
		System.out.println("This is the Setup Profile card found: " +accountNum + " Pin found: " +passwordOrPin);
		break;
		
		case "CARRIER_102698": lastFour = 13;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier102698 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '102698'"));
		
		carrier102698.next();
		String member102698 = carrier102698.getString("member_id");
		String password102698 = carrier102698.getString("passwd");
		this.accountNum = member102698;
		this.passwordOrPin = password102698;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		
		case "CARRIER_100045": lastFour = 14;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier100045 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '100045'"));
		
		carrier100045.next();
		String member100045 = carrier100045.getString("member_id");
		String password100045 = carrier100045.getString("passwd");
		this.accountNum = member100045;
		this.passwordOrPin = password100045;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		case "CARRIER_100644": lastFour = 15;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier100644 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '100644'"));
		
		carrier100644.next();
		String member100644 = carrier100644.getString("member_id");
		String password100644 = carrier100644.getString("passwd");
		this.accountNum = member100644;
		this.passwordOrPin = password100644;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		
		case "CARRIER_102698db": lastFour = 16;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier102698db = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '102698db'"));
		
		carrier102698db.next();
		String member102698db = carrier102698db.getString("member_id");
		String password102698db = carrier102698db.getString("passwd");
		this.accountNum = member102698db;
		this.passwordOrPin = password102698db;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		
		case "Register_Check_UNIVERSAL": lastFour = 15;
		//TODO Add database login
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		iOSLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet registerCheckCardUniversalDB = dbACPTCheck.query("infx",String.format("select first 3 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.contract_id = '-1' and c.payr_chk = 'Y' and  c.payr_ach = 'Y' order by c.lastupdated desc"));

		
		registerCheckCardUniversalDB.next();
		
		String newregisterCheckUniversalCard = registerCheckCardUniversalDB.getString("card_num");
		String newregisterCheckUniversalPin = registerCheckCardUniversalDB.getString("pin");
		this.accountNum = newregisterCheckUniversalCard;
		this.passwordOrPin = newregisterCheckUniversalPin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		
		System.out.println("Register Check" +accountType+ "card found: " +accountNum + " Pin found: " +passwordOrPin);
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
		System.out.println("This is the" +accountType + " card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
	
		
		case "MasterCard":  lastFour = 1;
		iOSLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet masterCardInfx = dbACPTCheck.query("infx",String.format("Select cp.card_num, cp.pin from card_pins cp, cards c where c.card_num like '5%%' and c.status = 'A' and c.card_num = cp.card_num and cp.status = 'A' and cp.valid = 'A'"));
		
		masterCardInfx.next();
		String newMasterCard = masterCardInfx.getString("card_num");
		String newMasterCardPin = masterCardInfx.getString("pin");
	
		this.accountNum = newMasterCard;
		this.passwordOrPin = newMasterCardPin;
		accountNum = accountNum.trim();
		this.cardID = getAccount.getCardID(accountNum, env);
		System.out.println("This is the Company card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//make sure card is not set to a non useable status
		this.getAndFixCardStatus(accountNum, env, accountType);
		
		iOSLogs.CapturedLogs(info, "Card ID: " +cardID+ " selected for testing");
		break;
						
		default:
			iOSLogs.CapturedLogs(info, "No " +accountType +" number found");
	
	}
		
		
	
	}
	
	public String getMaskedCard() {
		String TempCard = this.accountNum.trim();
		String maskedCard = TempCard.substring(0, 5) + "****" + TempCard.substring(TempCard.length()-4);
		return maskedCard;

		}	
	
	public String getlastFour(String Cardnum) {
		String TempCard = Cardnum;
		String getlastFour = TempCard.substring(TempCard.length()-4);
		return getlastFour;

		}	
	
	public String getlastSix(String Cardnum) {
		String TempCard = Cardnum;
		String getlastSix = TempCard.substring(TempCard.length()-6);
		return getlastSix;

		}	
	
	
	public String getCardID(String accountNumber, String env) throws Exception {
		String TempCard = accountNumber.trim();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		ResultSet cardIdResult = dbACPTCheck.query("infx",String.format("select card_id from cards where card_num = '"+TempCard+"'"));
		cardIdResult.next();
		String cardID = cardIdResult.getString("card_id");
		return cardID;

		}
	
	
	public String getAndFixCardStatus(String accountNumber, String env, String accountType) throws Exception {	
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS(env);
		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;
		
		
		//TODO make sure card is not set to a non useable status	
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		ResultSet cardStatusMysql = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNumber+"'"));
				

		//TODO setup mysql record if missing
				if (!cardStatusMysql.next()) {
					System.out.println(accountType+" row is missing from  mysql side need to login with card first");
					iOSLogs.CapturedLogs(info, accountType+" row is missing from  mysql side need to login with card first");
				}else {	
				String newCardDB = cardStatusMysql.getString("user_id");
				String newCardDBStatus = cardStatusMysql.getString("status_id");
				System.out.println(accountType+" found on MYSQL side =: " + newCardDB);
				System.out.println(accountType+" status on MYSQL side =: " + newCardDBStatus);

			
				
				if (accountNumber.equalsIgnoreCase(newCardDB)){
				iOSLogs.CapturedLogs(info, accountType+" found in both databses");
				System.out.println(accountType+" Status on mysql side =: " + newCardDBStatus);
				iOSLogs.CapturedLogs(info, accountType+" status is: " +newCardDBStatus);
				
				if(newCardDBStatus.equalsIgnoreCase("S")) {
				System.out.println(accountType+" is not Active on mysql side");
				iOSLogs.CapturedLogs(info, accountType+" is not Active updating to Active status");
				dbACPTCheck.execute("mysql", "UPDATE sec_user SET status_id ='A'WHERE user_id ='"+accountNumber+"'");
				dbACPTCheck.execute("mysql", "UPDATE sec_user SET passwd_fail_count ='0'WHERE user_id ='"+accountNumber+"'");
				iOSLogs.CapturedLogs(info, accountType+" status is being set back to Active and fail count = 0");
				
				ResultSet cardMysqlNewStatus = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
				cardMysqlNewStatus.next();		
				String CardDBStatusNow = cardMysqlNewStatus.getString("status_id");
				
				System.out.println(accountType+" Status on mysql side =: " + CardDBStatusNow);
				iOSLogs.CapturedLogs(info, accountType+" status is: " +CardDBStatusNow);
				}else {
				System.out.println("Status of S was not seen on "+accountType+" mysql side");
				iOSLogs.CapturedLogs(info, "Status of S was not seen on "+accountType+" mysql side");
				}
					
				}else {
					System.out.println(accountType+" already active on the mysql side");
					iOSLogs.CapturedLogs(info, accountType+" already active on the mysql side");
				}
				}
				return info;
	}
	
	
	
	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public void setCardNum(String cardNumNow) {
		this.accountNum = cardNumNow;
		System.out.println("SET Card Number: "+ accountNum);
	}
	
	public String getAccountNum() {
		System.out.println("GET Card number: "+ accountNum);
		return accountNum;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getPasswordOrPin() {
		return passwordOrPin;
	}

	public void setPasswordOrPin(String passwordOrPin) {
		this.passwordOrPin = passwordOrPin;
	}
}
