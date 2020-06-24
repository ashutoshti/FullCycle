package com.qa.fullcycle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.fullcycle.Browser.BrowserConfiguration;
import com.qa.fullcycle.utility.TestUtil;

public class TshirtPage extends BrowserConfiguration {
	
	public TshirtPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-container']//following::a[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement womenTshirt;
	
	@FindBy(xpath="//span[contains(text(),'More')]")
	WebElement moreButton;

	@FindBy(xpath="//i[@class='icon-plus']")
	WebElement addQuantity;
	
	public CheckoutPage selectTShirt(String Size, String colour) {
		TestUtil.scrollDown();
		TestUtil.MouseOverToElement(womenTshirt);
		moreButton.click();
		addQuantity.click();
		selectsize(Size);
		selectcolour(colour);
	return new CheckoutPage();
	}
	
	
	public void selectsize(String SelectSize) {
    	Select selectSize=new Select(driver.findElement(By.name("group_1")));
    	selectSize.selectByVisibleText(SelectSize);
	}
	
	public void selectcolour(String colourName) {
		driver.findElement(By.name(colourName)).click();
	}

}
