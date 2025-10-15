package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport2 {

	public static void main(String[] args) {
		ExtentTest extentTest;
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("ExtentReport.html");
	
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Automation Test Report");
		extentSparkReporter.config().setReportName("OrangeHRM report");
		
		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
		extentReports.setSystemInfo("ENV", "PROD");
		extentReports.setSystemInfo("SUITE", "Sanity");
		
		extentTest=extentReports.createTest("VerifyAdminFun.");
		
		
		extentTest.pass("Click on button");
		extentTest.warning("Taking to much time.");
		
		extentTest.log(Status.PASS, "Click on button");
		
		
		
	
		
		extentTest.pass("Click on button");
		extentTest.pass("Taking to much time.");
		
		extentTest=extentReports.createTest("VerifyLeaveFun.");
		extentTest.pass("Click on button");
		extentTest.fail("Taking to much time.");
		
		extentReports.flush();
		
		

	}

}
