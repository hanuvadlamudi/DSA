import java.util.Stack;

public class Stacks{
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i=1 ; i<=7 ; i++){
            s.push(i);
        }
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s);
    }
}