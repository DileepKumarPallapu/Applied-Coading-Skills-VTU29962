import java.util.*;

public class WarehouseProductFrequencyManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            frequency.put(id, frequency.getOrDefault(id, 0) + 1);
        }

        int bestId = Integer.MAX_VALUE, bestCount = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int id = entry.getKey(), count = entry.getValue();
            if (count > bestCount || (count == bestCount && id < bestId)) {
                bestId = id;
                bestCount = count;
            }
        }
        if (n == 0) System.out.println("No products");
        else System.out.println(bestId + " " + bestCount);
    }
}
