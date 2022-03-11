package automation.cucumber.testrunner;

import org.testng.annotations.AfterClass;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.cucumber.listener.*;

@CucumberOptions(features = {"classpath:features"},
glue = {"automation/cucumber/stepdefinitions"},
plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",},
tags= {"@smoke"}, monochrome = true, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void writeExtentReport() {
		String str = System.getProperty("user.dir");    
	    String filepath=str+"/src/test/resources/configs/extent-config.xml";
		Reporter.loadXMLConfig(filepath);
	}

}
