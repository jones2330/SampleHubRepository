package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the locators in Select Hotel Page
 */
public class SelectHotelPage extends BaseClass {
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement succSearchHtl;
	@FindBy(id="radiobutton_span")
	private WebElement plsSlctHtlMsg;
	
	
	
	public WebElement getPlsSlctHtlMsg() {
		return plsSlctHtlMsg;
	}
	public WebElement getSuccSearchHtl() {
		return succSearchHtl;
	}
	public WebElement getBtnRadio() {
		return btnRadio;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	public void selectAndSearchHotel() {
		clickwebElement(getBtnRadio());
		clickwebElement(getBtnContinue());
	}
	public void searchHotelWithoutSelect() {
		clickwebElement(getBtnContinue());
	}
	
	
	/*driver.findElement(By.id("radiobutton_1")).click();
	driver.findElement(By.id("continue")).click();*/
}
