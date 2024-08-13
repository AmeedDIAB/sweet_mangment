package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class CommunicationAndNotificationSteps {

    private Map<String, Message> sentMessages = new HashMap<>();
    private Message message;

    @Given("The store owner is on the messaging system page")
    public void theStoreOwnerIsOnTheMessagingSystemPage() {
        // Simulate that the store owner is on the messaging system page
        System.out.println("Store owner is on the messaging system page.");
    }

    @When("The store owner sends a message to the user with the following details")
    public void theStoreOwnerSendsAMessageToTheUserWithTheFollowingDetails(DataTable dataTable) {
        // Convert DataTable to a Map
        Map<String, String> messageDetails = dataTable.asMaps(String.class, String.class).get(0);
        String recipient = messageDetails.get("Recipient");
        String subject = messageDetails.get("Subject");
        String body = messageDetails.get("Body");
        message = new Message(recipient, subject, body);
        sentMessages.put(recipient, message);
        System.out.println("Message sent to " + recipient + ": " + message);
    }

    @Then("The message should be sent successfully to the user with the following details")
    public void theMessageShouldBeSentSuccessfullyToTheUserWithTheFollowingDetails(DataTable expectedDetailsTable) {
        Map<String, String> expectedDetails = expectedDetailsTable.asMaps(String.class, String.class).get(0);
        String recipient = expectedDetails.get("Recipient");
        Message sentMessage = sentMessages.get(recipient);
        assertNotNull("Message should be sent", sentMessage);
        assertEquals(expectedDetails.get("Subject"), sentMessage.getSubject());
        assertEquals(expectedDetails.get("Body"), sentMessage.getBody());
        System.out.println("Message details verified for " + recipient + ": " + sentMessage);
    }

    @When("The store owner sends a message to the supplier with the following details")
    public void theStoreOwnerSendsAMessageToTheSupplierWithTheFollowingDetails(DataTable dataTable) {
        // Convert DataTable to a Map
        Map<String, String> messageDetails = dataTable.asMaps(String.class, String.class).get(0);
        String recipient = messageDetails.get("Recipient");
        String subject = messageDetails.get("Subject");
        String body = messageDetails.get("Body");
        message = new Message(recipient, subject, body);
        sentMessages.put(recipient, message);
        System.out.println("Message sent to " + recipient + ": " + message);
    }

    @Then("The message should be sent successfully to the supplier with the following details")
    public void theMessageShouldBeSentSuccessfullyToTheSupplierWithTheFollowingDetails(DataTable expectedDetailsTable) {
        Map<String, String> expectedDetails = expectedDetailsTable.asMaps(String.class, String.class).get(0);
        String recipient = expectedDetails.get("Recipient");
        Message sentMessage = sentMessages.get(recipient);
        assertNotNull("Message should be sent", sentMessage);
        assertEquals(expectedDetails.get("Subject"), sentMessage.getSubject());
        assertEquals(expectedDetails.get("Body"), sentMessage.getBody());
        System.out.println("Message details verified for " + recipient + ": " + sentMessage);
    }

    // Inner class to represent a message
    private class Message {
        private String recipient;
        private String subject;
        private String body;

        public Message(String recipient, String subject, String body) {
            this.recipient = recipient;
            this.subject = subject;
            this.body = body;
        }

        public String getRecipient() {
            return recipient;
        }

        public String getSubject() {
            return subject;
        }

        public String getBody() {
            return body;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "recipient='" + recipient + '\'' +
                    ", subject='" + subject + '\'' +
                    ", body='" + body + '\'' +
                    '}';
        }
    }
}
