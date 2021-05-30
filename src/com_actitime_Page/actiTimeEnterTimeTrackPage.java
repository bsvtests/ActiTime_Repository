package com_actitime_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_actitime_Generic.BasePage;

public class actiTimeEnterTimeTrackPage extends BasePage{
	
	//Declaration
		@FindBy(id = "logoutLink")
		private WebElement logout;
		
		@FindBy(xpath = "//div[@class='popup_menu_button popup_menu_button_support']//div[@class='menu_icon']")
		private WebElement help;
		
		@FindBy(xpath = "//a[contains(.,'About your actiTIME')]")
		private WebElement aboutyourActitime;
		
		@FindBy(xpath ="//span[contains(text(),'(build 1405_20)')]")
		private WebElement buildnumber;
		
		@FindBy(id = "aboutPopupCloseButtonId")
		private WebElement buildnumbercloseicon;
		
		//Intilization
		public actiTimeEnterTimeTrackPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		//Uitilization
		public void clickOnLogout()
		{
			logout.click();
		}
		
		public void clickonHelp()
		{
			help.click();
		}
		
		public void clickonAboutYourActitime()
		{
			aboutyourActitime.click();
		}
		
		public String buildNumber()
		{
			verifyElement(buildnumber);
			String abuildnumber = buildnumber.getText();
			return abuildnumber;
		}
		
		public void buildNumberCloseIcon()
		{
			buildnumbercloseicon.click();
		}
		
	}