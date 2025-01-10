@login
  Feature: Login functionality for Sauce Labs application

    Background:
      Given User navigates to the login page

    Scenario: Valid Login
      When The user login with username "standard_user" and password "secret_sauce"
      Then The user should be redirected to the products page


    Scenario Outline: User cant login with invalid credentials
      Given User try to login with <user> and password <password>
      Then Access is expected to be denied with <reason>

      Examples:
        |user             |password    |reason             |
        |standard_user    |badpassword |invalid_credentials|
        |invalid_user     |secret_sauce|invalid_credentials|
        |standard_user    |            |password_missing   |
        |                 |secret_sauce|user_missing       |
        |                 |            |user_missing       |