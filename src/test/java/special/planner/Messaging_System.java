package sweet.management.messaging;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class MessagingSystemStepDefinition {
    MessagingSystem messagingSystem;

    @Given("I have sent a message {string} to {string}")
    public void iHaveSentAMessageTo(String messageContent, String receiver) {
        messagingSystem = new MessagingSystem();
        Message message = new Message("Sender", receiver, messageContent);
        messagingSystem.send_message(message);
    }

    @Then("The receiver should have received the message {string}")
    public void theReceiverShouldHaveReceivedTheMessage(String expectedMessageContent) {
        assertEquals(expectedMessageContent, messagingSystem.get_messages("Receiver").get(0).getContent());
    }
}
