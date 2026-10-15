import java.util.*;

public class EmergencyRouteMeetingPoint {
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

    static Node lca(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b) return root;
        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    static boolean contains(Node root, int target) {
        if (root == null) return false;
        return root.data == target || contains(root.left, target) || contains(root.right, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();
        int a = sc.nextInt(), b = sc.nextInt();

        Node root = buildTree(values);
        if (!contains(root, a) || !contains(root, b)) {
            System.out.println("LCA not found");
        } else {
            System.out.println("LCA = " + lca(root, a, b).data);
        }
    }
}
