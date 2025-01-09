@login
  Feature: Login functionality for Sauce Labs application

    Background:
      Given User navigates to the login page

      Scenario: Valid Login
        When The user login with username "standard_user" and password "secret_sauce"
        Then The user should be redirected to the products page

