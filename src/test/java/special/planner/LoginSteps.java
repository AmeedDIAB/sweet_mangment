package special.planner;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class LoginSteps {

    private boolean loggedIn;
    private String currentEmail;
    private String currentPassword;
    private Map<String, String> validCredentials;

    @Before
    public void setUp() {
        validCredentials = new HashMap<>();
        validCredentials.put("musabsoftware@gmail.com", "musab");
        validCredentials.put("mohdsoftware@gmail.com", "mohd");
        validCredentials.put("ameedsoftware@gmail.com", "ameed");
        loggedIn = false;
    }

    @Given("The user is not logged in")
    public void theUserIsNotLoggedIn() {
        // Code specific to login scenario
        loggedIn = false;
        System.out.println("User is not logged in.");
    }

    @When("the credentials is valid email is {string} and password is {string}")
    public void theCredentialsIsValidEmailIsAndPasswordIs(String email, String password) {
        currentEmail = email;
        currentPassword = password;

        // Simulate login logic
        if (validCredentials.containsKey(email) && validCredentials.get(email).equals(password)) {
            loggedIn = true;
        } else {
            loggedIn = false;
        }
    }

    @When("The email is invalid email is {string} and password is {string}")
    public void theEmailIsInvalidEmailIsAndPasswordIs(String email, String password) {
        currentEmail = email;
        currentPassword = password;

        // Simulate login logic
        if (!validCredentials.containsKey(email)) {
            loggedIn = false;
        } else {
            loggedIn = validCredentials.get(email).equals(password);
        }
    }

    @When("The password is invalid email is {string} and password is {string}")
    public void thePasswordIsInvalidEmailIsAndPasswordIs(String email, String password) {
        currentEmail = email;
        currentPassword = password;

        // Simulate login logic
        if (validCredentials.containsKey(email) && !validCredentials.get(email).equals(password)) {
            loggedIn = false;
        } else {
            loggedIn = true;
        }
    }

    @When("The credentials is invalid, email is {string} and password is {string}")
    public void theCredentialsIsInvalidEmailIsAndPasswordIs(String email, String password) {
        currentEmail = email;
        currentPassword = password;

        // Simulate login logic
        if (!validCredentials.containsKey(email) || !validCredentials.get(email).equals(password)) {
            loggedIn = false;
        } else {
            loggedIn = true;
        }
    }

    @Then("User logs in successfully")
    public void userLogsInSuccessfully() {
        assertTrue(loggedIn);
        System.out.println("User logged in successfully.");
    }

    @Then("User failed in log in")
    public void userFailedInLogIn() {
        assertFalse(loggedIn);
        System.out.println("User failed in log in.");
    }
}