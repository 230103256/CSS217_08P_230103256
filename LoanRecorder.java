package task09;

import java.util.HashMap;
import java.util.Map;


public class LoanRecorder {
    private final Map<String, String> loans = new HashMap<>();

    public void recordLoan(String studentId, String isbn) {
        loans.put(isbn, studentId);
        System.out.println("[LoanRecorder] Loan recorded: " + studentId + " -> " + isbn);
    }

    public boolean recordReturn(String studentId, String isbn) {
        if (!studentId.equals(loans.get(isbn))) {
            return false;
        }
        loans.remove(isbn);
        System.out.println("[LoanRecorder] Return recorded: " + studentId + " <- " + isbn);
        return true;
    }
}
