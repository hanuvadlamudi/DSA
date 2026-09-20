public class ClimbingStairs {
    public static int numOfWaysR(long n){
        if(n==0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        return numOfWaysR(n-1)+numOfWaysR(n-2);
    }

    //Memoization

    public static int memoization(int[] dp,int n){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        if(dp[n]==-1){
            return dp[n];
        }

        dp[n] = memoization(dp, n-1)  + memoization(dp, n-2);

        return dp[n];
    }

    public static void tabulation(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        for(int dps : dp){
            System.out.print(dps+" ");
        }
    }
    public static void main(String[] args) {
        int n =6;

        for(int i=0;i<=n;i++){
            System.out.println("For climbing "+i+" stairs , Ways = "+numOfWaysR(i));
        }

        int arr[] = new int[n+1];
        for(int i=0;i<=n;i++){
            System.out.println(memoization(arr, i));
        }

        tabulation(n);
    }
}
