package leaftaps.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class LaunchApp {
	
	public static ChromeDriver driver;	
	
	BufferedReader reader;
	public Properties prop;
	public static String url;
	
	@BeforeTest
	public void readPropertyFile()
	{
		try {
			reader = new BufferedReader(new FileReader("./config/Input.properties"));
			prop = new Properties();
			prop.load(reader);	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void launchLeafOrgApplication()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowsers()
	{
		driver.quit();
	}

}
