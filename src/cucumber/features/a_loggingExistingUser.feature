Feature: Automated Tester Course - Logging in

  Scenario: Logging in to https://mystore-testlab.coderslab.pl
    Given login form is open
    When login form is filled out
    Then user is successfully logged in
    And go to Addresses to add a new address
