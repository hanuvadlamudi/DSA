public class Knapsack0One {
    public static int maxProfit(int val[],int wt[],int capacity,int n){
        if(capacity == 0 ||n ==0){
            return 0;
        }

        if(wt[n-1]<=capacity){
            int profit1 = val[n-1] + maxProfit(val, wt, capacity-wt[n-1], n-1);
            int profit2 = maxProfit(val, wt, capacity, n-1);
            return Math.max(profit1, profit2);
        }else{
            return maxProfit(val, wt, capacity, n-1);
        }
    }

    // MEMOIZATION
    public static int maxProfit(int val[],int weight[],int capacity,int n,int[][] dp){
        if(n == 0 || capacity ==  0){
            return 0;
        }

        if(dp[n][capacity] != -1){
            return dp[n][capacity];
        }

        if(weight[n-1]<=capacity){
            int ans1 = val[n-1] + maxProfit(val, weight, capacity-weight[n-1], n-1,dp);
            int ans2 = maxProfit(val, weight, capacity, n-1, dp);

            dp[n][capacity] = Math.max(ans1, ans2);
            return dp[n][capacity];
        }else{
            dp[n][capacity] = maxProfit(val, weight, capacity, n-1, dp);
            return dp[n][capacity];
        }
    }

    //TABULATION

    public static int maxprofit(int val[],int weight[],int capacity){
        int n = val.length;
        int[][] dp = new int[val.length+1][capacity+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=weight[i-1]){
                    int incprofit = val[i-1] + dp[i-1][j-weight[i-1]];
                    int excprofit = dp[i-1][j];
                    dp[i][j] = Math.max(incprofit,excprofit);
                }else{
                    int excprofit = dp[i-1][j];
                    dp[i][j] = excprofit;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int capacity = 7;
        int dp[][] = new int[val.length+1][capacity+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        //System.out.println(maxProfit(val, wt, 7, wt.length));
        //System.out.println(maxProfit(val, wt, capacity,wt.length, dp));   
        System.out.println(maxprofit(val, wt, capacity));
    }
}
