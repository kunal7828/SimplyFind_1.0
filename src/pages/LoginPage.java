package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	

	
	
	String userNameLoc = "//input[@placeholder='Enter User id']";
	String passWordLoc = "//input[@placeholder='Enter Password']";
	String loginButtonLoc = "//button[contains(@type,'submit')]";
	
	public void enterUsername(String usernameValue)
	{
		System.out.println("Driver value==>>"+driver);
	driver.findElement(By.xpath(userNameLoc)).sendKeys(usernameValue);	
	}
	
	public void enterPassword(String passwordValue)
	{
		driver.findElement(By.xpath(passWordLoc)).sendKeys(passwordValue);	
	}
	public void clickOnLogin()
	{
		driver.findElement(By.xpath(loginButtonLoc)).click();	
	}
	
	

}
