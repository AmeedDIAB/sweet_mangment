Feature: Communication and Notification

  # Scenario for sending a message to a user
  Scenario: Sending a message to a user
    Given The store owner is on the messaging system page
    When The store owner sends a message to the user with the following details
      | Recipient | Subject      | Body                   |
      | John Doe   | Important    | Please check the order |
    Then The message should be sent successfully to the user with the following details
      | Recipient | Subject      | Body                   |
      | John Doe   | Important    | Please check the order |

  # Scenario for sending a message to a supplier
  Scenario: Sending a message to a supplier
    Given The store owner is on the messaging system page
    When The store owner sends a message to the supplier with the following details
      | Recipient | Subject      | Body                   |
      | Jane Smith | Order Update | Your shipment is ready |
    Then The message should be sent successfully to the supplier with the following details
      | Recipient | Subject      | Body                   |
      | Jane Smith | Order Update | Your shipment is ready |
