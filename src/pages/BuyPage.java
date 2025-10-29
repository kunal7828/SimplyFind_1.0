package pages;

import java.io.IOException;
import org.testng.Reporter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import common.BaseSetup;
import common.ExtentReport;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.SafeAction;

import com.aventstack.extentreports.Status;

public class BuyPage extends SafeAction {

	WebDriver driver;
	WebDriverWait wait;

	String buyLinkLoc = "//h6[text()='Buy ']";
	String myRequirementLoc = "//label[text()='My Requirements ']//following::span[1]";
	String myRequirementDDLoc = "//label[text()='My Requirements ']//following::a[2]";
	String propertyFoundLoc = "//label[text()='Properties found']//preceding::strong[1]";
	String yieldInputFieldLoc = "//label[text()='Yield ']//following::input[1]";
	String saveButtonLoc = "//a[text()='Search']//following::a[7]";
	String inputFieldfilterLoc = "//h4[text()='Save a Filter']//following::input[1]";
	String saveFilterLoc = "//h4[text()='Save a Filter']//following::a[1]";
	String searchButtonLoc = "//a[text()='Search']";
	String sortByListLoc = "//label[text()='Sort by']//following::a[1]";
	String sortAICLoc = "//label[text()='Sort by']//following::a[3]";
	String sortDaysOnMKTLoc = "//label[text()='Sort by']//following::a[4]";

	String sortDiscountLoc = "//label[text()='Sort by']//following::a[5]";
	String sortEPCLoc = "//label[text()='Sort by']//following::a[6]";
	String sortYieldLoc = "//label[text()='Sort by']//following::a[7]";

	String acendingAndDecendingIconLoc = "//label[text()='Sort by']//following::span[1]";
	String resetButtonLoc = "//a[text()='Reset']";

	String AddedToSiteDropDownLoc = "//label[text()='Added to Site']//following::span[1]";

	String anytimeLoc = "//label[text()='Added to Site']//following::a[3]";
	String last24HoursLoc = "//label[text()='Added to Site']//following::a[4]";
	String last7DaysLoc = "//label[text()='Added to Site']//following::a[5]";

	String newHome1Loc = "//label[text()='Must Haves']//following::a[text()='New Home'][1]";
	String leasehold1Loc = "//label[text()='Must Haves']//following::a[text()='Leasehold'][1]";
	String retirementHome1Loc = "//label[text()='Must Haves']//following::a[text()='Retirement Home'][1]";
	String auction1Loc = "//label[text()='Must Haves']//following::a[text()='Auction'][1]";
	String exLocalAuthority1Loc = "//label[text()='Must Haves']//following::a[text()='Ex Local Authority'][1]";
	String sharedOwnership1Loc = "//label[text()='Must Haves']//following::a[text()='Shared Ownership'][1]";

	String newHome2Loc = "//label[text()='Must Haves']//following::a[text()='New Home'][2]";
	String leasehold2Loc = "//label[text()='Must Haves']//following::a[text()='Leasehold'][2]";
	String retirementHome2Loc = "//label[text()='Must Haves']//following::a[text()='Retirement Home'][2]";
	String auction2Loc = "//label[text()='Must Haves']//following::a[text()='Auction'][2]";
	String exLocalAuthority2Loc = "//label[text()='Must Haves']//following::a[text()='Ex Local Authority'][2]";
	String sharedOwnership2Loc = "//label[text()='Must Haves']//following::a[text()='Shared Ownership'][2]";
	String development2Loc = "//label[text()='Must Haves']//following::a[text()='Development'][1]";
	String commercial2Loc = "//label[text()='Must Haves']//following::a[text()='Commercial'][1]";

