package com.qa.fullcycle.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.fullcycle.Browser.BrowserConfiguration;
import com.qa.fullcycle.pages.LoginPage;
import com.qa.fullcycle.utility.TestUtil;

public class LoginPageTestcase extends BrowserConfiguration {

	LoginPage loginpage;
	
	public LoginPageTestcase() {
		super();
	}
	
	@BeforeTest
	public void openbrowser() {
		browserTearUp();
		loginpage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyTitle() {
		String title=loginpage.verifyTitle();
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority = 2)
	public void applicationStarts() {
		loginpage.login(properties.getProperty("emailid"), properties.getProperty("password"));
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

