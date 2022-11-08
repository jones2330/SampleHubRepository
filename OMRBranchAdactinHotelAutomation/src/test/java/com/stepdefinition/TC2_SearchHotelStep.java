package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to search Hotel with different Scenarios
 */
public class TC2_SearchHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should Search hotel by selecting {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_by_selecting_and(String Location, String Hotels, String RoomType, String NumberofRooms, String CheckInDate, String CheckOutDate, String AdultsperRoom, String ChildrenperRoom) {
		pom.getSearchHotelPage().BookingHotelInfo(Location, Hotels, RoomType, NumberofRooms, CheckInDate, CheckOutDate, AdultsperRoom, ChildrenperRoom);
	}

	@Then("User should verify page navigate from Search Hotel to {string}")
	public void user_should_verify_page_navigate_from_search_hotel_to(String sltHotelMsg) {
		Assert.assertEquals("Verify Success to Select Hotel",pom.getSelectHotelPage().getSuccSearchHtl().getText(),sltHotelMsg);
	}

	@Then("User should Search hotel by selecting only Mandatory fields {string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_by_selecting_only_mandatory_fields_and(String Location, String NumberofRooms, String CheckInDate, String CheckOutDate, String AdultsperRoom) {
		pom.getSearchHotelPage().BookingHotelInfoWithMandatory(Location, NumberofRooms, CheckInDate, CheckOutDate, AdultsperRoom);
	}

	@Then("User should verify the Error Message {string} and {string}")
	public void user_should_verify_the_error_message_and(String chekInMsg, String chekOutMsg) {
		Assert.assertEquals("Verify Error Message CheckIn",pom.getSearchHotelPage().getCheckInElement().getText(), chekInMsg);
		Assert.assertEquals("Verify Error Message CheckIn",pom.getSearchHotelPage().getCheckOutElement().getText(), chekOutMsg);
	}

	@Then("User should Search hotel without selecting hotel information")
	public void user_should_search_hotel_without_selecting_hotel_information() {
		pom.getSearchHotelPage().BookingHotelInfoWithoutSelectingInfo();
	}

	@Then("User should verify the Error Message {string}")
	public void user_should_verify_the_error_message(String plsSltLocation) {
		Assert.assertEquals("Verify Plese Select Hotel Warning", pom.getSearchHotelPage().getPlsSlctLocation().getText(), plsSltLocation);
	}
	
}
