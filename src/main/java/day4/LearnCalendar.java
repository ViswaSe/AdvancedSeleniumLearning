package day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftaps.base.LaunchApp;

public class LearnCalendar extends LaunchApp{
	
	@BeforeClass
	public void provideData()
	{
		url=prop.getProperty("testleaf_url");
	}

	@Test
	public void selectFromCalendar() throws InterruptedException, ParseException
	{
		driver.findElement(By.xpath("//h5[text()='Calendar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("datepicker")).click();
		
		//Set the expected date
		String expectedDate = "1/12/2020";
		String[] dateVal =expectedDate.split("/");
		int monthToSelect = Integer.parseInt(dateVal[1]);
		
		//Get the month name
		String monthName=driver.findElement(By.className("ui-datepicker-month")).getText();
		System.out.println(monthName);
			
		//Set the format of the calendar to month text
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputFormat.parse(monthName));
		System.out.println(cal.getTime());
		
		//Set the format to month number
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM");
		System.out.println(outputFormat.format(cal.getTime()));
		System.out.println(Integer.parseInt(outputFormat.format(cal.getTime())));
		int presentMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
		
		
		//Move to forward direction
		if(presentMonth<monthToSelect)
		{
			for(int i=0;i<monthToSelect-presentMonth;i++)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(500);
			}
		}
		
		//Moving backward direction
		else if(presentMonth>monthToSelect)
		{
			for(int j=0;j<presentMonth-monthToSelect;j++)
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
				Thread.sleep(500);
			}
		}
		
		driver.findElementByLinkText(dateVal[0]).click();
	}
}
