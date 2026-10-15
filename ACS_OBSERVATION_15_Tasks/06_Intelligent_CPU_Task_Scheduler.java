import java.util.*;

public class IntelligentCPUTaskScheduler {
    static class Task {
        char name;
        int remaining;
        int readyTime;
        Task(char name, int remaining, int readyTime) {
            this.name = name;
            this.remaining = remaining;
            this.readyTime = readyTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cooldownPeriod = sc.nextInt();
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char task = sc.next().charAt(0);
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Task> available = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.remaining, a.remaining)
        );
        for (Map.Entry<Character, Integer> e : frequency.entrySet())
            available.offer(new Task(e.getKey(), e.getValue(), 0));

        Queue<Task> cooling = new PriorityQueue<>(
            Comparator.comparingInt(t -> t.readyTime)
        );

        int time = 0, completed = 0;
        while (completed < n) {
            while (!cooling.isEmpty() && cooling.peek().readyTime <= time)
                available.offer(cooling.poll());

            if (!available.isEmpty()) {
                Task task = available.poll();
                task.remaining--;
                completed++;
                if (task.remaining > 0) {
                    task.readyTime = time + cooldownPeriod + 1;
                    cooling.offer(task);
                }
                time++;
            } else if (!cooling.isEmpty()) {
                time = cooling.peek().readyTime;
            }
        }
        System.out.println(time);
    }
}
