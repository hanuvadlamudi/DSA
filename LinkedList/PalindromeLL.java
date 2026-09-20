public class PalindromeLL {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    public void print(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"---");
            temp = temp.next;
        }
        System.out.println("Null");
    }


    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast !=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(){

        if(head==null || head.next==null){
            return true;
        }

        Node midNode = findMid(head);
        
        Node prev = null;
        Node next;
        Node curr = midNode;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head ;
        Node right = prev;

        while(left != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    public static void main(String[] args) {
        PalindromeLL l = new PalindromeLL();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(1);
        l.print();
        System.out.println(l.isPalindrome());
    }
}
