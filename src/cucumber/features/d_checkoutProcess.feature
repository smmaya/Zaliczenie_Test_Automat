Feature: Checkout process A-Z

  Scenario Outline: Adding article to basket and getting through the checkout process
    Given existing user is successfully logged in
    When clicked on Clothes link in the upper menu
    Then page with clothing articles is displayed
    When selecting a Hummingbird Printed Sweater article
    Then that article's details page is displayed
    And checking if discount is applied correctly
    When selecting "<Size>" from the dropdown box
    Then the "<M>" size is selected
    When changing "<Quantity>" to "<5>" and clicking Add to Cart button
    Then a popup window with selected stuff appears
    When clicking on Proceed to Checkout button
    Then redirected ot the cart page
    When selecting Proceed to Checkout button
    Then address selection page is displayed
    When clicking Continue with a selected address
    And clicking Continue with selected PrestaShop delivery
    And checking Pay By Check selector
    And agreeing with the terms of service
    And clicking on Order With An Obligation To Pay button
    Then order confirmation page is displayed
    And centering the page and taking a screenshot
    When clicking on the user's name
    And clicking on the Order History and Details button
    Then Orders History page is displaying a list of orders
    And check the status name as Awaiting Check Payment of the latest order
    And check the total amount of the latest order
    Examples:
      | Size | Quantity |
      | M    | 5        |






