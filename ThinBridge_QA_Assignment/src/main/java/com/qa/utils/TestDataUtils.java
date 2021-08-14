package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataUtils {

	Properties prop;
	
	public TestDataUtils(String fileName) {
		try {
			
			prop =  new Properties();
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\testData\\"+fileName+".properties")));
		}catch (FileNotFoundException e) {
			new Throwable("Unable to find Properties file!! " + e.getMessage());
		}catch(IOException io) {
			new Throwable("Unable to read data from Properties file!! " + io.getMessage());
		}
	}
	
	public String getProperty(String property) {
		return prop.getProperty(property);
	}
}
