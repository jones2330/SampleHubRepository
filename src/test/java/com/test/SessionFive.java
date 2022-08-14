package com.test;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SessionFive {
	public static void main(String[] args) throws IOException, InterruptedException {
		File fl = new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel.xlsx");
		FileInputStream St = new FileInputStream(fl);
		Workbook workBk = new XSSFWorkbook(St);
		Sheet sht = workBk.getSheet("DoJ");
		
		for (int i = 0; i < sht.getPhysicalNumberOfRows(); i++) {
			Row rw = sht.getRow(i);
			for (int j = 0; j < rw.getPhysicalNumberOfCells(); j++) {
				Cell cell = rw.getCell(j);
				CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dtFmt = new SimpleDateFormat("dd/MM/YYYY");
						String formatedDate = dtFmt.format(dateCellValue);
						System.out.println(formatedDate);
					} else {
						double cellD = cell.getNumericCellValue();
						BigDecimal bD=BigDecimal.valueOf(cellD);
						//System.out.println(bD);
						System.out.println(bD.toString());
					}
					break;
				default:
					break;
				}
			}
		}
	}
}
