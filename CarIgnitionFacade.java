package task08;


public class CarIgnitionFacade {
    private static final double MIN_VOLTAGE = 12.0;

    private final Battery battery;
    private final FuelPump fuelPump;
    private final StarterMotor starter;
    private final DashboardDisplay dashboard;
    private boolean engineRunning = false;

    public CarIgnitionFacade(Battery battery, FuelPump fuelPump,
                             StarterMotor starter, DashboardDisplay dashboard) {
        this.battery = battery;
        this.fuelPump = fuelPump;
        this.starter = starter;
        this.dashboard = dashboard;
    }

    public void startEngine() {
        System.out.println("=== Starting Engine ===");
        if (engineRunning) {
            System.out.println("Engine is already running.");
            return;
        }
        if (battery.checkVoltage() < MIN_VOLTAGE) {
            System.out.println("Battery too weak. Start aborted.");
            return;
        }
        fuelPump.primeFuelLine();
        starter.crank();
        dashboard.illuminateGauges();
        engineRunning = true;
        System.out.println("Ready to drive!");
    }

    public void stopEngine() {
        System.out.println("=== Stopping Engine ===");
        if (!engineRunning) {
            System.out.println("Engine is not running.");
            return;
        }
        starter.stopEngine();
        fuelPump.stop();
        dashboard.turnOff();
        engineRunning = false;
    }
}
