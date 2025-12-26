Feature: User Login
  As a user
  I want to login to the application
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I login with username "demouser" and password "testingisfun99"
    Then I should see the home page

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "invaliduser"
    And I enter password "invalidpassword"
    And I click the login button
    Then I should see an error message
    And the error message should contain "Invalid"

  Scenario: Login with empty credentials
    Given I am on the login page
    When I click the login button
    Then I should remain on the login page

  Scenario: Forgot password link is clickable
    Given I am on the login page
    When I click the forgot password link
    Then the forgot password link should be functional
