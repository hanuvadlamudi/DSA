import java.util.ArrayList;

public class LowestCommonAncestor {
    
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

    public static boolean isPath(Node root,ArrayList<Node> list,int j){
        if(root == null){
            return false;
        }
        
        list.add(root);
        if(root.data == j){
            return true;
        }

        boolean lefttree = isPath(root.left, list,j);
        boolean righttree = isPath(root.right, list,j);

        if(lefttree || righttree){
            return true;
        }

        list.remove(list.size()-1);
        return false;
    }

    public static Node lca(Node root, int j, int k){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        isPath(root, path1,j);
        isPath(root, path2,k);

        if(path1.isEmpty() && path2.isEmpty()){
            return null;
        }

        int i=0;
        for(;i<path1.size() && i<path2.size() ; i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        return path1.get(i-1);
    }
    
    //METHOD - 2

    public static Node lca2(Node root,int n1,int n2){
        
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        if(leftlca == null){
            return rightlca;
        }

        if(rightlca == null){
            return leftlca;
        }

        return root;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

    //    System.out.println(lca(root, 5, 4).data);

      System.out.println(lca2(root, 2, 90).data);
    }
}
