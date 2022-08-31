package iOSsharedClasses;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollOptionsiOS {
	Logs iOSLogs = new Logs();
	AppStringsiOS iOSText = new AppStringsiOS();
	
	String pass = iOSText.PASS;
	String fail = iOSText.FAIL;
	String info = iOSText.INFO;
	
	public ScrollOptionsiOS() {
	}

	public ScrollOptionsiOS Refresh() throws Exception {

		// explanantion of move to

		try {
			System.out.println("Pass, Pull to resfesh started");
			// this is the long press move to new location on screen needed for pull to
			// refresh
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 410))
					.moveTo(PointOption.point(700, 800)).release().perform();
			Thread.sleep(1000);
			iOSLogs.CapturedLogs(info, "Pull to resfesh completed");

		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			iOSLogs.CapturedLogs(fail, "Pull to refresh failed.");

		}

		return this;
	}

	public ScrollOptionsiOS ScrollDown() throws Exception {

		try {
			System.out.println("Pass, Scroll down started");
			// this is the long press move to new location on screen needed for pull to
			// refresh
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 600))
					.moveTo(PointOption.point(700, 410)).release().perform();
			Thread.sleep(1000);
			iOSLogs.CapturedLogs(info, "Scroll down completed");

		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			iOSLogs.CapturedLogs(fail, "Scroll down failed");
		}

		return this;
	}

	public ScrollOptionsiOS ScrollDownModal() throws Exception {

		try {
			iOSLogs.CapturedLogs(info, "Scroll down started");
			// this is the long press move to new location on screen needed for pull to
			// refresh
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 350))
					.moveTo(PointOption.point(700, 80)).release().perform();
			Thread.sleep(1000);
			iOSLogs.CapturedLogs(info, "Scroll down completed");

		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			iOSLogs.CapturedLogs(info,e.getMessage());
			iOSLogs.CapturedLogs(fail, "Scroll down failed");
		}

		return this;
	}

	public ScrollOptionsiOS ScrollUp() throws Exception {

		try {
			iOSLogs.CapturedLogs(info, "Scroll up started");
			// this is the long press move to new location on screen needed for pull to
			// refresh
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 500))
					.moveTo(PointOption.point(700, 1400)).release().perform();
			Thread.sleep(1000);
			iOSLogs.CapturedLogs(info, "Scroll up completed");

		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			iOSLogs.CapturedLogs(info,e.getMessage());
			iOSLogs.CapturedLogs(fail, "Scroll up failed");
		}

		return this;
	}

	public ScrollOptionsiOS WelcomeScreenScroll() throws Exception {
		try {
			System.out.println("Pass, Scroll welcome screen started");

			int welcomeScreen = 0;
			while (welcomeScreen < 3) {
				new TouchAction<>(Capabilities.driver).longPress(PointOption.point(800, 400))
						.moveTo(PointOption.point(60, 700)).release().perform();
				Thread.sleep(1000);
				welcomeScreen++;
				iOSLogs.CapturedLogs(info,
						"View Welcome tutorial page " + welcomeScreen + " has been scrolled through");
			}

			Thread.sleep(1000);
			iOSLogs.CapturedLogs(iOSText.PASS, "Scroll welcome screen completed");

		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			iOSLogs.CapturedLogs(fail, "Scroll down failed.");
		}

		return this;
	}

}
