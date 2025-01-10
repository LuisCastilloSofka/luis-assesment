@products @regression
Feature: Product inventory functionality for Sauce Labs application

  Background:
    Given User navigates to the login page
    Given User is logged and is on the Products page of Sauce Labs application

  Scenario: Product can be added to the Cart
    When User adds the product "Sauce Labs Onesie" to the cart
    Then The product "Sauce Labs Onesie" should be displayed in the cart

  @detail
  Scenario: Remove a product from the cart
    When User adds the product "Sauce Labs Backpack" to the cart
    And User removes the product "Sauce Labs Backpack" from the product page
    Then The cart icon should not display the count of removed items

  Scenario Outline:
    When User sorts products by <sort_option>
    Then The product should be sort by <sortType> in <order>

    Examples:
      |sort_option         |sortType      |order     |
      |Name (A to Z)       |alphabetically|ascending |
      |Name (Z to A)       |alphabetically|descending|
      |Price (high to low) |price         |descending|
      |Price (low to high) |price         |ascending |

  Scenario Outline: Navigate to product detail page
    When User clicks on the product <element> for "<productName>"
    Then The product detail page for "<productName>" should be displayed

    Examples:
    |element|productName             |
    |name   |Sauce Labs Bike Light   |
    |image  |Sauce Labs Bike Light   |
    |name   |Sauce Labs Fleece Jacket|
    |image  |Sauce Labs Fleece Jacket|

  Scenario: Remove a product from the your cart page
    When User adds the product "Sauce Labs Backpack" to the cart
    And User removes the product "Sauce Labs Backpack" from the cart in detail page
    Then The product "Sauce Labs Backpack" should not be displayed in the cart