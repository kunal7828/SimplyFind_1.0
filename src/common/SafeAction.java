package common;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;



public class SafeAction extends Sync {
    public WebDriver driver;

    public SafeAction() {
        this.driver = BaseSetup.driver;
    }

    
    
    
    
    
    
    
    // Click action using XPath
    public void safeClick(String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            Reporter.log("Clicked successfully on element with XPath: " + xpathLocator, true);
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (ElementNotInteractableException e) {
            Reporter.log("Element not interactable with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while clicking the element with XPath: " + xpathLocator, true);
        }
    }

    // Type action using XPath
    public void safeType(String xpathLocator, String value) {
        try {
            WebElement element = driver.findElement(By.xpath(xpathLocator));
            element.sendKeys(value);
            Reporter.log("Entered value: " + value + " successfully into element with XPath: " + xpathLocator, true);
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (ElementNotInteractableException e) {
            Reporter.log("Unable to type into the element with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while typing into element with XPath: " + xpathLocator, true);
        }
    }

    // Clear action using XPath
    public void safeClear(String xpathLocator) {
        try {
            WebElement element = driver.findElement(By.xpath(xpathLocator));
            element.clear();
            Reporter.log("Cleared the element with XPath: " + xpathLocator, true);
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while clearing the element with XPath: " + xpathLocator, true);
        }
    }

    // Get text action using XPath
    public String safeGetText(String xpathLocator) {
        try {
            WebElement element = driver.findElement(By.xpath(xpathLocator));
            String text = element.getText();
            Reporter.log("Retrieved text from element with XPath: " + xpathLocator + ". Text: " + text, true);
            return text;
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while retrieving text from the element with XPath: " + xpathLocator, true);
        }
        return null;
    }

    // Get Title action
    public String safeGetTitle() {
        try {
            String title = driver.getTitle();
            Reporter.log("Title is: " + title, true);
            return title;
        } catch (Exception e) {
            Reporter.log("An error occurred while retrieving the title.", true);
        }
        return null;
    }

    // Get Attribute action using XPath
    public String safeGetAttribute(String xpathLocator, String attribute) {
        try {
            String value = driver.findElement(By.xpath(xpathLocator)).getAttribute(attribute);
            Reporter.log("Retrieved attribute: " + attribute + " from element with XPath: " + xpathLocator, true);
            return value;
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while retrieving attribute from the element with XPath: " + xpathLocator, true);
        }
        return null;
    }

    // Check if element is displayed using XPath
    public boolean safeIsDisplayed(String xpathLocator) {
        try {
            boolean isDisplayed = driver.findElement(By.xpath(xpathLocator)).isDisplayed();
            Reporter.log("Element with XPath: " + xpathLocator + " is displayed: " + isDisplayed, true);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while checking display status of the element with XPath: " + xpathLocator, true);
        }
        return false;
    }

    // Check if element is enabled using XPath
    public boolean safeIsEnabled(String xpathLocator) {
        try {
            boolean isEnabled = driver.findElement(By.xpath(xpathLocator)).isEnabled();
            Reporter.log("Element with XPath: " + xpathLocator + " is enabled: " + isEnabled, true);
            return isEnabled;
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while checking enabled status of the element with XPath: " + xpathLocator, true);
        }
        return false;
    }

    // Check if element is selected using XPath
    public boolean safeIsSelected(String xpathLocator) {
        try {
            boolean isSelected = driver.findElement(By.xpath(xpathLocator)).isSelected();
            Reporter.log("Element with XPath: " + xpathLocator + " is selected: " + isSelected, true);
            return isSelected;
        } catch (NoSuchElementException e) {
            Reporter.log("Element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while checking selected status of the element with XPath: " + xpathLocator, true);
        }
        return false;
    }

    // Select by visible text using XPath
    public void safeSelectByVisibleText(String xpathLocator, String visibleText) {
        try {
            Select dropdown = new Select(driver.findElement(By.xpath(xpathLocator)));
            dropdown.selectByVisibleText(visibleText);
            Reporter.log("Selected option with visible text: " + visibleText + " from dropdown with XPath: " + xpathLocator, true);
        } catch (NoSuchElementException e) {
            Reporter.log("Dropdown element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while selecting by visible text from the dropdown with XPath: " + xpathLocator, true);
        }
    }

    // Select by value using XPath
    public void safeSelectByValue(String xpathLocator, String value) {
        try {
            Select dropdown = new Select(driver.findElement(By.xpath(xpathLocator)));
            dropdown.selectByValue(value);
            Reporter.log("Selected option with value: " + value + " from dropdown with XPath: " + xpathLocator, true);
        } catch (NoSuchElementException e) {
            Reporter.log("Dropdown element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while selecting by value from the dropdown with XPath: " + xpathLocator, true);
        }
    }

    // Select by index using XPath
    public void safeSelectByIndex(String xpathLocator, int index) {
        try {
            Select dropdown = new Select(driver.findElement(By.xpath(xpathLocator)));
            dropdown.selectByIndex(index);
            Reporter.log("Selected option at index: " + index + " from dropdown with XPath: " + xpathLocator, true);
        } catch (NoSuchElementException e) {
            Reporter.log("Dropdown element not found with XPath: " + xpathLocator, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while selecting by index from the dropdown with XPath: " + xpathLocator, true);
        }
    }

    // Refresh page
    public void safeRefreshPage() {
        try {
            driver.navigate().refresh();
            Reporter.log("Refreshed the current page.", true);
        } catch (Exception e) {
            Reporter.log("An error occurred while refreshing the page.", true);
        }
    }

    // Navigate to URL
    public void safeNavigateTo(String url) {
        try {
            driver.navigate().to(url);
            Reporter.log("Navigated to URL: " + url, true);
        } catch (Exception e) {
            Reporter.log("An error occurred while navigating to URL: " + url, true);
        }
    }

    // Go back
    public void safeBack() {
        try {
            driver.navigate().back();
            Reporter.log("Navigated back to the previous page.", true);
        } catch (Exception e) {
            Reporter.log("An error occurred while navigating back.", true);
        }
    }

    // Go forward
    public void safeForward() {
        try {
            driver.navigate().forward();
            Reporter.log("Navigated forward to the next page.", true);
        } catch (Exception e) {
            Reporter.log("An error occurred while navigating forward.", true);
        }
    }

    // Get current URL
    public String safeGetCurrentUrl() {
        try {
            String currentUrl = driver.getCurrentUrl();
            Reporter.log("Current URL is: " + currentUrl, true);
            return currentUrl;
        } catch (Exception e) {
            Reporter.log("An error occurred while retrieving the current URL.", true);
        }
        return null;
    }
    
 // Safe Take Screenshot
    public void safeTakeScreenshot(String screenshotName) {
        try {
            // Generate a timestamp for unique filenames
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotFileName = screenshotName + "_" + timestamp + ".png";

            // Take the screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the destination path (adjust the directory path as per your project structure)
            String screenshotDir = "C:\\Users\\ak200\\OneDrive\\Documents\\workspace\\SeleniumWD";  // Ensure this directory exists or create it
            File destination = new File(screenshotDir + screenshotFileName);

            // Save the screenshot to the destination path
            FileHandler.copy(screenshot, destination);

            Reporter.log("Screenshot saved at: " + destination.getAbsolutePath(), true);
        } catch (WebDriverException e) {
            Reporter.log("WebDriver exception occurred while taking the screenshot: " + e.getMessage(), true);
        } catch (IOException e) {
            Reporter.log("IOException occurred while saving the screenshot: " + e.getMessage(), true);
        } catch (Exception e) {
            Reporter.log("An error occurred while taking the screenshot: " + e.getMessage(), true);
        }
    }


    // Close Window Which is Open
    public void safeClose() {
        try {
            driver.close();
            Reporter.log("Closed the current browser window.", true);
        } catch (Exception e) {
            Reporter.log("An error occurred while closing the browser window.", true);
        }
    }

    // Quit browser Which is Open
    public void safeQuit() {
        try {
            driver.quit();
            Reporter.log("Closed all browser windows and quit the WebDriver.", true);
        } catch (Exception e) {
            Reporter.log("An error occurred while quitting the WebDriver.", true);
        }
    }
}
