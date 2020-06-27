package com.tvd.trm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tvd.trm.base.TrmTestBase;

public class TRMAddUserPage extends TrmTestBase {

	@FindBy(id = "ctl00_ContentPlaceHolder1_lblTour")
	WebElement userlable;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlselect")
	WebElement level;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCompany")
	WebElement company;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlZone")
	WebElement zone;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCircle")
	WebElement circle;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlDivision")
	WebElement division;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlsubdivision")
	WebElement subdiv1;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlgroupname")
	WebElement groupname;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtusername")
	WebElement username;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPass")
	WebElement password;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlsubd")
	WebElement subdiv2;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtemail")
	WebElement mailid;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtmobile")
	WebElement mobile;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
	WebElement approval;

	@FindBy(xpath = "//input[contains(@name,'ctl00$ContentPlaceHolder1$btnapprej')]")
	WebElement approvereject;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lblconsumerapprovalreject")
	WebElement approverejectpage;

	public TRMAddUserPage() {
		PageFactory.initElements(driver, this);
	}

	public String adduserable() {
		return userlable.getText();
	}

	public String selectlevel(String txtlevel) {
		level.click();
		Select select = new Select(level);
		select.selectByVisibleText(txtlevel);
		return txtlevel;
	}

	public void selectcompany(String txtcompany) {
		company.click();
		Select select = new Select(company);
		select.selectByValue(txtcompany);
	}

	public void selectzone(String txtzone) {
		zone.click();
		Select select = new Select(zone);
		select.selectByValue(txtzone);
	}

	public void selectlcircle(String txtcircle) {
		circle.click();
		Select select = new Select(circle);
		select.selectByValue(txtcircle);
	}

	public void selectdivision(String txtdivision) {
		division.click();
		Select select = new Select(division);
		select.selectByValue(txtdivision);
	}

	public void selectsubdivisionfirst(String txtsubdiv1) {
		subdiv1.click();
		Select select = new Select(subdiv1);
		select.selectByValue(txtsubdiv1);
	}

	public void selectgroup(String txtgroup) {
		groupname.click();
		Select select = new Select(groupname);
		select.selectByVisibleText(txtgroup);
	}

	public void username(String txtusername) {
		username.sendKeys(txtusername);
	}

	public void password(String txtpassword) {
		password.sendKeys(txtpassword);
	}

	public void selectsubdivisionsecond(String txtsubdiv2) {
		subdiv2.click();
		Select select = new Select(subdiv2);
		select.selectByVisibleText(txtsubdiv2);
	}

	public void email(String txtemail) {
		mailid.sendKeys(txtemail);
	}

	public void mobile(String txtmobile) {
		mobile.sendKeys(txtmobile);
	}

	public void addapprovelbtn() {
		approval.click();
	}

	public void approverejectbtn(String username) {
		approvereject.click();
		driver.findElement(By.xpath("//span[text()='" + username + "']/preceding::input[1]")).click();
		Select select = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlselect")));
		select.selectByVisibleText("Approval");
	}

	public String approverejectlabel() {
		approvereject.click();
		return approverejectpage.getText();
	}

}