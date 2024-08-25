package org.example;

import java.util.HashMap;
import java.util.Map;

public class CommunicationAndFeedback {

    private boolean userLoggedIn;
    private boolean storeOwnerLoggedIn;
    private String message;
    private boolean messageSentToStoreOwner;
    private boolean messageSentToCustomer;
    private boolean messageSentToSupplier;
    private boolean feedbackRecorded;
    private Map<String, Boolean> recipientsReceivedMessage;
    private Map<String, Boolean> notificationsSent;

    public CommunicationAndFeedback() {
        recipientsReceivedMessage = new HashMap<>();
        notificationsSent = new HashMap<>();
    }

    // Simulate user logging in
    public void logInUser() {
        userLoggedIn = true;
        System.out.println("User is logged in.");
    }

    // Simulate store owner logging in
    public void logInStoreOwner() {
        storeOwnerLoggedIn = true;
        System.out.println("Store owner is logged in.");
    }

    // Simulate user browsing the dessert recipes page
    public void browseDessertRecipesPage() {
        if (!userLoggedIn) {
            throw new IllegalStateException("User must be logged in to browse the page.");
        }
        System.out.println("User is browsing the dessert recipes page.");
    }

    // Simulate user purchasing a product
    public void purchaseProduct() {
        if (!userLoggedIn) {
            throw new IllegalStateException("User must be logged in to purchase a product.");
        }
        System.out.println("User has purchased a product.");
    }

    // Simulate user having an inquiry about a product
    public void inquireAboutProduct() {
        if (!userLoggedIn) {
            throw new IllegalStateException("User must be logged in to inquire about a product.");
        }
        message = "Inquiry about a product";
        System.out.println("User has an inquiry about a product.");
    }

    // Simulate sending a message to the store owner
    public void sendMessageToStoreOwner() {
        if (!userLoggedIn) {
            throw new IllegalStateException("User must be logged in to send a message.");
        }
        messageSentToStoreOwner = true;
        System.out.println("User sends a message to the store owner.");
    }

    // Simulate user leaving feedback on a purchased product
    public void leaveFeedback() {
        if (!userLoggedIn) {
            throw new IllegalStateException("User must be logged in to leave feedback.");
        }
        feedbackRecorded = true;
        System.out.println("User leaves feedback on the purchased product.");
    }

    // Simulate store owner selecting a user from their customer list
    public void selectCustomer() {
        if (!storeOwnerLoggedIn) {
            throw new IllegalStateException("Store owner must be logged in to select a user.");
        }
        System.out.println("Store owner selects a user from their customer list.");
    }

    // Simulate store owner selecting a supplier from their contacts list
    public void selectSupplier() {
        if (!storeOwnerLoggedIn) {
            throw new IllegalStateException("Store owner must be logged in to select a supplier.");
        }
        System.out.println("Store owner selects another supplier from their contacts list.");
    }

    // Simulate store owner sending a message to a customer
    public void sendMessageToCustomer() {
        if (!storeOwnerLoggedIn) {
            throw new IllegalStateException("Store owner must be logged in to send a message.");
        }
        messageSentToCustomer = true;
        System.out.println("Store owner sends a message to the selected customer.");
    }

    // Simulate store owner sending a message to a supplier
    public void sendMessageToSupplier() {
        if (!storeOwnerLoggedIn) {
            throw new IllegalStateException("Store owner must be logged in to send a message.");
        }
        messageSentToSupplier = true;
        System.out.println("Store owner sends a message to the selected supplier.");
    }

    // Check if the store owner received the message
    public boolean verifyStoreOwnerReceivedMessage() {
        System.out.println("Store owner receives the message.");
        return messageSentToStoreOwner;
    }

    // Check if the user received a confirmation of the sent message
    public boolean verifyUserReceivedMessageConfirmation() {
        System.out.println("User receives a confirmation of the sent message.");
        return messageSentToStoreOwner;
    }

    // Check if feedback was recorded
    public boolean verifyFeedbackRecorded() {
        System.out.println("Feedback is recorded.");
        return feedbackRecorded;
    }

    // Check if the store owner was notified of the feedback
    public boolean verifyStoreOwnerNotifiedOfFeedback() {
        System.out.println("Store owner is notified of the feedback.");
        return feedbackRecorded;
    }

    // Check if the customer received the message
    public boolean verifyCustomerReceivedMessage() {
        System.out.println("Customer receives the message.");
        return messageSentToCustomer;
    }

    // Check if the supplier received the message
    public boolean verifySupplierReceivedMessage() {
        System.out.println("Supplier receives the message.");
        return messageSentToSupplier;
    }

    // Check if the store owner received a confirmation of the sent message
    public boolean verifyStoreOwnerReceivedConfirmation() {
        System.out.println("Store owner receives a confirmation of the sent message.");
        return messageSentToCustomer || messageSentToSupplier;
    }
}
