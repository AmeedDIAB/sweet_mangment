package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminPage adminPage = new AdminPage();
        Store store = new Store();
        ManagerPage managerPage = new ManagerPage(store);

        // Sample products for demonstration
        store.addProduct(new Product("Gingerbread", 5.99));
        store.addProduct(new Product("Chocolate Cake", 7.99));

        logger.info("\n--- Main Page ---");
        logger.info("1. Admin");
        logger.info("2. Manager(Store Owner / Supplier)");
        logger.info("3. User");
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

    private static final Logger logger = Logger.getLogger(AdminPage.class.getName());
    private Admin admin;
    private Store store;  // Added Store for managing products and sales

    public AdminPage() {
        this.admin = new Admin();
        this.store = new Store();  // Initialize Store
    }

    public void showAdminPage() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\n--- Admin Page ---");
            logger.info("1. Add User");
            logger.info("2. Update User");
            logger.info("3. Remove User");
            logger.info("4. List Users");
            logger.info("5. Content Management"); // Added Content Management
            logger.info("6. Monitoring and Reporting");
            logger.info("7. Exit");
            logger.info("Choose an option for admin: ");
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
                    logger.info("Exiting...");
                    return;

                default:
                    logger.warning("Invalid option. Please try again.");
            }
            logger.info("1. Returning to Admin Page");
            choice = scanner.nextInt();
            if (choice == 1) {
                continue;
            }
        }
    }

    private void addUser(Scanner scanner) {
        logger.info("Enter user type (storeOwner/supplier): ");
        String type = scanner.nextLine();
        logger.info("Enter user ID: ");
        String userId = scanner.nextLine();
        logger.info("Enter name: ");
        String name = scanner.nextLine();
        logger.info("Enter email: ");
        String email = scanner.nextLine();
        logger.info("Enter city: ");
        String city = scanner.nextLine();  // Added city

        if (type.equalsIgnoreCase("storeOwner")) {
            admin.addUser(new StoreOwner(userId, name, email, city));
        } else if (type.equalsIgnoreCase("supplier")) {
            admin.addUser(new Supplier(userId, name, email, city));
        } else {
            logger.warning("Invalid user type.");
        }
    }

    private void updateUser(Scanner scanner) {
        logger.info("Enter user ID to update: ");
        String userId = scanner.nextLine();
        if (admin.getUserById(userId) == null) {
            logger.warning("User not found with ID: " + userId);
            return;
        }

        logger.info("Enter new name: ");
        String name = scanner.nextLine();
        logger.info("Enter new email: ");
        String email = scanner.nextLine();
        admin.updateUser(userId, name, email);
    }

    private void removeUser(Scanner scanner) {
        logger.info("Enter user ID to remove: ");
        String userId = scanner.nextLine();
        if (admin.getUserById(userId) == null) {
            logger.warning("User not found with ID: " + userId);
            return;
        }
        admin.removeUser(userId);
    }

    private void showMonitoringAndReporting(Scanner scanner) {
        logger.info("\n--- Monitoring and Reporting ---");
        logger.info("1. Generate Financial Report");
        logger.info("2. Best-Selling Products");
        logger.info("3. User Statistics by City");
        logger.info("Choose an option for monitoring and reporting: ");
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
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void showContentManagement(Scanner scanner) {
        logger.info("\n--- Content Management ---");
        logger.info("1. Manage Recipes");
        logger.info("2. Manage Posts");
        logger.info("3. Manage User Feedback");
        logger.info("Choose an option for conetent management: ");
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
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void manageRecipes(Scanner scanner) {
        logger.info("\n--- Recipe Management ---");
        logger.info("1. Add Recipe");
        logger.info("2. Update Recipe");
        logger.info("3. Remove Recipe");
        logger.info("4. List Recipes");
        logger.info("Choose an option for manage recipes: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                logger.info("Enter recipe ID: ");
                String id = scanner.nextLine();
                logger.info("Enter recipe title: ");
                String title = scanner.nextLine();
                logger.info("Enter recipe description: ");
                String description = scanner.nextLine();
                admin.addRecipe(new Recipe(id, title, description));
                break;

            case 2:
                logger.info("Enter recipe ID to update: ");
                id = scanner.nextLine();
                logger.info("Enter new title: ");
                title = scanner.nextLine();
                logger.info("Enter new description: ");
                description = scanner.nextLine();
                admin.updateRecipe(id, title, description);
                break;

            case 3:
                logger.info("Enter recipe ID to remove: ");
                id = scanner.nextLine();
                admin.removeRecipe(id);
                break;

            case 4:
                admin.listRecipes();
                break;

            default:
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void managePosts(Scanner scanner) {
        logger.info("\n--- Post Management ---");
        logger.info("1. Add Post");
        logger.info("2. Update Post");
        logger.info("3. Remove Post");
        logger.info("4. List Posts");
        logger.info("Choose an option for manage posts: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                logger.info("Enter post ID: ");
                String id = scanner.nextLine();
                logger.info("Enter post title: ");
                String title = scanner.nextLine();
                logger.info("Enter post content: ");
                String content = scanner.nextLine();
                admin.addPost(new Post(id, title, content));
                break;

            case 2:
                logger.info("Enter post ID to update: ");
                id = scanner.nextLine();
                logger.info("Enter new title: ");
                title = scanner.nextLine();
                logger.info("Enter new content: ");
                content = scanner.nextLine();
                admin.updatePost(id, title, content);
                break;

            case 3:
                logger.info("Enter post ID to remove: ");
                id = scanner.nextLine();
                admin.removePost(id);
                break;

            case 4:
                admin.listPosts();
                break;

            default:
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void manageFeedback(Scanner scanner) {
        logger.info("\n--- Feedback Management ---");
        logger.info("1. Add Feedback");
        logger.info("2. List Feedback");
        logger.info("Choose an option for manage Feedback: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                logger.info("Enter user ID: ");
                String userId = scanner.nextLine();
                logger.info("Enter feedback content: ");
                String content = scanner.nextLine();
                admin.addFeedback(new Feedback(userId, content));
                break;

            case 2:
                admin.listFeedbacks();
                break;

            default:
                logger.warning("Invalid option. Please try again.");
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
    private static final Logger logger = Logger.getLogger(Admin.class.getName());
    private List<User> users;
    private List<Recipe> recipes;
    private List<Post> posts;
    private List<Feedback> feedbacks;

    public Admin() {
        this.users = new ArrayList<>();
        this.recipes = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    // Recipe Management
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        logger.info("Recipe added: " + recipe);
    }

    public void updateRecipe(String id, String newTitle, String newDescription) {
        for (Recipe recipe : recipes) {
            if (recipe.getId().equals(id)) {
                // Note: Since Recipe is immutable, you might want to remove and re-add it.
                recipes.remove(recipe);
                Recipe updatedRecipe = new Recipe(id, newTitle, newDescription);
                recipes.add(updatedRecipe);
                logger.info("Recipe updated: " + updatedRecipe);
                return;
            }
        }
        logger.warning("Recipe not found with ID: " + id);
    }

    public void removeRecipe(String id) {
        Iterator<Recipe> iterator = recipes.iterator();
        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe.getId().equals(id)) {
                iterator.remove();
                logger.info("Recipe removed with ID: " + id);
                return;
            }
        }
        logger.warning("Recipe not found with ID: " + id);
    }

    public void listRecipes() {
        logger.info("All recipes:");
        for (Recipe recipe : recipes) {
            logger.info(recipe.toString());
        }
    }

    // Post Management
    public void addPost(Post post) {
        posts.add(post);
        logger.info("Post added: " + post);
    }

    public void updatePost(String id, String newTitle, String newContent) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                // Note: Since Post is immutable, you might want to remove and re-add it.
                posts.remove(post);
                Post updatedPost = new Post(id, newTitle, newContent);
                posts.add(updatedPost);
                logger.info("Post updated: " + updatedPost);
                return;
            }
        }
        logger.warning("Post not found with ID: " + id);
    }

    public void removePost(String id) {
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId().equals(id)) {
                iterator.remove();
                logger.info("Post removed with ID: " + id);
                return;
            }
        }
        logger.warning("Post not found with ID: " + id);
    }

    public void listPosts() {
        logger.info("All posts:");
        for (Post post : posts) {
            logger.info(post.toString());
        }
    }

    // Feedback Management
    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        logger.info("Feedback added: " + feedback);
    }

    public void listFeedbacks() {
        logger.info("All feedbacks:");
        for (Feedback feedback : feedbacks) {
            logger.info(feedback.toString());
        }
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
        logger.info("User added: " + user);
    }

    // Update user information
    public void updateUser(String userId, String newName, String newEmail) {
        User user = getUserById(userId);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
            logger.info("User updated: " + user);
        } else {
            logger.warning("User not found with ID: " + userId);
        }
    }

    // Remove a user
    public void removeUser(String userId) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUserId().equals(userId)) {
                iterator.remove();
                logger.info("User removed with ID: " + userId);
                return;
            }
        }
        logger.warning("User not found with ID: " + userId);
    }

    // List all users
    public void listUsers() {
        logger.info("All users:");
        for (User user : users) {
            logger.info(user.toString());
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
        Map<String, Integer> cityStats = new HashMap<>();
        for (User user : users) {
            String city = user.getCity();
            cityStats.put(city, cityStats.getOrDefault(city, 0) + 1);
        }
        logger.info("User statistics by city:");
        for (Map.Entry<String, Integer> entry : cityStats.entrySet()) {
            logger.info("City: " + entry.getKey() + ", Number of Users: " + entry.getValue());
        }
    }
}

