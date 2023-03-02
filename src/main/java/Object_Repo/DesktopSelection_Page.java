package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopSelection_Page {
	
	public  DesktopSelection_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Computers')])[1]") 
	private WebElement ComputerTextField;
	
	@FindBy(xpath="(//a[contains(text(),'Desktops')])[1]")
	private WebElement DesktopTextField;
	
	@FindBy(xpath="//a[contains(text(),'Build your own cheap computer')]")
	private WebElement SelectComputerFromList;
	
	
	public void DesktopLink(WebDriver driver)
	{
		Actions actions = new Actions(driver);
	    
	    WebElement ele = ComputerTextField;
	    actions.moveToElement(ele).moveToElement(DesktopTextField).click().build().perform();
	
	}
	
	public void SelectComputer()
	{
		SelectComputerFromList.click();
	}

}
