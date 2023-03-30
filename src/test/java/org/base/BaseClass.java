package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public	static WebDriver driver;

	public String getCellValue(String sheetname,int rownum,int cellnum) throws IOException {

		String res="";
		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\FrameWorkClass\\excel\\AdactinHotel.xlsx");

		FileInputStream stream=new FileInputStream(file);

		Workbook workbook=new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);

			}else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check==numericCellValue) {
					res = String.valueOf(numericCellValue);
				}else {
					res = String.valueOf(check);
				}

			}

			break;

		default:
			break;
		}
		return res;

	}

	public void updateCellData(String sheetname,int rownum,int cellnum,String oldData,String newData) throws IOException {

		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\FrameWorkClass\\excel\\Adactin.xlsx");

		FileInputStream stream=new FileInputStream(file);

		Workbook workbook=new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);
		
		String value = cell.getStringCellValue();
		
		if (value.equals(oldData)) {
	
			cell.setCellValue(newData);
		}
		FileOutputStream out=new FileOutputStream(file);
		
		workbook.write(out);


	}
	
	public void writeCellData(String sheetname,int rownum,int cellnum,String data) throws IOException {

		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\FrameWorkClass\\excel\\AdactinHotel.xlsx");

		FileInputStream stream=new FileInputStream(file);

		Workbook workbook=new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell createCell = row.createCell(cellnum);
		
		createCell.setCellValue(data);
		
		FileOutputStream out=new FileOutputStream(file);
		
		workbook.write(out);

	}







	public static void launchTheBrowser() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	public static void enterUrl(String url) {

		driver.get(url);
	}
	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}
	public void elementSendkeys(WebElement element,String text) {

		element.sendKeys(text);
	}

	public void elementClick(WebElement element) {

		element.click();
	}

	public void acceptInAlert() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

	public void dissmissInAlert() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();

	}

	public String elementGetText(WebElement element) {

		String text = element.getText();
		return text.trim();
	}
	public String elementGetAttribute(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public static void quitWindow() {

		driver.quit();
	}
	public void closeCurrentWindow() {
		driver.close();
	}

	public String getApplicationTittle() {

		String title = driver.getTitle();
		return title;
	}

	public String getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public void selectOptionByText(WebElement element,String text) {

		Select select=new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByAttribute(WebElement element,String attributevalue) {

		Select select=new Select(element);
		select.selectByValue(attributevalue);
	}
	public void selectOptionByIndex(WebElement element,int index) {

		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void sendkeysByJs(WebElement element,String text) {

		JavascriptExecutor jk=(JavascriptExecutor) driver;

		jk.executeScript("arguments[0].setAttribute('value','"+text+"')", element);
	}
	public void clickByJs(WebElement element) {

		JavascriptExecutor jk =(JavascriptExecutor) driver;

		jk.executeScript("arguments[0].click())", element);
	}
	public void switchToChildWindow() {

		Set<String> handles = driver.getWindowHandles();

		for (String childwindow : handles) {
			driver.switchTo().window(childwindow);
		}
	}

	public void switchFrameByIndex(int index) {

		driver.switchTo().frame(index);
	}
	public void switchToFrameById(WebElement frameElement) {

		driver.switchTo().frame(frameElement);
	}
	public WebElement findElementById(String text) {

		WebElement element = driver.findElement(By.id(text));
		return element;
	}
	public WebElement findElementByName(String text) {

		WebElement element = driver.findElement(By.name(text));
		return element;
	}
	public WebElement findElementByClassName(String text) {

		WebElement element = driver.findElement(By.className(text));
		return element;
	}
	public WebElement findElementByXpath(String xpathvalue) {

		WebElement element = driver.findElement(By.xpath(xpathvalue));
		return element;
	}
	public void getOptionsByGetText(WebElement element) {

		Select select=new Select(element);

		List<WebElement> options = select.getOptions();

		for (WebElement x : options) {
			String text = x.getText();
		}
	}
	public void getoptionsByAttributeValue(WebElement element,String text) {

		Select select=new Select(element);

		List<WebElement> options = select.getOptions();

		for (WebElement x : options) {
			String attribute = x.getAttribute(text);
		}
	}
	public WebElement firstSelectedOption(WebElement element) {

		Select select=new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}
	public boolean checkMultipleSelection(WebElement element) {

		Select select=new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	public static Timeouts implicityWait(long time) {

		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return implicitlyWait;
	}
	public WebElement explicityWait(long time,String text) {

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));

		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.id(text)));
		return until;
	}
	public void deselectByIndex(WebElement element,int index) {

		Select select=new Select(element);

		select.deselectByIndex(index);
	}
	public void deselectByAttribute(WebElement element,String attributevalue) {

		Select select=new Select(element);

		select.deselectByValue(attributevalue);
	}
	public void DeselectByText(WebElement element,String text) {

		Select select=new Select(element);

		select.deselectByVisibleText(text);
	}
	public void deselectByAll(WebElement element) {

		Select select=new Select(element);

		select.deselectAll();
	}
	public String getTheParentWindow() {

		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public Set<String> getAllWindows() {

		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public void clearTheText(WebElement element) {

		element.clear();
	}
	public File takesScreenShot() {

		TakesScreenshot tk=(TakesScreenshot) driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	public Actions moveToElement(WebElement element) {

		Actions actions=new Actions(driver);
		Actions moveToElement = actions.moveToElement(element);
		return moveToElement;

	}
	public Actions dragAndDrop(WebElement sourceElement,WebElement destiElement) {

		Actions actions=new Actions(driver);
		Actions dragAndDrop = actions.dragAndDrop(sourceElement, destiElement);
		return dragAndDrop;
	}
	public Actions contextClick(WebElement element) {

		Actions actions=new Actions(driver);
		Actions contextClick = actions.contextClick(element);
		return contextClick;
	}
	public Actions dooubleClick(WebElement element) {
		Actions actions=new Actions(driver);
		Actions doubleClick = actions.doubleClick(element);
		return doubleClick;
	}
	public void insertValueAndEnter(WebElement element,String text) {

		element.sendKeys(text +Keys.ENTER);
	}
	public void moveToForwardPage() {

		driver.navigate().forward();
	}
	public void moveToBack() {

		driver.navigate().back();
	}
	public void pageToRefresh() {

		driver.navigate().refresh();
	}
	public void scrollDownByJs(WebElement element) {

		JavascriptExecutor jk=(JavascriptExecutor) driver;

		jk.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}


	public void scrollupByJs(WebElement element) {

		JavascriptExecutor jk=(JavascriptExecutor) driver;

		jk.executeScript("arguments[0].scrollIntoView(false)", element);
	}






































}
