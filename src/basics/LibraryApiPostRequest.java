/**
 * 
 */
package basics;

import java.io.FileInputStream;

import java.util.Properties;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.FormatConversion;
import files.Parameters;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author Shubham
 *
 */
public class LibraryApiPostRequest {
	Properties prop=new Properties();
	@BeforeTest
	public void getUrl() throws Exception {
		FileInputStream fis=new FileInputStream("C:\\Users\\Shubham\\Desktop\\API Automation Documents\\RestAssuredWorkspace\\RestAssured\\src\\files\\Parameters.properties");
		prop.load(fis);
		
	}
	
	@Test(dataProvider="getData")
	public void postCall(String isbn,String aisele) {
		RestAssured.baseURI=prop.getProperty("LibraryHost");
		Response res=given().body(Parameters.getLibraryBody(isbn,aisele)).log().all().when().post(Resources.getLibraryResource()).then().log().all().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		JsonPath jPath=FormatConversion.convertToJsonFormat(res);
		System.out.printf(jPath.get("ID"));
		String id=jPath.getString("ID");
		Response res1=given().body(Parameters.deleteLibraryBook(id)).when().post("/Library/DeleteBook.php").then().log().all().assertThat().statusCode(200).extract().response();
		@SuppressWarnings("unused")
		JsonPath jp=FormatConversion.convertToJsonFormat(res1);
		}
	
	@DataProvider(name="getData")
	public Object[][] getData() {
		return new Object[][] {{"qwqaasa","12341"},{"hsaldad","7301381"},{"ihddab","029283"}};
	}

}
