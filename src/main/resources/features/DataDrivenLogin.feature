
Feature: Data Driven Login Testing

  @regression @datadriven
  Scenario Outline: Verify login with different credentials
    Given the user opens the SauceDemo login page
    When the user enters username "<username>" and password "<password>"
    And the user clicks the login button
    Then the login result should be "<result>"

    Examples:
      | username        | password     | result  |
      | standard_user   | secret_sauce | success |
      | invalid_user    | secret_sauce | failure |
      | standard_user   | wrong_pass   | failure |
      | locked_out_user | secret_sauce | failure |

