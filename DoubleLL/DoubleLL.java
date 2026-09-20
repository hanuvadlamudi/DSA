public class DoubleLL {
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void addLast(int data){
        Node newNode = new Node(data);

        if(tail == null){
            head = tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static void removeFirst(){
        if(head == null){
            System.out.println("LL is Empty");
            return;
        }

        head=head.next;
        head.prev = null;
    }

    public static void removeLast(){
        if(tail == null){
            System.out.println("LL is Empty");
        }

        tail = tail.prev;
        tail.next = null;

    }

    public static void reverse(){
        if(head == null){
            System.out.println("LL is Empty");
            return;
        }

        Node prev = null;
        Node next;
        Node curr = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void print(){
        if(head == null){
            System.out.println("DoublyLL is Empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        DoubleLL ll = new DoubleLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(5);
        ll.addLast(6);

        ll.print();

        ll.removeFirst();
        ll.removeLast();
        ll.print();
        ll.reverse();
        ll.print();
    }
}
