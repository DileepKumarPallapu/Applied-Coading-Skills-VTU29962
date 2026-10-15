import java.util.*;

public class EmployeeHierarchyAnalyzer {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    static Node buildTree(int[] values) {
        if (values.length == 0 || values[0] == -1) return null;
        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length && !queue.isEmpty()) {
            Node current = queue.poll();
            if (i < values.length && values[i] != -1) {
                current.left = new Node(values[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && values[i] != -1) {
                current.right = new Node(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int levels(Node root) {
        return root == null ? 0 : 1 + Math.max(levels(root.left), levels(root.right));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();

        Node root = buildTree(values);
        System.out.println("Height = " + height(root));
        System.out.println("Levels = " + levels(root));
    }
}
