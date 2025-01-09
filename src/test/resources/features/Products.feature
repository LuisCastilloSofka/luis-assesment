@products
Feature: Product inventory functionality for Sauce Labs application

  Background:
    Given User navigates to the login page
    Given User is logged and is on the Products page of Sauce Labs application

  Scenario: Product can be added to the Cart
    When User adds the product "Sauce Labs Onesie" to the cart
    Then The product "Sauce Labs Onesie" should be displayed in the cart

    Scenario: Remove a product from the cart
      When User adds the product "Sauce Labs Backpack" to the cart
      And User removes the product "Sauce Labs Backpack" from the cart
      Then The product "Sauce Labs Backpack" should not be displayed in the cart