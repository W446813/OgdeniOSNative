package iOSsharedClasses;



public class TestSetup {
	private String testType;
	private String buildNum;

	
	public TestSetup(String testTypeSent, String buildNumSent) {
		this.testType = testTypeSent;
		this.buildNum = buildNumSent;
		
		System.out.println("Test Type set in test setup page is: " + this.testType);
		System.out.println("Build number in test setup page is: " + this.buildNum);
		
		
	}


	public String getTestType() {
		return testType;
	}


	public void setTestType(String testType) {
		this.testType = testType;
	}


	public String getBuildNum() {
		return buildNum;
	}


	public void setBuildNum(String buildNum) {
		this.buildNum = buildNum;
	}


	

}
