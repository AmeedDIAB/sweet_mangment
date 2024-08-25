package special.planner;

import org.example.CommunicationAndNotification;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommunicationAndNotificationTest {

    private CommunicationAndNotification communicationAndNotification;

    @Before
    public void setUp() {
        communicationAndNotification = new CommunicationAndNotification();
    }

    @Test
    public void testStoreOwnerOnMessagingSystemPage() {
        communicationAndNotification.onMessagingSystemPage();
        // No assertion needed, just testing method execution
    }

    @Test
    public void testStoreOwnerOffMessagingSystemPage() {
        communicationAndNotification.offMessagingSystemPage();
        // No assertion needed, just testing method execution
    }

    @Test
    public void testSendMessageToUserWhenOnPage() {
        communicationAndNotification.onMessagingSystemPage();

        String recipient = "user@example.com";
        String subject = "Welcome";
        String body = "Welcome to our service!";
        communicationAndNotification.sendMessageToUser(recipient, subject, body);

        CommunicationAndNotification.Message sentMessage = communicationAndNotification.getSentMessages().get(recipient);
        assertNotNull("Message should be sent to user", sentMessage);
        assertEquals(subject, sentMessage.getSubject());
        assertEquals(body, sentMessage.getBody());
    }

    @Test
    public void testSendMessageToSupplierWhenOnPage() {
        communicationAndNotification.onMessagingSystemPage();

        String recipient = "supplier@example.com";
        String subject = "Order Update";
        String body = "Your order has been shipped!";
        communicationAndNotification.sendMessageToSupplier(recipient, subject, body);

        CommunicationAndNotification.Message sentMessage = communicationAndNotification.getSentMessages().get(recipient);
        assertNotNull("Message should be sent to supplier", sentMessage);
        assertEquals(subject, sentMessage.getSubject());
        assertEquals(body, sentMessage.getBody());
    }

    @Test
    public void testSendMessageWhenNotOnPage() {
        communicationAndNotification.offMessagingSystemPage();

        String recipient = "user@example.com";
        String subject = "Welcome";
        String body = "Welcome to our service!";
        communicationAndNotification.sendMessageToUser(recipient, subject, body);

        // Check that no message was sent
        assertNull("Message should not be sent when store owner is off the messaging system page",
                communicationAndNotification.getSentMessages().get(recipient));
    }

    @Test
    public void testVerifyMessageSentToUser() {
        communicationAndNotification.onMessagingSystemPage();

        String recipient = "user@example.com";
        String subject = "Welcome";
        String body = "Welcome to our service!";
        communicationAndNotification.sendMessageToUser(recipient, subject, body);

        assertTrue(communicationAndNotification.verifyMessageSent(recipient, subject, body));
    }

    @Test
    public void testVerifyMessageSentToSupplier() {
        communicationAndNotification.onMessagingSystemPage();

        String recipient = "supplier@example.com";
        String subject = "Order Update";
        String body = "Your order has been shipped!";
        communicationAndNotification.sendMessageToSupplier(recipient, subject, body);

        assertTrue(communicationAndNotification.verifyMessageSent(recipient, subject, body));
    }

    @Test
    public void testVerifyNoMessageFound() {
        communicationAndNotification.onMessagingSystemPage();

        String recipient = "nonexistent@example.com";
        String subject = "Nonexistent";
        String body = "This message should not exist.";

        assertFalse(communicationAndNotification.verifyMessageSent(recipient, subject, body));
    }
}
