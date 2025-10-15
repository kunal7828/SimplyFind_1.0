package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getKeyValue(String key) {

		Properties properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(".\\src\\main\\resources\\config.properties");
			properties.load(input);

		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Unknown exception" + e);
		}
		return properties.getProperty(key);

	}
	
	
	public static void main(String[] args) {
		System.out.println(getKeyValue("DEVELOPMENT_LOGIN_URL"));
	}

}
