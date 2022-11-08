package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * 
 * @author Jones
 * @date 23-08-2022
 * description Used to Integrate all the Classes
 */

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true, dryRun = false,features = "src\\test\\resources\\Features\\", glue = "com.stepdefinition", monochrome = true,
plugin = {"pretty","json:target//output.json"})


public class TestRunnerClass extends BaseClass{
	
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(System.getProperty("user.dir")+"\\target\\output.json");
	}
}
