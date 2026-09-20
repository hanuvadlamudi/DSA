public class MinDist {

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

    public static Node lca(Node root,int n1,int n2){

        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if(leftlca == null){
            return rightlca;
        }

        if(rightlca == null){
            return leftlca;
        }

        return root;
    }

    public static int lcadist(Node root,int n){
        
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = lcadist(root.left, n);
        int rightDist = lcadist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }

    public static int distance(Node root,int n1,int n2){
        Node lcaNode = lca(root, n1, n2);
        int dist1 = lcadist(lcaNode,n1);
        int dist2 = lcadist(lcaNode,n2);

        return dist1 + dist2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(distance(root, 5,6));
    }
}
