import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int a[] = {6,8,0,8,1,3};

        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[a.length];
        int n = a.length-1;

        for(int i=n;i>=0;i--){

            while(!s.isEmpty() && a[s.peek()] <= a[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = a[s.peek()];
            }

            s.push(i);
        }

        for(int i=0;i<a.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}
