import java.util.Stack;

public class MaxHistogram {
    public static void Area(int a[]){
        int n = a.length;
        int nsr[] = new int[n];
        int nsl[] = new int[n];

        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while (!s.isEmpty() && a[s.peek()] >= a[i] ) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i] = s.peek();

            }
            s.push(i);
        }

        for(int i=0;i<n;i++){
            while(!s.isEmpty() && a[s.peek()] >= a[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        int maxarea = 0;
        for(int i=0;i<a.length;i++){
            int height = a[i];
            int width = nsr[i] - nsl[i] -1;
            int area = height * width;
            maxarea = Math.max(area, maxarea);
        }
        System.out.println(maxarea);
    }
    public static void main(String[] args) {
        int a[] = {2,1,5,6,2,3};
        Area(a);
    }
}
