Feature: Search item scenarios

  Scenario: Search item using search feature
    Given user navigate to WebstaurantStore homepage
    When user input "stainless work table" in search field
    And user click on "Search" button
    Then user should see product with "table" in it's title