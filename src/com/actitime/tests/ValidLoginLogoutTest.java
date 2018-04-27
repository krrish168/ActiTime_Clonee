package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test
	public void validLoginLogout()
	{
		String loginTitle=ExcelData.getData(file_path, "Login", 1, 2);
		String user=ExcelData.getData(file_path, "Login", 1, 0);
		String pass=ExcelData.getData(file_path, "Login", 1, 1);
		String timeTrackTitle=ExcelData.getData(file_path, "enterTimeTrack", 1, 0);
		//creating objects to Login and Logout POM classes
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		//PageFactory.initElements(driver, lp);
		//PageFactory.initElements(driver, ep);
		//Verify Login Page
		lp.verifyTheTitle(loginTitle);
		//enter valid un
		Reporter.log("username is: "+user,true);
		lp.enterUserName(user);
		//enter password
		Reporter.log("password is: "+pass,true);
		lp.enterPassword(pass);
		//click on login button1
		lp.clickonLogin();
		//verify the title name as enter time track page after login
		lp.verifyTheTitle(timeTrackTitle);
		//click on logout
		ep.clickonlogout();
		//verify the login page title
		lp.verifyTheTitle(loginTitle);
	}

}
