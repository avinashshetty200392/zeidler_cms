package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import com.cucumber.listener.Reporter;

import stepdefinitions.UploadImage;
import utility.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
				 glue = {"stepdefinitions"},
				 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				 dryRun=false)


public class TestRunner {
	@AfterClass
	public static void setup() {
       CommonMethods.getReportConfigPath();
	 }
	}
