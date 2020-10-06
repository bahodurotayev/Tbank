#  PAGE TITLE (NOT DONE)

#  Verify the Title of all pages contains appropriate value corresponding to its functionality



Feature: Login Page Title

  @RegressionTest
  Scenario: Verify the Title of Login page

    Given Navigate to website
    When Title of the page is not empty
    Then Title of the page contains "Techno Bank"



  @RegressionTest
  Scenario: Labels and Textboxes for username and password

    Given Navigate to website
    And Validate presence of Labels, Textboxes and login button
    And Verify Placeholder contains Label name


  @RegressionTest
  Scenario: Verify if the data in password field is either visible as asterisk or bullet signs.

    Given Navigate to website
    When user enter the password
    Then password is not visible and should be as asterisk or bullet signs