// Store Class
class Store {
    private static final Logger logger = Logger.getLogger(Store.class.getName());
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
        logger.info("Product added: " + product);
    }

    // Update a product's price
    public void updateProduct(String name, double newPrice) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                products.add(new Product(name, newPrice));
                logger.info("Product updated: " + product);
                return;
            }
        }
        logger.warning("Product not found: " + name);
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
                logger.info("Product removed: " + name);
                return;
            }
        }
        logger.warning("Product not found: " + name);
    }

    // List all products
    public void listProducts() {
        logger.info("All products:");
        for (Product product : products) {
            logger.info(product.toString());
        }
    }

    // Get all products
    public List<Product> getProducts() {
        return new ArrayList<>(products);  // Return a copy to avoid modification of the original list
    }

    // Apply discount to a product
    public void applyDiscount(String name, double discountPercentage) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                discounts.put(product, discountPercentage);
                logger.info("Discount applied: " + discountPercentage + "% to " + name);
                return;
            }
        }
        logger.warning("Product not found: " + name);
    }

    // Record a sale
    public void recordSale(Product product, int quantity) {
        if (products.contains(product)) {
            sales.put(product, sales.getOrDefault(product, 0) + quantity);
            logger.info("Sale recorded: " + quantity + " units of " + product.getName());
        } else {
            logger.warning("Product not found in store.");
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
        logger.info("Financial Report:");
        logger.info("Total Sales: $" + totalSales);
    }

    // Show best-selling products
    public void showBestSellingProducts() {
        List<Map.Entry<Product, Integer>> salesList = new ArrayList<>(sales.entrySet());
        salesList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));  // Sort by quantity sold

        logger.info("Best-Selling Products:");
        for (Map.Entry<Product, Integer> entry : salesList) {
            Product product = entry.getKey();
            int quantitySold = entry.getValue();
            logger.info("Product: " + product.getName() + ", Quantity Sold: " + quantitySold);
        }
    }

    // Add a new dessert recipe
    public void addDessertRecipe(DessertRecipe recipe) {
        dessertRecipes.add(recipe);
        logger.info("Dessert recipe added: " + recipe);
    }

    // List all dessert recipes
    public void listDessertRecipes() {
        if (dessertRecipes.isEmpty()) {
            logger.info("No dessert recipes available.");
        } else {
            for (DessertRecipe recipe : dessertRecipes) {
                logger.info(recipe.toString());
            }
        }
    }

    // Search for dessert recipes by name or description
    public void searchDessertRecipes(String keyword) {
        boolean found = false;
        for (DessertRecipe recipe : dessertRecipes) {
            if (recipe.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                logger.info(recipe.toString());
                found = true;
            }
        }
        if (!found) {
            logger.info("No recipes found with the keyword: " + keyword);
        }
    }

    // Filter dessert recipes based on dietary tags
    public void filterDessertRecipes(List<String> dietaryTags) {
        boolean found = false;
        for (DessertRecipe recipe : dessertRecipes) {
            if (recipe.getDietaryTags().containsAll(dietaryTags)) {
                logger.info(recipe.toString());
                found = true;
            }
        }
        if (!found) {
            logger.info("No recipes match the dietary tags: " + dietaryTags);
        }
    }

    // Purchase a dessert recipe
    public void purchaseDessertRecipe(String recipeName, User user) {
        for (DessertRecipe recipe : dessertRecipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                logger.info("Dessert purchased: " + recipe);
                // Implement additional purchase logic here
                return;
            }
        }
        logger.warning("Dessert recipe not found: " + recipeName);
    }

    // Place a new order
    public void placeOrder(Map<Product, Integer> productQuantities) {
        Order newOrder = new Order(productQuantities);
        orders.put(newOrder.getOrderId(), newOrder);
        logger.info("Order placed: " + newOrder);
    }

    // Update the status of an order
    public void updateOrderStatus(String orderId, String newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            logger.info("Order status updated: " + order);
        } else {
            logger.warning("Order not found with ID: " + orderId);
        }
    }

    // List all orders
    public void listOrders() {
        logger.info("All orders:");
        for (Order order : orders.values()) {
            logger.info(order.toString());
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
    private static final Logger logger = Logger.getLogger(ManagerPage.class.getName());
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
            logger.info("\n--- Manager Page ---");
            logger.info("1. Product Management");
            logger.info("2. Monitor Sales and Profits");
            logger.info("3. Identify Best-Selling Products");
            logger.info("4. Implement Dynamic Discounts");
            logger.info("5. Communication and Notification");
            logger.info("6. Account Management"); // New option for Account Management
            logger.info("7. Order Management");
            logger.info("8. Exit");
            logger.info("Choose an option for show Manager Page: ");
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
                    logger.info("Exiting...");
                    return;

                default:
                    logger.warning("Invalid option. Please try again.");
            }
        }
    }

    private void manageProducts(Scanner scanner) {
        logger.info("\n--- Product Management ---");
        logger.info("1. Add Product");
        logger.info("2. Update Product");
        logger.info("3. Remove Product");
        logger.info("4. List Products");
        logger.info("Choose an option for manage Products: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                logger.info("Enter product name: ");
                String name = scanner.nextLine();
                logger.info("Enter product price: ");
                double price = scanner.nextDouble();
                store.addProduct(new Product(name, price));
                break;

            case 2:
                logger.info("Enter product name to update: ");
                name = scanner.nextLine();
                logger.info("Enter new price: ");
                price = scanner.nextDouble();
                store.updateProduct(name, price);
                break;

            case 3:
                logger.info("Enter product name to remove: ");
                name = scanner.nextLine();
                store.removeProduct(name);
                break;

            case 4:
                store.listProducts();
                break;

            default:
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void implementDynamicDiscounts(Scanner scanner) {
        logger.info("\n--- Implement Dynamic Discounts ---");
        logger.info("Enter product name for discount: ");
        String name = scanner.nextLine();
        logger.info("Enter discount percentage: ");
        double discount = scanner.nextDouble();
        store.applyDiscount(name, discount);
    }

    private void handleCommunication(Scanner scanner) {
        logger.info("\n--- Communication and Notification ---");
        logger.info("1. Send Message to User");
        logger.info("2. Send Message to Supplier");
        logger.info("Choose an option for handle Communication: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                logger.info("Enter User ID: ");
                String userId = scanner.nextLine();
                logger.info("Enter message content: ");
                String userMessage = scanner.nextLine();
                messagingSystem.sendMessageToUser(userId, userMessage);
                break;

            case 2:
                logger.info("Enter Supplier ID: ");
                String supplierId = scanner.nextLine();
                logger.info("Enter message content: ");
                String supplierMessage = scanner.nextLine();
                messagingSystem.sendMessageToSupplier(supplierId, supplierMessage);
                break;

            default:
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void manageAccount(Scanner scanner) {
        logger.info("\n--- Account Management ---");
        logger.info("1. View Business Information");
        logger.info("2. Update Business Information");
        logger.info("Choose an option for manage Account: ");
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
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void viewBusinessInfo() {
        logger.info("\n--- Business Information ---");
        logger.info("Business Name: " + businessName);
        logger.info("Business Address: " + businessAddress);
    }

    private void updateBusinessInfo(Scanner scanner) {
        logger.info("\n--- Update Business Information ---");
        logger.info("Enter new business name: ");
        businessName = scanner.nextLine();
        logger.info("Enter new business address: ");
        businessAddress = scanner.nextLine();
        logger.info("Business information updated successfully.");
    }

    private void manageOrders(Scanner scanner) {
        logger.info("\n--- Order Management ---");
        logger.info("1. Place Order");
        logger.info("2. Update Order Status");
        logger.info("3. List Orders");
        logger.info("Choose an option for manage Orders: ");
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
                logger.warning("Invalid option. Please try again.");
        }
    }

    private void placeOrder(Scanner scanner) {
        logger.info("Enter product quantities (format: productName quantity, e.g., Gingerbread 3): ");
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
                logger.warning("Product not found: " + productName);
            }
        }

        store.placeOrder(productQuantities);
    }

    private void updateOrderStatus(Scanner scanner) {
        logger.info("Enter order ID to update: ");
        String orderId = scanner.nextLine();
        logger.info("Enter new status: ");
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
    private static final Logger logger = Logger.getLogger(MessagingSystem.class.getName());
    private Map<String, List<String>> userMessages;
    private Map<String, List<String>> supplierMessages;

    public MessagingSystem() {
        this.userMessages = new HashMap<>();
        this.supplierMessages = new HashMap<>();
    }

    public void sendMessageToUser(String userId, String message) {
        userMessages.computeIfAbsent(userId, k -> new ArrayList<>()).add(message);
        logger.info("Message sent to user " + userId + ": " + message);
    }

    public void sendMessageToSupplier(String supplierId, String message) {
        supplierMessages.computeIfAbsent(supplierId, k -> new ArrayList<>()).add(message);
        logger.info("Message sent to supplier " + supplierId + ": " + message);
    }

    // You can add methods to view messages if needed
}

// Order Class
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

// UserPage Class
class UserPage {
    private static final Logger logger = Logger.getLogger(UserPage.class.getName());
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
        logger.info("Enter user ID: ");
        String userId = scanner.nextLine();
        logger.info("Enter name: ");
        String name = scanner.nextLine();
        logger.info("Enter email: ");
        String email = scanner.nextLine();
        logger.info("Enter city: ");
        String city = scanner.nextLine();

        if (findUser(userId) != null) {
            logger.warning("User ID already exists. Please choose a different user ID.");
        } else {
            User newUser = new Customer(userId, name, email, city);
            users.add(newUser);
            logger.info("Account created successfully!");
        }
    }

    // Sign in to the platform
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter user ID: ");
        String userId = scanner.nextLine();
        logger.info("Enter name: ");
        String name = scanner.nextLine();

        User user = findUser(userId);
        if (user != null && user.getName().equals(name)) {
            currentUser = user;
            logger.info("Signed in successfully!");
        } else {
            logger.warning("Invalid user ID or name.");
        }
    }

    // Manage personal account
    public void manageAccount() {
        if (currentUser == null) {
            logger.warning("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        logger.info("1. Change Name");
        logger.info("2. Change Email");
        logger.info("3. Change City");
        logger.info("4. Delete Account");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                logger.info("Enter new name: ");
                String newName = scanner.nextLine();
                currentUser.setName(newName);
                logger.info("Name updated successfully!");
                break;
            case 2:
                logger.info("Enter new email: ");
                String newEmail = scanner.nextLine();
                currentUser.setEmail(newEmail);
                logger.info("Email updated successfully!");
                break;
            case 3:
                logger.info("Enter new city: ");
                String newCity = scanner.nextLine();
                currentUser.setCity(newCity);
                logger.info("City updated successfully!");
                break;
            case 4:
                users.remove(currentUser);
                currentUser = null;
                logger.info("Account deleted successfully.");
                break;
            default:
                logger.warning("Invalid choice.");
        }
    }

    // Post and share personal dessert creations
    public void postDessertCreation() {
        if (currentUser == null) {
            logger.warning("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the title of your dessert creation: ");
        String title = scanner.nextLine();
        logger.info("Enter the description of your dessert creation: ");
        String description = scanner.nextLine();

        if (currentUser instanceof Customer) {
            ((Customer) currentUser).addDessertCreation(title, description);
            logger.info("Dessert creation posted successfully!");
        } else {
            logger.warning("This feature is not available for your role.");
        }
    }

    // Communicate with store owners and suppliers
    public void sendMessage() {
        if (currentUser == null) {
            logger.warning("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the recipient's ID (store owner/supplier): ");
        String recipientId = scanner.nextLine();
        logger.info("Enter your message: ");
        String message = scanner.nextLine();

        communications.computeIfAbsent(recipientId, k -> new ArrayList<>())
                .add("From " + currentUser.getUserId() + ": " + message);
        logger.info("Message sent successfully!");
    }

    // Provide feedback on purchased products and shared recipes
    public void provideFeedback() {
        if (currentUser == null) {
            logger.warning("You need to sign in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the recipient's ID (store owner/supplier or shared recipe ID): ");
        String recipientId = scanner.nextLine();
        logger.info("Enter your feedback: ");
        String feedback = scanner.nextLine();

        feedbacks.computeIfAbsent(recipientId, k -> new ArrayList<>())
                .add("Feedback from " + currentUser.getUserId() + ": " + feedback);
        logger.info("Feedback submitted successfully!");
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

// Customer Class
class Customer extends User {
    private static final Logger logger = Logger.getLogger(Customer.class.getName());
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
        logger.info("Dessert creation added: " + creation);
    }

    // Method to list all dessert creations by this user
    public void listDessertCreations() {
        logger.info("Dessert Creations by " + getName() + ":");
        for (DessertCreation creation : dessertCreations) {
            logger.info(creation.toString());
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

// UserAccountService Class
class UserAccountService {
    private static final Logger logger = Logger.getLogger(UserAccountService.class.getName());
    private Map<String, Customer> users = new HashMap<>();

    public void signUp(String userId, String name, String email, String city, String password) {
        if (!users.containsKey(email)) {
            Customer user = new Customer(userId, name, email, city);
            // Here you would store the password securely, omitted for brevity
            users.put(email, user);
            logger.info("User signed up successfully.");
        } else {
            logger.warning("User with this email already exists.");
        }
    }

    public Customer signIn(String email, String password) {
        // Password validation logic would be here, omitted for simplicity
        Customer user = users.get(email);
        if (user != null) {
            logger.info("User signed in successfully.");
            return user;
        } else {
            logger.warning("Invalid email or password.");
            return null;
        }
    }

    public void updateAccount(String email, String newName, String newCity) {
        Customer user = users.get(email);
        if (user != null) {
            user.setName(newName);
            user.setCity(newCity);
            logger.info("Account updated successfully.");
        } else {
            logger.warning("User not found.");
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