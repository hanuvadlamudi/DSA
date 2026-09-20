import java.util.Stack;

public class ReverseStack{
    public static void PushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        PushAtBottom(s, data);
        s.push(top);
    }
    
    public static void Reverse(Stack <Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        Reverse(s);
        PushAtBottom(s,top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=7; i++){
            s.push(i);
        }
        System.out.println(s);
        Reverse(s);
        System.out.println(s);
    }
}