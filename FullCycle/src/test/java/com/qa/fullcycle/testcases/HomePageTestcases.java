package com.qa.fullcycle.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.fullcycle.Browser.BrowserConfiguration;
import com.qa.fullcycle.pages.HomePage;
import com.qa.fullcycle.pages.LoginPage;
import com.qa.fullcycle.pages.TshirtPage;
import com.qa.fullcycle.utility.TestUtil;

public class HomePageTestcases extends BrowserConfiguration {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTestcases() {
		super();
	}

	@BeforeTest
	public void openbrowser() {
		browserTearUp();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("emailid"), properties.getProperty("password"));
	}
	
	@Test(priority=1,enabled=true)
	public TshirtPage selcectTshirt() {
		homePage.selectTheProduct();
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new TshirtPage();
	}
}
