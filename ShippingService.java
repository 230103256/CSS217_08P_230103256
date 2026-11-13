package task5;

public class ShippingService {
    public String createLabel(String itemId, String address) {
        String label = "SHIP-" + itemId + "-" + Math.abs(address.hashCode() % 10000);
        System.out.println("[ShippingService] Label " + label + " created for: " + address);
        return label;
    }
}
