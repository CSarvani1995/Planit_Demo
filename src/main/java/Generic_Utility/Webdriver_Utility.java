package Generic_Utility;

import org.openqa.selenium.WebDriver;

public class Webdriver_Utility {

	public void maximizeScreen(WebDriver driver)
	{
		
		driver.manage().window().maximize();
	}

	public void defaultcontent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
}
