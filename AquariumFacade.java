package task06;

/** Фасад: утренний и вечерний уход за аквариумом. */
public class AquariumFacade {
    private final WaterFilter filter;
    private final AquariumHeater heater;
    private final AutoFeeder feeder;
    private final LedHoodLight led;

    public AquariumFacade(WaterFilter filter, AquariumHeater heater, AutoFeeder feeder, LedHoodLight led) {
        this.filter = filter;
        this.heater = heater;
        this.feeder = feeder;
        this.led = led;
    }

    public void runMorningRoutine() {
        System.out.println("=== Morning Routine ===");
        led.daylightMode();
        heater.regulate(26);
        filter.cycle(10);
        feeder.dispensePinch(2);
    }

    public void prepareForNight() {
        System.out.println("=== Preparing for Night ===");
        feeder.dispensePinch(1);
        filter.stop();
        heater.regulate(24);
        led.moonlightMode();
    }
}
