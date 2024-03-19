Feature: Login Feature

  Scenario: Login success
    Given I open Login Page
    When I enter email "constantin@moraresco.com"
    And I enter password "Nastika20$"
    And  I submit
    Then I am Logged in