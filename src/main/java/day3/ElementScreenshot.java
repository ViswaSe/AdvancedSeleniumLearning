package day3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftaps.base.LaunchApp;

public class ElementScreenshot extends LaunchApp {
	
	@BeforeClass
	public void provideData()
	{
		url = prop.getProperty("testleaf_url");
	}
	
	@Test
	public void takePageScreenshot() throws IOException
	{
		
		WebElement ele=driver.findElement(By.xpath("//h5[text()='Button']"));
		
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_YY_hh_mm_ss");
		Date date = new Date();
		String imgname = df.format(date);

		File src  = ele.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshots/"+imgname+".png");
		FileUtils.copyFile(src,desc);
		
	}
}
