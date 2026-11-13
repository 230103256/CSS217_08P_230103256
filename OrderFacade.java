package task5;


public class OrderFacade {
    private final InventoryService inventory;
    private final PaymentProcessor payment;
    private final ShippingService shipping;

    public OrderFacade(InventoryService inventory, PaymentProcessor payment, ShippingService shipping) {
        this.inventory = inventory;
        this.payment = payment;
        this.shipping = shipping;
    }

    public boolean placeOrder(String itemId, double amount, String address) {
        System.out.println("=== Placing order for " + itemId + " ===");
        if (!inventory.reserve(itemId)) {
            System.out.println("Order failed: item unavailable.");
            return false;
        }
        if (!payment.charge(amount)) {
            inventory.release(itemId);   // откат резерва, если оплата не прошла
            System.out.println("Order failed: payment declined.");
            return false;
        }
        shipping.createLabel(itemId, address);
        System.out.println("Order completed!");
        return true;
    }
}
