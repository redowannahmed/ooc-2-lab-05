import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ProductTesting {

    @Test
    public void testElectronicsTotalPrice() {
        Product electronics = new Electronics("Laptop", 5, 1000);
        assertEquals(1150.0, electronics.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testClothingTotalPrice() {
        Product clothing = new Clothing("T-Shirt", 10, 20);
        assertEquals(22.0, clothing.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testFurnitureTotalPrice() {
        Product furniture = new Furniture("Sofa", 2, 500);
        assertEquals(540.0, furniture.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testProductSortingByPrice() {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("Laptop", 5, 1000));
        products.add(new Clothing("T-Shirt", 10, 20));
        products.add(new Furniture("Sofa", 2, 500));

        OrderManager.sortProducts(products);

        assertEquals("T-Shirt", products.get(0).getName());
        assertEquals("Sofa", products.get(1).getName());
        assertEquals("Laptop", products.get(2).getName());
    }

    @Test
    public void testSortingWithSamePriceDifferentNames() {
        List<Product> products = new ArrayList<>();
        products.add(new Clothing("Shirt", 5, 50));
        products.add(new Clothing("T-Shirt", 10, 50));

        OrderManager.sortProducts(products);

        assertEquals("Shirt", products.get(0).getName());
        assertEquals("T-Shirt", products.get(1).getName());
    }

    @Test
    public void testSortingWithSamePriceSameNameDifferentStock() {
        List<Product> products = new ArrayList<>();
        products.add(new Clothing("T-Shirt", 5, 50));
        products.add(new Clothing("T-Shirt", 10, 50));

        OrderManager.sortProducts(products);

        assertEquals(5, products.get(0).getStockQuantity());
        assertEquals(10, products.get(1).getStockQuantity());
    }
}
