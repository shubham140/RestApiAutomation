/**
 * 
 */
package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Shubham
 *
 */
public class BasicsRestAssured {
	
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in";
		given().
			   //param("location","//api//users").
			   param("paramter","page=2").
			   when().
			   get("/api/users").
			   then().
			   assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	
		   body("data[0].first_name",equalTo("Charles"));
		
			   
	}

}
