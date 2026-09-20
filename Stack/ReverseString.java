import java.util.Stack;

public class ReverseString {
    public static String Reverse(String a){
        Stack<Character> s = new Stack<>();
        int n = a.length();
        int i = 0;
        while(i<n){
            s.push(a.charAt(i));
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            char c = s.pop();
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(Reverse(a));
    }
}
