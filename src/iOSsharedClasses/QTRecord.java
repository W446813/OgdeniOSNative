package iOSsharedClasses;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class QTRecord {
	
	
	public void ScreenShot(String desc) {
		try {
			Logs location = new Logs();
			// takes a screenshot and saves it in a file
			File screenshot = ((TakesScreenshot) Capabilities.driver).getScreenshotAs(OutputType.FILE);
			// copy the file to the required path
			FileUtils.copyFile(screenshot, new File(location.getDirPath()  + "iOS_" + desc + ".jpeg"));
		
		
		} catch (Exception e) {
			// if it fails to take screenshot then this block will execute
			System.out.println("Failure to take screenshot " + e);
		}
	}
	
	
	public static void startQTrecord(){ 
		
        //Activate QT
        try{
            String[] go = { "osascript", "-e", "tell application \"QuickTime Player\" to activate" };
            Process process = Runtime.getRuntime().exec(go);
            process.waitFor();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
        
        
        try{
        
        	
        	 String[] go = { "osascript", "-e", "tell application \"QuickTime Player\" use " + PhonePicker.PhoneID().toString()};
            //String[] go = { "osascript", "-e", "tell application \"QuickTime Player\" use " + PhonePicker.PhoneID()};
            Process process = Runtime.getRuntime().exec(go);
            process.waitFor();    
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
        
        
        //Start new recording
        try{
            String[] go = { "osascript", "-e", "tell application \"QuickTime Player\" to start new movie recording" };
            Process process = Runtime.getRuntime().exec(go);
            process.waitFor(); 
           
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }

}
	
	
	//public static void closeQT() throws IOException{
		
//		for (int i = 0; i < 1; i++) {
//
//			HashMap<String, String> logText = new HashMap<String, String>();
//			
//			for (Iterator<HashMap.Entry<String, String>> itr = logText.entrySet().iterator(); itr.hasNext();) {
//
//				HashMap.Entry<String, String> entry = itr.next();
//				System.out.println(" " + entry.getKey() + ", " + entry.getValue());
//
//			}
//
//			DateTimeFormatter dtfFile = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//			LocalDateTime dateNow = LocalDateTime.now();
//			System.out.println(dtf.format(dateNow));
//
//			try (FileWriter fw = new FileWriter("C:\\MobileAutomation\\AutomationLogs\\AutoLog " + dtfFile.format(dateNow) + PhonePicker.AppName() + " " + PhonePicker.PhoneID().toString() + ".txt", true)){
//
//				BufferedWriter out = new BufferedWriter(fw);
//				
//			
//			
//			
//			out.close();
//			
//			}
//			try (FileWriter fw = new FileWriter("/Users/W446813/AutomationLogs/logs/AutoLog " + dtfFile.format(dateNow) + PhonePicker.AppName() + " " + PhonePicker.PhoneID().toString() + ".txt", true)){
//
//				BufferedWriter out = new BufferedWriter(fw);
//				
//			
//			
//			out.close();
//			}
//			
//		}
		
        //Pause the recording, save and quit
		//Stop the recording
//	    try {
//	        String[] go = {"osascript", "-e", "tell application \"QuickTime Player\" to stop recording movie "};
//	       
//	        Process process = Runtime.getRuntime().exec(go);
//	        process.waitFor();
//	    } catch (IOException ex) {
//	        System.out.println(ex.toString());
//	    } catch (InterruptedException ex) {
//	        System.out.println(ex.toString());
//	    }
//	
//	    
//        try {        	     
//          String[] go = {"osascript", "-e", "save in tFile to \"Users/W446813/AutomationLogs/logs/QTSaves/one.mov"+ "as posix file", "-e", "do shell script \"touch \" & quoted form of posix path of tFile", "-e", "tell application \"QuickTime Player\"", "-e", "pause document 1", "-e", "save document 1 in tFile", "-e", "stop document 1", "-e", "close document 1 saving no", "-e", "quit", "-e", "end tell"};
//            Process process = Runtime.getRuntime().exec(go);
//            process.waitFor();
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//        } catch (InterruptedException ex) {
//            System.out.println(ex.toString());
//        }
//    }
	
	public static void saveQT(){
	
	//Stop the recording
    try {
        String[] go = {"osascript", "-e", "tell application \"QuickTime Player\" to stop document \"movie recording\""};
        Process process = Runtime.getRuntime().exec(go);
        process.waitFor();
    } catch (IOException ex) {
        System.out.println(ex.toString());
    } catch (InterruptedException ex) {
        System.out.println(ex.toString());
    }
    //Save
    try {
//       
        String[] go = {"osascript", "-e", "tell application \"System Events\" to keystroke \"s\" using {command down}", "-e", "delay 1"};         
        Process process = Runtime.getRuntime().exec(go);
    process.waitFor();
    } catch (IOException ex) {
        System.out.println(ex.toString());
    } catch (InterruptedException ex) {
        System.out.println(ex.toString());
    }
    //Enter the save directory
    try {
////       
        String[] go = {"osascript", "-e", "tell application \"System Events\" to keystroke \"G\" using {command down, shift down}", "-e", "delay 1"};
        Process process = Runtime.getRuntime().exec(go);
        process.waitFor();
    } catch (IOException ex) {
        System.out.println(ex.toString());
    } catch (InterruptedException ex) {
            System.out.println(ex.toString());
    }
    try {
////       
        String gofolder = "tell application \"System Events\" to keystroke\"\"+Users/W446813/AutomationLogs/logs/QTSaves/"+"\""+ "\"";
        String[] go = {"osascript", "-e", gofolder, "-e", "delay 1", "-e", "tell application \"System Events\" to keystroke return", "-e", "delay 1"};
        Process process = Runtime.getRuntime().exec(go);
        process.waitFor();
    } catch (IOException ex) {
        System.out.println(ex.toString());
    } catch (InterruptedException ex) {
            System.out.println(ex.toString());
    }
    try {
        
        String[] go = {"osascript", "-e", "tell application \"System Events\" to keystroke\"\"+one.mov+"+"\"", "-e", "tell application \"System Events\" to keystroke return", "-e", "delay 1"};         
        Process process = Runtime.getRuntime().exec(go);
        process.waitFor();
    } catch (IOException ex) {
        System.out.println(ex.toString());
    } catch (InterruptedException ex) {
        System.out.println(ex.toString());
    }
//    /////////////////////////////////////////////
   // Wait for save then quit
    boolean keepWaiting = true;
    while(keepWaiting){
        try{
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"osascript", "-e", "delay 5", "-e", "tell application \"QuickTime Player\" to quit"};
            Process proc = rt.exec(commands);
            proc.waitFor();
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
           
            // read any errors from the attempted command
            if(stdError.readLine() == null){keepWaiting = false;}
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }
//	
}
	
}
