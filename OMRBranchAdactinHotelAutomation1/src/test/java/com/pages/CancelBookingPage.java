package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the locators in Cancel Booking Page
 */
public class CancelBookingPage extends BaseClass{
	@FindBy(xpath="//a[@href='BookedItinerary.php']")
	private WebElement allBookedId;
	@FindBy(id="order_id_text")
	private WebElement orderIdToCanl;
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;
	@FindBy(name="ids[]")
	private WebElement checkBoxCan;
	@FindBy(xpath="(//input[@style='width:150px;'])[1]")
	private WebElement btnCanlSlt;
	@FindBy(id = "search_result_error")
	private WebElement bookingCanceledMsg;
	
	public WebElement getBookingCanceledMsg() {
		return bookingCanceledMsg;
	}
	public WebElement getAllBookedId() {
		return allBookedId;
	}
	public WebElement getOrderIdToCanl() {
		return orderIdToCanl;
	}
	public WebElement getBtnGo() {
		return btnGo;
	}
	public WebElement getCheckBoxCan() {
		return checkBoxCan;
	}
	public WebElement getBtnCanlSlt() {
		return btnCanlSlt;
	}
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	public void cancelCurrentBooking(String idToBeCancelled) {
		clickwebElement(getAllBookedId());
		sendkey(getOrderIdToCanl(), idToBeCancelled);
		clickwebElement(getBtnGo());
		clickwebElement(getCheckBoxCan());
		clickwebElement(getBtnCanlSlt());
		alertAccept();
		System.out.println("Cancelled Order ID: "+idToBeCancelled);
	}
	

}
