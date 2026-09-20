public class LCSubString {
    public static void algo(String s1,String s2){
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];
        int ans = 0;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
            

        }

        
        System.out.println(ans);
    }
    public static void main(String[] args) {
        String s2 = "ACBCF";
        String s1 = "ABCDAF";

        algo(s1, s2);

    }
}
