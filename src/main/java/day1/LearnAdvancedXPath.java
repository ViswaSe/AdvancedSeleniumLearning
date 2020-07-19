package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import leaftaps.base.LaunchApp;

public class LearnAdvancedXPath extends LaunchApp{
	
	@Test
	public void learnAdvancedXPath()
	{
		//Relative Text based Xpath
		String baseXpath="//h5[text()='Edit']";
		System.out.println(driver.findElement(By.xpath(baseXpath)).getText());
		
		//following XPath example:
		WebElement eleButton=driver.findElement(By.xpath(baseXpath+"/following::h5[1]"));
		System.out.println(eleButton.getText());
		
		//following-sibling Xpath example:
		WebElement ele=driver.findElement(By.xpath(baseXpath+"/following-sibling::img[1]"));
		System.out.println(ele.getAttribute("class"));

		//Relative TextBased Xpath
		String childXpath="//h5[text()='HyperLink']";
		
		//preceding xpath
		WebElement elePrecedingElement=driver.findElement(By.xpath(childXpath+"/preceding::h5[1]"));
		System.out.println(elePrecedingElement.getText());
		
		//preceding-sibling xpath
		
		String text=driver.findElement(By.xpath("//img[@alt='Link']/preceding-sibling::h5[1]")).getText();
		System.out.println(text);
		
		//Collections xpath
		System.out.println(driver.findElement(By.xpath("(//h5)[4]")).getText());

	}
	
	
}
