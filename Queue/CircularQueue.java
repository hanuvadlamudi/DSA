public class CircularQueue{
    static class Queue{
        static int a[];
        static int size;
        static int front;
        static int rear;

        Queue(int n){
            a = new int[n];
            size = n;
            rear = front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isfull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){
            if(isfull()){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front++;
            }

            rear = (rear+1) % size;
            a[rear] = data;

        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int pop = a[front];
            if(front==rear){
                front=rear=-1;
            }else{
            front = (front+1)%size;
            }
            return pop;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return a[front];     
        }
    }
    public static void main(String[] args) {
        Queue q =  new Queue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}