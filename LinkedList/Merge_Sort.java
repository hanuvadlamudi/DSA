public class Merge_Sort {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data  = data ;
            this.next = null;
        }
    }

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
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+"<>");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    
    public static Node head;
    public static Node tail;

    public static Node getmid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1,Node head2){
        Node merged = new Node(-1);
        Node temp = merged;
        while(head1!= null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    public static Node MergeSort(Node head){    
        if(head==null || head.next == null){
            return head;
        }
        Node mid = getmid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(rightHead);
        return merge(newLeft,newRight);
    }

    public static void main(String[] args) {
        Merge_Sort list = new Merge_Sort();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.print();
        list.head = list.MergeSort(list.head);
        list.print();
    }
}
