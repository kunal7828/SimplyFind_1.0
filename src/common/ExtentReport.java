package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("ExtentReport.html");
		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
        // Add some system information to the report
		
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("Tester", "Your Name");
		
		
		ExtentTest extentTest=extentReports.createTest("FirstTestCase");
		
		extentTest.pass("Click On Button");
		extentTest.pass("Validate successfullly.");
		
		extentReports.flush();


	}

}
