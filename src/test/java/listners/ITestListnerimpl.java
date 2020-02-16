package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListnerimpl extends ExtentReportListner implements ITestListener{
	
	private static ExtentReports extent;

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Execution Finished on UAT");
		extent.flush();
		System.out.println("Report Generated...");
	}

	@Override
	public void onStart(ITestContext arg0) {
	System.out.println("Execution Started on UAT");
		extent = setUp();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
	
		System.out.println("FAILED");
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		System.out.println("SKIPPED");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("PASS");
		
	}

}
