package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.BuyPage;

public class BuyTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	
	
	String yieldValue="5.4";
	String filterName="test1";
		
	@Test(priority = 1, enabled=true, description="Verifying Buy Filters functionality")
	
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
		buyPage.clickOnResetButton();
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
	}
	
	@Test (priority=2, enabled= false) //enabled= false , true
	public void verifyAICSortingFunctionality() { 
		BuyPage buyPage = new BuyPage(driver);
		buyPage.clickOnBuyLink();
		buyPage.clickOnMyRequirement();
		buyPage.selectMyRequirement();  
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
		buyPage.clickOnSortingIcon();
		buyPage.selectAICFromSortingList();
	//	buyPage.clickOnAcendingAndDecendingIcon();

		
	}
	
	
 
}
