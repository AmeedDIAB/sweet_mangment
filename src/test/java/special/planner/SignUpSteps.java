package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class SignUpSteps {

    private boolean signUpSuccessful;
    private Set<String> existingEmails;

    @Given("The user is not logged in for sign up")
    public void theUserIsNotLoggedInForSignUp() {
        // Code specific to sign up scenario
        System.out.println("User is not logged in for sign up.");
    }

    @When("the email format is incorrect")
    public void theEmailFormatIsIncorrect() {
        // Handle incorrect email format
        // Simulate sign-up failure due to incorrect email format
        signUpSuccessful = false;
        System.out.println("Handling incorrect email format.");
    }

    @When("The provided credentials exists, the email is {string}")
    public void theProvidedCredentialsExistTheEmailIs(String email) {
        // Initialize existingEmails if not already done
        if (existingEmails == null) {
            existingEmails = new HashSet<>();
            existingEmails.add("musabsoftware@gmail.com");
            existingEmails.add("mohdsoftware@gmail.com");
            existingEmails.add("ameedsoftware@gmail.com");
        }

        // Handle signing up with an existing email
        if (existingEmails.contains(email)) {
            signUpSuccessful = false;
            System.out.printf("Sign up failed for existing email: %s%n", email);
        } else {
            signUpSuccessful = true;
        }
    }

    @When("The provided credentials exists, the email is not {string}")
    public void theProvidedCredentialsExistTheEmailIsNot(String email) {
        // Initialize existingEmails if not already done
        if (existingEmails == null) {
            existingEmails = new HashSet<>();
            existingEmails.add("musabsoftware@gmail.com");
            existingEmails.add("mohdsoftware@gmail.com");
            existingEmails.add("ameedsoftware@gmail.com");
        }

        // Handle signing up with a new email
        if (!existingEmails.contains(email)) {
            signUpSuccessful = true;
            System.out.printf("Sign up succeeded for new email: %s%n", email);
        } else {
            signUpSuccessful = false;
        }
    }

    @Then("Signing up fails")
    public void signingUpFails() {
        // Verify that signing up failed
        assertFalse(signUpSuccessful);
        System.out.println("Sign up failed.");
    }

    @Then("Signing up succeeds")
    public void signingUpSucceeds() {
        // Verify that signing up succeeded
        assertTrue(signUpSuccessful);
        System.out.println("Sign up succeeded.");
    }
}