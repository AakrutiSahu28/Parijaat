Feature: Dashboard
  Scenario: Dashboard Details
    Given User is on login page
    When User enters valid CP id "CP_011"
    When User clicks the Submit button
    Then login successful
    Then User waits on homepage for 5 seconds
    And User clicks on Dashboard button
    Then Dashboard details tab opens.
