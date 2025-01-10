@checkout
Feature: Checkout functionality for Sauce Labs application

  Background:
    Given User navigates to the login page
    Given User is logged and is on the Products page of Sauce Labs application

  Scenario: Verify all field are required
    Given User is on the checkout page
    When User clicks on the "Continue" button
    Then An error message "Error: First Name is required" should be displayed
    And User fills in the "First Name" field with "John"
    And User clicks on the "Continue" button
    Then An error message "Error: Last Name is required" should be displayed
    And User fills in the "Last Name" field with "Doe"
    And User clicks on the "Continue" button
    Then An error message "Error: Postal Code is required" should be displayed

  Scenario:
    When User adds the following products to the cart:
    |Product Name            |Price|
    |Sauce Labs Backpack     |29.99|
    |Sauce Labs Onesie       |7.99 |
    |Sauce Labs Bolt T-Shirt |15.99|
    And User proceeds to the Checkout : Overview Page
    Then The item total should be "$53.97"

  Scenario:
    Given User proceeds to the Checkout : Overview Page
    When User clicks on the "Finish" button
    Then The order confirmation page should be displayed
    And The message "Thank you for your order!" should be shown








