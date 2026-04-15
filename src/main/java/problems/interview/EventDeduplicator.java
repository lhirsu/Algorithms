package problems.interview;

import java.util.*;

public class EventDeduplicator {

    private final Map<String, Long> lastSeen = new HashMap<>();
    private final int windowSeconds;

    public EventDeduplicator(int windowSeconds) {
        this.windowSeconds = windowSeconds;
    }

    public boolean shouldProcess(String eventId, long timestampSeconds) {
        Long lastTime = lastSeen.get(eventId);

        if (lastTime != null && timestampSeconds - lastTime < windowSeconds) {
            return false;
        }

        lastSeen.put(eventId, timestampSeconds);

        return true;
    }

    public static void main(String[] args) {
        EventDeduplicator dedup = new EventDeduplicator(5);

        System.out.println(dedup.shouldProcess("A", 1));  // true
        System.out.println(dedup.shouldProcess("A", 3));  // false
        System.out.println(dedup.shouldProcess("A", 7));  // true
        System.out.println(dedup.shouldProcess("B", 8));  // true
        System.out.println(dedup.shouldProcess("A", 10)); // false
    }
}