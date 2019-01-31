Feature: List of Jodel feeds
  In order to see the list of feeds
  As a Jodler
  I want to access the feed list screen

  Scenario: Click a feed from the list
    Given I am in the list screen
    When I click a feed cell
    Then I see a detail list screen