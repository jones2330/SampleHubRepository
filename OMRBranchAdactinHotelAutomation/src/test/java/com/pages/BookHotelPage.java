package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the locators in Book Hotel Page
 */
public class BookHotelPage extends BaseClass{
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@FindBy(id="address")
	private WebElement addressBillg;
	@FindBy(id="cc_num")
	private WebElement cardNum;
	@FindBy(id="cc_type")
	private WebElement cardType;
	@FindBy(id="cc_exp_month")
	private WebElement expMonth;
	@FindBy(id="cc_exp_year")
	private WebElement expYear;
	@FindBy(id="cc_cvv")
	private WebElement cardCvv;
	@FindBy(id="book_now")
	private WebElement btnBook;
	@FindBy(xpath = "(//td[@class='login_title'])[2]")
	private WebElement bookHtlpg;
	@FindBy(id = "first_name_span")
	private WebElement fstNmErrMsg;
	@FindBy(id = "last_name_span")
	private WebElement lastNmErrMsg;
	@FindBy(id = "address_span")
	private WebElement addrErrorMsg;
	@FindBy(id = "cc_num_span")
	private WebElement cardNoErrorMsg;
	@FindBy(id = "cc_type_span")
	private WebElement cardTypeErrorMsg;
	@FindBy(id = "cc_expiry_span")
	private WebElement expiryErrorMsg;
	@FindBy(id = "cc_cvv_span")
	private WebElement cvvNoErrorMsg;
	
	
	
	
	
	
	
	public WebElement getFstNmErrMsg() {
		return fstNmErrMsg;
	}
	public WebElement getLastNmErrMsg() {
		return lastNmErrMsg;
	}
	public WebElement getAddrErrorMsg() {
		return addrErrorMsg;
	}
	public WebElement getCardNoErrorMsg() {
		return cardNoErrorMsg;
	}
	public WebElement getCardTypeErrorMsg() {
		return cardTypeErrorMsg;
	}
	public WebElement getExpiryErrorMsg() {
		return expiryErrorMsg;
	}
	public WebElement getCvvNoErrorMsg() {
		return cvvNoErrorMsg;
	}
	public WebElement getBookHtlpg() {
		return bookHtlpg;
	}
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getAddressBillg() {
		return addressBillg;
	}
	public WebElement getCardNum() {
		return cardNum;
	}
	public WebElement getCardType() {
		return cardType;
	}
	public WebElement getExpMonth() {
		return expMonth;
	}
	public WebElement getExpYear() {
		return expYear;
	}
	public WebElement getCardCvv() {
		return cardCvv;
	}
	public WebElement getBtnBook() {
		return btnBook;
	}
	

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	public void bookConfirmatinByEnteringAllFields(String fstName,String lstName,String adDress,
			String crdNum,String crdTypetext,String expMonvalue,String expYrtext,String cvvNo) {
		sendkey(getTxtFirstName(), fstName);
		sendkey(getTxtLastName(), lstName);
		sendkey(getAddressBillg(), adDress);
		sendkey(getCardNum(), crdNum);
		selectDropDownByVisibletext(getCardType(), crdTypetext);
		selectDropDownByVisibletext(getExpMonth(), expMonvalue);
		selectDropDownByVisibletext(getExpYear(), expYrtext);
		sendkey(getCardCvv(), cvvNo);
		clickwebElement(getBtnBook());
	}
	public void bookConfirmatinByWithoutEnteringAnyFields() {
		clickwebElement(getBtnBook());
	}
}
