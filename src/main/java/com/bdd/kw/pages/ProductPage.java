package com.bdd.kw.pages;

import com.bdd.kw.propertyreader.PropertyReader;
import com.bdd.kw.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.bdd.kw.drivermanager.ManageDriver.driver;

import java.util.List;

public class ProductPage extends Utility {
	// Locators search bar send keys , click search btn
	private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

	public ProductPage() {
		// selectBrowser(PropertyReader.getInstance().getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(xpath = "//select[@name='quantity']")
	WebElement quantitySelectLink;

	@CacheLookup
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartButton;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	WebElement btnSearch;

	@CacheLookup
	@FindBy(linkText = "Angels and Demons: (Robert Langdon Book 1)")
	WebElement txtProduct;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
	WebElement txtAddCrtMsg;

	@CacheLookup
	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement btnCartQty;

	@FindBy(xpath = "//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
	public List<WebElement> cartItemList;

	public void clearCart() {
		clickOnElement(btnCartQty);
		int i = cartItemList.size();
		if (i >= 1) {
			cartItemList.get(0).click();
			i = cartItemList.size();
		}
	}
	
	public void enterProduct(String valProduct) {
		sendTextToElement(searchBox, valProduct);
		log.info("Search in the search bar" + searchBox.toString());
	}

	public void clickOnSearch() {
		log.info("Click on the Search button" + btnSearch.toString());
		clickOnElement(btnSearch);
	}

	public void clickOnProductTitle() {
		log.info("Click on the product Name" + txtProduct.toString());
		clickOnElement(txtProduct);
	}

	public void enterProductQty(int valProductQty) {

		javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(quantitySelectLink);
		selectByIndexFromDropDown(quantitySelectLink, valProductQty);
		log.info("Search in the product quantity" + valProductQty);
	}

	public void enterProductQty(String valProductQty) {
		switchToChildWindow();
		javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(quantitySelectLink);
		//clearCart();
		selectByValueFromDropDown(quantitySelectLink, valProductQty);
		log.info("Search in the product quantity" + valProductQty);
	}

	

	public void clickOnAddToCartButton() {
		log.info("Click on the addToCartButton" + addToCartButton.toString());
		clickOnElement(addToCartButton);
	}

	public void verifyThatTextIsDisplayed(String addToCartMsg) {
		verifyThatTextIsDisplayed(txtAddCrtMsg, addToCartMsg);
		log.info("Verifies add to cart text" + txtAddCrtMsg.toString());
		//closeAllWindow();
	}
	
	
}
