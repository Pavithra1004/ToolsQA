package com.Sdet32l1.GenricScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains only property file specific common methods
 * @author anand
 *
 */
public class FileMethods {
	static Properties property;
	/** 
	 * This method is used to open the property file
	 * @throws IOException 
	 */
	public static void openPropertyFile(String filePath) throws IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		property=new Properties();
		property.load(fis);
	}
	
	/**
	 * This method is used to fetch the data from the property file
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public static String getDataFromPropertyFile(String key) throws IOException
	{
	
		String value=property.getProperty(key);
		return value;
	}

}
