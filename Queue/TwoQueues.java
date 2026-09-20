import java.util.*;

public class TwoQueues{

    static class Stack{
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(q1.isEmpty()){
                q2.add(data);
            }else{
                q1.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("stack is Empty");
                return -1;
            }
            int top = -1;
            if(q1.isEmpty()){
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        return top;
                    }
                    q1.add(top);
                }
            }else{
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        return top;
                    }
                    q2.add(top);
                }
            }

            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int top = -1;
            if(q1.isEmpty()){
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }else{
                while(!q1.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }
    public static void main(String[] args) {
     Stack s = new Stack();
     
     s.push(0);
     s.push(1);
     s.push(2);

     System.out.println(s.peek());
     System.out.println(s.pop());

    }
}