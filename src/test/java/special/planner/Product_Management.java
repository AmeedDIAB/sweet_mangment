@Scenario: Managing Product Lifecycle
@Given("I have a product named {string} with a price of {double}")
public void iHaveAProductNamedWithAPriceOf(String productName, double initialPrice) {
    inventory = new Inventory();
    product = new Product(productName, "Delicious product", "Category", initialPrice, "Ingredients", "Image.jpg");
}

@When("I add the product to the inventory")
public void iAddTheProductToTheInventory() {
    inventory.add_product(product);
}

@Then("The product should be in the inventory")
public void theProductShouldBeInTheInventory() {
    assertNotNull(inventory.get_product(product.getName()));
    assertEquals(product.getName(), inventory.get_product(product.getName()).getName());
}

@When("I update the product's price to {double}")
public void iUpdateTheProductSPriceTo(Double newPrice) {
    product.update_product(price=newPrice);
}

@Then("The product's price should be updated to {double}")
public void theProductSPriceShouldBeUpdatedTo(Double expectedPrice) {
    assertEquals(expectedPrice, inventory.get_product(product.getName()).getPrice(), 0.01);
}

@When("I remove the product from the inventory")
public void iRemoveTheProductFromTheInventory() {
    inventory.remove_product(product.getName());
}

@Then("The product should no longer be in the inventory")
public void theProductShouldNoLongerBeInTheInventory() {
    assertNull(inventory.get_product(product.getName()));
}
