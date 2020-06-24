package com.qa.fullcycle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.fullcycle.Browser.BrowserConfiguration;
import com.qa.fullcycle.utility.TestUtil;

public class HomePage extends BrowserConfiguration {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement womenMenu;

	@FindBy(xpath = "//li[@class='sfHover']//ul//li//a[contains(text(),'T-shirts')]")
	WebElement womenMenuTshirtSubMenu;
	
	public TshirtPage selectTheProduct() {
		TestUtil.MouseOverToElement(womenMenu);
		womenMenuTshirtSubMenu.click();
		return new TshirtPage();
	}
	
	
}
