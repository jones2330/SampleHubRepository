package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to Cancel the Booking through different scenarios
 */
public class TC5_CancelBookingStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	
	
	@Then("User should Cancel Booking with current orderID")
	public void user_should_cancel_booking_with_current_order_id() {
		String orderId = getEnteredValue(pom.getBookingConfirmation().getOrderId(), "value");
		pom.getCancelBookingPage().cancelCurrentBooking(orderId);
	}

	@Then("User should verify Cancel Success Message {string}")
	public void user_should_verify_cancel_success_message(String expBookingCanceledMsg) {
		Assert.assertEquals("Verify Cancelled Successfully", pom.getCancelBookingPage().getBookingCanceledMsg().getText(), expBookingCanceledMsg);
	}

	@Then("User should Cancel Booking with existing orderID {string}")
	public void user_should_cancel_booking_with_existing_order_id(String exsOrderId) {
		pom.getCancelBookingPage().cancelCurrentBooking(exsOrderId);
	}
}
