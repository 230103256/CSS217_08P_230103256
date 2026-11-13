package task08;

public class Battery {
    private final double voltage;

    public Battery(double voltage) { this.voltage = voltage; }

    public double checkVoltage() {
        System.out.println("[Battery] Voltage: " + voltage + " V.");
        return voltage;
    }
}
