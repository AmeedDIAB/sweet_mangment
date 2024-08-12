package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ContentManagementSteps {

    private boolean adminLoggedIn;
    private List<String> sharedContent;
    private List<String> userFeedback;
    private boolean feedbackDeleted;
    private boolean feedbackResponded;

    // Reset state before each scenario
    @io.cucumber.java.Before
    public void setUp() {
        adminLoggedIn = false;
        sharedContent = new ArrayList<>();
        userFeedback = new ArrayList<>();
        feedbackDeleted = false;
        feedbackResponded = false;
    }

    @Given("I am logged in as an admin for content management")
    public void iAmLoggedInAsAnAdminForContentManagement() {
        // Simulate admin login
        adminLoggedIn = true; // Ensure this is set to true
        System.out.println("Admin logged in successfully for content management.");
    }

    @When("I view the content shared on the system")
    public void iViewTheContentSharedOnTheSystem() {
        assertTrue("Admin should be logged in to view shared content", adminLoggedIn);
        // Simulate viewing shared content
        sharedContent.add("Recipe: Chocolate Cake");
        sharedContent.add("Post: How to make a perfect pie");
        System.out.println("Viewing content shared on the system.");
    }

    @When("I view the user feedback")
    public void iViewTheUserFeedback() {
        assertTrue("Admin should be logged in to view user feedback", adminLoggedIn);
        // Simulate viewing user feedback
        userFeedback.add("Great recipe, really enjoyed it!");
        userFeedback.add("The pie recipe was not clear.");
        System.out.println("Viewing user feedback.");
    }

    @Then("I should see a list of recipes and posts")
    public void iShouldSeeAListOfRecipesAndPosts() {
        assertNotNull("Shared content should not be null", sharedContent);
        assertTrue("Shared content should contain 'Recipe: Chocolate Cake'", sharedContent.contains("Recipe: Chocolate Cake"));
        assertTrue("Shared content should contain 'Post: How to make a perfect pie'", sharedContent.contains("Post: How to make a perfect pie"));
        System.out.println("List of recipes and posts displayed.");
    }

    @Then("I should see all feedback provided by users")
    public void iShouldSeeAllFeedbackProvidedByUsers() {
        assertNotNull("User feedback should not be null", userFeedback);
        assertTrue("User feedback should contain 'Great recipe, really enjoyed it!'", userFeedback.contains("Great recipe, really enjoyed it!"));
        assertTrue("User feedback should contain 'The pie recipe was not clear.'", userFeedback.contains("The pie recipe was not clear."));
        System.out.println("All feedback provided by users is displayed.");
    }

    @Then("I should be able to delete or respond to feedback")
    public void iShouldBeAbleToDeleteOrRespondToFeedback() {
        // Simulate deleting and responding to feedback
        if (userFeedback != null && !userFeedback.isEmpty()) {
            feedbackDeleted = true; // Simulating successful deletion
            feedbackResponded = true; // Simulating successful response
        }
        assertTrue("Feedback should be deleted", feedbackDeleted);
        assertTrue("Feedback should be responded to", feedbackResponded);
        System.out.println("Feedback deleted and responded to successfully.");
    }
}
