package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leaftaps.base.LaunchApp;

public class LearnBootstrapHandling extends LaunchApp {
	
	@BeforeClass
	public void provideData()
	{
		url="https://getbootstrap.com/docs/4.0/components/dropdowns/";
	}
	
	@Test
	public void learnBootStrap() throws InterruptedException
	{
		
		WebElement dropDown=driver.findElement(By.id("dropdownMenuButton"));
		
		dropDown.click();
	
		WebElement eleDropDownAction=driver.findElement(By.linkText("Another action"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(eleDropDownAction);
		Thread.sleep(3000);
		
		eleDropDownAction.click();
	}
}
