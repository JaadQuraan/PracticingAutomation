Feature: Google Search Functionality Title Validation
  User Story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information


@google
  Scenario: Search functionality result title validation
    Given user is on Google search page
    When user types "I like Java" in the google search box and clicks enter
    Then user should see "I like Java - Google Search" in the google title

  Scenario: Search functionality result title validation
    Given user is on Google search page
    When user types "Jaad likes java" in the google search box and clicks enter
    Then user should see "Jaad likes java - Google Search" in the google title




