
Feature: SauceDemo Order Confirmation Page

  @smoke @order
  Scenario: TC_ORDER_001 Verify order confirmation page
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user completes checkout with valid details
    Then the order confirmation page should be displayed

  @regression @order
  Scenario: TC_ORDER_002 Verify confirmation message
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user completes checkout with valid details
    Then the confirmation message should be displayed

  @regression @order
  Scenario: TC_ORDER_003 Verify order completion message
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user completes checkout with valid details
    Then the order completion message should be displayed

  @smoke @order
  Scenario: TC_ORDER_004 Verify Back Home button
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user completes checkout with valid details
    Then the Back Home button should be displayed

  @regression @order
  Scenario: TC_ORDER_005 Navigate back to products
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user completes checkout with valid details
    When the user clicks the Back Home button
    Then the products page should be displayed
