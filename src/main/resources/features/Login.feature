
Feature: SauceDemo Login Functionality

  @smoke @positive
  Scenario: LOGIN_001 Login with valid credentials
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    And the user clicks the login button
    Then the products page should be displayed

  @negative
  Scenario: LOGIN_002 Login with invalid username and password
    Given the user opens the SauceDemo login page
    When the user logs in with invalid credentials
    And the user clicks the login button
    Then the login error should contain "Username and password do not match"

  @negative
  Scenario: LOGIN_003 Login with valid username and invalid password
    Given the user opens the SauceDemo login page
    When the user logs in with a valid username and invalid password
    And the user clicks the login button
    Then the login error should contain "Username and password do not match"

  @negative
  Scenario: LOGIN_004 Login with empty username
    Given the user opens the SauceDemo login page
    When the user logs in with an empty username
    And the user clicks the login button
    Then the login error should contain "Username is required"

  @negative
  Scenario: LOGIN_005 Login with empty password
    Given the user opens the SauceDemo login page
    When the user logs in with an empty password
    And the user clicks the login button
    Then the login error should contain "Password is required"

  @negative
  Scenario: LOGIN_006 Login with locked-out user
    Given the user opens the SauceDemo login page
    When the user logs in with locked-out user credentials
    And the user clicks the login button
    Then the login error should contain "locked out"
