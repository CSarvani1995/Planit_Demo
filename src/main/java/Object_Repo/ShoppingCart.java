package Object_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	public ShoppingCart(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration	
			@FindBy(xpath="//span[contains(text(),'Shopping cart')]")
			private WebElement ShoppingcartTextfield;	
			
			@FindBy(name ="removefromcart")
			private WebElement RemoveitemTextfield;	
			
			@FindBy(name ="updatecart")
			private WebElement UpdateCartTextfield;	
			
			@FindBy(className="product-subtotal")
			private WebElement subtotalTextfield;
			
			
			@FindBy(className="price-value-72")
			private WebElement priceTextfield;
			
			@FindBy(id="addtocart_72_EnteredQuantity")
			private WebElement addcartQuantityTextfield;
			
			@FindBy(id="add-to-cart-button-72")
			private WebElement addcartbuttonTextfield;
			
			@FindBy(id="termsofservice")
			private WebElement AgreecheckboxTextfield;
			
			@FindBy(id="checkout")
			private WebElement checkoutButtonTextField;
			
			
	//Business logic
			
			public void shoppingcartLink()
			{
				ShoppingcartTextfield.click();	
			}
			
			public void removeitem()
			{
				RemoveitemTextfield.click();
			}	
			
			public void updatecart()
			{	
				UpdateCartTextfield.click();
			}
			
			public void Subtotal(WebDriver driver)
			{
				String subtotal = subtotalTextfield.getText();
				System.out.println("Total cart amount ="+subtotal);
				
			}
			
			public void PriceofItem()
			{
				String price =priceTextfield.getText();
			    System.out.println("selected item price ="+price);
			}
			
			public void ItemQuanity(String Quantity)
			{
				addcartQuantityTextfield.clear();
				addcartQuantityTextfield.sendKeys(Quantity);
				
			}
			
			public void AddcartButton()
			{
				addcartbuttonTextfield.click();
			}
			
			public void AgreeCheckBox()
			{
				AgreecheckboxTextfield.click();
			}
			
			public void CheckOutButton()
			{
				checkoutButtonTextField.click();
			}
			
			
			
			
}
