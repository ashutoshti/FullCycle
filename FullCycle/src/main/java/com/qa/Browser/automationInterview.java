package com.qa.Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationInterview {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

		
		//----Login into Application---//
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
		/*------Verify the title of Page------*/
		String actualPageTitle=driver.getTitle();
		String expectedPageTitle="Login - My Store";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		
		/*------Enter the Credinatls and click on login Button------*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("fowena5793@mail-dj.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Mangla@2807");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		
		/*------Enter the Select T-Shirt From the Women Secetion------*/
		Actions actions = new Actions(driver);
        /*------Retrieve WebElement 'Music' to perform mouse hover------*/
    	WebElement menuOptionWomen = driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));
    	//Mouse hover menuOption 'Women Menu'
    	actions.moveToElement(menuOptionWomen).perform();
    	
    	//Now Select 'T-shirt' from sub menu which has got displayed on mouse hover of 'Women'
    	WebElement selectMenuOptionTshirt = driver.findElement(By.xpath("//li[@class='sfHover']//ul//li//a[contains(text(),'T-shirts')]"));
    	selectMenuOptionTshirt.click();
    	
    	//Scroll to the Dress
    	js.executeScript("window.scrollBy(0,700)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
    	
    	//Mouse Over the Tshirt
    	WebElement tshirtName = driver.findElement(By.xpath("//div[@class='product-container']//following::a[contains(text(),'Faded Short Sleeve T-shirts')]"));
    	//Mouse hover menuOption 'Women Menu'
    	actions.moveToElement(tshirtName).perform();
    	
    	//Click on More Button
    	driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();

    	//Enter the Quantity
    	driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
    	
    	//select the large size
    	Select selectSize=new Select(driver.findElement(By.name("group_1")));
    	selectSize.selectByVisibleText("L");
    	
    	//select the colour of dress
    	driver.findElement(By.name("Blue")).click();
    	
    	//Click on Add to Cart Button
    	driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
    	
    	//Click on Proceed to checkout
    	driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
    	
    	//scroll to botton of the page
    	WebElement finalProccedButton = driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
    	js.executeScript("arguments[0].scrollIntoView(true);",finalProccedButton);
    	
    	//Click to procced Button on Sign Progress Bar
    	finalProccedButton.click();

    	//Click to procced Button on Adress Progress Bar
    	driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
    	
    	//Click to procced Button on Shipping Progress Bar
    	driver.findElement(By.xpath("//input[@id='cgv']")).click();
    	driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
    	
    	//pay the order
    	driver.findElement(By.xpath("//a[@class='cheque']//span[contains(text(),'(order processing will be longer)')]")).click();
    	
    	//confrim the order
    	driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
    	
    	String actualConfrimText=driver.findElement(By.xpath("//p[contains(text(),'Your order on My Store is complete.')]")).getText();
    	String expectedConfrimText="Your order on My Store is complete.";
    	if (actualConfrimText.equals(expectedConfrimText)) {
			System.out.println("Order Confrimed");
		} else {
			System.out.println("Order Not-Confrim");
		}
    	driver.quit();


		
		

		
		
		


	}

}
