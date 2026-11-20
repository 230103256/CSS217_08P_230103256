
public class CoffeeRoasterFacade {
    private final BeanHopperGate hopperGate;
    private final RoastingDrumMotor drumMotor;
    private final HeatingChamber heatingChamber;
    private final CoolingTraySystem coolingTray;
    private final TelemetryLogger logger;

    public CoffeeRoasterFacade() {
        this.hopperGate = new BeanHopperGate();
        this.drumMotor = new RoastingDrumMotor();
        this.heatingChamber = new HeatingChamber();
        this.coolingTray = new CoolingTraySystem();
        this.logger = new TelemetryLogger();
    }
    public boolean runRoastBatch(
            String beanOrigin,
            int batchGrams,
            int drumRpm,
            int targetTempCelsius) {
        try {
            logger.resetBatchLog();
            logger.logState("BATCH", "Batch started: " + beanOrigin);

            hopperGate.loadGreenBeans(batchGrams);
            logger.logState("HOPPER", "Loaded " + batchGrams + "g of green beans.");

            drumMotor.startRotation(drumRpm);
            logger.logState("DRUM", "Drum spinning at " + drumRpm + " RPM.");

            hopperGate.openGate();
            hopperGate.closeGate();
            logger.logState("HOPPER", "Beans charged into drum; gate sealed.");

            heatingChamber.igniteBurner(drumMotor.isSpinning());
            logger.logState("HEATING", "Burner ignited.");

            heatingChamber.heatToTarget(targetTempCelsius);
            logger.logState("HEATING", "Roast phase active at " + targetTempCelsius + "C.");

            heatingChamber.extinguishBurner();
            logger.logState("HEATING", "Target reached; burner extinguished.");

            coolingTray.startCoolingFan();
            logger.logState("COOLING", "Cooling fan started.");

            coolingTray.openDischargeDoor(heatingChamber.isBurnerIgnited());
            logger.logState("COOLING", "Discharge door opened; beans on cooling tray.");

            drumMotor.stopRotation();
            coolingTray.finishCoolingCycle();
            logger.logState("BATCH", "Batch complete for origin: " + beanOrigin);
            return true;

        } catch (RuntimeException ex) {
            emergencyAbort(ex.getMessage());
            return false;
        }
    }
    public boolean roastLightProfile(String beanOrigin, int batchGrams) {
        return runRoastBatch(beanOrigin, batchGrams, 55, 196);
    }
    public boolean roastDarkProfile(String beanOrigin, int batchGrams) {
        return runRoastBatch(beanOrigin, batchGrams, 42, 230);
    }
    public void emergencyAbort(String reason) {
        logger.logState("ABORT", "Emergency shutdown triggered: " + reason);
        heatingChamber.extinguishBurner();
        hopperGate.closeGate();
        drumMotor.stopRotation();
        coolingTray.finishCoolingCycle();
    }
}