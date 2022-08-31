package iOSCarrierClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Iterator;

import iOSsharedClasses.PhonePicker;

public class LogsGalaxyS5 {

	public LogsGalaxyS5() {
	}

	public LogsGalaxyS5 CapturedLogs(String passFail, String keptLogText) throws Exception {

		for (int i = 0; i < 1; i++) {

			HashMap<String, String> logText = new HashMap<String, String>();
			logText.put(passFail, keptLogText);

			for (Iterator<HashMap.Entry<String, String>> itr = logText.entrySet().iterator(); itr.hasNext();) {

				HashMap.Entry<String, String> entry = itr.next();
				System.out.println(" " + entry.getKey() + ", " + entry.getValue());

			}

			DateTimeFormatter dtfFile = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalDateTime dateNow = LocalDateTime.now();
			System.out.println(dtf.format(dateNow));

			//PC			
//			try (FileWriter fw = new FileWriter("C:\\MobileAutomation\\AutomationLogs\\LogsGalaxyFive " + dtfFile.format(dateNow) + ".txt", true)){
//
//				BufferedWriter out = new BufferedWriter(fw);
//				
//			//out.write(dtf.format(dateNow) + " Dated Mobile Automation Log begins. ");
//			out.newLine();
//			//out.append(passFail + " " + keptLogText + " ");
//			out.write(dtf.format(dateNow)+ " " + passFail + " " + keptLogText + "  ");
//			
//			out.close();
//			
//			}

//MAC			
			try (FileWriter fw = new FileWriter("/Users/W446813/AutomationLogs/logs/AutoLog " + dtfFile.format(dateNow) + PhonePicker.AppName() + " " + PhonePicker.PhoneID().toString() + ".txt", true)){

				BufferedWriter out = new BufferedWriter(fw);
				
			
			out.newLine();
			out.write(dtf.format(dateNow)+ " " + passFail + " " + keptLogText + "  ");
			out.close();
			}

		}
		
		return this;
	}

}
