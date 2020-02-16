package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic.SeleniumClass;

public class ExtentReportListner extends SeleniumClass{
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	public static ExtentReports setUp() {
		String reportLocation= "./Reports/Extent_Report.html";
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report Location initialized....");
		report.start();
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Herokuapp");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		System.out.println("System info set in reports");
		return extent;
	}
	
	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {
		switch(teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Testcase is failed: ", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());
			
			try {
				extenttest.addScreenCaptureFromPath(getscreenshot());
			}catch(IOException e) {
				
			}
			if(driver != null) {
				driver.quit();
			}
			break;
			
		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Testcase is passed: ", ExtentColor.GREEN));
			break;
			
		default: 
			break;
		}
	}
		

}
