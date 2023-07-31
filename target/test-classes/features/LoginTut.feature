@logFeature
Feature: login Feature
  I want to test login functionality

  @login
  Scenario: Login with valid credentials
    Given user  is on Login Page
    When User enters  Login Credentials username "nivek@gmail.com" password "abcd@123"

  Scenario: Login with incorrect password
    Given user  is on Login Page
    When User enters  incorrect password "wd" and correct userName "nivek@gmail.com"
    Then user should get Error message
    
    
 Scenario: Login with incorrect userName and correct password
    Given user  is on Login Page
    When User enters  incorrect username "nks@gmail.com" and correct password "abcd@123"
    Then user should get Error message
    