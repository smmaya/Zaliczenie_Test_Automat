Feature: Automated Tester Course - Deleting last address

  Scenario: Deleting last created address
    Given logged in and at addresses page
    When deleting last created address
    Then logout and exit browser
