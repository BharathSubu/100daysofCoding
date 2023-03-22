//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

import java.util.*;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    //memoization
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findMax(0,0,fee,n,dp,prices);
    }

    private int findMax(int i, int j, int fee, int n, int[][] dp, int[] prices) {
        if(i == n-1){
            if(j == 1) return prices[i];
            else return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(j == 0){
            int case1 = findMax(i+1,1,fee, n, dp,prices) - prices[i] - fee ;
            int case2 = findMax(i+1,0,fee, n, dp,prices);
            dp[i][j] = Math.max(case2,case1);
        }
        else {
            int case1 =  prices[i] + findMax(i+1,0,fee, n, dp,prices);
            int case2 = findMax(i+1,1,fee, n, dp,prices);
            dp[i][j] = Math.max(case2,case1);
        }
        return dp[i][j];
    }
    //tabulaiton
    public int tabulationMaxProfit(int[] prices, int fee) {
        int n = prices.length;
        long dp[][] = new long[n][2];
        dp[n-1][1] = prices[n-1];
        dp[n-1][0] = 0;
        for(int i = n-2 ; i >= 0 ;i--){
            for(int j = 0; j < 2 ; j++){
                if(j == 0){
                    long case1 = dp[i+1][1] - prices[i] - fee ;
                    long case2 = dp[i+1][0];
                    dp[i][j] = Math.max(case2,case1);
                }
                else {
                    long case1 =  prices[i] + dp[i+1][0];
                    long case2 = dp[i+1][1];
                    dp[i][j] = Math.max(case2,case1);
                }
            }
        }
        return (int)dp[0][0];
    }

    //spaceOptimizaiton
    public int spaceMaxProfit(int[] prices, int fee) {
        int n = prices.length;

        int prevc1 = prices[n-1];
        int prevc2 = 0;
        for(int i = n-2 ; i >= 0 ;i--){
            for(int j = 0; j < 2 ; j++){
                if(j == 0){
                    int case1 = prevc1 - prices[i] - fee ;
                    int case2 = prevc2;
                    prevc2 = Math.max(case2,case1);
                }
                else {
                    int case1 =  prices[i] + prevc2;
                    int case2 = prevc1;
                    prevc1 = Math.max(case2,case1);
                }
            }
        }
        return prevc2;
    }
}
