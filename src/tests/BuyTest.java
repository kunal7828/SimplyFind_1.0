package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.BuyPage;

public class BuyTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	
	
	String yieldValue="5.5";
	String filterName="test2";
		
	@Test(priority = 1, enabled=false)
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
	
	@Test (priority=2, enabled= true)
	public void verifyAICSortingFunctionality() {
		BuyPage buyPage = new BuyPage(driver);
		buyPage.clickOnBuyLink();
		buyPage.clickOnMyRequirement();
		buyPage.selectMyRequirement();  
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
		buyPage.clickOnSortingIcon();
		buyPage.selectAICFromSortingList();
		
	}
	
	
 
}
