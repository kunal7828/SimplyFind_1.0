package common;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport3HYR {

	
	public  WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExtentReports extentReports= new ExtentReports();
		File file=new File("report.xml");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	//	extentReports
	//	.createTest("Screenshot Test 1", "This is for attaching the screenshot")
	//	.info("This is a info msg")
	//	.addScreenCaptureFromBase64String(base64Code);
		
	//	extentReports.flush();
		driver.quit();
	//	Desktop.getDesktop().browse(new File("report.html").toURI());
		
		

 	}
	
	
public void takeScreenshot(Method method) throws Exception { //method ka object banayege for printing name with screenshot
		
		System.out.println("Test Case Name------------->"+method.getName());
		Thread.sleep(3000);  //manage synchronization here other wise it will take blank picture
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver; //takesScreenshot object reference variable aur //driver ko typecast kiya
		File srcFile= takeScreenshot.getScreenshotAs(OutputType.FILE);
		File desFile= new File(method.getName()+".png");  //destination
		FileHandler.copy(srcFile, desFile); //file handler org openqa selenium io ki use karna hai
	}
	

}
