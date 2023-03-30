package org.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OmrbranchExcelTask {

	public static void main(String[] args) throws IOException {

		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\FrameWorkClass\\excel\\omr.xlsx");

		Workbook workbook=new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Country");

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://omrbranch.com/apitestingtraininginchennaiomr");

		WebElement dropBox = driver.findElement(By.xpath("//select[@id='country-list']"));

		dropBox.click();

		Select select=new Select(dropBox);

		List<WebElement> options = select.getOptions();

		
		for (int j = 0; j <options.size(); j++) {
			Row row = sheet.createRow(j);
			
		 WebElement list = options.get(j);

				String text = list.getText();

			Cell cell = row.createCell(0);

			cell.setCellValue(text);
		}
		
		FileOutputStream out=new FileOutputStream(file);
		
		workbook.write(out);


	}

}
