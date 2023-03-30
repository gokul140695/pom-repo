package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage() {

	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement afterSearchSuccessMsg;
	
	@FindBy(id="radiobutton_0")
    private WebElement btnSelectHotel;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	public WebElement getAfterSearchSuccessMsg() {
		return afterSearchSuccessMsg;
	}

	public WebElement getBtnSelectHotel() {
		return btnSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectHotel() {

		elementClick(getBtnSelectHotel());
		elementClick(getBtnContinue());
		
		
	}
	
}
