public class UnboundedKnapsack {
    public static void algo(int val[],int wt[],int capacity){
        int n = val.length;

        int dp[][] = new int[n+1][capacity+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){                      
                if(j>=wt[i-1]){
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int capacity = 7;

        algo(val, wt, capacity); 

        //rod cutting same .
    }
}
