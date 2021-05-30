package com_actitime_Generic;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {

	public static void getscreenshot(WebDriver driver, String name) {

		//TakesScreenshot scrnshot = (TakesScreenshot) driver;

		try {
			//File src = scrnshot.getScreenshotAs(OutputType.FILE);
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshot" +driver.getTitle()+".png"));
		}
		catch(IOException e) {
		}}

	public static void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectByValue(WebElement element, String Value) {
		Select sel = new Select(element);
		sel.selectByValue(Value);
	}
	public static void selectByVisibleText(WebElement element, String Text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}

	public static void deselectall(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectAll();

	}}