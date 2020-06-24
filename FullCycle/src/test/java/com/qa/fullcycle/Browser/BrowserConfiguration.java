/*author :- Ashutosh*/

package com.qa.fullcycle.Browser;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import com.qa.fullcycle.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfiguration {

	public static WebDriver driver;
	public static Properties properties;

	public BrowserConfiguration() {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/qa/fullcycle/configuration/config.properties");
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("File Not Found");
		}
	}

	public void browserTearUp() {

		/*
		 * ChromeOptions options=new ChromeOptions(); options.addArguments("headless");
		 * options.addArguments("window-size=1200x600"); driver=new
		 * ChromeDriver(options);
		 */

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}

	@AfterSuite
	public void browserTearDown() {
		driver.quit();
	}
}
