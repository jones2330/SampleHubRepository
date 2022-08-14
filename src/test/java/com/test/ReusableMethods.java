package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
	static WebDriver driver;
	public void browerLaunch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public void loadurl(String url) {
		driver.get(url);
	}
	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	public WebElement findElementByclassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}
	public WebElement findElementByxpath(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		return element;
	}
	public void sendkey(WebElement element,String value) {
		element.sendKeys(value);
	}
	public void clickwebElement(WebElement element) {
		element.click();
	}
	public void closeCurrentWindow() {
		driver.close();
	}
	public void closeAllWindows() {
		driver.quit();
	}
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String getCurrentTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public String getEnteredValue(WebElement element, String Atvalue) {
		String text = element.getAttribute(Atvalue);
	return text;
	}
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void sendKeysInAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
	public void sendKeysByJsExecutor(WebElement element , String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
	}
	public String getAttributeJsExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object script = js.executeScript("return arguments[0].getAttribute('value')",element);
		String text = (String) script;
		return text;
	}
	public void screenCaptureAsJpeg(String path) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenshotAsFile = screenShot.getScreenshotAs(OutputType.FILE);
		File fileCopy = new File(path);
		FileUtils.copyFile(screenshotAsFile, fileCopy);
	}
	public void switchFrameByIndex(String index) {
		driver.switchTo().frame(index);
		}
	public void switchFrameByName(String name) {
		driver.switchTo().frame(name);
		}
	public void switchFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
		}
	public void switchToDefault() {
		driver.switchTo().defaultContent();
		}
	public void switchToImediateParentFrame() {
		driver.switchTo().parentFrame();
		}
	public void selectDropDownByIndex(WebElement element, int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
	}
	public void selectDropDownByVisibletext(WebElement element, String text) {
		Select select =new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectDropDownByValue(WebElement element, String val) {
		Select select =new Select(element);
		select.selectByValue(val);
	}
	public void deSelectDropDownByIndex(WebElement element, int index) {
		Select select =new Select(element);
		select.deselectByIndex(index);
	}
	public void deSelectDropDownByVisibletext(WebElement element, String text) {
		Select select =new Select(element);
		select.deselectByVisibleText(text);
	}
	public void deSelectDropDownByValue(WebElement element, String val) {
		Select select =new Select(element);
		select.deselectByValue(val);
	}
	public void deSelectAllInDropDown(WebElement element) {
		Select select =new Select(element);
		select.deselectAll();
	}
	public List<WebElement> optionsInDropDown(WebElement element) {
		Select select =new Select(element);
		List<WebElement> allOptions = select.getOptions();
		return allOptions;
	}
	public List<WebElement> selectedOptionsInDropDown(WebElement element) {
		Select select =new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
	public Set<String> getAllOpenWindows() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public void switchToWindowByHandle(String handle) {
		driver.switchTo().window(handle);
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void rightClickOnWebelement(WebElement element) {
		Actions action= new Actions(driver);
		action.contextClick(element).perform();
	}
	public void dragAndDropWebElement(WebElement srcElement,WebElement desElement) {
		Actions action= new Actions(driver);
		action.dragAndDrop(srcElement, desElement);
	}
	public String getDataFromExcel(String sheet,int rowIndex, int cellIndex) throws IOException {
		String data=null;
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Booking.xlsx");
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
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Booking.xlsx");
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
		File file =new File("C:\\Users\\PAVI\\eclipse-workspace\\CheckByMav\\Excel\\Booking.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet dataSheet = workbook.getSheet(sheetName);
		Row row = dataSheet.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(Data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	public int getIntInputFromUser() {
		int val=0;
		Scanner scan = new Scanner(System.in);
		val = scan.nextInt();
		return val;
	}
	
}
/*1.Select location(Sydney,Melbourne,Brisbane,Adelaide,London,New York,Los Angeles,Paris)
 * 2.hotels(Hotel Creek,Hotel Sunshine,Hotel Hervey,Hotel Cornice)
 * 3.Room Type(Standard,Double,Deluxe,Super Deluxe)
 * 4.No of Rooms (1 - One,to ten)
 * CheckInDate(dd/MM/YYYY)
 * CheckOutDate(dd/MM/YYYY)
 * Adults per Room (1-4)
 * Childerens per Room (0-4)
 * Click Search
 * select CheckButton
 * click Continue
 * Address card details(FirstName,lastName,Biling Address,Credit Card no(16),Card Type(4),Exp month, Exp Year,CVV no(4))
 * click.BookNow
 * getOrderId
 */