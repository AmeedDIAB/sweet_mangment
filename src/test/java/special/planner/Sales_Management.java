package sweet.management.sales;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class SalesManagementStepDefinition {
    SalesDashboard salesDashboard;
    Product product;

    @Given("I have recorded a sale of {int} units of {string} at {double} each")
    public void iHaveRecordedASaleOfUnitsOfAtEach(int quantity, String productName, double price) {
        salesDashboard = new SalesDashboard();
        product = new Product(productName, "Delicious product", "Category", price, "Ingredients", "Image.jpg");
        salesDashboard.record_sale(productName, quantity, price);
    }

    @Then("The sales dashboard should show {int} units sold and {double} revenue")
    public void theSalesDashboardShouldShowUnitsSoldAndRevenue(int expectedQuantity, double expectedRevenue) {
        assertEquals(expectedQuantity, salesDashboard.get_sales_report().get(product.getName()).get("quantity"));
        assertEquals(expectedRevenue, salesDashboard.get_sales_report().get(product.getName()).get("revenue"), 0.01);
    }
}
