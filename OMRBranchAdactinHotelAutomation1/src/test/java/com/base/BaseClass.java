package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * @author Jones
 * @return byte[]
 * @description Used to Maintain all the Reusable Methods
 * @date 23-08-2022
 * 
 */
public class BaseClass {

	public static WebDriver driver;
	
	/**
	 * @return byte[]
	 */
	public byte[] screenShot() {
		TakesScreenshot tk = (TakesScreenshot) driver;
		byte[] b = tk.getScreenshotAs(OutputType.BYTES);
		return b;
	}
	/**
	 * @param browser
	 */
	public void browerLaunch(String browser) {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();		
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();		
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();		
			break;

		default:
			break;
		}
	}
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Config\\Config.properties"));
		String value = (String) properties.getProperty(key);
		return value;
	}
	/**
	 * @description Used to implement wait function
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 * @param webssiteURL
	 */
	public void loadurl(String webssiteURL) {
		driver.get(webssiteURL);
	}
	/**
	 * 
	 * @param attributeId
	 * @return WebElement
	 */
	public WebElement findElementById(String attributeId) {
		WebElement element = driver.findElement(By.id(attributeId));
		return element;
	}
	/**
	 * @param attributeName
	 * @return WebElement
	 */
	public WebElement findElementByName(String attributeName) {
		WebElement element = driver.findElement(By.name(attributeName));
		return element;
	}
	/**
	 * @param attributeClassName
	 * @return WebElement
	 */
	public WebElement findElementByclassName(String attributeClassName) {
		WebElement element = driver.findElement(By.className(attributeClassName));
		return element;
	}
	/**
	 * @param xPath
	 * @return WebElement
	 */
	public WebElement findElementByxpath(String xPath) {
		WebElement element = driver.findElement(By.xpath(xPath));
		return element;
	}
	/**
	 * @param element
	 * @param value
	 */
	public void sendkey(WebElement element,String value) {
		element.sendKeys(value);
	}
	/**
	 * @param element
	 */
	public void clickwebElement(WebElement element) {
		element.click();
	}
	/**
	 * @description Used to Close Current Window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	/**
	 * @description Used to Close All Windows
	 */
	public void closeAllWindows() {
		driver.quit();
	}
	/**
	 * @return String
	 */
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	/**
	 * @return String
	 */
	public String getCurrentTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}
	/**
	 * @param element
	 * @return String
	 */
	public String getWebElementText(WebElement element) {
		String text = element.getText();
		return text;
	}
	/**
	 * @param element
	 * @param attributeValue
	 * @return String
	 */
	public String getEnteredValue(WebElement element, String attributeValue) {
		String text = element.getAttribute(attributeValue);
	return text;
	}
	/**
	 * @description Used to Handle and accept the AlertBox 
	 */
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	/**
	 * @description Used to Handle and dismiss the AlertBox
	 */
	public void alertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * 
	 * @param textInAlert
	 */
	public void sendKeysInAlert(String textInAlert) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(textInAlert);
	}
	/**
	 * @param element
	 * @param text
	 */
	public void sendKeysByJsExecutor(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
	}
	/**
	 * @param element
	 * @return String
	 */
	public String getAttributeJsExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object script = js.executeScript("return arguments[0].getAttribute('value')",element);
		String text = (String) script;
		return text;
	}
	/**
	 * @param screenshotPath
	 * @throws IOException
	 */
	public void screenCaptureAsJpeg(String screenshotPath) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenshotAsFile = screenShot.getScreenshotAs(OutputType.FILE);
		File fileCopy = new File(screenshotPath);
		FileUtils.copyFile(screenshotAsFile, fileCopy);
	}
	/**
	 * @param frameIndex
	 */
	public void switchFrameByIndex(String frameIndex) {
		driver.switchTo().frame(frameIndex);
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
