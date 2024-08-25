package special.planner;

import org.example.LoginManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginManagerTest {

    private LoginManager loginManager;

    @Before
    public void setUp() {
        loginManager = new LoginManager();
    }

    @Test
    public void testLoginWithValidCredentials() {
        loginManager.loginWithValidCredentials("musabsoftware@gmail.com", "musab");
        assertTrue("User should be logged in with valid credentials", loginManager.isLoggedIn());
    }

    @Test
    public void testLoginWithInvalidEmail() {
        loginManager.loginWithInvalidEmail("invalidemail@example.com", "anyPassword");
        assertFalse("User should not be logged in with invalid email", loginManager.isLoggedIn());
    }

    @Test
    public void testLoginWithInvalidPassword() {
        loginManager.loginWithInvalidPassword("musabsoftware@gmail.com", "wrongPassword");
        assertFalse("User should not be logged in with invalid password", loginManager.isLoggedIn());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginManager.loginWithInvalidCredentials("invalidemail@example.com", "wrongPassword");
        assertFalse("User should not be logged in with invalid credentials", loginManager.isLoggedIn());
    }

    @Test
    public void testResetLoginState() {
        loginManager.loginWithValidCredentials("musabsoftware@gmail.com", "musab");
        assertTrue("User should be logged in initially", loginManager.isLoggedIn());

        loginManager.resetLoginState();
        assertFalse("User should not be logged in after resetting state", loginManager.isLoggedIn());
    }

    @Test
    public void testCurrentEmailAndPassword() {
        String email = "musabsoftware@gmail.com";
        String password = "musab";

        loginManager.loginWithValidCredentials(email, password);
        assertEquals("Current email should match", email, loginManager.getCurrentEmail());
        assertEquals("Current password should match", password, loginManager.getCurrentPassword());
    }
}
