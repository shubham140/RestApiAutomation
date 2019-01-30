package com.api.base;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 */

/**
 * @author Shubham
 * 
 * In this we are invoking the Properties file and getting all the data from that file
 *
 */
public class BaseClass {
	
	private String url="";
	public void InvokePropertiesFile() throws Exception {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Shubham\\Desktop\\API Automation Documents\\RestAssuredWorkspace\\MyFramework\\src\\main\\resources\\URL.properties");
		prop.load(fis);
		url=prop.getProperty("BASEURI");
		
	
	}
	
	public String getUrl() {
		
		return url;
		
	}

}
