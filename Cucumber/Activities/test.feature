@FirstTest
Feature: Basic syntax

  @FirstScenario
  Scenario: Scenario 1
    Given user is on TS Home page
    When user click on About us button
    Then user is taken to About us page
    And close the browser
