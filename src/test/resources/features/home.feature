Feature: Home Page Functionality
  As a logged-in user
  I want to interact with the home page
  So that I can navigate and manage my account

  Background: User is logged in
    Given I am on the login page
    When I login with username "demouser" and password "testingisfun99"
    Then I should see the home page

  Scenario: Verify home page displays correctly after login
    Then the home page should be displayed
    And the dashboard heading should not be empty

  Scenario: Verify welcome message is displayed
    Then I should see a welcome message
    And the welcome message should contain "Welcome"

  Scenario: Verify logout functionality
    When I click logout
    Then I should be navigated back to the login page

  Scenario: Verify navigation to profile page
    When I click on the profile link
    Then the URL should contain "profile"

  Scenario: Verify navigation to settings page
    When I click on the settings link
    Then the URL should contain "settings"
