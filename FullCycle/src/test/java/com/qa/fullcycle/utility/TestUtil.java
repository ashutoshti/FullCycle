package com.qa.fullcycle.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.fullcycle.Browser.BrowserConfiguration;

public class TestUtil extends BrowserConfiguration {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 20;

	public static void screenshot() throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss'.png'").format(new Date());
		String currentDir = System.getProperty("user.dir");
		File Destination = new File(currentDir + "/screenshots/" + filename);
		org.apache.commons.io.FileUtils.copyFile(source, Destination);
		System.out.println("ScreenShot taken");
	}
	
	public static void scrollToElement(String textTobeFound) {
		WebElement element = driver.findElement(By.linkText(textTobeFound));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
	}
	
	public static void MouseOverToElement(WebElement elemetToBeMouseOver) {
		Actions actions = new Actions(driver);
    	actions.moveToElement(elemetToBeMouseOver).perform();

	}
	
	public static void scrollToElement(WebElement textTobeFound) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textTobeFound);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
