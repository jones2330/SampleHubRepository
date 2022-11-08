package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmation;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to create the object for the POJO classes as Singleton
 */
public class PageObjectManager {
	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmation bookingConfirmation;
	private CancelBookingPage cancelBookingPage;
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage=new LoginPage():loginPage;
	}
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage==null)? searchHotelPage = new SearchHotelPage() :searchHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)? selectHotelPage=new SelectHotelPage():selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)?bookHotelPage=new BookHotelPage():bookHotelPage;
	}
	public BookingConfirmation getBookingConfirmation() {
		return (bookingConfirmation==null)?bookingConfirmation=new BookingConfirmation():bookingConfirmation;
	}
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage==null)?cancelBookingPage=new CancelBookingPage():cancelBookingPage;
	}
	
}
