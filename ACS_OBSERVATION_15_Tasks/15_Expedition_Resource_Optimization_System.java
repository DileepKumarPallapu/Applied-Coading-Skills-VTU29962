import java.util.*;

public class ExpeditionResourceOptimizationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), capacityLimit = sc.nextInt();
        int[] weight = new int[n + 1], value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][capacityLimit + 1];
        for (int i = 1; i <= n; i++) {
            for (int capacity = 0; capacity <= capacityLimit; capacity++) {
                dp[i][capacity] = dp[i - 1][capacity];
                if (weight[i] <= capacity) {
                    dp[i][capacity] = Math.max(dp[i][capacity],
                        dp[i - 1][capacity - weight[i]] + value[i]);
                }
            }
        }

        List<Integer> selected = new ArrayList<>();
        int capacity = capacityLimit;
        for (int i = n; i >= 1; i--) {
            if (dp[i][capacity] != dp[i - 1][capacity]) {
                selected.add(i);
                capacity -= weight[i];
            }
        }
        Collections.reverse(selected);

        System.out.println("MaximumValue = " + dp[n][capacityLimit]);
        System.out.println("SelectedItems:");
        for (int i = 0; i < selected.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(selected.get(i));
        }
        System.out.println();
    }
}
