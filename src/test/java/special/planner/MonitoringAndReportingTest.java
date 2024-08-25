package special.planner;

import org.example.MonitoringAndReportingManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

public class MonitoringAndReportingTest {

    private MonitoringAndReportingManager manager;

    @Before
    public void setUp() {
        manager = new MonitoringAndReportingManager();
        manager.loginAsAdmin();
    }

    @Test
    public void testViewFinancialReports() {
        double totalProfits = manager.viewFinancialReports("2024-01-01", "2024-12-31");
        assertEquals(150000.00, totalProfits, 0.01);
    }

    @Test
    public void testViewBestSellingProducts() {
        Map<String, Integer> bestSellingProducts = manager.viewBestSellingProducts();
        assertEquals(500, (int) bestSellingProducts.get("Product A"));
        assertEquals(300, (int) bestSellingProducts.get("Product B"));
    }

    @Test
    public void testViewUserRegistrationStatistics() {
        Map<String, Integer> registrationStats = manager.viewUserRegistrationStatistics();
        assertEquals(1200, (int) registrationStats.get("Nablus"));
        assertEquals(800, (int) registrationStats.get("Jenin"));
    }
}
