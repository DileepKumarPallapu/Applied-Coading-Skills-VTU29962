import java.util.*;

public class FactoryTemperatureMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], result = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) stack.pop();
            if (!stack.isEmpty()) result[i] = stack.peek();
            stack.push(a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
