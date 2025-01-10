@checkout
Feature: Checkout functionality for Sauce Labs application

  Background:
    Given User navigates to the login page
    Given User is logged and is on the Products page of Sauce Labs application
    Given User is on the checkout page

  Scenario: Verify all field are required
    When User clicks on the "Continue" button
    Then An error message "Error: First Name is required" should be displayed
    And User fills in the "First Name" field with "John"
    And User clicks on the "Continue" button
    Then An error message "Error: Last Name is required" should be displayed
    And User fills in the "Last Name" field with "Doe"
    And User clicks on the "Continue" button
    Then An error message "Error: Postal Code is required" should be displayed




