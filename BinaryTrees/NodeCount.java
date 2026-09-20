public class NodeCount {
    static class Node{
        int data ;
        Node left ;
        Node right ;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftcount = count(root.left);
        int rightcount = count(root.right);
        // int total = leftcount + rightcount +1;

        return leftcount + rightcount +1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        root.right.right.right.right = new Node(7);

        System.out.println(count(root));
    }
}
