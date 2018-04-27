package com.actitime.excelsheets;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest
{
	@Parameters({"city","area"})
	@Test
	public void testA(String city,String area)
	{
		Reporter.log(city,true);
		Reporter.log(area,true);
	}
	

}
