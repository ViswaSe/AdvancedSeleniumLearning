package day3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import leaftaps.base.LaunchApp;

public class FullPageScreenshot extends LaunchApp {
	
	@BeforeClass
	public void provideData()
	{
		//url=prop.getProperty("testleaf_url");
		url="https://getbootstrap.com/docs/4.0/components/dropdowns/";
	}
	
	@Test
	public void takeFullPageScreenshot()
	{
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		Date date = new Date();
		String imgname = df.format(date);
		
		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, true).withName(imgname).save();
		
	}

}
