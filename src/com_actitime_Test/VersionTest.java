package com_actitime_Test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com_actitime_Generic.BaseTest;
import com_actitime_Generic.ExcelData;
import com_actitime_Page.actiTIMELoginPage;

public class VersionTest extends BaseTest{
	
	@Test(priority = 3)
	public void verifyVersion() {
		
		//We are getting the title name from excel which we know it is expected title in webpage
		String title = ExcelData.getData(filepath, "TC01", 1, 2);
		
		//we are creating object for actiTIMELoginPage to use the methods inside the class
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		
		//we are passing title value which we fetched from the excel from line 13 and getting title
		//we already have one verifyTitle() in BasePage we are utilizing now
		lp.verifyTitle(title);
		
		String aversion = lp.verifyVersion();
		String eversion = ExcelData.getData(filepath, "TC01", 1, 5);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aversion, eversion);
		Reporter.log("The actual version is = "+aversion, true);
		Reporter.log("======  Program 3 is completed  ======", true);
		sa.assertAll();
		
	}

}
