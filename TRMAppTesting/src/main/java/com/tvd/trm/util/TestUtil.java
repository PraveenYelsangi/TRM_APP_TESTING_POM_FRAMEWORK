package com.tvd.trm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.google.common.io.Files;
import com.tvd.trm.base.TrmTestBase;

public class TestUtil extends TrmTestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static Workbook book;
	public static Sheet sheet;

	public static String TEST_DATA_FILE = "D:\\JAVA_01\\TRMAppTesting\\src\\main\\java\\com\\tvd\\trm\\testdata\\TRM_TEST_DATA.xlsx";

	// Unexpected alert
	public void alertAccept() {
		Alert alt = null;
		try {
			alt = driver.switchTo().alert();

		} catch (Exception e) {
			System.out.println("--continue--");
		}

		if (alt != null) {
			// System.out.println("no records found");
			alt.accept();
		} else {
			System.out.println("continue-----");
		}

	}

	// Test data method
	public static Object[][] gettestData(String sheetName) {
		try {
			FileInputStream file = new FileInputStream(TEST_DATA_FILE);
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		System.out.println("The no of row no. is: " + row);
		int col = sheet.getRow(0).getLastCellNum();
		System.out.println("The no of column no. is: " + col);

		Object[][] data = new Object[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	// Take Screen SHOT
	public static void takeScreenshotAtEndOfTest() {

		try {
			TakesScreenshot scrshot = ((TakesScreenshot) driver);

			File srcpic = scrshot.getScreenshotAs(OutputType.FILE);

			File destpic = new File("D:\\Selenium jars\\TookScreenShot\\" + timestamp() + ".png");

			Files.copy(srcpic, destpic);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	//Scroll bar
	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}
}
