package org.excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinTask {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://adactinhotelapp.com/");
		
		WebElement userBox = driver.findElement(By.id("username"));
			
		userBox.sendKeys("gokul");
		
		WebElement passBox = driver.findElement(By.id("password"));
		
		passBox.sendKeys("123456");
		
		WebElement btnLogin = driver.findElement(By.id("login"));
		
		btnLogin.click();
		
		
	}
	
}
