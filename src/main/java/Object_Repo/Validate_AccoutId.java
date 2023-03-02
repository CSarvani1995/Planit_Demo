package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate_AccoutId {
	
	//Initialization	
	public Validate_AccoutId(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration	
		@FindBy(xpath="(//a[@class='account'])[1]")
		private WebElement userIdTextfield;	
		
	//Business logic
	public void ValidateEmailId(String Email)
		{
		String userId = userIdTextfield.getText();
		if(userId.contains(Email)) 
		{
			System.out.println("User Id is correct");
		}
		else
		{
			System.out.println("User Id is different");
		}
			
		}	

}
