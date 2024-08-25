package special.planner;

import org.example.ExplorationAndPurchase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExplorationAndPurchaseTest {

    private ExplorationAndPurchase explorationAndPurchase;

    @Before
    public void setUp() {
        explorationAndPurchase = new ExplorationAndPurchase();
    }

    @Test
    public void testSetUserOnDessertRecipePage() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        assertTrue("User should be on the dessert recipe page", explorationAndPurchase.getAvailableRecipes().size() > 0);
        assertTrue(explorationAndPurchase.getAvailableRecipes().contains("Chocolate Cake"));
        assertTrue(explorationAndPurchase.getAvailableRecipes().contains("Vanilla Ice Cream"));
        assertTrue(explorationAndPurchase.getAvailableRecipes().contains("Cookies"));
    }

    @Test
    public void testBrowseAvailableDessertRecipes() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        explorationAndPurchase.browseAvailableDessertRecipes();
        // No specific assertion needed here, just testing method execution
    }

    @Test
    public void testSearchRecipe() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        explorationAndPurchase.searchRecipe("Chocolate");
        assertNotNull("Filtered recipes should not be null", explorationAndPurchase.getFilteredRecipes());
        assertTrue(explorationAndPurchase.getFilteredRecipes().contains("Chocolate Cake"));
        assertFalse(explorationAndPurchase.getFilteredRecipes().contains("Vanilla Ice Cream"));
    }

    @Test
    public void testApplyFilter() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        explorationAndPurchase.applyFilter("Nut-Free");
        assertNotNull("Filtered recipes should not be null", explorationAndPurchase.getFilteredRecipes());
        assertTrue(explorationAndPurchase.getFilteredRecipes().contains("Cookies"));
    }

    @Test
    public void testAreFilteredRecipesCorrect() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        explorationAndPurchase.applyFilter("Dairy-Free");
        assertTrue(explorationAndPurchase.areFilteredRecipesCorrect("Dairy-Free"));

        explorationAndPurchase.applyFilter("Nut-Free");
        assertTrue(explorationAndPurchase.areFilteredRecipesCorrect("Nut-Free"));

        explorationAndPurchase.applyFilter("Gluten-Free");
        assertTrue(explorationAndPurchase.areFilteredRecipesCorrect("Gluten-Free"));
    }

    @Test
    public void testViewDessertRecipe() {
        explorationAndPurchase.viewDessertRecipe();
        // No specific assertion needed here, just testing method execution
    }

    @Test
    public void testChooseOptionPurchase() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        explorationAndPurchase.chooseOption("Purchase");
        assertTrue("Purchase page should be displayed", explorationAndPurchase.isPurchasePageDisplayed());
    }

    @Test
    public void testCheckPurchasePageForChoice() {
        explorationAndPurchase.setUserOnDessertRecipePage();
        explorationAndPurchase.chooseOption("Purchase");
        assertTrue(explorationAndPurchase.checkPurchasePageForChoice("Purchase"));
    }
}
