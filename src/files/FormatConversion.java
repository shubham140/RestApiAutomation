/**
 * 
 */
package files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/**
 * @author Shubham
 *
 */
public class FormatConversion {
	
	
	public static JsonPath convertToJsonFormat(Response res) {
		
		String response =res.asString();
		System.out.println(response);
		JsonPath json=new JsonPath(response);
		return json;
		}
	
	public static XmlPath convertToXmlFormat(Response res) {
		String response=res.asString();
		XmlPath xml =new XmlPath(response);
		return xml;
	}

}
