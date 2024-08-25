package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExplorationAndPurchase {

    private boolean userOnDessertRecipePage;
    private List<String> availableRecipes;
    private List<String> filteredRecipes;
    private String searchKeyword;
    private String dietaryNeed;
    private boolean purchasePageDisplayed;

    public ExplorationAndPurchase() {
        this.userOnDessertRecipePage = false;
        this.availableRecipes = new ArrayList<>();
        this.filteredRecipes = new ArrayList<>();
        this.searchKeyword = "";
        this.dietaryNeed = "";
        this.purchasePageDisplayed = false;
    }

    public void setUserOnDessertRecipePage() {
        userOnDessertRecipePage = true;
        availableRecipes.clear(); // Reset available recipes
        availableRecipes.add("Chocolate Cake");
        availableRecipes.add("Vanilla Ice Cream");
        availableRecipes.add("Cookies");
        System.out.println("User is on the dessert recipe page.");
    }

    public void browseAvailableDessertRecipes() {
        if (!userOnDessertRecipePage) {
            throw new IllegalStateException("User must be on the dessert recipe page to browse recipes.");
        }
        System.out.println("User is browsing through the available dessert recipes.");
    }

    public List<String> getAvailableRecipes() {
        return new ArrayList<>(availableRecipes);
    }

    public void searchRecipe(String keyword) {
        if (!userOnDessertRecipePage) {
            throw new IllegalStateException("User must be on the dessert recipe page to search for recipes.");
        }
        searchKeyword = keyword;
        filteredRecipes.clear();
        for (String recipe : availableRecipes) {
            if (recipe.toLowerCase().contains(keyword.toLowerCase())) {
                filteredRecipes.add(recipe);
            }
        }
        System.out.println("User searches for a recipe using the keyword: " + keyword);
    }

    public List<String> getFilteredRecipes() {
        return new ArrayList<>(filteredRecipes);
    }

    public void applyFilter(String dietaryNeed) {
        if (!userOnDessertRecipePage) {
            throw new IllegalStateException("User must be on the dessert recipe page to apply a filter.");
        }
        this.dietaryNeed = dietaryNeed;
        filteredRecipes.clear();
        if ("Nut-Free".equalsIgnoreCase(dietaryNeed)) {
            filteredRecipes.add("Cookies"); // Example
        } else if ("Dairy-Free".equalsIgnoreCase(dietaryNeed)) {
            filteredRecipes.add("Fruit Sorbet"); // Example
        } else if ("Gluten-Free".equalsIgnoreCase(dietaryNeed)) {
            filteredRecipes.add("Gluten-Free Brownies"); // Example
        }
        System.out.println("User applies a filter for: " + dietaryNeed);
    }

    public boolean areFilteredRecipesCorrect(String dietaryNeed) {
        if (!userOnDessertRecipePage) {
            throw new IllegalStateException("User must be on the dessert recipe page to check filtered recipes.");
        }
        for (String recipe : filteredRecipes) {
            if (dietaryNeed.equalsIgnoreCase("Nut-Free") && !recipe.equals("Cookies")) {
                return false;
            } else if (dietaryNeed.equalsIgnoreCase("Dairy-Free") && !recipe.equals("Fruit Sorbet")) {
                return false;
            } else if (dietaryNeed.equalsIgnoreCase("Gluten-Free") && !recipe.equals("Gluten-Free Brownies")) {
                return false;
            }
        }
        return true;
    }

    public void viewDessertRecipe() {
        userOnDessertRecipePage = true;
        System.out.println("User is viewing a dessert recipe.");
    }

    public void chooseOption(String choice) {
        if (!userOnDessertRecipePage) {
            throw new IllegalStateException("User must be on the dessert recipe page to choose an option.");
        }
        if ("Purchase".equalsIgnoreCase(choice)) {
            purchasePageDisplayed = true;
        }
        System.out.println("User chooses '" + choice + "' for the selected dessert.");
    }

    public boolean isPurchasePageDisplayed() {
        return purchasePageDisplayed;
    }

    public boolean checkPurchasePageForChoice(String choice) {
        return purchasePageDisplayed && choice != null;
    }
}
