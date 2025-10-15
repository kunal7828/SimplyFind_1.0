package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestG {
	WebDriver driver;
	
	String username="//input[@name='username']";
	String password="//input[@name='password']";
	String loginButton="//button[text()=' Login ']";
	
	public void enterUsername(String usernameValue)
	{
		System.out.println("Driver value==>>"+driver);
	driver.findElement(By.xpath(username)).sendKeys(usernameValue);	
	}
	
	public void enterPassword(String passwordValue)
	{
		driver.findElement(By.xpath(password)).sendKeys(passwordValue);	
	}
	public void clickOnLogin()
	{
		driver.findElement(By.xpath(loginButton)).click();	
	}
	
	

}
