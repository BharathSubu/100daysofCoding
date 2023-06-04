//https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1
import java.util.*;
public class ExpressAsSumOfPowerOfNaturalNumbers {
    static int mod = 1000000007;
    static int numOfWays(int n, int x)
    {
        int dp[][] = new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return findWays(1,n,n,x,dp);
    }

    static int findWays(int i, int j ,int n,int x , int [][] dp){
        if(j == 0) return 1;
        if(i == n+1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int notake = findWays(i+1,j,n,x,dp);
        int take = 0;
        if(j - (int)Math.pow(i,x) >= 0) take = findWays(i+1,j-(int)Math.pow(i,x),n,x,dp);
        // System.out.println(i+" "+j+" "+notake+" "+take);
        notake%=mod;
        take%=mod;
        long ans = notake+take;
        return dp[i][j] = (int)ans%mod;
    }
}
