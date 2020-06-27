package com.tvd.trm.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.pages.TRMGenerateTicketPage;
import com.tvd.trm.pages.TRMHomePage;
import com.tvd.trm.pages.TRMLoginPage;
import com.tvd.trm.util.TestUtil;

public class TRMGenTicketPageTest extends TrmTestBase {
	TRMLoginPage loginpage;
	TRMHomePage homepage;
	TRMGenerateTicketPage ticketpage;
	String sheetsname = "Generate_ticket_data";
	TestUtil testut;

	public TRMGenTicketPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initializebrowser();
		loginpage = new TRMLoginPage();
		homepage = new TRMHomePage();
		homepage = loginpage.trmLogin(property.getProperty("username"), property.getProperty("password"),
				property.getProperty("trmrole"));
		homepage.genreateticketPage();
		ticketpage = new TRMGenerateTicketPage();
		testut = new TestUtil();
	}

	@Test(priority = 1)
	public void validatelableTest() {
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		String flag = ticketpage.genticketlable();
		System.out.println("This is a: " + flag);
		Assert.assertEquals(flag, "GENERATE TICKET", "Lable not matched");
	}

	@DataProvider
	public Object[][] getTestTicketdata() {
		Object data[][] = TestUtil.gettestData(sheetsname);
		return data;
	}

	@Test(priority = 2, dataProvider = "getTestTicketdata")
	public void enterTicketValueTest(String Priority, String Severity, String Assign_To, String Type_Of_Complaint,
			String Status, String Title, String Description, String Narration, String fileupload) {
		ticketpage.selectpriority(Priority);
		ticketpage.selectsevirity(Severity);
		ticketpage.selectassignTo(Assign_To);
		ticketpage.selectcomplaintype(Type_Of_Complaint);
		ticketpage.selectstatus(Status);
		ticketpage.entertitle(Title);
		ticketpage.enterdesc(Description);
		ticketpage.enternarrnation(Narration);

		ticketpage.uploadfile(fileupload);
		//ticketpage.submitticket();
		//testut.alertAccept();
		//System.out.println("Ticket Generate Successfully");
	}

	@AfterMethod()
	public void teardown() {
		//driver.quit();
	}
}