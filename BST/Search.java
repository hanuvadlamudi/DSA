public class Search {
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

    public static boolean bstSearch(Node root,int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return bstSearch(root.left, key);
        }else{
            return bstSearch(root.right, key);
        }
    }
    
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        
        for(int i=0;i<values.length;i++){
            root = TreeFormation(root, values[i]);
        }

        if(bstSearch(root, 7)){
            System.out.println("key is Found");
        }else{
            System.out.println("Key is not found");
        }
    }
}

