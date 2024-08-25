package special.planner;

import org.example.UserManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testViewUserAccounts() {
        List<String> accounts = userManager.viewUserAccounts();
        assertTrue("User accounts should include Store Owner: mohd.hajjaj80@gmail.com", accounts.contains("Store Owner: mohd.hajjaj80@gmail.com"));
        assertTrue("User accounts should include Raw Material Supplier: ameed@gmail.com", accounts.contains("Raw Material Supplier: ameed@gmail.com"));
    }

    @Test
    public void testCreateUserAccount() {
        userManager.createUserAccount("newuser@example.com", "password123", "Store Owner");
        assertTrue("Account creation should be successful.", userManager.isAccountCreationSuccessful());
        List<String> accounts = userManager.viewUserAccounts();
        assertTrue("New user account should be listed.", accounts.contains("Store Owner: newuser@example.com"));
    }

    @Test
    public void testDeleteUserAccount() {
        userManager.deleteUserAccount("mohd.hajjaj80@gmail.com");
        assertTrue("Account deletion should be successful.", userManager.isAccountDeletionSuccessful());
        List<String> accounts = userManager.viewUserAccounts();
        assertFalse("Deleted user account should not be listed.", accounts.contains("Store Owner: mohd.hajjaj80@gmail.com"));
    }
}
