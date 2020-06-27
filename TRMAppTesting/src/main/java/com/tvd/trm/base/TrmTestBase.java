package com.tvd.trm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.tvd.trm.util.TestUtil;
import com.tvd.trm.util.WebEventListener;

public class TrmTestBase {

	public static WebDriver driver;
	public static Properties property;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	// constructor to initialize Propeties
	public TrmTestBase() {
		try {
			property = new Properties();
			FileInputStream fileip = new FileInputStream(
					"D:/JAVA_01/TRMAppTesting/src/main/java/com/tvd/trm/config/config.properties");
			property.load(fileip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// method to initialize browser
	public void initializebrowser() {
		String launchbrowser = property.getProperty("browsers");
		if (launchbrowser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars\\chrome driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (launchbrowser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium jars\\gecko driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(property.getProperty("url"));
	}

}
