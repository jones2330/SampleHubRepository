@Login
Feature: Verifying Adactin Hotel Login Details
@PositiveTest
  Scenario Outline: Verifying Adactin Login with Valid Credentials
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Successful Message "Hello Jones2330!"

    Examples: 
      | username  | password |
      | Jones2330 | 81SECX   |
@PositiveTest
  Scenario Outline: Verifying Adactin Login with Valid Credentials with Enter key
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>" with Enter Key
    Then User should verify Login Successful Message "Hello Jones2330!"

    Examples: 
      | username  | password |
      | Jones2330 | 81SECX   |
@NegativeTest
  Scenario Outline: Verifying Adactin Login with Invalid Credentials
    Given User is on Adactin Login Page
    When User should perform Login "<username>","<password>"
    Then User should verify Login Unsuccessful Message "Invalid Login details or Your Password might have expired. "

    Examples: 
      | username | password |
      | Jones    | 81SECX   |
