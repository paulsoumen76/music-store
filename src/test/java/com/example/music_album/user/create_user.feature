Feature: User creation validation
  In order to avoid invalid user creation
  As an admin
  I want to validate user inputs

  Scenario: Create user with valid details
    Given I provide a valid username "john", valid password "john@123", valid email "john@gmail.com"
    When I submit the user
    Then the user should be created successfully
  Scenario: Don't Create user with invalid password
    Given I provide a valid username "john", invalid password "john@", valid email "john@gmail.com"
    When I submit the user
    Then the user should not be created successfully

