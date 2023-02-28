
Feature: Verification of product price added to Amazon cart

  Scenario: The user compares the product she added to
            the cart with the price of the product on the cart page.

    Given User visits "AmazonUrl"
    When Login with a registered user
    And User searches "iphone"
    And Select any product and go to the detail page of the product
    And It is checked that the selected product is the same as the detailed product
    And It is added to the add to cart button in the product detail
    Then The basket is checked, it is checked that the price of the added product is the same as the added product
    And User closes the browser

