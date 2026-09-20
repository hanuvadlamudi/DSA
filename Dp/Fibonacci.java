import java.util.Arrays;

public class Fibonacci{
    public static int calculate(int n){
        if(n==0 || n==1){
            return n;
        }

        return calculate(n-1) + calculate(n-2);
    }

    public static int memoization(int[] dp,int n){
        if(n ==0 || n==1){
            return n;
        }

        if(dp[n]!= -1){
            return dp[n];
        }

        dp[n]= memoization(dp, n-1) + memoization(dp, n-2);

        return dp[n];
    }

    public static int tabulation(int n){
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 44;
        System.out.println("Recursion : "+calculate(n));

        //memoization
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        for(int i=0;i<=n;i++){
            System.out.println("Memoization for : "+i+" steps is "+memoization(dp, i));
        }

        //tabulation
        System.out.println("Tabulation : "+tabulation(n));
    }
}