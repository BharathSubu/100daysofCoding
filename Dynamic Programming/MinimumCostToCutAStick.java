//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
import java.util.*;
public class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int dp[][] = new int[cuts.length][cuts.length];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findMax(0, cuts.length -1,n, cuts,dp);
    }

    private int findMax(int i, int j,int n, int[] cuts, int[][] dp) {
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        int start = i-1 == -1 ? 0 : cuts[i-1];
        int end = j+1 == cuts.length ? n : cuts[j+1];

        for (int k = i; k <= j; k++) {
            int num =  end - start + findMax(i,k-1,n,cuts,dp) + findMax(k+1,j,n,cuts,dp);
            ans =  Math.min( ans , num);
        }
        return dp[i][j] = ans;
    }
    //tabulation
    public int tabulationMinCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length;
        int dp[][] = new int[len+1][len+1];
        for (int i = len-1; i >= 0 ; i--) {
            int start = i-1 == -1 ? 0 : cuts[i-1];
            for (int j = 0; j < len; j++) {
                if(i > j) continue;
                int ans = Integer.MAX_VALUE;
                int end = j + 1 == len ? n : cuts[j + 1];
                for (int k = i; k <= j; k++) {
                    int num = end - start ;
                    if(i<k-1) num+=dp[i][k - 1] ;
                    if(k+1<j) num+=dp[k + 1][j];
                    ans = Math.min(ans, num);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][len-1];
    }
}
