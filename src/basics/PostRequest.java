/**
 * 
 */
package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.FormatConversion;
import files.Parameters;
import files.Resources;



/**
 * @author Shubham
 *
 */
public class PostRequest {

	/**
	 * @param args
	 * @throws Exception 
	 * 
	 * 
	 */
	java.util.Properties pro=new java.util.Properties();
	@BeforeTest
	public void getHost() throws Exception {
		
		FileInputStream fileIO=new FileInputStream("C:\\Users\\Shubham\\Desktop\\API Automation Documents\\RestAssuredWorkspace\\RestAssured\\src\\files\\Parameters.properties");
		pro.load(fileIO);
	}
	@Test
	public void callMethod() {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI=pro.getProperty("HOST");
		Response res1 = null;
		Response res=given().
		body(Parameters.getBody()).
		when().
		post(Resources.resourceName()).then().assertThat().statusCode(200).extract().response();
		System.out.println(res);
		String id=FormatConversion.convertToJsonFormat(res).get("id");
		System.out.println(id);
		
		
		given().when().get("/api/v1/update/"+"name").then().extract().response();
		System.out.println(res1);
		
		

	}

}
