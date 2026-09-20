public class Delete {
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

    public static Node deleteNode(Node root,int val){
        if(root == null){
            return root;
        }
        if(root.data < val){
            root.right = deleteNode(root.right, val);
        }else if(root.data > val){
            root.left = deleteNode(root.left, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            Node Is = InorderScion(root.right);
            root.data = Is.data;
            root.right = deleteNode(root.right, Is.data);
        }

        return root;
    }

    public static Node InorderScion(Node root) {
        while (root != null && root.left != null) {
            root = root.left;   
        }
        return root;
    }
    
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<val.length; i++){
            root = Create(root, val[i]);
        }

        Inorder(root);

        System.out.println();
        deleteNode(root, 8);
        Inorder(root);
    }
}
