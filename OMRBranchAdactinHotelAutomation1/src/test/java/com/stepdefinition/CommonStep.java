package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the Common Methods
 */
public class CommonStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify Login Successful Message {string}")
	public void user_should_verify_login_successful_message(String string) {
		
		Assert.assertEquals("verify Succesful login Message", getEnteredValue(pom.getSearchHotelPage().getSucessMsg(), "value"),string);
	}
	
}
