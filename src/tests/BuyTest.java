package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import common.BaseSetup;
import pages.BuyPage;

public class BuyTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	
	
	String yieldValue="5.4";
	String filterName="test1";
	
	ExtentReports extent = new ExtentReports();
	ExtentTest test = extent.createTest("Validate Sorting");


		
	@Test(priority = 1, enabled=false, description="Verifying Buy Filters functionality")
	
	 public void verifyPropertyCountWithYieldFiltersFunctionality() throws Exception {	
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
	public void verifySortingFunctionality() { 
		BuyPage buyPage = new BuyPage(driver);
		buyPage.clickOnBuyLink();
		
		buyPage.clickOnMyRequirement();
		buyPage.selectMyRequirement();  
		
		buyPage.clickOnSortByDropDown();
		buyPage.selectAICFromSortingList();	 
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test);
		
		buyPage.clickOnSortByDropDown();
		buyPage.selectDaysOnMKTFromSortingList();
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test);
			
		buyPage.clickOnSortByDropDown();
		buyPage.selectDiscountFromSortingList();
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 

		buyPage.clickOnSortByDropDown();
		buyPage.selectEPCFromSortingList();
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 

		buyPage.clickOnSortByDropDown();
		buyPage.selectYieldFromSortingList();
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test); 
		buyPage.clickOnAcendingAndDecendingIcon();
		buyPage.takeScreenshotForValidateSorting(test);
	
	}
	
	@Test (priority=3, enabled= true) //enabled= false , true
	public void verifyMoreFilterFunctionality() { 
		BuyPage buyPage = new BuyPage(driver);
		buyPage.clickOnBuyLink();
		buyPage.clickOnMyRequirement();
		buyPage.selectMyRequirement();  
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
		buyPage.clickOnMoreFilterDropDown();
		buyPage.clickOnAddedToSiteDropDown();
		buyPage.selectAddedToSiteDropDownValue();
		buyPage.selectMustHave();
	//	buyPage.selectDontShow();
		buyPage.viewFilterCheckbox();
	//	buyPage.RadonFilter();	
	//	buyPage.clickOnEPCCurrentDropDown();
	//	buyPage.selectEPCCurrentDropDown();
		buyPage.clickOnSearchButton();
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
		

		
	}
	
	
	
	
 
}
