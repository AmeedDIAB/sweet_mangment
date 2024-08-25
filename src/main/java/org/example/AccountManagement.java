package org.example;

import java.util.HashMap;
import java.util.Map;

public class AccountManagement {

    private Map<String, String> accountDetails;
    private Map<String, String> viewedDetails;

    // Constructor to initialize the account details
    public AccountManagement() {
        accountDetails = new HashMap<>();
        viewedDetails = new HashMap<>();
    }

    // Simulate that the store owner is on the account management page
    public void openAccountManagementPage() {
        System.out.println("Store owner is on the account management page.");
    }

    // Set the account details for the store owner
    public void setAccountDetails(Map<String, String> details) {
        accountDetails.clear();  // Clear existing details if any
        accountDetails.putAll(details);
        System.out.println("Store owner has the following account details: " + accountDetails);
    }

    // Simulate viewing the account details
    public void viewAccountDetails() {
        viewedDetails.clear();  // Clear previous viewed details if any
        viewedDetails.putAll(accountDetails);
        System.out.println("Store owner views the account details: " + viewedDetails);
    }

    // Check if the viewed account details match the expected details
    public boolean verifyAccountDetails(Map<String, String> expectedDetails) {
        boolean result = viewedDetails.equals(expectedDetails);
        if (!result) {
            System.out.println("Expected details: " + expectedDetails);
            System.out.println("Viewed details: " + viewedDetails);
            System.out.println("Account details do not match.");
        } else {
            System.out.println("Store owner sees the following account details: " + viewedDetails);
        }
        return result;
    }

    // Getter for accountDetails (for potential external use)
    public Map<String, String> getAccountDetails() {
        return new HashMap<>(accountDetails);
    }

    // Getter for viewedDetails (for potential external use)
    public Map<String, String> getViewedDetails() {
        return new HashMap<>(viewedDetails);
    }
}
