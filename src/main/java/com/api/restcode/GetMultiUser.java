/**
 * 
 */
package com.api.restcode;
import static io.restassured.RestAssured.given;
import com.api.base.BaseClass;
import com.api.base.GetResource;
import com.api.formatconversion.FormatConversion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author Shubham
 *
 */
public class GetMultiUser {
	
	
	public void getResponse() throws Exception {
		
		BaseClass uri=new BaseClass();
		uri.InvokePropertiesFile();
		RestAssured.baseURI=uri.getUrl();
		
		Response res=given().when().get(GetResource.getMultiUserResource()).
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).extract().response();
		FormatConversion.convertToJson(res);
		
	}

}
