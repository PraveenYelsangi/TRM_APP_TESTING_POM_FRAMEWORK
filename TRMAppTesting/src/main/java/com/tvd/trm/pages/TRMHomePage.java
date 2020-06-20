package com.tvd.trm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tvd.trm.base.TrmTestBase;

public class TRMHomePage extends TrmTestBase {

	@FindBy(id="ctl00_lblusername")
	WebElement validateName;
	
	@FindBy(xpath = "//a[text()='MasterInformation']")
	WebElement masterinformation;
	
	@FindBy(xpath = "//a[contains(text(),'Add User')]")
	WebElement adduser;

	@FindBy(xpath = "//a[contains(text(),'Generate Ticket')]")
	WebElement genrateticket;
	
	@FindBy(xpath = "//a[text()='Collections']")
	WebElement collection;
	
	@FindBy(xpath = "//a[contains(text(),'Manual Collection Entry')]")
	WebElement manualcollentry;

	public TRMHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateUsername() {
		return validateName.isDisplayed();
	}

	public TRMGenerateTicketPage genreateticketPage() {
		Actions action = new Actions(driver);
		action.moveToElement(masterinformation).build().perform();
		genrateticket.click();
		return new TRMGenerateTicketPage();
	}
	
	public TRMAddUserPage adduserPage() {
		Actions action = new Actions(driver);
		action.moveToElement(masterinformation).build().perform();
		adduser.click();
		return new TRMAddUserPage();
	}
	
	public TRMManualCollEntryPage manualcollentryPage() {
		Actions action = new Actions(driver);
		action.moveToElement(collection).build().perform();
		manualcollentry.click();
		return new TRMManualCollEntryPage();
	}
}
//div[@id='ctl00_ContentPlaceHolder1_GrdDisplay']//div//table//input[@type='checkbox']