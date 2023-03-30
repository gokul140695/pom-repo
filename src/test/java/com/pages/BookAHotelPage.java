package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotelPage extends BaseClass{

	public BookAHotelPage() {

	PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="(//td[@class='login_title'])[2]")
	private WebElement afterSelectHotelSuccessMsg;
	
	public WebElement getAfterSelectHotelSuccessMsg() {
		return afterSelectHotelSuccessMsg;
	}

	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCreditCardNo;
	
	@FindBy(id="cc_type")
	private WebElement dDnCreditCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDnMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDnYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvvNo;
	
	@FindBy(id="book_now")
	private WebElement btnBookNow;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getdDnCreditCardType() {
		return dDnCreditCardType;
	}

	public WebElement getdDnMonth() {
		return dDnMonth;
	}

	public WebElement getdDnYear() {
		return dDnYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	
	
	public void BookAHotel(String firstName,String lastName,String address,String creditCardNo,String creditCardType,String Month,String Year,String CvvNo) {

		elementSendkeys(getTxtFirstName(), firstName);
		elementSendkeys(getTxtLastName(), lastName);
		elementSendkeys(getTxtAddress(), address);
		elementSendkeys(getTxtCreditCardNo(), creditCardNo);
		selectOptionByText(getdDnCreditCardType(), creditCardType);
		selectOptionByText(getdDnMonth(), Month);
		selectOptionByText(getdDnYear(), Year);
		elementSendkeys(getTxtCvvNo(), CvvNo);
		elementClick(getBtnBookNow());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
