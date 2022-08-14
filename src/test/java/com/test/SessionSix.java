package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
public class SessionSix {
	public static void main(String[] args) throws IOException  {
		File fl = new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel1.xlsx");
		Workbook workBk = new XSSFWorkbook();
		Sheet sht = workBk.createSheet("New");
		String St = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number of rows you need to Write : ");
		int x=s.nextInt();
		System.out.println("Enter Number of cells you need to Write in Row : ");
		int y=s.nextInt();
		System.out.println("Enter Values one by one as String");
		
		for (int i = 0; i < x; i++) {
			Row rw = sht.createRow(i);
			for (int j = 0; j < y; j++) {
				Cell cel = rw.createCell(j);
				
				St= s.next();
				
				cel.setCellValue(St);
				FileOutputStream out = new FileOutputStream(fl);
				workBk.write(out);
	}}}
}
