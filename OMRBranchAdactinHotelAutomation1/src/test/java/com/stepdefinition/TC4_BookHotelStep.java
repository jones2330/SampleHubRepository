package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotelStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	
	
	@Then("User should Book Hotel by entering all fields {string},{string} and {string}")
	public void user_should_book_hotel_by_entering_all_fields_and(String fName, String lName, String address, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(2);

		pom.getBookHotelPage().bookConfirmatinByEnteringAllFields(fName, lName, address, map.get("CreditCardNo"), map.get("CreditCardType"), map.get("Expirymonth"), map.get("ExpiryYear"), map.get("CVVNum"));
	}

	@Then("User should verify page navigate from Book A hotel to {string}")
	public void user_should_verify_page_navigate_from_book_a_hotel_to(String ExpBookingConfText) {
		Assert.assertEquals("Verify Booking Confirmation page text", pom.getBookingConfirmation().getBookConfirmText().getText(), ExpBookingConfText);
	}

	@Then("User should click Book Now without Entering any details")
	public void user_should_click_book_now_without_entering_any_details() {
		pom.getBookHotelPage().bookConfirmatinByWithoutEnteringAnyFields();
	}

	@Then("User should verify all Error Messages {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_all_error_messages_and(String firstNmMessage, String LastNmErrMsg, String AddrErrorMsg, String CardNoErrorMsg, 
			String CardTypeErrorMsg, String ExpiryErrorMsg, String CvvNoErrorMsg) {
		Assert.assertEquals("Verify First Name Error Message", pom.getBookHotelPage().getFstNmErrMsg().getText(), firstNmMessage);
		Assert.assertEquals("Verify Last Name Error Message", pom.getBookHotelPage().getLastNmErrMsg().getText(), LastNmErrMsg);
		Assert.assertEquals("Verify Billing Address Error Message", pom.getBookHotelPage().getAddrErrorMsg().getText(), AddrErrorMsg);
		Assert.assertEquals("Verify Card Number Error Message", pom.getBookHotelPage().getCardNoErrorMsg().getText(), CardNoErrorMsg);
		Assert.assertEquals("Verify Card Type Error Message", pom.getBookHotelPage().getCardTypeErrorMsg().getText(), CardTypeErrorMsg);
		Assert.assertEquals("Verify Card Expiry Error Message", pom.getBookHotelPage().getExpiryErrorMsg().getText(), ExpiryErrorMsg);
		Assert.assertEquals("Verify Card CVV Error Message", pom.getBookHotelPage().getCvvNoErrorMsg().getText(), CvvNoErrorMsg);
	}
}
