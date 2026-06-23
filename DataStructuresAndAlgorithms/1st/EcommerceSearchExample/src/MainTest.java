import java.util.Random;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("===== E-COMMERCE SEARCH FUNCTIONALITY =====\n");

        // ========== TEST 1: SMALL DATASET ==========
        System.out.println("--- TEST 1: Small Dataset (10 products) ---\n");

        // Create 10 sample products
        Product[] smallProducts = {
                new Product("P100", "Laptop Pro", "Electronics", 1299.99),
                new Product("P101", "Wireless Mouse", "Electronics", 29.99),
                new Product("P102", "Gaming Keyboard", "Electronics", 89.99),
                new Product("P103", "4K Monitor", "Electronics", 399.99),
                new Product("P104", "USB-C Cable", "Accessories", 19.99),
                new Product("P105", "Phone Stand", "Accessories", 15.99),
                new Product("P106", "Bluetooth Speaker", "Electronics", 79.99),
                new Product("P107", "Smart Watch", "Wearables", 249.99),
                new Product("P108", "Noise Headphones", "Electronics", 199.99),
                new Product("P109", "Wireless Charger", "Accessories", 39.99)
        };

        // Display all products
        System.out.println("Product List:");
        for (Product p : smallProducts) {
            System.out.println("  " + p);
        }

        // Test Linear Search (small dataset)
        System.out.println("\n🔍 Searching for 'P105' using Linear Search:");
        Product found1 = ProductSearch.linearSearchWithSteps(smallProducts, "P105");
        if (found1 != null) {
            System.out.println("✅ Found: " + found1);
        } else {
            System.out.println("❌ Product not found");
        }

        // Test Binary Search (small dataset)
        System.out.println("\n🔍 Searching for 'P105' using Binary Search:");
        // Need to sort first
        ProductSearch.sortProducts(smallProducts);
        Product found2 = ProductSearch.binarySearch(smallProducts, "P105");
        if (found2 != null) {
            System.out.println("✅ Found: " + found2);
        } else {
            System.out.println("❌ Product not found");
        }

        // Search for non-existent product
        System.out.println("\n🔍 Searching for 'P999' (non-existent):");
        ProductSearch.linearSearchWithSteps(smallProducts, "P999");
        ProductSearch.binarySearch(smallProducts, "P999");

        // ========== TEST 2: LARGE DATASET ==========
        System.out.println("\n\n--- TEST 2: Large Dataset (100,000 products) ---\n");

        // Generate 100,000 products
        int size = 100000;
        Product[] largeProducts = new Product[size];
        Random random = new Random();

        System.out.println("Generating " + size + " products...");
        for (int i = 0; i < size; i++) {
            String id = "P" + String.format("%06d", i);
            String name = "Product_" + i;
            String category = getRandomCategory(random);
            double price = 10 + random.nextDouble() * 500;
            largeProducts[i] = new Product(id, name, category, price);
        }
        System.out.println("✅ " + size + " products generated\n");

        // Linear Search - Worst Case (search for last product)
        String lastProductId = "P" + String.format("%06d", size - 1);
        System.out.println("🔍 Linear Search (last product - worst case):");
        long startTime = System.nanoTime();
        Product linearResult = ProductSearch.linearSearchWithSteps(largeProducts, lastProductId);
        long endTime = System.nanoTime();
        long linearTime = (endTime - startTime) / 1000000; // Convert to ms

        if (linearResult != null) {
            System.out.println("✅ Found: " + linearResult);
        }
        System.out.println("⏱️ Time taken: " + linearTime + "ms\n");

        // Binary Search - Must sort first
        System.out.println("Sorting products for binary search...");
        startTime = System.nanoTime();
        ProductSearch.sortProducts(largeProducts);
        endTime = System.nanoTime();
        long sortTime = (endTime - startTime) / 1000000;
        System.out.println("✅ Sorting completed in " + sortTime + "ms\n");

        // Binary Search (log n performance)
        System.out.println("🔍 Binary Search (last product):");
        startTime = System.nanoTime();
        Product binaryResult = ProductSearch.binarySearch(largeProducts, lastProductId);
        endTime = System.nanoTime();
        long binaryTime = (endTime - startTime) / 1000000;

        if (binaryResult != null) {
            System.out.println("✅ Found: " + binaryResult);
        }
        System.out.println("⏱️ Time taken: " + binaryTime + "ms\n");

        // Performance Comparison
        System.out.println("\n📊 PERFORMANCE COMPARISON:");
        System.out.println("=" .repeat(50));
        System.out.println("Algorithm      | Steps (Worst) | Time (ms)");
        System.out.println("-".repeat(50));
        System.out.printf("Linear Search  | %-13d | %dms%n", size, linearTime);
        System.out.printf("Binary Search  | %-13d | %dms%n",
                (int)(Math.log(size) / Math.log(2)), binaryTime);
        System.out.println("=".repeat(50));

        // Speed improvement
        double speedImprovement = (double)linearTime / binaryTime;
        System.out.printf("\n🚀 Binary Search is %.1f times FASTER than Linear Search!\n", speedImprovement);

        // ========== TEST 3: BEST CASE SCENARIO ==========
        System.out.println("\n\n--- TEST 3: Best Case Scenarios ---\n");

        // Linear Search - Best Case (search for first product)
        System.out.println("🔍 Linear Search (first product - best case):");
        ProductSearch.linearSearchWithSteps(largeProducts, "P000000");

        // Binary Search - Best Case (search for middle product)
        System.out.println("\n🔍 Binary Search (middle product - best case):");
        String midProductId = "P" + String.format("%06d", size / 2);
        ProductSearch.binarySearch(largeProducts, midProductId);

        // ========== SUMMARY ==========
        System.out.println("\n\n📝 SUMMARY: When to Use Which Search");
        System.out.println("=" .repeat(60));
        System.out.println("Linear Search  | ✅ Small data (< 100 items) | ✅ Unsorted data");
        System.out.println("                | ✅ Simple implementation   |");
        System.out.println("-".repeat(60));
        System.out.println("Binary Search  | ✅ Large data (> 1000 items)| ✅ Sorted data");
        System.out.println("                | ✅ Frequent searches      |");
        System.out.println("                | ✅ Faster performance     |");
        System.out.println("=" .repeat(60));
    }

    // Helper method for random category
    private static String getRandomCategory(Random random) {
        String[] categories = {"Electronics", "Accessories", "Wearables",
                "Home", "Kitchen", "Books", "Toys", "Clothing"};
        return categories[random.nextInt(categories.length)];
    }
}