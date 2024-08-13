Feature: Communication and Notification
  Scenario: Communicating with Suppliers
    Given the store owner is on the messaging page,
    When the store owner selects a supplier to communicate with,
    Then the store owner should be able to send and receive messages from the selected supplier.
  Scenario Outline: Receiving Notifications for Special Requests
    Given the store owner has enabled email notifications in their settings,

    When a customer makes a special request for a "<RequestType>",

    Then the store owner should receive an email notification with the details of the "<RequestType>" request.

    Examples:
      |RequestType|
      |Customized Cake|
      |Bulk Order Inquiry|
      |Dietary-Specific Order|