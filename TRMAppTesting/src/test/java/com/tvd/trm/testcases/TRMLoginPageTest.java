package com.tvd.trm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.pages.TRMHomePage;
import com.tvd.trm.pages.TRMLoginPage;

public class TRMLoginPageTest extends TrmTestBase{
	TRMLoginPage loginpage;
	TRMHomePage homepage;
	
	public TRMLoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initializebrowser();
		loginpage = new TRMLoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.validateloginpagetitle();
		System.out.println("The Title of TRM Login Page is===:> "+title);
		Assert.assertEquals(title, "Login Page", "Title not found");
	}
	@Test(priority=2)
	public void hescomLogoTest(){
		Boolean flag = loginpage.validatehescomlogo();
		System.out.println("The Logo of TRM Login Page is ===:> "+flag);
		Assert.assertTrue(flag, "Login not Found");
	}
	@Test(priority=3)
	public void rapdrpTextTest(){
		String txt = loginpage.validaterapdrptxt();
		System.out.println("The Text of TRM Login Page is ===:> "+txt);
		Assert.assertEquals(txt, "R-APDRP TOTAL REVENUE MANAGEMENT SYSTEM.", "Page Text not Matched");
	}
	
	@Test(priority=4)
	public void trmLoginTest(){
		homepage = loginpage.trmLogin(property.getProperty("username"), property.getProperty("password"), property.getProperty("trmrole"));
		System.out.println("TRM Application Login Successfully");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
