package DemoWebShop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Generic_Utility.File_Utility;
import Generic_Utility.Webdriver_Utility;
import Object_Repo.Checkout_page;
import Object_Repo.DesktopSelection_Page;
import Object_Repo.Login_page;
import Object_Repo.ShoppingCart;
import Object_Repo.Validate_AccoutId;

public class BookComputer {

	public static void main(String[] args) throws Throwable {
		String Key="webdriver.driver.chrome";
		String Value="C:\\Selenium\\chromedriver_win32";
		System.setProperty(Key, Value);
		
		WebDriver driver=new ChromeDriver();
		Webdriver_Utility weblib = new Webdriver_Utility();
		weblib.maximizeScreen(driver);
				
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyandValue("url");
		String Email = flib.getKeyandValue("username");
		String Password = flib.getKeyandValue("password");
		String Quantity = flib.getKeyandValue("quantity");
		
	//Login to the Demo web shop with email and password details
		driver.get(URL);
		Login_page login = new Login_page(driver);
		login.LoginToApp(Email, Password);
		
	//Validate the user account ID 
		Validate_AccoutId ValidAccount = new Validate_AccoutId(driver);
		ValidAccount.ValidateEmailId(Email);
		
	//Remove items in shopping cart
		ShoppingCart cart = new ShoppingCart(driver);
		cart.shoppingcartLink();		
		weblib.defaultcontent(driver);
		
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
			    
			    cart.updatecart();
		    }
	    
	    
	 //Select “Desktop” from the hover menu
	    weblib.defaultcontent(driver);
	    DesktopSelection_Page desktop= new DesktopSelection_Page(driver);
	    desktop.DesktopLink(driver);	
	     
	 //select computer from the list displayed.
	    weblib.defaultcontent(driver);
	    desktop.SelectComputer();
	    
	 //Get the price details and enter the quantity and add to cart
	    weblib.defaultcontent(driver);
	    
	    cart.PriceofItem();
	    cart.ItemQuanity(Quantity);
	    cart.AddcartButton();
	    
	  //Validate “The product has been added to your shopping cart” message
		  String Popup = driver.findElement(By.xpath("//div[@id='bar-notification']")).getText();
		  System.out.println(Popup);   
	    
	 // click on the shopping cart and validate the subtotal. 
	    cart.shoppingcartLink();
	    weblib.defaultcontent(driver);
		cart.shoppingcartLink();
		cart.Subtotal(driver);
		
	//Select I agree  Checkbox and checkout
		cart.AgreeCheckBox();
		cart.CheckOutButton();
		
	//Checkout page
		weblib.defaultcontent(driver);
		Checkout_page checkout = new Checkout_page(driver);
		checkout.BillingAddress();
		checkout.ShippingsAddress(driver);
		checkout.ShippingMethod(driver);
		checkout.PaymentMethod(driver);
		checkout.PaymentInformation(driver);
		checkout.ConfirmOrder(driver);
		
	//logout
		
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		System.out.println("logout");
		
	}
	

}
