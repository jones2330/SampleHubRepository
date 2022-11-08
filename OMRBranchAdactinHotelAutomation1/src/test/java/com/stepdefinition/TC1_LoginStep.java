package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to perform Login with different scenarios
 */
public class TC1_LoginStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on Adactin Login Page")
	public void user_is_on_adactin_login_page() throws FileNotFoundException, IOException {
		
	}

	@When("User should perform Login {string},{string}")
	public void user_should_perform_login(String userName, String passWord) throws FileNotFoundException, IOException {
		//pom.getLoginPage().LoginMethod(getPropertyFileValue("username"), getPropertyFileValue("password"));
		pom.getLoginPage().LoginMethod(userName,passWord);
	}
	@When("User should perform Login {string},{string} with Enter Key")
	public void user_should_perform_login_with_enter_key(String userName, String passWord) throws AWTException {
		pom.getLoginPage().LoginByEnterKey(userName, passWord);
	}

	@Then("User should verify Login Unsuccessful Message {string}")
	public void user_should_verify_login_unsuccessful_message(String expMsg) {
		Assert.assertTrue("verify Error message",getWebElementText(pom.getLoginPage().getErrorMesgLgn()).contains(expMsg));
	}
	
}
