package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.BaseSetup;
import common.SafeAction;

public class BuyPage extends SafeAction {

	WebDriver driver;
	WebDriverWait wait;

	String buyLinkLoc = "//h6[text()='Buy ']";
	String myRequirementLoc = "//label[text()='My Requirements ']//following::span[1]";
	String myRequirementDDLoc = "//label[text()='My Requirements ']//following::a[2]";
	String propertyFoundLoc = "//label[text()='Properties found']//preceding::strong[1]";
	String yieldInputFieldLoc = "//label[text()='Yield ']//following::input[1]";
	String saveButtonLoc = "//a[text()='Search']//following::a[7]";
	String inputFieldfilterLoc="//h4[text()='Save a Filter']//following::input[1]";
	String saveFilterLoc="//h4[text()='Save a Filter']//following::a[1]";
	String searchButtonLoc = "//a[text()='Search']";

	// String postCodeValue="HA1 1LG";

	public BuyPage(WebDriver driver) {
		super(); // Ensure SafeAction uses this driver
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // ✅ Correct for Selenium 4+
	}

	// ✅ Click on Buy tab

	public void clickOnBuyLink() {
		BaseSetup.infoLog("Attempting to click on the Buy tab...");
		try {
			safeExplicitWait(buyLinkLoc, VERYSHORTWAIT);
			try {
				safeExplicitWait(buyLinkLoc, VERYSHORTWAIT);
				safeClick(buyLinkLoc);
				BaseSetup.passLog("✅ Buy tab clicked successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(buyLinkLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Buy tab." + element);
			}
		}

		catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on  Buy tab. Error: " + e.getMessage());
		}

	}

	// ✅ Click On My Requirement drop down.
	public void clickOnMyRequirement() {

		BaseSetup.infoLog("Attempting to click My Requirement drop down..");
		try {
			needToWait(VERYSHORTWAIT); // loading time manage by this wait.
			safeExplicitWait(myRequirementLoc, SHORTWAIT);
			try {
				safeWaitForElementToBeClickable(myRequirementLoc, SHORTWAIT);
				safeClick(myRequirementLoc);
				BaseSetup.passLog("✅ My Requirement drop down clicked successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(myRequirementLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on My Requirement  tab.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on My Requirement. Error: " + e.getMessage());
		}

	}

	public void selectMyRequirement() {

		BaseSetup.infoLog("Attempting to Select My Requirement from Drop down.");
		try {
		//	waitForPageToLoad(driver, SHORTWAIT);
			safeExplicitWait(myRequirementDDLoc, SHORTWAIT);
			try {
				safeWaitForElementToBeVisible(myRequirementDDLoc, SHORTWAIT);
				safeWaitForElementToBeClickable(myRequirementDDLoc, SHORTWAIT);
				safeClick(myRequirementDDLoc);
				BaseSetup.passLog("✅ My Requirement from Drop down successfully using normal click.");
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(myRequirementDDLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Select My Requirement .");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Select on My Requirement. Error: " + e.getMessage());
		}

	}

	public void validatePropertyCount() {

		BaseSetup.infoLog("Attempting to Get property Count.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(propertyFoundLoc, SHORTWAIT);
			try {
				safeWaitForElementToBeClickable(propertyFoundLoc, SHORTWAIT);
				
				boolean propertyValue=safeIsDisplayed(propertyFoundLoc);
				BaseSetup.passLog("✅ Property Count visible------->"+ propertyValue);
				
				String headerGetText = safeGetText(propertyFoundLoc);
				BaseSetup.passLog("✅ Get property Count successfully------->" + headerGetText);

			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(propertyFoundLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Get property Count.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Get property Count. Error: " + e.getMessage());
		}

	}

	public void enterYieldPercentage(String yieldValue) {

		BaseSetup.infoLog("Attempting to enter Yield Percentage.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(yieldInputFieldLoc, SHORTWAIT);
			try {
				safeWaitForElementToBeClickable(yieldInputFieldLoc, SHORTWAIT);
				safeType(yieldInputFieldLoc, yieldValue);
				BaseSetup.passLog("✅ Yield Percentage Value entered successfully.------->" + yieldValue);
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(yieldInputFieldLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Yield Percentage.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to enter Yield Percentage. Error: " + e.getMessage());
		}

	}

	public void saveFilter(String filterName) {
		BaseSetup.infoLog("Attempting to Save Filter.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(saveButtonLoc, SHORTWAIT);
			try {
				safeWaitForElementToBeClickable(saveButtonLoc, SHORTWAIT);
				safeClick(saveButtonLoc);
				
				safeWaitForElementToBeClickable(inputFieldfilterLoc, SHORTWAIT);
				safeType(inputFieldfilterLoc, filterName); 
				
				safeWaitForElementToBeClickable(saveFilterLoc, SHORTWAIT);
				safeClick(saveFilterLoc);
                BaseSetup.passLog("✅ filterName Saved successfully.------->" + filterName);
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(saveButtonLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on filterName.");
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to save filterName. Error: " + e.getMessage());
		}

	}

	public void clickOnSearchButton() {
		BaseSetup.infoLog("Attempting to click on search button.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(searchButtonLoc, SHORTWAIT);
			try {
				safeWaitForElementToBeClickable(searchButtonLoc, SHORTWAIT);
				safeClick(searchButtonLoc);
				BaseSetup.passLog("✅ Search button clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(searchButtonLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Search button ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on search button. Error: " + e.getMessage()); //
		}

	}

}
