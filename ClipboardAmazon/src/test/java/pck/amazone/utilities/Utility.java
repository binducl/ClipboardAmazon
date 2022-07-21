package pck.amazone.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
	
	Properties prop;

	public Utility() {
		File configFile = new File("./Configs/Config.properties");
		try {
			FileInputStream strm = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(strm);
		} catch (Exception ex) {
			System.out.println("Error: -" + ex.getMessage());
		}
	}

	public String getURL() {
		return prop.getProperty("baseUrl");
	}

	public String getChromePath() {
		return prop.getProperty("chromePath");
	}

}
