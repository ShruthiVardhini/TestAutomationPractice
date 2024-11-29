Feature: QA Practice - Scenarios for Login, Register and Forgot Password

  Scenario Outline: To validate the Login functionality using valid Email ID and valid Password
    Given I am on the QA Practice website
    When I navigate to the login page from the forms tab
    And I log in using "<emailId>" and "<password>"
    Then I should be landed on the home page

    Examples:
      | emailId         | password |
      | admin@admin.com | admin123 |

