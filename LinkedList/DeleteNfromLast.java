public class DeleteNfromLast{
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data  = data ;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail =  newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        if(head == null){
            System.out.println("Node is Empty");
        }
        while(temp != null){
            System.out.print(temp.data+">-");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void delete(int n) {
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(size == n){
            head = head.next;
            return;
        }

        int i = 1;
        int indexlast = size - n;
        Node prev = head;
        while(i < indexlast){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public static void main(String[] args) {
        DeleteNfromLast list = new DeleteNfromLast();
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.print();
        list.delete(3);
        list.print();
    }
}
