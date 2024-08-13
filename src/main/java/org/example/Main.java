package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Iterator;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminPage adminPage = new AdminPage();
        Store store = new Store();
        ManagerPage managerPage = new ManagerPage(store);

        // Sample products for demonstration
        store.addProduct(new Product("Gingerbread", 5.99));
        store.addProduct(new Product("Chocolate Cake", 7.99));

        System.out.println("\n--- Main Page ---");
        System.out.println("1. Admin");
        System.out.println("2. Manager(Store Owner / Supplier)");
        System.out.println("3. User");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Show Admin Page
                adminPage.showAdminPage();
                break;

            case 2:
                // Show Manager Page
                managerPage.showManagerPage();
                break;

            case 3:
                UserPage userPage = new UserPage();

                // Sample actions for testing
                userPage.signUp();
                userPage.signIn();
                userPage.manageAccount();
                userPage.postDessertCreation();
                break;

        }





    }
}

// Admin Page
class AdminPage {

    private Admin admin;
    private Store store;  // Added Store for managing products and sales

    public AdminPage() {
        this.admin = new Admin();
        this.store = new Store();  // Initialize Store
    }

    public void showAdminPage() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Admin Page ---");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Remove User");
            System.out.println("4. List Users");
            System.out.println("5. Content Management"); // Added Content Management
            System.out.println("6. Monitoring and Reporting");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;

                case 2:
                    updateUser(scanner);
                    break;

                case 3:
                    removeUser(scanner);
                    break;

                case 4:
                    admin.listUsers();
                    break;

                case 5:
                    showContentManagement(scanner);
                    break;

                case 6:
                    showMonitoringAndReporting(scanner);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("1. Returning to Admin Page");
            choice = scanner.nextInt();
            if (choice == 1) {
                continue;
            }
        }
    }

    private void addUser(Scanner scanner) {
        System.out.print("Enter user type (storeOwner/supplier): ");
        String type = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();  // Added city

        if (type.equalsIgnoreCase("storeOwner")) {
            admin.addUser(new StoreOwner(userId, name, email, city));
        } else if (type.equalsIgnoreCase("supplier")) {
            admin.addUser(new Supplier(userId, name, email, city));
        } else {
            System.out.println("Invalid user type.");
        }
    }

    private void updateUser(Scanner scanner) {
        System.out.print("Enter user ID to update: ");
        String userId = scanner.nextLine();
        if (admin.getUserById(userId) == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        admin.updateUser(userId, name, email);
    }

    private void removeUser(Scanner scanner) {
        System.out.print("Enter user ID to remove: ");
        String userId = scanner.nextLine();
        if (admin.getUserById(userId) == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }
        admin.removeUser(userId);
    }

    private void showMonitoringAndReporting(Scanner scanner) {
        System.out.println("\n--- Monitoring and Reporting ---");
        System.out.println("1. Generate Financial Report");
        System.out.println("2. Best-Selling Products");
        System.out.println("3. User Statistics by City");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                store.generateFinancialReport();
                break;

            case 2:
                store.showBestSellingProducts();
                break;

            case 3:
                admin.showUserStatisticsByCity();
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void showContentManagement(Scanner scanner) {
        System.out.println("\n--- Content Management ---");
        System.out.println("1. Manage Recipes");
        System.out.println("2. Manage Posts");
        System.out.println("3. Manage User Feedback");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                manageRecipes(scanner);
                break;

            case 2:
                managePosts(scanner);
                break;

            case 3:
                manageFeedback(scanner);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void manageRecipes(Scanner scanner) {
        System.out.println("\n--- Recipe Management ---");
        System.out.println("1. Add Recipe");
        System.out.println("2. Update Recipe");
        System.out.println("3. Remove Recipe");
        System.out.println("4. List Recipes");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter recipe ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter recipe title: ");
                String title = scanner.nextLine();
                System.out.print("Enter recipe description: ");
                String description = scanner.nextLine();
                admin.addRecipe(new Recipe(id, title, description));
                break;

            case 2:
                System.out.print("Enter recipe ID to update: ");
                id = scanner.nextLine();
                System.out.print("Enter new title: ");
                title = scanner.nextLine();
                System.out.print("Enter new description: ");
                description = scanner.nextLine();
                admin.updateRecipe(id, title, description);
                break;

            case 3:
                System.out.print("Enter recipe ID to remove: ");
                id = scanner.nextLine();
                admin.removeRecipe(id);
                break;

            case 4:
                admin.listRecipes();
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void managePosts(Scanner scanner) {
        System.out.println("\n--- Post Management ---");
        System.out.println("1. Add Post");
        System.out.println("2. Update Post");
        System.out.println("3. Remove Post");
        System.out.println("4. List Posts");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter post ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter post title: ");
                String title = scanner.nextLine();
                System.out.print("Enter post content: ");
                String content = scanner.nextLine();
                admin.addPost(new Post(id, title, content));
                break;

            case 2:
                System.out.print("Enter post ID to update: ");
                id = scanner.nextLine();
                System.out.print("Enter new title: ");
                title = scanner.nextLine();
                System.out.print("Enter new content: ");
                content = scanner.nextLine();
                admin.updatePost(id, title, content);
                break;

            case 3:
                System.out.print("Enter post ID to remove: ");
                id = scanner.nextLine();
                admin.removePost(id);
                break;

            case 4:
                admin.listPosts();
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void manageFeedback(Scanner scanner) {
        System.out.println("\n--- Feedback Management ---");
        System.out.println("1. Add Feedback");
        System.out.println("2. List Feedback");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter user ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter feedback content: ");
                String content = scanner.nextLine();
                admin.addFeedback(new Feedback(userId, content));
                break;

            case 2:
                admin.listFeedbacks();
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

// User Class
abstract class User {
    private String userId;
    private String name;
    private String email;
    private String city;  // Added city

    public User(String userId, String name, String email, String city) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Email: " + email + ", City: " + city + ", Role: " + getRole();
    }
}

// StoreOwner Class
class StoreOwner extends User {
    public StoreOwner(String userId, String name, String email, String city) {
        super(userId, name, email, city);
    }

    @Override
    public String getRole() {
        return "Store Owner";
    }
}

// Supplier Class
class Supplier extends User {
    public Supplier(String userId, String name, String email, String city) {
        super(userId, name, email, city);
    }

    @Override
    public String getRole() {
        return "Supplier";
    }
}

// Admin Class
class Admin {
    private List<User> users;
    private List<Recipe> recipes;
    private List<Post> posts;
    private List<Feedback> feedbacks;

    public Admin() {
        this.users = new ArrayList<User>();
        this.recipes = new ArrayList<Recipe>();
        this.posts = new ArrayList<Post>();
        this.feedbacks = new ArrayList<Feedback>();
    }

    // Recipe Management
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        System.out.println("Recipe added: " + recipe);
    }

    public void updateRecipe(String id, String newTitle, String newDescription) {
        for (Recipe recipe : recipes) {
            if (recipe.getId().equals(id)) {
                // Note: Since Recipe is immutable, you might want to remove and re-add it.
                recipes.remove(recipe);
                recipes.add(new Recipe(id, newTitle, newDescription));
                System.out.println("Recipe updated: " + new Recipe(id, newTitle, newDescription));
                return;
            }
        }
        System.out.println("Recipe not found with ID: " + id);
    }

    public void removeRecipe(String id) {
        Iterator<Recipe> iterator = recipes.iterator();
        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe.getId().equals(id)) {
                iterator.remove();
                System.out.println("Recipe removed with ID: " + id);
                return;
            }
        }
        System.out.println("Recipe not found with ID: " + id);
    }

    public void listRecipes() {
        System.out.println("All recipes:");
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    // Post Management
    public void addPost(Post post) {
        posts.add(post);
        System.out.println("Post added: " + post);
    }

    public void updatePost(String id, String newTitle, String newContent) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                // Note: Since Post is immutable, you might want to remove and re-add it.
                posts.remove(post);
                posts.add(new Post(id, newTitle, newContent));
                System.out.println("Post updated: " + new Post(id, newTitle, newContent));
                return;
            }
        }
        System.out.println("Post not found with ID: " + id);
    }

    public void removePost(String id) {
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId().equals(id)) {
                iterator.remove();
                System.out.println("Post removed with ID: " + id);
                return;
            }
        }
        System.out.println("Post not found with ID: " + id);
    }

    public void listPosts() {
        System.out.println("All posts:");
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    // Feedback Management
    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        System.out.println("Feedback added: " + feedback);
    }

    public void listFeedbacks() {
        System.out.println("All feedbacks:");
        for (Feedback feedback : feedbacks) {
            System.out.println(feedback);
        }
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    // Update user information
    public void updateUser(String userId, String newName, String newEmail) {
        User user = getUserById(userId);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
            System.out.println("User updated: " + user);
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    // Remove a user
    public void removeUser(String userId) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUserId().equals(userId)) {
                iterator.remove();
                System.out.println("User removed with ID: " + userId);
                return;
            }
        }
        System.out.println("User not found with ID: " + userId);
    }

    // List all users
    public void listUsers() {
        System.out.println("All users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    // Get user by ID
    public User getUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Show user statistics by city
    public void showUserStatisticsByCity() {
        Map<String, Integer> cityStats = new HashMap<String, Integer>();
        for (User user : users) {
            String city = user.getCity();
            cityStats.put(city, cityStats.getOrDefault(city, 0) + 1);
        }
        System.out.println("User statistics by city:");
        for (Map.Entry<String, Integer> entry : cityStats.entrySet()) {
            System.out.println("City: " + entry.getKey() + ", Number of Users: " + entry.getValue());
        }
    }
}

// Store Class
class Store {
    private List<Product> products;
    private Map<Product, Integer> sales;
    private Map<Product, Double> discounts;
    private Map<String, Order> orders; // Map to track orders by their ID
    private List<DessertRecipe> dessertRecipes; // New list for dessert recipes

    public Store() {
        this.products = new ArrayList<>();
        this.sales = new HashMap<>();
        this.discounts = new HashMap<>();
        this.orders = new HashMap<>();
        this.dessertRecipes = new ArrayList<>(); // Initialize dessert recipes list
    }

    // Add a product to the store
    public void addProduct(Product product) {
        products.add(product);
        sales.put(product, 0);  // Initialize sales count
        discounts.put(product, 0.0); // Initialize discount
    }

    // Update a product's price
    public void updateProduct(String name, double newPrice) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                products.add(new Product(name, newPrice));
                System.out.println("Product updated: " + product);
                return;
            }
        }
        System.out.println("Product not found: " + name);
    }

    // Remove a product from the store
    public void removeProduct(String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                sales.remove(product);
                discounts.remove(product);
                System.out.println("Product removed: " + name);
                return;
            }
        }
        System.out.println("Product not found: " + name);
    }

    // List all products
    public void listProducts() {
        System.out.println("All products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Get all products
    public List<Product> getProducts() {
        return new ArrayList<Product>(products);  // Return a copy to avoid modification of the original list
    }

    // Apply discount to a product
    public void applyDiscount(String name, double discountPercentage) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                discounts.put(product, discountPercentage);
                System.out.println("Discount applied: " + discountPercentage + "% to " + name);
                return;
            }
        }
        System.out.println("Product not found: " + name);
    }

    // Record a sale
    public void recordSale(Product product, int quantity) {
        if (products.contains(product)) {
            sales.put(product, sales.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found in store.");
        }
    }

    // Generate a financial report
    public void generateFinancialReport() {
        double totalSales = 0;
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            Product product = entry.getKey();
            int quantitySold = entry.getValue();
            double price = product.getPrice();
            double discount = discounts.getOrDefault(product, 0.0);
            double finalPrice = price - (price * discount / 100);
            totalSales += finalPrice * quantitySold;
        }
        System.out.println("Financial Report:");
        System.out.println("Total Sales: $" + totalSales);
    }

    // Show best-selling products
    public void showBestSellingProducts() {
        List<Map.Entry<Product, Integer>> salesList = new ArrayList<Map.Entry<Product, Integer>>(sales.entrySet());
        salesList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));  // Sort by quantity sold

        System.out.println("Best-Selling Products:");
        for (Map.Entry<Product, Integer> entry : salesList) {
            Product product = entry.getKey();
            int quantitySold = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Quantity Sold: " + quantitySold);
        }
    }
    // Add a new dessert recipe
    public void addDessertRecipe(DessertRecipe recipe) {
        dessertRecipes.add(recipe);
    }

    // List all dessert recipes
    public void listDessertRecipes() {
        if (dessertRecipes.isEmpty()) {
            System.out.println("No dessert recipes available.");
        } else {
            for (DessertRecipe recipe : dessertRecipes) {
                System.out.println(recipe);
            }
        }
    }

    // Search for dessert recipes by name or description
    public void searchDessertRecipes(String keyword) {
        boolean found = false;
        for (DessertRecipe recipe : dessertRecipes) {
            if (recipe.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(recipe);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recipes found with the keyword: " + keyword);
        }
    }

    // Filter dessert recipes based on dietary tags
    public void filterDessertRecipes(List<String> dietaryTags) {
        boolean found = false;
        for (DessertRecipe recipe : dessertRecipes) {
            if (recipe.getDietaryTags().containsAll(dietaryTags)) {
                System.out.println(recipe);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recipes match the dietary tags: " + dietaryTags);
        }
    }

    // Purchase a dessert recipe
    public void purchaseDessertRecipe(String recipeName, User user) {
        for (DessertRecipe recipe : dessertRecipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                System.out.println("Dessert purchased: " + recipe);
                // Implement additional purchase logic here
                return;
            }
        }
        System.out.println("Dessert recipe not found: " + recipeName);
    }

    // Place a new order
    public void placeOrder(Map<Product, Integer> productQuantities) {
        Order newOrder = new Order(productQuantities);
        orders.put(newOrder.getOrderId(), newOrder);
        System.out.println("Order placed: " + newOrder);
    }

    // Update the status of an order
    public void updateOrderStatus(String orderId, String newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            System.out.println("Order status updated: " + order);
        } else {
            System.out.println("Order not found with ID: " + orderId);
        }
    }

    // List all orders
    public void listOrders() {
        System.out.println("All orders:");
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }
}
// Product Class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price;
    }
}

