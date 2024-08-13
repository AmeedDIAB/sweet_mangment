Feature: Account Management
  Scenario: Updating Business Information
    Given the store owner is on the account management page,
    When the store owner updates their business contact information,
    Then the store owner's updated contact information should be saved and reflected in their account details.