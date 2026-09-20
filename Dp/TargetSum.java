public class TargetSum {
    public static void solution(int a[],int target){

        boolean[][] dp = new boolean[a.length+1][target+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(a[i-1]<=j && dp[i-1][j-a[i-1]]==true){
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }   
            }
           
        }
        System.out.println(dp[a.length][target]);
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int sum = 10;

        solution(arr, sum);
    }
}
