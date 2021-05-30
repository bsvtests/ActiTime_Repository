package com_actitime_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_actitime_Generic.BasePage;

public class actiTIMELoginPage extends BasePage{
	
	
	//declaration
	@FindBy(id = "username")
	private WebElement usernameTB;
	
	@FindBy(name = "pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath ="//div[.='Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[.='Username or Password is invalid. Please try again.']")
	private WebElement errorMessage;
	
	@FindBy(xpath ="//nobr[.='actiTIME 2020 Online']")
	private WebElement version;
	
	//initialization
	public actiTIMELoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//utilization
		public void enterusername(String un)
		{
			usernameTB.sendKeys(un);
		}
		
		public void enterpassword(String pwd)
		{
			passwordTB.sendKeys(pwd);
		}
		
		public void clickonLoginButton()
		{
			loginButton.click();
		}
		
		public String verifyErrorMessage()
		{
			verifyElement(errorMessage);
			String aerror = errorMessage.getText();
			return aerror;
		}
		
		public String verifyVersion()
		{
			verifyElement(version);
			String aVersion = version.getText();
			return aVersion;
		}

}
