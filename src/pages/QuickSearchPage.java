package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import common.SafeAction;

public class QuickSearchPage extends SafeAction {

	WebDriver driver;
	WebDriverWait wait;

	String quickSearchLinkLoc = "//h6[text()='Quick Search ']";
	String fullPostcodeInputLoc = "//label[text()='Property Type']//preceding::input[1]";
	String valueSelectLoc = "//label[text()='Full Postcode']//following::a[1]";
	String searchButtonLoc = "//a[text()='Search']";

	String propertyTypeDropdownLoc = "//label[text()='Property Type']//following::span[1]";

	// String postCodeValue="HA1 1LG";

	public QuickSearchPage(WebDriver driver) {
		super(); // Ensure SafeAction uses this driver
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // ✅ Correct for Selenium 4+
	}

	public void clickOnQuickSearch() throws Exception {
		try {
			safeExplicitWait(quickSearchLinkLoc, 10);

			try {
				safeClick(quickSearchLinkLoc); // normal Selenium click
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(quickSearchLinkLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				Reporter.log("⚠️ Normal click failed. JS click executed for Quick Search tab.", true);
			}

			Reporter.log("✅ Quick Search tab clicked successfully.", true);

		} catch (Exception e) {
			Reporter.log(String.format("❌ Quick Search tab not clickable. Error: %s", e.getMessage()), true);
		}
	}

	public void enterTextPostCodeField(String postCodeValue) {
	    try {
	      
	        safeType(fullPostcodeInputLoc, postCodeValue);
	        safeExplicitWait(fullPostcodeInputLoc, 10);
	        Reporter.log(String.format("✅ Entered postcode '%s' successfully into the Postcode field.", postCodeValue), true);
	    } catch (Exception e) {
	        Reporter.log(String.format("❌ Failed to enter postcode '%s' into Postcode field. Error: %s", postCodeValue, e.getMessage()), true);
	    }
	}

	public void clickOnselectPropertyType() {
	    try {
	       
	        safeClick(propertyTypeDropdownLoc);
	        safeExplicitWait(propertyTypeDropdownLoc, 10);
	        Reporter.log("✅ Property Type dropdown clicked successfully.", true);
	    } catch (Exception e) {
	        Reporter.log(String.format("❌ Failed to click on Property Type dropdown. Error: %s", e.getMessage()), true);
	    }
	}
}
