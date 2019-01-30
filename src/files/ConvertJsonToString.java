/**
 * 
 */
package files;


import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Shubham
 *
 */
public class ConvertJsonToString {
	
	
	public static  String GenerateStringFromResource(String path) throws Exception {
	
	return new String(Files.readAllBytes(Paths.get(path)));
		
		
	}

}
