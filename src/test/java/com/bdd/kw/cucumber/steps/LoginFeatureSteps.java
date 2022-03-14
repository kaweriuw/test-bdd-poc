package com.bdd.kw.cucumber.steps;

import com.bdd.kw.pages.HomePage;
import com.bdd.kw.pages.ProductPage;
import com.bdd.kw.pages.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureSteps {

	// Sign In Page
	
	@Given("I am on amazon page")
	public void iAmOnHomepage() {
		System.out.println("I am on homepage");
	}
	
	@When("I click on signin button")
	public void iClickOnSignIn() {
		new HomePage().clickOnSignIn();
	}

	@And("enters valid username as {string}")
	public void iEnterUserName(String userName) {
		new SignInPage().enterUserName(userName);
	}
	
	@And("clicks on continue button")
	public void iClickOnContnue() {
		new SignInPage().clickOnContinue();
	}

	@When("I enters Valid password  as {string}")
	public void iEnterPassword(String password) {
		new SignInPage().enterPassword(password);
	}
	
	@And("clicks on login button")
	public void iClickOnLogin() {
		new SignInPage().clickOnLogin();
	}
	@Then("I am navigated to the amazon home page {string}")
	public void iVerifyHomePage(String loginMsg) {
		new SignInPage().verifyThatTextIsDisplayed(loginMsg);
	}
	
   // Product Page	
	
	@Given("I am on homepage")
	public void iAmOnAmazonHomepage() {
		System.out.println("I am on homepage");
	}
	
	@And("click on clear cart")
	public void iClickOnClearCart() {
		new ProductPage().clearCart();
	}
	
	@When("I enter {string}")
	public void iEnter(String product) {
		new ProductPage().enterProduct(product);
	}
	
	@And("click on search bar")
	public void iClickOnSeachBar() {
		new ProductPage().clickOnSearch();
	}
	
	@And("click on the product")
	public void iClickOnProductTitle() {
		new ProductPage().clickOnProductTitle();
	}
	
	@And("change the quantity to {string}")
	public void iEnterProductQnty(String valProductQty) {
		new ProductPage().enterProductQty(valProductQty);
	}
	
	@And("click on add to cart button")
	public void iClickOnAddToCart() {
		new ProductPage().clickOnAddToCartButton();
	}
	
	@Then("verify the message displayed {string}")
	public void iVerifyAddToCart(String addToCartMsg) {
		new ProductPage().verifyThatTextIsDisplayed(addToCartMsg);
	//	new ProductPage().closeAllWindow();
	}
}

