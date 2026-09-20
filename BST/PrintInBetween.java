public class PrintInBetween {
    static class Node{
        int data ;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node Create(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data >= val){
            root.left = Create(root.left, val);
        }else{
            root.right = Create(root.right,val);
        }

        return root;
    }

    public static void print(Node root,int k1,int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            print(root.left, k1, k2);
            System.out.print(root.data+" ");
            print(root.right, k1, k2);
        }

        if(root.data > k2){
            print(root.left, k1, k2);
        }
        if(root.data < k1){
            print(root.right, k1, k2);
        }
    }
    
    public static void Inorder(Node root){
        if(root == null){
            return ;
        }

        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<val.length; i++){
            root = Create(root, val[i]);
        }

        Inorder(root);

        System.out.println();
        print(root, 10, 14);
    }
}
