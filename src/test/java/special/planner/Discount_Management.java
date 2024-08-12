package sweet.management.discount;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class DiscountManagementStepDefinition {
    DiscountManager discountManager;
    Product product;

    @Given("I have a product named {string} with a price of {double}")
    public void iHaveAProductNamedWithAPriceOf(String productName, double price) {
        discountManager = new DiscountManager();
        product = new Product(productName, "Delicious product", "Category", price, "Ingredients", "Image.jpg");
    }

    @When("I set a discount of {int}% for the product")
    public void iSetADiscountOfForTheProduct(int discountPercentage) {
        discountManager.set_discount(product.getName(), discountPercentage);
    }

    @Then("The product's price after discount should be {double}")
    public void theProductSPriceAfterDiscountShouldBe(Double expectedDiscountedPrice) {
        double discountedPrice = discountManager.apply_discount(product.getName(), product.getPrice());
        assertEquals(expectedDiscountedPrice, discountedPrice, 0.01);
    }
}
