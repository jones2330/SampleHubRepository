package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author Jones
 * @date 23-08-2022
 * @description Used to maintain the locators in Login Page
 */
public class LoginPage extends BaseClass {
	@FindBy(id="username")
	private WebElement txtUserName;
	@FindBy(id="password")
	private WebElement txtPassword;
	@FindBy(id="login")
	private WebElement btnLogin;
	@FindBy(xpath="//div[@class='auth_error']")
	private WebElement errorMesgLgn;
	
	
	public WebElement getErrorMesgLgn() {
		return errorMesgLgn;
	}
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void LoginMethod(String userName, String pass) {
		sendkey(getTxtUserName(), userName);
		sendkey(getTxtPassword(), pass);
		clickwebElement(getBtnLogin());
	}
	public void LoginByEnterKey(String userName, String pass) throws AWTException {
		sendkey(getTxtUserName(), userName);
		sendkey(getTxtPassword(), pass);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
