package task10;


public class HotelReceptionFacade {
    private final RoomAvailability rooms;
    private final BillingService billing;
    private final KeyCardEncoder keyEncoder;
    private final HousekeepingNotifier housekeeping;

    public HotelReceptionFacade(RoomAvailability rooms, BillingService billing,
                                KeyCardEncoder keyEncoder, HousekeepingNotifier housekeeping) {
        this.rooms = rooms;
        this.billing = billing;
        this.keyEncoder = keyEncoder;
        this.housekeeping = housekeeping;
    }

        public int checkInGuest(String guestName, String roomType, int nights) {
        System.out.println("=== Check-in: " + guestName + " (" + roomType + ", " + nights + " nights) ===");

        if (nights <= 0 || !rooms.isValidType(roomType)) {
            System.out.println("Check-in refused: invalid room type or number of nights.");
            return -1;
        }

        int room = rooms.assignRoom(roomType);
        if (room == -1) {
            System.out.println("Sorry, no " + roomType + " rooms are available.");
            return -1;
        }

        double total = rooms.getNightlyRate(roomType) * nights;
        billing.chargeStay(guestName, total);
        keyEncoder.encodeKey(room, guestName);
        System.out.println("Welcome, " + guestName + "! Your room is " + room + ".");
        return room;
    }


    public void checkOutGuest(int roomNumber) {
        System.out.println("=== Check-out: room " + roomNumber + " ===");
        if (!rooms.releaseRoom(roomNumber)) {
            System.out.println("Room " + roomNumber + " is not occupied. Nothing to do.");
            return;
        }
        housekeeping.requestCleaning(roomNumber);
        System.out.println("Thank you for staying with us!");
    }
}
