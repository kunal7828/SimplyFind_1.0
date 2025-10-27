package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.sql.Date;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class ExtentReport4 {

	public WebDriver driver;
public ExtentReports extent;
public ExtentTest logger;
	
	
	
	@BeforeTest
	public void setExtent() {
		// TODO Auto-generated method stub
				ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("ExtentReport.html");
				ExtentReports extentReports=new ExtentReports();
				extentReports.attachReporter(extentSparkReporter);
				
		        // Add some system information to the report
				
				extentReports.setSystemInfo("Environment", "QA");
				extentReports.setSystemInfo("Tester", "Your Name");
			
		
	}

	@Test
	public  void TitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "SimplyPhi");
		System.out.println("Tilte------>" + title);
		
		

	}
	
	


	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://iris2-qa-c5fpfmf3dzcaafds.z01.azurefd.net/simplyfind/#/phi/login");

	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
		extent.flush();

	}

}
