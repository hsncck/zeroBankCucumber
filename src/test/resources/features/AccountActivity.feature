Feature: Accounts Activity Info

  Background:
    Given the user is logged in

  Scenario: Verify title Zero – Account activity

    When the user clicks on Account Activity page
    Then the Account Activity page should be displayed


  Scenario: Default option should be Savings

    When the user clicks on Account Activity page
    Then the Account Activity page should be displayed
    And Account drop down should have Savings selected


  Scenario: Dropdown options should be displayed

    When the user clicks on Account Activity page
    Then the Account Activity page should be displayed
    And Following dropdown should be displayed
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  @wip
  Scenario: Transactions tabled options

    When the user clicks on Account Activity page
    Then the Account Activity page should be displayed
    And Following options should be displayed
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |



