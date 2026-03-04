Feature: Errror Validation
I want to use this template for my feature file

 @ErrorValidation
 Scenario Outline: Error Validation Test
 Given I landed on Ecommerce website page
 When Logged in with username <name> and <password>
 Then "Incorrect email or password." message is displayed.
 
 Examples:
    | name                         | password   |
    |chandujadhav96k+1204@gmail.com| Hellotest  |
