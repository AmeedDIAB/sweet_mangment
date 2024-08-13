Feature: Order Management

  # Scenario for processing an order
  Scenario: Processing an order
    Given The store owner is on the order management page
    And There is an order with the following details
      | Order ID | Product         | Quantity | Status     |
      | 1234     | Chocolate Cake  | 10       | Pending    |
    When The store owner processes the order with Order ID 1234
    Then The order status should be updated to "Processed"

  # Scenario for tracking an order
  Scenario: Tracking an order
    Given The store owner is on the order management page
    And There is an order with the following details
      | Order ID | Product         | Quantity | Status     |
      | 5678     | Vanilla Ice Cream| 5        | Processed  |
    When The store owner tracks the order with Order ID 5678
    Then The store owner should see the order status as "Processed"
