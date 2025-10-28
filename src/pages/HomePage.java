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
	//	boolean flag=safeIsDisplayed(homepage);
	//	Reporter.log("User login successfully.", true );
	//	return flag;
		
		if (driver.findElement(By.xpath(adminLocator)).isDisplayed()) {
			System.out.println("Home page is visible.");
			
			
		} else {
System.out.println("Home page is not visible.");
		}
	}
/*	
	public void clickOnProfileIcon() throws Exception {
		safeClick(clickOnProfileIcon);
		Reporter.log("profile icon clicked successfully.",true);
	}
	
     public void clickOnLogoutButton() throws Exception {
		
		safeClick(clickOnLogoutButton);
		Reporter.log("logout ckicked successfully.",true);
	}
*/
}
