public class Main {
    public static void main(String[] args) {
        System.out.println("===== INVENTORY MANAGEMENT SYSTEM =====\n");

        // Create inventory manager
        InventoryManager manager = new InventoryManager();

        // Test 1: Add products
        System.out.println("--- TEST 1: Adding Products ---");
        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Mouse", 50, 29.99);
        Product p3 = new Product("P003", "Keyboard", 25, 79.99);
        Product p4 = new Product("P004", "Monitor", 15, 299.99);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);
        manager.addProduct(p4);

        // Test 2: Display all products
        System.out.println("\n--- TEST 2: Display All Products ---");
        manager.displayAllProducts();

        // Test 3: Search for a product
        System.out.println("--- TEST 3: Search Product ---");
        manager.searchProductById("P002");

        // Test 4: Update a product
        System.out.println("\n--- TEST 4: Update Product ---");
        manager.updateProduct("P003", "Mechanical Keyboard", 30, 89.99);
        manager.displayAllProducts();

        // Test 5: Delete a product
        System.out.println("--- TEST 5: Delete Product ---");
        manager.deleteProduct("P004");
        manager.displayAllProducts();

        // Test 6: Try adding duplicate product
        System.out.println("--- TEST 6: Add Duplicate ---");
        Product duplicate = new Product("P001", "Gaming Laptop", 5, 1299.99);
        manager.addProduct(duplicate);

        // Test 7: Try deleting non-existent product
        System.out.println("\n--- TEST 7: Delete Non-existent Product ---");
        manager.deleteProduct("P999");

        // Test 8: Total inventory value
        System.out.println("\n--- TEST 8: Total Inventory Value ---");
        System.out.printf("💰 Total Inventory Value: $%.2f\n", manager.getTotalInventoryValue());
        System.out.println("📦 Total Products: " + manager.getTotalProducts());

        // Test 9: Performance test (adding many products)
        System.out.println("\n--- TEST 9: Performance Test ---");
        System.out.println("Adding 1000 products...");
        long startTime = System.currentTimeMillis();

        for (int i = 100; i < 1100; i++) {
            Product p = new Product("P" + i, "Product" + i, i, i * 1.5);
            manager.addProduct(p);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("✅ Added 1000 products in " + (endTime - startTime) + "ms");
        System.out.println("📦 Total Products: " + manager.getTotalProducts());

        System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM COMPLETE =====");
    }
}