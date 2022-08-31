package iOSCarrierClasses;
import java.io.IOException;
import java.io.*;
import java.util.Properties;

public class LocalConfiguration {
	
	public LocalConfiguration () {}
	public LocalConfiguration (String filename) {
		local_file_name=filename;
		
	}
		
	public String getConfigurationValue(String configurationname) throws IOException{
		Properties prop = new Properties();
		InputStream stream = getClass().getClassLoader().getResourceAsStream(this.local_file_name);
		
		if (stream != null) {
			prop.load(stream);
		}
		else {
			throw new FileNotFoundException("localConfigurationFile "+local_file_name+ " could not be opened. Are you sure it is setup?");
		}
		
		return prop.getProperty(configurationname);
			
	}
	
	public String local_file_name="local_config.properties";
}




