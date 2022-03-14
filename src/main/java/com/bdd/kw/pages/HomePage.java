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

public class HomePage extends Utility {
	// Locators search bar send keys laptop, click search btn
	private static final Logger log = LogManager.getLogger(HomePage.class.getName());

	public HomePage() {
		selectBrowser(PropertyReader.getInstance().getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement SearchbarLink;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	WebElement searchLink;

	@CacheLookup
	@FindBy(partialLinkText="Hello, Sign in")
	//@FindBy(xpath = "//span[text()='Sign in']")
	WebElement btnSignIn;
	
	
	
	public void clickOnSignIn() {
		log.info("Click on the Sign in button" + btnSignIn.toString());
		clickOnElement(btnSignIn);
		
	}
	
	public void searchProduct(String product) {
		sendTextToElement(SearchbarLink, product);
		log.info("Search in the search bar" + SearchbarLink.toString());
	}

	public void clickOnSearch() {
		clickOnElement(searchLink);
		log.info("Click on the search button" + searchLink.toString());
	}
}
