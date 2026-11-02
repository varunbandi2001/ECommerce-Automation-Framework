Feature: SauceDemo Checkout

  @smoke @checkout
  Scenario: TC_CHECKOUT_001 Complete an order successfully
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user adds the Sauce Labs Backpack to the cart
    And the user opens the shopping cart
    And the user clicks the checkout button
    And the user enters checkout details "Varun", "Bandi", "500001"
    And the user continues checkout
    Then the checkout overview should be displayed
    When the user finishes the order
    Then the order confirmation should be displayed

  @regression @checkout
  Scenario: TC_CHECKOUT_002 Validate missing first name
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user adds the Sauce Labs Backpack to the cart
    And the user opens the shopping cart
    And the user clicks the checkout button
    And the user enters checkout details "", "Bandi", "500001"
    And the user continues checkout
    Then the checkout error should be displayed