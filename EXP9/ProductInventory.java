import java.util.HashMap;
import java.util.Map;

public class ProductInventory {
    public static void main(String args[]) {
        HashMap<Integer, Integer> inventory = new HashMap<>();
        inventory.put(101, 50); 
        inventory.put(102, 30);  
        inventory.put(103, 70);  
        inventory.put(102, 45); 
        System.out.println("Updated quantity of product 102 to 45.");
        inventory.remove(101);
        System.out.println("Removed product 101 from inventory.");
        System.out.println("Final Product Inventory:");
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product ID: " + productId + ", Quantity: " + quantity);
        }
    }
}

