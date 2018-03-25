Feature: Automated tests for Rakuten.de

  Scenario: Verify search results are listed
    Given I am on rakuten homepage
    When I insert "mobile" in the search bar
    And I select any item from the autocomplete list
    Then Search results page should be opened

  Scenario: Select payment method successfully
    Given I am on rakuten homepage
    When I insert "home" in the search bar
    And I select any item from the autocomplete list
    And I select any product from the search result page
    And I add the product to the Shopcart
    And I proceed to checkout page
    And I proceed with my client profile
    Then Payment methods selection page should be displayed


