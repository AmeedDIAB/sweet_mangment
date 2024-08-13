package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductManagementSteps {

    private List<Product> productList;
    private Product updatedProduct;
    private double discountPercentage;

    @Given("The store owner is on the product management page")
    public void theStoreOwnerIsOnTheProductManagementPage() {
        productList = new ArrayList<>();
        System.out.println("Store owner is on the product management page.");
    }

    @Given("The store owner has a product named {string}")
    public void theStoreOwnerHasAProductNamed(String productName) {
        Product product = new Product(productName, 0, 0, "Uncategorized");
        productList.add(product);
        System.out.println("The store owner has a product named " + productName + ".");
    }

    @Given("The store owner has a product named {string} with the following details")
    public void theStoreOwnerHasAProductNamedWithTheFollowingDetails(String productName, DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row : data) {
            if (row.size() < 3) {
                System.err.println("Error: Data row has fewer than expected columns.");
                continue;
            }
            double price;
            int quantity;
            try {
                price = Double.parseDouble(row.get(0));
                quantity = Integer.parseInt(row.get(1));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price or quantity: " + e.getMessage());
                continue;
            }
            String category = row.get(2);
            Product product = new Product(productName, price, quantity, category);
            productList.add(product);
            System.out.println("Product with name " + productName + " and details added.");
        }
    }

    @Given("The store owner has a product named {string} with price {double}")
    public void theStoreOwnerHasAProductNamedWithPrice(String productName, Double price) {
        Product product = new Product(productName, price, 0, "Uncategorized");
        productList.add(product);
        System.out.println("The store owner has a product named " + productName + " with price " + price + ".");
    }

    @When("The store owner adds a new product with the following details")
    public void theStoreOwnerAddsANewProductWithTheFollowingDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row : data.subList(1, data.size())) { // Skip header row
            if (row.size() < 4) {
                System.err.println("Error: Data row has fewer than expected columns.");
                continue;
            }
            String name = row.get(0);
            double price;
            int quantity;
            try {
                price = Double.parseDouble(row.get(1));
                quantity = Integer.parseInt(row.get(2));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price or quantity: " + e.getMessage());
                continue;
            }
            String category = row.get(3);
            productList.add(new Product(name, price, quantity, category));
        }
        System.out.println("Product(s) with specified details added.");
    }

    @Then("The product should be added to the product list")
    public void theProductShouldBeAddedToTheProductList(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row : data.subList(1, data.size())) { // Skip header row
            if (row.size() < 4) {
                System.err.println("Error: Data row has fewer than expected columns.");
                continue;
            }
            String name = row.get(0);
            double price;
            int quantity;
            try {
                price = Double.parseDouble(row.get(1));
                quantity = Integer.parseInt(row.get(2));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price or quantity: " + e.getMessage());
                continue;
            }
            String category = row.get(3);
            Product expectedProduct = new Product(name, price, quantity, category);
            assertTrue("Product " + expectedProduct + " should be in the list.", productList.contains(expectedProduct));
        }
        System.out.println("Product(s) verified in the product list.");
    }

    @When("The store owner removes the product with name {string}")
    public void theStoreOwnerRemovesTheProductWithName(String productName) {
        productList.removeIf(product -> product.getName().equals(productName));
        System.out.println("Product with name " + productName + " removed.");
    }

    @Then("The product should be removed from the product list")
    public void theProductShouldBeRemovedFromTheProductList(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row : data.subList(1, data.size())) { // Skip header row
            if (row.size() < 1) {
                System.err.println("Error: Data row has fewer than expected columns.");
                continue;
            }
            String name = row.get(0);
            Product product = new Product(name, 0, 0, "Uncategorized");
            assertFalse("Product " + product + " should be removed from the list.", productList.contains(product));
        }
        System.out.println("Product(s) removed from the product list.");
    }

    @When("The store owner updates the product with the following details")
    public void theStoreOwnerUpdatesTheProductWithTheFollowingDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row : data.subList(1, data.size())) { // Skip header row
            if (row.size() < 4) {
                System.err.println("Error: Data row has fewer than expected columns.");
                continue;
            }
            String name = row.get(0);
            double price;
            int quantity;
            try {
                price = Double.parseDouble(row.get(1));
                quantity = Integer.parseInt(row.get(2));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price or quantity: " + e.getMessage());
                continue;
            }
            String category = row.get(3);
            updatedProduct = new Product(name, price, quantity, category);
            boolean productFound = false;
            for (Product product : productList) {
                if (product.getName().equals(name)) {
                    productList.remove(product);
                    productList.add(updatedProduct);
                    productFound = true;
                    break;
                }
            }
            if (!productFound) {
                System.err.println("Product with name " + name + " not found for update.");
            }
        }
        System.out.println("Product updated.");
    }

    @Then("The product should be updated in the product list")
    public void theProductShouldBeUpdatedInTheProductList(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> row : data.subList(1, data.size())) { // Skip header row
            if (row.size() < 4) {
                System.err.println("Error: Data row has fewer than expected columns.");
                continue;
            }
            String name = row.get(0);
            double price;
            int quantity;
            try {
                price = Double.parseDouble(row.get(1));
                quantity = Integer.parseInt(row.get(2));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price or quantity: " + e.getMessage());
                continue;
            }
            String category = row.get(3);
            Product expectedProduct = new Product(name, price, quantity, category);
            assertTrue("Expected product " + expectedProduct + " not found in the list.", productList.contains(expectedProduct));
        }
        System.out.println("Updated product verified in the product list.");
    }

    @When("The store owner sets a discount of {int}% on {string}")
    public void theStoreOwnerSetsADiscountOfOn(Integer discount, String productName) {
        discountPercentage = discount;
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                double discountedPrice = product.getPrice() * (1 - discount / 100.0);
                product.setPrice(discountedPrice);
                System.out.println("Discount of " + discount + "% applied to " + productName + ".");
                return;
            }
        }
        System.err.println("Product with name " + productName + " not found for discount application.");
    }

    @Then("The price of {string} should be updated to {double}")
    public void thePriceOfShouldBeUpdatedTo(String productName, Double expectedPrice) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                assertEquals("Price for product " + productName + " does not match expected value.", expectedPrice, product.getPrice(), 0.01);
                System.out.println("Price of " + productName + " updated to " + expectedPrice + ".");
                return;
            }
        }
        System.err.println("Product with name " + productName + " not found for price validation.");
    }

    @Given("The store owner is on the sales and profits page")
    public void theStoreOwnerIsOnTheSalesAndProfitsPage() {
        System.out.println("Store owner is on the sales and profits page.");
    }

    @When("The store owner views the sales and profit reports")
    public void theStoreOwnerViewsTheSalesAndProfitReports() {
        System.out.println("Store owner views the sales and profit reports.");
        // Implement your logic to display reports
    }

    @Then("The store owner should see the total sales and profits")
    public void theStoreOwnerShouldSeeTheTotalSalesAndProfits() {
        System.out.println("Store owner should see the total sales and profits.");
        // Implement your assertion or verification logic
    }

    @Given("The store owner is on the best-selling products page")
    public void theStoreOwnerIsOnTheBestSellingProductsPage() {
        System.out.println("Store owner is on the best-selling products page.");
    }

    @When("The store owner views the best-selling products report")
    public void theStoreOwnerViewsTheBestSellingProductsReport() {
        System.out.println("Store owner views the best-selling products report.");
        // Implement your logic to display best-selling products
    }

    @Then("The store owner should see a list of best-selling products")
    public void theStoreOwnerShouldSeeAListOfBestSellingProducts() {
        System.out.println("Store owner should see a list of best-selling products.");
        // Implement your assertion or verification logic
    }

    // Inner class for Product
    public static class Product {
        private String name;
        private double price;
        private int quantity;
        private String category;

        public Product(String name, double price, int quantity, String category) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Double.compare(product.price, price) == 0 &&
                    quantity == product.quantity &&
                    name.equals(product.name) &&
                    category.equals(product.category);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, quantity, category);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
}
