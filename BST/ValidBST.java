public class ValidBST {
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
    
    public static void Inorder(Node root){
        if(root == null){
            return ;
        }

        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }

    public static boolean isValidBST(Node root, Node min,Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<val.length; i++){
            root = Create(root, val[i]);
        }

        Inorder(root);
        System.out.println();

        if(isValidBST(root,null, null)){
            System.out.println("Valid");
        }else{
            System.out.println("Not Valid");
        }
    }
}