	String includeUnderOfferSoldStc = "//h4[text()='View Filters']//following::label[text()=' Include Under Offer, Sold STC ']";
	String includeExcludedProperties = "//h4[text()='View Filters']//following::label[text()=' Include Excluded Properties ']";
	String discountedPropertiesOnly = "//h4[text()='View Filters']//following::label[text()=' Discounted Properties Only ']";
	
	
	String greaterThan1percent="//button[text()=' < 1 % ']";
	String Radon1to3percent="//button[text()=' 1 - 3 % ']";
	String Radona3to5percent="//button[text()=' 3 - 5 % ']";
	String Radona5to10percent="//button[text()=' 5 - 10 % ']";
	String Radon10to30percent="//button[text()=' 10 - 30 % ']";
	String lessThan30percent="//button[text()=' > 30 % ']";
	
	String currentDropDownLoc="//label[text()='Current']//following::a[1]";
	
	String selectACurrentLoc="//label[text()='Current']//following::a[3]";
	String selectBCurrentLoc="//label[text()='Current']//following::a[4]";
	String selectCCurrentLoc="//label[text()='Current']//following::a[5]";
	String selectDCurrentLoc="//label[text()='Current']//following::a[6]";
	String selectECurrentLoc="//label[text()='Current']//following::a[7]";
	String selectFCurrentLoc="//label[text()='Current']//following::a[8]";
	String selectGCurrentLoc="//label[text()='Current']//following::a[9]";
	
	String potentialDropDownLoc="//label[text()='Potential']//following::a[1]";
	
	String selectAPotentialLoc="//label[text()='Current']//following::a[3]";
	String selectBPotentialLoc="//label[text()='Current']//following::a[4]";
	String selectCPotentialLoc="//label[text()='Current']//following::a[5]";
	String selectDPotentialLoc="//label[text()='Current']//following::a[6]";
	String selectEPotentialLoc="//label[text()='Current']//following::a[7]";
	String selectFPotentialLoc="//label[text()='Current']//following::a[8]";
	String selectGPotentialLoc="//label[text()='Current']//following::a[9]";
	

	public BuyPage(WebDriver driver) {
		super(); // Ensure SafeAction uses this driver
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // ✅ Correct for Selenium 4+
	}

	// ✅ Click on Buy tab

