package task10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class RoomAvailability {
    private final Map<String, Deque<Integer>> freeRooms = new HashMap<>();
    private final Map<String, Double> nightlyRates = new HashMap<>();
    private final Map<Integer, String> occupiedRooms = new HashMap<>(); // номер -> тип

    public RoomAvailability() {
        addRoomType("SINGLE", 80.0, 101, 102);
        addRoomType("DOUBLE", 120.0, 201, 202, 203);
        addRoomType("SUITE", 250.0, 301);
    }

    private void addRoomType(String type, double rate, Integer... rooms) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int r : rooms) {
            queue.add(r);
        }
        freeRooms.put(type, queue);
        nightlyRates.put(type, rate);
    }

    /** Выдаёт первый свободный номер заданного типа или -1, если свободных нет. */
    public int assignRoom(String roomType) {
        Deque<Integer> queue = freeRooms.get(roomType);
        if (queue == null || queue.isEmpty()) {
            return -1;
        }
        int room = queue.poll();
        occupiedRooms.put(room, roomType);
        System.out.println("[RoomAvailability] Room " + room + " (" + roomType + ") assigned.");
        return room;
    }

    public double getNightlyRate(String roomType) {
        return nightlyRates.getOrDefault(roomType, 0.0);
    }

    public boolean isValidType(String roomType) {
        return freeRooms.containsKey(roomType);
    }

    /** Возвращает номер в пул свободных. false, если номер не был занят. */
    public boolean releaseRoom(int roomNumber) {
        String type = occupiedRooms.remove(roomNumber);
        if (type == null) {
            return false;
        }
        freeRooms.get(type).add(roomNumber);
        System.out.println("[RoomAvailability] Room " + roomNumber + " released.");
        return true;
    }
}
