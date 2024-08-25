package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class SignUpManager {

    private boolean signUpSuccessful;
    private Set<String> existingEmails;
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public SignUpManager() {
        existingEmails = new HashSet<>();
        existingEmails.add("musabsoftware@gmail.com");
        existingEmails.add("mohdsoftware@gmail.com");
        existingEmails.add("ameedsoftware@gmail.com");
    }

    public void checkEmailFormat(String email) {
        if (EMAIL_PATTERN.matcher(email).matches()) {
            System.out.println("Email format is correct.");
        } else {
            signUpSuccessful = false;
            System.out.println("Handling incorrect email format.");
        }
    }

    public void checkEmailExistence(String email) {
        if (existingEmails.contains(email)) {
            signUpSuccessful = false;
            System.out.printf("Sign up failed for existing email: %s%n", email);
        } else {
            signUpSuccessful = true;
            System.out.printf("Sign up succeeded for new email: %s%n", email);
        }
    }

    public boolean isSignUpSuccessful() {
        return signUpSuccessful;
    }

    // Method to simulate successful sign-up
    public void signUp(String email) {
        checkEmailFormat(email);
        if (signUpSuccessful) {
            checkEmailExistence(email);
        }
    }
}
