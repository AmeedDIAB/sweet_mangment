package special.planner;

import org.example.ContentManagement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContentManagementTest {

    private ContentManagement contentManagement;

    @Before
    public void setUp() {
        contentManagement = new ContentManagement();
    }

    @Test
    public void testLoginAsAdmin() {
        contentManagement.loginAsAdmin();
        // Test that admin login sets the state correctly
        assertTrue("Admin should be logged in", contentManagement.isAdminLoggedIn());
    }

    @Test(expected = IllegalStateException.class)
    public void testViewSharedContentWithoutLogin() {
        contentManagement.viewSharedContent();
        // This should throw an IllegalStateException as admin is not logged in
    }

    @Test
    public void testViewSharedContentWithLogin() {
        contentManagement.loginAsAdmin();
        contentManagement.viewSharedContent();

        // Verify that the shared content is populated correctly
        assertNotNull("Shared content should not be null", contentManagement.getSharedContent());
        assertTrue("Shared content should contain 'Recipe: Chocolate Cake'",
                contentManagement.getSharedContent().contains("Recipe: Chocolate Cake"));
        assertTrue("Shared content should contain 'Post: How to make a perfect pie'",
                contentManagement.getSharedContent().contains("Post: How to make a perfect pie"));
    }

    @Test(expected = IllegalStateException.class)
    public void testViewUserFeedbackWithoutLogin() {
        contentManagement.viewUserFeedback();
        // This should throw an IllegalStateException as admin is not logged in
    }

    @Test
    public void testViewUserFeedbackWithLogin() {
        contentManagement.loginAsAdmin();
        contentManagement.viewUserFeedback();

        // Verify that the user feedback is populated correctly
        assertNotNull("User feedback should not be null", contentManagement.getUserFeedback());
        assertTrue("User feedback should contain 'Great recipe, really enjoyed it!'",
                contentManagement.getUserFeedback().contains("Great recipe, really enjoyed it!"));
        assertTrue("User feedback should contain 'The pie recipe was not clear.'",
                contentManagement.getUserFeedback().contains("The pie recipe was not clear."));
    }

    @Test
    public void testDeleteOrRespondToFeedback() {
        contentManagement.loginAsAdmin();
        contentManagement.viewUserFeedback();
        contentManagement.deleteOrRespondToFeedback();

        // Verify that feedback was deleted and responded to
        assertTrue("Feedback should be deleted", contentManagement.isFeedbackDeleted());
        assertTrue("Feedback should be responded to", contentManagement.isFeedbackResponded());
    }

    @Test
    public void testLogout() {
        contentManagement.loginAsAdmin();
        contentManagement.logout();

        // Ensure that admin is logged out correctly
        assertFalse("Admin should be logged out", contentManagement.isAdminLoggedIn());
    }
}
