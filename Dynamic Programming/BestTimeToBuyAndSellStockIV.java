//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
import java.util.*;
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,-1)));
        return findMax(0,0,0,k,n,dp,prices);
    }
    private int findMax(int i, int j, int k,int t, int n, int[][][] dp, int[] prices) {
        if(k == t) return 0;
        if(i == n-1){
            if(j == 1) return prices[i];
            else return 0;
        }
        if(dp[i][j][k] != -1) return dp[i][j][k];
        if(j == 0){
            int case1 = findMax(i+1,1,k,t,n,dp,prices) - prices[i];
            int case2 = findMax(i+1,0,k,t,n,dp,prices);
            dp[i][j][k] = Math.max(case2,case1);
        }
        else {
            int case1 = prices[i] + findMax(i+1,0,k+1,t,n,dp,prices);
            int case2 = findMax(i+1,1,k,t,n,dp,prices);
            dp[i][j][k] = Math.max(case2,case1);
        }
        return dp[i][j][k];
    }
}
