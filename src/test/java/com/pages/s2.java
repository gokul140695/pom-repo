package com.pages;

import org.base.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class s2 extends BaseClass{
	
	
	@BeforeClass
	public static void before() {

		launchTheBrowser();
		enterUrl("http://adactinhotelapp.com/");
		maximizeWindow();
	}
	
	@Test
	public void loginfunction() {
		
		sample s=new sample();
		
		
		s.login("Mohan1222", "Noor@12345");
		
		

	}
	
}
