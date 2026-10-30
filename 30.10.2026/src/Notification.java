abstract class Notification {
    protected Sender sender;
    public Notification(Sender sender){
        this.sender = sender;
    }
    public abstract void deliver(String text);
}