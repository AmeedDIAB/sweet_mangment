package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class AccountManagementSteps {

    private Map<String, String> accountDetails;
    private Map<String, String> viewedDetails;

    @Given("The store owner is on the account management page")
    public void theStoreOwnerIsOnTheAccountManagementPage() {
        // Simulate that the store owner is on the account management page
        System.out.println("Store owner is on the account management page.");
    }

    @Given("The store owner has the following account details")
    public void theStoreOwnerHasTheFollowingAccountDetails(DataTable dataTable) {
        accountDetails = new HashMap<>();
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            accountDetails.put(row.get("Field"), row.get("Value"));
        }
        System.out.println("Store owner has the following account details: " + accountDetails);
    }

    @When("The store owner views the account details")
    public void theStoreOwnerViewsTheAccountDetails() {
        viewedDetails = new HashMap<>(accountDetails); // Simulate viewing the account details
        System.out.println("Store owner views the account details: " + viewedDetails);
    }

    @Then("The store owner should see the following account details")
    public void theStoreOwnerShouldSeeTheFollowingAccountDetails(DataTable dataTable) {
        Map<String, String> expectedDetails = new HashMap<>();
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            expectedDetails.put(row.get("Field"), row.get("Value"));
        }
        assertEquals("Account details do not match.", expectedDetails, viewedDetails);
        System.out.println("Store owner sees the following account details: " + viewedDetails);
    }
}
