
Feature: SauceDemo Products and Shopping Cart

  @smoke @products
  Scenario: TC_PROD_001 Verify products page after login
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    Then the products page should be displayed

  @smoke @cart
  Scenario: TC_CART_001 Add a backpack to the cart
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user adds the Sauce Labs Backpack to the cart
    Then the cart badge should display "1"
    And the Add to cart button should change to Remove

  @cart
  Scenario: TC_CART_002 Verify backpack in shopping cart
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user adds the Sauce Labs Backpack to the cart
    And the user opens the shopping cart
    Then the cart should contain Sauce Labs Backpack
    And the backpack price should be displayed

  @cart @regression
  Scenario: TC_CART_003 Remove backpack from cart
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user adds the Sauce Labs Backpack to the cart
    And the user opens the shopping cart
    When the user removes the Sauce Labs Backpack from the cart
    Then the shopping cart should be empty
    And the cart badge should not be displayed

    
    
      @smoke @cart
  Scenario: TC_CART_004 Verify product details in the cart
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user adds the Sauce Labs Backpack to the cart
    And the user opens the shopping cart
    Then the cart should contain the Sauce Labs Backpack