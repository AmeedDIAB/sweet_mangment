package special.planner;

import org.example.OrderManagementManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderManagementManagerTest {

    private OrderManagementManager manager;

    @Before
    public void setUp() {
        manager = new OrderManagementManager();
        manager.addOrder("1", "Pending");
        manager.addOrder("2", "Shipped");
        manager.addOrder("3", "Delivered");
    }

    @Test
    public void testProcessOrder() {
        manager.processOrder(1);
        assertEquals("Processed", manager.getCurrentOrderStatus());
        assertEquals("Processed", manager.getOrderDetails().get("1"));
    }

    @Test
    public void testTrackOrder() {
        manager.trackOrder(2);
        assertEquals("Shipped", manager.getCurrentOrderStatus());
    }

    @Test(expected = RuntimeException.class)
    public void testProcessOrderWithInvalidId() {
        manager.processOrder(999); // Order ID not in the list
    }

    @Test(expected = RuntimeException.class)
    public void testTrackOrderWithInvalidId() {
        manager.trackOrder(999); // Order ID not in the list
    }

    @Test
    public void testAddOrder() {
        manager.addOrder("4", "Pending");
        assertEquals("Pending", manager.getOrderDetails().get("4"));
    }
}
