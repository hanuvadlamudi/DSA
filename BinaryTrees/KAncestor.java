public class KAncestor {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    public static int ancestorK(Node root,int n,int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }
        
        int leftan = ancestorK(root.left,n, k);
        int rightan = ancestorK(root.right,n, k);

        if(leftan == -1 && rightan == -1){
            return -1;
        }

        int max = Math.max(leftan,rightan) +1;

        if(max == k){
            System.out.println(root.data);
        }

        return max;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ancestorK(root, 7, 2);
    }
}
