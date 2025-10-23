package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.BuyPage;

public class BuyTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	
	
	String yieldValue="8";
	String filterName="abc";
		
	@Test(priority = 1)

	 public void verifyBuyFiltersFunctionality() throws Exception {	
		BuyPage buyPage = new BuyPage(driver);
		buyPage.clickOnBuyLink();
		buyPage.clickOnMyRequirement();
		buyPage.selectMyRequirement();  
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
		buyPage.enterYieldPercentage(yieldValue);
		buyPage.saveFilter(filterName);
		buyPage.clickOnSearchButton();
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
	}
	
	
 
}
