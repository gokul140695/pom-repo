package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass{
	
	public SearchHotelPage() {

	PageFactory.initElements(driver, this);
	
	}

	@FindBy(id="username_show")
	private WebElement verifySuccessMsg;
	
	@FindBy(id="location")
	private WebElement dDnLocation;
	
	@FindBy(id="hotels")
	private WebElement dDnHotels;
	
	@FindBy(id="room_type")
	private WebElement dDnRoomType;
	
	@FindBy(id="room_nos")
	private WebElement dDnNoOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement txtCheckInDate;
	
	@FindBy(id="datepick_out")
	private WebElement txtCheckOutDate;
	
	@FindBy(id="adult_room")
	private WebElement dDnAdultsRoom;
	
	@FindBy(id="child_room")
	private WebElement dDnChildRoom;
	
	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	public WebElement getVerifySuccessMsg() {
		return verifySuccessMsg;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnNoOfRooms() {
		return dDnNoOfRooms;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultsRoom() {
		return dDnAdultsRoom;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public void searchHotels(String location,String hotels,String roomType,String noOfRooms,String checkInDate,String checkInOutDate,String AdultsPerRoom,String chilPerRoom) {

		selectOptionByText(getdDnLocation(), location);
		selectOptionByText(getdDnHotels(), hotels);
	    selectOptionByText(getdDnRoomType(), roomType);
	    selectOptionByText(getdDnNoOfRooms(), noOfRooms);
	    elementSendkeys(getTxtCheckInDate(), checkInDate);
	    elementSendkeys(getTxtCheckOutDate(), checkInOutDate);
	    selectOptionByText(getdDnAdultsRoom(), AdultsPerRoom);
	    selectOptionByText(getdDnChildRoom(), chilPerRoom);
	    elementClick(getBtnSearch());
	    
	}
	
	

}
