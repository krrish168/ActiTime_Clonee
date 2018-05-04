package com.actitime.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstant 
{
	public WebDriver driver;
	//@Parameters({"nodeUrl","browser","appUrl"})
	@BeforeMethod
	//public void preCondition(String nodeUrl,String browser,String appUrl) throws MalformedURLException
	public void preCondition(String url)
	{
		
		/*URL url=new URL(nodeUrl);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(url,dc);
		driver.get(appUrl);*/
		
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_value, gecko_key);
		//(assigning driver) Open the Browser / Launch the Browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//enter the URL
		//driver.navigate().to("http://localhost/login.do");	
		//or
		String appUrl=GenericUtils.getProperty(config_path, url);
		//driver.get("https://demo.actitime.com/login.do");
		driver.get(appUrl);
	
	}
		
		@AfterMethod
		public void postCondition(ITestResult res)
		{
			int status = res.getStatus();
			String name = res.getMethod().getMethodName();
			if(status==2) //status==2 means test case fail and status==1 means test case pass
			{
				GenericUtils.getScreenshot(driver,name);
			}
		driver.close();
		}
	}