//Recipe Class
class Recipe {
    private String id;
    private String title;
    private String description;

    public Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Recipe ID: " + id + ", Title: " + title + ", Description: " + description;
    }
}

//Post Class
class Post {
    private String id;
    private String title;
    private String content;

    public Post(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Post ID: " + id + ", Title: " + title + ", Content: " + content;
    }
}
//Feedback Class
class Feedback {
    private String userId;
    private String content;

    public Feedback(String userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Feedback: " + content;
    }
}
//------------------------------------------------------------------
class ManagerPage {
    private Store store;
    private MessagingSystem messagingSystem;
    private String businessName; // Business information field
    private String businessAddress; // Business information field

    public ManagerPage(Store store) {
        this.store = store;
        this.messagingSystem = new MessagingSystem(); // Initialize the messaging system
        this.businessName = "Default Business Name"; // Default values
        this.businessAddress = "Default Address";
    }

    public void showManagerPage() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Manager Page ---");
            System.out.println("1. Product Management");
            System.out.println("2. Monitor Sales and Profits");
            System.out.println("3. Identify Best-Selling Products");
            System.out.println("4. Implement Dynamic Discounts");
            System.out.println("5. Communication and Notification");
            System.out.println("6. Account Management"); // New option for Account Management
            System.out.println("7. Order Management");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageProducts(scanner);
                    break;

