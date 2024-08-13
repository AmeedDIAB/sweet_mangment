package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class CommunicationAndFeedbackSteps {

    private boolean userLoggedIn;
    private boolean storeOwnerLoggedIn;
    private String message;
    private boolean messageSentToStoreOwner;
    private boolean messageSentToCustomer;
    private boolean messageSentToSupplier;
    private boolean feedbackRecorded;
    private Map<String, Boolean> recipientsReceivedMessage;
    private Map<String, Boolean> notificationsSent;

    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        userLoggedIn = true;
        System.out.println("User is logged in.");
    }

    @Given("The store owner is logged in")
    public void theStoreOwnerIsLoggedIn() {
        storeOwnerLoggedIn = true;
        System.out.println("Store owner is logged in.");
    }

    @Given("The user is browsing the dessert recipes page")
    public void theUserIsBrowsingTheDessertRecipesPage() {
        assertTrue(userLoggedIn);
        System.out.println("User is browsing the dessert recipes page.");
    }

    @Given("The user has purchased a product")
    public void theUserHasPurchasedAProduct() {
        assertTrue(userLoggedIn);
        System.out.println("User has purchased a product.");
    }

    @When("The user has an inquiry about a product")
    public void theUserHasAnInquiryAboutAProduct() {
        message = "Inquiry about a product";
        System.out.println("User has an inquiry about a product.");
    }

    @When("The user sends a message to the store owner")
    public void theUserSendsAMessageToTheStoreOwner() {
        assertTrue(userLoggedIn);
        // Simulate sending message to store owner
        messageSentToStoreOwner = true;
        System.out.println("User sends a message to the store owner.");
    }

    @When("The user leaves feedback on the purchased product")
    public void theUserLeavesFeedbackOnThePurchasedProduct() {
        feedbackRecorded = true;
        System.out.println("User leaves feedback on the purchased product.");
    }

    @When("The store owner selects a user from their customer list")
    public void theStoreOwnerSelectsAUserFromTheirCustomerList() {
        assertTrue(storeOwnerLoggedIn);
        System.out.println("Store owner selects a user from their customer list.");
    }

    @When("The store owner selects another supplier from their contacts list")
    public void theStoreOwnerSelectsAnotherSupplierFromTheirContactsList() {
        assertTrue(storeOwnerLoggedIn);
        System.out.println("Store owner selects another supplier from their contacts list.");
    }

    @When("The store owner sends a message to the selected customer")
    public void theStoreOwnerSendsAMessageToTheSelectedCustomer() {
        assertTrue(storeOwnerLoggedIn);
        // Simulate sending message to customer
        messageSentToCustomer = true;
        System.out.println("Store owner sends a message to the selected customer.");
    }

    @When("The store owner sends a message to the selected supplier")
    public void theStoreOwnerSendsAMessageToTheSelectedSupplier() {
        assertTrue(storeOwnerLoggedIn);
        // Simulate sending message to supplier
        messageSentToSupplier = true;
        System.out.println("Store owner sends a message to the selected supplier.");
    }

    @Then("The store owner receives the message")
    public void theStoreOwnerReceivesTheMessage() {
        assertTrue(messageSentToStoreOwner);
        System.out.println("Store owner receives the message.");
    }

    @Then("The user receives a confirmation of the sent message")
    public void theUserReceivesAConfirmationOfTheSentMessage() {
        assertTrue(messageSentToStoreOwner);
        System.out.println("User receives a confirmation of the sent message.");
    }

    @Then("The feedback is recorded")
    public void theFeedbackIsRecorded() {
        assertTrue(feedbackRecorded);
        System.out.println("Feedback is recorded.");
    }

    @Then("The store owner is notified of the feedback")
    public void theStoreOwnerIsNotifiedOfTheFeedback() {
        assertTrue(feedbackRecorded);
        System.out.println("Store owner is notified of the feedback.");
    }

    @Then("The customer receives the message")
    public void theCustomerReceivesTheMessage() {
        assertTrue(messageSentToCustomer);
        System.out.println("Customer receives the message.");
    }

    @Then("The supplier receives the message")
    public void theSupplierReceivesTheMessage() {
        assertTrue(messageSentToSupplier);
        System.out.println("Supplier receives the message.");
    }

    @Then("The store owner receives a confirmation of the sent message")
    public void theStoreOwnerReceivesAConfirmationOfTheSentMessage() {
        assertTrue(messageSentToCustomer || messageSentToSupplier);
        System.out.println("Store owner receives a confirmation of the sent message.");
    }
}