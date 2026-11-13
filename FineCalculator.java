package task09;

import java.util.HashMap;
import java.util.Map;


public class FineCalculator {
    private final Map<String, Double> fines = new HashMap<>();

    public FineCalculator() { fines.put("S003", 5.50); }

    public double getOutstandingFine(String studentId) { return fines.getOrDefault(studentId, 0.0); }
}
