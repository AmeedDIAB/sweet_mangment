package special.planner;

import org.example.ProductManagementManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ProductManagementManagerTest {

    private ProductManagementManager manager;

    @Before
    public void setUp() {
        manager = new ProductManagementManager();
        manager.addProduct("Product A", 100.0, 10, "Category 1");
        manager.addProduct("Product B", 150.0, 20, "Category 2");
    }

    @Test
    public void testAddProduct() {
        manager.addProduct("Product C", 200.0, 30, "Category 3");
        List<ProductManagementManager.Product> products = manager.getProductList();
        assertEquals(3, products.size());
        assertTrue(products.contains(new ProductManagementManager.Product("Product C", 200.0, 30, "Category 3")));
    }

    @Test
    public void testRemoveProduct() {
        manager.removeProduct("Product A");
        List<ProductManagementManager.Product> products = manager.getProductList();
        assertEquals(1, products.size());
        assertFalse(products.contains(new ProductManagementManager.Product("Product A", 100.0, 10, "Category 1")));
    }

    @Test
    public void testUpdateProduct() {
        manager.updateProduct("Product B", 180.0, 25, "Updated Category");
        List<ProductManagementManager.Product> products = manager.getProductList();
        assertTrue(products.contains(new ProductManagementManager.Product("Product B", 180.0, 25, "Updated Category")));
    }

    @Test
    public void testSetDiscount() {
        manager.setDiscount("Product B", 10.0);
        List<ProductManagementManager.Product> products = manager.getProductList();
        ProductManagementManager.Product product = new ProductManagementManager.Product("Product B", 135.0, 20, "Category 2");
        assertTrue(products.contains(product));
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateNonExistingProduct() {
        manager.updateProduct("Non-Existing Product", 200.0, 10, "Category");
    }

    @Test(expected = RuntimeException.class)
    public void testSetDiscountOnNonExistingProduct() {
        manager.setDiscount("Non-Existing Product", 10.0);
    }
}
