package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {

	public static void main(String[] args) throws IOException {

		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\FrameWorkClass\\excel\\Adactin.xlsx");

		FileInputStream stream=new FileInputStream(file);

		Workbook workbook=new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet("Datas");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
		
			   for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				   Cell cell = row.getCell(j);
			
				   System.out.println(cell);
			   }
		
		}

		
		
	}

}
