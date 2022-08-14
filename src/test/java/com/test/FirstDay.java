package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FirstDay {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.navigate().to("https://omrbranch.com/");
		
		File fl = new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Check excel.xlsx");
		FileInputStream St = new FileInputStream(fl);
		Workbook workBk = new XSSFWorkbook(St);
		Sheet sht = workBk.getSheet("Logins");
		
		
		for (int i = 1; i < sht.getPhysicalNumberOfRows(); i++) {
			Row rw = sht.getRow(i);
			for (int j = 0; j < rw.getPhysicalNumberOfCells(); j++) {
				if (j==7) {
					Cell cell = rw.getCell(j);
					WebElement emailTab = dr.findElement(By.id("email"));
					emailTab.sendKeys(cell.toString());
					System.out.print(emailTab.getAttribute("value")+"\t");	//print
				}if (j==9) {
					Cell cell = rw.getCell(j);
					WebElement passTab = dr.findElement(By.name("pass"));
					passTab.sendKeys(cell.toString());
					Thread.sleep(2000);
					System.out.print(passTab.getAttribute("value"));         //print               
					WebElement btnLogin = dr.findElement(By.xpath("//button[@type='submit']"));
					btnLogin.click();
					System.out.println();   //New Line
				}
			}
			Thread.sleep(3000);
			dr.navigate().refresh();
		}
		
	}

}
