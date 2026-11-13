package task03;

public class ComputerFacade {
    private final PowerSupply supply;
    private final BIOS bios;
    private final HardDrive drive;
    private final OperatingSystem system;
    public ComputerFacade (PowerSupply supply,BIOS bios,HardDrive drive,OperatingSystem system) {
        this.supply = supply;
        this.bios = bios;
        this.drive = drive;
        this.system = system;
    }
    public void startComputer() {
        supply.supplyPower();
        bios.runPost();
        drive.spinUp();
        drive.readBootSector();
        system.loadKernel();
    }

    public void shutDownComputer() {
        system.shutdown();
        drive.spinDown();
        bios.shutdown();
        supply.cutPower();
    }




}
