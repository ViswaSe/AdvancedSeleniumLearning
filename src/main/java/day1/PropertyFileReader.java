package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFileReader {

	BufferedReader reader;
	Properties prop;
	
	@Test
	public void readProperty()
	{
		try {
			reader = new BufferedReader(new FileReader("./config/Input.properties"));
			prop=new Properties();
			prop.load(reader);	
			
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			System.out.println(prop.getProperty("url"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
