package com_actitime_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Reporter;
import com_actitime_Page.*;
import com_actitime_Generic.BaseTest;
import com_actitime_Generic.ExcelData;

public class VerifybuildnumberTest extends BaseTest{

	@Test(priority = 4)
	public void verifyBuildNumber() throws Exception {

		String un = ExcelData.getData(filepath, "TC01", 1, 0);
		String pwd = ExcelData.getData(filepath, "TC01", 1, 1);
		String ebuildnumber = ExcelData.getData(filepath, "TC02", 1, 3);

		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTimeEnterTimeTrackPage hp = new actiTimeEnterTimeTrackPage(driver);

		lp.enterusername(un);
		lp.enterpassword(pwd);
		lp.clickonLoginButton();

		//clicking on help icon in the header
		hp.clickonHelp();
		Thread.sleep(5000);
		//clicking on the about actiTime link
		hp.clickonAboutYourActitime();
		Thread.sleep(5000);
		//here we are calling the buildNumber() from POM class and keeping value in abuildnumber
		String abuildnumber = hp.buildNumber();
		
		SoftAssert BN = new SoftAssert();
		BN.assertEquals(abuildnumber, ebuildnumber);
		Reporter.log("The actual build number is = "+abuildnumber, true);
		BN.assertAll();
		
		hp.buildNumberCloseIcon();
		Thread.sleep(3000);
		
		hp.clickOnLogout();
		Reporter.log("======  Program 4 is completed  ======", true);
//		if(ebuildnumber == abuildnumber) {
//			System.out.println("build number is matching"+abuildnumber);
//		}
//		else {
//			System.out.println("build number is not matching"+abuildnumber);

	}}