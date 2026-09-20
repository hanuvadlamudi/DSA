public class Lcs {
    public static int algo(String s1,String s2,int m,int n){
        if(m==0 || n==0) {
            return 0;
        }

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return algo(s1, s2, m-1, n-1) + 1;
        }else{
            int ans1 = algo(s1, s2, m-1, n);
            int ans2 = algo(s1, s2, m, n-1);

            return Math.max(ans1, ans2);
        }
        
    }

    //Memoization

    public static int memo(String s1,String s2,int m,int n,int dp[][]){
        if( m==0 || n==0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] = memo(s1, s2, m-1, n-1, dp) + 1;
        }else{
            int ans1 = memo(s1, s2, m-1, n, dp);
            int ans2 = memo(s1, s2, m, n-1, dp);

            return dp[m][n] = Math.max(ans1, ans2);
        }
        
    }

    //Tabulation
    public static void table(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        System.out.println(dp[m][n]);
    }
    public static void main(String[] args) {
        String  str1 = "abcde";
        String str2 = "ace";

        // System.out.print(algo(str1, str2, str1.length(), str2.length()));

        int dp[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        // memo(str1, str2, str1.length(), str2.length(), dp);
        // System.out.println(dp[dp.length-1][dp[0].length-1]);
        
        table(str1, str2);
    }
}
