package com.qa.fullcycle.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.fullcycle.Browser.BrowserConfiguration;
import com.qa.fullcycle.pages.CheckoutPage;
import com.qa.fullcycle.pages.HomePage;
import com.qa.fullcycle.pages.LoginPage;
import com.qa.fullcycle.pages.TshirtPage;
import com.qa.fullcycle.utility.TestUtil;

public class CheckoutpageTestcases extends BrowserConfiguration{
	
	LoginPage loginPage;
	HomePage homePage;
	TshirtPage tshirtPage;
	CheckoutPage checkoutPage;

	public CheckoutpageTestcases() {
		super();
	}

	@BeforeTest
	public void openbrowser() {
		browserTearUp();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(properties.getProperty("emailid"), properties.getProperty("password"));
		tshirtPage=homePage.selectTheProduct();
		checkoutPage=tshirtPage.selectTShirt("L","Blue");

	}
	
	@Test(priority=1,enabled=true)
	public void paymentCheckout() {
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		checkoutPage.checkingOut();
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
