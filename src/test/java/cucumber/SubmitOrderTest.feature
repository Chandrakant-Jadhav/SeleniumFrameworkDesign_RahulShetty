Feature: Purchase the order from Ecommerce Website
Background:
Given I landed on Ecommerce website page

  Scenario Outline: Postive Test of Submitting the order
    Given Logged in with username <name> and <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation
    
    Examples:
    | name                         | password   |productName    |
    |chandujadhav96k+1204@gmail.com| Hello123@  |ADIDAS ORIGINAL|
    