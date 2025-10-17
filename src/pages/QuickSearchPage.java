package pages;

import java.time.Duration;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import common.BaseSetup;
import common.SafeAction;

public class QuickSearchPage extends SafeAction {

	WebDriver driver;
	WebDriverWait wait;

	String quickSearchLinkLoc = "//h6[text()='Quick Search ']";
	
	
	String valueSelectLoc = "//label[text()='Full Postcode']//following::a[1]";
	String searchButtonLoc = "//a[text()='Search']";

	String propertyTypeDropdownLoc = "//label[text()='Property Type']//following::span[1]";

	// String postCodeValue="HA1 1LG";

	public QuickSearchPage(WebDriver driver) {
		super(); // Ensure SafeAction uses this driver
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // ✅ Correct for Selenium 4+
	}

	// ✅ Click on Quick Search tab
	public void clickOnQuickSearch() {
		BaseSetup.infoLog("Attempting to click on the Quick Search tab...");
		try {
			safeExplicitWait(quickSearchLinkLoc, VERYSHORTWAIT);
			try {
				safeWaitForElementToBeClickable(quickSearchLinkLoc, VERYSHORTWAIT);
				safeClick(quickSearchLinkLoc);
				BaseSetup.passLog("✅ Quick Search tab clicked successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(quickSearchLinkLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Quick Search tab.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Quick Search tab. Error: " + e.getMessage());
		}
	}

	// ✅ Enter Postcode
	public void enterTextPostCodeField(String postCodeValue) {
		BaseSetup.infoLog("Attempting to enter postcode: " + postCodeValue);
		try {
			String fullPostCodeLoc="//label[text()='Full Postcode']";
			safeWaitForElementToBeClickable(fullPostCodeLoc, LONGWAIT);
			String  fullpostcodefield = safeGetText(fullPostCodeLoc);
			BaseSetup.infoLog("Attempting to click on label postcode: " + fullpostcodefield);

			String fullPostcodeInputLoc = "//label[text()='Property Type']//preceding::input[1]";   //----------------

			
			safeWaitForElementToBeClickable(fullPostcodeInputLoc, VERYSHORTWAIT);     //----------------
			safeType(fullPostcodeInputLoc, postCodeValue);
			BaseSetup.passLog("✅ Entered postcode '" + postCodeValue + "' successfully into Postcode field.");
		} catch (Exception e) {
			BaseSetup.failLog("❌ Failed to enter postcode '" + postCodeValue + "'. Error: " + e.getMessage());
		}
	}

	public void selectPostCodeProperty(String postCodeValue) {
		BaseSetup.infoLog("Attempting to select Property From List: " + postCodeValue);
		
		try {
			needToWait(SHORTWAIT);
			//	safeWaitForElementToBeVisible(valueSelectLoc, LONGWAIT);
			//	safeWaitForElementToBeClickable(valueSelectLoc, LONGWAIT);
				safeClick(valueSelectLoc);		
				BaseSetup.passLog("✅ Select postcode '" + postCodeValue + "' successfully into Postcode field.");
			} catch (Exception e) {
				BaseSetup.failLog("❌ Failed to Select postcode '" + valueSelectLoc + "'. Error: " + e.getMessage());
			}

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * 
	 * 
	 * 
	 * 
	 * BaseSetup.infoLog("Attempting to select Property From List: " + postCodeValue);

		try {
		needToWait(SHORTWAIT);
		//	safeWaitForElementToBeVisible(valueSelectLoc, LONGWAIT);
		//	safeWaitForElementToBeClickable(valueSelectLoc, LONGWAIT);
			safeClick(valueSelectLoc);
			
		
			
			
			
			
			
			
			BaseSetup.passLog("✅ Select postcode '" + postCodeValue + "' successfully into Postcode field.");
		} catch (Exception e) {
			BaseSetup.failLog("❌ Failed to Select postcode '" + valueSelectLoc + "'. Error: " + e.getMessage());
		}



	// ✅ Select Property Type
	public void clickOnSelectPropertyType() {
		BaseSetup.infoLog("Attempting to click on Property Type dropdown...");
		try {
			safeWaitForElementToBeClickable(propertyTypeDropdownLoc, VERYSHORTWAIT);
			safeClick(propertyTypeDropdownLoc);
			BaseSetup.passLog("✅ Property Type dropdown clicked successfully.");
		} catch (Exception e) {
			BaseSetup.failLog("❌ Failed to click on Property Type dropdown. Error: " + e.getMessage());
		}

		String propertyTypeListValueLocator = "//label[text()='Property Type']//following::label[1]";
		BaseSetup.infoLog("Attempting to select Property Type From List: " + propertyTypeListValueLocator);

		try {
			safeWaitForElementToBeClickable(propertyTypeListValueLocator, VERYSHORTWAIT);
			safeClick(propertyTypeListValueLocator);
			BaseSetup.passLog(
					"✅ Entered postcode '" + propertyTypeListValueLocator + "' successfully into Postcode field.");
		} catch (Exception e) {
			BaseSetup.failLog(
					"❌ Failed to enter postcode '" + propertyTypeListValueLocator + "'. Error: " + e.getMessage());
		}
		BaseSetup.infoLog("Attempting to click on Property Type dropdown...");
		try {
			safeWaitForElementToBeClickable(propertyTypeDropdownLoc, VERYSHORTWAIT);
			safeClick(propertyTypeDropdownLoc);
			BaseSetup.passLog("✅ Property Type dropdown clicked successfully.");
		} catch (Exception e) {
			BaseSetup.failLog("❌ Failed to click on Property Type dropdown. Error: " + e.getMessage());
		}
	}

	// ✅ Select Property Type
*/
}
