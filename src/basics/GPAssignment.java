/**
 * 
 */
package basics;

import java.io.FileInputStream;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.FormatConversion;
import files.Parameters;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author Shubham
 *
 */
public class GPAssignment {
	Properties prop=new Properties();
	@BeforeTest
	public void getUri() throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Shubham\\Desktop\\API Automation Documents\\RestAssuredWorkspace\\RestAssured\\src\\files\\Parameters.properties");
		prop.load(fis);
	}
	@Test
	public void runCode() {
		
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().log().all().body(Parameters.getBody()).when().post("/api/v1/create").then().statusCode(200).extract().response();
		JsonPath js=FormatConversion.convertToJsonFormat(res);
		String id=js.get("id");
		System.out.println(id);
		String name=js.getString("name");
		Assert.assertEquals(name, "gpuser1");
		String salary=js.getString("salary");
		Assert.assertEquals(salary, "45000");
		String age=js.getString("age");
		Assert.assertEquals(age, "25");
		Response res1=given().log().all().when().get("/api/v1/employee/"+id).then().log().all().assertThat().extract().response();
		JsonPath js1=FormatConversion.convertToJsonFormat(res1);
		System.out.println(js1);
		Response res2=given().log().all().body("{\"name\":\"gpuser1\",\"salary\":\"50000\",\"age\":\"25\"}").when().put("/api/v1/update/"+id).then().extract().response();
		JsonPath js2=FormatConversion.convertToJsonFormat(res2);
		System.out.println(js2);
		String newSlary=js2.getString("salary");
		System.out.println(newSlary);
		Assert.assertEquals(newSlary, "50000");
		Response rs3=given().when().delete("/api/v1/update/"+id).then().extract().response();
		JsonPath js3=FormatConversion.convertToJsonFormat(rs3);
		System.out.println(js3);
		
		
		
		
		
		
		
		
		
	}

}
