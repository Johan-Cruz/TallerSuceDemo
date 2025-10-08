Feature: Successful purchase process on SauceDemo

  @purchase
  Scenario: Complete a successful purchase of two products
    Given the user has logged in successfully
    When the user adds the products to the cart
    And the user completes the checkout process
    Then the confirmation message "Thank you for your order!" should be displayed
