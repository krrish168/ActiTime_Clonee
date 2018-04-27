package com.actitime.generic;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage 
{
	//Declaration
	public WebDriver driver;
	//Initialization by using constructor
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Utilization
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching: "+eTitle,true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching:",true);
			Reporter.log("Actual Title is : "+driver.getTitle()+" Expected Title is: "+eTitle,true);
			Assert.fail(); //making the status failed
		}
	}
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present",true);
		}
		catch (Exception e)
		{
			Reporter.log("Element is not Present: ",true);
			Assert.fail();
		}
		
	}
}
