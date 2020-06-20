package com.tvd.trm.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tvd.trm.base.TrmTestBase;

public class TRMManualCollEntryPage extends TrmTestBase {

	@FindBy(id = "ctl00_ContentPlaceHolder1_Rblmanual_0")
	WebElement entryradiobtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtConsumerID")
	WebElement consid;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSearchconsumerIdwise")
	WebElement search;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lblconsid")
	WebElement considlable;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtCounter")
	WebElement counter;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtrecieptnum")
	WebElement receiptno;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtreceiptdate")
	WebElement reciptdate;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddltowards")
	WebElement towards;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnset")
	WebElement setcounter;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtamountPaid")
	WebElement amountpaid;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rblPaymentmode_0")
	WebElement cash;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rblPaymentmode_1")
	WebElement chequebtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rblPaymentmode_2")
	WebElement ddbtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtCheqNum")
	WebElement chequeddnum;

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlBanklist")
	WebElement banklist;

	@FindBy(id = "ctl00_ContentPlaceHolder1_imgChqdate")
	WebElement chequedddate;

	@FindBy(xpath = "//div[contains(@class,'ajax__calendar_title')]")
	WebElement years;

	/*
	 * @FindBy(xpath =
	 * "//tbody[@id='ctl00_ContentPlaceHolder1_CalExtCheqDate_yearsBody']")
	 * String yearsbody;
	 * 
	 * @FindBy(xpath =
	 * "//table[@id='ctl00_ContentPlaceHolder1_CalExtCheqDate_monthsTable']")
	 * String monthbody;
	 * 
	 * @FindBy(xpath =
	 * "//table[@id='ctl00_ContentPlaceHolder1_CalExtCheqDate_daysTable']")
	 * String daysbody;
	 */

	@FindBy(id = "ctl00_ContentPlaceHolder1_rblPaymentmode_3")
	WebElement moneyorderbtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUpdate")
	WebElement submitbtn;

	public TRMManualCollEntryPage() {
		PageFactory.initElements(driver, this);
	}

	public void isSelectedradiobtn() {
		boolean radiobtn = entryradiobtn.isDisplayed();
		System.out.println("Entry Radio button is Displayed: " + radiobtn);
		boolean enableradiobtn = entryradiobtn.isEnabled();
		System.out.println("Entry Radio button is Enabled: " + enableradiobtn);
	}

	public void enterconsumerid(String consno) {
		consid.clear();
		consid.sendKeys(consno);
	}

	public void clicksearch() {
		search.click();
	}

	public void consumeridlable() {
		boolean conslbl = considlable.isDisplayed();
		System.out.println("The Searched Consumer ID is Displayed: " + conslbl);
	}

	public void entercountername(String countername) {
		if (counter.isEnabled()) {
			counter.clear();
			counter.sendKeys(countername);
		} else {
			System.out.println("Counter text box is disabled");
		}
	}

	public void enterreciptno(String recipt) {
		if (receiptno.isEnabled()) {
			receiptno.clear();
			receiptno.sendKeys(recipt);
		} else {
			System.out.println("Receipt no text box is disabled");
		}
	}

	public void receiptdate() {
		if (reciptdate.isEnabled()) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			reciptdate.clear();
			reciptdate.sendKeys(date1);
		} else {
			System.out.println("Date text box is disabled");
		}
	}

	public void selecttowards(String revenuetowards) {
		if (towards.isEnabled()) {
			Select select = new Select(towards);
			select.selectByVisibleText(revenuetowards);
		} else {
			System.out.println("Drop down is Disabled");
		}
	}

	public void clicksetcounter() {
		setcounter.click();
	}

	public void enteramout(String amount) {
		amountpaid.clear();
		amountpaid.sendKeys(amount);
	}

	public void cashradiobtn() {
		boolean enableradiobtn = cash.isEnabled();
		System.out.println("Cash Radio button is Enabled: " + enableradiobtn);
		// cash.click();
		boolean selectradiobtn = cash.isSelected();
		System.out.println("Cash Radio button is Selected: " + selectradiobtn);
	}

	public void chequeradiobtn() {
		boolean enableradiobtn = chequebtn.isEnabled();
		System.out.println("Cheque Radio button is Enabled: " + enableradiobtn);
		chequebtn.click();
		boolean selectradiobtn = chequebtn.isSelected();
		System.out.println("Cheque Radio button is Selected: " + selectradiobtn);
	}

	public void ddradiobtn() {
		boolean enableradiobtn = ddbtn.isEnabled();
		System.out.println("DD Radio button is Selected: " + enableradiobtn);
		ddbtn.click();
		boolean selectradiobtn = chequebtn.isSelected();
		System.out.println("DD Radio button is Selected: " + selectradiobtn);
	}

	public void enterchequeDDno(String ddcheque) {
		chequeddnum.clear();
		chequeddnum.sendKeys(ddcheque);
	}

	public void selectbankname(String bank) {
		Select select = new Select(banklist);
		select.selectByVisibleText(bank);
	}

	public void clickcalender() {
		chequedddate.click();
	}

	public void clickcalenderyearbody() {
		years.click();
		years.click();
	}

	public void selectyear(String year) {
		WebElement date = driver
				.findElement(By.xpath("//tbody[@id='ctl00_ContentPlaceHolder1_CalExtCheqDate_yearsBody']"));
		List<WebElement> row = date.findElements(By.tagName("tr"));
		List<WebElement> col = date.findElements(By.tagName("td"));
		for (WebElement cell : col) {
			String date1 = cell.getText();
			//System.out.println(date1);
			if (date1.equals(year)) {
				cell.findElement(By.xpath("//div[contains(@class,'ajax__calendar_years')]//div[text()='" + year + "']"))
						.click();
				//System.out.println(cell.isDisplayed());
			}
		}
	}

	public void selectmonth(String month) {
		WebElement date = driver
				.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_CalExtCheqDate_monthsTable']"));
		List<WebElement> row = date.findElements(By.tagName("tr"));
		List<WebElement> col = date.findElements(By.tagName("td"));
		for (WebElement cell : col) {
			String date1 = cell.getText();
			//System.out.println(date1);
			if (date1.equals(month)) {
				cell.findElement(
						By.xpath("//div[contains(@class,'ajax__calendar_month')]//div[text()='" + month + "']"))
						.click();
				//System.out.println(cell.isDisplayed());
			}
		}
	}

	public void selectday(String days) {
		WebElement date = driver
				.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_CalExtCheqDate_daysTable']"));
		List<WebElement> row = date.findElements(By.tagName("tr"));
		List<WebElement> col = date.findElements(By.tagName("td"));
		for (WebElement cell : col) {
			String date1 = cell.getText();
			//System.out.println(date1);
			if (date1.equals(days)) {
				cell.findElement(By.xpath("//div[contains(@class,'ajax__calendar_day')]//div[text()='" + days + "']"))
						.click();
				//System.out.println(cell.isDisplayed());
			}
		}
	}

	public void moneyorderradiobtn() {
		boolean enableradiobtn = moneyorderbtn.isEnabled();
		System.out.println("Money Order Radio button is Enabled: " + enableradiobtn);
		moneyorderbtn.click();
		boolean selectradiobtn = moneyorderbtn.isSelected();
		System.out.println("Money Order Radio button is Selected: " + selectradiobtn);
	}

	public void submitbtnclick() {
		submitbtn.click();
	}

}
