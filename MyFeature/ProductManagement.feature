Feature: Product Management

  # Scenario for adding a new product
  Scenario: Adding a new product
    Given The store owner is on the product management page
    When The store owner adds a new product with the following details
      | Name           | Price | Quantity | Category   |
      | Chocolate Cake | 20.0  | 50       | Dessert     |
    Then The product should be added to the product list
      | Name           | Price | Quantity | Category   |
      | Chocolate Cake | 20.0  | 50       | Dessert     |

  # Scenario for updating an existing product
  Scenario: Updating an existing product
    Given The store owner is on the product management page
    And The store owner has a product named "Chocolate Cake" with the following details
      | Price | Quantity | Category   |
      | 20.0  | 50       | Dessert     |
    When The store owner updates the product with the following details
      | Name           | Price | Quantity | Category   |
      | Chocolate Cake | 18.0  | 45       | Dessert     |
    Then The product should be updated in the product list
      | Name           | Price | Quantity | Category   |
      | Chocolate Cake | 18.0  | 45       | Dessert     |

  # Scenario for removing a product
  Scenario: Removing a product
    Given The store owner is on the product management page
    And The store owner has a product named "Chocolate Cake"
    When The store owner removes the product with name "Chocolate Cake"
    Then The product should be removed from the product list
      | Name           |
      | Chocolate Cake |

  # Scenario for monitoring sales and profits
  Scenario: Monitoring sales and profits
    Given The store owner is on the sales and profits page
    When The store owner views the sales and profit reports
    Then The store owner should see the total sales and profits

  # Scenario for identifying best-selling products
  Scenario: Identifying best-selling products
    Given The store owner is on the best-selling products page
    When The store owner views the best-selling products report
    Then The store owner should see a list of best-selling products

  # Scenario for implementing dynamic discount features
  Scenario: Implementing a dynamic discount
    Given The store owner is on the product management page
    And The store owner has a product named "Vanilla Ice Cream" with price 15.0
    When The store owner sets a discount of 10% on "Vanilla Ice Cream"
    Then The price of "Vanilla Ice Cream" should be updated to 13.5