	public void clickOnBuyLink() {
		needToWait(VERYSHORTWAIT);
		BaseSetup.infoLog("Attempting to click on the Buy tab...");
		try {
			safeExplicitWait(buyLinkLoc, LONGWAIT);
			try {
				safeExplicitWait(buyLinkLoc, LONGWAIT);
				safeClick(buyLinkLoc);
				needToWait(VERYSHORTWAIT);
				BaseSetup.passLog("✅ Buy tab clicked successfully using normal click.");
				Reporter.log(" ✅ Buy tab clicked successfully", true);
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
		needToWait(SHORTWAIT);
		String myRequirementLabelLoc = "//label[text()='My Requirements ']";
		// right now no option using static wait because of the loading issues
		;
		BaseSetup.infoLog(safeGetText(myRequirementLabelLoc));

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
		needToWait(SHORTWAIT);
		BaseSetup.infoLog("Attempting to Select My Requirement from Drop down.");
		try {
			// needToWait(VERYSHORTWAIT);
			safeExplicitWait(myRequirementDDLoc, LONGWAIT);
			try {
				// safeWaitForElementToBeClickable(myRequirementDDLoc, SHORTWAIT);
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
			safeExplicitWait(propertyFoundLoc, LONGWAIT);
			try {
				// safeWaitForElementToBeVisible(propertyFoundLoc, LONGWAIT);
				// safeWaitForElementToBeClickable(propertyFoundLoc, LONGWAIT);
				safeExplicitWait(propertyFoundLoc, LONGWAIT);
				boolean propertyValue = safeIsDisplayed(propertyFoundLoc);
				BaseSetup.passLog("✅ Property Count visible------->" + propertyValue);

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
			needToWait(SHORTWAIT);// loading time manage by this wait.
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

	// click on sort_by_dropdown list

	public void clickOnSortByDropDown() {
		needToWait(SHORTWAIT);// loading time manage by this wait.
		BaseSetup.infoLog("Attempting to click on Sorting List Icon.");
		try {

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
		needToWait(VERYVERYSHORTWAIT);// loading time manage by this wait.

		BaseSetup.infoLog("Attempting to select AIC from Sorting List.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortAICLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortAICLoc, LONGWAIT);
				safeClick(sortAICLoc);
				BaseSetup.passLog("✅ AIC Selected Successfully from sorting list."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortAICLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript select Aic From sorting list ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to select AIC from Sorting List. Error: " + e.getMessage()); //
		}
	}

	public void selectDaysOnMKTFromSortingList() {
		needToWait(VERYVERYSHORTWAIT);// loading time manage by this wait.
		BaseSetup.infoLog("Attempting to select Days On MKT from Sorting List.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortDaysOnMKTLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortDaysOnMKTLoc, LONGWAIT);
				safeClick(sortDaysOnMKTLoc);
				BaseSetup.passLog("✅ Days On MKT Selected Successfully from sorting list."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortDaysOnMKTLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog(
						"⚠️ Normal click failed. Executed JavaScript select Days On MKT From sorting list ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to select Days On MKT from Sorting List. Error: " + e.getMessage()); //
		}

	}

	public void selectDiscountFromSortingList() {
		needToWait(VERYVERYSHORTWAIT);// loading time manage by this wait.
		BaseSetup.infoLog("Attempting to select Discount from Sorting List.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortDiscountLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortDiscountLoc, LONGWAIT);
				safeClick(sortDiscountLoc);
				BaseSetup.passLog("✅ Discount Selected Successfully from sorting list."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortDiscountLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript select Discount From sorting list ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to select Discount from Sorting List. Error: " + e.getMessage()); //
		}

	}

	public void selectEPCFromSortingList() {
		needToWait(VERYVERYSHORTWAIT);// loading time manage by this wait.
		BaseSetup.infoLog("Attempting to select EPC from Sorting List.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortEPCLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortEPCLoc, LONGWAIT);
				safeClick(sortEPCLoc);
				BaseSetup.passLog("✅ EPC Selected Successfully from sorting list."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortEPCLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript select EPC From sorting list ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to select EPC from Sorting List. Error: " + e.getMessage()); //
		}

	}

	public void selectYieldFromSortingList() {
		needToWait(VERYVERYSHORTWAIT);// loading time manage by this wait.
		BaseSetup.infoLog("Attempting to select Yield from Sorting List.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(sortYieldLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(sortYieldLoc, LONGWAIT);
				safeClick(sortYieldLoc);
				BaseSetup.passLog("✅ Yield Selected Successfully from sorting list."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(sortYieldLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript select Yield From sorting list ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to select Discount from Yield List. Error: " + e.getMessage()); //
		}

	}

	public void clickOnOrderManageIcon() {

	}

	public void takeScreenshotForValidateSorting(ExtentTest test) {
//    safeScrollBy(0, 300); // Scroll down
		needToWait(SHORTWAIT); // Short wait

		String screenshotPath = System.getProperty("user.dir") + "/reports/screenshots/sorting";
	     String actualPathIncludingImageName=	safeTakeScreenshot(test, screenshotPath); // Screenshot taken and saved

		test.log(Status.INFO, "Screenshot after sorting validation",
				MediaEntityBuilder.createScreenCaptureFromPath(actualPathIncludingImageName).build()); // Screenshot logged in report

		// safeScrollBy(0, -400); // Scroll back up
		needToWait(SHORTWAIT); // Short wait
	}

	public void clickOnAcendingAndDecendingIcon() {

		BaseSetup.infoLog("Attempting to click on acending And Decending Icon.");
		try {
			// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
			safeExplicitWait(acendingAndDecendingIconLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(acendingAndDecendingIconLoc, LONGWAIT);
				safeClick(acendingAndDecendingIconLoc);
				BaseSetup.passLog("✅ Acending And Decending Icon clicked successfully.");

				//
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(acendingAndDecendingIconLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Sorting List Icon ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Sorting List Icon. Error: " + e.getMessage()); //
		}

	}
	// more filter code starts from here

//	
	public void clickOnMoreFilterDropDown() {

		String moreFilterDropDownLoc = "//label[text()='More Filters']//following::a[1]";

		BaseSetup.infoLog("Attempting to click on More Filter Drop Down.");
		// needToWait(VERYSHORTWAIT);//loading time manage by this wait.

		try {

			safeExplicitWait(moreFilterDropDownLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(moreFilterDropDownLoc, LONGWAIT);
				safeClick(moreFilterDropDownLoc);
				BaseSetup.passLog("✅ More Filter Drop Down clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(moreFilterDropDownLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on More Filter Drop Down."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on More Filter Drop Down. Error: " + e.getMessage()); //
		}

	}

	public void clickOnAddedToSiteDropDown() {

		try {

			safeExplicitWait(AddedToSiteDropDownLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(AddedToSiteDropDownLoc, LONGWAIT);
				safeClick(AddedToSiteDropDownLoc);
				BaseSetup.passLog("✅ Added To Site DropDown Drop Down clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(AddedToSiteDropDownLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on  Added To Site DropDown ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Added To Site DropDown . Error: " + e.getMessage()); //
		}
	}

	public void selectAddedToSiteDropDownValue() {

		needToWait(SHORTWAIT);// loading time manage by this wait.
		BaseSetup.infoLog("Attempting to click on Sorting List Icon.");
		try {

			safeExplicitWait(anytimeLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(anytimeLoc, LONGWAIT);
				safeClick(anytimeLoc);
				// safeClick(last24HoursLoc);
				// safeClick(last7DaysLoc);

				BaseSetup.passLog("✅ Anytime Value Selected successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(anytimeLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Anytime List Icon ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Anytime on List Icon. Error: " + e.getMessage()); //
		}
	}

	public void selectMustHave() {

		BaseSetup.infoLog("Attempting to Select Must Haves.");
		// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
		try {

			safeExplicitWait(newHome1Loc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(newHome1Loc, LONGWAIT);
				safeClick(newHome1Loc); // 1.
				 safeClick(leasehold1Loc); //2
				 safeClick(retirementHome1Loc); //3
				 safeClick(auction1Loc); //4
				 safeClick(exLocalAuthority1Loc); //5
				safeClick(sharedOwnership1Loc); //6

				BaseSetup.passLog("✅ Must Haves selected successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(newHome1Loc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript click on Must Haves."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click on Must Haves. Error: " + e.getMessage()); //
		}

	}

	public void selectDontShow() {

		BaseSetup.infoLog("Attempting to Select Dont Show.");
		// needToWait(VERYSHORTWAIT);  //loading time manage by this wait.
		try {

			safeExplicitWait(newHome2Loc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(newHome2Loc, LONGWAIT);
			//	safeClick(newHome2Loc); // 1.
				 safeClick(leasehold2Loc); //2.
				// safeClick(retirementHome2Loc); //3.
				// safeClick(auction2Loc); //4.
				// safeClick(exLocalAuthority2Loc); //5.
				// safeClick(sharedOwnership2Loc); //6.
				// safeClick(development2Loc); //7.
				// safeClick(commercial2Loc); //8.

			BaseSetup.passLog("✅ Select Dont Show Filters successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(newHome2Loc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Select Dont Show Filters."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Select Dont Show Filters. Error: " + e.getMessage()); //
		}
	}

	public void viewFilterCheckbox() {

		BaseSetup.infoLog("Attempting to Select Dont Show.");
		 needToWait(VERYSHORTWAIT);//loading time manage by this wait.
		try {
			safeExplicitWait(includeUnderOfferSoldStc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(includeUnderOfferSoldStc, LONGWAIT);
				safeClick(includeUnderOfferSoldStc); // 1.
				 safeClick(includeExcludedProperties); //2.
				 safeClick(discountedPropertiesOnly); //3.
		BaseSetup.passLog("✅ View Filter checkbox selected successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(includeUnderOfferSoldStc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript View Filter checkbox selected ."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to View Filter checkbox. Error: " + e.getMessage()); //
		}
	}

	public void RadonFilter() {
		BaseSetup.infoLog("Attempting to Select Radon Filter.");
		// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
		try {
			safeExplicitWait(greaterThan1percent, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(greaterThan1percent, LONGWAIT);
				safeClick(greaterThan1percent);   //1.
				safeClick(Radon1to3percent);   //2.
				 safeClick(Radona3to5percent);  //3.
				 safeClick(Radona5to10percent); //4.
				 safeClick(Radon10to30percent); //5.
				 safeClick(lessThan30percent);  //6.
				
		BaseSetup.passLog("✅ Radon Filter selected successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(greaterThan1percent));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Radon Filter."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Radon Filter. Error: " + e.getMessage()); //
		}
	}
	 
	public void clickOnEPCCurrentDropDown() {
		BaseSetup.infoLog("Attempting to click On Current DropDown.");
		// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
		try {
			safeExplicitWait(currentDropDownLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(currentDropDownLoc, LONGWAIT);
				safeClick(currentDropDownLoc); // 1.
				
		BaseSetup.passLog("✅ Current DropDown clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(currentDropDownLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Current DropDown."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click Current DropDown Error: " + e.getMessage()); //
		}
	}
	
	public void selectEPCCurrentDropDown() {
		BaseSetup.infoLog("Attempting to Select EPC Current DropDown.");
		try {
			safeExplicitWait(selectACurrentLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(selectACurrentLoc, LONGWAIT);
			//	safeClick(selectACurrentLoc); // 1.
				safeClick(selectBCurrentLoc); //2.
				// safeClick(selectCCurrentLoc); //3.
				// safeClick(selectDCurrentLoc); //4.
				// safeClick(selectECurrentLoc); //5.
				// safeClick(selectFCurrentLoc); //6.
				// safeClick(selectGCurrentLoc); //7.
		BaseSetup.passLog("✅ Radon Filter selected successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(selectACurrentLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Radon Filter."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Radon Filter. Error: " + e.getMessage()); //
		}
	}
	
	public void clickOnEPCPotentialDropDown() {
		
		BaseSetup.infoLog("Attempting to click On Current DropDown.");
		// needToWait(VERYSHORTWAIT);//loading time manage by this wait.
		try {
			safeExplicitWait(potentialDropDownLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(potentialDropDownLoc, LONGWAIT);
				safeClick(potentialDropDownLoc); // 1.
				
		BaseSetup.passLog("✅ Current DropDown clicked successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(potentialDropDownLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Current DropDown."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to click Current DropDown Error: " + e.getMessage()); //
		}	
		
	}
	public void selectEPCPotentialDropDown() {
		BaseSetup.infoLog("Attempting to Select EPC Current DropDown.");
		try {
			safeExplicitWait(selectAPotentialLoc, LONGWAIT);
			try {
				safeWaitForElementToBeClickable(selectAPotentialLoc, LONGWAIT);
				safeClick(selectAPotentialLoc); // 1.
			//	safeClick(selectBPotentialLoc); //2.
				// safeClick(selectCPotentialLoc); //3.
				// safeClick(selectDPotentialLoc); //4.
				// safeClick(selectEPotentialLoc); //5.
				// safeClick(selectFPotentialLoc); //6.
				// safeClick(selectGPotentialLoc); //7.
		BaseSetup.passLog("✅ Radon Filter selected successfully."); //
			} catch (Exception e) {
				WebElement element = driver.findElement(By.xpath(selectAPotentialLoc));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				BaseSetup.warningLog("⚠️ Normal click failed. Executed JavaScript Radon Filter."); //
			}
		} catch (Exception e) {
			BaseSetup.failLog("❌ Unable to Radon Filter. Error: " + e.getMessage()); //
		}
	}
	
	
	
	
	
	

}
