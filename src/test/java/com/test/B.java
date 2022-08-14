package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class B {
	public void enterValueInNewCell(String sheetName,int rowIndex,int cellIndex,String Data) throws IOException {
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet dataSheet = workbook.getSheet(sheetName);
		Row row = dataSheet.createRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(Data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
		System.out.println("Added");
	}
	public static void main(String[] args) throws IOException {
		B b = new B();
		b.enterValueInNewCell("new",6,5,"Jnes");
	}
}
