package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimplifyHomePage {
	
	WebDriver driver;
	public SimplifyHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	String dashboardLocator="//h5[text()='Properties']";
	
	public void validateAdminVisibility()
	{
		
		if (driver.findElement(By.xpath(dashboardLocator)).isDisplayed()) {
			System.out.println("Home page is visible.");
		} else {
          System.out.println("Home page is not visible.");
		}
		
		
		
	}

}