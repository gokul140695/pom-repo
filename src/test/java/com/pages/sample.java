package com.pages;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sample extends BaseClass {
	
	
	public sample() {

	PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement pass;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	@FindBy(id="login")
	private WebElement btnLogin;
	
	
	
	public void login(String text,String passs) {
		
     elementSendkeys(getUsername(), text);
     
     elementSendkeys(getPass(), passs);
     
     elementClick(getBtnLogin());
     
     
	}
	
	


}
