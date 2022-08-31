package iOSsharedClasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import iOSCarrierClasses.LocalConfiguration;



public class ConnectionHandler {
	
	
	EnvironmentPicker setEnviroment = new 	EnvironmentPicker();
	
	//LocalConfiguration TestData;
	LocalConfiguration ServerLogins = new LocalConfiguration("ServerLogins.properties");
		Logs iOSLogs = new Logs();
		protected Connection mysql;
		protected Connection infx;
		LocalConfiguration TestData = new LocalConfiguration("TestData.txt");
		LocalConfiguration TestData2 = new LocalConfiguration("Pixel2.properties");
		
		AppStringsiOS iOSText = new AppStringsiOS();
			
	 
	public ConnectionHandler(String environment) throws Exception, SQLException,IOException {
			
//my start		
		System.out.println("Inside of connection handler iOS MY environment is: " + environment);
		AppStringsiOS iOSText = new AppStringsiOS();
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		DriverManager.registerDriver(new com.informix.jdbc.IfxDriver());
		System.out.println("Inside of connection handler iOS MY environment is: " + environment);
		int envPicked;
		
		switch (environment) {

		case "TEST":  envPicked = 1;
		this.mysql = DriverManager.getConnection("jdbc:mysql://slcmysqlacpt1/teslsm",ServerLogins.getConfigurationValue("acptMysqlUN"),ServerLogins.getConfigurationValue("acptMysqlPW"));
		this.infx = DriverManager.getConnection("jdbc:informix-sqli://slcinfxacpt1.efs.local:7210/tch:INFORMIXSERVER=efs89_online1",ServerLogins.getConfigurationValue("acptInfxUN"), ServerLogins.getConfigurationValue("acptInfxPW"));
		iOSLogs.CapturedLogs(iOSText.INFO, "Connected to ACPT TEST environment");
		break;

		case "PARTNER": envPicked = 2;
		this.mysql = DriverManager.getConnection("jdbc:mysql://teslsm.partner.efsllc.com/teslsm",ServerLogins.getConfigurationValue("partnerMysqlUN"),ServerLogins.getConfigurationValue("partnerMysqlPW"));
		this.infx = DriverManager.getConnection("jdbc:informix-sqli://infxdb01x.efspartner.uw2.wexglobal.com:9080/tch:INFORMIXSERVER=efs55_online3",ServerLogins.getConfigurationValue("partnerInfxUN"),ServerLogins.getConfigurationValue("partnerInfxPW"));
		iOSLogs.CapturedLogs(iOSText.INFO, "Connected to Partner environment");
		break;
		
		case "AWSSIT": envPicked = 3;
		this.mysql = DriverManager.getConnection("jdbc:mysql://teslsm.sit.efsllc.com/teslsm",ServerLogins.getConfigurationValue("awsSitMsqlUN"),ServerLogins.getConfigurationValue("awsSitMsqlPW")); 
		this.infx = DriverManager.getConnection("jdbc:informix-sqli://infxdb01q.efssit.uw2.wexglobal.com:9080/tch:INFORMIXSERVER=efs55_online3;",ServerLogins.getConfigurationValue("awsSitInfxUN"),ServerLogins.getConfigurationValue("awsSitInfxPW"));
		iOSLogs.CapturedLogs(iOSText.INFO, "Connected to AWSSIT environment");
		break;
		
		case "AWSDIT": envPicked = 4;
		this.mysql = DriverManager.getConnection("jdbc:mysql://teslsm.dit.efsllc.com/teslsm",ServerLogins.getConfigurationValue("awsDitMysqlUN"),ServerLogins.getConfigurationValue("awsDitMysqlPW")); 
		this.infx = DriverManager.getConnection("jdbc:informix-sqli://infxdb01d.efsdev.uw2.wexglobal.com:9080/tch:INFORMIXSERVER=efs55_online3;",ServerLogins.getConfigurationValue("awsDitInfxUN"),ServerLogins.getConfigurationValue("awsDitInfxPW")); 
		iOSLogs.CapturedLogs(iOSText.INFO, "Connected to AWSDIT environment");
		break;
				
		case "DIT": envPicked = 4;
		this.mysql = DriverManager.getConnection("jdbc:mysql://msp-wex-1009/teslsm",ServerLogins.getConfigurationValue("DitMysqlUN"),ServerLogins.getConfigurationValue("DitMysqlPW")); 
		this.infx = DriverManager.getConnection("jdbc:informix-sqli://msp-wex-1010:7210/tch:INFORMIXSERVER=efs30_online1",ServerLogins.getConfigurationValue("DitInfxUN"),ServerLogins.getConfigurationValue("itInfxPW")); 
		iOSLogs.CapturedLogs(iOSText.INFO, "Connected to DIT environment");
		break;	
		
		default:
		iOSLogs.CapturedLogs(iOSText.INFO, "No servers could be found");
		
		}
	}
	
	public ResultSet query(String db,String query) throws IllegalArgumentException, SQLException {
		
		Statement state;
		
		if (db == "mysql") {
			state = this.mysql.createStatement(); 
		} else if (db == "infx") {
			state = this.infx.createStatement();
		} else {
			throw new IllegalArgumentException("Expected either mysql or infx as the parameter value");
		}
		
		return state.executeQuery(query);
		
		
	}
	
	public boolean execute(String db, String statement) throws IllegalArgumentException, SQLException {
		Statement state;
		
		if (db == "mysql") {
			state = this.mysql.createStatement(); 
		} else if (db == "infx") {
			state = this.infx.createStatement();
		} else {
			throw new IllegalArgumentException("Expected either mysql or infx as the parameter value");
		}
		
		
		
		return state.execute(statement);
	}
	
	
	
		
}
