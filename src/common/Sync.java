package common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sync {

	public static WebDriver driver;

	public Sync() {

		this.driver = BaseSetup.driver;
		System.out.println("Sync driver value--->" + this.driver);

	}

	public void needToWait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void safeImplicitWait(int second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}

	public void safeExplicitWait(String locator, int second) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));

	}

	public void safeFluentWait(String locator, int maxtimeOutSecond, int pollingEverySecond) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(maxtimeOutSecond))
				.pollingEvery(Duration.ofSeconds(pollingEverySecond)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	// Wait for an element to be selected
	public void waitForElementToBeSelected(String locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locator)));
	}

	// Wait for element to be clickable
	public void waitForElementToBeClickable(String locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

}
