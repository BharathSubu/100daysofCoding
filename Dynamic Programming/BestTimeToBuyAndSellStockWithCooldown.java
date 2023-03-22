//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
import java.util.*;
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findMax(0,0,n,dp,prices);
    }

    private int findMax(int i, int j, int n, int[][] dp, int[] prices) {
        if(i == n-1){
            if(j == 1) return prices[i];
            else return 0;
        }
        if(i >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(j == 0){
            int case1 = findMax(i+1,1,n,dp,prices) - prices[i];
            int case2 = findMax(i+1,0,n,dp,prices);
            dp[i][j] = Math.max(case2,case1);
        }
        else {
            int case1 = prices[i] + findMax(i+2,0,n,dp,prices);
            int case2 = findMax(i+1,1,n,dp,prices);
            dp[i][j] = Math.max(case2,case1);
        }
        return dp[i][j];
    }
}
