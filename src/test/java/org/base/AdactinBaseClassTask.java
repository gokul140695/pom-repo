package org.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

public class AdactinBaseClassTask {


	public void hotelBooking() throws IOException {

		BaseClass baseclass=new BaseClass();


		baseclass.launchTheBrowser();

		baseclass.enterUrl("http://adactinhotelapp.com/");

		baseclass.maximizeWindow();
		
		 baseclass.implicityWait(20);

		WebElement txtUser = baseclass.findElementById("username");

		String name = baseclass.getCellValue("Hotel", 1, 0);

		baseclass.elementSendkeys(txtUser, name);

		WebElement txtpass = baseclass.findElementById("password");

		String pass = baseclass.getCellValue("Hotel", 1, 1);

		baseclass.elementSendkeys(txtpass, pass);

		WebElement btnLogin = baseclass.findElementById("login");

		baseclass.elementClick(btnLogin);

		WebElement selectlLocation = baseclass.findElementById("location");

		baseclass.selectOptionByText(selectlLocation, "Melbourne");

		WebElement selectHotels = baseclass.findElementById("hotels");

		baseclass.selectOptionByText(selectHotels, "Hotel Hervey");

		WebElement selectRoomType = baseclass.findElementById("room_type");

		baseclass.selectOptionByText(selectRoomType, "Double");

		WebElement selectNoOfRooms = baseclass.findElementById("room_nos");

		baseclass.selectOptionByText(selectNoOfRooms, "3 - Three");

		WebElement checkInDate = baseclass.findElementById("datepick_in");

		String checkIn = baseclass.getCellValue("Hotel", 1, 2);

		baseclass.elementSendkeys(checkInDate, checkIn);

		WebElement checkOutDate = baseclass.findElementById("datepick_out");

		String checkOut = baseclass.getCellValue("Hotel", 1, 3);

		baseclass.elementSendkeys(checkOutDate, checkOut);

		WebElement selectAdults = baseclass.findElementById("adult_room");

		baseclass.selectOptionByText(selectAdults, "2 - Two");

		WebElement selectChildren = baseclass.findElementById("child_room");

		baseclass.selectOptionByText(selectChildren, "2 - Two");

		WebElement btnSearch = baseclass.findElementByName("Submit");

		baseclass.elementClick(btnSearch);

		WebElement btnClick = baseclass.findElementById("radiobutton_1");

		baseclass.elementClick(btnClick);

		WebElement btnContinue = baseclass.findElementById("continue");

		baseclass.elementClick(btnContinue);

		WebElement txtFirstName = baseclass.findElementById("first_name");

		String firstName = baseclass.getCellValue("Hotel", 1, 4);

		baseclass.elementSendkeys(txtFirstName, firstName);

		WebElement txtLastName = baseclass.findElementById("last_name");

		String lastName = baseclass.getCellValue("Hotel", 1, 5);

		baseclass.elementSendkeys(txtLastName, lastName);
		
		WebElement txtAddress = baseclass.findElementById("address");

		String address = baseclass.getCellValue("Hotel", 1, 6);

		baseclass.elementSendkeys(txtAddress, address);
		
		WebElement txtCreditCard = baseclass.findElementById("cc_num");

		String creditCardNumber = baseclass.getCellValue("Hotel", 1, 7);

		baseclass.elementSendkeys(txtCreditCard, creditCardNumber);
		
		WebElement selectCardType = baseclass.findElementById("cc_type");

		baseclass.selectOptionByText(selectCardType, "Master Card");
		
		WebElement selectMonth = baseclass.findElementById("cc_exp_month");

		baseclass.selectOptionByText(selectMonth, "March");
		
		WebElement selectYear = baseclass.findElementById("cc_exp_year");

		baseclass.selectOptionByText(selectYear, "2022");
		
		WebElement txtCvvNum = baseclass.findElementById("cc_cvv");

		String cvv = baseclass.getCellValue("Hotel", 1, 8);

		baseclass.elementSendkeys(txtCvvNum, cvv);
		
		WebElement btnBook = baseclass.findElementById("book_now");
		
		baseclass.elementClick(btnBook);
		
		WebElement txtorderid = baseclass.findElementByXpath("//input[@name='order_no']");
		
		String orderId = baseclass.elementGetAttribute(txtorderid);
		
		baseclass.writeCellData("Hotel", 1, 9, orderId);
		
		
		

	}

	public static void main(String[] args) throws IOException {

		AdactinBaseClassTask a=new AdactinBaseClassTask();

		a.hotelBooking();


	}




}
