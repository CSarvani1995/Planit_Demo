package DemoWebShop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Generic_Utility.File_Utility;

public class SampleDemo {

	public static void main(String[] args) throws Throwable {
		String Key="webdriver.driver.chrome";
		String Value="C:\\Selenium\\chromedriver_win32";
		System.setProperty(Key, Value);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis); 
		String URL =pro.getProperty("url");
		String Email =pro.getProperty("username");
		String Password =pro.getProperty("password");
		String Quantity =pro.getProperty("quantity");
		
		
		
	//Login to the Demo web shop with email and password details
		driver.get(URL);
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.name("Password")).sendKeys(Password);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
	//Validate the user account ID 
		String userId = driver.findElement(By.xpath("(//a[@class='account'])[1]")).getText();
		if(userId.contains(Email)) 
		{
			System.out.println("User Id is correct");
		}
		else
		{
			System.out.println("User Id is different");
		}
		
	//Remove items in shopping cart
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		driver.switchTo().defaultContent();
		
		List <WebElement> AllCheckboxes =  driver.findElements(By.name("removefromcart"));
	    if(AllCheckboxes.isEmpty()) 
		    {
		    	System.out.println(" shopping cart is empty ");
		    }
		    else
		    {
			    int size = AllCheckboxes.size();
			    System.out.println(" shopping cart size is = " + size);
			   
			    for(int i = 0; i<size; i++) {
			        
			        AllCheckboxes.get(i).click();
			    }
			    
			    driver.findElement(By.name("updatecart")).click();
		    }
	    
	    
	 //Select “Desktop” from the hover menu
	    driver.switchTo().defaultContent();
	    Actions actions = new Actions(driver);
	    
	    WebElement ele = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
	    actions.moveToElement(ele).moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"))).click().build().perform();
	    
	    
	 //select computer from the list displayed.
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//a[contains(text(),'Build your own cheap computer')]")).click();
	    
	 //Get the price details and enter the quantity and add to cart
	    driver.switchTo().defaultContent();
	    String price =driver.findElement(By.className("price-value-72")).getText();
	    
	    System.out.println("selected item price ="+price);
	    
	    driver.findElement(By.id("addtocart_72_EnteredQuantity")).clear();
	    driver.findElement(By.id("addtocart_72_EnteredQuantity")).sendKeys(Quantity);
	    
	    driver.findElement(By.id("add-to-cart-button-72")).click();
	   
	    
	 //Validate “The product has been added to your shopping cart” message
	   // Thread.sleep(3000); 
	   // Alert alert = driver.switchTo().alert();
	    String Popup = driver.findElement(By.xpath("//div[@id='bar-notification']")).getText();
	    System.out.println(Popup);
	   
	    
	 // click on the shopping cart and validate the subtotal.
	    
	  driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		
		String subtotal =driver.findElement(By.className("product-subtotal")).getText();
		
		System.out.println("Total cart amount ="+subtotal);
		
	//Select I agree  Checkbox and checkout
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		
	//Checkout page
		driver.switchTo().defaultContent();
		//billing address
		driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]")).click();
		
		//Shipping address
		
		WebDriverWait waitSA= new WebDriverWait(driver, Duration.ofSeconds(30));
		waitSA.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-shipping']//input[@onclick='Shipping.save()']"))).click();
		 
		//shipping method
		WebDriverWait waitSM= new WebDriverWait(driver, Duration.ofSeconds(30));
		waitSM.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-shipping_method']//input[@onclick='ShippingMethod.save()']"))).click();
		
		//payment method
		
		WebDriverWait waitPM= new WebDriverWait(driver, Duration.ofSeconds(30));
		waitPM.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-payment_method']//input[@onclick='PaymentMethod.save()']"))).click();
		
		//Payment Information
		WebDriverWait waitPI= new WebDriverWait(driver, Duration.ofSeconds(30));
		waitPI.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-payment_info']//input[@onclick='PaymentInfo.save()']"))).click();
	
		//Confirm Order
		WebDriverWait waitCO= new WebDriverWait(driver, Duration.ofSeconds(40));
		waitCO.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-confirm_order']//input"))).click();
		
	//Validate the message “Your order has been successfully processed!”
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//div[@class='title']")).getText();
			
		String actualMessage = driver.findElement(By.xpath("//div[@class='master-wrapper-main']//div[@class='title']")).getText();
	
		String expectedMessage = "Your order has been successfully processed!";
	
		Assert.assertEquals(actualMessage,expectedMessage);
		
		System.out.println(actualMessage);
		
		String OrderNo = driver.findElement(By.xpath("(//ul[@class='details']//li)[1]")).getText();
		System.out.println(OrderNo);
		
		driver.findElement(By.xpath("//div[@class='section order-completed']//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		System.out.println("logout");
		
	}

}
