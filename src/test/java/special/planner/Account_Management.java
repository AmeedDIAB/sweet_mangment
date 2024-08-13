package sweet.management.account;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class AccountManagementStepDefinition {
    Account account;

    @Given("I have updated my account contact information to {string}")
    public void iHaveUpdatedMyAccountContactInformationTo(String newContactInfo) {
        account = new Account("Sweet Shop", newContactInfo);
    }

    @Then("My account contact information should be {string}")
    public void myAccountContactInformationShouldBe(String expectedContactInfo) {
        assertEquals(expectedContactInfo, account.get_contact_info());
    }
}
