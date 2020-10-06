Feature: Login Functionality

  @RegressionTest
  Scenario Outline: Login with valid username and password (Positive scenario)

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then User should login successfully and redirected to appropriate page
    Examples:
      | username   | password |
      | technobank | 12345678 |


  @RegressionTest
  Scenario Outline: Login with valid username and an invalid password (Negative scenario)

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then Invalid Credential error message will display
    Examples:
      | username   | password  |
      | technobank | qwert2014 |


  @RegressionTest
  Scenario Outline: Login with invalid username and an invalid password (Negative scenario)

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then Invalid Credential error message will display

    Examples:
      | username | password  |
      | techno   | qwert2014 |


  @RegressionTest
  Scenario Outline: Login with invalid username and valid password (Negative scenario)

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then Invalid Credential error message will display
    Examples:
      | username | password |
      | asdklmn  | 12345678 |


  @RegressionTest
  Scenario Outline: Login page for both, when the field is blank and Submit button is clicked

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then Appropriate message will display
    Examples:
      | username | password |
      |          |          |


  @RegressionTest
  Scenario Outline: Login with empty username and valid/invalid password (Negative scenario)

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then Empty username message will display
    Examples:
      | username | password |
      |          | 13456    |
      |          | 12345678 |

  @RegressionTest
  Scenario Outline: Login with valid/invalid username and empty password (Negative scenario)

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then Empty password message will display
    Examples:
      | username   | password |
      | technobank |          |
      | admin200   |          |



#  @RegressionTest
#  Scenario: Login with with inactive credentials (Positive scenario)
#    Given Navigate to website
#    When Enter inactive Username and Password
#    Then User should not login successfully and error message will display