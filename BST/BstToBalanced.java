import java.util.ArrayList;

public class BstToBalanced {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inOrder(ArrayList<Integer> list, Node root) {
        if (root == null) {
            return;
        }

        inOrder(list, root.left);
        list.add((root.data));
        inOrder(list, root.right);

    }

    public static Node CreateBst(ArrayList<Integer> list, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = si + (ei - si) / 2;

        Node root = new Node(list.get(mid));

        root.left = CreateBst(list, si, mid - 1);
        root.right = CreateBst(list, mid + 1, ei);

        return root;
    }

    public static Node toBalancedBst(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(list, root);

        int si = 0;
        int ei = list.size() - 1;

        root = CreateBst(list, si, ei);

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preOrder(root);
        System.out.println();

        root = toBalancedBst(root);

        preOrder(root);

    }
}
