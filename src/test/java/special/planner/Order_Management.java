package sweet.management.order;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class OrderManagementStepDefinition {
    OrderManager orderManager;
    Order order;

    @Given("I have placed an order for {int} units of {string}")
    public void iHavePlacedAnOrderForUnitsOf(String productName, int quantity) {
        orderManager = new OrderManager();
        order = new Order("Customer", productName, quantity);
        orderManager.place_order(order);
    }

    @Then("The order status should be {string}")
    public void theOrderStatusShouldBe(String expectedStatus) {
        assertEquals(expectedStatus, orderManager.get_order_status(order));
    }
}
