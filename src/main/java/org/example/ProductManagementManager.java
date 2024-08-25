package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductManagementManager {

    private List<Product> productList;
    private Product updatedProduct;
    private double discountPercentage;

    public ProductManagementManager() {
        productList = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity, String category) {
        Product product = new Product(name, price, quantity, category);
        productList.add(product);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(String name) {
        productList.removeIf(product -> product.getName().equals(name));
    }

    public void updateProduct(String name, double price, int quantity, String category) {
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
            throw new RuntimeException("Product with name " + name + " not found for update.");
        }
    }

    public void setDiscount(String name, double discountPercentage) {
        this.discountPercentage = discountPercentage;
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                double discountedPrice = product.getPrice() * (1 - discountPercentage / 100.0);
                product.setPrice(discountedPrice);
                return;
            }
        }
        throw new RuntimeException("Product with name " + name + " not found for discount application.");
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);
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
