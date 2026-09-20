public class CoinChange {
    public static void algo(int coins[],int sum){

        int dp[][] = new int[coins.length+1][sum+1];

        for(int i=0;i<dp.length;i++){ // Zero rupees req with any coins 1 (Not giving is also)
            dp[i][0] = 1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        System.out.println(dp[dp.length-1][dp[0].length-1]);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int sum = 5;

        algo(coins, sum);
    }
}
