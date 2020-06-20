package com.tvd.trm.testcases;

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
		String title = homepage.validateHomePageTitle();
		System.out.println("The Title of TRM HomePage is===:> "+title);
		Assert.assertEquals(title, "Welcome", "Title not found");
	}
    @Test(priority=2)
	public void validateUsernameTest(){
		Boolean flag = homepage.validateUsername();
		System.out.println("The Display Username is ===:> "+flag);
		Assert.assertTrue(flag, "Username not found");
	}
	@Test(priority=3)
	public void generateTicketlinkTest(){
		generate_tic = homepage.genreateticketPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
