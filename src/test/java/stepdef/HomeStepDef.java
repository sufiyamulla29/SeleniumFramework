package stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import generic.SeleniumClass;
import listners.ExtentReportListner;
import pageobject.HomePage;

public class HomeStepDef extends ExtentReportListner{
	
	HomePage hp = new HomePage();
	@Given("^\"([^\"]*)\" browser is selected$")
	public void browser_is_selected(String arg1) throws Throwable {
	    ExtentTest logInfo = null;
	    try {
	    	test = extent.createTest(Feature.class, "to automate the internet herokuapp");
	    	test=test.createNode(Scenario.class, "to verify links present on homepage");
	    	logInfo = test.createNode(new GherkinKeyword("Given"), "browser_is_selected");  
	    	hp.launchBrowser(arg1);
	    	
	    	logInfo.pass("Opened Chrome browser");
	    	
	    }catch(AssertionError | Exception e) {
	    	testStepHandle("FAIL", SeleniumClass.driver, logInfo, e);
	    }
	    
	}

	@Then("^launch url \"([^\"]*)\"$")
	public void launch_url(String arg1) throws Throwable {
		ExtentTest logInfo = null;
	    try {
	    	
	    	logInfo = test.createNode(new GherkinKeyword("Then"), "launch_url");  
	    	hp.launchApplication(arg1);
	    	
	    	logInfo.pass("Launched application");
	    	
	    }catch(AssertionError | Exception e) {
	    	testStepHandle("FAIL", SeleniumClass.driver, logInfo, e);
	    }
	    
		
	}

	@Then("^verify page by url \"([^\"]*)\"$")
	public void verify_page_by_url(String arg1) throws Throwable {
		ExtentTest logInfo = null;
	    try {
	    	
	    	logInfo = test.createNode(new GherkinKeyword("Then"), "verify page by url");  
	    	hp.verifyPageByURL(arg1);
	    	
	    	logInfo.pass("Page of URL is verified");
	    	
	    }catch(AssertionError | Exception e) {
	    	testStepHandle("FAIL", SeleniumClass.driver, logInfo, e);
	    }
		
	}

	@Then("^click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
		ExtentTest logInfo = null;
	    try {
	    	
	    	logInfo = test.createNode(new GherkinKeyword("Then"), "click_on_Link");  
	    	hp.clickLink(arg1);
	    	
	    	logInfo.pass("Clicked on link and navigated to page");
	    	
	    }catch(AssertionError | Exception e) {
	    	testStepHandle("FAIL", SeleniumClass.driver, logInfo, e);
	    }
		
	}

	@Then("^navigate back to home page$")
	public void navigate_back_to_home_page() throws Throwable {
		ExtentTest logInfo = null;
	    try {
	    	
	    	logInfo = test.createNode(new GherkinKeyword("Then"), "navigate_back_to_home_page");  
	    	hp.navigateBack();
	    	
	    	logInfo.pass("Navigated back to home page");
	    	
	    	
	    }catch(AssertionError | Exception e) {
	    	testStepHandle("FAIL", SeleniumClass.driver, logInfo, e);
	    }
		
	}



}
