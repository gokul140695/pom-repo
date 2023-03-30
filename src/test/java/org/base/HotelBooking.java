package org.base;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

public class HotelBooking extends BaseClass {
	
	@BeforeClass
	public static void beforeClass() {

		launchTheBrowser();

		enterUrl("http://adactinhotelapp.com/");
		
		maximizeWindow();
		
		implicityWait(20);
		
	}
	@AfterClass
	public static void afetrclass() {

		quitWindow();
		
	}
	@Test
	public void booking() throws IOException {
		
		WebElement txtUser = findElementById("username");
		
		String name = getCellValue("Hotel", 1, 0);
		
		elementSendkeys(txtUser, name);
		
		WebElement txtpass = findElementById("password");

		String pass = getCellValue("Hotel", 1, 1);
	
		elementSendkeys(txtpass, pass);
		
		WebElement btnLogin = findElementById("login");
	
		elementClick(btnLogin);

		WebElement textLoginMsg = findElementById("username_show");
	
		String afterLoginSuccess = elementGetAttribute(textLoginMsg);
	
		Assert.assertEquals("verify after login success msg", "Hello Mohan1222!",afterLoginSuccess);

		WebElement selectLocation = findElementById("location");

		selectOptionByText(selectLocation, "Melbourne");
		
		WebElement selectHotel = findElementById("hotels");
		
		selectOptionByText(selectHotel, "Hotel Hervey");
		
		WebElement selectRoomType = findElementById("room_type");
	
		selectOptionByText(selectRoomType, "Double");
		
		WebElement selectByRooms = findElementById("room_nos");
		
		selectOptionByText(selectByRooms, "3 - Three");
		
		WebElement checkInDate = findElementById("datepick_in");
		
		String checkIn = getCellValue("Hotel", 1, 2);
		
		elementSendkeys(checkInDate,checkIn );
		
		WebElement checkOutDate = findElementById("datepick_out");
		
		String checkOut = getCellValue("Hotel", 1, 3);
		
		elementSendkeys(checkOutDate, checkOut);
		
		WebElement selectAdults = findElementById("adult_room");
		
		selectOptionByText(selectAdults, "2 - Two");
		
		WebElement selectChildren = findElementById("child_room");
		
		selectOptionByText(selectChildren, "2 - Two");
		
		WebElement btnSubmit = findElementByName("Submit");
		
		elementClick(btnSubmit);
		
		WebElement txtSearchHotel = findElementByXpath("//td[@class='login_title']");
		
		String afterSubmitSucessMsg = elementGetText(txtSearchHotel);
		
		Assert.assertEquals("verify select hotel", "Select Hotel",afterSubmitSucessMsg);

		WebElement slectHotel = findElementById("radiobutton_0");
		
		elementClick(slectHotel);
		
		WebElement btnContinue = findElementById("continue");
		
		elementClick(btnContinue);
		
		WebElement txtBookHotel = findElementByXpath("(//td[@class='login_title'])[2]");
		
		String afterSelectHotelSuccessMsg = elementGetText(txtBookHotel);
		
		Assert.assertEquals("verify Book A Hotel", "Book A Hotel",afterSelectHotelSuccessMsg);
		
		WebElement txtFirstName = findElementById("first_name");
		
		String firstName = getCellValue("Hotel", 1, 4);
		
		elementSendkeys(txtFirstName, firstName);
		
		WebElement txtLastName = findElementById("last_name");
		
		String lastName = getCellValue("Hotel", 1, 5);
		
		elementSendkeys(txtLastName, lastName);
		
		WebElement txtAddress = findElementById("address");
		
		String address = getCellValue("Hotel", 1, 6);
		
		elementSendkeys(txtAddress, address);
		
		WebElement txtCreditCard = findElementById("cc_num");
		
		String creditCard = getCellValue("Hotel", 1, 7);
		
		elementSendkeys(txtCreditCard, creditCard);
		
		WebElement selectCardType = findElementById("cc_type");
		
		selectOptionByText(selectCardType, "Master Card");
		
		WebElement selectMonth = findElementById("cc_exp_month");
		
		selectOptionByText(selectMonth, "March");
		
		WebElement selectYear = findElementById("cc_exp_year");
		
		selectOptionByText(selectYear, "2022");
		
		WebElement txtCvv = findElementById("cc_cvv");
		
		String cvv = getCellValue("Hotel", 1, 8);
		
		elementSendkeys(txtCvv, cvv);
		
		WebElement btnBookNow = findElementById("book_now");
		
		elementClick(btnBookNow);
		
		WebElement txtBookingConfirm = findElementByXpath("//td[text()='Booking Confirmation ']");
		
		String afterBookingSuccess = elementGetText(txtBookingConfirm);
		
		Assert.assertEquals("verify Booking Confirmatin", "Booking Confirmation",afterBookingSuccess);
		
		WebElement getOrderNo = findElementByXpath("//input[@name='order_no']");
		
		String orderNo = elementGetAttribute(getOrderNo);
	
		writeCellData("Hotel", 1, 10, orderNo);
	
	
	
	}
	
	
	
	

}
