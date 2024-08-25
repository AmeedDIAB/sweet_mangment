package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContentManagement {

    private boolean adminLoggedIn;
    private List<String> sharedContent;
    private List<String> userFeedback;
    private boolean feedbackDeleted;
    private boolean feedbackResponded;

    public ContentManagement() {
        this.adminLoggedIn = false;
        this.sharedContent = new ArrayList<>();
        this.userFeedback = new ArrayList<>();
        this.feedbackDeleted = false;
        this.feedbackResponded = false;
    }

    // Simulate admin login
    public void loginAsAdmin() {
        adminLoggedIn = true;
        System.out.println("Admin logged in successfully for content management.");
    }

    // Simulate viewing shared content
    public void viewSharedContent() {
        if (!adminLoggedIn) {
            throw new IllegalStateException("Admin must be logged in to view shared content.");
        }
        // Simulate viewing shared content
        sharedContent.add("Recipe: Chocolate Cake");
        sharedContent.add("Post: How to make a perfect pie");
        System.out.println("Viewing content shared on the system.");
    }

    // Simulate viewing user feedback
    public void viewUserFeedback() {
        if (!adminLoggedIn) {
            throw new IllegalStateException("Admin must be logged in to view user feedback.");
        }
        // Simulate viewing user feedback
        userFeedback.add("Great recipe, really enjoyed it!");
        userFeedback.add("The pie recipe was not clear.");
        System.out.println("Viewing user feedback.");
    }

    // Get the list of shared content
    public List<String> getSharedContent() {
        return sharedContent;
    }

    // Get the list of user feedback
    public List<String> getUserFeedback() {
        return userFeedback;
    }

    // Simulate deleting and responding to feedback
    public void deleteOrRespondToFeedback() {
        if (userFeedback != null && !userFeedback.isEmpty()) {
            feedbackDeleted = true; // Simulating successful deletion
            feedbackResponded = true; // Simulating successful response
        } else {
            feedbackDeleted = false;
            feedbackResponded = false;
        }
        System.out.println("Feedback deleted and responded to successfully.");
    }

    // Check if feedback was deleted
    public boolean isFeedbackDeleted() {
        return feedbackDeleted;
    }

    // Check if feedback was responded to
    public boolean isFeedbackResponded() {
        return feedbackResponded;
    }

    // Check if admin is logged in
    public boolean isAdminLoggedIn() {
        return adminLoggedIn;
    }

    // Simulate logging out
    public void logout() {
        adminLoggedIn = false;
        System.out.println("Admin logged out successfully.");
    }
}
