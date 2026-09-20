import java.util.ArrayList;

public class Path {
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

    public static Node Create(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data >= val) {
            root.left = Create(root.left, val);
        } else {
            root.right = Create(root.right, val);
        }

        return root;
    }

    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("null");
    }

    static ArrayList<Integer> path = new ArrayList<>();

    public static void printPaths(Node root) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printPaths(root.left);
        printPaths(root.right);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int val[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Create(root, val[i]);
        }

        Inorder(root);
        System.out.println();
        printPaths(root);
    }
}
