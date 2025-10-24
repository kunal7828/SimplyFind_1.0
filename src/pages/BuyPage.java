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
	String sortByListLoc="//label[text()='Sort by']//following::a[1]";
	String sortAICLoc="//label[text()='Sort by']//following::a[3]";
	String acendingAndDecendingIconLoc="//label[text()='Sort by']//following::span[1]";
	String resetButtonLoc="//a[text()='Reset']";


	public BuyPage(WebDriver driver) {
		super(); // Ensure SafeAction uses this driver
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // ✅ Correct for Selenium 4+
	}

	// ✅ Click on Buy tab

	public void clickOnBuyLink() {
		BaseSetup.infoLog("Attempting to click on the Buy tab...");
		try {
			safeExplicitWait(buyLinkLoc, LONGWAIT);
			try {
				safeExplicitWait(buyLinkLoc, LONGWAIT);
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
		needToWait(SHORTWAIT); // right now no option using static wait because of the loading issues
//		safeExplicitWait(myRequirementLoc, LONGWAIT);
	    BaseSetup.infoLog("Attempting to click My Requirement drop down..");
		try {
			// loading time manage by this wait.
			safeExplicitWait(myRequirementLoc, LONGWAIT);
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
	//		needToWait(VERYSHORTWAIT);
			safeExplicitWait(myRequirementDDLoc, LONGWAIT);
			try {
			//	safeWaitForElementToBeClickable(myRequirementDDLoc, SHORTWAIT);
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
		//	 needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(propertyFoundLoc, LONGWAIT);
			try {
			//	safeWaitForElementToBeVisible(propertyFoundLoc, LONGWAIT);
			//	safeWaitForElementToBeClickable(propertyFoundLoc, LONGWAIT);
				safeExplicitWait(propertyFoundLoc, LONGWAIT);
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
		   needToWait(SHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(yieldInputFieldLoc, LONGWAIT);
			try {
				safeWaitForElementToBeVisible(yieldInputFieldLoc, LONGWAIT);
				safeWaitForElementToBeClickable(yieldInputFieldLoc, LONGWAIT);
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
			safeExplicitWait(saveButtonLoc, LONGWAIT);
			try {
				safeWaitForElementToBeVisible(saveButtonLoc, LONGWAIT);
				safeWaitForElementToBeClickable(saveButtonLoc, LONGWAIT);
				safeClick(saveButtonLoc);
				
				safeWaitForElementToBeVisible(inputFieldfilterLoc, LONGWAIT);
				safeWaitForElementToBeClickable(inputFieldfilterLoc, LONGWAIT);
				safeType(inputFieldfilterLoc, filterName); 
				
				safeWaitForElementToBeVisible(saveFilterLoc, LONGWAIT);
				safeWaitForElementToBeClickable(saveFilterLoc, LONGWAIT);
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
			safeExplicitWait(searchButtonLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(searchButtonLoc, LONGWAIT);
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
	
	
	public void clickOnResetButton() {
		BaseSetup.infoLog("Attempting to click on Reset Button.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(resetButtonLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(resetButtonLoc, LONGWAIT);
				safeClick(resetButtonLoc);
				BaseSetup.passLog("✅ Reset Button clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(acendingAndDecendingIconLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Reset Button."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Reset Button. Error: " + e.getMessage()); //
		}
		
	}
	
	
	//verify ascending and descending properties in Aic
	
	public void clickOnSortingIcon() {	
		BaseSetup.infoLog("Attempting to click on Sorting List Icon.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortByListLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortByListLoc, LONGWAIT);
				safeClick(sortByListLoc);
				BaseSetup.passLog("✅ Sorting List Icon clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortByListLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Sorting List Icon ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Sorting List Icon. Error: " + e.getMessage()); //
		}
}
	
	public void selectAICFromSortingList() {
		BaseSetup.infoLog("Attempting to select AIC from Sorting List.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortAICLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortAICLoc, LONGWAIT);
				safeClick(sortAICLoc);
				BaseSetup.passLog("✅ AIC Selected Successfully from sorting list."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortByListLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript select Aic From sorting list ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to select AIC from Sorting List. Error: " + e.getMessage()); //
		}	
	}
	
	public void clickOnAcendingAndDecendingIcon() {
		
		BaseSetup.infoLog("Attempting to click on acending And Decending Icon.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(acendingAndDecendingIconLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(acendingAndDecendingIconLoc, LONGWAIT);
				safeClick(acendingAndDecendingIconLoc);
				BaseSetup.passLog("✅ Acending And Decending Icon clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(acendingAndDecendingIconLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Sorting List Icon ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Sorting List Icon. Error: " + e.getMessage()); //
		}
		
	}
	

	

	
	
	
}
	
		
		
		
		
		
		
		
		


