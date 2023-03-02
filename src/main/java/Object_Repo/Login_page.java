package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

//Initialization
	public Login_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
		
//Declaration	
	@FindBy(className="ico-login")
	private WebElement loginIcoTextfield;
	
	@FindBy(id="Email")
	private WebElement emailIdTextfield;
	
	@FindBy(name="Password")
	private WebElement passwordTextfield;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement submitTextfield;
	
	
//Business logic
	public void LoginToApp(String Email, String password)
	{
		loginIcoTextfield.click();
		emailIdTextfield.sendKeys(Email);
		passwordTextfield.sendKeys(password);
		submitTextfield.click();
		
	}
}
