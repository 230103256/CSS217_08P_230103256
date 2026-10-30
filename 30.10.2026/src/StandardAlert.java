public class StandardAlert extends Notification {
    public StandardAlert(Sender sender) {
        super(sender);
    }
    public void deliver(String text) {
        sender.send("INFO: " + text);
    }
}