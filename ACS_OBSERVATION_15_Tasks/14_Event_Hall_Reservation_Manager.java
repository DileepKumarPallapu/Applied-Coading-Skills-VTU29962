import java.util.*;

public class EventHallReservationManager {
    static class Event {
        int start, end;
        Event(int start, int end) { this.start = start; this.end = end; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Event[] events = new Event[n];

        for (int i = 0; i < n; i++)
            events[i] = new Event(sc.nextInt(), sc.nextInt());

        Arrays.sort(events, Comparator.comparingInt((Event e) -> e.end)
                                      .thenComparingInt(e -> e.start));

        int count = 0, lastEnd = Integer.MIN_VALUE;
        for (Event event : events) {
            if (event.start >= lastEnd) {
                count++;
                lastEnd = event.end;
            }
        }
        System.out.println("MaximumEvents = " + count);
    }
}
