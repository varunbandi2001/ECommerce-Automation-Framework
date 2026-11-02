
Feature: SauceDemo Logout

  @smoke @logout
  Scenario: TC_LOGOUT_001 Logout successfully
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    And the user opens the side menu
    And the user clicks logout
    Then the login page should be displayed after logout
