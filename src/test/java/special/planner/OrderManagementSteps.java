package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class OrderManagementSteps {

    private Map<String, String> orderDetails;
    private String currentOrderStatus;

    @Given("The store owner is on the order management page")
    public void theStoreOwnerIsOnTheOrderManagementPage() {
        // Simulate that the store owner is on the order management page
        System.out.println("Store owner is on the order management page.");
    }

    @Given("There is an order with the following details")
    public void thereIsAnOrderWithTheFollowingDetails(DataTable dataTable) {
        orderDetails = new HashMap<>();
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            orderDetails.put(row.get("Order ID"), row.get("Status"));
        }
        System.out.println("Order details: " + orderDetails);
    }

    @When("The store owner processes the order with Order ID {int}")
    public void theStoreOwnerProcessesTheOrderWithOrderID(int orderId) {
        // Simulate processing the order
        String orderIdString = String.valueOf(orderId);
        if (orderDetails.containsKey(orderIdString)) {
            orderDetails.put(orderIdString, "Processed");
            currentOrderStatus = "Processed";
        } else {
            throw new RuntimeException("Order ID not found.");
        }
        System.out.println("Processed order with Order ID: " + orderId);
    }

    @When("The store owner tracks the order with Order ID {int}")
    public void theStoreOwnerTracksTheOrderWithOrderID(int orderId) {
        // Simulate tracking the order
        String orderIdString = String.valueOf(orderId);
        if (orderDetails.containsKey(orderIdString)) {
            currentOrderStatus = orderDetails.get(orderIdString);
        } else {
            throw new RuntimeException("Order ID not found.");
        }
        System.out.println("Tracked order with Order ID: " + orderId);
    }

    @Then("The order status should be updated to {string}")
    public void theOrderStatusShouldBeUpdatedTo(String expectedStatus) {
        assertEquals("Order status does not match.", expectedStatus, currentOrderStatus);
        System.out.println("Order status updated to: " + expectedStatus);
    }

    @Then("The store owner should see the order status as {string}")
    public void theStoreOwnerShouldSeeTheOrderStatusAs(String expectedStatus) {
        assertEquals("Order status does not match.", expectedStatus, currentOrderStatus);
        System.out.println("Order status is: " + expectedStatus);
    }
}
