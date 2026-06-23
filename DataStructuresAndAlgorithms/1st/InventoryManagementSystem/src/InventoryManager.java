import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Product> inventory;
    private int totalProducts;

    public InventoryManager() {
        this.inventory = new HashMap<>();
        this.totalProducts = 0;
    }

    // Add product - O(1)
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("❌ Product ID " + product.getProductId() + " already exists!");
            return;
        }
        inventory.put(product.getProductId(), product);
        totalProducts++;
        System.out.println("✅ Product added: " + product.getProductName());
    }

    // Update product - O(1)
    public void updateProduct(String productId, String newName, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("❌ Product with ID " + productId + " not found!");
            return;
        }

        if (newName != null && !newName.isEmpty()) {
            product.setProductName(newName);
        }
        if (newQuantity >= 0) {
            product.setQuantity(newQuantity);
        }
        if (newPrice >= 0) {
            product.setPrice(newPrice);
        }
        System.out.println("✅ Product updated: " + product.getProductName());
    }

    // Delete product - O(1)
    public void deleteProduct(String productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            totalProducts--;
            System.out.println("✅ Product deleted: " + removed.getProductName());
        } else {
            System.out.println("❌ Product with ID " + productId + " not found!");
        }
    }

    // Search product by ID - O(1)
    public Product searchProductById(String productId) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("❌ Product with ID " + productId + " not found!");
            return null;
        }
        System.out.println("✅ Product found: " + product);
        return product;
    }

    // Display all products - O(n)
    public void displayAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("📦 Inventory is empty!");
            return;
        }

        System.out.println("\n📦 INVENTORY LIST (Total: " + totalProducts + " products)");
        System.out.println("=".repeat(60));
        System.out.println("ID     | Name                    | Qty   | Price");
        System.out.println("-".repeat(60));

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
        System.out.println("=".repeat(60) + "\n");
    }

    // Get total value - O(n)
    public double getTotalInventoryValue() {
        double totalValue = 0;
        for (Product product : inventory.values()) {
            totalValue += product.getQuantity() * product.getPrice();
        }
        return totalValue;
    }

    // Check if product exists
    public boolean productExists(String productId) {
        return inventory.containsKey(productId);
    }

    // Get total number of products
    public int getTotalProducts() {
        return totalProducts;
    }
}