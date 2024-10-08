import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderManager {
    public static void sortProducts(List<Product> productList) {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                double priceDiff = p1.calculateTotalPrice() - p2.calculateTotalPrice();
                if (priceDiff != 0) {
                    return (int) Math.signum(priceDiff);
                }
                int nameComparison = p1.getName().compareToIgnoreCase(p2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                }
                return Integer.compare(p1.getStockQuantity(), p2.getStockQuantity());
            }
        });
    }
}
