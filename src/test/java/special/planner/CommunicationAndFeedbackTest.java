package special.planner;

import org.example.CommunicationAndFeedback;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommunicationAndFeedbackTest {

    private CommunicationAndFeedback communicationAndFeedback;

    @Before
    public void setUp() {
        communicationAndFeedback = new CommunicationAndFeedback();
    }

    @Test
    public void testUserLogIn() {
        communicationAndFeedback.logInUser();
        // No assert is needed since we're just testing the action
    }

    @Test
    public void testStoreOwnerLogIn() {
        communicationAndFeedback.logInStoreOwner();
        // No assert is needed since we're just testing the action
    }

    @Test(expected = IllegalStateException.class)
    public void testBrowseDessertRecipesPageWithoutLogIn() {
        communicationAndFeedback.browseDessertRecipesPage();
    }

    @Test
    public void testBrowseDessertRecipesPageWithLogIn() {
        communicationAndFeedback.logInUser();
        communicationAndFeedback.browseDessertRecipesPage();
        // No assert is needed since we're just testing the action
    }

    @Test(expected = IllegalStateException.class)
    public void testPurchaseProductWithoutLogIn() {
        communicationAndFeedback.purchaseProduct();
    }

    @Test
    public void testPurchaseProductWithLogIn() {
        communicationAndFeedback.logInUser();
        communicationAndFeedback.purchaseProduct();
        // No assert is needed since we're just testing the action
    }

    @Test(expected = IllegalStateException.class)
    public void testInquireAboutProductWithoutLogIn() {
        communicationAndFeedback.inquireAboutProduct();
    }

    @Test
    public void testInquireAboutProductWithLogIn() {
        communicationAndFeedback.logInUser();
        communicationAndFeedback.inquireAboutProduct();
        // No assert is needed since we're just testing the action
    }

    @Test(expected = IllegalStateException.class)
    public void testSendMessageToStoreOwnerWithoutLogIn() {
        communicationAndFeedback.sendMessageToStoreOwner();
    }

    @Test
    public void testSendMessageToStoreOwnerWithLogIn() {
        communicationAndFeedback.logInUser();
        communicationAndFeedback.sendMessageToStoreOwner();
        assertTrue(communicationAndFeedback.verifyStoreOwnerReceivedMessage());
        assertTrue(communicationAndFeedback.verifyUserReceivedMessageConfirmation());
    }

    @Test(expected = IllegalStateException.class)
    public void testLeaveFeedbackWithoutLogIn() {
        communicationAndFeedback.leaveFeedback();
    }

    @Test
    public void testLeaveFeedbackWithLogIn() {
        communicationAndFeedback.logInUser();
        communicationAndFeedback.leaveFeedback();
        assertTrue(communicationAndFeedback.verifyFeedbackRecorded());
        assertTrue(communicationAndFeedback.verifyStoreOwnerNotifiedOfFeedback());
    }

    @Test(expected = IllegalStateException.class)
    public void testSelectCustomerWithoutLogIn() {
        communicationAndFeedback.selectCustomer();
    }

    @Test
    public void testSelectCustomerWithLogIn() {
        communicationAndFeedback.logInStoreOwner();
        communicationAndFeedback.selectCustomer();
        // No assert is needed since we're just testing the action
    }

    @Test(expected = IllegalStateException.class)
    public void testSelectSupplierWithoutLogIn() {
        communicationAndFeedback.selectSupplier();
    }

    @Test
    public void testSelectSupplierWithLogIn() {
        communicationAndFeedback.logInStoreOwner();
        communicationAndFeedback.selectSupplier();
        // No assert is needed since we're just testing the action
    }

    @Test(expected = IllegalStateException.class)
    public void testSendMessageToCustomerWithoutLogIn() {
        communicationAndFeedback.sendMessageToCustomer();
    }

    @Test
    public void testSendMessageToCustomerWithLogIn() {
        communicationAndFeedback.logInStoreOwner();
        communicationAndFeedback.sendMessageToCustomer();
        assertTrue(communicationAndFeedback.verifyCustomerReceivedMessage());
        assertTrue(communicationAndFeedback.verifyStoreOwnerReceivedConfirmation());
    }

    @Test(expected = IllegalStateException.class)
    public void testSendMessageToSupplierWithoutLogIn() {
        communicationAndFeedback.sendMessageToSupplier();
    }

    @Test
    public void testSendMessageToSupplierWithLogIn() {
        communicationAndFeedback.logInStoreOwner();
        communicationAndFeedback.sendMessageToSupplier();
        assertTrue(communicationAndFeedback.verifySupplierReceivedMessage());
        assertTrue(communicationAndFeedback.verifyStoreOwnerReceivedConfirmation());
    }
}
