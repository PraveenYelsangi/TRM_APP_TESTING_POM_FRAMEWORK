package com.tvd.trm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tvd.trm.base.TrmTestBase;
import com.tvd.trm.util.TestUtil;


public class TRMLoginPage extends TrmTestBase {
	TestUtil testut;
	
	// PageFactory (Object Repository)
	@FindBy(xpath="//input[@name='txtusername']")
	WebElement username;

	@FindBy(xpath = "//input[@name='txtPassword']")
	WebElement password;

	@FindBy(xpath = "//*[@id='ddlgroupname']")
	WebElement roles;

	@FindBy(id = "btnlogin")
	WebElement submit;

	@FindBy(xpath = "//img[contains(@src,'')]")
	WebElement hescomlogo;

	@FindBy(xpath = "//*[contains(text(),'R-APDRP')]")
	WebElement rapdrptext;

	// Initializing the pageObjects
	public TRMLoginPage() {
		PageFactory.initElements(driver, this);
		testut = new TestUtil();
	}

	public String validateloginpagetitle() {
		return driver.getTitle();
	}

	public boolean validatehescomlogo() {
		return hescomlogo.isDisplayed();
	}

	public String validaterapdrptxt() {
		return rapdrptext.getText();
	}

	public TRMHomePage trmLogin(String uname, String pward, String role) {
		username.sendKeys(uname);
		password.sendKeys(pward);
		roles.sendKeys(role);
		/*WebDriverWait wait = new WebDriverWait(driver,TestUtil.IMPLICIT_WAIT);
		wait.until(ExpectedConditions.alertIsPresent());
		testut.alertAccept();*/
		submit.click();
		return new TRMHomePage();
	}
}

