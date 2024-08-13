Feature: Account Management

  # Scenario for viewing account details
  Scenario: Viewing account details
    Given The store owner is on the account management page
    And The store owner has the following account details
      | Field          | Value                        |
      | Business Name  | Sweet Treats Bakery           |
      | Email          | contact@sweetbakes.com        |
      | Address        | 123 Bakery Street, Cake Town  |
      | Phone Number   | +1234567890                   |
    When The store owner views the account details
    Then The store owner should see the following account details
      | Field          | Value                        |
      | Business Name  | Sweet Treats Bakery           |
      | Email          | contact@sweetbakes.com        |
      | Address        | 123 Bakery Street, Cake Town  |
      | Phone Number   | +1234567890                   |
