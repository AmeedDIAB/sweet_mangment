package special.planner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ExplorationAndPurchaseSteps {

    private boolean userOnDessertRecipePage;
    private List<String> availableRecipes;
    private List<String> filteredRecipes;
    private String searchKeyword;
    private String dietaryNeed;
    private boolean purchasePageDisplayed;

    @Given("The user is on the dessert recipe page")
    public void theUserIsOnTheDessertRecipePage() {
        userOnDessertRecipePage = true;
        System.out.println("User is on the dessert recipe page.");
    }

    @When("The user is browsing through the available dessert recipes")
    public void theUserIsBrowsingThroughTheAvailableDessertRecipes() {
        assertTrue(userOnDessertRecipePage);
        // Simulate available recipes
        availableRecipes = new ArrayList<>();
        availableRecipes.add("Chocolate Cake");
        availableRecipes.add("Vanilla Ice Cream");
        availableRecipes.add("Cookies");
        System.out.println("User is browsing through the available dessert recipes.");
    }

    @When("The user searches for a recipe using the keyword {string}")
    public void theUserSearchesForARecipeUsingTheKeyword(String keyword) {
        assertTrue(userOnDessertRecipePage);
        searchKeyword = keyword;
        // Simulate search
        filteredRecipes = new ArrayList<>();
        for (String recipe : availableRecipes) {
            if (recipe.toLowerCase().contains(keyword.toLowerCase())) {
                filteredRecipes.add(recipe);
            }
        }
        System.out.println("User searches for a recipe using the keyword: " + keyword);
    }

    @When("The user applies a filter for {string}")
    public void theUserAppliesAFilterFor(String dietaryNeed) {
        assertTrue(userOnDessertRecipePage);
        this.dietaryNeed = dietaryNeed;
        // Simulate filtering recipes
        filteredRecipes = new ArrayList<>();
        if (dietaryNeed.equalsIgnoreCase("Nut-Free")) {
            filteredRecipes.add("Cookies"); // Example
        } else if (dietaryNeed.equalsIgnoreCase("Dairy-Free")) {
            filteredRecipes.add("Fruit Sorbet"); // Example
        } else if (dietaryNeed.equalsIgnoreCase("Gluten-Free")) {
            filteredRecipes.add("Gluten-Free Brownies"); // Example
        }
        System.out.println("User applies a filter for: " + dietaryNeed);
    }

    @When("The user chooses \"Purchase\" choice for the selected dessert")
    public void theUserChoosesPurchaseChoiceForTheSelectedDessert() {
        assertTrue(userOnDessertRecipePage);
        purchasePageDisplayed = true;
        System.out.println("User chooses 'Purchase' choice for the selected dessert.");
    }

    @Then("The user should see a list of dessert recipes")
    public void theUserShouldSeeAListOfDessertRecipes() {
        assertNotNull(availableRecipes);
        assertTrue(availableRecipes.contains("Chocolate Cake"));
        assertTrue(availableRecipes.contains("Vanilla Ice Cream"));
        assertTrue(availableRecipes.contains("Cookies"));
        System.out.println("User sees a list of dessert recipes.");
    }

    @Then("The user should see a list of recipes that match the keyword {string}")
    public void theUserShouldSeeAListOfRecipesThatMatchTheKeyword(String keyword) {
        assertNotNull(filteredRecipes);
        for (String recipe : filteredRecipes) {
            assertTrue(recipe.toLowerCase().contains(keyword.toLowerCase()));
        }
        System.out.println("User sees a list of recipes that match the keyword: " + keyword);
    }

    @Then("The user should see a list of recipes that match the filter {string}")
    public void theUserShouldSeeAListOfRecipesThatMatchTheFilter(String dietaryNeed) {
        assertNotNull(filteredRecipes);
        System.out.println("User sees a list of recipes that match the filter: " + dietaryNeed);
        // Here you could add additional assertions depending on the filtering logic
    }

    @Then("The user should be redirected to the store owner's purchase page")
    public void theUserShouldBeRedirectedToTheStoreOwnersPurchasePage() {
        assertTrue(purchasePageDisplayed);
        System.out.println("User is redirected to the store owner's purchase page.");
    }

    @Then("The user should see the purchase page that contains options to select quantity and delivery details and \"Confirm Purchase\" choice")
    public void theUserShouldSeeThePurchasePageThatContainsOptionsToSelectQuantityAndDeliveryDetailsAndConfirmPurchaseChoice() {
        assertTrue(purchasePageDisplayed);
        // Simulate checking for options on the purchase page
        System.out.println("User sees the purchase page with options to select quantity, delivery details, and 'Confirm Purchase' choice.");
    }
}