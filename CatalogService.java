package task09;

import java.util.HashMap;
import java.util.Map;


public class CatalogService {
    private final Map<String, Boolean> availability = new HashMap<>();

    public CatalogService() {
        availability.put("978-0134685991", true);
        availability.put("978-0596007126", true);
    }

    public boolean exists(String isbn) { return availability.containsKey(isbn); }
    public boolean isAvailable(String isbn) { return availability.getOrDefault(isbn, false); }
    public void markCheckedOut(String isbn) { availability.put(isbn, false); }
    public void markReturned(String isbn) { availability.put(isbn, true); }
}
