package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends BaseClass {
	
	public BookingConfirmPage() {

	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement afterBookAHotelSuccessMsg;

	
	
	@FindBy(xpath="//input[@id='order_no']")
    private WebElement getOrderNo;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
    private WebElement linkBookedIt;
	
	public WebElement getAfterBookAHotelSuccessMsg() {
		return afterBookAHotelSuccessMsg;
	}

	
	public WebElement getLinkBookedIt() {
		return linkBookedIt;
	}
	
	public WebElement getGetOrderNo() {
		return getOrderNo;
	}
	
	
	public void BookingConfirm() {

		elementClick(getLinkBookedIt());
		
	}
	
	
	
}
