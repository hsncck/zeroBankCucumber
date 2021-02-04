Feature: Account Summary Page


  Scenario: Zero – Account summary title
    Given the user accesses Account Summary Page
    Then the user should see Zero – Account summary title


  Scenario: Account types
    Given the user accesses Account Summary Page
    Then the user should see following Account Types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Account Options
    Given the user accesses Account Summary Page
    Then the user should see following Account Types
      | Account     |
      | Credit Card |
      | Balance     |
