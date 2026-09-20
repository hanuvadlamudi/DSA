public class Mcm {
    public static int algo(int[] a,int i,int j){
        if(i==j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int cost1 = algo(a, i, k);  // Ai...Ak => arr[i-1] x arr[k]
            int cost2 = algo(a, k+1, j); // Ak+1...Aj => arr[k+1] x arr[j]
            int cost3 = a[i-1] * a[k] * a[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;
    }

    public static void tabulation(int a){
        
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,3}; // for n size --- n-1 matrices are possible.
        int n = a.length;

        System.out.println(algo(a, 1, n-1));
    }
}
