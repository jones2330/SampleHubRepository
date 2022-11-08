package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the locators in Booking Confirmation Page
 */
public class BookingConfirmation extends BaseClass{
	@FindBy(id="order_no")
	private WebElement OrderId;
	@FindBy(xpath = "//td[contains(text(),'Booking Confirmation ')]")
	private WebElement bookConfirmText;
	

	public WebElement getBookConfirmText() {
		return bookConfirmText;
	}

	public WebElement getOrderId() {
		return OrderId;
	}
	
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}
	
	public String getBookedOrderID() {
		String data = getEnteredValue(getOrderId(),"value");
		return data;
		
	}
	
	
}
