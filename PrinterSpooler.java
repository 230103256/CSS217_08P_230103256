package task07;

public class PrinterSpooler {
    private int jobCounter = 0;

    public void queue(String content) {
        jobCounter++;
        System.out.println("[PrinterSpooler] Print job #" + jobCounter + " queued ("
                + content.length() + " characters).");
    }
}
