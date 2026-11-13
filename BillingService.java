package task10;

public class BillingService {
    public void chargeStay(String guestName, double total) {
        System.out.printf("[BillingService] Charged %s $%.2f for the stay.%n", guestName, total);
    }
}
