package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.QuickSearchPageFun;

public class QuickSearchTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	
	String postCode="HA1 1LG";
	
	@Test(priority = 1)

	 public void verifyQuickSearchFunctionality() throws Exception {
	        QuickSearchPageFun quickSearchPageFun = new QuickSearchPageFun(driver);
	        quickSearchPageFun.clickOnQuickSearch();
	    //    quickSearchPageFun.enterPostcode();
	    }

	
	
	
	
	
	
	
	
	
}
