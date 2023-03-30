package org.greenspomtask;

import org.base.BaseClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class pomPage extends BaseClass {

	@BeforeClass
	public static void beforeclass() {

		launchTheBrowser();
		enterUrl("http://www.greenstechnologys.com/");
		maximizeWindow();
		implicityWait(10);
	}

	@Test
	public void greensPom() {

		GreensEntryPage firstpage=new GreensEntryPage();
		
		firstpage.scrolldown();
		
		System.out.println(elementGetText(firstpage.getDownText()));
		
		firstpage.scrollUp();
		
		System.out.println(elementGetText(firstpage.getUpText()));
		
		firstpage.getLnkCertifications();
		
		CertificationPage certifications=new CertificationPage();
		
		String successmsg = elementGetText(certifications.getVerifymsg());
		
		Assert.assertEquals("verify course Message", "Courses",successmsg);
		
		
		
		
	}
	

}
