package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.SafeAction;

import java.time.Duration;
import java.util.Map;
 
public class LenearFlow extends SafeAction{
	
	    WebDriver driver;
	    WebDriverWait wait;
	
	    String quickSearchLinkLoc = "//h6[text()='Quick Search ']";
		String fullPostcodeInputLoc = "//label[text()='Property Type']//preceding::input[1]";
		String valueSelectLoc = "//label[text()='Full Postcode']//following::a[1]";
		String searchButtonLoc = "//a[text()='Search']";

		String propertyTypeDropdownLoc = "//label[text()='Property Type']//following::span[1]";
	    
	    String bedsddLoc="//label[text()='Beds ']//following::button[1]";
	    String bedsddListLoc="//label[text()='Radius']//following::li[2]";

	    String yieldInputFieldLoc="//label[text()='Yield ']//following::input[1]";
 
    @BeforeMethod
    public void setUp() {
      //  io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
 
        // ✅ Disable notifications & password manager
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));
 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
 
    @Test(priority=1)
    public void login() throws Exception {
        driver.get("https://iris2-qa-c5fpfmf3dzcaafds.z01.azurefd.net/simplyfind/#/phi/login");
 
        // --- Login ---
        By userInput = By.xpath("//input[@placeholder='Enter User id']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(userInput)).sendKeys("kunal@simplyphi.co.uk");
 
        By passInput = By.id("inp_login_pass");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passInput)).sendKeys("Admin@123");
 
        By loginBtn = By.xpath("//button[normalize-space()='Login']");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    
        // --- Optional Popup Handling ---
        By okBtn = By.xpath("//button[contains(normalize-space(.),'OK')]");
        try {
            if (!driver.findElements(okBtn).isEmpty()) {
                WebElement okElement = wait.until(ExpectedConditions.elementToBeClickable(okBtn));
                okElement.click();
                System.out.println("✅ Popup handled successfully.");
            } else {
                System.out.println("ℹ️ No popup appeared.");
            }
        } catch (Exception e) {
            System.out.println("❌ Popup handling failed: " + e.getMessage());
        }
 
     
     //   driver.findElement(By.xpath("//a[normalize-space()='Search']")).click();
        Thread.sleep(5000);
    }
 
    
    
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
       //    driver.quit();
        }
    }
}
 