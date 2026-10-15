import java.util.*;

public class MuseumTreasureRoutePlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }

        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();

        int twoBack = 0, oneBack = 0;
        for (int value : values) {
            int current = Math.max(oneBack, twoBack + value);
            twoBack = oneBack;
            oneBack = current;
        }
        System.out.println(oneBack);
    }
}
