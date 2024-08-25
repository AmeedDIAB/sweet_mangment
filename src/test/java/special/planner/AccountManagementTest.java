package special.planner;

import org.example.AccountManagement;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AccountManagementTest {

    private AccountManagement accountManagement;
    private Map<String, String> testAccountDetails;

    @Before
    public void setUp() {
        accountManagement = new AccountManagement();
        testAccountDetails = new HashMap<>();
        testAccountDetails.put("Username", "storeowner");
        testAccountDetails.put("Email", "owner@store.com");
        testAccountDetails.put("Phone", "1234567890");
    }

    @Test
    public void testOpenAccountManagementPage() {
        // Simulate opening the account management page
        accountManagement.openAccountManagementPage();
        // No assertions needed; just testing the method runs without error
    }

    @Test
    public void testSetAccountDetails() {
        // Set the account details
        accountManagement.setAccountDetails(testAccountDetails);

        // Verify that account details are set correctly
        assertEquals(testAccountDetails, accountManagement.getAccountDetails());
    }

    @Test
    public void testViewAccountDetails() {
        // Set and then view account details
        accountManagement.setAccountDetails(testAccountDetails);
        accountManagement.viewAccountDetails();

        // Verify that viewed details match the set account details
        assertEquals(testAccountDetails, accountManagement.getViewedDetails());
    }

    @Test
    public void testVerifyAccountDetails() {
        // Set and view account details
        accountManagement.setAccountDetails(testAccountDetails);
        accountManagement.viewAccountDetails();

        // Verify the viewed details match the expected details
        assertTrue(accountManagement.verifyAccountDetails(testAccountDetails));
    }

    @Test
    public void testVerifyAccountDetailsMismatch() {
        // Set account details
        accountManagement.setAccountDetails(testAccountDetails);

        // Create different expected details
        Map<String, String> differentDetails = new HashMap<>(testAccountDetails);
        differentDetails.put("Email", "wrongemail@store.com");

        // View account details
        accountManagement.viewAccountDetails();

        // Verify that the viewed details do not match the different expected details
        assertFalse(accountManagement.verifyAccountDetails(differentDetails));
    }
}
