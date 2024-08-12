Feature: Order Management
  Scenario: Processing and Tracking Customer Orders
    Given the store owner is on the order management page,
    When a new order is received,
    Then the store owner should be able to update the order status to "Processing," "Shipped," or "Delivered," and track the order's progress.