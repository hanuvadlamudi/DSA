public class MinPartitioning {
    public static void main(String[] args) {
        int a[] = {1,6,11,5};

        int sum = 0;

        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        
        int n = a.length;
        int w = sum /2;

        int dp[][] = new int[n+1][w+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(a[i-1] <= j){
                    dp[i][j] = Math.max(a[i-1]+dp[i-1][j-a[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][w];
        int sum2 = sum - sum1;

        System.out.println(Math.abs(sum1-sum2));
    }
}
