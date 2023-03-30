package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass {
	
	public CancelBookingPage() {

	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id="order_id_text")
    private WebElement txtOrderNo;
	
	@FindBy(id="search_hotel_id")
    private WebElement btnGo;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCancelOrderId;

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancelOrderId() {
		return btnCancelOrderId;
	}
	
	public void CancelBooking(String orderNo) {

		elementSendkeys(getTxtOrderNo(), orderNo);
		elementClick(getBtnGo());
		elementClick(getBtnCancelOrderId());
		acceptInAlert();
	}


}
