package com_actitime_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com_actitime_Generic.BaseTest;
import com_actitime_Generic.ExcelData;
import com_actitime_Page.actiTIMELoginPage;

public class InvalidloginTest extends BaseTest{
	@Test(priority = 2)
	public void invalidLogin() throws Exception
	{
		String title = ExcelData.getData(filepath, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		//verify Login page should be displayed
		lp.verifyTitle(title);
		int rc = ExcelData.getRowCount(filepath, "TC02");
		for(int i =1; i<=rc; i++)
		{
			String un = ExcelData.getData(filepath, "TC02", i, 0);
			String pw = ExcelData.getData(filepath, "TC02", i, 1);
			//Enter invalid username
			Reporter.log("Invalid user name = "+un,true);
			lp.enterusername(un);
			//Enter invalid password
			Reporter.log("Invalid Password = "+pw,true);
			lp.enterpassword(pw);
			//click on Login
			lp.clickonLoginButton();
			
			String aErrorMessage = lp.verifyErrorMessage();
			String eErrorMessage = ExcelData.getData(filepath, "TC02", 1, 2);
			Assert.assertEquals(aErrorMessage, eErrorMessage);
			
			Thread.sleep(1000);
		}
		Reporter.log("======  Program 2 is completed  ======", true);
	}
	

	}