package task11;

public class BoardingPassGenerator {
    public String generate(String bookingRef, String seat, String bagTag) {
        return "+-----------------------------+\n"
             + "|        BOARDING PASS        |\n"
             + "| Booking : " + bookingRef + "\n"
             + "| Seat    : " + seat + "\n"
             + "| Bag tag : " + bagTag + "\n"
             + "+-----------------------------+";
    }
}
