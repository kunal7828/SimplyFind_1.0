package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.BaseSetup;
import pages.BuyPage;

public class BuyTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	String yieldValue="5.4";
	
    public static ExtentTest extentTest;

//	ExtentReports extent = new ExtentReports();
//	ExtentTest test = extent.createTest("Validate Sorting"); 
		
	@Test(priority = 1, enabled=false, description="Verifying Buy Filters functionality")  //enabled= false , true
	
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
		
	}
	
	@Test (priority=3, enabled=false)
		public void verifyAicSortingAcending() {
			BuyPage buyPage = new BuyPage(driver);
			buyPage.clickOnSortByDropDown();
			buyPage.selectAICFromSortingList();	 
			buyPage.clickOnAcendingAndDecendingIcon();
			
		}
	@Test (priority=4, enabled=false)
	public void verifyAicSortingDescending() {
		BuyPage buyPage = new BuyPage(driver);
		buyPage.clickOnAcendingAndDecendingIcon();
//		buyPage.safeLogScreenshot(extentTest, "AIC - Ascending", Status.PASS);
		// Screenshot after ascending
	}
		
		/*		
		 * 
		 * 
		
		
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
		*/
	
	String BuiltYear="1940";
	String filterName="test17";
	
	@Test (priority=5, enabled= true) //enabled= false , true
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
    //  buyPage.selectDontShow();
	//	buyPage.viewFilterCheckbox();
	//	buyPage.RadonFilter();	
	//	buyPage.clickOnEPCCurrentDropDown();
	//	buyPage.selectEPCCurrentDropDown();
	//	buyPage.clickOnEPCPotentialDropDown();
	//	buyPage.selectEPCPotentialDropDown();	
	//	buyPage.enterPropertyAgeBuiltYear(BuiltYear);    //change built year on runtime	
    //  buyPage.clickOnYearComparatorDropDown();
    //  buyPage.selectYearComparatorFromDropDown();
		
		buyPage.clickOncloseButton();
	    buyPage.saveFilter(filterName);
	    buyPage.clickOnSearchButton();
		buyPage.validatePropertyCount(); //Reusable method after applying filter.
		buyPage.clickOnDashboard();
		buyPage.getMatchingPropertyCount(); //Reusable method after applying filter.
		
		
		buyPage.clickOnWindowClose();
		buyPage.clickOnBedTypeDropDown();
		buyPage.removeAllBedType();
		
		

		
		


		
//		
		
		

		
	}
	
	
	
	
 
}
