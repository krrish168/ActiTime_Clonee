package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class LoginPage extends BasePage
{
	//Declaration
	//@FindBy(xpath="//input[@name='username']")
	@FindBy(id="username")
	private WebElement UserNameTB;
	
	@FindBy(name="pwd")
	private WebElement PasswordTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;
	
	//INitialization by Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void enterUserName(String un)
	{
		UserNameTB.sendKeys(un);
	}
	public void enterPassword(String pw)
	{
		PasswordTB.sendKeys(pw);
	}
	public void clickonLogin()
	{
		loginBTN.click();
	}
	public void verifyTheTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	public String verifyErrorMessage()
	{
		verifyElement(errMsg);
		String actualErrMsg=errMsg.getText();
		return actualErrMsg;
	}
	public String verifyVersion()
	{
		String aVersion=version.getText();
		return aVersion;
	}
	
}
