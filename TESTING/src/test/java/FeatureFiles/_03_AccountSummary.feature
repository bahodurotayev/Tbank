Feature: Account Summary Page

  @RegressionTest
  Scenario Outline: Account Summary Page Functionality

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then User should login successfully and redirected to appropriate page
    When Title of the page is not empty
    Then Title of the page contains "Account Page"
    And Account Page contains Account number and Customer information
    Then Click on Initiate transaction button and redirected

    Examples:
      | username   | password |
      | technobank | 12345678 |


  @RegressionTest
  Scenario Outline: Account Headers Functionality

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then User should login successfully and redirected to appropriate page
    And Account Page displays all headers

    Examples:
      | username   | password |
      | technobank | 12345678 |


  @RegressionTest
  Scenario Outline: Account Balance Functionality

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then User should login successfully and redirected to appropriate page
    And Account Page displays correct Balance information

    Examples:
      | username   | password |
      | technobank | 12345678 |


  @RegressionTest
  Scenario Outline: Transaction History Functionality

    Given Navigate to website
    When Entering  "<username>" and "<password>" credentials
    Then User should login successfully and redirected to appropriate page
    And Verify table contains correct "table_header_List"
    And Verify table columns are not empty
      | list_of_table_elements |
    And Transaction amounts have valid format

    Examples:
      | username   | password |
      | technobank | 12345678 |



