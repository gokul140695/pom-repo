package org.greenspomtask;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreensEntryPage extends BaseClass {

	public WebElement getLnkCertifications() {
		return lnkCertifications;
	}

	public GreensEntryPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Greens Technology OMR']")
	private WebElement downText;

	@FindBy(xpath="//h1[@style='font-size:22px;']")
	private WebElement upText;
	
	@FindBy(xpath="//a[text()='Certifications']")
	private WebElement lnkCertifications;
	

	
	
	public WebElement getDownText() {
		return downText;
	}

	public WebElement getUpText() {
		return upText;
	}

	public void scrolldown() {

		scrollDownByJs(getDownText());
	}
	public void scrollUp() {

		scrollupByJs(getUpText());
	}
	
	public void entryPage() {

		elementClick(getLnkCertifications());
		
	}

}
