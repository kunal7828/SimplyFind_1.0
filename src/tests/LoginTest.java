package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;
  @Test
  public void verifyLoginFunWithValidData() throws Exception {
	  LoginPage loginPage=new LoginPage(driver);
	  loginPage.enterUsername("Admin");
	  loginPage.enterPassword("admin123");
	  loginPage.clickOnLogin();
	  Thread.sleep(5000);
	  HomePage homePage=new HomePage(driver);
	  homePage.validateAdminVisibility();
	  Thread.sleep(5000);
	  
  }
  

  @BeforeSuite
  public void openBrowser() throws Exception {
	  driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
	  
  }

}
