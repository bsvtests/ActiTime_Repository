package com_actitime_Generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
//common methods in POM class we write in base page
public class BasePage
{
	
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//We are using this method to know the title of the webpage
	public void verifyTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleIs(title));
			Reporter.log("Matching title is = "+title,true);
		}
		catch (Exception e) 
		{
			Reporter.log("Title is not matching....",true);
			Reporter.log("Matching title is = "+driver.getTitle(),true);
			Assert.fail();
		}
	}
		
	public void verifyElement(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element present...",true);
		}
		catch (Exception e) 
		{
			Reporter.log("Element is not present...",true);
			Assert.fail();
		}
	}
}
