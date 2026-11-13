package task04;

public class SmartRoomFacade {
    private final CeilingLight light;
    private final Thermostat thermostat;
    private final WindowBlinds blinds;
    private final DoorLock lock;

    public SmartRoomFacade(CeilingLight light, Thermostat thermostat,
                           WindowBlinds blinds, DoorLock lock) {
        this.light = light;
        this.thermostat = thermostat;
        this.blinds = blinds;
        this.lock = lock;
    }

    public void activateNightMode() {
        System.out.println("=== Night Mode ===");
        light.off();
        blinds.close();
        lock.lock();
        thermostat.setTemperature(19);
    }

    /** Жалюзи открыты, свет вкл, 22°C. */
    public void activateMorningMode() {
        System.out.println("=== Morning Mode ===");
        blinds.open();
        light.on();
        thermostat.setTemperature(22);
    }
}
