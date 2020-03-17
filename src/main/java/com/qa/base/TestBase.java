package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public static String userDir = System.getProperty("user.dir");
	public int RESPONSE_STATUS_CODE_200 =200;
	public int RESPONSE_STATUS_CODE_500 =500;
	public int RESPONSE_STATUS_CODE_400 =400;
	public int RESPONSE_STATUS_CODE_401 =401;
	public int RESPONSE_STATUS_CODE_201 =201;
	
	
	
	
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream(
					userDir +"/src/main/java/com/qa/config/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
