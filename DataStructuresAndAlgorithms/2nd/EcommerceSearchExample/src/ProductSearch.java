import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    // ========== LINEAR SEARCH ==========
    // O(n) - Best: O(1), Worst: O(n)
    public static Product linearSearch(Product[] products, String productId) {
        for (int i = 0; i < products.length; i++) {
            // Comparison counter for analysis
            if (products[i].getProductId().equals(productId)) {
                return products[i];
            }
        }
        return null; // Not found
    }

    // Linear search with step counter (for analysis)
    public static Product linearSearchWithSteps(Product[] products, String productId) {
        int steps = 0;
        for (int i = 0; i < products.length; i++) {
            steps++;
            if (products[i].getProductId().equals(productId)) {
                System.out.println("📊 Linear Search took " + steps + " steps");
                return products[i];
            }
        }
        System.out.println("📊 Linear Search took " + steps + " steps (not found)");
        return null;
    }

    // ========== BINARY SEARCH ==========
    // O(log n) - Best: O(1), Worst: O(log n)
    // IMPORTANT: Products must be sorted by productId!
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                System.out.println("📊 Binary Search took " + steps + " steps");
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        System.out.println("📊 Binary Search took " + steps + " steps (not found)");
        return null;
    }

    // Sort products by productId (required for binary search)
    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
    }
}