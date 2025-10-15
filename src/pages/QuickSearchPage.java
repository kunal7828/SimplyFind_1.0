package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.SafeAction;

public class QuickSearchPage extends SafeAction {

	String fullPostcodeInputLoc = "//h6[text()='Quick Search ']";
	String postCodeLoc = "//label[text()='Property Type']//preceding::input[1]";
	String valueSelectLoc = "//label[text()='Full Postcode']//following::a[1]";
	String searchButtonLoc = "//a[text()='Search']";

	WebDriver driver;
	WebDriverWait wait;
	
	public QuickSearchPage(WebDriver driver) {
	    super(); // Ensure SafeAction uses this driver
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Correct for Selenium 4+
	}
	
	
	public void clickOnQuickSearch() throws Exception {
        try {
            safeExplicitWait(fullPostcodeInputLoc, 5);
            try {
                safeClick(fullPostcodeInputLoc); // normal click
            } catch (Exception e) {
                WebElement element = driver.findElement(By.xpath(fullPostcodeInputLoc));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
            System.out.println("✅ First Quick Search tab clicked successfully.");
        } catch (Exception e) {
            System.out.println("❌ Quick Search tab not clickable: " + e.getMessage());
        }
    }

	
	
	
	

}
