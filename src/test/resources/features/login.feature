
Feature: login

  Scenario: Login as a user
    Given login with valid input
    Then the user should be able to login

  Scenario: Login with invalid username
    Given login with invalid username input
    Then the user should not be able to login
    Then the user should see warning message

  Scenario: Login with invalid password
    Given login with invalid password input
    Then the user should not be able to login
    Then the user should see warning message
  @login
  Scenario: Login without any input
    Given login without any input
    Then the user should not be able to login
    Then the user should see warning message




