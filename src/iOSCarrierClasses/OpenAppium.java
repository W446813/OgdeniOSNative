package iOSCarrierClasses;

import java.io.File;




import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;




public class OpenAppium {
	
	
	private AppiumDriverLocalService service;

	
	public OpenAppium() {
	}
	
	public void startServer() {
	
		 service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		            .usingDriverExecutable(new File("/usr/local/bin/node"))
		            .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
		            .usingPort(4723).withIPAddress("127.0.0.1"));
		    service.start();
		   

	}
	
}
