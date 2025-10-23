package common;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class SafeAction extends Sync {
    public WebDriver driver;

    public SafeAction() {
        this.driver = BaseSetup.driver;
    }
    
   
    // Click action using XPath
    public void safeClick(String xpathLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
            element.click();
            Reporter.log(String.format("✅ Successfully clicked element with XPath: %s", xpathLocator), true);
        } catch (TimeoutException e) {
            Reporter.log(String.format("❌ Timeout: Element not clickable within time limit. XPath: %s", xpathLocator), true);
        } catch (NoSuchElementException e) {
            Reporter.log(String.format("❌ Element not found with XPath: %s", xpathLocator), true);
        } catch (ElementClickInterceptedException e) {
            Reporter.log(String.format("⚠️ Click intercepted by another element. XPath: %s", xpathLocator), true);
            waitForPageToLoad(driver, 10);
        } catch (ElementNotInteractableException e) {
            Reporter.log(String.format("⚠️ Element not interactable with XPath: %s", xpathLocator), true);
        } catch (StaleElementReferenceException e) {
            Reporter.log(String.format("⚠️ Element became stale while attempting to click. XPath: %s", xpathLocator), true);
        } catch (Exception e) {
            Reporter.log(String.format("❌ Unexpected error while clicking element with XPath: %s. Error: %s", xpathLocator, e.getMessage()), true);
        }
    }
    
    
   /*
    public void safeClick(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.findElement(locator).click();
                return;
            } catch (ElementClickInterceptedException e) {
                BaseSetup.warningLog("⚠️ Click intercepted, retrying...");
                waitForPageToLoad(driver, 10);
            }
            attempts++;
        }
        throw new RuntimeException("❌ Failed to click element after multiple retries: " + locator);
    }
    
    */
    public void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(webDriver ->
            ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
        BaseSetup.infoLog("✅ Page fully loaded and ready.");
    }

    public void waitForLoaderToDisappear(By loaderLocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
        BaseSetup.infoLog("✅ Loader disappeared, page ready for interaction.");
    }
    
    
    
    

    // Type action using XPath
    public void safeType(String xpathLocator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));

            element.clear(); // Always clear existing text before typing
            element.sendKeys(value);
            
            if (!element.getAttribute("value").equals(value)) {
                // Fallback: use JavaScript if sendKeys didn't register
                ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, value);
            }

            Reporter.log(String.format("✅ Successfully entered value '%s' into element with XPath: %s", value, xpathLocator), true);

        } catch (TimeoutException e) {
            Reporter.log(String.format("❌ Timeout: Element not visible within time limit. XPath: %s", xpathLocator), true);
        } catch (NoSuchElementException e) {
            Reporter.log(String.format("❌ Element not found with XPath: %s", xpathLocator), true);
        } catch (ElementNotInteractableException e) {
            Reporter.log(String.format("⚠️ Element not interactable with XPath: %s", xpathLocator), true);
        } catch (StaleElementReferenceException e) {
            Reporter.log(String.format("⚠️ Element became stale while typing. XPath: %s", xpathLocator), true);
        } catch (Exception e) {
            Reporter.log(String.format("❌ Unexpected error while typing into element with XPath: %s. Error: %s", xpathLocator, e.getMessage()), true);
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
