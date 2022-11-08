package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should select the Hotel Name and click Continue")
	public void user_should_select_the_hotel_name_and_click_continue() {
		pom.getSelectHotelPage().selectAndSearchHotel();
	}

	@Then("User should verify page navigate from Select Hotel to {string}")
	public void user_should_verify_page_navigate_from_select_hotel_to(String bookAhtl) {
		Assert.assertEquals("Verify Page moves to Book A Hotel", pom.getBookHotelPage().getBookHtlpg().getText(), bookAhtl);
	}

	@Then("User should click Continue without Selecting Hotel")
	public void user_should_click_continue_without_selecting_hotel() {
		pom.getSelectHotelPage().searchHotelWithoutSelect();
	}
	@Then("User should verify the Error Message in Search Hotel page {string}")
	public void user_should_verify_the_error_message_in_search_hotel_page(String plsSlctHtl) {
		Assert.assertEquals("Verify Please Select Hotel Msg", pom.getSelectHotelPage().getPlsSlctHtlMsg().getText(), plsSlctHtl);
	}
}
