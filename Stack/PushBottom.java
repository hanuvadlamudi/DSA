import java.util.Stack;
public class PushBottom {
    public static void Push(Stack<Integer> s,int n){
        if(s.isEmpty()){
            s.push(n);
            return;
        }
        int top = s.pop();
        Push(s,n);
        s.push(top);
    }
        public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        Push(s, 0);
        System.out.println(s);
    }
}
