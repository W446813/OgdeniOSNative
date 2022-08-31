package iOSCarrierClasses;

import org.openqa.selenium.WebElement;

import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Logs;

public class FaceIDCheck {
	public FaceIDCheck() {
	}

	public void FaceIdModal() throws Exception {
		
		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		RepoCarrieriOS xpath = new RepoCarrieriOS();
		iOSLogs.setupTest("Face ID modal");
		iOSLogs.CapturedLogs(iOSText.INFO, "Face ID Modal testing Initiated.");

		// Close facial reg software modal with cancel click.

		WebElement CancelButtonFaceID = xpath.CancelButtonFaceID();

		if (CancelButtonFaceID != null && CancelButtonFaceID.isDisplayed()) {
			CancelButtonFaceID.click();
			iOSLogs.CapturedLogs(iOSText.PASS, "Face ID Modal is now closed or canceled");

		} else {
			iOSLogs.CapturedLogs(iOSText.INFO, "Face ID Modal was already closed or canceled on a prior run");
		}

	}

}
