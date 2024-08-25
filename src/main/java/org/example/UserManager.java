package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {

    private List<String> userAccounts;
    private boolean accountCreationSuccess;
    private boolean accountDeletionSuccess;
    private Map<String, String> userAccountsMap;

    public UserManager() {
        userAccounts = new ArrayList<>();
        userAccountsMap = new HashMap<>();
        userAccountsMap.put("mohd.hajjaj80@gmail.com", "Store Owner");
        userAccountsMap.put("ameed@gmail.com", "Raw Material Supplier");
        refreshUserAccounts();
    }

    private void refreshUserAccounts() {
        userAccounts.clear();
        for (Map.Entry<String, String> entry : userAccountsMap.entrySet()) {
            userAccounts.add(entry.getValue() + ": " + entry.getKey());
        }
    }

    public List<String> viewUserAccounts() {
        return new ArrayList<>(userAccounts);
    }

    public void createUserAccount(String email, String password, String role) {
        userAccountsMap.put(email, role);
        refreshUserAccounts();
        accountCreationSuccess = true;
        System.out.printf("Created account with email: %s, role: %s%n", email, role);
    }

    public boolean isAccountCreationSuccessful() {
        return accountCreationSuccess;
    }

    public void deleteUserAccount(String email) {
        if (userAccountsMap.containsKey(email)) {
            userAccountsMap.remove(email);
            refreshUserAccounts();
            accountDeletionSuccess = true;
            System.out.printf("Deleted account with email: %s%n", email);
        } else {
            accountDeletionSuccess = false;
            System.out.printf("Failed to delete account with email: %s%n", email);
        }
    }

    public boolean isAccountDeletionSuccessful() {
        return accountDeletionSuccess;
    }
}
