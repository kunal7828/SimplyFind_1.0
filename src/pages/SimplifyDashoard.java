package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.BaseSetup;

public class SimplifyDashoard {
	
	WebDriver driver;
	public SimplifyDashoard(WebDriver driver) {
		this.driver=driver;
	}
	
	String dashboardLocator="//h5[text()='Properties']";
	

   public void validateDashboardVisibility() {
        BaseSetup.infoLog("Checking if Dashboard is visible...");
        try {
            if (driver.findElement(By.xpath(dashboardLocator)).isDisplayed()) {
                BaseSetup.passLog("✅ Home page is visible.");
            } else {
                BaseSetup.failLog("❌ Home page is not visible.");
            }
        } catch (Exception e) {
            BaseSetup.failLog("❌ Error while validating Dashboard visibility: " + e.getMessage());
        }
    }
}
