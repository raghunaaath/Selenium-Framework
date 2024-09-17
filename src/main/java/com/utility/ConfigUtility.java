package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigUtility {
	
	private Properties prop;
	
	public ConfigUtility() {
		
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
			prop.load(file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Properties getPropertyFileDetails() {
		return this.prop;
	}
	
	public String getPropertyValueOf(String key) {
		
		return prop.getProperty(key);
	}

}
