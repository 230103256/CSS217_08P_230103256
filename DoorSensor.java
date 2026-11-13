package task12;


public class DoorSensor {
    private boolean closed;

    public DoorSensor(boolean closed) { this.closed = closed; }
    public boolean isClosed() { return closed; }
    public void setClosed(boolean closed) { this.closed = closed; }
}
