package org.junitsample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	static WebDriver driver;
	
	long berforeTime;
	
	long aftertime;
	

	@BeforeClass
	public static void beforeclass() {

		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass
	public static void afterclass() {

		driver.quit();
	}
	@Before
	public void beforeMethod() {

	  berforeTime = System.currentTimeMillis();
		System.out.println(berforeTime);
	}
	@After
	public void afterMethod() {
		 aftertime = System.currentTimeMillis();
		System.out.println(aftertime);
		
	   long  totalTime=aftertime-berforeTime;
	   
	   System.out.println(totalTime);
		
	}
	@Test
	public void payment() {

		WebElement txtUser = driver.findElement(By.id("email"));
		
		txtUser.sendKeys("gokul");
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		
		txtPass.sendKeys("1345");
	
		WebElement btnLogin = driver.findElement(By.id("u_0_9_u4"));
	
		btnLogin.click();
		
		
	
	
	
	}
	

}
