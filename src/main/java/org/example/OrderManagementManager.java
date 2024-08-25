package org.example;

import java.util.HashMap;
import java.util.Map;

public class OrderManagementManager {

    private Map<String, String> orderDetails;
    private String currentOrderStatus;

    public OrderManagementManager() {
        orderDetails = new HashMap<>();
    }

    public void addOrder(String orderId, String status) {
        orderDetails.put(orderId, status);
    }

    public void processOrder(int orderId) {
        String orderIdString = String.valueOf(orderId);
        if (orderDetails.containsKey(orderIdString)) {
            orderDetails.put(orderIdString, "Processed");
            currentOrderStatus = "Processed";
        } else {
            throw new RuntimeException("Order ID not found.");
        }
    }

    public void trackOrder(int orderId) {
        String orderIdString = String.valueOf(orderId);
        if (orderDetails.containsKey(orderIdString)) {
            currentOrderStatus = orderDetails.get(orderIdString);
        } else {
            throw new RuntimeException("Order ID not found.");
        }
    }

    public String getCurrentOrderStatus() {
        return currentOrderStatus;
    }

    public Map<String, String> getOrderDetails() {
        return new HashMap<>(orderDetails);
    }
}
