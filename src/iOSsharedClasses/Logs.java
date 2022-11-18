package iOSsharedClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import iOSCarrierClasses.LocalConfiguration;

public class Logs{
	//String type; 
		//String buildNum;
	//need to decide if thtey should be public or private 
		//public TestSetup testSetup;
		
		Boolean regression = false;
		String type = "Regression_CardControl_";
		String buildNum = "5.0.3(20220401.1)_"; //mabe getters and setters
		String fileEnd = "iOS_SmokeTest";//Add this from tests when you name them on starting it....
		
		DateTimeFormatter dtfFile = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime dateNow = LocalDateTime.now();

		Date currentdate = new Date();
		SimpleDateFormat fileDate = new SimpleDateFormat("MMMMM_dd_yyyy");
		String fileDateSTR = fileDate.format(currentdate);
		QTRecord CaptureiOS = new QTRecord();
//		protected static ExtentReports extent;

		//TODO: set regression to true or false 	
		//Boolean regressionRun = false;
		//String buildNum = "Build5.0.7(505)_";
		
		// helps to generate the logs in test report.
//		protected static ExtentTest test;
		
	
	
	
	
	public Logs() {
	
		
		this.startReport();
	}

	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String resultFile;
	public static String resultFileTwo;
	public static String indexFile;
	public static String instancereportsFolder;
	public static String dateFolder;
	public static String reportsFolder;
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String NEW_LINE = System.getProperty("line.separator");
	
	public final String PASS = "Test Pass";
	public final String INFO = "Test Info";
	public final String FAIL = "Test Fail";

	public Logs CapturedLogs(String passFailInfo, String keptLogText) throws Exception {
//TODO Decide to keep non xtm version or not if not delete these sections		
//		DateTimeFormatter dtfFile = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH");
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//		LocalDateTime dateNow = LocalDateTime.now();
//TODO Decide to keep non xtm version or not if not delete these sections		

		HashMap<String, String> logText = new HashMap<String, String>();
		logText.put(passFailInfo, keptLogText);

//TODO Want to see all logs in console? Uncomment this section old old way to do it
//		 for (Iterator<HashMap.Entry<String, String>> itr =
//		 logText.entrySet().iterator(); itr.hasNext();) {
//		 HashMap.Entry<String, String> entry = itr.next();
//		 System.out.println(" " + entry.getKey() + ", " + entry.getValue());
//TODO Want to see all logs in console? Uncomment this section old old way to do it
		
		if (passFailInfo.equalsIgnoreCase(PASS)) {
			// testResult = resultPass;
			testPassed(passFailInfo, keptLogText);
		}

		if (passFailInfo.equalsIgnoreCase(INFO)) {
			// testResult = resultInfo;
			testInfo(passFailInfo, keptLogText);
		}

		if (passFailInfo.equalsIgnoreCase(FAIL)) {
			// testResult = resultFail;
			testFail(passFailInfo, keptLogText);
		}
//TODO Want to see all logs in console? Uncomment this section old old way to do it		
//		 }
//TODO Want to see all logs in console? Uncomment this section old old way to do it
		
//TODO Decide to keep non xtm version or not if not delete these sections		
//		try (FileWriter indexFile = new FileWriter(getDirPath() + dtfFile.format(dateNow) + "_" + PhonePicker.AppName()
//				+ "_" + PhonePicker.PhoneID().toString() + "_" + "iOS_index.html", true)) {
//			BufferedWriter out = new BufferedWriter(indexFile);
//			out.write(dtf.format(dateNow) + " " + passFailInfo + " " + keptLogText + "  " + "<br/>");
//			out.close();
//		}
//TODO Decide to keep non xtm version or not if not delete these sections		

		this.tearDown();
		return this;
	}
	
	
	
	
public void startReport() {
		
		
//		if (java.util.Objects.isNull(this.testSetup)) {
//			this.testSetup = new TestSetup("System_test_", "5.0.0");
//		}
//		
//		
//		this.type = this.testSetup.getTestType();
//		this.buildNum = this.testSetup.getBuildNum();
		
		//System.out.println("Basic Extent TestType name is: " +this.type);
		//System.out.println("Basic Extent BuildNum is: " + this.buildNum);
		
		
		File directory = new File(getDirPath());
		if (!directory.exists()) {
			System.out.println("Test directory creation initated");
			directory.mkdir();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		} else {
			 //System.out.println("Directory already exists");
		}

		if (extent == null) {
			System.out.println("initialize the HtmlReporter");
			// initialize the HtmlReporter

			// builds a new report using the html template
			ExtentHtmlReporter htmlReporter;

		//System.out.println("TestType name is: " + type+ " " );
		//System.out.println("BuildNum is: " + buildNum+ " " );
		
		if (regression == true) {
				//htmlReporter = new ExtentHtmlReporter(getDirPath()+ "Test_Name_"+ buildNum + new SimpleDateFormat("MMMMM_dd_yyyy_HH-mm").format(currentdate) + "_" + "iOS_SmokeTest.html");
				htmlReporter = new ExtentHtmlReporter(getDirPath()+ this.type + this.buildNum + new SimpleDateFormat("MMMMM_dd_yyyy_HH-mm").format(currentdate) + "_" + ".html");
							
				
		} else {
			 htmlReporter = new ExtentHtmlReporter(getDirPath()+ "System_test_" + new SimpleDateFormat("MMMMM_dd_yyyy_HH-mm").format(currentdate) + "_" +fileEnd+ ".html");
		
		}					
	
		 

			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			htmlReporter.config().setChartVisibilityOnOpen(true);
			//htmlReporter.config().setDocumentTitle("EFS Automation Report");
			htmlReporter.config().setReportName(fileEnd);
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			//htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			//htmlReporter.config().setTimeStampFormat(timeStampFormat);
			// htmlReporter.setAppendExisting(true);
		}
		
	}
//change to create test
	public void setupTest(String desc) {
		test = extent.createTest(desc);
	}
	
