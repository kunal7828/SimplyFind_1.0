package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	String adminLocator="//h6[text()='Dashboard']";
	
	public void validateAdminVisibility()
	{
		
		if (driver.findElement(By.xpath(adminLocator)).isDisplayed()) {
			System.out.println("Home page is visible.");
			
			
		} else {
System.out.println("Home page is not visible.");
		}
	}

}
