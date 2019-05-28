package com.inetBank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configruations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationURL() {
		return prop.getProperty("baseUrl");
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getChromePath() {

		return prop.getProperty("chromeDriverPath");
	}
	
	public String geFireFoxPath() {
		return prop.getProperty("fireFoxDriver");
	}
}
