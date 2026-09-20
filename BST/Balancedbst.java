public class Balancedbst {
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

    public static Node buildBst(int a[],int si,int ei){
        if(si > ei){
            return null;
        }

        int mid = si +(ei - si) / 2;

        Node root = new Node(a[mid]);

        root.left = buildBst(a, si, mid - 1);
        root.right = buildBst(a, mid + 1, ei);

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
     public static void main(String[] args) {
        int a[] = {3,5,6,8,10,11,12};
        Node root = buildBst(a, 0, a.length-1);

        preOrder(root);
    }
}
