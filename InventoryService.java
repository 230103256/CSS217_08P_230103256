package task5;

import java.util.HashMap;
import java.util.Map;
public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("BOOK-JAVA", 2);
        stock.put("MOUSE-01", 1);
    }

    public boolean reserve(String itemId) {
        int left = stock.getOrDefault(itemId, 0);
        if (left <= 0) {
            System.out.println("[InventoryService] Item " + itemId + " is out of stock.");
            return false;
        }
        stock.put(itemId, left - 1);
        System.out.println("[InventoryService] Reserved " + itemId + " (left: " + (left - 1) + ").");
        return true;
    }

    public void release(String itemId) {
        stock.merge(itemId, 1, Integer::sum);
        System.out.println("[InventoryService] Reservation of " + itemId + " released.");
    }
}
