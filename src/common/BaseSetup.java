package common;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSetup {

    public static WebDriver driver;
    private ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static Logger log = LogManager.getLogger(BaseSetup.class);

    @BeforeSuite
    public void openBrowserWithLogin() throws Exception {
        log.info("Launching Chrome browser...");

        // --- Chrome Options setup ---
        ChromeOptions options = new ChromeOptions();

        // Disable browser notifications and popups
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill-keyboard-accessory-view");

        // Remove “Chrome is being controlled by automated test software” message
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Disable password manager completely
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        
        
      //  ChromeOptions options = new ChromeOptions();   duplicate code
   //     Map<String, Object> prefs = new HashMap<>(); duplicate code
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);   
        
        // Initialize ChromeDriver
        driver = new ChromeDriver(options);
        log.info("Chrome browser launched successfully.");

        // Open the URL
        driver.get("https://iris2-qa-c5fpfmf3dzcaafds.z01.azurefd.net/simplyfind/#/phi/login");
   //     driver.manage().window().maximize();
        Thread.sleep(5000);

        // --- Setup Extent Reports ---
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extentSparkReporter.config().setTheme(Theme.DARK); //STANDARD OR DARK
        extentSparkReporter.config().setDocumentTitle("Automation Test Report");
        extentSparkReporter.config().setReportName("IRIS2 QA Sanity Report");
        extentSparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "Kunal Sharma");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Suite", "Sanity");
        extentReports.setSystemInfo("Browser", "Chrome");
        
        
        
 
        
        
        
        

        // --- Perform Login ---
        try {
            LoginPage loginPage = new LoginPage(driver);
            String username = ExcelUtility.getCellValue("Login", 1, 0);
            String password = ExcelUtility.getCellValue("Login", 1, 1);

            loginPage.enterUsername(username);
            Thread.sleep(2000);
            
            loginPage.enterPassword(password);
            Thread.sleep(2000);
            
            loginPage.clickOnLogin();
            Thread.sleep(2000);
            
            log.info("Login successful with username: " + username);

        } catch (Exception e) {
            log.error("Login failed! Check Excel file or locators.", e);
            throw e;
        }

        
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); try {
		 * wait.until(ExpectedConditions.alertIsPresent());
		 * driver.switchTo().alert().accept(); } catch (TimeoutException e) {
		 * log.info("No alert appeared."); }
		 * 
		 */      
        

       
/*------------------------------------------------
  
         // Wait for the popup to appear
      //  Thread.sleep(2000); // adjust according to popup timing
        
        // Create Robot instance
        Robot robot = new Robot();

        // Press Enter key (usually "OK" button is default)
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Optional: small delay after pressing
        Thread.sleep(500);

        System.out.println("OK clicked using Robot!");
------------------------------------------------*/
        
       
        // --- Handle Alert if present ---
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            log.info("Alert handled successfully.");
        } catch (Exception e) {
            log.warn("No alert present after login.");
        }

        Thread.sleep(3000);
    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println("Running Test Case: " + method.getName());
        extentTest = extentReports.createTest(method.getName());
    }

    @AfterSuite
    public void closeBrowser() {
        try {
            if (extentReports != null) {
                extentReports.flush();
                log.info("Extent Report generated successfully.");
            }
            if (driver != null) {
        //       driver.quit();
                log.info("Browser closed successfully.");
            }
        } catch (Exception e) {
            log.error("Error while closing browser/report.", e);
        }
    }

    // ---------- Logging Helpers ----------
    public static void passLog(String steps) {
        extentTest.log(Status.PASS, steps);
        log.info(steps);
    }

    public static void failLog(String steps) {
        extentTest.log(Status.FAIL, steps);
        log.error(steps);
    }

    public static void skipLog(String steps) {
        extentTest.log(Status.SKIP, steps);
        log.warn(steps);
    }

    public static void warningLog(String steps) {
        extentTest.log(Status.WARNING, steps);
        log.warn(steps);
    }

    public static void infoLog(String steps) {
        extentTest.log(Status.INFO, steps);
        log.info(steps);
    }

    public static void setDes(String des) {
        extentTest.getModel().setDescription(des);
        log.info(des);
    }
}
