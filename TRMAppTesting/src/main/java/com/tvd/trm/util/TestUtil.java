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
import org.openqa.selenium.io.FileHandler;
import com.tvd.trm.base.TrmTestBase;

public class TestUtil extends TrmTestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;

	public static Workbook book;
	public static Sheet sheet;

	public static String currentWorkingDir = System.getProperty("user.dir");
	public static String testdataPath = currentWorkingDir + "\\src\\main\\java\\com\\tvd\\trm\\testdata";
	public static String TEST_DATA_FILE = testdataPath + "\\TRM_TEST_DATA.xlsx";

	// public static String TEST_DATA_FILE =
	// "D:\\JAVA_01\\TRMAppTesting\\src\\main\\java\\com\\tvd\\trm\\testdata\\TRM_TEST_DATA.xlsx";

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

	// Taking failed Screen SHOT
	public static String screenshotpath;

	public static void captureScreenshot(String methodName) throws IOException {
		// Take screen shot and store it in volatile memory with reference name
		// scrFile
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			screenshotpath = System.getProperty("user.dir") + "/Screenshots/" + methodName + "_" + timestamp()
					+ ".jpeg";
			FileHandler.copy(scrFile, new File(screenshotpath));
		} catch (IOException e) {
			System.out.println("Screenshot not capture for method: " + methodName);
			e.printStackTrace();
		}
	}

	/*// Take Screen SHOT
	public static void takeScreenshotAtEndOfTest() throws IOException {
		String screenshot = currentWorkingDir + "/Screenshots";
		try {
			TakesScreenshot scrshot = ((TakesScreenshot) driver);

			File srcpic = scrshot.getScreenshotAs(OutputType.FILE);

			File destpic = new File(screenshot + timestamp() + ".png");

			Files.copy(srcpic, destpic);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}*/

	public static String timestamp() {
		return new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
	}

	// Scroll bar
	public void scrolldown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}

	/*
	 * // To clear before logged data in log file public static void logclear(){
	 * BufferedWriter bw; try { bw = new BufferedWriter(new
	 * FileWriter("C:\\Testing_Logs\\log.txt")); bw.write(""); bw.flush();
	 * bw.close(); } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

}
