package common;

import java.time.Duration;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Sync extends ConstantVariable {

	public static WebDriver driver;

	public Sync() {

		this.driver = BaseSetup.driver;
		// System.out.println("Sync driver value--->" + this.driver);
		Reporter.log("🔗 Sync initialized with driver instance: " + this.driver, true);

	}

	/**
	 * Pauses the execution for a specified number of seconds. (Use only for
	 * debugging; prefer explicit or fluent waits in production.)
	 */
	public void needToWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
			Reporter.log(String.format("⏸️ Thread paused for %d seconds", seconds), true);
		} catch (InterruptedException e) {
			Reporter.log("❌ Thread interrupted during sleep: " + e.getMessage(), true);
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Sets a global implicit wait for element location.
	 */
	public void safeImplicitWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
			Reporter.log(String.format("⏳ Implicit wait set to %d seconds", seconds), true);
		} catch (Exception e) {
			Reporter.log("❌ Failed to set implicit wait: " + e.getMessage(), true);
		}
	}

	/**
	 * Waits explicitly until all elements matching the XPath are visible.
	 */
	public void safeExplicitWait(String locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
			Reporter.log(String.format("✅ Element(s) visible for XPath: %s (Waited %d sec)", locator, seconds), true);
		} catch (TimeoutException e) {
			Reporter.log(
					String.format("❌ Timeout: Element(s) not visible within %d sec for XPath: %s", seconds, locator),
					true);
		} catch (Exception e) {
			Reporter.log(String.format("❌ Error waiting for XPath %s: %s", locator, e.getMessage()), true);
		}
	}

	/**
	 * Waits using FluentWait for an element to be visible.
	 */
	public void safeFluentWait(String locator, int maxTimeoutSeconds, int pollingEverySeconds) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(maxTimeoutSeconds))
					.pollingEvery(Duration.ofSeconds(pollingEverySeconds)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			Reporter.log(String.format("✅ Element visible with XPath: %s (Timeout: %d sec | Polling: %d sec)", locator,
					maxTimeoutSeconds, pollingEverySeconds), true);
		} catch (TimeoutException e) {
			Reporter.log(String.format("❌ Timeout: Element not visible within %d sec for XPath: %s", maxTimeoutSeconds,
					locator), true);
		} catch (Exception e) {
			Reporter.log(String.format("❌ Fluent wait failed for XPath %s: %s", locator, e.getMessage()), true);
		}
	}

	/**
	 * Waits until the element becomes selected (useful for checkboxes/radio
	 * buttons).
	 */
	public void safeWaitForElementToBeSelected(String locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locator)));
			Reporter.log(String.format("✅ Element selected successfully with XPath: %s", locator), true);
		} catch (TimeoutException e) {
			Reporter.log(String.format("❌ Timeout: Element not selected within %d sec for XPath: %s", seconds, locator),
					true);
		} catch (Exception e) {
			Reporter.log(String.format("❌ Error while waiting for selection of XPath %s: %s", locator, e.getMessage()),
					true);
		}
	}

	/**
	 * Waits until the element becomes clickable.
	 */
	public void safeWaitForElementToBeClickable(String locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			Reporter.log(String.format("✅ Element clickable for XPath: %s (Waited %d sec)", locator, seconds), true);
		} catch (TimeoutException e) {
			Reporter.log(
					String.format("❌ Timeout: Element not clickable within %d sec for XPath: %s", seconds, locator),
					true);
		} catch (Exception e) {
			Reporter.log(String.format("❌ Error while waiting for clickable XPath %s: %s", locator, e.getMessage()),
					true);
		}
	}

	/**
	 * Waits until the element becomes visible.
	 */

	public void safeWaitForElementToBeVisible(String locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			Reporter.log(String.format("✅ Element is visible with XPath: %s", locator), true);
		} catch (TimeoutException e) {
			Reporter.log(String.format("❌ Timeout: Element not visible within %d sec for XPath: %s", seconds, locator),
					true);
		} catch (Exception e) {
			Reporter.log(String.format("❌ Error while waiting for visibility of XPath %s: %s", locator, e.getMessage()),
					true);
		}
	}

}
