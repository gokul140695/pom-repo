package com.pages;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PomHotelLogin extends BaseClass {
	
	@BeforeClass
	public static void beforeClass() {
		
		launchTheBrowser();
		enterUrl("http://adactinhotelapp.com/");
		maximizeWindow();
		implicityWait(20);
	}
	
	@AfterClass
	public static void afterClass() {

		quitWindow();
	}

	@Test
	public void booking() throws IOException, InterruptedException {

		LoginPage log=new LoginPage();

		log.login(getCellValue("PomHotel", 1, 0), getCellValue("PomHotel", 1, 1));
		
		SearchHotelPage hotelPage=new SearchHotelPage();
		
		String afterLoginSuccessMsg = elementGetAttribute(hotelPage.getVerifySuccessMsg());
		
		Assert.assertEquals("verify after login success msg", "Hello Mohan1222!",afterLoginSuccessMsg);
		
		hotelPage.searchHotels("Melbourne", "Hotel Hervey", "Double", "3 - Three", getCellValue("PomHotel", 1, 2), getCellValue("PomHotel", 1, 3), "2 - Two", "2 - Two");
		
		SelectHotelPage selectHotelPage=new SelectHotelPage();
		
		String afterSearchSuccessMsg = elementGetText(selectHotelPage.getAfterSearchSuccessMsg());
		
		Assert.assertEquals("verify select hotel ", "Select Hotel",afterSearchSuccessMsg);
		
		selectHotelPage.selectHotel();
		
		BookAHotelPage aHotelPage=new BookAHotelPage();
		
		String  afterSelectSuccessMsg= elementGetText(aHotelPage.getAfterSelectHotelSuccessMsg());
		
		Assert.assertEquals("verify Book A Hotel", "Book A Hotel",afterSelectSuccessMsg);
		
		aHotelPage.BookAHotel(getCellValue("PomHotel", 1, 4), getCellValue("PomHotel", 1, 5), getCellValue("PomHotel", 1, 6), getCellValue("PomHotel", 1, 7), "Master Card", "March", "2022", getCellValue("PomHotel", 1, 8));
		
		BookingConfirmPage confirmPage=new BookingConfirmPage();
		
		String afterBookAHotelSuccessMsg = elementGetText(confirmPage.getAfterBookAHotelSuccessMsg());
		
		Assert.assertEquals("verify Booking Confirmation", "Booking Confirmation",afterBookAHotelSuccessMsg);

		String ordernumber = elementGetAttribute(confirmPage.getGetOrderNo());
		
		writeCellData("PomHotel", 1, 9, ordernumber);
		
		confirmPage.BookingConfirm();
		
		CancelBookingPage cancel=new CancelBookingPage();
		
		
		cancel.CancelBooking(getCellValue("PomHotel", 1, 9));
		
		
	}

}
