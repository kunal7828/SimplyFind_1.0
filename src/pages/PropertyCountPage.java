package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.BaseSetup;
import common.SafeAction;

public class PropertyCountPage extends SafeAction {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public PropertyCountPage(WebDriver driver) {
		super();// Ensure SafeAction uses this driver
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// ✅ Click on Quick Search tab
	public void clickOnBuy() {
		String buyLinkLocator = "//h6[text()='Buy ']";
		BaseSetup.infoLog("Attempting to click on the Buy tab...");
		try {
			safeExplicitWait(buyLinkLocator, VERYSHORTWAIT);
			try {
				safeClick(buyLinkLocator);
				BaseSetup.passLog("✅ Quick Search tab clicked successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(buyLinkLocator));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Buy link tab.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Buy link tab. Error: " + e.getMessage());
		}
	}

	public void clickOnMyRequirementField() {
		String myRequirementFieldLoc = "//label[text()='My Requirements ']//following::span[1]";
		BaseSetup.infoLog("Attempting to click on the My Requirement Field Drop down tab...");
		try {
			needToWait(SHORTWAIT);
			safeWaitForElementToBeVisible(myRequirementFieldLoc, SHORTWAIT);
			safeWaitForElementToBeClickable(myRequirementFieldLoc, SHORTWAIT);
			try {
				safeClick(myRequirementFieldLoc);
				BaseSetup.passLog("✅ My Requirement tab clicked successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(myRequirementFieldLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ My Requirement click failed.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on My Requirement Field Drop down tab. Error: " + e.getMessage());
		}

	}

	public void selectValueMyRequirement() {

		String myRequirementValueLoc = "//label[text()='My Requirements ']//following::a[2]";
		BaseSetup.infoLog("Select Value from My Requirement Field Drop down.");
		try {
			needToWait(SHORTWAIT);
			// safeWaitForElementToBeVisible(myRequirementValueLoc, VERYSHORTWAIT);
			safeWaitForElementToBeClickable(myRequirementValueLoc, VERYSHORTWAIT);
			// safeExplicitWait(myRequirementValueLoc, VERYSHORTWAIT);
			try {
				safeClick(myRequirementValueLoc);
				BaseSetup
						.passLog("✅ Select Value from My Requirement Field Drop down successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(myRequirementValueLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Select Value from My Requirement Field Drop down click failed.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on My Requirement value Drop down tab. Error: " + e.getMessage());
		}
	}

	public void getNumberOfProperties() {
		String propertyFoundLoc = "//a[text()='Reset']//following::strong[1]";
	    BaseSetup.infoLog("Fetching number of properties from locator: " + propertyFoundLoc);

	    try {
	        needToWait(SHORTWAIT);
	        safeWaitForElementToBeVisible(propertyFoundLoc, VERYSHORTWAIT);
	        safeWaitForElementToBeClickable(propertyFoundLoc, VERYSHORTWAIT);
	        safeClick(propertyFoundLoc);

	        // Get text from the element
	        String propertyCountText = driver.findElement(By.xpath(propertyFoundLoc)).getText().trim();
	        BaseSetup.infoLog("Property count text fetched: " + propertyCountText);

	        // ✅ Remove non-numeric characters (e.g., commas, spaces)
	        String numericText = propertyCountText.replaceAll("[^\\d]", "");

	        // ✅ Check if numericText is valid
	        if (numericText.isEmpty()) {
	            throw new NumberFormatException("Property count text is not numeric: " + propertyCountText);
	        }

	        int propertyCount = Integer.parseInt(numericText);

	        // Log success
	        BaseSetup.passLog("✅ Number of properties found: " + propertyCount);

	    } catch (NumberFormatException e) {
	        BaseSetup.failLog("❌ Failed to parse property count. Text might not be numeric. Error: " + e.getMessage());
	    } catch (Exception e) {
	        BaseSetup.failLog("❌ Unable to fetch property count. Error: " + e.getMessage());
	    }
	}
	
public void clickDashboard() {
    String dashboardLoc = "//a[text()='Dashboard']"; // Dashboard count element
    safeClick(dashboardLoc); // Use SafeAction method
    BaseSetup.passLog("✅ Dashboard clicked successfully.");

}



public void getTotalPropertiesOnMarket() {
    try {
        // XPath to locate all property count elements for "No. of properties on the market"
        String propertyCountsXpath = "";

        // Wait for the dashboard to load
        safeWaitForElementToBeVisible(propertyCountsXpath, SHORTWAIT);

        // Find all property count elements
        List<WebElement> propertyElements = driver.findElements(By.xpath(propertyCountsXpath));

        int total = 0;
        for (WebElement el : propertyElements) {
            String text = el.getText().trim();
            BaseSetup.infoLog("Fetched property count text: " + text);

            // Remove commas and non-numeric chars
            String numericText = text.replaceAll("[^\\d]", "");
            if (numericText.isEmpty()) continue;

            int value = Integer.parseInt(numericText);
            total += value;
        }

        BaseSetup.passLog("✅ Total number of properties on the market: " + total);

    } catch (Exception e) {
        BaseSetup.failLog("❌ Failed to fetch and sum property counts. Error: " + e.getMessage());
    }
}



public void sumAllBedAndStudioCounts() {
    // Locator for all numeric cells in the highlighted row
    String propertyRowLocator = "//div[contains(@class,'dasboard_list_inner') and contains(@class,'font-600')]";

    try {
        BaseSetup.infoLog("Fetching all property counts for Studio and Beds...");
        
        // Wait for elements to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> propertyElements = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(propertyRowLocator))
        );

        int total = 0;
        for (WebElement element : propertyElements) {
            String text = element.getText().trim().replace(",", "");
            if (!text.isEmpty()) {
                try {
                    total += Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    BaseSetup.warningLog("⚠️ Skipped invalid number: " + text);
                }
            }
        }

        BaseSetup.passLog("✅ Total count for Studio and Beds: " + total);

    } catch (Exception e) {
        BaseSetup.failLog("❌ Failed to fetch and sum property counts. Error: " + e.getMessage());
    }
}


 
}

	
	