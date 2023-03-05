//https://leetcode.com/problems/coin-change-ii/submissions/
import java.util.Arrays;

public class CoinChangeII {

    long findWays(int i,int coins[] , int n , int sum , long [][] dp) {

        if(sum == 0) return 1;
        if(i == n - 1){
            if(sum%coins[i] == 0) return 1;
            return 0;
        }
        if(dp[i][sum] != -1) return dp[i][sum];
        dp[i][sum] = 0;
        int canTake = sum/coins[i];
        for (int j = 0; j <= canTake; j++) {
            dp[i][sum] += findWays(i+1,coins,n,(sum-(j*coins[i])),dp);
        }
        return dp[i][sum];
    }

    public long count(int coins[], int n, int sum) {
        long dp[][] = new long[n][sum+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findWays(0,coins,n,sum,dp);
    }

}
