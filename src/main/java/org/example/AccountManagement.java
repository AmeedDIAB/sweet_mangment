package org.example;


public class AccountManagement {
    private Account account;

    // Constructor
    public AccountManagement(Account account) {
        this.account = account;
    }

    // Method to get account details
    public Account getAccountDetails() {
        return this.account;
    }

    // Method to update account details
    public void updateAccountDetails(String businessName, String email, String address, String phoneNumber) {
        account.setBusinessName(businessName);
        account.setEmail(email);
        account.setAddress(address);
        account.setPhoneNumber(phoneNumber);
    }
}
