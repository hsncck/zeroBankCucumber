Feature: Pay Bills Functionality

  Background:
    Given the user is logged in

  Scenario: Zero – Pay Bills Title
    Given the user accesses the Pay Bills tab
    When the user should see Zero – Pay Bills

  Scenario: Pay operation
    Given the user accesses the Pay Bills tab
    When the user should see Zero – Pay Bills
    Then the user should enters payment info
    And the user should see submit message

  Scenario: Payment without entering the amount or date
    Given the user accesses the Pay Bills tab
    When the user should see Zero – Pay Bills
    Then the user should enters without any input
    And the user should see Please fill out message

  Scenario: Amount field should not accept alphabetical or special characters
    Given the user accesses the Pay Bills tab
    When the user should see Zero – Pay Bills
    Then the user should enters amount field alphabetical char
    And the user should not see submit message
  @wip
  Scenario: Date field should not accept alphabetical characters
    Given the user accesses the Pay Bills tab
    When the user should see Zero – Pay Bills
    Then the user should enters date field alphabetical char
    And the user should see error message


