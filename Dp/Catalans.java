public class Catalans{
    public static int solve(int n){
        if(n==0 || n==1){
            return 1;
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            ans += solve(i) * solve(n-i-1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solve(n));
    }
}