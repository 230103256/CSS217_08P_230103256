package task06;

/** Подсистема: фильтр воды. */
public class WaterFilter {
    public void cycle(int minutes) { System.out.println("[WaterFilter] Running filter cycle for " + minutes + " min."); }
    public void stop() { System.out.println("[WaterFilter] Filter set to quiet mode."); }
}
