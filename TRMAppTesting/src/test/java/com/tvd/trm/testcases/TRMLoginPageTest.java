package com.tvd.trm.testcases;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.pages.TRMHomePage;
import com.tvd.trm.pages.TRMLoginPage;

public class TRMLoginPageTest extends TrmTestBase {
	TRMLoginPage loginpage;
	TRMHomePage homepage;
	Logger logger = Logger.getLogger(TRMLoginPageTest.class.getName());

	public TRMLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializebrowser();
		loginpage = new TRMLoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		logger.info("------------------->> Start LoginPage Test <<-------------------");
		String title = loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "Login Page", "Login title not matched");
		logger.info("==> Login page Title Test Complete and Title is: " + title);
	}

	@Test(priority = 2)
	public void hescomLogoTest() {
		Boolean flag = loginpage.validatehescomlogo();
		Assert.assertTrue(flag, "Login not Found");
		logger.info("==> Home page Logo Test Complete and flag is: " + flag);
	}

	@Test(priority = 3)
	public void rapdrpTextTest() {
		String txt = loginpage.validaterapdrptxt();
		Assert.assertEquals(txt, "R-APDRP TOTAL REVENUE MANAGEMENT SYSTEM.", "Page Text not Matched");
		logger.info("==> Home page RAPDRP text Test Complete and text is: " + txt);
	}

	@Test(priority = 4)
	public void trmLoginTest() {
		homepage = loginpage.trmLogin(property.getProperty("username"), property.getProperty("password"),
				property.getProperty("trmrole"));
		logger.info("TRM Application Login Successfully");
		logger.info("------------------->> End LoginPage Test <<-------------------");
		logger.info(" ");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
