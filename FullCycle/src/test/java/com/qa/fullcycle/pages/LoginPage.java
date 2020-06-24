package com.qa.fullcycle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.fullcycle.Browser.BrowserConfiguration;

public class LoginPage extends BrowserConfiguration{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInButton;
	
	@FindBy(id = "email")
	WebElement uiemailid;
	
	@FindBy(id = "passwd")
	WebElement uipassword;
	
	@FindBy(xpath = "//p[@class='submit']//span[1]")
	WebElement loginButton;
	
	public HomePage login(String username, String password) {
		signInButton.click();
		uiemailid.sendKeys(username);
		uipassword.sendKeys(password);
		loginButton.click();
		return new HomePage();
	}
	
	public String verifyTitle() {
		return driver.getTitle();
		
	}

}
