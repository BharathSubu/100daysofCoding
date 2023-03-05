//https://leetcode.com/problems/coin-change/
import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long dp[][] = new long[n][amount+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findWays(0,coins,n,amount,dp);
    }

    private int findWays(int i, int[] coins, int n, int amount, long[][] dp) {
        if(amount == 0) return 0;
        if(i == n-1) {
            if(amount%coins[i] == 0) return amount/coins[i];
            return -1;
        }
        if(dp[i][amount] != -1) return (int)dp[i][amount];
        dp[i][amount] = Integer.MAX_VALUE;
        int canTake = amount/coins[i];
        for (int j = 0; j <= canTake; j++) {
            int count = findWays(i+1,coins,n,amount-(j*coins[i]),dp);
            if(count != -1)
            dp[i][amount] = Math.min(dp[i][amount] , j + count);
        }
        return (int) dp[i][amount];
    }
}
