/**
 * 
 */
package com.api.formatconversion;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/**
 * @author Shubham
 *
 */
public class FormatConversion {
	
	public static JsonPath convertToJson(Response res) {
		String response =res.asString();
		System.out.println(response);
		JsonPath jsp=new JsonPath(response);
		return jsp;
		
	}
	
	public static XmlPath convertToXml(Response res) {
		String response=res.asString();
		System.out.println(response);
		XmlPath xml=new XmlPath(response);
		return xml;
	}

}
