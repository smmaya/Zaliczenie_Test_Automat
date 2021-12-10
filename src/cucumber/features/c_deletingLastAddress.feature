Feature: Deleting Last Address

  Scenario: Deleting last created address
    Given logged in and at addresses page
    When deleting last created address
    Then logout and exit browser
