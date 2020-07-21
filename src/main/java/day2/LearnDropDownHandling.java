package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftaps.base.LaunchApp;

public class LearnDropDownHandling extends LaunchApp {
	
	@BeforeClass
	public void provideData()
	{
		url=prop.getProperty("testleaf_url");
	}
	
	@Test
	public void handleDropdown()
	{
		
		driver.findElement(By.xpath("//h5[text()='Drop down']")).click();
		
		WebElement eleFirst = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select sel1 = new Select(eleFirst);
		sel1.selectByVisibleText("Selenium");
		sel1.selectByValue("2");
		System.out.println(sel1.getFirstSelectedOption().getText());
		
		WebElement eleLast =driver.findElement(By.xpath("(//div[@class='example'])[6]/select"));
		Select sel2	 = new Select(eleLast);
		List<WebElement> allOptions =sel2.getOptions();
		
		for(WebElement each:allOptions)
		{
			each.click();
		}
		
		List<WebElement> eleOptions = sel2.getAllSelectedOptions();
		for(WebElement eachOption:eleOptions)
		{
			System.out.println(eachOption.getText());
		}
		
	}

}
