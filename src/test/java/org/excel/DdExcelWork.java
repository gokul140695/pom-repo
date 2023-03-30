package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DdExcelWork {

	public static void main(String[] args) throws IOException {

		File file=new File("C:\\Users\\ELCOT\\eclipse-workspace\\FrameWorkClass\\excel\\Adactin.xlsx");

		FileInputStream stream=new FileInputStream(file);

		Workbook workbook =new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet("Datas");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

				Cell cell = row.getCell(j);

				CellType type = cell.getCellType();

				switch (type) {
				case STRING:

					String value = cell.getStringCellValue();

					System.out.println(value);

					break;
				case NUMERIC:

					if (DateUtil.isCellDateFormatted(cell)) {

						Date date = cell.getDateCellValue();

						SimpleDateFormat a=new SimpleDateFormat("dd/MM/yyyy");

						String format = a.format(date);

						System.out.println(format);
					}
					else {

						double d = cell.getNumericCellValue();

						BigDecimal bigDecimal = BigDecimal.valueOf(d);

						String string = bigDecimal.toString();

						System.out.println(string);
					}
					break;
				default:
					break;
				}

			}

		}

	}

}
