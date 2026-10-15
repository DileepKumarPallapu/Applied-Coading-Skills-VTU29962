import java.util.*;

public class MultiCityDeliveryOptimizationSystem {
    static class Element {
        int value, listIndex, elementIndex;
        Element(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), k = sc.nextInt();
        int[][] lists = new int[m][];
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(e -> e.value)
        );

        for (int i = 0; i < m; i++) {
            int size = sc.nextInt();
            lists[i] = new int[size];
            for (int j = 0; j < size; j++) lists[i][j] = sc.nextInt();
            if (size > 0) minHeap.offer(new Element(lists[i][0], i, 0));
        }

        List<Integer> merged = new ArrayList<>();
        PriorityQueue<Integer> topK = new PriorityQueue<>();

        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            merged.add(current.value);
            if (k > 0) {
                topK.offer(current.value);
                if (topK.size() > k) topK.poll();
            }

            int next = current.elementIndex + 1;
            if (next < lists[current.listIndex].length)
                minHeap.offer(new Element(lists[current.listIndex][next], current.listIndex, next));
        }

        System.out.println("Merged:");
        printList(merged);

        List<Integer> top = new ArrayList<>(topK);
        top.sort(Collections.reverseOrder());
        System.out.println("TopK:");
        printList(top);
    }

    static void printList(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(values.get(i));
        }
        System.out.println();
    }
}
