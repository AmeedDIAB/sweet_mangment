package org.example;

import java.util.HashMap;
import java.util.Map;

public class MonitoringAndReportingManager {

    private boolean adminLoggedIn;
    private Map<String, Double> financialReports;
    private Map<String, Integer> bestSellingProducts;
    private Map<String, Integer> userRegistrationStats;

    public MonitoringAndReportingManager() {
        // Initialize data
        financialReports = new HashMap<>();
        bestSellingProducts = new HashMap<>();
        userRegistrationStats = new HashMap<>();

        // Simulate some data
        financialReports.put("2024-01-01 to 2024-12-31", 150000.00);
        bestSellingProducts.put("Product A", 500);
        bestSellingProducts.put("Product B", 300);
        userRegistrationStats.put("Nablus", 1200);
        userRegistrationStats.put("Jenin", 800);
    }

    public void loginAsAdmin() {
        adminLoggedIn = true;
        System.out.println("Admin logged in successfully.");
    }

    public boolean isAdminLoggedIn() {
        return adminLoggedIn;
    }

    public double viewFinancialReports(String startDate, String endDate) {
        if (adminLoggedIn) {
            // Simulate viewing financial reports for the specified period
            String key = startDate + " to " + endDate;
            return financialReports.getOrDefault(key, 0.0);
        }
        return 0.0;
    }

    public Map<String, Integer> viewBestSellingProducts() {
        if (adminLoggedIn) {
            // Simulate viewing best-selling products
            return new HashMap<>(bestSellingProducts);
        }
        return new HashMap<>();
    }

    public Map<String, Integer> viewUserRegistrationStatistics() {
        if (adminLoggedIn) {
            // Simulate viewing user registration statistics by city
            return new HashMap<>(userRegistrationStats);
        }
        return new HashMap<>();
    }
}