	public void setupTestYellow(String desc ) {
		test = extent.createTest("<font color = yellow>" + desc + "</font>");
	}
	
	public void setupTestRed(String desc ) {
		test = extent.createTest("<font color = red>" + desc + "</font>");
	}
	
	public void testPassed(String passFail, String desc) {
		test.pass(MarkupHelper.createLabel("PASSED: " + desc, ExtentColor.GREEN));
	}
		
	

	public void testInfo(String passFail, String desc) {
		test.info(MarkupHelper.createLabel("INFO: " + desc, ExtentColor.BLUE));
		// TODO: test = extent.createTest(desc).info(MarkupHelper.createCodeBlock("Add
		// details if needed"));
	}

	public void testFail(String passFail, String desc) {
		
		String imageDesc = "TEST_"+ desc.substring(0, 20);
		 
		if (regression == true) {
			 imageDesc = desc.substring(0, 20);
		}

		imageDesc = imageDesc.trim();
		imageDesc = imageDesc.replaceAll("\\.", "");
		imageDesc = imageDesc.replaceAll("\\s+", "_");
		CaptureiOS.ScreenShot(imageDesc);
		Logs location = new Logs();
		String imageFileName = location.getDirPath() + "iOS_" + imageDesc + ".jpeg";
		Logs iOSLogs = new Logs();

		try {
			ExtentTest et = test.fail(MarkupHelper.createLabel("FAILED: " + desc, ExtentColor.RED));

			File tempFile = new File(imageFileName);

			if (tempFile.exists()) {
				et.addScreenCaptureFromPath(imageFileName);
			}

		} catch (IOException e) {

			try {
				test.fail(MarkupHelper.createLabel("FAILED: " + desc, ExtentColor.RED))
						.addScreenCaptureFromPath(location.getDirPath() + "iOS_" + desc + ".jpeg");
			} catch (IOException e1) {

			}

		}
		iOSLogs.setupTest("Test continued after prior test failure");
	}

//	public String getDirPath() {
//
//
//		LocalConfiguration logPath = new LocalConfiguration();
//		String logpath = null;
//		try {
//			logpath = logPath.getConfigurationValue("extentreport");
//			if (regression == true) {
//		logpath = logPath.getConfigurationValue("extentreportRegression");
//			}
//		} catch (Exception e) {
//			logpath = "/Users/W502702/AutomationLogs/logs/AutoLog_HTML_files/";
//		}
//		return logpath + "/iOS/" + fileDateSTR + "/";
//	}


	public String getDirPath() {


		LocalConfiguration logPath = new LocalConfiguration();
		String logpath = null;
		try {
			//logpath =	System.getProperty("user.home");
			//logpath = logPath.getConfigurationValue("extentreport");
			logpath = "./src/testLogs/systemTesting/";
			if (regression) {
				//logpath =	System.getProperty("user.home");
				//logpath = logPath.getConfigurationValue("extentreportRegression");
				logpath = "./src/testLogs/regressionTesting/";

			}
		} catch (Exception e) {
			//logpath = "/Users/W502702/AutomationLogs/logs/AutoLog_HTML_files/";
			logpath = "./src/testLogs/extra/";
		}
		return logpath  + fileDateSTR + "/";
	}



	@AfterTest
	public void tearDowndriver() throws Exception {

		// add statements or other logging you want at the end of the test.
	}

	@AfterSuite
	public void tearDown() {
		// to write or update test information to reporter
		extent.flush();
	}
	
	
	
}