                case 2:
                    store.generateFinancialReport();
                    break;

                case 3:
                    store.showBestSellingProducts();
                    break;

                case 4:
                    implementDynamicDiscounts(scanner);
                    break;

                case 5:
                    handleCommunication(scanner);
                    break;

                case 6:
                    manageAccount(scanner); // Handle account management
                    break;

                case 7:
                    manageOrders(scanner);
                    return;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void manageProducts(Scanner scanner) {
        System.out.println("\n--- Product Management ---");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. List Products");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                store.addProduct(new Product(name, price));
                break;

            case 2:
                System.out.print("Enter product name to update: ");
                name = scanner.nextLine();
                System.out.print("Enter new price: ");
                price = scanner.nextDouble();
                store.updateProduct(name, price);
                break;

            case 3:
                System.out.print("Enter product name to remove: ");
                name = scanner.nextLine();
                store.removeProduct(name);
                break;

            case 4:
                store.listProducts();
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void implementDynamicDiscounts(Scanner scanner) {
        System.out.println("\n--- Implement Dynamic Discounts ---");
        System.out.print("Enter product name for discount: ");
        String name = scanner.nextLine();
        System.out.print("Enter discount percentage: ");
        double discount = scanner.nextDouble();
        store.applyDiscount(name, discount);
    }

    private void handleCommunication(Scanner scanner) {
        System.out.println("\n--- Communication and Notification ---");
        System.out.println("1. Send Message to User");
        System.out.println("2. Send Message to Supplier");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter message content: ");
                String userMessage = scanner.nextLine();
                messagingSystem.sendMessageToUser(userId, userMessage);
                break;

            case 2:
                System.out.print("Enter Supplier ID: ");
                String supplierId = scanner.nextLine();
                System.out.print("Enter message content: ");
                String supplierMessage = scanner.nextLine();
                messagingSystem.sendMessageToSupplier(supplierId, supplierMessage);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void manageAccount(Scanner scanner) {
        System.out.println("\n--- Account Management ---");
        System.out.println("1. View Business Information");
        System.out.println("2. Update Business Information");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                viewBusinessInfo();
                break;

            case 2:
                updateBusinessInfo(scanner);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void viewBusinessInfo() {
        System.out.println("\n--- Business Information ---");
        System.out.println("Business Name: " + businessName);
        System.out.println("Business Address: " + businessAddress);
    }

    private void updateBusinessInfo(Scanner scanner) {
        System.out.println("\n--- Update Business Information ---");
        System.out.print("Enter new business name: ");
        businessName = scanner.nextLine();
        System.out.print("Enter new business address: ");
        businessAddress = scanner.nextLine();
        System.out.println("Business information updated successfully.");
    }
    private void manageOrders(Scanner scanner) {
        System.out.println("\n--- Order Management ---");
        System.out.println("1. Place Order");
        System.out.println("2. Update Order Status");
        System.out.println("3. List Orders");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                placeOrder(scanner);
                break;

            case 2:
                updateOrderStatus(scanner);
                break;

            case 3:
                store.listOrders();
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void placeOrder(Scanner scanner) {
        System.out.println("Enter product quantities (format: productName quantity, e.g., Gingerbread 3): ");
        Map<Product, Integer> productQuantities = new HashMap<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) break;  // Stop input on empty line

            String[] parts = input.split(" ");
            String productName = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            Product product = findProductByName(productName);
            if (product != null) {
                productQuantities.put(product, quantity);
            } else {
                System.out.println("Product not found: " + productName);
            }
        }

        store.placeOrder(productQuantities);
    }

    private void updateOrderStatus(Scanner scanner) {
        System.out.print("Enter order ID to update: ");
        String orderId = scanner.nextLine();
        System.out.print("Enter new status: ");
        String status = scanner.nextLine();

        store.updateOrderStatus(orderId, status);
    }

    private Product findProductByName(String name) {
        for (Product product : store.getProducts()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
//Messaging System Class
class MessagingSystem {
    private Map<String, List<String>> userMessages;
    private Map<String, List<String>> supplierMessages;

    public MessagingSystem() {
        this.userMessages = new HashMap<>();
        this.supplierMessages = new HashMap<>();
    }

    public void sendMessageToUser(String userId, String message) {
        userMessages.computeIfAbsent(userId, k -> new ArrayList<>()).add(message);
        System.out.println("Message sent to user " + userId + ": " + message);
    }

    public void sendMessageToSupplier(String supplierId, String message) {
        supplierMessages.computeIfAbsent(supplierId, k -> new ArrayList<>()).add(message);
        System.out.println("Message sent to supplier " + supplierId + ": " + message);
    }

    // You can add methods to view messages if needed
}

class Order {
    private String orderId;
    private Map<Product, Integer> products;
    private String status; // e.g., "Pending", "Shipped", "Delivered"

    public Order(Map<Product, Integer> products) {
        this.orderId = UUID.randomUUID().toString(); // Unique order ID
        this.products = products;
        this.status = "Pending";
    }

    public String getOrderId() {
        return orderId;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Status: " + status + ", Products: " + products;
    }
}
//-----------------------------------------------
//UserPage Class
class UserPage {
    private List<User> users;
    private User currentUser;
    private Map<String, List<String>> communications; // Store communication records
    private Map<String, List<String>> feedbacks; // Store feedback records

    public UserPage() {
        this.users = new ArrayList<>();
        this.currentUser = null;
        this.communications = new HashMap<>();
        this.feedbacks = new HashMap<>();
    }

    // Sign up for a new account
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter city: ");
        String city = scanner.nextLine();

        if (findUser(userId) != null) {
            System.out.println("User ID already exists. Please choose a different user ID.");
        } else {
            User newUser = new Customer(userId, name, email, city);
            users.add(newUser);
            System.out.println("Account created successfully!");
        }
    }

    // Sign in to the platform
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        User user = findUser(userId);
        if (user != null && user.getName().equals(name)) {
            currentUser = user;
            System.out.println("Signed in successfully!");
        } else {
            System.out.println("Invalid user ID or name.");
        }
    }

    // Manage personal account
    public void manageAccount() {
        if (currentUser == null) {
            System.out.println("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Change Name");
        System.out.println("2. Change Email");
        System.out.println("3. Change City");
        System.out.println("4. Delete Account");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                currentUser.setName(newName);
                System.out.println("Name updated successfully!");
                break;
            case 2:
                System.out.println("Enter new email: ");
                String newEmail = scanner.nextLine();
                currentUser.setEmail(newEmail);
                System.out.println("Email updated successfully!");
                break;
            case 3:
                System.out.println("Enter new city: ");
                String newCity = scanner.nextLine();
                currentUser.setCity(newCity);
                System.out.println("City updated successfully!");
                break;
            case 4:
                users.remove(currentUser);
                currentUser = null;
                System.out.println("Account deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Post and share personal dessert creations
    public void postDessertCreation() {
        if (currentUser == null) {
            System.out.println("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of your dessert creation: ");
        String title = scanner.nextLine();
        System.out.println("Enter the description of your dessert creation: ");
        String description = scanner.nextLine();

        if (currentUser instanceof Customer) {
            ((Customer) currentUser).addDessertCreation(title, description);
            System.out.println("Dessert creation posted successfully!");
        } else {
            System.out.println("This feature is not available for your role.");
        }
    }

    // Communicate with store owners and suppliers
    public void sendMessage() {
        if (currentUser == null) {
            System.out.println("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the recipient's ID (store owner/supplier): ");
        String recipientId = scanner.nextLine();
        System.out.println("Enter your message: ");
        String message = scanner.nextLine();

        if (!communications.containsKey(recipientId)) {
            communications.put(recipientId, new ArrayList<>());
        }
        communications.get(recipientId).add("From " + currentUser.getUserId() + ": " + message);
        System.out.println("Message sent successfully!");
    }

    // Provide feedback on purchased products and shared recipes
    public void provideFeedback() {
        if (currentUser == null) {
            System.out.println("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the recipient's ID (store owner/supplier or shared recipe ID): ");
        String recipientId = scanner.nextLine();
        System.out.println("Enter your feedback: ");
        String feedback = scanner.nextLine();

        if (!feedbacks.containsKey(recipientId)) {
            feedbacks.put(recipientId, new ArrayList<>());
        }
        feedbacks.get(recipientId).add("Feedback from " + currentUser.getUserId() + ": " + feedback);
        System.out.println("Feedback submitted successfully!");
    }

    private User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        UserPage userPage = new UserPage();

        // Sample actions for testing
        userPage.signUp();
        userPage.signIn();
        userPage.manageAccount();
        userPage.postDessertCreation();
        userPage.sendMessage();
        userPage.provideFeedback();
    }
}

//Customer Class
class Customer extends User {
    private List<DessertCreation> dessertCreations;

    public Customer(String userId, String name, String email, String city) {
        super(userId, name, email, city);
        this.dessertCreations = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    // Method to add a dessert creation
    public void addDessertCreation(String title, String description) {
        DessertCreation creation = new DessertCreation(title, description);
        dessertCreations.add(creation);
        System.out.println("Dessert creation added: " + creation);
    }

    // Method to list all dessert creations by this user
    public void listDessertCreations() {
        System.out.println("Dessert Creations by " + getName() + ":");
        for (DessertCreation creation : dessertCreations) {
            System.out.println(creation);
        }
    }

    public void removeDessertCreation(String dessert) {
        dessertCreations.removeIf(creation -> creation.toString().contains(dessert));
    }

    public List<DessertCreation> getDessertCreations() {
        return dessertCreations;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dessert Creations: " + dessertCreations;
    }
}

//UserAccountService Class
class UserAccountService {
    private Map<String, Customer> users = new HashMap<>();

    public void signUp(String userId, String name, String email, String city, String password) {
        if (!users.containsKey(email)) {
            Customer user = new Customer(userId, name, email, city);
            // Here you would store the password securely, omitted for brevity
            users.put(email, user);
            System.out.println("User signed up successfully.");
        } else {
            System.out.println("User with this email already exists.");
        }
    }

    public Customer signIn(String email, String password) {
        // Password validation logic would be here, omitted for simplicity
        Customer user = users.get(email);
        if (user != null) {
            System.out.println("User signed in successfully.");
            return user;
        } else {
            System.out.println("Invalid email or password.");
            return null;
        }
    }

    public void updateAccount(String email, String newName, String newCity) {
        Customer user = users.get(email);
        if (user != null) {
            user.setName(newName);
            user.setCity(newCity);
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}

//DessertCreation Class
class DessertCreation {
    private String title;
    private String description;

    public DessertCreation(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description;
    }
}
//DessertRecipe Class
class DessertRecipe {
    private String name;
    private String description;
    private List<String> dietaryTags;
    private double price;

    public DessertRecipe(String name, String description, List<String> dietaryTags, double price) {
        this.name = name;
        this.description = description;
        this.dietaryTags = dietaryTags;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDietaryTags() {
        return dietaryTags;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "DessertRecipe [Name=" + name + ", Description=" + description + ", DietaryTags=" + dietaryTags + ", Price=$" + price + "]";
    }
}