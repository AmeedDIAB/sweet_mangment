Feature: Monitoring and Reporting

  @FINANCIAL_REPORTS
  Scenario: Monitor profits and generate financial reports
    Given I am logged in as an admin
    When I view the financial reports for the period "<Start Date>" to "<End Date>"
    Then I should see the total profits generated

  @BEST_SELLING_PRODUCTS
  Scenario: Identify best-selling products in each store
    Given I am logged in as an admin
    When I view the best-selling products in each store
    Then I should see a list of products sorted by sales volume for each store

  @USER_STATISTICS
  Scenario: Gather and display statistics on registered users by City
    Given I am logged in as an admin
    When I view the user registration statistics by city
    Then I should see the number of registered users in each city including Nablus, Jenin, etc.
