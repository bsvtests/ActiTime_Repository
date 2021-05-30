package com_actitime_Generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstant {
	
//	static 
//	{
//		System.setProperty(chrome_key, chrome_value);
//		System.setProperty(firefox_key, firefox_value);
//	}
//Note: We are tweaking the code inorder to run the code using Node system.
//Remove the comments if you don't want to run through Node
//Remove from step 30 to 33 and uncomment 17 to 21
	
	public  WebDriver driver;
	@Parameters({"nodeurl", "browser", "appurl"})
	@BeforeMethod
	public void precondition(String nodeurl, String browser, String appurl) throws MalformedURLException {
		
		URL url = new URL(nodeurl);
		DesiredCapabilities dc = new DesiredCapabilities();
		driver = new RemoteWebDriver(url, dc);
		dc.setBrowserName(browser);
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(appurl);
	}
	@AfterMethod
	public void postcondition(ITestResult result) {
	int status = result.getStatus();
		if(status == 2) {
			String name = result.getName();
			GenericUtils.getscreenshot(driver, name);
		}
		
		driver.close();
	}
}
