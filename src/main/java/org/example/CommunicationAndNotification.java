package org.example;

import java.util.HashMap;
import java.util.Map;

public class CommunicationAndNotification {

    private Map<String, Message> sentMessages = new HashMap<>();
    private boolean storeOwnerOnMessagingSystemPage;

    // Simulate that the store owner is on the messaging system page
    public void onMessagingSystemPage() {
        storeOwnerOnMessagingSystemPage = true;
        System.out.println("Store owner is on the messaging system page.");
    }

    // Simulate that the store owner is not on the messaging system page
    public void offMessagingSystemPage() {
        storeOwnerOnMessagingSystemPage = false;
        System.out.println("Store owner is off the messaging system page.");
    }

    // Method to send a message to a recipient (user or supplier)
    private void sendMessage(String recipient, String subject, String body) {
        if (storeOwnerOnMessagingSystemPage) {
            Message message = new Message(recipient, subject, body);
            sentMessages.put(recipient, message);
            System.out.println("Message sent to " + recipient + ": " + message);
        } else {
            System.out.println("Store owner is not on the messaging system page.");
        }
    }

    // Method to send a message to a user
    public void sendMessageToUser(String recipient, String subject, String body) {
        sendMessage(recipient, subject, body);
    }

    // Method to send a message to a supplier
    public void sendMessageToSupplier(String recipient, String subject, String body) {
        sendMessage(recipient, subject, body);
    }

    // Method to verify if a message was sent successfully with the correct details
    public boolean verifyMessageSent(String recipient, String subject, String body) {
        Message sentMessage = sentMessages.get(recipient);
        if (sentMessage == null) {
            System.out.println("No message found for recipient: " + recipient);
            return false;
        }

        boolean isSubjectCorrect = sentMessage.getSubject().equals(subject);
        boolean isBodyCorrect = sentMessage.getBody().equals(body);

        if (isSubjectCorrect && isBodyCorrect) {
            System.out.println("Message details verified for " + recipient + ": " + sentMessage);
            return true;
        } else {
            System.out.println("Message details do not match for " + recipient + ": " + sentMessage);
            return false;
        }
    }

    // Getter for sent messages (useful for testing)
    public Map<String, Message> getSentMessages() {
        return sentMessages;
    }

    // Inner class to represent a message
    public class Message {
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
