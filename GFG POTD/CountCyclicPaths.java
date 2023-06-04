//https://practice.geeksforgeeks.org/problems/aa0000a5f710ce8d41366b714341eef644ec7b82/1
import java.util.*;
public class CountCyclicPaths {
    public static int countPaths(int n){
        //vetices step to reach it
        long dp[][] = new long[4][n+1];
        int mod = (int)(1e9 + 7);
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[0][i] = (dp[1][i-1] + dp[2][i-1] + dp[3][i-1])%mod;
            dp[1][i] = (dp[0][i-1] + dp[2][i-1] + dp[3][i-1])%mod;
            dp[2][i] = (dp[1][i-1] + dp[0][i-1] + dp[3][i-1])%mod;
            dp[3][i] = (dp[1][i-1] + dp[2][i-1] + dp[0][i-1])%mod;
        }
        return (int)dp[0][n];
    }

    public static void main(String[] args) {
        System.out.println(countPaths(6));
    }
}
