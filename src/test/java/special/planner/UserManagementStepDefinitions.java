package special.planner;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class UserManagementStepDefinitions {

    private final special.planner.Login login;
    User currentUser;
    User testUser;
    String email;

    // Constructor to initialize the login and users
    public UserManagementStepDefinitions(Login login) {
        this.login = login;
        currentUser = new User("admin@example.com", "adminpass", "Admin");
        testUser = new User("user@example.com", "userpass", "Store Owner");
    }

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        // Log in as admin
        currentUser.setAsAdmin();
        assertTrue(currentUser.isAdmin());
    }

    @When("I view the list of user accounts")
    public void i_view_the_list_of_user_accounts() {
        // View user accounts (you may want to return a list from a method here)
        login.viewUserAccounts();
    }

    @Then("I should see a list of store owners and raw material suppliers")
    public void i_should_see_a_list_of_store_owners_and_raw_material_suppliers() {
        // Check if the list contains both Store Owners and Raw Material Suppliers
        assertTrue(login.containsRole("Store Owner"));
        assertTrue(login.containsRole("Raw Material Supplier"));
    }

    @When("I create a new user account with {string}, {string}, {string} as the following")
    public void i_create_a_new_user_account_with_as_the_following(String email, String password, String role, io.cucumber.datatable.DataTable dataTable) {
        // Loop through the DataTable to create multiple users
        this.email = email;
        login.addUser(email, password, role);

        // Example for using DataTable if needed:
        dataTable.asMaps().forEach(row -> {
            String email = row.get("Email");
            String password = row.get("Password");
            String role = row.get("Role");
            login.addUser(email, password, role);
        });
    }

    @Then("I should see a success message confirming the account creation")
    public void i_should_see_a_success_message_confirming_the_account_creation() {
        // Check if the user was successfully added
        assertTrue(login.userExists(email));
    }

    @When("I delete the user account with email {string}")
    public void i_delete_the_user_account_with_email(String email) {
        // Add a user and then delete them
        login.addUser(testUser.getEmail(), testUser.getPassword(), testUser.getRole());
        login.deleteUser(email);
    }

    @Then("I should see a success message confirming the account deletion")
    public void i_should_see_a_success_message_confirming_the_account_deletion() {
        // Ensure the user was successfully deleted
        assertFalse(login.userExists(testUser.getEmail()));
    }
}
