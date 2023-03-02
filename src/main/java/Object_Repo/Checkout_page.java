package Object_Repo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_page {

	public Checkout_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration	
			@FindBy(xpath="(//input[@class='button-1 new-address-next-step-button'])[1]")
			private WebElement billingaddressTextfield;	
			
			@FindBy(xpath="//li[@id='opc-shipping']//input[@onclick='Shipping.save()']")
			private WebElement ShippingaddressTextfield;
			
			@FindBy(xpath="//li[@id='opc-shipping_method']//input[@onclick='ShippingMethod.save()']")
			private WebElement shippingmethodTextfield;
			
			@FindBy(xpath="//li[@id='opc-payment_method']//input[@onclick='PaymentMethod.save()']")
			private WebElement paymentmethodTextfield;
			
			@FindBy(xpath="//li[@id='opc-payment_info']//input[@onclick='PaymentInfo.save()']")
			private WebElement PaymentInformationTextfield;
			
			@FindBy(xpath="//li[@id='opc-confirm_order']//input")
			private WebElement ConfirmOrderTextfield;
			
	//Business logic
			
			public void BillingAddress()
			{
				billingaddressTextfield.click();
			}
			
			public WebElement ShippingsAddress(WebDriver driver)
			{
				WebDriverWait waitSA= new WebDriverWait(driver, Duration.ofSeconds(30));
				waitSA.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-shipping']//input[@onclick='Shipping.save()']"))).click();  
				return ShippingaddressTextfield;
			}
			
			public WebElement ShippingMethod(WebDriver driver)
			{
				WebDriverWait waitSM= new WebDriverWait(driver, Duration.ofSeconds(30));
				waitSM.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-shipping_method']//input[@onclick='ShippingMethod.save()']"))).click();
				return shippingmethodTextfield;
			}
			
			public WebElement PaymentMethod(WebDriver driver)
			{
				WebDriverWait waitPM= new WebDriverWait(driver, Duration.ofSeconds(30));
				waitPM.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-payment_method']//input[@onclick='PaymentMethod.save()']"))).click();
				return paymentmethodTextfield;
			}
			
			public WebElement PaymentInformation(WebDriver driver)
			{
				WebDriverWait waitPI= new WebDriverWait(driver, Duration.ofSeconds(30));
				waitPI.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-payment_info']//input[@onclick='PaymentInfo.save()']"))).click();
				return PaymentInformationTextfield;
			}
			
			public WebElement ConfirmOrder(WebDriver driver)
			{
				WebDriverWait waitCO= new WebDriverWait(driver, Duration.ofSeconds(40));
				waitCO.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='opc-confirm_order']//input"))).click();
				return ConfirmOrderTextfield;
			}
			
			
}

