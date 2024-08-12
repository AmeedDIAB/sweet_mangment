Feature: Product Management
  Scenario: Adding New Products
    Given the store owner is logged into the Sweet Management System,
    When the store owner navigates to the product management section and selects "Add Product",
    Then the store owner should be able to enter product details such as name, description, category, price, ingredients, and images, and successfully add the product to the inventory.
  Scenario: Updating Product Information
    Given the store owner is logged into the Sweet Management System,
    When the store owner selects an existing product in the product management section and chooses the "Update" option,
    Then the store owner should be able to modify the product details, save the changes, and see the updated information reflected in the product listing.
  Scenario: Removing Products
    Given the store owner is logged into the Sweet Management System,
    When the store owner selects a product and chooses the "Remove" option,
    Then the product should be removed from the active inventory and optionally flagged as out-of-stock or discontinued.
Feature: Sales and Performance Monitoring
  Scenario: Monitoring Sales and Profits
    Given the store owner is logged into the Sweet Management System,
    When the store owner accesses the sales dashboard,
    Then the store owner should be able to view real-time sales data, profit margins, and generate detailed sales and profit reports.
  Scenario: Identifying Best-Selling Products
    Given the store owner is logged into the Sweet Management System,
    When the store owner opens the product performance dashboard,
    Then the store owner should see a list of the best-selling products based on metrics like total sales, profit margins, and customer ratings.
Feature: Discount Management
  Scenario: Implementing Dynamic Discount Features
    Given the store owner is logged into the Sweet Management System,
    When the store owner sets up a discount campaign,
    Then the system should automatically apply the discount at checkout for eligible products and track the performance of the discount.