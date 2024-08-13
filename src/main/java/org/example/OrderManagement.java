package org.example;


import java.util.HashMap;
import java.util.Map;

public class OrderManagement {
    private Map<Integer, Order> orders;

    // Constructor
    public OrderManagement() {
        this.orders = new HashMap<>();
    }

    // Method to add an order
    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    // Method to process an order
    public boolean processOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order != null && "Pending".equals(order.getStatus())) {
            order.setStatus("Processed");
            return true;
        }
        return false;
    }

    // Method to track an order
    public Order trackOrder(int orderId) {
        return orders.get(orderId);
    }

    // Method to retrieve all orders (for testing or management purposes)
    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
