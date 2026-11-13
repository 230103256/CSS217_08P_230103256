package task12;

public class WashingMachineFacade {
    private final DoorSensor door;
    private final WaterValve valve;
    private final DetergentDispenser detergent;
    private final DrumMotor drum;
    private final DrainPump pump;

    public WashingMachineFacade(DoorSensor door, WaterValve valve, DetergentDispenser detergent,
                                DrumMotor drum, DrainPump pump) {
        this.door = door;
        this.valve = valve;
        this.detergent = detergent;
        this.drum = drum;
        this.pump = pump;
    }

    public boolean runQuickWash() {
        System.out.println("=== Quick Wash ===");
        if (!door.isClosed()) {
            System.out.println("Cannot start: door is open.");
            return false;
        }
        valve.fill("cold");
        valve.close();
        detergent.dispense(30);
        drum.spin("Gentle", 15);
        System.out.println("Quick wash finished.");
        return true;
    }

    public boolean runHeavyWash() {
        System.out.println("=== Heavy Wash ===");
        if (!door.isClosed()) {
            System.out.println("Cannot start: door is open.");
            return false;
        }
        valve.fill("warm");
        valve.close();
        detergent.dispense(80);
        drum.spin("High-speed", 45);
        pump.drain();
        System.out.println("Heavy wash finished.");
        return true;
    }
}
