package task02;

public class CoffeeMachineFacade {
    private final WaterHeater heater;
    private final CoffeeGrinder grinder;
    private final BrewUnit brewUnit;
    private final CupDispenser cupDispenser;

    public CoffeeMachineFacade(WaterHeater heater, CoffeeGrinder grinder,
                               BrewUnit brewUnit, CupDispenser cupDispenser) {
        this.heater = heater;
        this.grinder = grinder;
        this.brewUnit = brewUnit;
        this.cupDispenser = cupDispenser;
    }


    public void brewEspresso() {
        System.out.println("=== Making Espresso ===");
        cupDispenser.dispenseCup();
        heater.heatWater(92);
        grinder.grindBeans("fine");
        brewUnit.brew(25);
        System.out.println("Espresso is ready!");
    }

    public void brewAmericano() {
        System.out.println("=== Making Americano ===");
        cupDispenser.dispenseCup();
        heater.heatWater(95);
        grinder.grindBeans("medium");
        brewUnit.brew(40);
        brewUnit.addHotWater(150);
        System.out.println("Americano is ready!");
    }
}
