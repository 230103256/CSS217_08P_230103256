package task11;

import java.util.Set;

public class TicketVerifier {
    private final Set<String> validBookings = Set.of("BK1001", "BK1002", "BK1003");

    public boolean isValid(String bookingRef) { return validBookings.contains(bookingRef); }
}
