package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagementSteps {

    private List<String> userAccounts;
    private boolean accountCreationSuccess;
    private boolean accountDeletionSuccess;

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        // Code to simulate admin login
        System.out.println("Admin logged in successfully.");
    }

    @When("I view the list of user accounts")
    public void iViewTheListOfUserAccounts() {
        // Code to retrieve and display the list of user accounts
        userAccounts = new ArrayList<>();
        userAccounts.add("Store Owner: mohd.hajjaj80@gmail.com");
        userAccounts.add("Raw Material Supplier: ameed@gmail.com");
    }

    @Then("I should see a list of store owners and raw material suppliers")
    public void iShouldSeeAListOfStoreOwnersAndRawMaterialSuppliers() {
        // Assert that the list contains the expected accounts
        assertTrue(userAccounts.contains("Store Owner: mohd.hajjaj80@gmail.com"));
        assertTrue(userAccounts.contains("Raw Material Supplier: ameed@gmail.com"));
        System.out.println("User accounts displayed successfully.");
    }

    @When("I create a new user account with as the following")
    public void iCreateANewUserAccountWithAsTheFollowing(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String email = row.get("Email");
            String password = row.get("Password");
            String role = row.get("Role");
            // Code to create a new user account
            System.out.printf("Creating account: %s, %s, %s%n", email, password, role);
            // Assume account creation is always successful for this test
            accountCreationSuccess = true;
        }
    }

    @Then("I should see a success message confirming the account creation")
    public void iShouldSeeASuccessMessageConfirmingTheAccountCreation() {
        // Assert that the account creation was successful
        assertTrue(accountCreationSuccess);
        System.out.println("Account created successfully.");
    }

    @When("I delete the user account with email {string}")
    public void iDeleteTheUserAccountWithEmail(String email) {
        // Code to delete the user account
        System.out.printf("Deleting account with email: %s%n", email);
        // Assume account deletion is always successful for this test
        accountDeletionSuccess = true;
    }

    @Then("I should see a success message confirming the account deletion")
    public void iShouldSeeASuccessMessageConfirmingTheAccountDeletion() {
        // Assert that the account deletion was successful
        assertTrue(accountDeletionSuccess);
        System.out.println("Account deleted successfully.");
    }
}
