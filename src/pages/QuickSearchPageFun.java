package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ExcelUtility;
import common.SafeAction;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class QuickSearchPageFun extends SafeAction {

    String quickSearchLinkLoc = "//h6[text()='Quick Search ']";
    String postCodeLoc = "//label[text()='Property Type']//preceding::input[1]";
    String valueSelectLoc = "//label[text()='Full Postcode']//following::a[1]";
    String searchButtonLoc = "//a[text()='Search']";

    WebDriver driver;
    WebDriverWait wait;

public QuickSearchPageFun(WebDriver driver) {
    super(); // Ensure SafeAction uses this driver
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Correct for Selenium 4+
}


    public void clickOnQuickSearch() throws Exception {
        try {
            safeExplicitWait(quickSearchLinkLoc, 5);
            try {
                safeClick(quickSearchLinkLoc); // normal click
            } catch (Exception e) {
                WebElement element = driver.findElement(By.xpath(quickSearchLinkLoc));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
            System.out.println("✅ First Quick Search tab clicked successfully.");
        } catch (Exception e) {
            System.out.println("❌ Quick Search tab not clickable: " + e.getMessage());
        }
    }

    public void enterPostcode() {
        By postcodeInput = By.xpath("//label[text()='Property Type']//preceding::input[1]");
        try {
            WebElement postcodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(postcodeInput));
            Thread.sleep(5000);
            postcodeElement.clear();
            postcodeElement.sendKeys("HA1");
            System.out.println("✅ Postcode entered successfully.");
        } catch (Exception e) {
            System.out.println("❌ Could not enter postcode: " + e.getMessage());
        }

        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath(searchButtonLoc)).click();
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("❌ Search button click failed: " + e.getMessage());
        }
    }


	
}



   
/* Junk code
   try {
        	safeExplicitWait(postCodeLoc, 10);
        	safeClear(postCodeLoc);
        	safeExplicitWait(postCodeLoc, 10);
        	safeType(postCodeLoc, postCode);
        	
        	
            Thread.sleep(5000);
            System.out.println("✅ Postcode entered successfully.");
        } catch (Exception e) {
            System.out.println("❌ Could not enter postcode: " + e.getMessage());
        }

        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath(searchButtonLoc)).click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("❌ Search button click failed: " + e.getMessage());
        }
*/