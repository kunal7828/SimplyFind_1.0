package pages;

public class recycle {
	/*
	 * boolean flag=
	 * driver.findElement(By.xpath("//h6[text()='Time']")).isDisplayed();
	 * System.out.println("Time page is visible-->"+flag);
	 * 
	 * 
	 * 
	 * boolean dashboardFlag =
	 * driver.findElement(By.xpath(dashboardPage)).isDisplayed();
	 * Thread.sleep(3000); if (dashboardFlag) {
	 * System.out.println("Admin dashboard element and logged in successfully");
	 * }else {
	 * System.out.println("Admin dashboard element and not logged in successfully");
	 * }
	 * 
	 * 
	 * 
	 * 
	 * String headerGetText =
	 * driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText(); Boolean
	 * headerFlag =
	 * driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	 * 
	 * System.out.println("Dashobard Page Displayed Successfully. ------> " +
	 * headerGetText);
	 * System.out.println("Dashobard Page Displayed Successfully. ------>" +
	 * headerFlag); String currentPageUrl = driver.getCurrentUrl();
	 * System.out.println("URL: " + currentPageUrl); // Get the page title and print
	 * it String pageTitle = driver.getTitle(); System.out.println("Page Title: " +
	 * pageTitle);
	 * 
	 * 
	 * public void safeClick(String xpathLocator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    try {
        safeScroll(xpathLocator, "into-view"); // <-- scroll before clicking
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
        element.click();
        Reporter.log(String.format("✅ Successfully clicked element with XPath: %s", xpathLocator), true);
    } catch (Exception e) {
        Reporter.log(String.format("❌ Error clicking element with XPath: %s - %s", xpathLocator, e.getMessage()), true);
    }
}



public void safeScrollBy(int x, int y) {
    try {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        Reporter.log(String.format("✅ Scrolled by x:%d, y:%d pixels.", x, y), true);
    } catch (JavascriptException e) {
        Reporter.log(String.format("⚠️ JavaScript execution failed while scrolling by coordinates. Error: %s", e.getMessage()), true);
    } catch (Exception e) {
        Reporter.log(String.format("❌ Unexpected error while scrolling by coordinates. Error: %s", e.getMessage()), true);
    }
}


safeScroll("//button[@id='submit']", "into-view");
safeScroll("", "to-top");
safeScroll("", "to-bottom");
safeScrollBy(0, 500); // scrolls 500px down
	 * 
	 * 
	 * 
	 */
}
