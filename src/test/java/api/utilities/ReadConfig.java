package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	static Properties properties;
	String propertyPath = "C:\\Users\\Kutty Karadi\\eclipse-workspace\\RestAssuredAPITesting\\src\\test\\resources\\Routes.properties";
	//String propertyPath1 = System.getenv(Userd)\\RestAssuredAPITesting\\src\\test\\resources\\Routes.properties";
   
	public ReadConfig() throws FileNotFoundException {
		properties = new Properties();
		FileInputStream file = new FileInputStream(propertyPath);
		try {
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String get_postURL() {
		String post_url = properties.getProperty("post_url");
		return post_url;
	}
	public static String get_getURL() {
		String get_url = properties.getProperty("get_url");
		return get_url;
	}
	public static String get_putURL() {
		String put_url = properties.getProperty("put_url");
		return put_url;
	}
	public static String get_deleteURL() {
		String delete_url = properties.getProperty("delete_url");
		return delete_url;
	}

	
}
