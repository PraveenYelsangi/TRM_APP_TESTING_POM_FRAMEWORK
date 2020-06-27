package com.tvd.trm.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.pages.TRMGenerateTicketPage;
import com.tvd.trm.pages.TRMHomePage;
import com.tvd.trm.pages.TRMLoginPage;

public class TRMHomePageTest extends TrmTestBase{
	TRMLoginPage loginpage;
	TRMHomePage homepage;
	TRMGenerateTicketPage generate_tic;
	Logger logger = Logger.getLogger(TRMHomePageTest.class.getName());
	
	public TRMHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializebrowser();
		loginpage = new TRMLoginPage();
		homepage = new TRMHomePage();
		homepage = loginpage.trmLogin(property.getProperty("username"), property.getProperty("password"), property.getProperty("trmrole"));
	}
	@Test(priority=1)
	public void homePageTitleTest(){
		logger.info("------------------->> Start HomePage Test <<-------------------");
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Welcome", "Title not found");
		logger.info("==> Home page Title Test Complete and Title is: " + title);
	}
    @Test(priority=2)
	public void validateUsernameTest(){
		Boolean flag = homepage.validateUsername();
		Assert.assertTrue(flag, "Username not found");
		logger.info("==> Home page display Username Test Complete and Title is: " + flag);
	}
	@Test(priority=3)
	public void generateTicketlinkTest(){
		generate_tic = homepage.genreateticketPage();
		logger.info("------------------->> End LoginPage Test <<-------------------");
		logger.info(" ");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
