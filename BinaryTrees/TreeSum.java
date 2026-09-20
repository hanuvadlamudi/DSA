public class TreeSum {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int Sum(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = Sum(root.left);
        int rightsum = Sum(root.right);
        return leftsum + rightsum + root.data;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(Sum(root));
    }
}
