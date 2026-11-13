package task5;

public class PaymentProcessor {
    public boolean charge(double amount) {
        if (amount <= 0) {
            System.out.println("[PaymentProcessor] Invalid amount: " + amount);
            return false;
        }
        System.out.printf("[PaymentProcessor] Charged $%.2f.%n", amount);
        return true;
    }
}
