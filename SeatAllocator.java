package task11;
public class SeatAllocator {
    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F'};
    private int next = 0;

    public String assignNextSeat() {
        String seat = (next / LETTERS.length + 1) + "" + LETTERS[next % LETTERS.length];
        next++;
        return seat;
    }
}
