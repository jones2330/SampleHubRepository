package com.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

public class Integration extends ReusableMethods{
	public static void main(String[] args) throws IOException, InterruptedException {
		String link = "https://adactinhotelapp.com/";
		System.out.println("Enter No of Bookings you have to Make : ");
		
		Integration integ = new Integration();
		
		int n = integ.getIntInputFromUser();
		
		integ.browerLaunch();
		integ.loadurl(link);
		integ.maximizeWindow();
		//-----------------------------ImplicitWait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//login once
		WebElement findElementById = integ.findElementById("username");
		integ.sendkey(findElementById, "Greens8767");
		WebElement findElementByName = integ.findElementByName("password");
		integ.sendkey(findElementByName, "QN8V3A");
		WebElement findElementById2 = integ.findElementById("login");
		integ.clickwebElement(findElementById2);
		
		//-------------------------Multiple Bookings
		for (int i = 1; i <=n; i++) {
		WebElement findElementById3 = integ.findElementById("location");
		String dataFromExcel = integ.getDataFromExcel("New", i, 0);
		integ.selectDropDownByVisibletext(findElementById3, dataFromExcel);
		WebElement findElementById4 = integ.findElementById("hotels");
		String dataFromExcel2 = integ.getDataFromExcel("New", i, 1);
		integ.selectDropDownByVisibletext(findElementById4, dataFromExcel2);
		//room_type
		WebElement findElementById5 = integ.findElementById("room_type");
		String dataFromExcel3 = integ.getDataFromExcel("New", i, 2);
		integ.selectDropDownByVisibletext(findElementById5, dataFromExcel3);
		//room_nos
		WebElement findElementById6 = integ.findElementById("room_nos");
		String dataFromExcel4 = integ.getDataFromExcel("New", i, 3);
		integ.selectDropDownByValue(findElementById6, dataFromExcel4);
		//Check in Date - datepick_in
		WebElement findElementById7 = integ.findElementById("datepick_in");
		String dataFromExcel5 = integ.getDataFromExcel("New", i, 4);
		findElementById7.clear();
		integ.sendkey(findElementById7, dataFromExcel5);
		//Check out Date - datepick_out
		WebElement findElementById8 = integ.findElementById("datepick_out");
		String dataFromExcel6 = integ.getDataFromExcel("New", i, 5);
		findElementById8.clear();
		integ.sendkey(findElementById8, dataFromExcel6);
		//Adult No. - adult_room
		WebElement findElementById9 = integ.findElementById("adult_room");
		String dataFromExcel7 = integ.getDataFromExcel("New", i, 6);
		integ.selectDropDownByValue(findElementById9, dataFromExcel7);
		//Childeren No. - child_room
		WebElement findElementById10 = integ.findElementById("child_room");
		String dataFromExcel8 = integ.getDataFromExcel("New", i, 7);
		integ.selectDropDownByValue(findElementById10, dataFromExcel8);
		//click Search button - Submit
		WebElement findElementById11 = integ.findElementById("Submit");
		integ.clickwebElement(findElementById11);
		//click radio_button - radiobutton_0
		WebElement findElementById12 = integ.findElementById("radiobutton_0");
		integ.clickwebElement(findElementById12);
		//continue to next page - continue
		WebElement findElementById13 = integ.findElementById("continue");
		integ.clickwebElement(findElementById13);
		//first Name - first_name
		WebElement findElementById14 = integ.findElementById("first_name");
		String dataFromExcel9 = integ.getDataFromExcel("New", i, 8);
		integ.sendkey(findElementById14, dataFromExcel9);
		//last Name - last_name
		WebElement findElementById15 = integ.findElementById("last_name");
		String dataFromExcel10 = integ.getDataFromExcel("New", i, 9);
		integ.sendkey(findElementById15, dataFromExcel10);
		//Billing Address - address
		WebElement findElementById16 = integ.findElementById("address");
		String dataFromExcel11 = integ.getDataFromExcel("New", i, 10);
		integ.sendkey(findElementById16, dataFromExcel11);
		//Card No - cc_num
		WebElement findElementById17 = integ.findElementById("cc_num");
		String dataFromExcel12 = integ.getDataFromExcel("New", i, 11);
		integ.sendkey(findElementById17, dataFromExcel12);
		//Card Type - cc_type
		WebElement findElementById18 = integ.findElementById("cc_type");
		String dataFromExcel13 = integ.getDataFromExcel("New", i, 12);
		integ.selectDropDownByVisibletext(findElementById18, dataFromExcel13);
		//Exp month - cc_exp_month
		WebElement findElementById19 = integ.findElementById("cc_exp_month");
		String dataFromExcel14 = integ.getDataFromExcel("New", i, 13);
		integ.selectDropDownByValue(findElementById19, dataFromExcel14);
		//Exp Year - cc_exp_year
		WebElement findElementById20 = integ.findElementById("cc_exp_year");
		String dataFromExcel15 = integ.getDataFromExcel("New", i, 14);
		integ.selectDropDownByVisibletext(findElementById20, dataFromExcel15);
		//CVV Num - cc_cvv
		WebElement findElementById21 = integ.findElementById("cc_cvv");
		String dataFromExcel16 = integ.getDataFromExcel("New", i, 15);
		integ.sendkey(findElementById21, dataFromExcel16);
		//Click Book Now - book_now
		WebElement findElementById22 = integ.findElementById("book_now");
		integ.clickwebElement(findElementById22);
		//Thread.sleep(5000);
		//get Order ID - order_no
		WebElement findElementById23 = integ.findElementById("order_no");
		String getEnteredValue = integ.getEnteredValue(findElementById23, "value");
		//Save orderID in File
		integ.enterValueInNewCell("New", i, 16, getEnteredValue);
		//Print for Reference
		System.out.println(getEnteredValue);
		//Thread.sleep(5000);
		//Again Next Tick - search_hotel
		WebElement findElementById24 = integ.findElementById("search_hotel");
		integ.clickwebElement(findElementById24);
		
		}
	}

}
