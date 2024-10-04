package tealium.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import tealium.ExtendReports.ExtendReport;

public class Listener implements ITestListener{

	
	ExtentTest test;
	ExtentReports  report;
	
	@Override
    public void onStart(ITestContext context) {
        // Initialize the report before any tests start
		 report = ExtendReport.reports();
		
    }
	
	 @Override
	    public void onTestStart(ITestResult result) {
	        // Log the start of the test
		 test=  report.createTest(result.getMethod().getMethodName());
		 System.out.println("Test started: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Log the successful test result
	    	test.pass("test Passed");
	    	System.out.println("Test onTestSuccess: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Log the failure and capture the exception if needed
	    	System.out.println("Test onTestFailure: " + result.getName());
	    	test.fail("test fail"+result.getThrowable().getMessage());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Log the skipped test result
	    	System.out.println("Test onTestSkipped: " + result.getName());
	    	test.skip("test skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Finalize the report when all tests are finished
	    	report.flush();
	    	
	    }

}
