class UrgentAlert extends Notification {
    public UrgentAlert(Sender sender) {
        super(sender);
    }
    public void deliver(String text) {
        sender.send("CRITICAL: " + text + " [ACK REQUIRED]");
    }
}

