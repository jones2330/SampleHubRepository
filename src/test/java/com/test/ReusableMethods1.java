package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReusableMethods1 {
	
	public String getDataFromExcel(String sheet,int rowIndex, int cellIndex) throws IOException {
		String data=null;
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet dataSheet = workbook.getSheet(sheet);
		Row row = dataSheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat reqFormat=new SimpleDateFormat("dd/MM/YYYY");
				String formatedDate = reqFormat.format(dateCellValue);
				data= formatedDate;
			}else {
				double numericCellValue = cell.getNumericCellValue();
				long roundedValue = Math.round(numericCellValue);
				if(roundedValue==numericCellValue) {
					String stringValue = String.valueOf(roundedValue);
					data=stringValue;
				}else {
					String stringValue = String.valueOf(numericCellValue);
					data=stringValue;
				}
			}
			break;
		case STRING:
			String stringCellValue = cell.getStringCellValue();
			data=stringCellValue;
			break;
		default:
			break;
		}
		return data;
	}
	
	public void replaceCellValue(String sheetName,int rowIndex,int cellIndex,String oldData,String newData) throws IOException {
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet dataSheet = workbook.getSheet(sheetName);
		Row row = dataSheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	
	public void enterValueInNewCell(String sheetName,int rowIndex,int cellIndex,String Data) throws IOException {
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet dataSheet = workbook.getSheet(sheetName);
		Row row = dataSheet.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(Data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	
	public static void main(String[] args) throws IOException {
		ReusableMethods1 reuse = new ReusableMethods1();
		reuse.enterValueInNewCell("new",6,6,"JonES");
	}
}


















