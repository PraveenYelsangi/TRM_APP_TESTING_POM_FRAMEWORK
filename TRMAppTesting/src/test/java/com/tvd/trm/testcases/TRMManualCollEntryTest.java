package com.tvd.trm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.pages.TRMHomePage;
import com.tvd.trm.pages.TRMLoginPage;
import com.tvd.trm.pages.TRMManualCollEntryPage;
import com.tvd.trm.util.TestUtil;

public class TRMManualCollEntryTest extends TrmTestBase {
	TRMLoginPage loginpage;
	TRMHomePage homepage;
	TRMManualCollEntryPage manualcollentry;
	String sheetsname = "Manual_coll_entry";
	TestUtil testut;

	public TRMManualCollEntryTest() {
		super();
	}

	@Test(priority = 1)
	public void setUp() {
		initializebrowser();
		loginpage = new TRMLoginPage();
		homepage = new TRMHomePage();
		homepage = loginpage.trmLogin(property.getProperty("username"), property.getProperty("password"),
				property.getProperty("trmrole"));
		homepage.manualcollentryPage();
		manualcollentry = new TRMManualCollEntryPage();
		testut = new TestUtil();
	}

	@Test(priority = 2)
	public void validateradiobtn() {
		manualcollentry.isSelectedradiobtn();
	}

	@DataProvider
	public Object[][] getManualcollentrydata() {
		Object data[][] = TestUtil.gettestData(sheetsname);
		return data;
	}

	@Test(priority = 3, dataProvider = "getManualcollentrydata")
	public void enterdetails(String consid, String countername, String receiptno, String towards, String amount,
			String paymentmode, String chequeddno, String bankname, String years, String month, String day)
			throws Exception {

		manualcollentry.enterconsumerid(consid);
		manualcollentry.clicksearch();
		testut.alertAccept();
		manualcollentry.consumeridlable();
		manualcollentry.entercountername(countername);
		manualcollentry.enterreciptno(receiptno);
		manualcollentry.receiptdate();
		manualcollentry.selecttowards(towards);
		manualcollentry.clicksetcounter();
		testut.alertAccept();
		manualcollentry.enteramout(amount);
		testut.scrolldown();

		if (paymentmode.contentEquals("CASH")) {
			manualcollentry.cashradiobtn();
		} else if (paymentmode.contentEquals("CHEQUE")) {
			manualcollentry.chequeradiobtn();
			manualcollentry.enterchequeDDno(chequeddno);
			manualcollentry.selectbankname(bankname);
			manualcollentry.clickcalender();
			manualcollentry.clickcalenderyearbody();
			manualcollentry.selectyear(years);
			manualcollentry.selectmonth(month);
			manualcollentry.selectday(day);
		} else if (paymentmode.contentEquals("DD")) {
			manualcollentry.ddradiobtn();
			manualcollentry.enterchequeDDno(chequeddno);
			manualcollentry.selectbankname(bankname);
			manualcollentry.clickcalender();
			manualcollentry.clickcalenderyearbody();
			manualcollentry.selectyear(years);
			manualcollentry.selectmonth(month);
			manualcollentry.selectday(day);

		} else if (paymentmode.contentEquals("MONEYORDER")) {
			manualcollentry.moneyorderradiobtn();

		} else {
			System.out.println("Your Payment mode is incorrect, your choose Payment mode is: " + paymentmode);
		}
	}

	@AfterMethod
	public void tear() {
		// driver.close();
	}
}