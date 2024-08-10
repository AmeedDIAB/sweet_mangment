Feature: Content Management

  @CONTENT_MANAGEMENT
  Scenario: Manage shared content
    Given I am logged in as an admin
    When I view the content shared on the system
    Then I should see a list of recipes and posts

  @USER_FEEDBACK
  Scenario: Manage user feedback
    Given I am logged in as an admin
    When I view the user feedback
    Then I should see all feedback provided by users
    And I should be able to delete or respond to feedback
