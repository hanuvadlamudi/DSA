
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String str = "({[{()}]})";
        int n = str.length();
        Stack<Character> s = new Stack<>();
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i)== '('){
                s.push(str.charAt(i));
            }else{
                if(s.isEmpty()){
                    System.out.println("Not a valid Paranthesis");
                    break;
                }
                if( (s.peek() == '(' && str.charAt(i)==')' ) ||
              (s.peek() == '[' && str.charAt(i)==']' ) ||
              (s.peek() == '{' && str.charAt(i)=='}' ) ){
                s.pop();
              }else{
                System.out.println("Not a Valid paranthesis");
                break;
              }
            }
        }
        if(s.isEmpty()){
            System.out.println("Valid Paranthesis");
        }else{
            System.out.println("Not a valid Paranthesis");
        }
    }
}
