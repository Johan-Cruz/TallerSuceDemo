Feature: User login on SauceDemo

  @login
  Scenario Outline: Successful login with valid user credentials
    Given the user opens the SauceDemo website
    When the user logs in with username "<username>" and password "<password>"
    Then the inventory page should be displayed

    Examples:
      | username      | password     |
      | visual_user   | secret_sauce |
      | standard_user | secret_sauce |
