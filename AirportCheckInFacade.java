package task11;

public class AirportCheckInFacade {
    private final TicketVerifier verifier;
    private final SeatAllocator seats;
    private final BaggageHandler baggage;
    private final BoardingPassGenerator generator;

    public AirportCheckInFacade(TicketVerifier verifier, SeatAllocator seats,
                                BaggageHandler baggage, BoardingPassGenerator generator) {
        this.verifier = verifier;
        this.seats = seats;
        this.baggage = baggage;
        this.generator = generator;
    }

    public String completeCheckIn(String bookingRef, double bagWeightKg) {
        System.out.println("=== Check-in for " + bookingRef + " ===");
        if (!verifier.isValid(bookingRef)) {
            System.out.println("Rejected: invalid booking reference.");
            return null;
        }
        if (!baggage.isWithinLimit(bagWeightKg)) {
            System.out.println("Rejected: bag weight " + bagWeightKg + " kg exceeds "
                    + BaggageHandler.MAX_WEIGHT_KG + " kg limit.");
            return null;
        }
        String seat = seats.assignNextSeat();
        String tag = baggage.tagBag(bookingRef, bagWeightKg);
        return generator.generate(bookingRef, seat, tag);
    }
}
