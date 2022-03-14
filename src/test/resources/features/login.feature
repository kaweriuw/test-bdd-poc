#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Amazon login functionality test

  @tag1
  Scenario: Check login with valid credentials
    Given I am on amazon page
    When I click on signin button 
    And enters valid username as "bddtester1@gmail.com "
    And clicks on continue button
    When I enters Valid password  as "1tokaFour"
    And clicks on login button
    Then I am navigated to the amazon home page "Hello, bddtester"

	@tag2
	Scenario: User should be able to search the laptop in the search bar and add to the cart
    Given I am on homepage
    And click on clear cart
    When I enter "dan brown"
    And click on search bar
    And click on the product
    And change the quantity to "3"
    And click on add to cart button
    Then verify the message displayed "Added to Cart"
  