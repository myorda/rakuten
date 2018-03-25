Feature: Automated tests for Rakuten.de

  Scenario: Verify search results are listed
    Given I am on Rakuten homepage
    When I insert "mobile" in the search bar
    And I select any item from the autocomplete list
    Then Search results page should be opened

  Scenario: Select payment method successfully
    Given I am on Rakuten homepage
    When I insert "home" in the search bar
    And I select any item from the autocomplete list
    And I select any product from the search result page
    And I add the product to the Shopcart
    And I proceed to checkout page
    And I proceed with my client profile
    Then Payment methods selection page should be displayed

#    Automated acceptance tests for Login
  Scenario: Verify user can login successfully
    Given I am on Rakuten customer account page
    When I login with "mblg@mail.bg" and "Password@2"
    Then I should be successfully logged in

  Scenario: Verify user is not logged in with wrong password
    Given I am on Rakuten customer account page
    When I login with "mblg@mail.bg" and "Password@1"
    Then user is not logged in and error message "Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe." is displayed

  Scenario: Verify user is not logged in with empty credentials
    Given I am on Rakuten customer account page
    When I login with "" and ""
    Then user is not logged in and error message "Bitte überprüfen Sie Ihre Eingaben." is displayed

  Scenario: Verify user is not logged in with empty password
    Given I am on Rakuten customer account page
    When I login with "mblg@mail.bg" and ""
    Then user is not logged in and error message "Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe." is displayed


