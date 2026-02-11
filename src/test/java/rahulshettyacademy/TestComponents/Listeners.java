package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	//Thread Safe
	ThreadLocal <ExtentTest>extentTest= new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		//Assign Unique thread Id (Error Validation) Test 
		extentTest.set(test);;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
	    // Screenshot, Attach to report
		extentTest.get().fail(result.getThrowable());

	    try {
	        // Get the driver from the test class
	        driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	        
	        // Capture screenshot - THIS SHOULD BE HERE, NOT IN CATCH BLOCK
	        String filePath = getScreenShot(result.getMethod().getMethodName(), driver);
	        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	        
	    } catch (Exception e) {
	    	System.err.println("Failed to capture screenshot: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
