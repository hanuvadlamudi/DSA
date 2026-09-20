public class Diameter {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left  = null;
            this.right = null;
        }
    }

    static class Info{
        int dia;
        int h ;
        Info(int dia,int h){
            this.dia = dia;
            this.h = h;
        }
    }

    public static Info diameter(Node root){
        if(root == null){
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diameter = Math.max(Math.max(leftInfo.dia,rightInfo.dia), leftInfo.h + rightInfo.h +1);
        int height = Math.max(leftInfo.h, rightInfo.h) + 1  ;

        return new Info(diameter,height);
    }
    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.right.right = new Node(5);
        // root.right.right.right = new Node(6);
        // root.right.right.right.right = new Node(7);
        Node root = new Node(1);
       root.left = new Node(2);
       root.left.right = new Node(3);
       root.left.left = new Node(1);
       root.left.left.left = new Node(1);
       root.left.left.left.left =  new Node(1);
       root.left.left.left.left.left =  new Node(1);
       root.left.left.left.left.left.left =  new Node(1);
       root.left.left.left.left.left.left.left =  new Node(1);
       root.left.right.right = new Node(1);
       root.left.right.right.right = new Node(1);
       root.left.right.right.right.right = new Node(1);
       root.left.right.right.right.right.right = new Node(1);
       root.right = new Node(9);
       root.right.right = new Node(5);
       root.right.right.right = new Node(6); 

        System.out.println(diameter(root).dia);
        System.out.println(diameter(root).h);
    }
}
