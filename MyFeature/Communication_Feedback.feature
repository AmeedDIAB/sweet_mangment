Feature: Communication and Feedback

  # User Scenarios
  Scenario: Communicating with store owners for inquiries
    Given The user is logged in
    And The user is browsing the dessert recipes page
    When The user has an inquiry about a product
    And The user sends a message to the store owner
    Then The store owner receives the message
    And The user receives a confirmation of the sent message

  Scenario: Providing feedback on purchased products
    Given The user is logged in
    And The user has purchased a product
    When The user leaves feedback on the purchased product
    Then The feedback is recorded
    And The store owner is notified of the feedback

  # Store Owner Scenarios
  Scenario: Store owner communicates with users
    Given The store owner is logged in
    When The store owner selects a user from their customer list
    And The store owner sends a message to the selected customer
    Then The customer receives the message
    And The store owner receives a confirmation of the sent message

  Scenario: Store owner communicates with suppliers
    Given The store owner is logged in
    When The store owner selects another supplier from their contacts list
    And The store owner sends a message to the selected supplier
    Then The supplier receives the message
    And The store owner receives a confirmation of the sent message
