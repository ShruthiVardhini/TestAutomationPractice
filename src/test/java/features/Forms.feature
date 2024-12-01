Feature: QA Practice - Scenarios for Login, Register and Forgot Password

  Scenario Outline: To validate the Login functionality using valid Email ID and valid Password.
    Given I am on the QA Practice website
    When I navigate to the login page from the forms tab
    And I log in using "<emailId>" and "<password>"
    Then I should be landed on the home page

    Examples:
      | emailId         | password |
      | admin@admin.com | admin123 |

  Scenario Outline: To Validate the Login Functionality using invalid Email Id and invalid Password.
      Given I am on the QA Practice website
      When I navigate to the login page from the forms tab
      And I log in using "<emailId>" and "<password>"
      Then I must not be able to login and Bad credentials error should be thrown
    Examples:
      | emailId         | password  |
      | test@test.com   | test@123  |
      | admin@test.com  | admin@123 |
      | admin@admin.com |           |
      |                 | admin123  |

  Scenario: To validate whether the error message is thrown when trying to Login with empty Email and Password fields.
    Given I am on the QA Practice website
    When I navigate to the login page from the forms tab
    And I click on submit button
    Then I must not be able to login and Bad credentials error should be thrown

