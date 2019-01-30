/**
 * 
 */
package files;

/**
 * @author Shubham
 *
 */
public class Parameters {
	
	
	public static String getBody() {
		String body="{\"name\":\"gpuser1\",\"salary\":\"45000\",\"age\":\"25\"}";
		return body;
	}
	
	public static String getLibraryBody(String isbn,String aisel) {
		String body="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisel+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
		return body;
	}
	
	public static String deleteLibraryBook(String id) {
		String body="{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+id+"\"\r\n" + 
				" \r\n" + 
				"}\r\n" + 
				"";
		return body;
	}

}
