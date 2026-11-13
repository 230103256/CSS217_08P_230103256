package task11;

public class BaggageHandler {
    public static final double MAX_WEIGHT_KG = 23.0;
    private int tagCounter = 1000;

    public boolean isWithinLimit(double weightKg) {
        return weightKg >= 0 && weightKg <= MAX_WEIGHT_KG;
    }

    public String tagBag(String bookingRef, double weightKg) {
        tagCounter++;
        String tag = "TAG" + tagCounter;
        System.out.printf("[BaggageHandler] Bag %.1f kg tagged as %s for %s.%n", weightKg, tag, bookingRef);
        return tag;
    }
}
