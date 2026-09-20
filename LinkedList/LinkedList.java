public class LinkedList{
    public static class Node{
        int data;
        Node next ;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(tail==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //add middle
    public void add(int data,int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i< idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
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

    public void removeFirst(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        if(size == 1){
            head = tail = null;
        }
        head = head.next;
        
    }

    public int iterSearch(int key){
        Node temp = head ;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }


    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recursiveSearch(int key){
        return helper(head,key);
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.print();
        System.out.println(size);
        l1.add(7, 2);
        l1.print();
        System.out.println(l1.size);
        l1.removeFirst();
        l1.removeFirst();
        l1.print();
        System.out.println(l1.iterSearch(4));
        System.out.println(l1.iterSearch(3));
        System.out.println(l1.recursiveSearch(4));
        System.out.println(l1.recursiveSearch(3));
    }
}