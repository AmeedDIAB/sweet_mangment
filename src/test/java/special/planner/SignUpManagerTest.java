package special.planner;

import org.example.SignUpManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SignUpManagerTest {

    private SignUpManager manager;

    @Before
    public void setUp() {
        manager = new SignUpManager();
    }

    @Test
    public void testSignUpWithIncorrectEmailFormat() {
        manager.signUp("invalid-email-format");
        assertFalse("Sign up should fail with incorrect email format.", manager.isSignUpSuccessful());
    }

    @Test
    public void testSignUpWithExistingEmail() {
        manager.signUp("musabsoftware@gmail.com");
        assertFalse("Sign up should fail with an existing email.", manager.isSignUpSuccessful());
    }

    @Test
    public void testSignUpWithNewEmail() {
        manager.signUp("newuser@gmail.com");
        assertTrue("Sign up should succeed with a new email.", manager.isSignUpSuccessful());
    }
}
