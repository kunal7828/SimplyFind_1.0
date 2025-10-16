package tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.QuickSearchPage;

public class QuickSearchTest extends BaseSetup {
	
	WebDriver driver;
    WebDriverWait wait;

	
	
	String postCodeValue="HA1";
	
	@Test(priority = 1)

	 public void verifyQuickSearchFunctionality() throws Exception {
		QuickSearchPage quickSearchPage = new QuickSearchPage(driver);
		quickSearchPage.clickOnQuickSearch();
		quickSearchPage.enterTextPostCodeField(postCodeValue);
		quickSearchPage.clickOnSelectPropertyType();
		
		
	    }
	
	
	
}
