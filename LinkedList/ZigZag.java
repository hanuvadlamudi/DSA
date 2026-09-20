public class ZigZag {
    public static class Node{
        int data;
        Node next ;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public static Node head;
    public static Node tail;

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

    public void Arrange() {
        Node slow = head;
        Node fast = head;

        //Find mid
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node curr = mid.next;
        mid.next = null;
        //Reverse the Right LL

        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL , nextr;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextL;

            left = nextL;
            right = nextr;
        }

    }

    public static void main(String[] args) {
        ZigZag ll = new ZigZag();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        ll.Arrange();
        ll.print();
    }
}