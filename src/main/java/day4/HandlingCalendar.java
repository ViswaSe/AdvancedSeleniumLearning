package day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingCalendar {
	
	@Test
	public void setDateInCalendar() throws ParseException, InterruptedException
	{
		String url = "https://jqueryui.com/datepicker/";
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Set the expected date to be selected
		String expectedDate = "25/01/2020";
		String[] dateVal 	= expectedDate.split("/");
		int monthToSelect 	= Integer.parseInt(dateVal[1]); 
	
		
		WebElement inFrame = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(inFrame);
		
		WebElement eleDatePicker = driver.findElementById("datepicker");
		eleDatePicker.click();
		
		//Get the month name from the date picker
		String monthName=driver.findElementByClassName("ui-datepicker-month").getText();
		System.out.println(monthName);
		
		//Set the date format as text for the month
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputFormat.parse(monthName));
		
		//Set the date format as number for the month
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM");
		System.out.println(outputFormat.format(cal.getTime()));
		int presentMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
	
		//Apply the logic to move forward or backward direction to pick the expected date
		
		//Moving forward direction
		if(monthToSelect>presentMonth)
		{
			for(int i=0;i<monthToSelect-presentMonth;i++)
			{
				driver.findElementByXPath("//a[contains(@class,'ui-datepicker-next')]").click();
				Thread.sleep(500);
			}
		}
		
		//Moving backward direction
		else if(monthToSelect<presentMonth)
		{
			for(int i=0;i<presentMonth-monthToSelect;i++)
			{
				driver.findElementByXPath("//a[contains(@class,'ui-datepicker-prev')]").click();
				Thread.sleep(500);
			}
		}
		
		driver.findElementByLinkText(dateVal[0]).click();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
