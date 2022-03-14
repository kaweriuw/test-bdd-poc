package com.bdd.kw.pages;

import com.bdd.kw.propertyreader.PropertyReader;
import com.bdd.kw.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bdd.kw.drivermanager.ManageDriver.driver;

public class SignInPage extends Utility {
	// Locators search bar send keys laptop, click search btn
	private static final Logger log = LogManager.getLogger(SignInPage.class.getName());

	public SignInPage() {
		//selectBrowser(PropertyReader.getInstance().getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath="//input[@name='email']")
	//@FindBy(name="email")
	WebElement txtUserName;
	
	@CacheLookup
	@FindBy(id="continue")
	WebElement btnContinue;
	
	@CacheLookup
	@FindBy(id="signInSubmit")
	WebElement btnLogin;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement txtPassword;
	
	@CacheLookup
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement txtLoggedInUser;
	
	public void clickOnContinue() {
		log.info("Click on the Sign in button" + btnContinue.toString());
		clickOnElement(btnContinue);
		
	}
	
	public void enterUserName(String valUserName) {
		sendTextToElement(txtUserName, valUserName);
		log.info("Search in the search bar" + txtUserName.toString());
	}

	public void enterPassword(String valPassword) {
		sendTextToElement(txtPassword, valPassword);
		log.info("Search in the search bar" + txtPassword.toString());
	}
	
	public void clickOnLogin() {
		log.info("Click on the Sign in button" + btnLogin.toString());
		clickOnElement(btnLogin);
	}
	
	public void verifyThatTextIsDisplayed(String loginMsg)
    {
        verifyThatTextIsDisplayed(txtLoggedInUser, loginMsg);
        log.info( "Verifies add to cart text" + txtLoggedInUser.toString());
    }


}
