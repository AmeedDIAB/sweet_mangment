package org.example;

import java.util.HashMap;
import java.util.Map;

public class LoginManager {

    private boolean loggedIn;
    private String currentEmail;
    private String currentPassword;
    private Map<String, String> validCredentials;

    public LoginManager() {
        validCredentials = new HashMap<>();
        validCredentials.put("musabsoftware@gmail.com", "musab");
        validCredentials.put("mohdsoftware@gmail.com", "mohd");
        validCredentials.put("ameedsoftware@gmail.com", "ameed");
        loggedIn = false;
    }

    public void loginWithValidCredentials(String email, String password) {
        currentEmail = email;
        currentPassword = password;
        if (validCredentials.containsKey(email) && validCredentials.get(email).equals(password)) {
            loggedIn = true;
        } else {
            loggedIn = false;
        }
    }

    public void loginWithInvalidEmail(String email, String password) {
        currentEmail = email;
        currentPassword = password;
        if (!validCredentials.containsKey(email)) {
            loggedIn = false;
        } else {
            loggedIn = validCredentials.get(email).equals(password);
        }
    }

    public void loginWithInvalidPassword(String email, String password) {
        currentEmail = email;
        currentPassword = password;
        if (validCredentials.containsKey(email) && !validCredentials.get(email).equals(password)) {
            loggedIn = false;
        } else {
            loggedIn = true;
        }
    }

    public void loginWithInvalidCredentials(String email, String password) {
        currentEmail = email;
        currentPassword = password;
        if (!validCredentials.containsKey(email) || !validCredentials.get(email).equals(password)) {
            loggedIn = false;
        } else {
            loggedIn = true;
        }
    }

    public void resetLoginState() {
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getCurrentEmail() {
        return currentEmail;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }
}
