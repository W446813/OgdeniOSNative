package iOSsharedClasses;

import org.openqa.selenium.WebElement;
import iOSCardClasses.RepoCardiOS;
import io.appium.java_client.AppiumDriver;

public class EnvironmentPicker {
	static AppiumDriver<WebElement> driver;
	RepoCardiOS elements =new RepoCardiOS();
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	private String environment;

	
	
	public EnvironmentPicker environmentPickerButton() throws Exception {
		iOSLogs.setupTest("Environment and test type picker started");
		iOSLogs.setupTest("ENVIRONMENT PICKER");
		Thread.sleep(2000);
//TODO un-comment wanted environment		
//~~ACPT TEST~~
//		setEnviroment("TEST");
//		WebElement TestButton=elements.ACPTButton();
//		if (TestButton !=null &&  TestButton.isEnabled()){
//			TestButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "Test Server selected as testing option");
//		}else {
//			iOSLogs.CapturedLogs(iOSText.INFO, "Test Button not found could be that you already chose an environment");
//	}
		
//~~PARTNER~~
		setEnviroment("PARTNER");
		WebElement PartnerButton=elements.PartnerButton();
	if (PartnerButton !=null &&  PartnerButton.isEnabled()){
		PartnerButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "PARTNER Server selected as testing option");
		}else {
		iOSLogs.CapturedLogs(iOSText.INFO, "PARTNER Button not found could be that you already chose an environment");
	}

////~~AWS SIT~~
//		setEnviroment("AWSSIT");
//		WebElement SITAWSButton=elements.SITAWSButton();
//		if (SITAWSButton !=null &&  SITAWSButton.isEnabled()){
//			SITAWSButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "SIT AWS Server selected as testing option");
//		}else {
//		iOSLogs.CapturedLogs(iOSText.INFO, "SIT AWS Button not found could be that you already chose an environment");
//	}
		
//~~AWS DIT~~
//		setEnviroment("AWSDIT");
//		WebElement AWSDITButton=elements.DITAWSButton();
//		if (AWSDITButton.isEnabled()){
//			AWSDITButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "AWSDIT Button pressed");
//	}else {
//		iOSLogs.CapturedLogs(iOSText.INFO, "AWSDIT Button not found");
//	}		
		
//~~DIT~~
//		setEnviroment("DIT");
//		WebElement DITButton=elements.DITButton();
//		if (DITButton.isEnabled()){
//			DITButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "DIT Button pressed");
//	}else {
//		iOSLogs.CapturedLogs(iOSText.INFO, "DIT Button not found");
//	}
		
		Thread.sleep(3000);	
		WebElement StartButton = elements.StartButton();
		Thread.sleep(3000);
		if (StartButton != null && StartButton.isDisplayed()) {
			StartButton.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Start Button on env picker selected.");
		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Start Button on env picker Not found");
		}

		return this;
	}
	
	
	public EnvironmentPicker environmentPickerButtonCarrier() throws Exception {
		iOSLogs.setupTest("Environment and test type picker started");
		iOSLogs.setupTest("ENVIRONMENT PICKER");
		Thread.sleep(2000);
//TODO un-comment wanted environment		
//~~ACPT TEST~~
//		setEnviroment("TEST");
//		WebElement TestButton=elements.ACPTButton();
//		if (TestButton !=null &&  TestButton.isEnabled()){
//			TestButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "ACPT Test Server selected as testing option");
//		}else {
//			iOSLogs.CapturedLogs(iOSText.INFO, "ACPT Test Button not found could be that you already chose an environment");
//	}
		
//~~PARTNER~~
		setEnviroment("PARTNER");
		WebElement StartButtonCarrier=elements.StartButtonCarrier();
		if (StartButtonCarrier !=null &&  StartButtonCarrier.isEnabled()){
			StartButtonCarrier.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Carrier PARTNER start button found");
		}else {
		iOSLogs.CapturedLogs(iOSText.INFO, "Carrier PARTNER start button not found");
	}

//~~AWS SIT~~
//		setEnviroment("AWSSIT");
//		WebElement SITAWSButton=elements.SITAWSButton();
//		if (SITAWSButton !=null &&  SITAWSButton.isEnabled()){
//			SITAWSButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "SIT AWS Server selected as testing option");
//		}else {
//		iOSLogs.CapturedLogs(iOSText.INFO, "SIT AWS Button not found could be that you already chose an environment");
//	}
		
//~~AWS DIT~~
//		setEnviroment("AWSDIT");
//		WebElement AWSDITButton=elements.DITAWSButton();
//		if (AWSDITButton.isEnabled()){
//			AWSDITButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "AWSDIT Button pressed");
//	}else {
//		iOSLogs.CapturedLogs(iOSText.INFO, "AWSDIT Button not found");
//	}		
		
//~~DIT~~
//		setEnviroment("DIT");
//		WebElement DITButton=elements.DITButton();
//		if (DITButton.isEnabled()){
//			DITButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "DIT Button pressed");
//	}else {
//		iOSLogs.CapturedLogs(iOSText.INFO, "DIT Button not found");
//	}
		
//		Thread.sleep(3000);	
//		WebElement StartButton = elements.StartButton();
//		Thread.sleep(3000);
//		if (StartButton != null && StartButton.isDisplayed()) {
//			StartButton.click();
//			iOSLogs.CapturedLogs(iOSText.PASS, "Start Button on env picker selected.");
//		} else {
//			iOSLogs.CapturedLogs(iOSText.INFO, "Start Button on env picker Not found");
//		}
//
		return this;
	}
	
	
	public EnvironmentPicker SetEnvironment() throws Exception {
		iOSLogs.setupTest("ENVIRONMENT PICKER");
		Thread.sleep(2000);
//TODO un-comment wanted environment		
//~~ACPT TEST~~
//		setEnviroment("TEST");

		
////~~PARTNER TEST~~
		setEnviroment("PARTNER");


//~~AWS SIT~~
//		setEnviroment("AWSSIT");

		
//~~AWS DIT~~
//		setEnviroment("AWSDIT");

		
//~~DIT~~
//		setEnviroment("DIT");


		return this;
	}
	
	
	

	public void setEnviroment(String env) {
//		System.out.println("SET ENVIROMENT: "+ enviroment);
		this.environment = env;
		System.out.println("SET ENVIROMENT: "+ environment);
	}
	
	
	public String getEnviroment() {
		System.out.println("GET ENVIROMENT: "+ environment);
		return environment;
	}
		
}