package com.qa.fullcycle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.fullcycle.Browser.BrowserConfiguration;
import com.qa.fullcycle.utility.TestUtil;

public class CheckoutPage extends BrowserConfiguration{

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addTocart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement finalProccedButton;
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutOnAddressBar;
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsAndConditionsonShippingPage;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutOnShippingBar;	
	
	@FindBy(xpath="//a[@class='cheque']//span[contains(text(),'(order processing will be longer)')]")
	WebElement paymentByCheque;	
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confrimTheOrder;
	
	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")
	WebElement confrimMessage;
	
	
	public void checkingOut() {
		addTocart.click();
		proceedToCheckout.click();
		TestUtil.scrollToElement(finalProccedButton);
		finalProccedButton.click();
		proceedToCheckoutOnAddressBar.click();
		termsAndConditionsonShippingPage.click();
		proceedToCheckoutOnShippingBar.click();
		paymentByCheque.click();
		confrimTheOrder.click();
		verifyTheOrderPlaced();
	}
	
	
	public void verifyTheOrderPlaced() {
		String actualConfrimText=confrimMessage.getText();
    	String expectedConfrimText="Your order on My Store is complete.";
    	Assert.assertEquals(actualConfrimText, expectedConfrimText);    	
	}
}
