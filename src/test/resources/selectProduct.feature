Feature: Selecting product on page.
  descirption: Selecting specific product by using specific fitlers, and sorters.

  Scenario: user select first offer on iPhone
    Given user is on HomePage
    When user enters "iPhone" in search field
    And user clicks on search button
    Then search result page is displayed
    When user select sorting by "cena: od najwyższej"
    Then products are sorted by "cena: od najwyższej"
    When user select filters by state "używane"
    Then products are filtered by state "używane"
    When user clicks on 1 promoted product
    Then product info is correct
    And close browser
