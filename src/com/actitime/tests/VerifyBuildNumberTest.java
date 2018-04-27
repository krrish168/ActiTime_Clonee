package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNumberTest extends BaseTest
{
	@Test
	public void testVerifyBuildNumber() throws InterruptedException
	{
		String loginTitle=ExcelData.getData(file_path, "Login", 1, 2);
		String user=ExcelData.getData(file_path, "Login", 1, 0);
		String pass=ExcelData.getData(file_path, "Login", 1, 1);
		String eTitle=ExcelData.getData(file_path, "enterTimeTrack", 1, 0);
		//for https://demo.actitime.com/login.do/
		String eBuild=ExcelData.getData(file_path, "enterTimeTrack", 1, 1);
		//fro https://http://localhost/login.do
		//String eBuild=ExcelData.getData(file_path, "enterTimeTrack", 2, 1);
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		//verify login page
		lp.verifyTheTitle(loginTitle);
		//enter the valid un
		lp.enterUserName(user);
		Reporter.log("username is: "+user,true);
		//enter the valid pw
		lp.enterPassword(pass);
		Reporter.log("password is: "+pass,true);
		//click on login
		lp.clickonLogin();
		
		//verify the enter time track page
		lp.verifyTheTitle(eTitle);
		//click on help button
		Thread.sleep(2000);
		ep.clickOnHelpBTN();
		//click on about your actitime option
		ep.clickOnAboutActitimeBTN();
		//verify the build number
		String aBuild=ep.verifyBuildNumber();
		Thread.sleep(2000);
		Assert.assertEquals(aBuild,eBuild);
		Reporter.log("actual build number is: "+aBuild,true);
		Thread.sleep(2000);
		//close the hidden division popup
		ep.closePopUp();
		//click on logout
		ep.clickonlogout();
		Thread.sleep(2000);
		//verify the login page title
		lp.verifyTheTitle(loginTitle);
		}
}
