Feature: Search item scenarios

  Background:
    Given user navigate to WebstaurantStore homepage
    When user input "stainless work table" in search field
    And user click on "Search" button

    @FirstRequirement
    Scenario: Search item using search feature
      Then user should see every product with "Table" in it's title

    @SecondRequirement
    Scenario: Add last found item into cart
      When user click on "last page" button
      And user click on "last item Add to Cart" button
      Then user should see "View Cart" button
      When user click on "View Cart" button
      Then user should see "Cart" on page title
      And user should see details of the added item in cart page

    @ThirdRequirement
    Scenario: Verify empty cart feature
      When user click on "last page" button
      And user click on "last item Add to Cart" button
      Then user should see "View Cart" button
      When user click on "View Cart" button
      Then user should see "Cart" on page title
      And user should see details of the added item in cart page
      When user click on "Cart" button
      And user click on "Empty Cart" button
      And user click confirm on "Empty Cart" button in the popup
      Then user should Your cart is empty. message

