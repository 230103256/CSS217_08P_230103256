package task09;


public class LibraryCheckoutFacade {
    private final MemberValidator validator;
    private final CatalogService catalog;
    private final FineCalculator fines;
    private final LoanRecorder recorder;

    public LibraryCheckoutFacade(MemberValidator validator, CatalogService catalog,
                                 FineCalculator fines, LoanRecorder recorder) {
        this.validator = validator;
        this.catalog = catalog;
        this.fines = fines;
        this.recorder = recorder;
    }

    public boolean borrowBook(String studentId, String isbn) {
        System.out.println("=== " + studentId + " borrows " + isbn + " ===");
        if (!validator.isActive(studentId)) {
            System.out.println("Denied: student is not active.");
            return false;
        }
        double fine = fines.getOutstandingFine(studentId);
        if (fine > 0) {
            System.out.printf("Denied: unpaid fines of $%.2f.%n", fine);
            return false;
        }
        if (!catalog.exists(isbn)) {
            System.out.println("Denied: book not in catalog.");
            return false;
        }
        if (!catalog.isAvailable(isbn)) {
            System.out.println("Denied: book is already checked out.");
            return false;
        }
        catalog.markCheckedOut(isbn);
        recorder.recordLoan(studentId, isbn);
        System.out.println("Checkout successful.");
        return true;
    }

    public void returnBook(String studentId, String isbn) {
        System.out.println("=== " + studentId + " returns " + isbn + " ===");
        if (!recorder.recordReturn(studentId, isbn)) {
            System.out.println("No matching loan found for this student.");
            return;
        }
        catalog.markReturned(isbn);
        System.out.println("Book returned and available again.");
    }
}
