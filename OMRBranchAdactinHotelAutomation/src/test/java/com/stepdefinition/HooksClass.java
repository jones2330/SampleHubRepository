package com.stepdefinition;

import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to perform Before and After Scenario Operations
 */
public class HooksClass extends BaseClass{
	@Before
	public void beforeClassMethod() throws IOException {
		browerLaunch(getPropertyFileValue("browser"));
		loadurl(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWait();
	}
	
	@After
	public void afterClassMethod(Scenario scen) {
		if (!scen.isFailed()) {
			scen.attach(screenShot(), "images/png", "Scenario Output Screenshot");
		}
		closeCurrentWindow();
	}
	
	
}
