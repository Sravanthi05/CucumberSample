package org.basefire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclassfire {
public static WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
		
		public static void windowMaximize() {
			driver.manage().window().maximize();
		}
		
		public static void launchUrl (String url){
			driver.get(url);
		}
		
		public static String pageTitle() {
			String title = driver.getTitle();
			return title;
		}
		
		public static String pageUrl() {
			String url = driver.getCurrentUrl();
			return url;
		}
		
		public static void passText (String txt, WebElement web) {
			web.sendKeys(txt);
		}
		
		public static void closeEntireBrowser() {
			driver.quit();
		}
		
		public static void clickBtn(WebElement web) {
			web.click();
		}
		
		public static void screenShot (String imgName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File image = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("location+ imgName.png");
			FileUtils.copyFile(image, f);
		}
		
		public static Actions a;
		
		public static void moveTheCursor(WebElement targetWebElement) {
			a = new Actions(driver);
			a.moveToElement(targetWebElement).perform();
		}
		
		public static void dragDrop(WebElement dragElement, WebElement dropElement) {
			a= new Actions(driver);
			a.dragAndDrop(dragElement, dropElement).perform();
		}
		
		public static JavascriptExecutor js;
		
		public static void scrollThePage (WebElement targetpage) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0],scrollIntoView(true)", targetpage);
			}
		
		public static void scroll(WebElement element) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0],scrollIntoView(flase)", element);
		}
		
	/*	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
			File f = new File ("excellocation.xlsx");
			FileInputStream fls = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fls);
			Sheet mysheet = wb.getSheet("Data");
			Row r = mysheet.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			CellType cellType = c.getCellType();
			
			String value = " ";
			if(cellType == 1) {
				String value2 = c.getStringCellValue();
				
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date dd = c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat(value);
				String value1 = s.format(dd);
			}
			
			else {
				double d = c.getNumericCellValue();
				long l = (long)d;
				String valueOf = String.valueOf(l);
				
			}
		}*/
			
		public static void createNewExcelFile (int rowNum, int cellNum, String writeData) throws IOException {
			File f = new File("/Users/sravanthi/eclipse-workspace1/mavenInstallation/Excel/writedata.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("Datas");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			
			}
		
		public static void createCell (int rowNum, int cellNum, String writeData) throws IOException {
			File f = new File("/Users/sravanthi/eclipse-workspace1/mavenInstallation/Excel/writedata.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Datas");
			Row r = s.getRow(rowNum);
			Cell c = r.createCell(cellNum);
			c.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			
			}
		
		public static void createRow (int rowNum, int cellNum, String writeData) throws IOException {
			File f = new File("/Users/sravanthi/eclipse-workspace1/mavenInstallation/Excel/writedata.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet newSheet = w.getSheet("Datas");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			
			}
		
		public static void updateDataToParticularCell (int getTheRow, int getTheCell, String existingData, String writeNewData) throws IOException {
			File f = new File("Excel Location.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s = wb.getSheet("Datas");
			Row r = s.getRow(getTheRow);
			Cell c = r.getCell(getTheCell);
			String str = c.getStringCellValue();
			if (str.equals(existingData)) {
				c.setCellValue(writeNewData);
				}
			
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			
			
			
			
		}
	
	
}
	











