package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	//Declaration
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
	private WebElement helpBTN;
	
	@FindBy(xpath="//li[.='About your actiTIME']")
	private WebElement abtActitimeBTN;
	//for https://demo.actitime.com/login/do
	@FindBy(xpath="//span[contains(text(),'(build 40469)')]")
	
	//for http://localhost/login.do
	
	//@FindBy(xpath="//span[contains(text(),'(build 39769)')]")
	private WebElement buildNumber;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closePopUp;
	
	//Initialization
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public void clickOnHelpBTN()
	{
		helpBTN.click();
	}
	public void clickOnAboutActitimeBTN()
	{
		abtActitimeBTN.click();
	}
	public String verifyBuildNumber() throws InterruptedException
	{
		verifyElement(buildNumber);
		String aBuild=buildNumber.getText();
		Thread.sleep(2000);
		return aBuild;
	}
	public void closePopUp()
	{
		closePopUp.click();
	}
	public void clickonlogout()
	{
		logoutBTN.click();
	}
}
