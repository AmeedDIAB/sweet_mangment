Feature: User Management

  @USER_MANAGEMENT
  Scenario: Manage user accounts
    Given I am logged in as an admin
    When I view the list of user accounts
    Then I should see a list of store owners and raw material suppliers

  @CREATE_USER_ACCOUNT
  Scenario: Create a new user account
    Given I am logged in as an admin
    When I create a new user account with as the following
      | Email                  | Password | Role                 |
      | mohd.hajjaj80@gmail.com| 123456   | Store Owner          |
      | ameed@gmail.com        | 654321   | Raw Material Supplier|
    Then I should see a success message confirming the account creation

  @DELETE_USER_ACCOUNT
  Scenario: Delete a user account
    Given I am logged in as an admin
    When I delete the user account with email "mohd.hajjaj80@gmail.com"
    Then I should see a success message confirming the account deletion
