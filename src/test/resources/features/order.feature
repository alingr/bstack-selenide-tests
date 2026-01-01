Feature: Order Placement
  As a user
  I want to place an order
  So that I can purchase products

  Scenario: Successfully place an order with valid user
    Given I am on the login page
    When I login with username "demouser" and password "testingisfun99"
    Then I should see the home page
    When I add a product to the cart
    And I proceed to checkout
    And I enter shipping address with the following details:
      | First Name   | Test First name      |
      | Last Name    | Test Last Name       |
      | Address      | Test Address Line 123|
      | State        | Test State Province  |
      | Postal Code  | 123456               |
    Then I should see the order confirmation message
    And the confirmation message should contain "Your Order has been successfully placed."

  Scenario: Verify existing order is displayed
    Given I am on the login page
    When I login with username "existing_orders_user" and password "testingisfun99"
    Then I should see the home page
    When I click on the orders link
    Then I should see the existing order

  Scenario: Verify date for existing order
    Given I am on the login page
    When I login with username "existing_orders_user" and password "testingisfun99"
    Then I should see the home page
    When I click on the orders link
    Then I should see the existing order
    And the order date should be "1 November, 2020"