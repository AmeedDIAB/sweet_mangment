Feature: Order Tracking by Customers
  Scenario: Customers Tracking their Orders
    Given the customer is logged into their account,
    When the customer navigates to the order tracking page,
    Then the customer should see the current status of their order, including estimated delivery time.