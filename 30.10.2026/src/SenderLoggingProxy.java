public class SenderLoggingProxy implements Sender {
    private Sender realSender;
    private int sendCount = 0;

    public SenderLoggingProxy(Sender realSender) {
        this.realSender = realSender;
    }

    public void send(String message) {
        sendCount++;
        System.out.println("[AUDIT] Preparing transmission #" + sendCount + "...");
        realSender.send(message);
        System.out.println("[AUDIT] Transmission complete.");
    }
}