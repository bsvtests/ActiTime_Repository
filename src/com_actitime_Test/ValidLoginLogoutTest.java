package com_actitime_Test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com_actitime_Generic.*;
import com_actitime_Page.actiTIMELoginPage;
import com_actitime_Page.actiTimeEnterTimeTrackPage;

public class ValidLoginLogoutTest extends BaseTest{

	@Test
	public void ValidLoginLogout() throws Exception {

		//first we are fetching the data from excel and storing values in objects
		String un = ExcelData.getData(filepath, "TC01", 1, 0);
		String pwd = ExcelData.getData(filepath, "TC01", 1, 1);
		String lgTitle = ExcelData.getData(filepath, "TC01", 1, 2);
		String hpTitle = ExcelData.getData(filepath, "TC01", 1, 3);

		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTimeEnterTimeTrackPage hp = new actiTimeEnterTimeTrackPage(driver);
		
		//Verify Login page should be displayed
		lp.verifyTitle(lgTitle);
		//Enter valid username
		lp.enterusername(un);
		//Enter valid password
		lp.enterpassword(pwd);
		//click on Login
		lp.clickonLoginButton();
		//verify Enter Time Track page should be displayed
		lp.verifyTitle(hpTitle);
		//click on Logout
		hp.clickOnLogout();
		//Verify Login page should be displayed
		lp.verifyTitle(lgTitle);
		Reporter.log("======  Program 1 is completed  ======", true);

	}	
}
