import java.util.LinkedList;
import java.util.Queue;

public class Level_order {
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

    static class BinaryTree{
        static int idx = -1;
        public static Node treeFormation(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = treeFormation(nodes);
            newNode.right = treeFormation(nodes);

            return newNode;
        }

        public static void traversal(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node newNode = q.remove();
                if(newNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(newNode.data+" ");
                    if(newNode.left != null){
                        q.add(newNode.left);
                    }
                    if(newNode.right != null){
                        q.add(newNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.treeFormation(nodes);
        tree.traversal(root);
    }
}
