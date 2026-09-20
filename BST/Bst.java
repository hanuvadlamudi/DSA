public class Bst{
    static class Node{
        int data ;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    
    public static Node  TreeFormation(Node root,int val){

        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = TreeFormation(root.left, val);
        }else{
            root.right = TreeFormation(root.right, val);
        }

        return root;
    }
    
    public static void Inorder(Node root){
        if(root == null){
            return;
        }

        Inorder(root.left);     
        System.out.print(root.data+" ");
        Inorder(root.right);
    }


    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = TreeFormation(root, values[i]);
        }

        Inorder(root);
    }
}