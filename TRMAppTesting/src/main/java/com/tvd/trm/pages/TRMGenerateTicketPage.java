package com.tvd.trm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.tvd.trm.base.TrmTestBase;

public class TRMGenerateTicketPage extends TrmTestBase {

	@FindBy(id = "ctl00_ContentPlaceHolder1_lblGenerateTicket")
	WebElement ticketlable;

	@FindBy(id = "ctl00_ContentPlaceHolder1_drpPriority")
	WebElement priority;

	@FindBy(id = "ctl00_ContentPlaceHolder1_drpSEVIRITY")
	WebElement sevirity;

	@FindBy(id = "ctl00_ContentPlaceHolder1_drpAssign")
	WebElement assignTo;

	@FindBy(id = "ctl00_ContentPlaceHolder1_drpHescom")
	WebElement complainttype;

	@FindBy(id = "ctl00_ContentPlaceHolder1_drpStatus1")
	WebElement status;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtTitle")
	WebElement titletext;

	@FindBy(id = "ctl00_ContentPlaceHolder1_txtDescription")
	WebElement descrip;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtdesc")
	WebElement narration;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnUpload")
	WebElement submit;
	

	//constructor of currentpage to initialize Propeties file
	public TRMGenerateTicketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String genticketlable() {
		return ticketlable.getText();

	}
	
	public void selectpriority(String txtpriority) {
		priority.click();
		Select select = new Select(priority);
		select.selectByVisibleText(txtpriority);
	}

	public void selectsevirity(String txtsevirity) {
		sevirity.click();
		Select select = new Select(sevirity);
		select.selectByVisibleText(txtsevirity);
	}

	public void selectassignTo(String txtassignTo) {
		assignTo.click();
		Select select = new Select(assignTo);
		select.selectByVisibleText(txtassignTo);
	}

	public void selectcomplaintype(String txtcomplaintype) {
		complainttype.click();
		Select select = new Select(complainttype);
		select.selectByVisibleText(txtcomplaintype);
	}

	public void selectstatus(String txtstatus) {
		status.click();
		Select select = new Select(status);
		select.selectByVisibleText(txtstatus);
	}

	public void entertitle(String txttitle) {
		titletext.sendKeys(txttitle);
	}

	public void enterdesc(String txtdescrip) {
		descrip.sendKeys(txtdescrip);
	}
	
	public void uploadfile(String uploadingfile) {
		WebElement ele =  driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_fUpload']"));
		ele.sendKeys(uploadingfile);
	}
	
	public void enternarrnation(String txtnarration) {
		narration.sendKeys(txtnarration);
	}
	
	public void submitticket(){
		submit.click();
	}

}
