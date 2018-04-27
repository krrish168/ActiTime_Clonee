package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest 
{
	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		//Fetching the data from excel sheet by initializing the RowNUm and CellNum
		String loginTitle=ExcelData.getData(file_path, "login", 1, 2);
		String eErrorMessage=ExcelData.getData(file_path, "Login", 1, 4);
		int loginRc=ExcelData.getRowCount(file_path, "Login");
		LoginPage lp=new LoginPage(driver);
		
		//verify Login Page
		lp.verifyTheTitle(loginTitle);
		Reporter.log("----------------------------",true);
		for(int i=2;i<=loginRc;i++)
		{
			String user=ExcelData.getData(file_path, "Login", i, 0);
			String pass=ExcelData.getData(file_path, "Login", i, 1);
			//enter invaid Un
			Reporter.log("USername: "+user,true);
			lp.enterUserName(user);
			
			//enter invalid password
			Reporter.log("password is: "+pass,true);
			lp.enterPassword(pass);
			
			//click on login
			lp.clickonLogin();
			Thread.sleep(2000);
			
			//verify the error message
			String aErrorMessage=lp.verifyErrorMessage();
			Assert.assertEquals(aErrorMessage,eErrorMessage);
			Reporter.log("Messaging is matching: "+eErrorMessage,true);
			Reporter.log("---------------------",true);		
		}
	}

}
