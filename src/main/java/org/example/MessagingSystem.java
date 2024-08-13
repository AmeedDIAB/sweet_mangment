package org.example;

import java.util.ArrayList;
import java.util.List;

public class MessagingSystem {
    private List<Message> sentMessages;

    // Constructor
    public MessagingSystem() {
        this.sentMessages = new ArrayList<>();
    }

    // Method to send a message
    public boolean sendMessage(Message message) {
        if (message.getRecipient() == null || message.getSubject() == null || message.getBody() == null) {
            return false; // Message is not valid
        }

        sentMessages.add(message);
        return true; // Message sent successfully
    }

    // Method to retrieve sent messages
    public List<Message> getSentMessages() {
        return sentMessages;
    }
}
