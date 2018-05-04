package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils
{
	public static String getProperty(String path,String key)
	{
		String value="";
		Properties p=new Properties();
		try
		{
			p.load(new FileInputStream(path));
			value=p.getProperty(key);//recurssion of method
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	public static void getScreenshot(WebDriver driver,String name)
	{
		try
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("./screenshots/"+name+".png"));
		}
		catch(IOException e)
		{
			
		}
	}
	
	//generic methods
	//Handling list box by using Select class
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	public static void selectByVisibleTexy(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	//Handling drag & drop by using Actions class
	public static void dropAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	//Handling de-selecting list box elements
	public static void deselectByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	public static void deselectByValue(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.deselectByValue(text);
	}
	public static void deselectByVisibleText(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.deselectByVisibleText(text);
	}
	//deselectAll() in multi select list box
	public static void deselectAll(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.deselectAll();
	}
	//get first selected options
	public static void getFirstSelectedOption(WebElement element)
	{
		Select sel=new Select(element);
		sel.getFirstSelectedOption();
	}
	public static void getAllSelectedOptions(WebElement element)
	{
		Select sel=new Select(element);
		sel.getAllSelectedOptions();
	}
	public List<WebElement> getOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allopt=sel.getOptions();
		return allopt;
	}
	//handling Drop Down Menu
	public static void dropDown(WebDriver driver,WebElement trg)
	{
		Actions act=new Actions(driver);
		act.moveToElement(trg).perform();
	}
	//right click options-context click
	public static void contextClick(WebDriver driver,WebElement target)
	{
		Actions act=new Actions(driver);
		act.contextClick(target).perform();
	}
	//double click on the element
	public static void doubleClick(WebDriver driver,WebElement target)
	{
		Actions act=new Actions(driver);
		act.doubleClick(target).perform();
	}
}
