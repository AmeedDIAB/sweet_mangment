package org.example;



import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private List<Product> products;

    public ProductManagement() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String productName, Product updatedProduct) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setQuantity(updatedProduct.getQuantity());
                product.setCategory(updatedProduct.getCategory());
                break;
            }
        }
    }

    public void removeProduct(String productName) {
        products.removeIf(product -> product.getName().equals(productName));
    }

    public Product getProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Product product : products) {
            totalSales += product.getPrice() * product.getQuantity();
        }
        return totalSales;
    }

    public List<Product> getBestSellingProducts() {
        products.sort((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
        return products;
    }

    public void applyDiscount(String productName, double discountPercentage) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                double discountedPrice = product.getPrice() - (product.getPrice() * discountPercentage / 100);
                product.setPrice(discountedPrice);
                break;
            }
        }
    }
}
