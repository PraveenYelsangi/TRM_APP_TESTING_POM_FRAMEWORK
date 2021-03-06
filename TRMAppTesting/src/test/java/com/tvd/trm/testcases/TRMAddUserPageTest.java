package com.tvd.trm.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.pages.TRMAddUserPage;
import com.tvd.trm.pages.TRMHomePage;
import com.tvd.trm.pages.TRMLoginPage;
import com.tvd.trm.util.TestUtil;

public class TRMAddUserPageTest extends TrmTestBase {
	TRMLoginPage loginpage;
	TRMHomePage homepage;
	TRMAddUserPage adduser;
	String sheetsname = "Add_User";
	Logger logger =  Logger.getLogger(TRMAddUserPageTest.class);

	public TRMAddUserPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initializebrowser();
		loginpage = new TRMLoginPage();
		homepage = new TRMHomePage();
		homepage = loginpage.trmLogin(property.getProperty("username"), property.getProperty("password"),
				property.getProperty("trmrole"));
		homepage.adduserPage();
		adduser = new TRMAddUserPage();
	}

	@Test(priority = 1)
	public void validateadduserTest() {
		logger.info("------------------->> Start AddUserPage Test <<-------------------");
		String addusertext = adduser.adduserable();
		Assert.assertEquals(addusertext, "ADD USER DETAILS", "Add User lable not matched :==>");
		logger.info("Validated Add User text and the text is: " + addusertext);
	}

	// Get Test data for AddUser form
	@DataProvider
	public Object[][] getAddUserdata() {
		Object data[][] = TestUtil.gettestData(sheetsname);
		return data;
	}

	// Passing Values to AddUSer form level wise
	@Test(priority = 2, dataProvider = "getAddUserdata")
	public void enteradduserValueTest(String level, String company, String zone, String circle, String division,
			String subdivfirst, String groupname, String username, String password, String subdivsecond, String emailid,
			String mobileno) throws Exception {
		if (level.contentEquals("COM")) {
			adduser.selectlevel(level);
			adduser.selectcompany(company);
			adduser.selectgroup(groupname);
			adduser.username(username);
			adduser.password(password);
			adduser.email(emailid);
			adduser.mobile(mobileno);
		} else if (level.contentEquals("ZONE")) {
			adduser.selectlevel(level);
			adduser.selectcompany(company);
			adduser.selectzone(zone);
			adduser.selectgroup(groupname);
			adduser.username(username);
			adduser.password(password);
			adduser.email(emailid);
			adduser.mobile(mobileno);
		} else if (level.contentEquals("CIRCLE")) {
			adduser.selectlevel(level);
			adduser.selectcompany(company);
			adduser.selectzone(zone);
			adduser.selectlcircle(circle);
			adduser.selectgroup(groupname);
			adduser.username(username);
			adduser.password(password);
			adduser.email(emailid);
			adduser.mobile(mobileno);
		} else if (level.contentEquals("DIV")) {
			adduser.selectlevel(level);
			adduser.selectcompany(company);
			adduser.selectzone(zone);
			adduser.selectlcircle(circle);
			adduser.selectdivision(division);
			adduser.selectgroup(groupname);
			adduser.username(username);
			adduser.password(password);
			adduser.email(emailid);
			adduser.mobile(mobileno);
		} else if (level.contentEquals("SUBDIV")) {
			adduser.selectlevel(level);
			adduser.selectcompany(company);
			adduser.selectzone(zone);
			adduser.selectlcircle(circle);
			adduser.selectdivision(division);
			adduser.selectsubdivisionfirst(subdivfirst);
			adduser.selectgroup(groupname);
			adduser.username(username);
			adduser.password(password);
			adduser.selectsubdivisionsecond(subdivsecond);
			adduser.email(emailid);
			adduser.mobile(mobileno);
		} else {

			System.out.println("The Level doesn't exists, Your entered level is: " + level);
		}
		logger.info("The Selected Level is: " + level);
		logger.info(" Level:" + level + " Company:" + company + " Zone:" + zone + " Circle:" + circle + " Division:"
				+ division + " Sub-division:" + subdivfirst + " Group:" + groupname + " Username:" + username
				+ " Password:" + password + " Sub-division2:" + subdivsecond + " E-mail:" + emailid + " Mobile no:"
				+ mobileno);

		// adduser.addapprovelbtn();
	}

	@Test(priority = 3)
	public void validateapproveRejectlabelTest() {
		String approvalreject = adduser.approverejectlabel();
		Assert.assertEquals(approvalreject, "User Approval/Reject", "Approve/reject lable not matched");
		logger.info("Validated Approval/Reject Page and the text is: " + approvalreject);
	}

	// Add same Username name manually which is used in above method excel sheet
	@Test(priority = 4, dataProvider = "getAddUserdata")
	public void userApproveRejectTest(String level, String company, String zone, String circle, String division,
			String subdivfirst, String groupname, String username, String password, String subdivsecond, String emailid,
			String mobileno) {
		adduser.approverejectbtn(username);
		logger.info("Approval UserName is: " + username);
		logger.info("------------------->> End AddUserPage Test <<-------------------");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

// span[contains(.,'rajesh')]/preceding::input[1]
// span[text()='Praveen']/preceding::input[1]