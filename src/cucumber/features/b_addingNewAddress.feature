Feature: Adding New Address

  Scenario Outline: Adding a new address
    Given user logged in and at the Addresses page
    When clicking the link Create New Address
    Then fill out and save the form "<alias>" "<street>" "<city>" "<zipCode>" "<country>" "<phone>"
    And check if the newly created address "<alias>" is correct
    Examples:
      | alias          | street          | city     | zipCode | country        | phone      |
      | second address | Jagiellońska 28 | Gdańsk   | 80-555  | United Kingdom | 1231231230 |
