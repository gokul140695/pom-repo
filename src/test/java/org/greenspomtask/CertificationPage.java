package org.greenspomtask;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CertificationPage extends BaseClass{

	
	@FindBy(id="pageHeader")
	private WebElement verifymsg;

	public WebElement getVerifymsg() {
		return verifymsg;
	}
	
	
	
	
}
