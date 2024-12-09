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



  Scenario: To validate whether the user can register a new account from the Register page.
    Given I am on the QA Practice website
    When I navigate to the register page from forms tab
    Then I fill all the fields and click on register button which displays a success message
          | firstname | lastname | phone     | email          | password |
          | Test      | User     | 012345678 | test@email.com | test@123 |



  Scenario: To validate the user cannot complete the registration process without providing the mandatory fields.
    Given I am on the QA Practice website
    When I navigate to the register page from forms tab
    And I fill all the fields except email and password and click register
      | firstname | lastname | phone      |
      | Test1     | User1    | 0987654321 |
    Then the success message should not be displayed


  Scenario: To validate the user should be able to complete the registration precess even if the non mandatory fileds are not provided.
    Given I am on the QA Practice website
    When I navigate to the register page from forms tab
    And I fill all the mandatory fields and click on register button
      | email           | password |
      | test2@gmail.com | Test@321 |
    Then I should see the success message


  Scenario Outline: To validate the Recover password fuctionality
    Given I am on the QA Practice website
    When I navigate to the recover password page
    And I fill the email field with "<email>" and click on recover password button
    Then I should get a message redirecting to fetch the new password from the mailId given.
    Examples:
      | email          |
      | test@email.com |


  Scenario:  To validate the Recover password email should not be triggered if the form is submitted with the empty email field.
    Given I am on the QA Practice website
    When I navigate to the recover password page
    And I click on recover password button
    Then I should not see the recover password email trigger message

