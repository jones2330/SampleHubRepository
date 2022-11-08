package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the locators in Search Hotel Page
 */
public class SearchHotelPage extends BaseClass{
	@FindBy(id="location")
	private WebElement htlLocation;
	@FindBy(id="hotels")
	private WebElement htlName;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement nofRooms;
	@FindBy(id="datepick_in")
	private WebElement checkInDate;
	@FindBy(id="datepick_out")
	private WebElement checkOutDate;
	@FindBy(id="adult_room")
	private WebElement nofAdults;
	@FindBy(id="child_room")
	private WebElement nofChilds;
	@FindBy(id="Submit")
	private WebElement btnSearch;
	@FindBy(id="username_show")
	private WebElement sucessMsg;
	@FindBy(id="checkin_span")
	private WebElement checkInElement;
	@FindBy(id="checkout_span")
	private WebElement checkOutElement;
	@FindBy(id="location_span")
	private WebElement plsSlctLocation;
	
	
	
	
	public WebElement getPlsSlctLocation() {
		return plsSlctLocation;
	}

	public WebElement getCheckInElement() {
		return checkInElement;
	}

	public WebElement getCheckOutElement() {
		return checkOutElement;
	}

	public WebElement getSucessMsg() {
		return sucessMsg;
	}

	public WebElement getHtlLocation() {
		return htlLocation;
	}

	public WebElement getHtlName() {
		return htlName;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNofRooms() {
		return nofRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getNofAdults() {
		return nofAdults;
	}

	public WebElement getNofChilds() {
		return nofChilds;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void BookingHotelInfo(String loctext, String htltext,String roomText,
			String nosRmValue,String inDate,String outDate,String nosAdltValue,String nosChildvalue) {
		
		selectDropDownByVisibletext(getHtlLocation(), loctext);
		selectDropDownByVisibletext(getHtlName(), htltext);
		selectDropDownByVisibletext(getRoomType(),roomText);
		selectDropDownByVisibletext(getNofRooms(), nosRmValue);
		getCheckInDate().clear();
		sendkey(getCheckInDate(), inDate);
		getCheckOutDate().clear();
		sendkey(getCheckOutDate(), outDate);
		selectDropDownByVisibletext(getNofAdults(), nosAdltValue);
		selectDropDownByVisibletext(getNofChilds(), nosChildvalue);
		clickwebElement(getBtnSearch());
	}
	public void BookingHotelInfoWithMandatory(String loctext,
			String nosRmValue,String inDate,String outDate,String nosAdltValue) {
		
		selectDropDownByVisibletext(getHtlLocation(), loctext);
		selectDropDownByVisibletext(getNofRooms(), nosRmValue);
		getCheckInDate().clear();
		sendkey(getCheckInDate(), inDate);
		getCheckOutDate().clear();
		sendkey(getCheckOutDate(), outDate);
		selectDropDownByVisibletext(getNofAdults(), nosAdltValue);
		clickwebElement(getBtnSearch());
	}
	public void BookingHotelInfoWithoutSelectingInfo() {
		clickwebElement(getBtnSearch());
	}
	
	
	
	
	
	
	}
