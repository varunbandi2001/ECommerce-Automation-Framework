
Feature: SauceDemo Product Sorting

  Background:
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button

  @smoke @sorting
  Scenario: TC_SORT_001 Sort products A to Z
    When the user sorts products by "Name (A to Z)"
    Then products should be displayed in alphabetical order

  @regression @sorting
  Scenario: TC_SORT_002 Sort products Z to A
    When the user sorts products by "Name (Z to A)"
    Then products should be displayed in reverse alphabetical order

  @regression @sorting
  Scenario: TC_SORT_003 Sort products by price low to high
    When the user sorts products by "Price (low to high)"
    Then products should be displayed from lowest price to highest price

  @regression @sorting
  Scenario: TC_SORT_004 Sort products by price high to low
    When the user sorts products by "Price (high to low)"
    Then products should be displayed from highest price to lowest price
