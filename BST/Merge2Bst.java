import java.util.ArrayList;

public class Merge2Bst {
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

    public static void inOrder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static Node createBst(ArrayList<Integer> mergedList,int si,int ei){
        if(si>ei){
            return null;
        }

        int mid = si + (ei - si)/2;
        Node root = new Node(mergedList.get(mid));
        root.left = createBst(mergedList, si, mid - 1);
        root.right = createBst(mergedList, mid + 1, ei);

        return root;
    }
    public static Node mergeList(Node root1,Node root2){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        ArrayList<Integer> mergedList = new ArrayList<>();
        int i=0 , j=0;

        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i) <= list2.get(j)){
                mergedList.add(list1.get(i));
                i++;
            }else{
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while(i<list1.size()){
            mergedList.add(list1.get(i));
            i++;
        }

        while(j<list2.size()){
            mergedList.add(list2.get(j));
            j++;
        }

        int si =0;
        int ei = mergedList.size()-1;

        return createBst(mergedList, si, ei);
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeList(root1, root2);
        preOrder(root);
    }
}
