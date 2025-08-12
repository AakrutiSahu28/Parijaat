Feature: login functionality

  Scenario: login with valid credentials
    Given User is on login page
   When User enters valid CP id "CP_011"
    When User clicks the Submit button
    Then login successful
