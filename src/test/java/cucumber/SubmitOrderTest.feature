@tag
Feature: Purchase the order from Ecommerce Website
Background:
Given I landed on Ecommerce website page

  @Regression
  Scenario Outline: Postive Test of Submitting the order
    Given Logged in with username <name> and <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "Order Placed Successfully" message is displayed on confirmation page
    
    Examples:
    | name                         | password   |productName    |
    |chandujadhav96k+1204@gmail.com| Hello123@  |ADIDAS ORIGINAL|
    