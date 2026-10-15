import java.util.*;

public class CircularDeliveryRouteRepair {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static void removeCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                if (slow == fast) {
                    while (fast.next != slow) fast = fast.next;
                } else {
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
                fast.next = null;
                return;
            }
        }
    }

    static Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) return head;
        Node current = head, newHead = null, previousGroup = null;

        while (current != null) {
            Node check = current;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }

            Node groupEnd = current, previous = check;
            for (int i = 0; i < count; i++) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (newHead == null) newHead = previous;
            if (previousGroup != null) previousGroup.next = previous;
            previousGroup = groupEnd;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        if (n <= 0) return;

        Node head = null, tail = null;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextInt());
            if (head == null) head = nodes[i];
            else tail.next = nodes[i];
            tail = nodes[i];
        }

        int cyclePosition = sc.nextInt();
        if (cyclePosition >= 0 && cyclePosition < n) tail.next = nodes[cyclePosition];

        removeCycle(head);
        head = reverseKGroup(head, k);

        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }
}
